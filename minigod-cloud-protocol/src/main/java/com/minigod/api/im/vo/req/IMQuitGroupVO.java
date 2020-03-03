/**
 * @Title: IMQuitGroupVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.req;

import com.minigod.api.vo.BaseVO;

/**
 * @description 
 *
 * @author Jimmy
 * @date 2015-8-16 下午1:00:44
 * @version v1.0
 */

public class IMQuitGroupVO extends BaseVO{
	private static final long serialVersionUID = 1L;
	
	private String groupId;
	private int isQg = 0;
	private String groupType;
	
	public String getGroupType() {
		return groupType;
	}

	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}

	public int getIsQg() {
		return isQg;
	}

	public void setIsQg(int isQg) {
		this.isQg = isQg;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
}
