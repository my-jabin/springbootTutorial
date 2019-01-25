package com.jiujiu.springboot.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.NonNull;

/**
 * @ClassName ErrorResponse
 * @AuThor yanbin.hu
 * @Date 1/25/2019
 * @Description
 **/
@Data
public class ErrorResponse {
    @NonNull
    private HttpStatus status;
    @NonNull
    private String message;
}