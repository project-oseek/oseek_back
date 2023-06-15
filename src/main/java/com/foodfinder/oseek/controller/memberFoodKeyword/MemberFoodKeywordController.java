package com.foodfinder.oseek.controller.memberFoodKeyword;

import com.foodfinder.oseek.common.CommController;
import com.foodfinder.oseek.dto.memberFoodKeyword.MemberFoodKeywordReqDto;
import com.foodfinder.oseek.service.MemberFoodKeywordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "memberFoodKeyword", description = "음식 키워드 정보 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/memberfoodkeyword")
public class MemberFoodKeywordController extends CommController {

    private final MemberFoodKeywordService memberFoodKeywordService;

    @Operation(summary = "맴버 음식 키워드 저장", description = "맴버의 음식 키워드를 저정합니다.", responses = {
            @ApiResponse(responseCode = "200", description = "맴버 정보 수정 성공",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = MemberFoodKeywordReqDto.class))))
    })
    @PostMapping()
    public ResponseEntity saveMemberFoodKeyword(@AuthenticationPrincipal User user, @RequestBody List<MemberFoodKeywordReqDto> reqDtoList){
        Long memberId = Long.valueOf((user.getUsername()));
        return SuccessReturn(memberFoodKeywordService.saveMemberFoodKeyword(memberId, reqDtoList));
    }
}
