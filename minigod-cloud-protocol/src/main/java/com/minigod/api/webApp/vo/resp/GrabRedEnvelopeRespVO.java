/**
 * @Title: GrabRedEnvelopeRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.resp;

import java.io.Serializable;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-6-26 下午2:36:44
 * @version v1.0
 */

public class GrabRedEnvelopeRespVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer status;
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}
