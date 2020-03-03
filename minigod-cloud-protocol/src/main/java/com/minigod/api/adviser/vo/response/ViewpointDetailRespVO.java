/**
 * @Title: ViewpointDetailRespVO.java
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
 * @date 2015-11-2 下午5:16:46
 * @version v1.0
 */
@TransferBean
public class ViewpointDetailRespVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@TransferID
	private Long uId;
	@Emoji
	private String uName;
	@Emoji
	private String commentName;
	private String uImg;
	private String adviserType;
	private String adviserOrg;
	private String[] adviserField;
	private Integer commentNum;
	private Integer likeNum;
	private Long readNum;
	private Long viewpointTs;
	private String relationType;
	private Integer permission;
	private String url;
	private String shareUrl;
	@Emoji
	private String shareTitle;
	@Emoji
	private String shareSummary;
	private Integer isLike;
	private Integer isMine;
	private Integer isComment;
	private Long viewpointId;
	private Integer isQues;
	private Integer rewardNum;
	private List<ViewpointDetailRespVO_reward> rewards;
	private Integer isSelection;
	private String content;
	private String title;
	private String isAttentioned;

	public Integer getIsSelection() {
		return isSelection;
	}

	public void setIsSelection(Integer isSelection) {
		this.isSelection = isSelection;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getIsComment() {
		return isComment;
	}

	public void setIsComment(Integer isComment) {
		this.isComment = isComment;
	}

	public String getCommentName() {
		return commentName;
	}

	public void setCommentName(String commentName) {
		this.commentName = commentName;
	}

	public Integer getRewardNum() {
		return rewardNum;
	}

	public void setRewardNum(Integer rewardNum) {
		this.rewardNum = rewardNum;
	}

	public List<ViewpointDetailRespVO_reward> getRewards() {
		return rewards;
	}

	public void setRewards(List<ViewpointDetailRespVO_reward> rewards) {
		this.rewards = rewards;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getIsQues() {
		return isQues;
	}

	public void setIsQues(Integer isQues) {
		this.isQues = isQues;
	}

	public Long getViewpointId() {
		return viewpointId;
	}

	public void setViewpointId(Long viewpointId) {
		this.viewpointId = viewpointId;
	}

	public Integer getIsMine() {
		return isMine;
	}

	public void setIsMine(Integer isMine) {
		this.isMine = isMine;
	}

	public Integer getIsLike() {
		return isLike;
	}

	public void setIsLike(Integer isLike) {
		this.isLike = isLike;
	}

	public Long getuId() {
		return uId;
	}

	public void setuId(Long uId) {
		this.uId = uId;
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

	public String[] getAdviserField() {
		return adviserField;
	}

	public void setAdviserField(String[] adviserField) {
		this.adviserField = adviserField;
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

	public Long getReadNum() {
		return readNum;
	}

	public void setReadNum(Long readNum) {
		this.readNum = readNum;
	}

	public Long getViewpointTs() {
		return viewpointTs;
	}

	public void setViewpointTs(Long viewpointTs) {
		this.viewpointTs = viewpointTs;
	}

	public String getRelationType() {
		return relationType;
	}

	public void setRelationType(String relationType) {
		this.relationType = relationType;
	}

	public Integer getPermission() {
		return permission;
	}

	public void setPermission(Integer permission) {
		this.permission = permission;
	}

	public String getShareUrl() {
		return shareUrl;
	}

	public void setShareUrl(String shareUrl) {
		this.shareUrl = shareUrl;
	}

	public String getShareTitle() {
		return shareTitle;
	}

	public void setShareTitle(String shareTitle) {
		this.shareTitle = shareTitle;
	}

	public String getShareSummary() {
		return shareSummary;
	}

	public void setShareSummary(String shareSummary) {
		this.shareSummary = shareSummary;
	}

	public String getIsAttentioned() {
		return isAttentioned;
	}

	public void setIsAttentioned(String isAttentioned) {
		this.isAttentioned = isAttentioned;
	}

	@TransferBean
	public static class ViewpointDetailRespVO_reward implements Serializable {
		private static final long serialVersionUID = 1L;

		@TransferID
		private Long uId;
		private String uImg;
		private Integer uType;

		public Integer getuType() {
			return uType;
		}

		public void setuType(Integer uType) {
			this.uType = uType;
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
	}
}
