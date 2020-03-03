package com.minigod.api.user.vo.request;

import java.io.Serializable;

/**
 * @Title: ReqAddFriendVO.java
 * @Description: 
 * @Copyright:  2015 minigod
 * @Company: minigod
 *
 * @author panlz
 * @date 2015-9-2 下午5:07:05
 * @version v1.0
 */

public class ReqAddFriendVO implements Serializable {

	private static final long serialVersionUID = -2262980172948367617L;
	
	private String cId ;//和前端约定好的cId
	private String sId ;//SessionID
	private String userId;//用户id
	private String  phoneNum;//手机号
	private String pwd;		//密码
	private String nickname;//昵称
	private String eventId;//事件ID，获取验证码成功后传给前端
	public String getcId() {
		return cId;
	}
	public void setcId(String cId) {
		this.cId = cId;
	}
	public String getsId() {
		return sId;
	}
	public void setsId(String sId) {
		this.sId = sId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
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
	
}
