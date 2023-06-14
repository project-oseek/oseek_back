package com.foodfinder.oseek.controller.member;

import com.foodfinder.oseek.common.CommController;
import com.foodfinder.oseek.dto.member.MemberInfoResDto;
import com.foodfinder.oseek.dto.member.MemberModifyReqDto;
import com.foodfinder.oseek.dto.notice.NoticeResDto;
import com.foodfinder.oseek.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

@Tag(name = "member", description = "맴버 정보 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController extends CommController {

    private final MemberService memberService;

    @Operation(summary = "맴버 정보 업데이트", description = "맴버 정보를 수정 합니다.", responses = {
            @ApiResponse(responseCode = "200", description = "맴버 정보 수정 성공",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = MemberModifyReqDto.class))))
    })
    @PutMapping()
    public ResponseEntity modifyMemberInfo(@AuthenticationPrincipal User user, @RequestBody MemberModifyReqDto reqDto){
        reqDto.setMemberId(Long.valueOf((user.getUsername())));
        return SuccessReturn(memberService.modifyMemberInfo(reqDto));
    }

    @Operation(summary = "맴버 정보 조회", description = "맴버 정보를 조회 합니다.", responses = {
            @ApiResponse(responseCode = "200", description = "맴버 정보 조 성공",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = MemberInfoResDto.class))))
    })
    @GetMapping("/info")
    public ResponseEntity findMemberInfo(@PathVariable Long memberId){
        return SuccessReturn(memberService.findMemberInfo(memberId));
    }




}
