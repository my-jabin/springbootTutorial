package com.jiujiu.springboot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @ClassName SecurityConfiguration
 * @AuThor yanbin.hu
 * @Date 1/18/2019
 * @Description
 **/
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // HttpSecurity doc:
        //https://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/#jc-httpsecurity
        http.authorizeRequests()
                // allow all user(all role) to access the "/" page
                .antMatchers("/").permitAll()
                // user of role "ADMIN" allowed to access this page
                .antMatchers("/link").hasRole("ADMIN")
                // any request needs to be authenticated
                .anyRequest().authenticated()
                .and()
                // all user must log in
                .formLogin();
//                .and()
//                .httpBasic();
    }


    @Autowired      // here is configuration related to spring boot basic authentication
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()                 // for inMemory Authentication
                // {noop} means: we use NoOpPasswordEncoder to encode password = plain text
                .withUser("admin").password("{noop}admin").roles("ADMIN")
                .and()
                .withUser("hyb").password("{noop}hyb").roles("USER");
    }
}