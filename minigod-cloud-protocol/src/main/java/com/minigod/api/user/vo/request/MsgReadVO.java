package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.MsgRead;
import com.minigod.api.user.vo.SNVersion;

/**
 * @Title: MsgReadVO.java
 * @Description: 消息已读请求对象
 * @Copyright: © 2015 minigod
 * @Company: minigod
 *
 * @author minigod
 * @date 2015-1-4 下午8:05:40
 * @version v1.0
 */

public class MsgReadVO extends SNVersion {
	
	private static final long serialVersionUID = 1L;
	
	private MsgRead params;

	public MsgRead getParams() {
		return params;
	}

	public void setParams(MsgRead params) {
		this.params = params;
	}
	
}
