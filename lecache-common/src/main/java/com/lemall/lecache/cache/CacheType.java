package com.lemall.lecache.cache;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** 
 * @Description:
 * @author Dimmacro
 * @Comany:LeEco
 * @Create time: 2016年9月21日下午6:05:57
 * 
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface CacheType {
    String type() default "";
}
