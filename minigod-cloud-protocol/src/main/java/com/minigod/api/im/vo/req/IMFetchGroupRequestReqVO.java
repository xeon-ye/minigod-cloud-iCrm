/**
 * @Title: IMFetchGroupRequestReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description 
 *
 * @author Jimmy
 * @date 2015-11-13 下午12:15:32
 * @version v1.0
 */

public class IMFetchGroupRequestReqVO extends SNVersion {
	private static final long serialVersionUID = 1L;
	
	private IMFetchGroupRequestVO params;

	public IMFetchGroupRequestVO getParams() {
		return params;
	}

	public void setParams(IMFetchGroupRequestVO params) {
		this.params = params;
	}
}
