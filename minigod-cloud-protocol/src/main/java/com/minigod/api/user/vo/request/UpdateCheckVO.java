package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.user.vo.params.DeviceInfo;

public class UpdateCheckVO extends SNVersion {

	private static final long serialVersionUID = 1L;

	private DeviceInfo params;

	public DeviceInfo getParams() {
		return params;
	}

	public void setParams(DeviceInfo params) {
		this.params = params;
	}
}
