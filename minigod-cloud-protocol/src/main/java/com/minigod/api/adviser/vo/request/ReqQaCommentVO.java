package com.minigod.api.adviser.vo.request;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.adviser.vo.params.QaComment;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;
@TransferBean
public class ReqQaCommentVO extends SNVersion {

	private static final long serialVersionUID = -1958465183676587063L;
	@TransferID
	@Emoji
	private QaComment params;

	public QaComment getParams() {
		return params;
	}

	public void setParams(QaComment params) {
		this.params = params;
	}
	
}
