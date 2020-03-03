package com.minigod.api.webApp.vo.req;

import java.io.Serializable;

/**
 * <code>GameFightEventJoinReqVO<code>
 * 
 * @author panlz 一战到底 获取参赛信息 初始化页面请求类
 * 
 */
public class GameFightEventJoinReqVO extends GameFightbaseReqVO implements Serializable {
	/**  */
	private static final long serialVersionUID = -5232267923290668354L;

	private String isJoinNext; // Y表示参加下一期

	public String getIsJoinNext() {
		return isJoinNext;
	}

	public void setIsJoinNext(String isJoinNext) {
		this.isJoinNext = isJoinNext;
	}

}
