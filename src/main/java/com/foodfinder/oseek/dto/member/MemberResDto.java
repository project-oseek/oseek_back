package com.foodfinder.oseek.dto.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class MemberResDto {

    private String nickname;
    private String email;
    private String address;

    @Builder
    @Getter
    @AllArgsConstructor
    public static class TokenInfo {
        private String grantType;
        private String accessToken;
        private Long accessTokenExpirationTime;
        private String refreshToken;
        private Long refreshTokenExpirationTime;
    }

}
