package com.jiujiu.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @ClassName DatabaseLoader
 * @AuThor yanbin.hu
 * @Date 1/17/2019
 * @Description
 **/
@Component
@Order(2)
public class DatabaseLoader implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("database loader...");
    }
}