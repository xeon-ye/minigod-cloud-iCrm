package com.sunline.modules.common.annotation;

import java.lang.annotation.*;

/**
 * @description: 请求日志注解类
 * @author: Larry Lai
 * @date: 2019/6/12 11:19
 * @version: v1.0
 */

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemLog {
    String description() default "";
}
