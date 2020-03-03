/**
 * @Title: ViewpointSelectionRespVO.java
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
 * @date 2015-11-5 上午10:58:02
 * @version v1.0
 */

@TransferBean
public class ViewpointSelectionRespVO implements Serializable{
	private static final long serialVersionUID = 1L;

	@TransferID
	@Emoji
	private List<ViewpointSelectionRespVO_data> data;
	private List<Integer> deleteId;
	
	public List<Integer> getDeleteId() {
		return deleteId;
	}
	public void setDeleteId(List<Integer> deleteId) {
		this.deleteId = deleteId;
	}
	public List<ViewpointSelectionRespVO_data> getData() {
		return data;
	}
	public void setData(List<ViewpointSelectionRespVO_data> data) {
		this.data = data;
	}

	@TransferBean
	public static class ViewpointSelectionRespVO_data implements Serializable{
		private static final long serialVersionUID = 1L;
		
		@TransferID
		private Long uId;
		private String uImg;
		@Emoji
		private String uName;
		private String adviserType;
		private String adviserOrg;
		private Integer viewpointId;
		private String url;
		private String shareUrl;
		private String viewpointType;
		@Emoji
		private String title;
		@Emoji
		private String summary;
		private String firstImg;
		private Long viewpointTs;
		private Long readNum;
		private Long commentNum;
		private Long likeNum;
		private String isSelection;
		private String isAttentioned;

		public String getShareUrl() {
			return shareUrl;
		}
		public void setShareUrl(String shareUrl) {
			this.shareUrl = shareUrl;
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
		public Integer getViewpointId() {
			return viewpointId;
		}
		public void setViewpointId(Integer viewpointId) {
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
		public Long getCommentNum() {
			return commentNum;
		}
		public void setCommentNum(Long commentNum) {
			this.commentNum = commentNum;
		}
		public Long getLikeNum() {
			return likeNum;
		}
		public void setLikeNum(Long likeNum) {
			this.likeNum = likeNum;
		}
		public String getIsSelection() {
			return isSelection;
		}
		public void setIsSelection(String isSelection) {
			this.isSelection = isSelection;
		}

		public String getIsAttentioned() {
			return isAttentioned;
		}

		public void setIsAttentioned(String isAttentioned) {
			this.isAttentioned = isAttentioned;
		}
	}

}
