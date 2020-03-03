/*
 * FileName: YieldRequestVO.java
 * Copyright: Copyright 2014-11-7 MiniGod Tech. Co. Ltd.All right reserved.
 * Description: 
 *
 */
package com.minigod.api.ptf.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * <code>YieldRequestVO<code> 历史指数回算的收益率 请求实体类。
 *
 * @author Jimmy
 * @since  MiniGod v0.0.1 (2014-11-7)
 *
 */
public class YieldRequestVO extends SNVersion {
	/**  */
	private static final long serialVersionUID = 2253292020018224870L;
	
	private YieldVO params;

	public YieldVO getParams() {
		return params;
	}

	public void setParams(YieldVO params) {
		this.params = params;
	}
}
