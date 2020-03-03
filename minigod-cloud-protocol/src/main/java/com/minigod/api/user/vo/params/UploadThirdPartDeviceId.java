package com.minigod.api.user.vo.params;

import com.minigod.api.user.vo.SNUserBase;

public class UploadThirdPartDeviceId extends SNUserBase {

	private static final long serialVersionUID = -5810541967667635483L;

	private Integer type;//第三方类型	0表示个推，目前只有个推

	private String deviceId;//设备ID	第三方生成的设备ID（个推叫ClientId）

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
}
