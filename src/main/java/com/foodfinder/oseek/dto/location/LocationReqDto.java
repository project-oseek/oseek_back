package com.foodfinder.oseek.dto.location;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "사용자 위치 정보 요청 DTO")
@Getter
@Setter
public class LocationReqDto {

    @Schema(description = "경도")
    private String longitude;

    @Schema(description = "위도")
    private String latitude;
}
