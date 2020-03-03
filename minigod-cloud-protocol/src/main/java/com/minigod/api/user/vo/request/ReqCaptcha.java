package com.minigod.api.user.vo.request;

import java.io.Serializable;

import com.minigod.api.vo.BaseVO;

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

public class ReqCaptcha extends BaseVO implements Serializable {

	private static final long serialVersionUID = -8965110224611211599L;

	private String phoneNum; //手机号

	private Integer evenId;//验证码

	private String captcha;//验证码
	
	private String redeemCode;
	
	private int tempCode = 0;

	public int getTempCode() {
		return tempCode;
	}

	public void setTempCode(int tempCode) {
		this.tempCode = tempCode;
	}

	public String getRedeemCode() {
		return redeemCode;
	}

	public void setRedeemCode(String redeemCode) {
		this.redeemCode = redeemCode;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public Integer getEvenId() {
		return evenId;
	}

	public void setEvenId(Integer evenId) {
		this.evenId = evenId;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
}
