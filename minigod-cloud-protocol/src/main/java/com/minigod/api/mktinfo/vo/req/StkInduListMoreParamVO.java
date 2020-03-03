/**
 * @Title: StkInduListMoreParamVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.vo.BaseVO;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2015-8-18 下午10:24:03
 * @version v1.0
 */

public class StkInduListMoreParamVO extends BaseVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer count;// 拉取的条数
	private String induCode;// 行业/概念id
	private Integer sortField;// 排序字段
	private String sortDir;// 排序方向
	private String mktCode;//市场

	public String getMktCode() {
		return mktCode;
	}

	public void setMktCode(String mktCode) {
		this.mktCode = mktCode;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getInduCode() {
		return induCode;
	}

	public void setInduCode(String induCode) {
		this.induCode = induCode;
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
