/*******************************************************************************
 * Copyright (c) 2016 minigod minigod.Co.Ltd. All rights reserved.
 ******************************************************************************/

package com.minigod.api.ptf.vo.req;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.vo.BaseVO;


public class GetPtfRankingTabRequestVO extends SNVersion {
	private static final long serialVersionUID = 1L;

	private GetPtfRankingTabVO params;

	public GetPtfRankingTabVO getParams() {
		return params;
	}

	public void setParams(GetPtfRankingTabVO params) {
		this.params = params;
	}

	public static class GetPtfRankingTabVO extends BaseVO {

		private static final long serialVersionUID = 1L;
		
	}

}
