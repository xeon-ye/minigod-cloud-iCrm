/*
 * FileName: CommentVO.java
 * Copyright: Copyright 2014-12-3 MiniGod Tech. Co. Ltd.All right reserved.
 * Description: 
 *
 */
package com.minigod.api.ptf.vo.req;

import com.minigod.api.vo.BaseVO;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * <code>SaveCommentVO<code>
 *
 * @author Jimmy
 * @since  MiniGod v0.0.1 (2014-12-3)
 *
 */
@TransferBean
public class PostCmtVO extends BaseVO{
	private static final long serialVersionUID = 1L;
	private Integer noteId; //  主帖的ID
	@TransferID
	private Long uId; // 用户的ID
	@Emoji
	private String content; // 评论的内容
	private String type; // 评论类型 R - 回复，L - 点赞 
	public Integer getNoteId() {
		return noteId;
	}
	public void setNoteId(Integer noteId) {
		this.noteId = noteId;
	}
	public Long getuId() {
		return uId;
	}
	public void setuId(Long uId) {
		this.uId = uId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
