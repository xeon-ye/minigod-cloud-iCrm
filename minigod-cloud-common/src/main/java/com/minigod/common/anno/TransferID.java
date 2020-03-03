package com.minigod.common.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Title: ID.java
 * @Description: ID转码
 * @Copyright:  2016 minigod
 * @Company: minigod
 *
 * @author
 * @date 2015-4-8 上午10:30:17
 * @version v1.0
 */

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface TransferID {
	int key() default -1;
}
