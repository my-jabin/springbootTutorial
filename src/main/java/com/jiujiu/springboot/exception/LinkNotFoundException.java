package com.jiujiu.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @ClassName LinkNotFoundException
 * @AuThor yanbin.hu
 * @Date 1/25/2019
 * @Description
 **/
@ResponseStatus(HttpStatus.NOT_FOUND)
public class LinkNotFoundException extends RuntimeException{
    public LinkNotFoundException(String s) {
        super(s);
    }
}