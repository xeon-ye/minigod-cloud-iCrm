package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNUserBase;
import com.minigod.api.user.vo.params.DeviceInfo;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;

/**
 * @Title: ReqUploadDeviceInfo.java
 * @Description: 
 * @Copyright:  2015 minigod
 * @Company: minigod
 *
 * @author ken
 * @date 2015-7-4 下午3:52:13
 * @version v1.0
 */

@TransferBean
public class ReqUploadDeviceInfo extends SNUserBase {

	private static final long serialVersionUID = 2412049579524626700L;

	@Emoji
	private DeviceInfo deviceInfo; //设备信息

	public DeviceInfo getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(DeviceInfo deviceInfo) {
		this.deviceInfo = deviceInfo;
	}
}
