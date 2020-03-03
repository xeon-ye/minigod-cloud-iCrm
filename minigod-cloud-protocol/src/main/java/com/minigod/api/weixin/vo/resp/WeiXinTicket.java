/**
 * @Title: WeiXinTicket.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.weixin.vo.resp;

import com.minigod.api.weixin.vo.resp.WeiXin;

import java.io.Serializable;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-9-22 下午7:22:47
 * @version v1.0
 */

public class WeiXinTicket extends WeiXin implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String ticket;
	private Integer expires_id;
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public Integer getExpires_id() {
		return expires_id;
	}
	public void setExpires_id(Integer expires_id) {
		this.expires_id = expires_id;
	}
}
