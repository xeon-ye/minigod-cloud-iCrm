/**
 * @Title: IMCreateGroupRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.resp;

import java.io.Serializable;

/**
 * @description 
 *
 * @author Jimmy
 * @date 2015-8-15 下午2:25:46
 * @version v1.0
 */

public class IMCreateGroupRespVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String groupId; // 群组ID
	
	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
}
