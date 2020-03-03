/**
 * @Title: StkSubscribeVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.vo.BaseVO;

/**
 * <code>StkTsVO</code>
 * 
 * @author Jimmy
 * @date 2015-7-1 下午2:14:40
 * @version v1.0
 */
public class StkTsVO extends BaseVO {
	private static final long serialVersionUID = 1L;
	/** 资产ID */
	private String assetId;
	
	public String getAssetId() {
		return assetId;
	}
	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}
}
