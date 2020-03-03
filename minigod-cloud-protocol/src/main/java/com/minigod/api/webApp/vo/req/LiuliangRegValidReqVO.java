/**
 * @Title: LiuliangRegValidReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.req;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-11-16 下午4:37:34
 * @version v1.0
 */

public class LiuliangRegValidReqVO extends AdBaseReqVO{
	private static final long serialVersionUID = 1L;
	
	private String phoneNum;
	private String pwd;
	private String nickName;
	private String captcha;
	private Integer eventId;
	
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
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
