/**
 * @Title: NewMemberVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo;

import java.io.Serializable;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-12-12 下午4:32:55
 * @version v1.0
 */

public class PushNewMemberVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long userId;

	private String nickname;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}
