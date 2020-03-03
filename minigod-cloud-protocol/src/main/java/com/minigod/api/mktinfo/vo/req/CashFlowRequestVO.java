/**
 * @Title: StkNewRequestVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description 个股现金流量信息参数
 *
 * @author 余俊斌
 * @date 2015年10月14日 下午4:27:08
 * @version v1.0
 */
public class CashFlowRequestVO extends SNVersion {

	private static final long serialVersionUID = -6347178435615361938L;
	
	private CashFlowParamVO params;

	public CashFlowParamVO getParams() {
		return params;
	}

	public void setParams(CashFlowParamVO params) {
		this.params = params;
	}

}
