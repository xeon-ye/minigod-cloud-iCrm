/**
 * @Title: UploadDevicePushConfigVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.user.vo.request;

import com.minigod.api.vo.BaseVO;

/**
 * @description IOS上传设备推送设置信息业务类
 *
 * @author minigod
 * @date 2015-12-4 下午1:51:47
 * @version v1.0
 */

public class UploadDevicePushConfigVO extends BaseVO {

	private static final long serialVersionUID = 1L;
	
	private Integer pushConfig;

	public Integer getPushConfig() {
		return pushConfig;
	}

	public void setPushConfig(Integer pushConfig) {
		this.pushConfig = pushConfig;
	}
	
}
