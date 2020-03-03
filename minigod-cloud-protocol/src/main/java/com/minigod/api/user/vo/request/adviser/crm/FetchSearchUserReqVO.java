/**
 * @Title: FetchSearchUserReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.user.vo.request.adviser.crm;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-12-29 下午3:29:57
 * @version v1.0
 */

public class FetchSearchUserReqVO extends SNVersion {
	private static final long serialVersionUID = 1L;

	private SearchUserReqVO params;

	public SearchUserReqVO getParams() {
		return params;
	}

	public void setParams(SearchUserReqVO params) {
		this.params = params;
	}
}
