/**
 * @Title: SysMsgRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.user.vo.response;

import java.io.Serializable;
import java.util.List;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-4-22 下午4:38:21
 * @version v1.0
 */

public class SysMsgRespVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long version;
	private List<SysMsgRespVO_data> data;
	
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}

	public List<SysMsgRespVO_data> getData() {
		return data;
	}
	public void setData(List<SysMsgRespVO_data> data) {
		this.data = data;
	}

	public static class SysMsgRespVO_data{
		private Long msgId;
		private String url;
		private String msgTitle;
		private String msgType;
		private Long ts;
		private Integer isRead;
		private Integer status;
		private String msgLev;
		public String getMsgLev() {
			return msgLev;
		}
		public void setMsgLev(String msgLev) {
			this.msgLev = msgLev;
		}
		public Integer getStatus() {
			return status;
		}
		public void setStatus(Integer status) {
			this.status = status;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getMsgTitle() {
			return msgTitle;
		}
		public void setMsgTitle(String msgTitle) {
			this.msgTitle = msgTitle;
		}
		public String getMsgType() {
			return msgType;
		}
		public void setMsgType(String msgType) {
			this.msgType = msgType;
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
		public Long getMsgId() {
			return msgId;
		}
		public void setMsgId(Long msgId) {
			this.msgId = msgId;
		}
		
		
	}
}
