/*
 * FileName: InvestMsgRespVO.java
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
 * @description 投资圈消息列表返回类 minigod證券國際pc版
 *
* @author panlz
 * @date 2015-7-23 下午4:00:37
 * @version v1.0
 */
@TransferBean
public class InvestMsgRespVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	//增量拉取历史的版本号,加载更多此版本作为参数传给后端
	private Long incVersion;
	//上传的版本号,将此版本号上传到服务器
	private Long uploadVersion;
	//投资圈未读消息数量
	private Integer unReadCnt;
	
	@TransferID
	@Emoji
	private List<InvestMsgRespVO_Data> data;
	
	public Long getIncVersion() {
		return incVersion;
	}
	public void setIncVersion(Long incVersion) {
		this.incVersion = incVersion;
	}
	public Long getUploadVersion() {
		return uploadVersion;
	}
	public void setUploadVersion(Long uploadVersion) {
		this.uploadVersion = uploadVersion;
	}
	public Integer getUnReadCnt() {
		return unReadCnt;
	}
	public void setUnReadCnt(Integer unReadCnt) {
		this.unReadCnt = unReadCnt;
	}
	public List<InvestMsgRespVO_Data> getData() {
		return data;
	}
	public void setData(List<InvestMsgRespVO_Data> data) {
		this.data = data;
	}

	@TransferBean
	public static class InvestMsgRespVO_Data  implements Serializable{
		
		private static final long serialVersionUID = 1L;
		
		private Integer msgId;
		private String msgType;
		@Emoji
		private String msgCon;
		private Long relaId;
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
		public Long getRelaId() {
			return relaId;
		}
		public void setRelaId(Long relaId) {
			this.relaId = relaId;
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
	}
}
