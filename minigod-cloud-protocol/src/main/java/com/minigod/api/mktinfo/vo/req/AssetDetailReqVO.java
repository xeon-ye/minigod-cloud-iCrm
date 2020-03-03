/**
 * @Title: StkQuotReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * <code>StkQuotReqVO</code>
 * 
 * @author Jimmy
 * @date 2015-7-1 下午1:45:42
 * @version v1.0
 */
public class AssetDetailReqVO extends SNVersion {
	private static final long serialVersionUID = 1L;

	private AssetDetailVO params;
	
	public AssetDetailVO getParams() {
		return params;
	}

	public void setParams(AssetDetailVO params) {
		this.params = params;
	}
	
}
