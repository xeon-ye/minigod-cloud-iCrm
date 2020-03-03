/*
 * FileName: StkBchReqVO.java
 * Copyright: Copyright 2014-11-19 MiniGod Tech. Co. Ltd.All right reserved.
 * Description: 
 *
 */
package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.user.vo.SNVersion;

public class StkBchReqVO extends SNVersion {
	/**  */
	private static final long serialVersionUID = -4035968035368002862L;
	private  StkBchVO params;
	
	public StkBchVO getParams() {
		return params;
	}
	public void setParams(StkBchVO params) {
		this.params = params;
	}
}
