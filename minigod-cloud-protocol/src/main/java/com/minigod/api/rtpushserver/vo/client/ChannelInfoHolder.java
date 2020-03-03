/**
 * @Title: ChannelInfoHolder.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.rtpushserver.vo.client;

import java.io.Serializable;

/**
 * <code>ChannelInfoHolder</code>
 * 
 * @author Jimmy
 * @date 2015-7-15 下午4:54:18
 * @version v1.0
 */
public class ChannelInfoHolder implements Serializable {
	/** */
	private static final long serialVersionUID = 1L;

	private ChannelInfo channelInfo;

	private String channelId;

	private EChannelAction action;

	public EChannelAction getAction() {
		return action;
	}

	public void setAction(EChannelAction action) {
		this.action = action;
	}

	public ChannelInfo getChannelInfo() {
		return channelInfo;
	}

	public void setChannelInfo(ChannelInfo channelInfo) {
		this.channelInfo = channelInfo;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public static enum EChannelAction {
		CLOSE, // 
		CONNECTION, // 
		CONNECTED //
	}
}
