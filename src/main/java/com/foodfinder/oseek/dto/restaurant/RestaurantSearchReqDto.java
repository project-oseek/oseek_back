package com.foodfinder.oseek.dto.restaurant;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.util.List;

@Schema(description = "음식점 조건 필터Dto")
@Getter
public class RestaurantSearchReqDto {

    @Schema(description = "경도")
    private String longitude;

    @Schema(description = "위도")
    private String latitude;

    @Schema(description = "지역", example = "제주 제주시 도담동")
    private String region;

    @Schema(description = "음식 취향 list")
    private List<String> foodKeywords;

    @Schema(description = "음식점 분류", nullable = true)
    private String category;

    @Schema(description = "정렬 기준", example = "star")
    private String sortStandard;
}
