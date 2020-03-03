/**
 * @Title: ESendStatus.java
 * @Copyright: © 2016 minigod
 * @Company: minigod
 */

package com.minigod.api.fnlprod;

/**
 * @description 卡券发送的状态
 * 
 * @author Jimmy
 * @date 2016-1-15 上午9:47:04
 * @version v1.0
 */

public enum ESendStatus {
	W, // 等待
	E, // 错误
	U, // 未知（或异常）
	S, // 成功
}
