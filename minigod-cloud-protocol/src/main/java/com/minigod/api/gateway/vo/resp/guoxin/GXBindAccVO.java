/**
 * @Title: GXBindAccResponse.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.gateway.vo.resp.guoxin;

import java.io.Serializable;

/**
 * @description 绑定账号
 * 
 * @author Jimmy
 * @date 2015-3-12 上午10:42:32
 * @version v1.0
 */

public class GXBindAccVO implements Serializable {
	private static final long serialVersionUID = 1L;
	// 绑定状态
	private String bindStatus;
	// 登录信息
	private Object loginInfo;

	public String getBindStatus() {
		return bindStatus;
	}

	public void setBindStatus(String bindStatus) {
		this.bindStatus = bindStatus;
	}

	public Object getLoginInfo() {
		return loginInfo;
	}

	public void setLoginInfo(Object loginInfo) {
		this.loginInfo = loginInfo;
	}

}
