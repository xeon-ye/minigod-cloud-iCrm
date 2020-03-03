package com.minigod.api.adviser.vo.params;

import com.minigod.api.adviser.vo.QNAdviserBase;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
@TransferBean
public class AnswerAction extends QNAdviserBase  {

	private static final long serialVersionUID = -6148586421924205449L;
	
	private String action ; //动作 
	@Emoji
	private String content ; //内容
	
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
