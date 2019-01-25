package com.jiujiu.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName LinkExceptionHandler
 * @AuThor yanbin.hu
 * @Date 1/25/2019
 * @Description
 **/
@RestControllerAdvice
public class LinkExceptionHandler {

    @ExceptionHandler(value = LinkNotFoundException.class)
    public ErrorResponse exception(LinkNotFoundException exception) {
        return new ErrorResponse(HttpStatus.NOT_FOUND,exception.getMessage());
    }
}