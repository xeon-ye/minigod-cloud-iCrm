/**
 * @Title: CheckCreatePtfRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.resp;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-6-9 下午4:57:12
 * @version v1.0
 */

public class CheckCreatePtfRespVO extends SNVersion {
	private static final long serialVersionUID = 1L;
	
	private String canCrt;
	private String message;
	public String getCanCrt() {
		return canCrt;
	}
	public void setCanCrt(String canCrt) {
		this.canCrt = canCrt;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
