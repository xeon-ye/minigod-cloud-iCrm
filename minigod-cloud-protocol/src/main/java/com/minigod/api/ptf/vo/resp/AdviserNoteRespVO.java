/**
 * @Title: AdviserNoteRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.resp;

import java.io.Serializable;
import java.util.List;

import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-8-24 上午10:34:14
 * @version v1.0
 */

@TransferBean
public class AdviserNoteRespVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@TransferID
	private List<AdviserNoteRespVO_note> data;
	
	public List<AdviserNoteRespVO_note> getData() {
		return data;
	}
	public void setData(List<AdviserNoteRespVO_note> data) {
		this.data = data;
	}

	@TransferBean
	public static class AdviserNoteRespVO_note implements Serializable {
		private static final long serialVersionUID = 1L;
		
		@TransferID
		private Long uId;
		private String uImg;
		private String uName;
		private Integer noteId;
		private Integer readNum;
		private String content;
		private String relationType;
		public String getRelationType() {
			return relationType;
		}
		public void setRelationType(String relationType) {
			this.relationType = relationType;
		}
		public Long getuId() {
			return uId;
		}
		public void setuId(Long uId) {
			this.uId = uId;
		}
		public String getuImg() {
			return uImg;
		}
		public void setuImg(String uImg) {
			this.uImg = uImg;
		}
		public String getuName() {
			return uName;
		}
		public void setuName(String uName) {
			this.uName = uName;
		}
		public Integer getNoteId() {
			return noteId;
		}
		public void setNoteId(Integer noteId) {
			this.noteId = noteId;
		}
		public Integer getReadNum() {
			return readNum;
		}
		public void setReadNum(Integer readNum) {
			this.readNum = readNum;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
	}
}
