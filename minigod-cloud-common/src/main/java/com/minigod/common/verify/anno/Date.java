package com.minigod.common.verify.anno;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.minigod.common.verify.anno.impl.VerifyDate;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Date {
	
	public String format() default "yyyy-MM-dd HH:mm:ss";
	
	// 错误返回码
	public int code() default 0;
	
	// 错误描述
	public String message() default "日期检查异常.";
	
	// 验证实现类
	public Class<?> clazz() default VerifyDate.class;
}