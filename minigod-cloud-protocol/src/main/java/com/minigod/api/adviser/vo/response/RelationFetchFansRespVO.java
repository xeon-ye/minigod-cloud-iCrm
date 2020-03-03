/**
 * @Title: RelationCheckDelClientRespVO.java
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
 * @author 谢尚河
 * @date 2015-11-16 上午9:54:18
 * @version v1.0
 */
@TransferBean
public class RelationFetchFansRespVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer count;

	@Emoji
	@TransferID
	private List<RelationFetchFansDataVO> data;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<RelationFetchFansDataVO> getData() {
		return data;
	}

	public void setData(List<RelationFetchFansDataVO> data) {
		this.data = data;
	}

	@TransferBean
	public static class RelationFetchFansDataVO implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@TransferID
		private Long userId;
		private String icon;
		@Emoji
		private String nickname;
		private String isOpenAcc;
//		private String isJoinChargeGroup;
//		private String isJoinChargePtf;
		private String clientDate;
		private String lastLoginDate;
		private String isReward;
		private String isMedia;
		@Emoji
		private String cmnt;// 备注名

		public Long getUserId() {
			return userId;
		}

		public void setUserId(Long userId) {
			this.userId = userId;
		}

		public String getIcon() {
			return icon;
		}

		public void setIcon(String icon) {
			this.icon = icon;
		}

		public String getNickname() {
			return nickname;
		}

		public void setNickname(String nickname) {
			this.nickname = nickname;
		}

		public String getIsOpenAcc() {
			return isOpenAcc;
		}

		public void setIsOpenAcc(String isOpenAcc) {
			this.isOpenAcc = isOpenAcc;
		}
		public String getCmnt() {
			return cmnt;
		}

		public void setCmnt(String cmnt) {
			this.cmnt = cmnt;
		}
		public String getIsMedia() {
			return isMedia;
		}

		public void setIsMedia(String isMedia) {
			this.isMedia = isMedia;
		}

		public String getIsReward() {
			return isReward;
		}

		public void setIsReward(String isReward) {
			this.isReward = isReward;
		}

		public String getClientDate() {
			return clientDate;
		}

		public void setClientDate(String clientDate) {
			this.clientDate = clientDate;
		}

		public String getLastLoginDate() {
			return lastLoginDate;
		}

		public void setLastLoginDate(String lastLoginDate) {
			this.lastLoginDate = lastLoginDate;
		}

	}

}
