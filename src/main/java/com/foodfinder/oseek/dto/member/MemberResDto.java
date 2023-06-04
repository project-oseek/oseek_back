package com.foodfinder.oseek.dto.member;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class MemberResDto {

    private String nickname;
    private String email;
    private String address;
}
