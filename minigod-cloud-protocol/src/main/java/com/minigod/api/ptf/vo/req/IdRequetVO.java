/*
 * FileName: IdRequetVO.java
 * Copyright: Copyright 2014-12-5 MiniGod Tech. Co. Ltd.All right reserved.
 * Description: 
 *
 */
package com.minigod.api.ptf.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * <code>IdRequetVO<code>
 *
 * @author Jimmy
 * @since  MiniGod v0.0.1 (2014-12-5)
 *
 */
public class IdRequetVO extends SNVersion {
	/**  */
	private static final long serialVersionUID = -1417962669886465705L;
	
	private IdVO params;

	public IdVO getParams() {
		return params;
	}

	public void setParams(IdVO params) {
		this.params = params;
	}
}
