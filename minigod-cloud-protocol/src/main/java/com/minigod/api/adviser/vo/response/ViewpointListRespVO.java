/**
 * @Title: ViewpointListRespVO.java
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
 * @author 
 * @date 2015-11-4 上午10:15:56
 * @version v1.0
 */
@TransferBean
public class ViewpointListRespVO implements Serializable{
	private static final long serialVersionUID = 1L;

	@Emoji
	private List<ViewpointListRespVO_data> data;
	private List<Long> deleteIds;
	private Integer unReadNum;
	
	public Integer getUnReadNum() {
		return unReadNum;
	}

	public void setUnReadNum(Integer unReadNum) {
		this.unReadNum = unReadNum;
	}

	public List<ViewpointListRespVO_data> getData() {
		return data;
	}

	public void setData(List<ViewpointListRespVO_data> data) {
		this.data = data;
	}

	public List<Long> getDeleteIds() {
		return deleteIds;
	}

	public void setDeleteIds(List<Long> deleteIds) {
		this.deleteIds = deleteIds;
	}

	/**
	 * @description 这里描述类的用处
	 *
	 * @author minigod
	 * @date 2015-12-24 上午11:23:40
	 * @version v1.0
	 */
	@TransferBean
	public static class ViewpointListRespVO_data implements Serializable{
		private static final long serialVersionUID = 1L;
		
		@TransferID
		private Long uId;
		private String uImg;
		private String uName;
		private Integer isComment;
		private String adviserType;
		private String adviserOrg;
		private Long viewpointId;
		private String url;
		private String shareUrl;
		private String viewpointType;
		@Emoji
		private String title;
		@Emoji
		private String summary;
		private String firstImg;
		private Integer commentNum;
		private Integer likeNum;
		private Long viewpointTs;
		private Long readNum;
		private Integer isSelection;
		private Integer isLike;
		private Integer isMine;

		public Integer getIsMine() {
			return isMine;
		}
		public void setIsMine(Integer isMine) {
			this.isMine = isMine;
		}
		public Integer getIsComment() {
			return isComment;
		}
		public void setIsComment(Integer isComment) {
			this.isComment = isComment;
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
		public String getShareUrl() {
			return shareUrl;
		}
		public void setShareUrl(String shareUrl) {
			this.shareUrl = shareUrl;
		}
		public Integer getIsLike() {
			return isLike;
		}
		public void setIsLike(Integer isLike) {
			this.isLike = isLike;
		}
		public Integer getIsSelection() {
			return isSelection;
		}
		public void setIsSelection(Integer isSelection) {
			this.isSelection = isSelection;
		}
		public String getAdviserType() {
			return adviserType;
		}
		public void setAdviserType(String adviserType) {
			this.adviserType = adviserType;
		}
		public String getAdviserOrg() {
			return adviserOrg;
		}
		public void setAdviserOrg(String adviserOrg) {
			this.adviserOrg = adviserOrg;
		}
		public Long getViewpointId() {
			return viewpointId;
		}
		public void setViewpointId(Long viewpointId) {
			this.viewpointId = viewpointId;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getViewpointType() {
			return viewpointType;
		}
		public void setViewpointType(String viewpointType) {
			this.viewpointType = viewpointType;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getSummary() {
			return summary;
		}
		public void setSummary(String summary) {
			this.summary = summary;
		}
		public String getFirstImg() {
			return firstImg;
		}
		public void setFirstImg(String firstImg) {
			this.firstImg = firstImg;
		}
		public Integer getCommentNum() {
			return commentNum;
		}
		public void setCommentNum(Integer commentNum) {
			this.commentNum = commentNum;
		}
		public Integer getLikeNum() {
			return likeNum;
		}
		public void setLikeNum(Integer likeNum) {
			this.likeNum = likeNum;
		}
		public Long getViewpointTs() {
			return viewpointTs;
		}
		public void setViewpointTs(Long viewpointTs) {
			this.viewpointTs = viewpointTs;
		}
		public Long getReadNum() {
			return readNum;
		}
		public void setReadNum(Long readNum) {
			this.readNum = readNum;
		}
		public Long getuId() {
			return uId;
		}
		public void setuId(Long uId) {
			this.uId = uId;
		}
		
	}
}
