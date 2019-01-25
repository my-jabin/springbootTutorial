package com.jiujiu.springboot.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
 * @Description This Filter instance only applied for a certain URL, we define a FilterRegistrationBean in the  {@link com.jiujiu.springboot.MainApp} class
 **/
// without @component anotation
public class CertainFilter implements Filter {

    private final static Logger logger = LoggerFactory.getLogger(CertainFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        logger.info(
                "Certain Request  {} : {}",
                req.getMethod(),
                req.getRequestURI());

        chain.doFilter(request, response);
        logger.info(
                "Certain Response :{}",
                res.getContentType());
    }
}