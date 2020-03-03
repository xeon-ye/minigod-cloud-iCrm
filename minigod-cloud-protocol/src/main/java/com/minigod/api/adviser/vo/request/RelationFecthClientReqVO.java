/**
 * @Title: RelationDelClientReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.adviser.vo.request;

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
public class RelationFecthClientReqVO extends SNVersion {
	private static final long serialVersionUID = 1L;
	@TransferID
	private RelationFecthClientVO params;

	public RelationFecthClientVO getParams() {
		return params;
	}

	public void setParams(RelationFecthClientVO params) {
		this.params = params;
	}

	@TransferBean
	public static class RelationFecthClientVO extends QNAdviserBase {

		private static final long serialVersionUID = 1L;

		private String openAccType;
		private String chargeType;
		private String joinType;
		@TransferID
		private Long userId;
		

		public String getOpenAccType() {
			return openAccType;
		}

		public void setOpenAccType(String openAccType) {
			this.openAccType = openAccType;
		}

		public String getChargeType() {
			return chargeType;
		}

		public void setChargeType(String chargeType) {
			this.chargeType = chargeType;
		}

		public String getJoinType() {
			return joinType;
		}

		public void setJoinType(String joinType) {
			this.joinType = joinType;
		}

		public Long getUserId() {
			return userId;
		}

		public void setUserId(Long userId) {
			this.userId = userId;
		}

	}
}
