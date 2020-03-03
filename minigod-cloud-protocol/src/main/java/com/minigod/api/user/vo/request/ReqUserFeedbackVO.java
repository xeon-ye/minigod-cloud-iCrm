/*
 * FileName: ReqUserFeedbackVO.java
 * Copyright: Copyright 2015-7-20 MiniGod Tech. Co. Ltd.All right reserved.
 * Description: 
 *
 */
package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.user.vo.params.Feedback;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
/**
 * <code>ReqUserFeedbackVO<code>
 *
 * @author panlz
 * @since  MiniGod v0.0.1 (2015-7-20)
 *
 */
@TransferBean
public class ReqUserFeedbackVO extends SNVersion {
	/**  */
	private static final long serialVersionUID = -1958465183676587063L;
	
	@Emoji
	private Feedback params;

	public Feedback getParams() {
		return params;
	}

	public void setParams(Feedback params) {
		this.params = params;
	}

}
