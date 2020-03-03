/**
 * @Title: StkFiveBetsRequestVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description 个股五档行情请求VO
 *
 * @author 余俊斌
 * @date 2015年3月11日 下午3:04:09
 * @version v1.0
 */

public class StkFiveBetsRequestVO extends SNVersion {

	private static final long serialVersionUID = 1L;

	private StkFiveBetsVO params;

	public StkFiveBetsVO getParams() {
		return params;
	}

	public void setParams(StkFiveBetsVO params) {
		this.params = params;
	}
	
}
