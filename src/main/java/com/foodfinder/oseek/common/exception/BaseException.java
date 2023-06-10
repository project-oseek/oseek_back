package com.foodfinder.oseek.common.exception;

import com.foodfinder.oseek.common.code.ApiCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BaseException extends Exception{
    private ApiCode status;
}
