/**
 * @Title: IMFetchGroupMemberRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.resp;

import java.io.Serializable;
import java.util.List;

import com.minigod.api.im.vo.resp.IMFetchGroupMemberVO;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-8-16 下午1:17:37
 * @version v1.0
 */
@TransferBean
public class IMFetchGroupMemberRespVO implements Serializable {
	private static final long serialVersionUID = 1L;
	@TransferID
	private List<IMFetchGroupMemberVO> data;
	@Deprecated
	private Integer readVersion;

	private Integer totalPage;

	private Integer pageNo;

	private Integer memberCount; // 人数

	public Integer getMemberCount() {
		return memberCount;
	}

	public void setMemberCount(Integer memberCount) {
		this.memberCount = memberCount;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getReadVersion() {
		return readVersion;
	}

	public void setReadVersion(Integer readVersion) {
		this.readVersion = readVersion;
	}

	public List<IMFetchGroupMemberVO> getData() {
		return data;
	}

	public void setData(List<IMFetchGroupMemberVO> data) {
		this.data = data;
	}
}
