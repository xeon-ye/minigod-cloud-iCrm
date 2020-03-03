package com.minigod.api.adviser.vo.request;

import com.minigod.api.adviser.vo.params.AnswerAction;
import com.minigod.api.user.vo.SNVersion;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;
@TransferBean
public class ReqAnswerActionVO extends SNVersion {

	private static final long serialVersionUID = -1958465183676587063L;
	@TransferID
	@Emoji
	private AnswerAction params;

	public AnswerAction getParams() {
		return params;
	}

	public void setParams(AnswerAction params) {
		this.params = params;
	}
	
}
