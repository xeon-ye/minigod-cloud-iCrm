package com.minigod.api.adviser.vo.params;

import com.minigod.api.adviser.vo.QNAdviserBase;
import com.minigod.common.anno.TransferBean;
@TransferBean
public class QAStatistic extends QNAdviserBase  {

	private static final long serialVersionUID = -6148586421924205449L;
	
	private Integer type ; //问题来源 1广场问答 2专属投顾问答
	

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	
}
