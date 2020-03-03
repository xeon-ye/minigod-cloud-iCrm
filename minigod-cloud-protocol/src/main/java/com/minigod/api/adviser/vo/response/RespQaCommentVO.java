package com.minigod.api.adviser.vo.response;

import com.minigod.api.adviser.vo.RespAdviserQABaseVO;
import com.minigod.common.anno.TransferBean;

/**
 * 问答评价返回
 */
@TransferBean
public class RespQaCommentVO extends RespAdviserQABaseVO{

	private static final long serialVersionUID = 340831528495266018L;
	
	private String isForward; //是否需转发给其他投顾 Y要转发 N不需转发
	
	private String returnMsg ; //返回提示信息

	public String getIsForward() {
		return isForward;
	}

	public void setIsForward(String isForward) {
		this.isForward = isForward;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}
	
}
