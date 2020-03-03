package com.minigod.common.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Title: TransferBean.java
 * @Description: 需要加密的Class
 * @Copyright:  2016 minigod
 * @Company: minigod
 *
 * @author
 * @date 2015-4-8 上午10:33:12
 * @version v1.0
 */

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface TransferBean {
}
