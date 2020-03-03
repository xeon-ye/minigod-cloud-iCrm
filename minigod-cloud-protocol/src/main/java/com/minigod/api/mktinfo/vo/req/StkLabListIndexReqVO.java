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

public class StkLabListIndexReqVO extends SNVersion {
	private static final long serialVersionUID = 1L;

	private StkLabListIndexParamVO params;

	public StkLabListIndexParamVO getParams() {
		return params;
	}

	public void setParams(StkLabListIndexParamVO params) {
		this.params = params;
	}

}
