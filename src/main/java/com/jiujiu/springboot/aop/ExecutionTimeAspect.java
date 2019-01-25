package com.jiujiu.springboot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName ExecutionTimeAspect
 * @AuThor yanbin.hu
 * @Date 1/24/2019
 * @Description
 **/
@Aspect
@Component
@Order(1) // Guarantees order of when Apspect are applied. This Aspect will applied firstly
public class ExecutionTimeAspect {

    private final static Logger logger = LoggerFactory.getLogger(ExecutionTimeAspect.class);

    // create pointcur for setter method
    @Pointcut("execution(* com.jiujiu.springboot.*..set*(..))")
    private void setter(){}


    // create pointcur for getter method
    @Pointcut("execution(* com.jiujiu.springboot.*..get*(..))")
    private void getter(){}


    @Before("getter() || setter()")
    public void beforeGetterAndSetter(JoinPoint jp){
        logger.info("{} {} is called", jp.getSignature().getDeclaringType().getSimpleName(), jp.getSignature().getName());
        // jp.getArgs(): get arguments passed to the method
        // jp.getTarget() : get the class

    }


    @Around("@annotation(org.springframework.web.bind.annotation.GetMapping) && execution(public * *(..))")
    public Object log(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .currentRequestAttributes())
                .getRequest();

        Object value;

        try {
            value = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throw throwable;
        } finally {
            logger.info(
                    "{} {} from {}",
                    request.getMethod(),
                    request.getRequestURI(),
                    request.getRemoteAddr(),
                    request.getHeader("user-id"));
        }

        return value;
    }

    @Around("@annotation(com.jiujiu.springboot.annotation.Timed) && execution(public * *(..)) ")
    public Object timed(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object value;

        try {
            value = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throw throwable;
        } finally {
            long duration = System.currentTimeMillis() - start;

            logger.info(
                    "{}.{} took {} ms",
                    proceedingJoinPoint.getSignature().getDeclaringType().getSimpleName(),
                    proceedingJoinPoint.getSignature().getName(),
                    duration);
        }

        return value;

    }

}