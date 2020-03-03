package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * 
 * <code>StkSumRequestVO<code>[股票分时概要信息 - 请求参数实体类]
 *
 * @author Colin
 * @since MiniGod v0.0.1(2014-11-20)
 *
 */

public class StkRTRequestVO extends SNVersion {
	/**  */
	private static final long serialVersionUID = 8096185982540526128L;

	private StkRTParaVO params;

	public StkRTParaVO getParams() {
		return params;
	}

	public void setParams(StkRTParaVO params) {
		this.params = params;
	}
}