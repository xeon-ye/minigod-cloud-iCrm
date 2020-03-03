package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.ErrorMsg;
import com.minigod.api.user.vo.SNVersion;

/**
 * @Title: UploadErrorMsgVO.java
 * @Description: 错误信息上报接口
 * @Copyright: © 2015 minigod
 * @Company: minigod
 *
 * @author minigod
 * @date 2015-2-9 下午1:55:57
 * @version v1.0
 */

public class UploadErrorMsgVO extends SNVersion {
	
	private static final long serialVersionUID = 1L;

	private ErrorMsg params;

	public ErrorMsg getParams() {
		return params;
	}

	public void setParams(ErrorMsg params) {
		this.params = params;
	}

}
