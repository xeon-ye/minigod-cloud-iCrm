package com.minigod.api.vo;

import java.io.Serializable;

import com.minigod.protocol.StaticType;

/**
 * @Title: SNResponse.java
 * @Description: 
 * @Copyright:  2015 minigod
 * @Company: minigod
 *
 * @author ken
 * @date 2015-4-23 下午2:58:17
 * @version v1.0
 */

public class SNResponse implements Serializable {

	private static final long serialVersionUID = 4675414552962434446L;

	private Integer code = StaticType.CodeType.OK.getCode(); //返回的状态
	private String message; //返回的消息
	private Object result; //返回的结果

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
}
