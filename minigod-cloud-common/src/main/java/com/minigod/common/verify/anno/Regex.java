package com.minigod.common.verify.anno;

import com.minigod.common.verify.anno.impl.VerifyRegex;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Regex {

	//验证规则
	public String regex();

	// 错误返回码
	public int code() default 0;

	// 错误描述
	public String message() default "验证不通过.";

	// 验证实现类
	public Class<?> clazz() default VerifyRegex.class;
}