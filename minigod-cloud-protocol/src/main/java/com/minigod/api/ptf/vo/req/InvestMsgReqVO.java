/*
 * FileName: InvestMsgReqVO.java
 * Copyright: Copyright 2014-12-4 MiniGod Tech. Co. Ltd.All right reserved.
 * Description: 
 *
 */
package com.minigod.api.ptf.vo.req;

import com.minigod.api.user.vo.SNVersion;

/**
 * 
 * @description 获取投资圈消息列表请求类 minigod證券國際PC版
 *
 * @author panlz
 * @date 2015-7-23 下午4:00:37
 * @version v1.0
 */
public class   InvestMsgReqVO extends SNVersion {
	/**  */
	private static final long serialVersionUID = 5056919075607046478L;

	private InvestMsgVO params;

	public InvestMsgVO getParams() {
		return params;
	}

	public void setParams(InvestMsgVO params) {
		this.params = params;
	}
	
}
