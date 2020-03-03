/**
 * @Title: MySummaryReqVo.java
 * @Copyright: © 2016 minigod
 * @Company: minigod
 */

package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.params.DeviceInfo;
import com.minigod.api.vo.BaseVO;
import com.minigod.common.anno.Emoji;

/**
 * @description
 * 
 * @author kouyandong
 * @date 2016-1-20 下午2:58:45
 * @version v1.0
 */

public class UserThirdparty extends BaseVO{
	private static final long serialVersionUID = -6163187304722218665L;
	private String clientIp;
	private String serverIp;
	private Integer sessionType;
	private Integer userType;
	private String source;
	@Emoji
	private DeviceInfo deviceInfo; // 设备信息

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	public String getServerIp() {
		return serverIp;
	}

	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}

	public Integer getSessionType() {
		return sessionType;
	}

	public void setSessionType(Integer sessionType) {
		this.sessionType = sessionType;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public DeviceInfo getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(DeviceInfo deviceInfo) {
		this.deviceInfo = deviceInfo;
	}
}
