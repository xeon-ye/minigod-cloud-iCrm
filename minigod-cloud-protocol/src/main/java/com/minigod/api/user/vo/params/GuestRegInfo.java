/**
 * @Title: GuestRegInfo.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.user.vo.params;

import java.io.Serializable;

import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;

/**
 * @description 
 *
 * @author minigod
 * @date 2015-10-14 下午3:31:12
 * @version v1.0
 */

@TransferBean
public class GuestRegInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Emoji
	private DeviceInfo deviceInfo; // 设备信息

	private String ip; // 客户端IP

	public DeviceInfo getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(DeviceInfo deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
}
