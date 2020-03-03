/**
 * @Title: IndexOfHeatVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.vo.BaseVO;

/**
 * <code>IndexOfHeatVO</code>
 * 
 * @author XIONGPAN
 * @date 2015-7-1 下午1:46:23
 * @version v1.0
 */
public class IndexOfHeatVO extends BaseVO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String assetId ;//个股资产id
	private long ts;//时间戳 
	private int count=5;//拉取数量
	public String getAssetId() {
		return assetId;
	}
	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}
	public long getTs() {
		return ts;
	}
	public void setTs(long ts) {
		this.ts = ts;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
	
}
