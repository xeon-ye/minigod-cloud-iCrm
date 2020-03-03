/**
 * @Title: StkNewsDetailRequsetVo.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description 
 *
 * @author 谢尚河
 * @date 2015-7-20 上午11:28:38
 * @version v1.0
 */

public class StkNewsDetailRequsetVo extends SNVersion {
	private static final long serialVersionUID = 1L;

	private StkNewsDetailParamVO params;

	public StkNewsDetailParamVO getParams() {
		return params;
	}

	public void setParams(StkNewsDetailParamVO params) {
		this.params = params;
	}
}
