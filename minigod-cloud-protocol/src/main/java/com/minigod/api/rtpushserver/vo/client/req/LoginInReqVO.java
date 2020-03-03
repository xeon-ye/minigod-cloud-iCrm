/**
 * @Title: LoginInReq.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.rtpushserver.vo.client.req;

import java.io.Serializable;

/**
 * <code>LoginInReq</code>
 * 
 * @author Jimmy
 * @date 2015-7-11 上午9:25:33
 * @version v1.0
 */

public class LoginInReqVO implements Serializable {
	/** */
	private static final long serialVersionUID = 1L;

	private String channelId;
	private String token;

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
