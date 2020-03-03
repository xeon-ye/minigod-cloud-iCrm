/**
 * @Title: UploadDevicePushConfig.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description IOS上传设备推送设置信息请求类
 *
 * @author minigod
 * @date 2015-12-4 下午1:37:02
 * @version v1.0
 */

public class UploadDevicePushConfigReqVO extends SNVersion {

	private static final long serialVersionUID = 1L;
	
	private UploadDevicePushConfigVO params;

	public UploadDevicePushConfigVO getParams() {
		return params;
	}

	public void setParams(UploadDevicePushConfigVO params) {
		this.params = params;
	}
	
}
