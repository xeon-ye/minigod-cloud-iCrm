package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.vo.BaseVO;

/**
 * @description 股本结构参数VO
 * 
 * @author xiongpan
 * @date 2015-9-25 下午9:21:16
 * @version v1.0
 */
public class CapStructureVO extends BaseVO{

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
