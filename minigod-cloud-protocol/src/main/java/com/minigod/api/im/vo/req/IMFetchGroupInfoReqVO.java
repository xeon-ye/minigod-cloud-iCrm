/**
 * @Title: IMFetchGroupInfoReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description 
 *
 * @author Jimmy
 * @date 2015-8-16 下午1:02:35
 * @version v1.0
 */

public class IMFetchGroupInfoReqVO extends SNVersion {
	private static final long serialVersionUID = 1L;
	
	private IMFetchGroupInfoVO params;

	public IMFetchGroupInfoVO getParams() {
		return params;
	}

	public void setParams(IMFetchGroupInfoVO params) {
		this.params = params;
	}
}
