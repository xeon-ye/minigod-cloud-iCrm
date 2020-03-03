/**
 * @Title: WeixinToken.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.weixin.vo.resp;

import java.io.Serializable;

/**
 * 获取access_token公众号的全局唯一票据
 *
 * @author MiniGod
 * @date 2015-9-18 上午10:31:51
 * @version v1.0
 */

public class WeixinToken extends WeiXin implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String access_token;
	private String expires_in;
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public String getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}
}
