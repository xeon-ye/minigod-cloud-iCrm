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
public class PtfFollowerRspVO implements Serializable{
	/**  */
	private static final long serialVersionUID = -5232267923290668354L;
	

	private int total;

	@TransferID
	@Emoji
	private List<PtfFollowerRspVO_Follower> users;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<PtfFollowerRspVO_Follower> getUsers() {
		return users;
	}

	public void setUsers(List<PtfFollowerRspVO_Follower> users) {
		this.users = users;
	}

	/**
	 * <code>Follower<code>
	 */
	@TransferBean
	public static class PtfFollowerRspVO_Follower implements Serializable{
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
