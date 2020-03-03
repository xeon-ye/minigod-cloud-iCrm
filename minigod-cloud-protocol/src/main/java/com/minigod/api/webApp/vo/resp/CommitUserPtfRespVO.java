/**
 * @Title: CommitUserPtfRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.resp;

import java.io.Serializable;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-8-8 下午6:30:29
 * @version v1.0
 */

public class CommitUserPtfRespVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer status;

	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}
