package com.minigod.api.user.vo.request.adviser;

import java.io.Serializable;

import com.minigod.api.user.vo.SNUserBase;

/**
 * @Title: AdviserVerifyVO.java
 * @Description: 
 * @Copyright:  2015 minigod
 * @Company: minigod
 *
 * @author ken
 * @date 2015-7-13 下午5:31:56
 * @version v1.0
 */

public class ReqAdviserVerifyVO extends SNUserBase implements Serializable {

	private static final long serialVersionUID = 2406842815060417640L;

	private AdviserVerify params;

	public AdviserVerify getParams() {
		return params;
	}

	public void setParams(AdviserVerify params) {
		this.params = params;
	}
}
