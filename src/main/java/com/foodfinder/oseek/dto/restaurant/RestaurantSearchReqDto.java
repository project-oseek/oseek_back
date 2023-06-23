package com.foodfinder.oseek.dto.restaurant;

import com.foodfinder.oseek.domain.restaurant.Sort;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.util.List;

@Schema(description = "음식점 조건 필터Dto")
@Getter
public class RestaurantSearchReqDto {

    @Schema(description = "경도")
    private double longitude;

    @Schema(description = "위도")
    private double latitude;

    @Schema(description = "지역", example = "제주 제주시 도담동")
    private String region;

    @Schema(description = "음식 취향 list, code/food_keyword", nullable = true)
    private List<String> memberFoodKeywords;

    @Schema(description = "음식점 분류(KOREAN, JAPANESE, CHINESE...)", nullable = true)
    private String category;

    @Schema(description = "정렬 기준(DISTANCE(거리순), NAME(이름순), RATE(별점순))", example = "star", defaultValue = "DISTANCE")
    private Sort sortStandard;
}
