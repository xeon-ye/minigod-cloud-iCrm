package com.minigod.api.ptf.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * @Title: PtfUsrFavPtfIdsRequestVO.java
 * @Description: 这里描述类的用处
 * @Copyright: © 2014 minigod
 * @Company: minigod
 *
 * @author minigod
 * @date 2014-11-11 上午10:48:36
 * @version v1.0
 */

public class PtfUsrFavPtfIdsRequestVO extends SNVersion {
	
	private static final long serialVersionUID = 1L;
	
	private PtfUsrFavPtfIdsVO params;

	public PtfUsrFavPtfIdsVO getParams() {
		return params;
	}

	public void setParams(PtfUsrFavPtfIdsVO params) {
		this.params = params;
	}

}
