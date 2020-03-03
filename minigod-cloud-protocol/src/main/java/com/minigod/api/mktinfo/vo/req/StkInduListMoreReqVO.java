/**
 * @Title: StkInduListMoreReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2015-8-18 下午10:23:22
 * @version v1.0
 */

public class StkInduListMoreReqVO extends SNVersion {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StkInduListMoreParamVO params;

	public StkInduListMoreParamVO getParams() {
		return params;
	}

	public void setParams(StkInduListMoreParamVO params) {
		this.params = params;
	}

}
