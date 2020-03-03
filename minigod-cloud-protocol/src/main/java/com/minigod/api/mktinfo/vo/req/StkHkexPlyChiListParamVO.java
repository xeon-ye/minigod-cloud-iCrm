package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.vo.BaseVO;

/**
 * @description
 * 
 * @author PENGFENG
 * @date 2017-4-6
 * @version v2.0
 */

public class StkHkexPlyChiListParamVO extends BaseVO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String assetId;
	private Integer type;
	private Integer count;
	private Integer pageCount;
	private Integer pageNow;
	public String getAssetId() {
		return assetId;
	}
	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public Integer getPageNow() {
		return pageNow;
	}
	public void setPageNow(Integer pageNow) {
		this.pageNow = pageNow;
	}
	 
	 
	
	
}
