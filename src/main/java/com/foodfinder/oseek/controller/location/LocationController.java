package com.foodfinder.oseek.controller.location;

import com.foodfinder.oseek.common.CommController;
import com.foodfinder.oseek.common.exception.BaseException;
import com.foodfinder.oseek.dto.location.LocationResDto;
import com.foodfinder.oseek.service.LocationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@Tag(name = "location", description = "사용자 위치 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/location")
public class LocationController extends CommController {


    private final LocationService locationService;

    @Operation(summary = "사용자 위치 정보 조회", responses = { @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = LocationResDto.class)))})
    @GetMapping("/{longitude}/{latitude}")
    public ResponseEntity findMemberLocationDetail(@PathVariable Double latitude, @PathVariable Double longitude) throws BaseException, IOException {
        return SuccessReturn(locationService.findMemberLocationDetail(longitude, latitude));
    }
}
