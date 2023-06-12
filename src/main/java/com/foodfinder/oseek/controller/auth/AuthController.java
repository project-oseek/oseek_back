package com.foodfinder.oseek.controller.auth;

import com.foodfinder.oseek.common.CommController;
import com.foodfinder.oseek.common.exception.BaseException;
import com.foodfinder.oseek.dto.auth.AuthReqDto;
import com.foodfinder.oseek.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController extends CommController {

    @Autowired
    private AuthService authService;

    @PostMapping("/regenerateToken")
    public ResponseEntity regenerateToken(@RequestBody AuthReqDto authReqDto) throws BaseException {
        return SuccessReturn(authService.regenerateToken(authReqDto));
    }

    @PostMapping("/logout")
    public ResponseEntity logout(@RequestBody AuthReqDto authReqDto) throws BaseException {
        authService.logout(authReqDto);
        return SuccessReturn();
    }

}
