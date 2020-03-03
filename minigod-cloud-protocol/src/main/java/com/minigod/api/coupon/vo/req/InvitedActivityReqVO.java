/**
 * @Title: InvitedActivityReqVO.java
 * @Copyright: © 2016 minigod
 * @Company: minigod
 */

package com.minigod.api.coupon.vo.req;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.vo.BaseVO;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2016-1-26 上午10:22:22
 * @version v1.0
 */

public class InvitedActivityReqVO extends SNVersion {
	private static final long serialVersionUID = 1L;

	private InvitedActivityVO params;

	public InvitedActivityVO getParams() {
		return params;
	}

	public void setParams(InvitedActivityVO params) {
		this.params = params;
	}

	public static class InvitedActivityVO extends BaseVO {
		private static final long serialVersionUID = -3443899277198881431L;
		private String inviterUserId;
		private EUserIdentity type;

		public String getInviterUserId() {
			return inviterUserId;
		}

		public void setInviterUserId(String inviterUserId) {
			this.inviterUserId = inviterUserId;
		}

		public EUserIdentity getType() {
			return type;
		}

		public void setType(EUserIdentity type) {
			this.type = type;
		}
	}

	public static enum EUserIdentity {
		INVITER, // 邀请人
		INVITED // 被邀请人
	}
}
