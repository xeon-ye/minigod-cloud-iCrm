package com.minigod.api.user.vo.request;

import java.io.Serializable;

/**
 * @Title: ReqCaptcha.java
 * @Description: 
 * @Copyright:  2015 minigod
 * @Company: minigod
 *
 * @author ken
 * @date 2015-4-18 上午10:09:43
 * @version v1.0
 */

public class ReqEmailCaptcha implements Serializable {

	private static final long serialVersionUID = -8965110224611211599L;
	private Integer userId;
	private String email; //邮箱
	private String captcha;//验证码

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
