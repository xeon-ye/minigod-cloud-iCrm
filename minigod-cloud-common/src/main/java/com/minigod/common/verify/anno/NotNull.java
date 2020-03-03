package com.minigod.common.verify.anno;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.minigod.common.verify.anno.impl.VerifyNull;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotNull {
	// 错误返回码
	public int code() default 0;
	
	// 错误描述
	public String message() default "为空.";
	
	// 验证实现类
	public Class<?> clazz() default VerifyNull.class;
}