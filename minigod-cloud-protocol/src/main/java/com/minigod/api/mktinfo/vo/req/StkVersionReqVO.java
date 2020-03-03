/*
 * FileName: StkVersionReqVO.java
 * Copyright: Copyright 2014-11-13 MiniGod Tech. Co. Ltd.All right reserved.
 * Description: 
 *
 */
package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * <code>StkVersionReqVO<code>
 *
 * @author Jimmy
 * @since  MiniGod v0.0.1 (2014-11-13)
 *
 */
public class StkVersionReqVO  extends SNVersion {
	/**  */
	private static final long serialVersionUID = 1825011933664783416L;
	
	private StkVersionVO params;

	public StkVersionVO getParams() {
		return params;
	}

	public void setParams(StkVersionVO params) {
		this.params = params;
	}
}
