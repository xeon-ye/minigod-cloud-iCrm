package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.vo.BaseVO;

/**
 * @description 个股分红融资参数VO
 * 
 * @author xiongpan
 * @date 2015-10-8 下午9:21:16
 * @version v1.0
 */
public class StkDivVO extends BaseVO{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String assetId;

		public String getAssetId() {
			return assetId;
		}

		public void setAssetId(String assetId) {
			this.assetId = assetId;
		}
}
