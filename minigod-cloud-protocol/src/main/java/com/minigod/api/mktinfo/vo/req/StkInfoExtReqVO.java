/**
 * @Title: StkSubscribeReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * <code>StkTsReqVO</code>
 * 
 * @author Jimmy
 * @date 2015-7-1 下午2:14:08
 * @version v1.0
 */
public class StkInfoExtReqVO extends SNVersion {
	private static final long serialVersionUID = 1L;

	private StkInfoExtVO params;

	public StkInfoExtVO getParams() {
		return params;
	}

	public void setParams(StkInfoExtVO params) {
		this.params = params;
	}

}
