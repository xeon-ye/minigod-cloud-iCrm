/**
 * @Title: PtfWithdrawRequestVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description 实盘组合撤单请求值对象
 *
 * @author minigod
 * @date 2015-3-31 下午2:14:06
 * @version v1.0
 */

public class PtfWithdrawRequestVO extends SNVersion {

	private static final long serialVersionUID = 1L;
	
	private PtfWithdrawVO params;

	public PtfWithdrawVO getParams() {
		return params;
	}

	public void setParams(PtfWithdrawVO params) {
		this.params = params;
	}
	
}
