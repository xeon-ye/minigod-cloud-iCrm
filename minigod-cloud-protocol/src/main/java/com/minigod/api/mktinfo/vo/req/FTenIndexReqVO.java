/**
 * @Title: FTenIndexVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.vo.BaseVO;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2015-10-15 上午9:53:58
 * @version v1.0
 */

public class FTenIndexReqVO extends SNVersion {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private FTenIndexVO params;

	public FTenIndexVO getParams() {
		return params;
	}

	public void setParams(FTenIndexVO params) {
		this.params = params;
	}

	public static class FTenIndexVO extends BaseVO {

		private static final long serialVersionUID = 1L;

		private String assetId;

		public String getAssetId() {
			return assetId;
		}

		public void setAssetId(String assetId) {
			this.assetId = assetId;
		}

	}

}
