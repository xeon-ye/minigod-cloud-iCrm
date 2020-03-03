package com.minigod.api.user.vo.request.adviser;

import java.io.Serializable;

import com.minigod.api.user.vo.SNUserBase;

/**
 * @Title: WeiXinCheckVO.java
 * @Description: 
 * @Copyright:  2015 minigod
 * @Company: minigod
 *
 * @author ken
 * @date 2015-7-13 下午4:58:21
 * @version v1.0
 */

public class WeiXinCheck extends SNUserBase implements Serializable {

	private static final long serialVersionUID = 2406842815060417640L;

	private String token;//微信的token
	private String openCode;//微信的code

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getOpenCode() {
		return openCode;
	}

	public void setOpenCode(String openCode) {
		this.openCode = openCode;
	}
}
