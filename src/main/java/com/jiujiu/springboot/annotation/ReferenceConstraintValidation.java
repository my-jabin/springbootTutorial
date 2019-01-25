package com.jiujiu.springboot.annotation;

import java.lang.annotation.Annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @ClassName ReferenceConstraintValidation
 * @AuThor yanbin.hu
 * @Date 1/24/2019
 * @Description
 **/
public class ReferenceConstraintValidation implements ConstraintValidator<StartWith,String> {

    private String[] prefix;

    @Override
    public void initialize(StartWith annotation) {
        prefix = annotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        boolean result = false;
        if(value != null){
            for(String pre : prefix){
                result = value.startsWith(pre);
                if(result) break;
            }
        }else{
            return true;
        }
        return result;
    }
}