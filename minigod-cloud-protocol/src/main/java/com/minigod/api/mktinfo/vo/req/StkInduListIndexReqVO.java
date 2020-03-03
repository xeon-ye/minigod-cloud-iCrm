/**
 * @Title: StkInduListIndexVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2015-8-18 下午9:00:48
 * @version v1.0
 */

public class StkInduListIndexReqVO extends SNVersion {
	private static final long serialVersionUID = 1L;

	private StkInduListIndexParamVO params;

	public StkInduListIndexParamVO getParams() {
		return params;
	}

	public void setParams(StkInduListIndexParamVO params) {
		this.params = params;
	}

}
