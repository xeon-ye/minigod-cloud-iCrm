
/*******************************************************************************
 * Copyright (c) 2016 minigod.Co.Ltd. All rights reserved.
 ******************************************************************************/

package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNUserBase;

/**
 * @description
 * 
 * @author kouyandong
 * @date 2016-1-20 下午2:58:45
 * @version v1.0
 */

public class TrdPwdVO extends SNUserBase {
	private static final long serialVersionUID = -6163187304722218665L;
	private String pwd;
	private String key; //解密码的KEY

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}


	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
