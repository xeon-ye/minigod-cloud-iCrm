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

public class ReqUserPwd extends SNUserBase {

	private static final long serialVersionUID = 1L;

	private Integer eventId;//事件ID
	private String key;//解密码的key
	private String pwd;//用户密码
	private String phoneNum;//手机
	private String email;
	private String captcha;
	private String JFGroupUser;

	public String getJFGroupUser() {
		return JFGroupUser;
	}

	public void setJFGroupUser(String JFGroupUser) {
		this.JFGroupUser = JFGroupUser;
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

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
}
