/**
 * @Title: InvestIndexVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.req;

import java.io.Serializable;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2015-12-9 下午8:39:04
 * @version v1.0
 */

public class InvestIndexVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long userId;
	private String type;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
