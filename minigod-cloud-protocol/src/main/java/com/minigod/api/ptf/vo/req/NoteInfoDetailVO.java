/**
 * @Title: BrokerLoginInfoVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.req;

import com.minigod.api.vo.BaseVO;

/**
 * 
 * @description 帖子详情页请求类
 *
 * @author MiniGod
 * @date 2015-4-4 上午11:25:01
 * @version v1.0
 */

public class NoteInfoDetailVO extends BaseVO {

	private static final long serialVersionUID = 1L;
	
	private Integer noteId; // 帖子ID

	public Integer getNoteId() {
		return noteId;
	}

	public void setNoteId(Integer noteId) {
		this.noteId = noteId;
	}
}
