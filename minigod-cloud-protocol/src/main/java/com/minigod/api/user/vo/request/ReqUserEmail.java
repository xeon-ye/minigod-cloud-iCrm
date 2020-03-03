package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNUserBase;

/**
 * @Title: ReqUserPwd.java
 * @Description: 
 * @Copyright:  2015 minigod
 * @Company: minigod
 *
 * @author ken
 * @date 2015-4-16 下午2:57:53
 * @version v1.0
 */

public class ReqUserEmail extends SNUserBase {

	private static final long serialVersionUID = 1L;

	private String email;//email

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
