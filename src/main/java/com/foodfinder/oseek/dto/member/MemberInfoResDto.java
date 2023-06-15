package com.foodfinder.oseek.dto.member;

import com.foodfinder.oseek.domain.member.Member;
import lombok.Getter;

@Getter
public class MemberInfoResDto {
    private Long memberId;
    private String nickname;
    private String email;
    private String location;
//    private List<String> keywords;

    public MemberInfoResDto(Member member){
        this.memberId = member.getMemberId();
        this.nickname = member.getNickname();
        this.email = member.getEmail();
        this.location = member.getLocation();
//        this.keywords = keywords;
    }
}
