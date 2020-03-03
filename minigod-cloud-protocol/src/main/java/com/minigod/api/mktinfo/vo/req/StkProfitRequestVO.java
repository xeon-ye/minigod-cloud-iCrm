/**
 * @Title: StkNewRequestVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description 个股利润指标信息请求
 *
 * @author 余俊斌
 * @date 2015年10月13日 下午8:17:14
 * @version v1.0
 */
public class StkProfitRequestVO extends SNVersion {

	private static final long serialVersionUID = -6347178435615361938L;
	
	private StkProfitParamVO params;

	public StkProfitParamVO getParams() {
		return params;
	}

	public void setParams(StkProfitParamVO params) {
		this.params = params;
	}

}
