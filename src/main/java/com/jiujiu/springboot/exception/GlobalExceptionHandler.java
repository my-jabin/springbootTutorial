package com.jiujiu.springboot.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName GlobalExceptionHandler
 * @AuThor yanbin.hu
 * @Date 1/25/2019
 * @Description
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger("GlobalExceptionHandler");

    @ExceptionHandler(Exception.class)
    public ErrorResponse handleGlobalException(Exception e){
        logger.info("catch an exception with message: " + e.getMessage());
        return new ErrorResponse(HttpStatus.BAD_REQUEST,e.getMessage());
    }
}