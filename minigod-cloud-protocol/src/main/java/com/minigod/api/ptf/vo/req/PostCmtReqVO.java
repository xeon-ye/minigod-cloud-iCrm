/*
 * FileName: SaveCommentReqVO.java
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
 * @description 投资圈评论
 *
 * @author MiniGod
 * @date 2015-4-17 下午5:08:12
 * @version v1.0
 */

@TransferBean
public class PostCmtReqVO extends SNVersion {
	private static final long serialVersionUID = 900925521328609572L;
	@TransferID
	@Emoji
	private PostCmtVO params;
	
	public PostCmtVO getParams() {
		return params;
	}
	public void setParams(PostCmtVO params) {
		this.params = params;
	}
}
