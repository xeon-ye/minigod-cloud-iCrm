/**
 * @Title: RespAskValidVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.adviser.vo.response;

import java.io.Serializable;

/**
 * @description
 * 
 * @author panlz
 * @date 2015-12-16 下午5:49:49
 * @version v1.0
 */

public class RespAskValidVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer msgType; // 1夜间时段类型
	private String successMsg;

	public Integer getMsgType() {
		return msgType;
	}

	public void setMsgType(Integer msgType) {
		this.msgType = msgType;
	}

	public String getSuccessMsg() {
		return successMsg;
	}

	public void setSuccessMsg(String successMsg) {
		this.successMsg = successMsg;
	}

}
