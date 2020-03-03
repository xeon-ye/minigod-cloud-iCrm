/*
 * FileName: StkStatusRequestVO.java
 * Copyright: Copyright 2014-11-13 MiniGod Tech. Co. Ltd.All right reserved.
 * Description: 
 *
 */
package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * <code>StkStatusRequestVO<code>
 * 
 * @author Jimmy
 * @since MiniGod v0.0.1 (2014-11-13)
 * 
 */
public class StkStatusRequestVO extends SNVersion {
	/**  */
	private static final long serialVersionUID = 8096185982540526128L;

	private StkStatusParaVO params;

	public StkStatusParaVO getParams() {
		return params;
	}

	public void setParams(StkStatusParaVO params) {
		this.params = params;
	}
}
