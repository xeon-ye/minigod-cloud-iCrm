/**
 * @Title: MySummaryReqVo.java
 * @Copyright: © 2016 minigod
 * @Company: minigod
 */

package com.minigod.api.user.vo.request;

import java.io.Serializable;

/**
 * @description
 * 
 * @author kouyandong
 * @date 2016-1-20 下午2:58:45
 * @version v1.0
 */

public class TokenVO implements Serializable{
	private static final long serialVersionUID = -6163187304722218665L;

	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
