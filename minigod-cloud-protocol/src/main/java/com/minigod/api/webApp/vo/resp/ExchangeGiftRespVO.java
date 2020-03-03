/**
 * @Title: ExchangeGiftRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.resp;

import java.io.Serializable;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-7-31 下午5:26:08
 * @version v1.0
 */

public class ExchangeGiftRespVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer status;

	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}
