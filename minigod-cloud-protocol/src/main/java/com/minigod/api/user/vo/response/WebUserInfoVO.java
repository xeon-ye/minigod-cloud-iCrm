/*
 * FileName: PtfFollowerRspVO.java
 * Copyright: Copyright 2014-12-5 MiniGod Tech. Co. Ltd.All right reserved.
 * Description: 
 *
 */
package com.minigod.api.user.vo.response;

import com.minigod.api.grm.fc.vo.resp.EF07000001VO;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

import java.io.Serializable;
import java.util.Date;

/**
 * <code>PtfFollowerRspVO<code>
 * 
 * @author Jimmy
 * @since MiniGod v0.0.1 (2014-12-5)
 * 
 */
@TransferBean
public class WebUserInfoVO implements Serializable {
	/**  */
	private static final long serialVersionUID = -5232267923290668354L;

	@TransferID
	private Long uId;
	private Integer invUserId;//推荐人ID,邀请该用户的用户ID
	private String userSourceChannelId;
	@Emoji
	private String uName;
	private String uImg;
	private Integer uType;
	private String imId;
	private String imPwd;
	private Date lastLoginTime;
	private String trdAccount;
	private EF07000001VO ef07000001VO; //行情信息
	private String phoneNum;// 手机号
	private String email;
	private String clientId;//客户号
	private String openstatus;//开户状态
	private String sessionId;
	private String userIcon;
	private String nickName;

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getUserIcon() {
		return userIcon;
	}

	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getOpenstatus() {
		return openstatus;
	}

	public void setOpenstatus(String openstatus) {
		this.openstatus = openstatus;
	}

	public String getUserSourceChannelId() {
		return userSourceChannelId;
	}

	public void setUserSourceChannelId(String userSourceChannelId) {
		this.userSourceChannelId = userSourceChannelId;
	}

	public Integer getInvUserId() {
		return invUserId;
	}

	public void setInvUserId(Integer invUserId) {
		this.invUserId = invUserId;
	}

	public String getImId() {
		return imId;
	}

	public void setImId(String imId) {
		this.imId = imId;
	}

	public String getImPwd() {
		return imPwd;
	}

	public void setImPwd(String imPwd) {
		this.imPwd = imPwd;
	}

	public Long getuId() {
		return uId;
	}

	public void setuId(Long uId) {
		this.uId = uId;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuImg() {
		return uImg;
	}

	public void setuImg(String uImg) {
		this.uImg = uImg;
	}

	public Integer getuType() {
		return uType;
	}

	public void setuType(Integer uType) {
		this.uType = uType;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getTrdAccount() {
		return trdAccount;
	}

	public void setTrdAccount(String trdAccount) {
		this.trdAccount = trdAccount;
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

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public EF07000001VO getEf07000001VO() {
		return ef07000001VO;
	}

	public void setEf07000001VO(EF07000001VO ef07000001VO) {
		this.ef07000001VO = ef07000001VO;
	}
}
