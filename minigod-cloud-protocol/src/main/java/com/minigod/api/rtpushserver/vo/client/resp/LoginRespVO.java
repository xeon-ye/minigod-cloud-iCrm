/**
 * @Title: LoginRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.rtpushserver.vo.client.resp;

import java.io.Serializable;

/**
 * <code>LoginRespVO</code>
 * 
 * @author Jimmy
 * @date 2015-7-11 上午9:28:37
 * @version v1.0
 */
public class LoginRespVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String channelId;

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

}
