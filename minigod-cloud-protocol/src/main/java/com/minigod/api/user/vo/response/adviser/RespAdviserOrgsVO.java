package com.minigod.api.user.vo.response.adviser;

import java.io.Serializable;
import java.util.List;

/**
 * @Title: RespAdviserOrgs.java
 * @Description: 
 * @Copyright:  2015 minigod
 * @Company: minigod
 *
 * @author ken
 * @date 2015-7-13 下午5:20:15
 * @version v1.0
 */

public class RespAdviserOrgsVO implements Serializable {

	private static final long serialVersionUID = -1651584739271904264L;

	private List<AdviserOrgVO> updated;//添加或更新的数据List数据
	
	private List<Integer> removed;//删除的数据List数据
	
	private Integer lastVersion;

	public List<AdviserOrgVO> getUpdated() {
		return updated;
	}

	public void setUpdated(List<AdviserOrgVO> updated) {
		this.updated = updated;
	}

	public List<Integer> getRemoved() {
		return removed;
	}

	public void setRemoved(List<Integer> removed) {
		this.removed = removed;
	}

	public Integer getLastVersion() {
		return lastVersion;
	}

	public void setLastVersion(Integer lastVersion) {
		this.lastVersion = lastVersion;
	}
	
}
