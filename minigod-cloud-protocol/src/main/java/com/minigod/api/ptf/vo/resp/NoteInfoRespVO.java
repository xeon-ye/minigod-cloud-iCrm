/**
 * @Title: NoteInfoDetailRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.resp;

import java.util.List;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.ptf.vo.resp.PtfNoteRespVO.PtfNoteRespVO_Comment;
import com.minigod.api.ptf.vo.resp.PtfNoteRespVO.PtfNoteRespVO_Note;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-4-17 下午2:44:03
 * @version v1.0
 */
@TransferBean
public class NoteInfoRespVO extends SNVersion {
	private static final long serialVersionUID = 1L;
	
	@TransferID
	@Emoji
	private PtfNoteRespVO_Note note;
	@TransferID
	@Emoji
	private List<PtfNoteRespVO_Comment> comments;

	public PtfNoteRespVO_Note getNote() {
		return note;
	}

	public void setNote(PtfNoteRespVO_Note note) {
		this.note = note;
	}

	public List<PtfNoteRespVO_Comment> getComments() {
		return comments;
	}

	public void setComments(List<PtfNoteRespVO_Comment> comments) {
		this.comments = comments;
	}
}


