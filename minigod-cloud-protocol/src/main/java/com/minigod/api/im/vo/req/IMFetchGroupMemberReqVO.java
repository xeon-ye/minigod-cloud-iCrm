/**
 * @Title: IMFetchGroupMemberReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description 
 *
 * @author Jimmy
 * @date 2015-8-16 下午1:07:40
 * @version v1.0
 */

public class IMFetchGroupMemberReqVO extends SNVersion {
	private static final long serialVersionUID = 1L;

	private IMFetchGroupMemberRVO params;

	public IMFetchGroupMemberRVO getParams() {
		return params;
	}

	public void setParams(IMFetchGroupMemberRVO params) {
		this.params = params;
	}
	
}
