/**
 * @Title: BaseResponse.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.gateway.vo.resp.guoxin;

import java.io.Serializable;

import com.minigod.protocol.StaticType;

/**
 * @description 国信的交易请求的响应内容
 * 
 * @author Jimmy
 * @date 2015-3-10 下午2:22:10
 * @version v1.0
 */

public class GXResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	// 返回码
	private Integer code = StaticType.CodeType.OK.getCode();
	// 返回信息
	private String message;
	// 结果
	private Object result;

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

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
}
