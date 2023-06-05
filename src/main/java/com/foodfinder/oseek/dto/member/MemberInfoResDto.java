package com.foodfinder.oseek.dto.member;

import com.foodfinder.oseek.domain.member.Member;
import lombok.Getter;

@Getter
public class MemberInfoResDto {
    private Long memberId;
    private String nickname;
    private String email;
    private String address;
//    private List<String> favoriteTypes;
//    private List<String> keywords;

    public MemberInfoResDto(Member member){
        this.memberId = member.getMemberId();
        this.nickname = member.getNickname();
        this.email = member.getEmail();
        this.address = member.getAddress();
//        this.favoriteTypes = favoriteTypes;
//        this.keywords = keywords;
    }
}
