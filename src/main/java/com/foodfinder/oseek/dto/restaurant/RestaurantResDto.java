package com.foodfinder.oseek.dto.restaurant;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.util.List;

@Schema(description = "음식점 응답Dto")
@Getter
public class RestaurantResDto {
    @Schema(description = "음식점 id")
    private Long restaurantId;

    @Schema(description = "가게 이름")
    private String restaurantName;

    @Schema(description = "음식점 분류")
    private String category;

    @Schema(description = "별점")
    private double star;

    @Schema(description = "운영여부", example = "운영 중")
    private String isOpen;

    @Schema(description = "위치로부터의 거리", example = "10m")
    private String distance;

    @Schema(description = "평균 가격", example = "평균 10,000원")
    private String price;

    @Schema(description = "메뉴들")
    private List<String> menu;

    @Schema(description = "저장 여부, true = 저장")
    private boolean isHeart;

    @Schema(description = "이미지 경로")
    private String image;
}
