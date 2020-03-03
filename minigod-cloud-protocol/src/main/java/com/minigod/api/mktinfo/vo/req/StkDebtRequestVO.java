/**
 * @Title: StkNewRequestVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description 个股资产负债信息请求
 *
 * @author 余俊斌
 * @date 2015年10月14日 下午3:41:06
 * @version v1.0
 */
public class StkDebtRequestVO extends SNVersion {

	private static final long serialVersionUID = -6347178435615361938L;
	
	private StkDebtParamVO params;

	public StkDebtParamVO getParams() {
		return params;
	}

	public void setParams(StkDebtParamVO params) {
		this.params = params;
	}

}
