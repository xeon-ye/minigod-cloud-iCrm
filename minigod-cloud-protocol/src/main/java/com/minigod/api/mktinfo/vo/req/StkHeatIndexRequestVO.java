/**
 * @Title: StkHeatIndexRequestVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2015-8-15 下午6:00:30
 * @version v1.0
 */

public class StkHeatIndexRequestVO extends SNVersion {
	private static final long serialVersionUID = 1L;

	private StkHeatIndexParamVO params;

	public StkHeatIndexParamVO getParams() {
		return params;
	}

	public void setParams(StkHeatIndexParamVO params) {
		this.params = params;
	}

}
