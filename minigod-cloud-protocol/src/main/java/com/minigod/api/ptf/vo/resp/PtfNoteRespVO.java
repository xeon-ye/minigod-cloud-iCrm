/*
 * FileName: PtfNoteRespVO.java
 * Copyright: Copyright 2014-12-5 MiniGod Tech. Co. Ltd.All right reserved.
 * Description: 
 *
 */
package com.minigod.api.ptf.vo.resp;

import java.io.Serializable;
import java.util.List;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * 
 * @description 投资圈动态返回类
 *
 * @author MiniGod
 * @date 2015-4-17 下午3:56:40
 * @version v1.0
 */
@TransferBean
public class PtfNoteRespVO extends SNVersion {
	private static final long serialVersionUID = 1L;
	
	@TransferID
	@Emoji
	private PtfNoteRespVO_Data data;
	
	public PtfNoteRespVO_Data getData() {
		return data;
	}

	public void setData(PtfNoteRespVO_Data data) {
		this.data = data;
	}
	
	@TransferBean
	public static class PtfNoteRespVO_Data implements Serializable{
		private static final long serialVersionUID = 1L;
		@TransferID
		@Emoji
		List<PtfNoteRespVO_Note> notes;
		@TransferID
		@Emoji
		List<PtfNoteRespVO_Comment> comments;
		
		private Integer unreadCount;
		
		public List<PtfNoteRespVO_Comment> getComments() {
			return comments;
		}

		public void setComments(List<PtfNoteRespVO_Comment> comments) {
			this.comments = comments;
		}

		public List<PtfNoteRespVO_Note> getNotes() {
			return notes;
		}

		public void setNotes(List<PtfNoteRespVO_Note> notes) {
			this.notes = notes;
		}

		public Integer getUnreadCount() {
			return unreadCount;
		}

		public void setUnreadCount(Integer unreadCount) {
			this.unreadCount = unreadCount;
		}
	}
	
	@TransferBean
	public static class PtfNoteRespVO_Note  implements Serializable{
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
		private Integer likeNum;
		private Integer commentNum;
		private String relationType;
		private Integer isInteraction;
		private Integer isLimit;

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
		public Integer getLikeNum() {
			return likeNum;
		}
		public void setLikeNum(Integer likeNum) {
			this.likeNum = likeNum;
		}
		public Integer getCommentNum() {
			return commentNum;
		}
		public void setCommentNum(Integer commentNum) {
			this.commentNum = commentNum;
		}
		public String getRelationType() {
			return relationType;
		}
		public void setRelationType(String relationType) {
			this.relationType = relationType;
		}
		public Integer getIsInteraction() {
			return isInteraction;
		}
		public void setIsInteraction(Integer isInteraction) {
			this.isInteraction = isInteraction;
		}
		public Integer getIsLimit() {
			return isLimit;
		}
		public void setIsLimit(Integer isLimit) {
			this.isLimit = isLimit;
		}
		
	}
	@TransferBean
	public static class PtfNoteRespVO_Comment implements Serializable{
		private static final long serialVersionUID = 1L;
		private String type;
		private Integer cmtId;
		private Integer noteId;
		@TransferID
		private Long fromUId;
		@Emoji
		private String fromUName;
		private String fromUImg;
		private Integer fromUType;
		@TransferID
		private Long toUId;
		@Emoji
		private String toUName;
		private Integer toUType;
		@Emoji
		private String content;
		private Integer perm;
		private Long ts;
		private Integer status;
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public Integer getCmtId() {
			return cmtId;
		}
		public void setCmtId(Integer cmtId) {
			this.cmtId = cmtId;
		}
		public Integer getNoteId() {
			return noteId;
		}
		public void setNoteId(Integer noteId) {
			this.noteId = noteId;
		}
		public String getFromUName() {
			return fromUName;
		}
		public void setFromUName(String fromUName) {
			this.fromUName = fromUName;
		}
		public String getFromUImg() {
			return fromUImg;
		}
		public void setFromUImg(String fromUImg) {
			this.fromUImg = fromUImg;
		}
		public String getToUName() {
			return toUName;
		}
		public void setToUName(String toUName) {
			this.toUName = toUName;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public Integer getPerm() {
			return perm;
		}
		public void setPerm(Integer perm) {
			this.perm = perm;
		}
		public Long getTs() {
			return ts;
		}
		public void setTs(Long ts) {
			this.ts = ts;
		}
		public Integer getStatus() {
			return status;
		}
		public void setStatus(Integer status) {
			this.status = status;
		}
		public Long getFromUId() {
			return fromUId;
		}
		public void setFromUId(Long fromUId) {
			this.fromUId = fromUId;
		}
		public Long getToUId() {
			return toUId;
		}
		public void setToUId(Long toUId) {
			this.toUId = toUId;
		}
		public Integer getFromUType() {
			return fromUType;
		}
		public void setFromUType(Integer fromUType) {
			this.fromUType = fromUType;
		}
		public Integer getToUType() {
			return toUType;
		}
		public void setToUType(Integer toUType) {
			this.toUType = toUType;
		}
		
	}
}
