package com.minigod.common.verify.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.minigod.common.verify.anno.impl.VerifyNumber;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Number {

	//最大值
	public long maxValue() default Long.MAX_VALUE;

	//最小值
	public long minValue() default Long.MIN_VALUE;

	// 错误返回码
	public int code() default 0;

	// 错误描述
	public String message() default "不是数字.";

	// 验证实现类
	public Class<?> clazz() default VerifyNumber.class;
}