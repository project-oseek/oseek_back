package com.foodfinder.oseek.service;

import com.foodfinder.oseek.common.code.ApiCode;
import com.foodfinder.oseek.common.exception.BaseException;
import com.foodfinder.oseek.dto.auth.AuthReqDto;
import com.foodfinder.oseek.dto.auth.TokenInfo;
import com.foodfinder.oseek.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class AuthService {

    @Autowired
    private final JwtTokenProvider jwtTokenProvider;

    private final RedisTemplate redisTemplate;


    public TokenInfo regenerateToken(AuthReqDto authReqDto) throws BaseException {

        // 1. Refresh Token 검증
        if (!jwtTokenProvider.validateToken(authReqDto.getRefreshToken())) {
            throw new BaseException(ApiCode.EXPIRED_REFRESH_TOKEN);
        }

        // 2. Access Token 에서 User email 을 가져옵니다.
        Authentication authentication = jwtTokenProvider.getAuthentication(authReqDto.getAccessToken());

        // 3. Redis 에서 User email 을 기반으로 저장된 Refresh Token 값을 가져옵니다.
        String refreshToken = (String)redisTemplate.opsForValue().get("RT:" + authentication.getName());

        // (추가) 로그아웃되어 Redis 에 RefreshToken 이 존재하지 않는 경우 처리
        if(ObjectUtils.isEmpty(refreshToken)) {
            throw new BaseException(ApiCode.EXPIRED_REFRESH_TOKEN);
        }

        if(!refreshToken.equals(authReqDto.getRefreshToken())) {
            throw new BaseException(ApiCode.INVALID_JWT);
        }

        // 4. 새로운 토큰 생성
        TokenInfo tokenInfo = jwtTokenProvider.generateToken(authentication.getName(), authentication.getAuthorities());

        // 5. RefreshToken Redis 업데이트
        redisTemplate.opsForValue()
                .set("RT:" + authentication.getName(), tokenInfo.getRefreshToken(), tokenInfo.getRefreshTokenExpirationTime(), TimeUnit.MILLISECONDS);

        return tokenInfo;
    }

    @Transactional
    public void logout(AuthReqDto authReqDto) throws BaseException {

        if (!jwtTokenProvider.validateToken(authReqDto.getAccessToken())) {
            throw new BaseException(ApiCode.INVALID_JWT);
        }

        Authentication authentication = jwtTokenProvider.getAuthentication(authReqDto.getAccessToken());

        if (redisTemplate.opsForValue().get("RT:" + authentication.getName()) != null) {
            // Refresh Token 삭제
            redisTemplate.delete("RT:" + authentication.getName());
        }

        Long expiration = jwtTokenProvider.getExpiration(authReqDto.getAccessToken());

        redisTemplate.opsForValue()
                .set(authReqDto.getAccessToken(), "logout", expiration, TimeUnit.MILLISECONDS);
    }

}
