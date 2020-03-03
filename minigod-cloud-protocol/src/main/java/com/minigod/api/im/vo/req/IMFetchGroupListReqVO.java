/**
 * @Title: IMFetchGroupListReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description 
 *
 * @author Jimmy
 * @date 2015-8-16 下午1:04:53
 * @version v1.0
 */

public class IMFetchGroupListReqVO extends SNVersion {
	private static final long serialVersionUID = 1L;
	
	private IMFetchGroupListRVO params;

	public IMFetchGroupListRVO getParams() {
		return params;
	}

	public void setParams(IMFetchGroupListRVO params) {
		this.params = params;
	}
}
