package com.jiujiu.springboot.controller;

import com.jiujiu.springboot.model.Link;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HomeController
 * @AuThor yanbin.hu
 * @Date 1/18/2019
 * @Description
 **/
@RestController
public class HomeController {

    // Handler methods arguments
    // https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc-ann-methods

    @GetMapping("/")
    public String read(){
        return "hello world";
    }

    @PutMapping("/{id}")
    public void update(@PathVariable String id){
        System.out.println("updating id =" + id);
        // do update
    }

    @PostMapping("/")
    public void create(@RequestBody Link link){
        System.out.println("creating a link "+ link.toString());
        // do create
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        System.out.println("delete id = " + id);
        // do delete
    }


}