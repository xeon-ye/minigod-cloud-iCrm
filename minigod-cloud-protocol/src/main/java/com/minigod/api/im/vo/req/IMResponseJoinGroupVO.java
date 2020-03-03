/**
 * @Title: IMResponseJoinGroupVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.req;

import com.minigod.api.vo.BaseVO;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-11-13 下午1:14:41
 * @version v1.0
 */

public class IMResponseJoinGroupVO extends BaseVO {
	private static final long serialVersionUID = 1L;

	private Long groupRequestId; // 群组请求的ID
	private EResponseAction action;// 响应动作, R – 拒绝, A – 接受

	public static enum EResponseAction {
		R, A
	}

	public Long getGroupRequestId() {
		return groupRequestId;
	}

	public void setGroupRequestId(Long groupRequestId) {
		this.groupRequestId = groupRequestId;
	}

	public EResponseAction getAction() {
		return action;
	}

	public void setAction(EResponseAction action) {
		this.action = action;
	}
}
