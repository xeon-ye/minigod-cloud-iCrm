/**
 * @Title: IMFetchGroupListRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.resp;

import java.io.Serializable;
import java.util.List;

import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-8-21 下午3:53:10
 * @version v1.0
 */
@TransferBean
public class IMFetchGroupListRespVO implements Serializable {
	/** */
	private static final long serialVersionUID = 1L;
	@Emoji
	@TransferID
	private List<IMFetchGroupListVO> add;
	@Emoji
	@TransferID
	private List<IMFetchGroupListVO> update;

	private List<String> delete;

	private Long maxVersion;
	
	private Integer groupCount;// 当前用户创建群数量
	
	private Integer maxGroupCount; // 当前用户可创建的最大群数量

	public Integer getMaxGroupCount() {
		return maxGroupCount;
	}

	public void setMaxGroupCount(Integer maxGroupCount) {
		this.maxGroupCount = maxGroupCount;
	}

	public Integer getGroupCount() {
		return groupCount;
	}

	public void setGroupCount(Integer groupCount) {
		this.groupCount = groupCount;
	}

	public List<IMFetchGroupListVO> getAdd() {
		return add;
	}

	public void setAdd(List<IMFetchGroupListVO> add) {
		this.add = add;
	}

	public List<IMFetchGroupListVO> getUpdate() {
		return update;
	}

	public void setUpdate(List<IMFetchGroupListVO> update) {
		this.update = update;
	}

	public List<String> getDelete() {
		return delete;
	}

	public void setDelete(List<String> delete) {
		this.delete = delete;
	}

	public Long getMaxVersion() {
		return maxVersion;
	}

	public void setMaxVersion(Long maxVersion) {
		this.maxVersion = maxVersion;
	}
}
