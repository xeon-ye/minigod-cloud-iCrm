package com.minigod.api.user.vo;

import java.io.Serializable;

/**
 * @Title: ErrorMsg.java
 * @Description: 错误日志上报值对象
 * @Copyright: © 2015 minigod
 * @Company: minigod
 *
 * @author minigod
 * @date 2015-2-9 下午2:29:36
 * @version v1.0
 */

public class ErrorMsg  extends SNUserBase implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String appVersion; // 应用版本
	
	private String info; // 错误日志信息
	
	private String osVersion; // 操作系统版本
	
	private String osType; // 操作系统类型
	
	private String deviceModel; // 设备信号
	
	private String appName; // 应用名称

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	public String getOsType() {
		return osType;
	}

	public void setOsType(String osType) {
		this.osType = osType;
	}

	public String getDeviceModel() {
		return deviceModel;
	}

	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}
	
}
