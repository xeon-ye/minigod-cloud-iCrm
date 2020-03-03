/**
 * @Title: InvitedVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo;

import java.io.Serializable;

/**
 * @description 
 *
 * @author Jimmy
 * @date 2015-9-1 下午3:08:59
 * @version v1.0
 */

public class PushInvitedVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long qnId;
	private String nickname;
	public Long getQnId() {
		return qnId;
	}
	public void setQnId(Long qnId) {
		this.qnId = qnId;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
}
