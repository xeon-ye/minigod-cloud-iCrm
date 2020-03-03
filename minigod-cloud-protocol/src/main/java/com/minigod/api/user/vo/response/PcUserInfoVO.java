package com.minigod.api.user.vo.response;

import com.minigod.api.grm.fc.vo.resp.EF07000001VO;

import java.io.Serializable;
import java.util.Date;

public class PcUserInfoVO implements Serializable {

	private static final long serialVersionUID = -5232267923290668354L;

	private Long userId;
	private String sessionId;//推荐人ID,邀请该用户的用户ID
	private String userIcon;
	private String nickname;
	private Integer gender;
	
	private String trdAccount;
	private EF07000001VO ef07000001VO; //行情信息
	private String phoneNum;// 手机号
	private String email;
	
	private Integer uType;
	private String imId;

	private Date lastLoginTime;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getUserIcon() {
		return userIcon;
	}

	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getTrdAccount() {
		return trdAccount;
	}

	public void setTrdAccount(String trdAccount) {
		this.trdAccount = trdAccount;
	}

	public EF07000001VO getEf07000001VO() {
		return ef07000001VO;
	}

	public void setEf07000001VO(EF07000001VO ef07000001vo) {
		ef07000001VO = ef07000001vo;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getuType() {
		return uType;
	}

	public void setuType(Integer uType) {
		this.uType = uType;
	}

	public String getImId() {
		return imId;
	}

	public void setImId(String imId) {
		this.imId = imId;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	
}
