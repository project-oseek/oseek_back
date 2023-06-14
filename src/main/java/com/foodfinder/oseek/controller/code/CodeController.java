package com.foodfinder.oseek.controller.code;

import com.foodfinder.oseek.common.CommController;
import com.foodfinder.oseek.dto.code.CodeResDto;
import com.foodfinder.oseek.service.CodeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/code")
public class CodeController extends CommController {

    @Autowired
    private CodeService codeService;

    @Operation(summary = "코드 조회", description = "특정한 코드 그룹에 속한 코드 list를 반환합니다.",
               responses = {@ApiResponse(responseCode = "200", description = "코드 조회 성공", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = CodeResDto.class))))
    })
    @GetMapping("/{codeGroup}")
    public ResponseEntity findCodes(@PathVariable String codeGroup){
        return SuccessReturn(codeService.findCodes(codeGroup));
    }

}
