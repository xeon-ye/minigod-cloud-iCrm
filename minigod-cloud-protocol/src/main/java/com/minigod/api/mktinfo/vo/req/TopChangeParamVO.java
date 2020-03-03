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
public class TopChangeParamVO extends BaseVO {// add by jjchou
	private static final long serialVersionUID = 4776251288536031081L;
	private Integer count;// 拉取的条数
	private Integer sortField;// 排序字段0-涨幅榜，1-跌幅榜，2-振幅榜，3-换手率榜
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
	public Integer getSortField() {
		return sortField;
	}
	public void setSortField(Integer sortField) {
		this.sortField = sortField;
	}
	public String getSortDir() {
		return sortDir;
	}
	public void setSortDir(String sortDir) {
		this.sortDir = sortDir;
	}
}
