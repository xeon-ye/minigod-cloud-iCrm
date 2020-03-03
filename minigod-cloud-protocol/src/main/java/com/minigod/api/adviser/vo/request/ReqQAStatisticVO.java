package com.minigod.api.adviser.vo.request;

import com.minigod.api.adviser.vo.params.QAStatistic;
import com.minigod.api.user.vo.SNVersion;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * 问答统计请求类
 */
@TransferBean
public class ReqQAStatisticVO extends SNVersion {

	private static final long serialVersionUID = 4926141855371145977L;
	
	@TransferID
	@Emoji
	private QAStatistic params;

	public QAStatistic getParams() {
		return params;
	}

	public void setParams(QAStatistic params) {
		this.params = params;
	}
}
