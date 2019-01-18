package com.jiujiu.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName LinkController
 * @AuThor yanbin.hu
 * @Date 1/18/2019
 * @Description
 **/
@RestController
@RequestMapping("/link")
public class LinkController {

    @GetMapping
    public String read(){
        return "hello links";
    }
}