/**
 * @Title: WeiXinTokenRedis.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.weixin.vo.resp;

import java.io.Serializable;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-9-30 下午1:56:13
 * @version v1.0
 */

public class WeiXinTokenRedis implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String access_token;
	private String ticket;
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
}
