/**
 * @Title: GXLoginResponse.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.gateway.vo.resp.guoxin;

import java.io.Serializable;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-3-12 下午4:36:14
 * @version v1.0
 */

public class GXLoginVO implements Serializable{
	private static final long serialVersionUID = 1L;
	// 登录信息
	private Object loginInfo;

	public Object getLoginInfo() {
		return loginInfo;
	}

	public void setLoginInfo(Object loginInfo) {
		this.loginInfo = loginInfo;
	}

}
