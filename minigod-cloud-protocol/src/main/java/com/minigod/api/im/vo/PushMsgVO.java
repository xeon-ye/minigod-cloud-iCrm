/**
 * @Title: PushMsgVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo;

import java.io.Serializable;

/**
 * @description 
 *
 * @author Jimmy
 * @date 2015-12-16 下午3:29:06
 * @version v1.0
 */

public class PushMsgVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String action;
	
	private Object pushContent;
	
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Object getPushContent() {
		return pushContent;
	}
	public void setPushContent(Object pushContent) {
		this.pushContent = pushContent;
	}
}
