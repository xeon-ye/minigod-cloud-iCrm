package com.minigod.api.user.vo.response;

import java.io.Serializable;
import java.util.List;

import com.minigod.api.user.vo.response.RespFriendVO;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;
@TransferBean
public class RespFriendInfoVO implements Serializable {

	private static final long serialVersionUID = 3176672955281189535L;

	private Long lastVersion;
	
	@TransferID
	@Emoji
	private List<RespFriendVO> added;//添加的用户
	
	@TransferID
	private List<Long> removed;//删除的用户，解除关系的用户，使用的是消息的id
	
	@TransferID
	@Emoji
	private List<RespFriendVO> updated;//修改的用户
	
	@TransferID
	@Emoji
	private List<RespFriendVO> nfs ;//返回前端的数据集

	public Long getLastVersion() {
		return lastVersion;
	}

	public void setLastVersion(Long lastVersion) {
		this.lastVersion = lastVersion;
	}

	public List<RespFriendVO> getAdded() {
		return added;
	}

	public void setAdded(List<RespFriendVO> added) {
		this.added = added;
	}

	public List<Long> getRemoved() {
		return removed;
	}

	public void setRemoved(List<Long> removed) {
		this.removed = removed;
	}

	public List<RespFriendVO> getUpdated() {
		return updated;
	}

	public void setUpdated(List<RespFriendVO> updated) {
		this.updated = updated;
	}

	public List<RespFriendVO> getNfs() {
		return nfs;
	}

	public void setNfs(List<RespFriendVO> nfs) {
		this.nfs = nfs;
	}
	
	
}
