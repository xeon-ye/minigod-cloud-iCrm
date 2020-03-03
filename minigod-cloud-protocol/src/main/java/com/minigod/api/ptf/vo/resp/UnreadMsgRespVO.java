/*
 * FileName: UnreadMsgRespVO.java
 * Copyright: Copyright 2014-12-7 MiniGod Tech. Co. Ltd.All right reserved.
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
 * 
 * @description 这里描述类的用处
 *
 * @author MiniGod
 * @date 2015-4-17 下午4:24:08
 * @version v1.0
 */
@TransferBean
public class UnreadMsgRespVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@TransferID
	@Emoji
	private List<UnReadMsgRespVO_Data_Orign> data;
	private Long version;
	private Integer unreadCount;

	public Integer getUnreadCount() {
		return unreadCount;
	}
	public void setUnreadCount(Integer unreadCount) {
		this.unreadCount = unreadCount;
	}
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	public List<UnReadMsgRespVO_Data_Orign> getData() {
		return data;
	}
	public void setData(List<UnReadMsgRespVO_Data_Orign> data) {
		this.data = data;
	}
	
	

	@TransferBean
	public static class UnReadMsgRespVO_Data_EncodeRelaId extends UnReadMsgRespVO_Data_Orign  implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		@TransferID
		private Long relaId;
		
		public Long getRelaId() {
			return relaId;
		}
		public void setRelaId(Long relaId) {
			this.relaId = relaId;
		}
	}

	
	@TransferBean
	public static class UnReadMsgRespVO_Data_NotEncodeRelaId extends UnReadMsgRespVO_Data_Orign implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Long relaId;
		
		public Long getRelaId() {
			return relaId;
		}
		public void setRelaId(Long relaId) {
			this.relaId = relaId;
		}
	}
	
	@TransferBean
	public static class UnReadMsgRespVO_Data_Orign  implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = -5477671317891610778L;
		private Integer msgId;
		private Long version;
		private String msgType;
		private String title;
		@Emoji
		private String msgCon;
		
		@TransferID
		private Long ptfId;
		private String relaType;
		@Emoji
		private String relaText;
		@TransferID
		private Long uId;
		private String uImg;
		@Emoji
		private String uName;
		private Integer uType;
		private Long ts;
		private Integer isRead; // 信息是否已读
		public Integer getMsgId() {
			return msgId;
		}
		public void setMsgId(Integer msgId) {
			this.msgId = msgId;
		}
		public String getMsgType() {
			return msgType;
		}
		public void setMsgType(String msgType) {
			this.msgType = msgType;
		}
		public String getMsgCon() {
			return msgCon;
		}
		public void setMsgCon(String msgCon) {
			this.msgCon = msgCon;
		}

		public Long getPtfId() {
			return ptfId;
		}
		public void setPtfId(Long ptfId) {
			this.ptfId = ptfId;
		}
		public String getRelaType() {
			return relaType;
		}
		public void setRelaType(String relaType) {
			this.relaType = relaType;
		}
		public String getRelaText() {
			return relaText;
		}
		public void setRelaText(String relaText) {
			this.relaText = relaText;
		}
		public Long getuId() {
			return uId;
		}
		public void setuId(Long uId) {
			this.uId = uId;
		}
		public String getuImg() {
			return uImg;
		}
		public void setuImg(String uImg) {
			this.uImg = uImg;
		}
		public String getuName() {
			return uName;
		}
		public void setuName(String uName) {
			this.uName = uName;
		}
		public Integer getuType() {
			return uType;
		}
		public void setuType(Integer uType) {
			this.uType = uType;
		}
		public Long getTs() {
			return ts;
		}
		public void setTs(Long ts) {
			this.ts = ts;
		}
		public Integer getIsRead() {
			return isRead;
		}
		public void setIsRead(Integer isRead) {
			this.isRead = isRead;
		}
		public Long getVersion() {
			return version;
		}
		public void setVersion(Long version) {
			this.version = version;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
	}
}
