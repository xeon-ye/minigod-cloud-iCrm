package com.minigod.api.user.vo.params;

import com.minigod.api.vo.BaseVO;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;

/**
 * 设备信息
 */

@TransferBean
public class DeviceInfo extends BaseVO {

	private static final long serialVersionUID = 1L;

	private Integer deviceId;//设备ID由服务器生成
	private String deviceCode;//设备ID(目前仅用于iOS设备)

	@Emoji
	private String deviceName;//设备名称(用户自定义设备名称，从客户端上传，可以在网站修改，用于客户识别不同的设备)

	@Emoji
	private String deviceModel;//设备型号(如：“iPhone 5S”)
	private Integer deviceType;//设备类型(0PC;1手机;2平板)
	private String osVersion;//操作系统版本
	private Integer osType;//操作系统类型(0安卓，1苹果，2WP)
	private String appVersion;//App应用版本
	private String openCode;//第三方open_code
	private String channel; // 渠道标示，应用是从哪个
	private Integer customType;

	public Integer getCustomType() {
		return customType;
	}

	public void setCustomType(Integer customType) {
		this.customType = customType;
	}

	public Integer getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceCode() {
		return deviceCode;
	}

	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getDeviceModel() {
		return deviceModel;
	}

	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}

	public Integer getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
	}

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	public Integer getOsType() {
		return osType;
	}

	public void setOsType(Integer osType) {
		this.osType = osType;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public String getOpenCode() {
		return openCode;
	}

	public void setOpenCode(String openCode) {
		this.openCode = openCode;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

}
