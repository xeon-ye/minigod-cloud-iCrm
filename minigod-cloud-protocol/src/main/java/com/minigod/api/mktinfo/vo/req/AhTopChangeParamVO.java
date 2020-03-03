package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.vo.BaseVO;

import java.util.List;


/**
 * @author jjchou
 * @version v1.0
 * @project: minigod
 * @description:
 * @copyright:2017
 * @company: 
 * 2017年6月19日
 */
public class AhTopChangeParamVO extends BaseVO {
	private static final long serialVersionUID = 4776251288536031081L;
	private Integer count;// 拉取的条数
	private String market;// 
	private String sortDir;// 排序方向
	private String assetId;//资产ID
	public String getAssetId() {
		return assetId;
	}
	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getSortDir() {
		return sortDir;
	}
	public void setSortDir(String sortDir) {
		this.sortDir = sortDir;
	}
	public String getMarket() {
		return market;
	}
	public void setMarket(String market) {
		this.market = market;
	}

	
}
