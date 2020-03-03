/**
 * @Title: RewardListRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.adviser.vo.response;

import java.io.Serializable;
import java.util.List;

import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-12-3 下午8:21:04
 * @version v1.0
 */
@TransferBean
public class RewardListRespVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<RewardListRespVO_reward> dateRewards;
	private List<RewardListRespVO_userReward> userRewards;
	
	public List<RewardListRespVO_reward> getDateRewards() {
		return dateRewards;
	}

	public void setDateRewards(List<RewardListRespVO_reward> dateRewards) {
		this.dateRewards = dateRewards;
	}

	public List<RewardListRespVO_userReward> getUserRewards() {
		return userRewards;
	}

	public void setUserRewards(List<RewardListRespVO_userReward> userRewards) {
		this.userRewards = userRewards;
	}

	public static class RewardListRespVO_reward implements Serializable {
		private static final long serialVersionUID = 1L;
		
		private String payDate;
		private Double dayIncome;
		public String getPayDate() {
			return payDate;
		}
		public void setPayDate(String payDate) {
			this.payDate = payDate;
		}
		public Double getDayIncome() {
			return dayIncome;
		}
		public void setDayIncome(Double dayIncome) {
			this.dayIncome = dayIncome;
		}
	}
	
	@TransferBean
	public static class RewardListRespVO_userReward implements Serializable {
		private static final long serialVersionUID = 1L;
		
		private Integer rewardId;
		@TransferID
		private Long uId;
		private String uImg;
		private String uName;
		private Integer uType;
		private String commentName;
		private Double amount;
		private String payDate;
		public String getPayDate() {
			return payDate;
		}
		public void setPayDate(String payDate) {
			this.payDate = payDate;
		}
		public Integer getRewardId() {
			return rewardId;
		}
		public void setRewardId(Integer rewardId) {
			this.rewardId = rewardId;
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
		public Integer getuType() {
			return uType;
		}
		public void setuType(Integer uType) {
			this.uType = uType;
		}
		public String getCommentName() {
			return commentName;
		}
		public void setCommentName(String commentName) {
			this.commentName = commentName;
		}
		public Double getAmount() {
			return amount;
		}
		public void setAmount(Double amount) {
			this.amount = amount;
		}
	}
}
