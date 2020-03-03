/**
 * @Title: CheckCreatePtfFromBrk.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-6-9 下午4:52:22
 * @version v1.0
 */

public class CheckCreatePtfRequestVO extends SNVersion {
	private static final long serialVersionUID = 1L;
	
	private CheckCreatePtfVO params;

	public CheckCreatePtfVO getParams() {
		return params;
	}

	public void setParams(CheckCreatePtfVO params) {
		this.params = params;
	}
}
