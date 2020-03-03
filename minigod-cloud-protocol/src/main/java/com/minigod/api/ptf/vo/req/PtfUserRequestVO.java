package com.minigod.api.ptf.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * @Title: PtfUserRequestVO.java
 * @Description: 这里描述类的用处
 * @Copyright: © 2014 minigod
 * @Company: minigod
 *
 * @author minigod
 * @date 2014-11-11 上午10:43:47
 * @version v1.0
 */

public class PtfUserRequestVO extends SNVersion {
	
	private static final long serialVersionUID = 1L;
	
	private PtfUserVO params;

	public PtfUserVO getParams() {
		return params;
	}

	public void setParams(PtfUserVO params) {
		this.params = params;
	}

}
