package com.foodfinder.oseek.dto.memberFoodKeyword;

import com.foodfinder.oseek.domain.memberFoodKeyword.MemberFoodKeyword;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "음식 키워드 정보 수정 요청 DTO")
@Getter
@Setter
public class MemberFoodKeywordReqDto {
    @NotNull
    @Schema(description = "맴버 키", hidden = true)
    private Long memberId;
    @Schema(description = "음식 키워드", nullable = false, example = "fineView")
    private String foodKeyword;

    public MemberFoodKeyword toEntity() {
        return MemberFoodKeyword.builder()
                .memberId(memberId)
                .foodKeyword(foodKeyword)
                .build();
    }
}
