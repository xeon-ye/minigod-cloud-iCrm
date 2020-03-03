/**
 * @Title: AddNiuFriendRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.user.vo.response;

import java.io.Serializable;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-6-16 下午5:27:55
 * @version v1.0
 */

public class AddNiuFriendRespVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer status;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
