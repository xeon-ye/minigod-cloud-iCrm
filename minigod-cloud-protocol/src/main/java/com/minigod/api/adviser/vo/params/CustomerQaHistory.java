package com.minigod.api.adviser.vo.params;

import com.minigod.api.adviser.vo.QNAdviserBase;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;
@TransferBean
public class CustomerQaHistory extends QNAdviserBase  {

	private static final long serialVersionUID = -6148586421924205449L;
	
	@TransferID
	private Long qUserId; //提问用户ID

	public Long getqUserId() {
		return qUserId;
	}

	public void setqUserId(Long qUserId) {
		this.qUserId = qUserId;
	}

}
