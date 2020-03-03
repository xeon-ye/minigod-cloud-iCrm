/**
 * @Title: RelationDelClientReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.adviser.vo.request;

import java.util.List;

import com.minigod.api.adviser.vo.QNAdviserBase;
import com.minigod.api.user.vo.SNVersion;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2015-11-16 上午10:27:37
 * @version v1.0
 */
@TransferBean
public class RelationDelClientReqVO extends SNVersion {
	private static final long serialVersionUID = 1L;
	private String requestSrc;
	@TransferID
	private RelationDelClientVO params;

	public RelationDelClientVO getParams() {
		return params;
	}

	public void setParams(RelationDelClientVO params) {
		this.params = params;
	}

	public String getRequestSrc() {
		return requestSrc;
	}

	public void setRequestSrc(String requestSrc) {
		this.requestSrc = requestSrc;
	}

	@TransferBean
	public static class RelationDelClientVO extends QNAdviserBase {

		private static final long serialVersionUID = 1L;

		@TransferID
		private List<Long> tarUserIds;
		private String isInBlacklist;// 是否在黑名单
		private String isCheck;
		private String isDelFriend;
		private String type;

		public String getIsInBlacklist() {
			return isInBlacklist;
		}

		public void setIsInBlacklist(String isInBlacklist) {
			this.isInBlacklist = isInBlacklist;
		}

		public List<Long> getTarUserIds() {
			return tarUserIds;
		}

		public void setTarUserIds(List<Long> tarUserIds) {
			this.tarUserIds = tarUserIds;
		}

		public String getIsCheck() {
			return isCheck;
		}

		public void setIsCheck(String isCheck) {
			this.isCheck = isCheck;
		}

		public String getIsDelFriend() {
			return isDelFriend;
		}

		public void setIsDelFriend(String isDelFriend) {
			this.isDelFriend = isDelFriend;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}
		
	}
}
