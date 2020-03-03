/**
 * @Title: TxtVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-9-25 下午3:28:18
 * @version v1.0
 */

public class TxtVO extends MsgBaseVO {
	private static final long serialVersionUID = 1L;
	private String msg; // 消息内容

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
