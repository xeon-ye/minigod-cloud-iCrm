package com.minigod.api.user.vo.request;

import java.io.Serializable;

/**
 * @Title: UserFeedVO.java
 * @Description: 
 * @Copyright:  2015 minigod
 * @Company: minigod
 *
 * @author ken
 * @date 2015-4-7 下午3:18:13
 * @version v1.0
 */

public class UserFeedVO implements Serializable {

	private static final long serialVersionUID = 6872739283461672212L;

	private String nickName;//用户昵称
	private String contact;//联系方式（手机号、邮件、QQ）
	private String content;//反馈内容

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
