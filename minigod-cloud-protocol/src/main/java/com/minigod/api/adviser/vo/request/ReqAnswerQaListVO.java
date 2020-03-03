package com.minigod.api.adviser.vo.request;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.adviser.vo.params.AnswerQaList;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * 回答者问题列表请求类
 */
@TransferBean
public class ReqAnswerQaListVO extends SNVersion {

	private static final long serialVersionUID = 4926141855371145977L;
	
	@TransferID
	@Emoji
	private AnswerQaList params;

	public AnswerQaList getParams() {
		return params;
	}

	public void setParams(AnswerQaList params) {
		this.params = params;
	}
}
