/**
 * @Title: StkQuotVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.vo.BaseVO;

import java.util.List;

/**
 * <code>StkQuotVO</code>
 * 
 * @author wangshuai
 * @date 2015-7-1 下午1:46:23
 * @version v1.0
 */
public class AssetTradeVO extends BaseVO {
	

	private static final long serialVersionUID = 1L;

	private String assetId;

	private Long pos;
	
	private int count; 

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}
	public Long getPos() {
		return pos;
	}

	public void setPos(Long pos) {
		this.pos = pos;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}


	
}
