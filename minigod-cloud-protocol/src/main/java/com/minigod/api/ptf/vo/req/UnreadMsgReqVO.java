/*
 * FileName: UnreadMsgReqVO.java
 * Copyright: Copyright 2014-12-4 MiniGod Tech. Co. Ltd.All right reserved.
 * Description: 
 *
 */
package com.minigod.api.ptf.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * 
 * @description 这里描述类的用处
 *
 * @author MiniGod
 * @date 2015-4-11 下午4:00:37
 * @version v1.0
 */
public class   UnreadMsgReqVO extends SNVersion {
	/**  */
	private static final long serialVersionUID = 5056919075607046478L;

	private UnreadMsgVO params;

	public UnreadMsgVO getParams() {
		return params;
	}

	public void setParams(UnreadMsgVO params) {
		this.params = params;
	}
	
}
