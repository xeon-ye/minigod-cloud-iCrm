package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNVersion;

/**
 * @Title: ReqCaptchaVO.java
 * @Description: 
 * @Copyright:  2015 minigod
 * @Company: minigod
 *
 * @author ken
 * @date 2015-4-18 上午10:06:26
 * @version v1.0
 */

public class ReqEmailCaptchaVO extends SNVersion {

	private static final long serialVersionUID = -5733114166711052682L;

	private ReqEmailCaptcha params;

	public ReqEmailCaptcha getParams() {
		return params;
	}

	public void setParams(ReqEmailCaptcha params) {
		this.params = params;
	}
}
