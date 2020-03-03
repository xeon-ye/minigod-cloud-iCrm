package com.minigod.api.ptf.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * @Title: PtfUsrSumRequestVO.java
 * @Description: 这里描述类的用处
 * @Copyright: © 2014 minigod
 * @Company: minigod
 *
 * @author minigod
 * @date 2014-11-11 上午10:45:45
 * @version v1.0
 */

public class PtfUsrSumRequestVO extends SNVersion {
	
	private static final long serialVersionUID = 1L;
	
	private PtfUsrSumVO params;

	public PtfUsrSumVO getParams() {
		return params;
	}

	public void setParams(PtfUsrSumVO params) {
		this.params = params;
	}

}
