package com.jiujiu.springboot.config;

import com.jiujiu.springboot.security.AuditorAwareImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @ClassName JpaConfig
 * @AuThor yanbin.hu
 * @Date 1/17/2019
 * @Description
 **/
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class JpaConfig {

    @Bean
    public AuditorAware<String> auditorAware(){
        return new AuditorAwareImpl();
    }
}
