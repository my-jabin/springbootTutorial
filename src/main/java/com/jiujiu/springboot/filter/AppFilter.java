package com.jiujiu.springboot.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName AppFilter
 * @AuThor yanbin.hu
 * @Date 1/22/2019
 * @Description
 **/
@Component
public class AppFilter implements Filter {

    private final static Logger logger = LoggerFactory.getLogger(AppFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        logger.info(
                "Logging Request  {} : {}",
                req.getMethod(),
                req.getRequestURI());

        chain.doFilter(request, response);
        logger.info(
                "Logging Response :{}",
                res.getContentType());
    }
}