 package com.hhq.test.annotation.customannotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.stereotype.Service;

@Documented
@Service
@Inherited
@Retention(RUNTIME)
@Target(TYPE)
/**
 * @author Kevin He
 * @date 2018/05/16
 * @version 1.0.0
 */
public @interface VerifyService {
    
    String description() default "";
    
    String verifyType();
}
