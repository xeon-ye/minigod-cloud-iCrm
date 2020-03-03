package com.minigod.api.adviser.vo.params;

import com.minigod.api.adviser.vo.QNAdviserBase;
import com.minigod.common.anno.TransferBean;
@TransferBean
public class QaComment extends QNAdviserBase  {

	private static final long serialVersionUID = -6148586421924205449L;
	
	private Integer isSatisfy ; //是否满意
	
	private Integer type ; //不满意类型
	
	private String reason ; //不满意原因
	
	public Integer getIsSatisfy() {
		return isSatisfy;
	}

	public void setIsSatisfy(Integer isSatisfy) {
		this.isSatisfy = isSatisfy;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
}
