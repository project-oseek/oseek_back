package com.foodfinder.oseek.dto.memberFoodKeyword;

import com.foodfinder.oseek.domain.memberFoodKeyword.MemberFoodKeyword;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Schema(description = "음식 키워드 정보 조회 DTO")
@Getter
public class MemberFoodKeyWordResDto {

    @Schema(description = "음식 키워드", nullable = false, example = "fineView")
    private String foodKeyword;

    public MemberFoodKeyWordResDto(MemberFoodKeyword entity){
        this.foodKeyword = entity.getFoodKeyword();
    }

}
