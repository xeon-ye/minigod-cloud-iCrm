package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;

/**
 * @Title: UploadDeviceInfo.java
 * @Description: 
 * @Copyright:  2015 minigod
 * @Company: minigod
 *
 * @author ken
 * @date 2015-7-4 下午3:49:07
 * @version v1.0
 */

@TransferBean
public class UploadDeviceInfo extends SNVersion {

	private static final long serialVersionUID = -5694111736032432231L;

	@Emoji
	private ReqUploadDeviceInfo params;

	public ReqUploadDeviceInfo getParams() {
		return params;
	}

	public void setParams(ReqUploadDeviceInfo params) {
		this.params = params;
	}
}
