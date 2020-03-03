package com.minigod.api.adviser.vo.params;

import com.minigod.api.adviser.vo.QNAdviserBase;
import com.minigod.common.anno.TransferBean;
@TransferBean
public class AnswerQaList extends QNAdviserBase  {

	private static final long serialVersionUID = -6148586421924205449L;
	
	private Integer type ; //问题来源 1广场问答 2专属投顾问答
	
	private Integer qStatus ; //问题状态 空全部 0待抢答，1已抢未答，2已回答， 3已放弃，4超时
	
	private Integer isSatisfy ; //是否满意 空全部  0不满意 1满意,2没有评价

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getqStatus() {
		return qStatus;
	}

	public void setqStatus(Integer qStatus) {
		this.qStatus = qStatus;
	}

	public Integer getIsSatisfy() {
		return isSatisfy;
	}

	public void setIsSatisfy(Integer isSatisfy) {
		this.isSatisfy = isSatisfy;
	}
	
}
