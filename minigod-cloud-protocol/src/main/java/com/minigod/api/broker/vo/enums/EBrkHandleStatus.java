/**
 * @Title: EBrkSendStatus.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.broker.vo.enums;

/**
 * @description 请求处理状态
 *
 * @author 余俊斌
 * @date 2015年7月8日 上午9:33:54
 * @version v1.0
 */

public enum EBrkHandleStatus {

	/**
	 * 请求处理成功，有返回，并且返回正常
	 */
	S("请求处理成功"),
	/**
	 * 请求处理失败，有返回，并且返回失败
	 */
	F("请求处理失败"),
	/**
	 * 请求处理超时，无返回
	 */
	O("请求处理超时"),
	;
	
	private String desc;
	
	private EBrkHandleStatus(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}
}
