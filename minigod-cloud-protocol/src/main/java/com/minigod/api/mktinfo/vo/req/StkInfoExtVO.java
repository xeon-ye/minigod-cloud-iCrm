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
public class StkInfoExtVO extends BaseVO {
	private static final long serialVersionUID = 1L;
	/** 资产ID */
	private String assetId;
	private Integer count;// 拉取的条数，分页查询的话是每页的条数
	private String sortField;// 排序字段
	private String sortDir;// 排序方向
	private Integer page;//当前页

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

	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public String getSortDir() {
		return sortDir;
	}

	public void setSortDir(String sortDir) {
		this.sortDir = sortDir;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}
}
