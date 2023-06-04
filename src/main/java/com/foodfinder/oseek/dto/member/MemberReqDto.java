package com.foodfinder.oseek.dto.member;

import com.foodfinder.oseek.domain.member.Member;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberReqDto {

    @NotBlank
    private int memberId;

    @NotBlank
    private String nickname;

    @NotBlank
    private String email;

    @NotBlank
    private String address;

    public Member toEntity() {
        return Member.builder()
                .nickname(nickname)
                .email(email)
                .address(address)
                .build();
    }
}
