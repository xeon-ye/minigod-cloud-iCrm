/**
 * @Title: LastActiveMsgId.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo;

import java.io.Serializable;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-11-6 下午4:01:28
 * @version v1.0
 */

public class LastActiveGrpMsgId implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer grpMsgId;

	public Integer getGrpMsgId() {
		return grpMsgId;
	}

	public void setGrpMsgId(Integer grpMsgId) {
		this.grpMsgId = grpMsgId;
	}

}
