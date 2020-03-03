/**
 * @Title: CheckPtfWithdrawRequestVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */
package com.minigod.api.ptf.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description 组合撤单预检请求值对象
 *
 * @author minigod
 * @date 2015-3-31 下午4:19:05
 * @version v1.0
 */

public class CheckPtfWithdrawRequestVO extends SNVersion {
	
	private static final long serialVersionUID = 1L;
	
	private CheckPtfWithdrawVO params;

	public CheckPtfWithdrawVO getParams() {
		return params;
	}

	public void setParams(CheckPtfWithdrawVO params) {
		this.params = params;
	}
}
