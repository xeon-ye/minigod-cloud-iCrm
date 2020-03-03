package com.minigod.api.user.vo.response;

import java.io.Serializable;

public class InvitationCodeInfoVO implements Serializable {

	private static final long serialVersionUID = 2919742828412829850L;

	private String userName;//创建者名称 ;邀请码创建者姓名，若无创建者，返空，客户端应有默认值 NOTICE：转赠的邀请码，该值应为邀请码的被赠送方;

	private String userIcon;//头像url;邀请码创建者头像，若无创建者，返空或者默认url，客户端应有默认的头像或url;

	//服务器获知使用者姓名的途径有两种：
	//1.使用者自己申请时填写的
	//2.邀请码发送者主动发送时，客户端从通信录上报的姓名
	private String invUserName;//使用者姓名; 邀请码使用者姓名

	private String invUserPhone;//使用者手机号

	//该字段值应包括：
	//1.邀请码发送发对接受方的问候/招呼;
	//邀请码发送者主动发送时，可填对接受方的一段话，若没有，可返空;
	//2.minigod平台介绍，如： 这是一个私密的投资平台，为保障您的权益，需要验证手机号进行安全确认;
	private String[] words;//问候语

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserIcon() {
		return userIcon;
	}

	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
	}

	public String getInvUserName() {
		return invUserName;
	}

	public void setInvUserName(String invUserName) {
		this.invUserName = invUserName;
	}

	public String getInvUserPhone() {
		return invUserPhone;
	}

	public void setInvUserPhone(String invUserPhone) {
		this.invUserPhone = invUserPhone;
	}

	public String[] getWords() {
		return words;
	}

	public void setWords(String[] words) {
		this.words = words;
	}
}
