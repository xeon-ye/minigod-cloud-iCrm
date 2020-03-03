package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.user.vo.params.Captcha;

/** 
 * 验证码信息 
 */

public class CaptchaVO extends SNVersion {
	private static final long serialVersionUID = 1L;

	private Captcha params;

	public Captcha getParams() {
		return params;
	}

	public void setParams(Captcha params) {
		this.params = params;
	}
}
