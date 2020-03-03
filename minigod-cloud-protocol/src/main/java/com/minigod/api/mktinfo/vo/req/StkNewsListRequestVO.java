/**
 * @Title: StkNewRequestVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2015-7-20 上午9:32:37
 * @version v1.0
 */

public class StkNewsListRequestVO extends SNVersion {

	private static final long serialVersionUID = 1L;

	private StkNewsListParamVO params;

	public StkNewsListParamVO getParams() {
		return params;
	}

	public void setParams(StkNewsListParamVO params) {
		this.params = params;
	}

}
