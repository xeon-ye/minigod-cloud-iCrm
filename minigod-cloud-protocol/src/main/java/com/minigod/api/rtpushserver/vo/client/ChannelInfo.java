package com.minigod.api.rtpushserver.vo.client;

import java.io.Serializable;

/**
 * <code>ChannelInfo</code>
 * 
 * @author Jimmy
 * @date 2015-6-30 下午5:09:14
 * @version v1.0
 */
public class ChannelInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	// 所在服务器的IP
	private String ip;
	// 创建时的纳秒
	private Long ts;
	
	public String getIp() {
		return ip;
	}

	public void setIp(String targetIp) {
		this.ip = targetIp;
	}

	public Long getTs() {
		return ts;
	}

	public void setTs(Long ts) {
		this.ts = ts;
	}
	
	/**
	 * @param destChannelInfo
	 * @return
	 */
	public boolean isEq(ChannelInfo destChannelInfo) {
		if (destChannelInfo == null) {
			return false;
		}
		boolean isEq = true;
		Long destTs = destChannelInfo.getTs();
		String destIp = destChannelInfo.getIp();
		if (ts != null) {
			isEq &= ts.equals(destTs);
		} else {
			isEq &= (destTs == null);
		}
		if (ip != null) {
			isEq &= ip.equals(destIp);
		} else {
			isEq &= (destIp == null);
		}
		return isEq;
	}
}
