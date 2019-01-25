package com.jiujiu.springboot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @ClassName SecurityConfiguration
 * @AuThor yanbin.hu
 * @Date 1/18/2019
 * @Description
 **/
@Configuration
@EnableWebSecurity
//it's to swtich off the default web application security configuration and add your own
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private UserDetailsServiceImpl userDetailsService;


    public SecurityConfiguration(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // HttpSecurity doc:
        //https://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/#jc-httpsecurity
        http.authorizeRequests()
                // any request end with "info" are allowed
                .requestMatchers(EndpointRequest.to("info")).permitAll()
                // allow all user(all role) to access the "/" page
                .antMatchers("/").permitAll()
                // user of role "ADMIN" allowed to access this page
//                .antMatchers("/link").hasRole("ADMIN")
                .antMatchers("/link/**").permitAll()
                // allow all to asscee h2-console path
                .antMatchers("/h2-console/**").permitAll()
                // any request needs to be authenticated
                .anyRequest().authenticated()
                .and()
                // all user must log in
                .formLogin()
//                    .loginPage("/showMyLoginForm") // the custom login page could be value of the login page path or to path to a controller. e.g. /login.html or /showMyLoginForm
//                .loginProcessingUrl("/anthenticateUser") // specify the authentication processing url. It must match the url in the submit form with POST request
                .permitAll()
                .and()
                .logout().permitAll().and()
//                   custom access denied pages
//                  .exceptionHandling()
//                  .accessDeniedPage("/accessDeniedPage")
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .httpBasic();

    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Autowired      // here is configuration related to spring boot basic authentication
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {


//        auth.inMemoryAuthentication()                 // for inMemory Authentication
//                // {noop} means: we use NoOpPasswordEncoder to encode password = plain text
//                .withUser("admin").password("{noop}admin").roles("ADMIN")
//                .and()
//                .withUser("hyb@gmail.com").password("{noop}hyb").roles("USER");

        //        it’s recommended to stick with the default encoders provided in PasswordEncoderFactories.
//        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//        auth.inMemoryAuthentication()                 // for inMemory Authentication
//                // {noop} means: we use NoOpPasswordEncoder to encode password = plain text
//                .withUser("admin").password(encoder.encode("admin")).roles("ADMIN")
//                .and()
//                .withUser("hyb").password(encoder.encode("hyb")).roles("USER");
    }
}