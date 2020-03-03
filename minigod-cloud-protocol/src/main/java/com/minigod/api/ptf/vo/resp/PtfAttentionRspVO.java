/*
 * FileName: PtfFollowerRspVO.java
 * Copyright: Copyright 2014-12-5 MiniGod Tech. Co. Ltd.All right reserved.
 * Description: 
 *
 */
package com.minigod.api.ptf.vo.resp;

import java.io.Serializable;
import java.util.List;

import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;
/**
 * <code>PtfFollowerRspVO<code>
 *
 * @author Jimmy
 * @since  MiniGod v0.0.1 (2014-12-5)
 *
 */
@TransferBean
public class PtfAttentionRspVO implements Serializable{
	/**  */
	private static final long serialVersionUID = -5232267923290668354L;
	

	private String isOwn;
	@TransferID
	private Long oId;
	@Emoji
	private String oName;
	private Integer oType;
	private int total;
	private Integer stranger;

	@TransferID
	@Emoji
	private List<PtfAttentionRspVO_Follower> users;

	public Long getoId() {
		return oId;
	}

	public void setoId(Long oId) {
		this.oId = oId;
	}

	public String getIsOwn() {
		return isOwn;
	}

	public void setIsOwn(String isOwn) {
		this.isOwn = isOwn;
	}

	public String getoName() {
		return oName;
	}

	public void setoName(String oName) {
		this.oName = oName;
	}
	
	public Integer getoType() {
		return oType;
	}

	public void setoType(Integer oType) {
		this.oType = oType;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Integer getStranger() {
		return stranger;
	}

	public void setStranger(Integer stranger) {
		this.stranger = stranger;
	}

	public List<PtfAttentionRspVO_Follower> getUsers() {
		return users;
	}

	public void setUsers(List<PtfAttentionRspVO_Follower> users) {
		this.users = users;
	}

	/**
	 * <code>Follower<code>
	 */
	@TransferBean
	public static class PtfAttentionRspVO_Follower implements Serializable{
		private static final long serialVersionUID = 4783257545972080086L;
		
		@TransferID
		private Long uId;
		@Emoji
		private String uName;
		private String uImg;
		private Integer uType;
		
		public Long getuId() {
			return uId;
		}
		public void setuId(Long uId) {
			this.uId = uId;
		}
		public String getuName() {
			return uName;
		}
		public void setuName(String uName) {
			this.uName = uName;
		}
		public String getuImg() {
			return uImg;
		}
		public void setuImg(String uImg) {
			this.uImg = uImg;
		}
		public Integer getuType() {
			return uType;
		}
		public void setuType(Integer uType) {
			this.uType = uType;
		}
		
		
		
	}
}
