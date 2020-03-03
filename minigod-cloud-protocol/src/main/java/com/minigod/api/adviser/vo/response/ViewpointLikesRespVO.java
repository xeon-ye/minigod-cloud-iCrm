/**
 * @Title: ViewpointLikesRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.adviser.vo.response;

import java.io.Serializable;
import java.util.List;

import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description
 * 
 * @author MiniGod
 * @date 2015-11-3 下午4:13:01
 * @version v1.0
 */
@TransferBean
public class ViewpointLikesRespVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@TransferID
	@Emoji
	private List<ViewpointLikesRespVO_data> viewpointLikes;
	private Integer guestNum;
	
	public List<ViewpointLikesRespVO_data> getViewpointLikes() {
		return viewpointLikes;
	}

	public void setViewpointLikes(List<ViewpointLikesRespVO_data> viewpointLikes) {
		this.viewpointLikes = viewpointLikes;
	}

	public Integer getGuestNum() {
		return guestNum;
	}

	public void setGuestNum(Integer guestNum) {
		this.guestNum = guestNum;
	}

	@TransferBean
	public static class ViewpointLikesRespVO_data implements Serializable {
		private static final long serialVersionUID = 1L;
		
		@TransferID
		@Emoji
		private ViewpointUserCommentVO likeUserComment;
		private Integer likeId;
		public ViewpointUserCommentVO getLikeUserComment() {
			return likeUserComment;
		}
		public void setLikeUserComment(ViewpointUserCommentVO likeUserComment) {
			this.likeUserComment = likeUserComment;
		}
		public Integer getLikeId() {
			return likeId;
		}
		public void setLikeId(Integer likeId) {
			this.likeId = likeId;
		}
	}
}
