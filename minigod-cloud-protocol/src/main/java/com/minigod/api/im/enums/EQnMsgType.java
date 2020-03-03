/**
 * @Title: QnMsgType.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.enums;

/**
 * @description 
 *
 * @author Jimmy
 * @date 2015-8-24 下午8:17:13
 * @version v1.0
 */

public enum EQnMsgType {
	PLAIN_TEXT(0),
	DISPLAY_DIRECT(3); // 文本消息--普通类型消息通知，客户端直接特殊展示
	
	private int code;
	
	EQnMsgType(int iCode) {
		code = iCode;
	}

	public int getCode() {
		return code;
	}
}
