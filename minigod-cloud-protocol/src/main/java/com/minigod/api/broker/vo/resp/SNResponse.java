/**
 * @Title: QNBaseResponse.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.broker.vo.resp;

import java.io.Serializable;

import com.minigod.protocol.StaticType;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-3-9 下午8:36:57
 * @version v1.0
 */

public class SNResponse<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	// 返回码
	private Integer code = StaticType.CodeType.OK.getCode();
	// 券商端返回码
	private Integer orgCode;
	// 返回信息
	private String message;
	// 具体参数类
	private T result;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Integer getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(Integer orgCode) {
		this.orgCode = orgCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

}
