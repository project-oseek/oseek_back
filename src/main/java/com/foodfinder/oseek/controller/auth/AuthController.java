package com.foodfinder.oseek.controller.auth;

import com.foodfinder.oseek.common.CommController;
import com.foodfinder.oseek.common.exception.BaseException;
import com.foodfinder.oseek.dto.auth.AuthReqDto;
import com.foodfinder.oseek.dto.auth.TokenInfo;
import com.foodfinder.oseek.dto.memberFoodKeyword.MemberFoodKeywordReqDto;
import com.foodfinder.oseek.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "auth", description = "인증 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController extends CommController {

    private final AuthService authService;

    @Operation(summary = "토큰 재발급", responses = { @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TokenInfo.class)))})
    @PostMapping("/regenerateToken")
    public ResponseEntity regenerateToken(@RequestBody AuthReqDto authReqDto) throws BaseException {
        return SuccessReturn(authService.regenerateToken(authReqDto));
    }

    @Operation(summary = "로그아웃", responses = { @ApiResponse(responseCode = "200")})
    @PostMapping("/logout")
    public ResponseEntity logout(@RequestBody AuthReqDto authReqDto) throws BaseException {
        authService.logout(authReqDto);
        return SuccessReturn();
    }

}
