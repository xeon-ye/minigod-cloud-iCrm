/**
 * @Title: MySummaryReqVo.java
 * @Copyright: © 2016 minigod
 * @Company: minigod
 */

package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description
 * 
 * @author kouyandong
 * @date 2016-1-20 下午2:58:45
 * @version v1.0
 */

public class SimulateVO extends SNVersion {
	private static final long serialVersionUID = -6163187304722218665L;

	private UserThirdparty params;

	public UserThirdparty getParams() {
		return params;
	}

	public void setParams(UserThirdparty params) {
		this.params = params;
	}

}
