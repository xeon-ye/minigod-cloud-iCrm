/*
 * FileName: StkVersionVO.java
 * Copyright: Copyright 2014-11-13 MiniGod Tech. Co. Ltd.All right reserved.
 * Description: 
 *
 */
package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.vo.BaseVO;
/**
 * <code>StkVersionVO<code>
 *
 * @author Jimmy
 * @since  MiniGod v0.0.1 (2014-11-13)
 *
 */
public class StkVersionVO extends BaseVO{
	/**  */
	private static final long serialVersionUID = 5625495880027017495L;
	
	private Integer version;
	//
	private Integer currentPage; // 当前页，第一页为1
	private Integer pageSize; // 每页大小

	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
}
