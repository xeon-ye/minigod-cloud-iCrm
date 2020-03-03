/**
 * @Title: ETarPayStatus.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.enums;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-11-5 下午1:28:45
 * @version v1.0
 */

public enum ETarPayStatus {
	W, // 等待转账
	E, // 转账超时
	F, // 转账失败（有明确的错误原因）
	S, // 转账已成功
}
