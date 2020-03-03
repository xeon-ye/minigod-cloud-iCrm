/**
 * @Title: StkKDJReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description 查询技术指标请求
 *
 * @author 余俊斌
 * @date 2015年8月17日 下午2:46:33
 * @version v1.0
 */

public class StkTechnicalIndicatorMinReqVO extends SNVersion {

	private static final long serialVersionUID = -8026081956967404111L;
	
	private StkTechnicalIndicatorMinParamVO params;

	public StkTechnicalIndicatorMinParamVO getParams() {
		return params;
	}

	public void setParams(StkTechnicalIndicatorMinParamVO params) {
		this.params = params;
	}
	
}
