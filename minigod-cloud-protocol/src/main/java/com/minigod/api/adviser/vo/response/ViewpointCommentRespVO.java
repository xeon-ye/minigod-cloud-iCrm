/**
 * @Title: ViewpointCommentRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.adviser.vo.response;

import java.io.Serializable;
import java.util.List;

import com.minigod.api.adviser.vo.response.ViewpointUserCommentVO;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-11-3 下午2:22:59
 * @version v1.0
 */
@TransferBean
public class ViewpointCommentRespVO implements Serializable{
	private static final long serialVersionUID = 1L;

	@TransferID
	@Emoji
	private List<ViewpointCommentRespVO_data> comments; 

	public List<ViewpointCommentRespVO_data> getComments() {
		return comments;
	}

	public void setComments(List<ViewpointCommentRespVO_data> comments) {
		this.comments = comments;
	}

	@TransferBean
	public static class ViewpointCommentRespVO_data implements Serializable{
		private static final long serialVersionUID = 1L; 
		
		private Integer cmtId;
		@TransferID
		private ViewpointUserCommentVO fromUserComment;
		@TransferID
		private ViewpointUserCommentVO toUserComment;
		@Emoji
		private String content;
		private Integer permission;
		private Long commentTs;
		public Integer getCmtId() {
			return cmtId;
		}
		public void setCmtId(Integer cmtId) {
			this.cmtId = cmtId;
		}
		public ViewpointUserCommentVO getFromUserComment() {
			return fromUserComment;
		}
		public void setFromUserComment(ViewpointUserCommentVO fromUserComment) {
			this.fromUserComment = fromUserComment;
		}
		public ViewpointUserCommentVO getToUserComment() {
			return toUserComment;
		}
		public void setToUserComment(ViewpointUserCommentVO toUserComment) {
			this.toUserComment = toUserComment;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public Integer getPermission() {
			return permission;
		}
		public void setPermission(Integer permission) {
			this.permission = permission;
		}
		public Long getCommentTs() {
			return commentTs;
		}
		public void setCommentTs(Long commentTs) {
			this.commentTs = commentTs;
		}
	}
}
