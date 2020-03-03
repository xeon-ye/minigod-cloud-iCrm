/*
 * FileName: PtfHDYieldRequestVO.java
 * Copyright: Copyright 2014-11-10 MiniGod Tech. Co. Ltd.All right reserved.
 * Description: 
 *
 */
package com.minigod.api.ptf.vo.req;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * <code>PtfHDYieldRequestVO<code> 调整组合时获取组合的历史数据 <br>
 * (包括模拟历史数据和创建后保存的历史数据)
 *
 * @author Jimmy
 * @since  MiniGod v0.0.1 (2014-11-10)
 *
 */
@TransferBean
public class PtfHDYieldRequestVO extends SNVersion {
	private static final long serialVersionUID = 1323700109069488612L;
	
	@TransferID
	private PtfHDYieldVO params;
	
	public PtfHDYieldVO getParams() {
		return params;
	}

	public void setParams(PtfHDYieldVO params) {
		this.params = params;
	}
}
