package com.minigod.api.adviser.vo.request;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.adviser.vo.QNAdviserBase;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * 返回和请求的基础类
 */
@TransferBean
public class AdviserBaseVO extends SNVersion {

	private static final long serialVersionUID = 4926141855371145977L;
	
	@TransferID
	@Emoji
	private QNAdviserBase params;

	public QNAdviserBase getParams() {
		return params;
	}

	public void setParams(QNAdviserBase params) {
		this.params = params;
	}
}
