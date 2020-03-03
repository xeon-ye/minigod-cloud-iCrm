/**
 * @Title: GrpReqUnreadHolderVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo;

import com.minigod.api.im.vo.GrpReqUnreadCountVO;

import java.util.Date;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-12-2 下午6:39:19
 * @version v1.0
 */

public class GrpReqUnreadHolderVO extends GrpReqUnreadCountVO {
	private static final long serialVersionUID = 1L;
	private Date lastTime;
	private String lastMsg;

	public Date getLastTime() {
		return lastTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}

	public String getLastMsg() {
		return lastMsg;
	}

	public void setLastMsg(String lastMsg) {
		this.lastMsg = lastMsg;
	}

}
