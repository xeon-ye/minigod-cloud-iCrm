/*
 * FileName: PtfNoteReqVO.java
 * Copyright: Copyright 2014-12-4 MiniGod Tech. Co. Ltd.All right reserved.
 * Description: 
 *
 */
package com.minigod.api.ptf.vo.req;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * <code>PtfNoteReqVO<code>
 *
 * @author Jimmy
 * @since  MiniGod v0.0.1 (2014-12-4)
 *
 */
@TransferBean
public class PtfNoteReqVO extends SNVersion {
	/**  */
	private static final long serialVersionUID = -1791813033886922021L;

	@TransferID
	private PtfNoteVO params;

	public PtfNoteVO getParams() {
		return params;
	}

	public void setParams(PtfNoteVO params) {
		this.params = params;
	}
}
