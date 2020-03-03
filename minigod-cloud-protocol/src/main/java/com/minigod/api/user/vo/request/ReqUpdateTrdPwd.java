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

public class ReqUpdateTrdPwd extends SNUserBase {

	private static final long serialVersionUID = 1L;

	private String oldPwd;//用户旧密码
	private String newPwd;//用户新密码
	private String key;//解密码的key

	public String getOldPwd() {
		return oldPwd;
	}

	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
