package com.minigod.common.verify.anno;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.minigod.common.verify.anno.impl.VerifyEmail;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Email {
	// 错误返回码
	public int code() default 0;
	
	// 错误描述
	public String message() default "邮箱地址验证不通过.";
	
	// 验证实现类
	public Class<?> clazz() default VerifyEmail.class;
}
