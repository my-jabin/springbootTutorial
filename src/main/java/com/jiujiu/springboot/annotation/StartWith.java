package com.jiujiu.springboot.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @ClassName StartWith
 * @AuThor yanbin.hu
 * @Date 1/24/2019
 * @Description
 **/
@Constraint(validatedBy = ReferenceConstraintValidation.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface StartWith {

     String[] value() default {"http","https"};

     String message() default "must start with http or https";

    // define default groups
     Class<?>[] groups() default {};

    // define default payloads
     Class<? extends Payload>[] payload() default {};
}
