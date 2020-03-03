/*
 * FileName: UnreadMsgVO.java
 * Copyright: Copyright 2014-12-4 MiniGod Tech. Co. Ltd.All right reserved.
 * Description: 
 *
 */
package com.minigod.api.ptf.vo.req;

import com.minigod.api.vo.BaseVO;

/**
 * 
 * @description 这里描述类的用处
 *
 * @author MiniGod
 * @date 2015-4-11 下午4:00:22
 * @version v1.0
 */
public class UnreadMsgVO extends BaseVO{
	/**  */
	private static final long serialVersionUID = 3464825410615914588L;
	
	private Long locateVersion;
	private Integer count;
	private Integer messageGroup;
	
	private Long version;//用于兼容旧版拉取投资圈的形式
	

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Long getLocateVersion() {
		return locateVersion;
	}

	public void setLocateVersion(Long locateVersion) {
		this.locateVersion = locateVersion;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getMessageGroup() {
		return messageGroup;
	}

	public void setMessageGroup(Integer messageGroup) {
		this.messageGroup = messageGroup;
	}

}
