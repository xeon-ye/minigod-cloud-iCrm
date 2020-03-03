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
public class RelationFetchClientRespVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer count;

	@Emoji
	@TransferID
	private List<RelationFetchClientDataVO> data;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<RelationFetchClientDataVO> getData() {
		return data;
	}

	public void setData(List<RelationFetchClientDataVO> data) {
		this.data = data;
	}

	@TransferBean
	public static class RelationFetchClientDataVO implements Serializable {

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
		private String isJoinChargeGroup;
		private String isJoinChargePtf;
		private Long date;
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

		public String getIsJoinChargeGroup() {
			return isJoinChargeGroup;
		}

		public void setIsJoinChargeGroup(String isJoinChargeGroup) {
			this.isJoinChargeGroup = isJoinChargeGroup;
		}

		public String getIsJoinChargePtf() {
			return isJoinChargePtf;
		}

		public void setIsJoinChargePtf(String isJoinChargePtf) {
			this.isJoinChargePtf = isJoinChargePtf;
		}

		public Long getDate() {
			return date;
		}

		public void setDate(Long date) {
			this.date = date;
		}

		public String getCmnt() {
			return cmnt;
		}

		public void setCmnt(String cmnt) {
			this.cmnt = cmnt;
		}

		
	}

}
