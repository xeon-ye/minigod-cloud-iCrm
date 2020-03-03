package com.minigod.api.user.vo.params;

import com.minigod.api.user.vo.SNUserBase;

public class UserPhoneNum extends SNUserBase {

	private static final long serialVersionUID = -7335351861458828516L;
	
	private String newNum;//新的手机号
	private String captcha; //验证码,通过手机向服务端请求的验证码，用来验证手机拥有者是否为当前用户，有效期待定
	private Integer eventId;//事件ID
	private String pwd;
	private String key;

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

	public String getNewNum() {
		return newNum;
	}

	public void setNewNum(String newNum) {
		this.newNum = newNum;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}
}
