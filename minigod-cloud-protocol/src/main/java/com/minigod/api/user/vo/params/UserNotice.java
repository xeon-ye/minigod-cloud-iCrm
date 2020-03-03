package com.minigod.api.user.vo.params;

import com.minigod.api.user.vo.SNUserBase;

public class UserNotice extends SNUserBase {
	private static final long serialVersionUID = -4136698025550129578L;
	
	private Long timestamp;//时间撮
	private Integer fetchCount;//一次获取数据的记录数
	//1当fetchDirection为0，请求created小于timestamp的消息（即拉取历史消息）
	//2当fetchDirection为1时，请求created大于timestamp的消息（即更新消息）
	private Integer fetchDirection;

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getFetchCount() {
		return fetchCount;
	}

	public void setFetchCount(Integer fetchCount) {
		this.fetchCount = fetchCount;
	}

	public Integer getFetchDirection() {
		return fetchDirection;
	}

	public void setFetchDirection(Integer fetchDirection) {
		this.fetchDirection = fetchDirection;
	}
}