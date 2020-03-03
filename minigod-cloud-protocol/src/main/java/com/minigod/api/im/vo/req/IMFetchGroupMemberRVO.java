/**
 * @Title: IMFetchGroupMemberVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.req;

import com.minigod.api.vo.BaseVO;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-8-16 下午1:07:50
 * @version v1.0
 */

public class IMFetchGroupMemberRVO extends BaseVO {
	private static final long serialVersionUID = 1L;

	private String groupId;
	@Deprecated
	private Integer readVersion;
	@Deprecated
	private Integer limitNum;

	private Integer pageCount; // 页大小
	private Integer pageNo; // 页码

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public Integer getReadVersion() {
		return readVersion;
	}

	public void setReadVersion(Integer readVersion) {
		this.readVersion = readVersion;
	}

	public Integer getLimitNum() {
		return limitNum;
	}

	public void setLimitNum(Integer limitNum) {
		this.limitNum = limitNum;
	}
}
