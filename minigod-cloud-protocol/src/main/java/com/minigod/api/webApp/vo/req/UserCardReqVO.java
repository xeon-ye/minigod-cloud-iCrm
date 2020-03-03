/**
 * @Title: UserCardReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.req;

import java.io.Serializable;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2015-12-9 下午4:52:47
 * @version v1.0
 */

public class UserCardReqVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
