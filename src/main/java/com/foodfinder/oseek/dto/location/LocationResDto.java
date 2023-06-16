package com.foodfinder.oseek.dto.location;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "사용자 위치 정보 요청 DTO")
@Getter
@Setter
public class LocationResDto {

    @Schema(description = "경도")
    private Double longitude;

    @Schema(description = "위도")
    private Double latitude;

    @Schema(description = "시")
    private String region_1depth_name;

    @Schema(description = "구")
    private String region_2depth_name;

    @Schema(description = "동")
    private String region_3depth_name;

}
