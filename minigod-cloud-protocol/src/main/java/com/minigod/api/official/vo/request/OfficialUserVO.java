/**
 * @Title: OfficialUserVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.official.vo.request;

import com.minigod.api.vo.BaseVO;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-12-21 下午12:05:37
 * @version v1.0
 */

public class OfficialUserVO extends BaseVO{
	private static final long serialVersionUID = 1L;
	
	private String certType;//凭证类型手机0
	private String certCode;//certType=0对应的是手机号
	private String pwd;		//密码
	private String nickname;//昵称
	private String eventId;//事件ID，获取验证码成功后传给前端
	private String captcha;//验证码
	private String  newPwd;//找回密码，新的密码
	private String  phoneNum;//号码
	private String areaCode;//区号

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getCertType() {
		return certType;
	}
	public void setCertType(String certType) {
		this.certType = certType;
	}
	public String getCertCode() {
		return certCode;
	}
	public void setCertCode(String certCode) {
		this.certCode = certCode;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public String getCaptcha() {
		return captcha;
	}
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	public String getNewPwd() {
		return newPwd;
	}
	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

}
