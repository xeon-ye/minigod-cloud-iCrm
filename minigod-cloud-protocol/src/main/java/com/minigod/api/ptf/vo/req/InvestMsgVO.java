/*
 * FileName: InvestMsgVO.java
 * Copyright: Copyright 2014-12-4 MiniGod Tech. Co. Ltd.All right reserved.
 * Description: 
 *
 */
package com.minigod.api.ptf.vo.req;

import com.minigod.api.vo.BaseVO;

/**
 * 
 * @description 获取投资圈消息列表请求类 minigod證券國際PC版
 *
 * @author panlz
 * @date 2015-7-23 下午4:00:37
 * @version v1.0
 */
public class InvestMsgVO extends BaseVO{
	/**  */
	private static final long serialVersionUID = 3464825410615914588L;
	
	private Long version;
	private Integer count ;

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
}
