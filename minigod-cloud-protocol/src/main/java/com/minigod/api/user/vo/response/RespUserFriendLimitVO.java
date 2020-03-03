package com.minigod.api.user.vo.response;

import java.io.Serializable;

/**
 * 获取好友上限值、好友个数、好友能添加的剩余数量
 */

public class RespUserFriendLimitVO implements Serializable {

	private static final long serialVersionUID = 340831528495266018L;

	private Integer fdLim;//好友上限值
	private Integer addFds;//已添加好友数量
	
	public Integer getFdLim() {
		return fdLim;
	}
	public void setFdLim(Integer fdLim) {
		this.fdLim = fdLim;
	}
	public Integer getAddFds() {
		return addFds;
	}
	public void setAddFds(Integer addFds) {
		this.addFds = addFds;
	}
	

}
