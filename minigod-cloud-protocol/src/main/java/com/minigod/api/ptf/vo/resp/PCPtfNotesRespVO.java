/*
 * FileName: PCPtfNotesRespVO.java
 * Copyright: Copyright 2015-7-29 MiniGod Tech. Co. Ltd.All right reserved.
 * Description: 
 *
 */
package com.minigod.api.ptf.vo.resp;

import java.io.Serializable;
import java.util.List;

import com.minigod.api.ptf.vo.resp.PtfNoteRespVO.PtfNoteRespVO_Comment;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * 
 * @description 投资圈动态、帖子详情返回类，专门提供给PCminigod證券國際
 * 投资圈动态改造：notes包括praises和comments
 * 帖子详情改造：note包括praises和comments
 *
 * @author panlz
 * @date 2015-7-22 下午3:56:40
 * @version v1.0
 */

@TransferBean
public  class PCPtfNotesRespVO implements Serializable{
	private static final long serialVersionUID = 1L;
	@TransferID
	@Emoji
	List<NoteRespVO_PC> notes;
	
	@TransferID
	@Emoji
	private NoteRespVO_PC note;
	
	public List<NoteRespVO_PC> getNotes() {
		return notes;
	}

	public void setNotes(List<NoteRespVO_PC> notes) {
		this.notes = notes;
	}

	public NoteRespVO_PC getNote() {
		return note;
	}

	public void setNote(NoteRespVO_PC note) {
		this.note = note;
	}



	@TransferBean
	public static class NoteRespVO_PC  implements Serializable{
	
		private static final long serialVersionUID = 1L;
		private Integer noteId;
		private String noteType;
		@TransferID
		private Long uId;
		@Emoji
		private String uName;
		private String uImg;
		private Integer uType;
		@TransferID
		private Long ptfId;
		@Emoji
		private String ptfName;
		private Integer perm;
		@Emoji
		private String busCon;
		private Long ts;
		private Integer isReal;
		private String isWithin;
		private Integer status;
		
		@TransferID
		@Emoji
		List<PtfNoteRespVO_Comment> praises;
		
		@TransferID
		@Emoji
		List<PtfNoteRespVO_Comment> comments;
		
		
		public Long getuId() {
			return uId;
		}
		public void setuId(Long uId) {
			this.uId = uId;
		}
		public Long getPtfId() {
			return ptfId;
		}
		public void setPtfId(Long ptfId) {
			this.ptfId = ptfId;
		}
		public Integer getNoteId() {
			return noteId;
		}
		public void setNoteId(Integer noteId) {
			this.noteId = noteId;
		}
		public String getNoteType() {
			return noteType;
		}
		public void setNoteType(String noteType) {
			this.noteType = noteType;
		}
		public String getuName() {
			return uName;
		}
		public void setuName(String uName) {
			this.uName = uName;
		}
		public String getuImg() {
			return uImg;
		}
		public void setuImg(String uImg) {
			this.uImg = uImg;
		}
		public Integer getuType() {
			return uType;
		}
		public void setuType(Integer uType) {
			this.uType = uType;
		}
		public String getPtfName() {
			return ptfName;
		}
		public void setPtfName(String ptfName) {
			this.ptfName = ptfName;
		}
		public Integer getPerm() {
			return perm;
		}
		public void setPerm(Integer perm) {
			this.perm = perm;
		}
		public String getBusCon() {
			return busCon;
		}
		public void setBusCon(String busCon) {
			this.busCon = busCon;
		}
		public Long getTs() {
			return ts;
		}
		public void setTs(Long ts) {
			this.ts = ts;
		}
		public Integer getIsReal() {
			return isReal;
		}
		public void setIsReal(Integer isReal) {
			this.isReal = isReal;
		}
		public String getIsWithin() {
			return isWithin;
		}
		public void setIsWithin(String isWithin) {
			this.isWithin = isWithin;
		}
		public Integer getStatus() {
			return status;
		}
		public void setStatus(Integer status) {
			this.status = status;
		}
		public List<PtfNoteRespVO_Comment> getPraises() {
			return praises;
		}
		public void setPraises(List<PtfNoteRespVO_Comment> praises) {
			this.praises = praises;
		}
		public List<PtfNoteRespVO_Comment> getComments() {
			return comments;
		}
		public void setComments(List<PtfNoteRespVO_Comment> comments) {
			this.comments = comments;
		}
	}
	
}
