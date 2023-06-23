package com.foodfinder.oseek.oauth2;

import com.foodfinder.oseek.domain.member.Member;
import com.foodfinder.oseek.enums.AuthProvider;
import com.foodfinder.oseek.enums.Role;
import com.foodfinder.oseek.oauth2.OAuth2UserInfo;
import com.foodfinder.oseek.oauth2.OAuth2UserInfoFactory;
import com.foodfinder.oseek.oauth2.UserPrincipal;
import com.foodfinder.oseek.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final MemberRepository memberRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException {
        OAuth2UserService oAuth2UserService = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = oAuth2UserService.loadUser(oAuth2UserRequest);

        return processOAuth2User(oAuth2UserRequest, oAuth2User);
    }

    protected OAuth2User processOAuth2User(OAuth2UserRequest oAuth2UserRequest, OAuth2User oAuth2User) {
        //OAuth2 로그인 플랫폼 구분
        AuthProvider authProvider = AuthProvider.valueOf(oAuth2UserRequest.getClientRegistration().getRegistrationId().toUpperCase());
        OAuth2UserInfo oAuth2UserInfo = OAuth2UserInfoFactory.getOAuth2UserInfo(authProvider, oAuth2User.getAttributes());

        if (!StringUtils.hasText(oAuth2UserInfo.getEmail())) {
            throw new RuntimeException("Email not found from OAuth2 provider");
        }


        Member member = memberRepository.findByEmail(oAuth2UserInfo.getEmail()).orElse(null);
        //이미 가입된 경우
        if (member != null) {
            if (!member.getAuthProvider().equals(authProvider)) {
                throw new RuntimeException("Email already signed up.");
            }
//            member = updateUser(member, oAuth2UserInfo);
            member.modifyIsFirstLogin("0");
            memberRepository.save(member);
        }
        //가입되지 않은 경우
        else {
            member = registerUser(authProvider, oAuth2UserInfo);
        }

        return UserPrincipal.create(member, oAuth2UserInfo.getAttributes());
    }

    private Member registerUser(AuthProvider authProvider, OAuth2UserInfo oAuth2UserInfo) {
        Member member = Member.builder()
                .email(oAuth2UserInfo.getEmail())
//                .oauth2Id(oAuth2UserInfo.getOAuth2Id())
                .authProvider(authProvider)
                .role(Role.ROLE_USER)
                .isFirstLogin("1")
                .build();

        return memberRepository.save(member);
    }

//    private Member updateUser(Member user, OAuth2UserInfo oAuth2UserInfo) {
//        return memberRepository.save(Member.update(oAuth2UserInfo));
//    }
}
