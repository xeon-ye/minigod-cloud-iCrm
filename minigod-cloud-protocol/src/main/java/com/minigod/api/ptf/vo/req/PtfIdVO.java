/*
 * FileName: PtfIdVO.java
 * Copyright: Copyright 2014-10-23 MiniGod Tech. Co. Ltd.All right reserved.
 * Description: 
 *
 */
package com.minigod.api.ptf.vo.req;

import java.io.Serializable;

import com.minigod.api.vo.BaseVO;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * <code>PtfIdVO<code>
 * 
 * @author Jimmy
 * @since MiniGod v0.0.1 (2014-10-23)
 * 
 */
@TransferBean
public class PtfIdVO extends BaseVO implements Serializable {

	private static final long serialVersionUID = -5575862978340390996L;

	@TransferID
	private Long ptfId; // 组合id

	public Long getPtfId() {
		return ptfId;
	}

	public void setPtfId(Long ptfId) {
		this.ptfId = ptfId;
	}
}
