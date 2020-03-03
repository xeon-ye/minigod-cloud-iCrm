package com.minigod.common.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Title: Emoji.java
 * @Description: 
 * @Copyright:  2016 minigod
 * @Company: minigod
 *
 * @author
 * @date 2015-6-23 下午3:16:11
 * @version v1.0
 */

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Emoji {
	
}

