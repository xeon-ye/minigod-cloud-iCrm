package com.minigod.api.ptf.vo.req;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * 
 * @description 组合调仓预检请求类
 *
 * @author MiniGod
 * @date 2015-3-30 上午11:13:13
 * @version v1.0
 */
@TransferBean
public class CheckRealAdjustRequestVO extends SNVersion {

	private static final long serialVersionUID = 1L;
	
	@TransferID
	private CheckRealAdjustVO params;

	public CheckRealAdjustVO getParams() {
		return params;
	}

	public void setParams(CheckRealAdjustVO params) {
		this.params = params;
	}
}
