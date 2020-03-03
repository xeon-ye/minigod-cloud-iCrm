package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.user.vo.params.UploadThirdPartDeviceId;

public class UploadThirdPartDeviceIdVO  extends SNVersion {

	private static final long serialVersionUID = 8055406574753606634L;

	public UploadThirdPartDeviceId params;

	public UploadThirdPartDeviceId getParams() {
		return params;
	}

	public void setParams(UploadThirdPartDeviceId params) {
		this.params = params;
	}
}
