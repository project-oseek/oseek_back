package com.foodfinder.oseek.controller.member;


import com.foodfinder.oseek.common.CommController;
import com.foodfinder.oseek.dto.notice.NoticeResDto;
import com.foodfinder.oseek.service.NoticeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "notice", description = "공지사항 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/notice")
public class NoticeController extends CommController {

    private final NoticeService noticeService;

@Operation(summary = "공지사항 조회", description = "공지사항 list를 반환합니다.", responses = {
        @ApiResponse(responseCode = "200", description = "공지사항 조회 성공", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = NoticeResDto.class))))
})
    @GetMapping
    public ResponseEntity findNotices(){
        return SuccessReturn(noticeService.getNotices());
    }
}
