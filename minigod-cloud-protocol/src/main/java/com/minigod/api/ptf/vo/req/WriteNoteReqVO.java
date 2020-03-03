/*
 * FileName: SaveDiaryReqVO.java
 * Copyright: Copyright 2014-12-3 MiniGod Tech. Co. Ltd.All right reserved.
 * Description: 
 *
 */
package com.minigod.api.ptf.vo.req;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * 
 * @description 这里描述类的用处
 *
 * @author MiniGod
 * @date 2015-4-17 下午5:06:03
 * @version v1.0
 */

@TransferBean
public class WriteNoteReqVO extends SNVersion {
	/**  */
	private static final long serialVersionUID = 1L;

	@TransferID
	@Emoji
	private WriteNoteVO params;

	public WriteNoteVO getParams() {
		return params;
	}

	public void setParams(WriteNoteVO params) {
		this.params = params;
	}
}
