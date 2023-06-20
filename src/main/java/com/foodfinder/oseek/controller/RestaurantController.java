package com.foodfinder.oseek.controller;

import com.foodfinder.oseek.common.CommController;
import com.foodfinder.oseek.dto.notice.NoticeResDto;
import com.foodfinder.oseek.dto.restaurant.RestaurantResDto;
import com.foodfinder.oseek.dto.restaurant.RestaurantSearchReqDto;
import com.foodfinder.oseek.service.RestaurantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "restaurant", description = "가게 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurant")
public class RestaurantController extends CommController {

    private final RestaurantService restaurantService;

    @Operation(summary = "가게 조회", description = "가게 list를 반환합니다.", responses = {
            @ApiResponse(responseCode = "200", description = "가게 list 조회 성공", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = RestaurantResDto.class))))
    })
    @GetMapping
    public ResponseEntity findRestaurant(@RequestBody(required = false) RestaurantSearchReqDto searchReqDto){
        return SuccessReturn();
    }
}
