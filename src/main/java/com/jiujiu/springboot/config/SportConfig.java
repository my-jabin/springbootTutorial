package com.jiujiu.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @ClassName SportConfig
 * @AuThor yanbin.hu
 * @Date 1/23/2019
 * @Description
 **/
@Configuration
@PropertySource("classpath:sport.properties")
public class SportConfig {
}