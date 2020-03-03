package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNVersion;

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

public class ReqUserEmailVO extends SNVersion {

	private static final long serialVersionUID = 1L;

	private ReqUserEmail  params;

	public ReqUserEmail getParams() {
		return params;
	}

	public void setParams(ReqUserEmail params) {
		this.params = params;
	}	
}
