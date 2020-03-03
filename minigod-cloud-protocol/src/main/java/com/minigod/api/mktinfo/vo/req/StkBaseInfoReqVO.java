/**
 * @Title: StkBaseInfoReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description 
 *
 * @author 谢尚河
 * @date 2015-8-19 下午10:19:42
 * @version v1.0
 */

public class StkBaseInfoReqVO extends SNVersion {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StkBaseInfoParamVO params;

	public StkBaseInfoParamVO getParams() {
		return params;
	}

	public void setParams(StkBaseInfoParamVO params) {
		this.params = params;
	}
}
