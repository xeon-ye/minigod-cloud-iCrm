/**
 * @Title: AddNiuFriendRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.user.vo.response;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description
 * 
 * @author MiniGod
 * @date 2015-6-16 下午5:27:55
 * @version v1.0
 */
@TransferBean
public class ReqInterfaceUpdateRespVO implements Serializable {
	private static final long serialVersionUID = 1L;
	@TransferID
	private List<UpdInfo> updInfo;

	public List<UpdInfo> getUpdInfo() {
		return updInfo;
	}

	public void setUpdInfo(List<UpdInfo> updInfo) {
		this.updInfo = updInfo;
	}

	@TransferBean
	public static class UpdInfo implements Serializable {

		private static final long serialVersionUID = 1L;

		private String name;
		private String value;
		private Integer count;
		private String lastMsg; 
		private Date lastMsgTime;
		private Long maxMsgVersion = 0l;
		
		@TransferID
		private List<UserIdUnReadNum> sec ;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public Integer getCount() {
			return count;
		}

		public void setCount(Integer count) {
			this.count = count;
		}

		public List<UserIdUnReadNum> getSec() {
			return sec;
		}

		public void setSec(List<UserIdUnReadNum> sec) {
			this.sec = sec;
		}

		public String getLastMsg() {
			return lastMsg;
		}

		public void setLastMsg(String lastMsg) {
			this.lastMsg = lastMsg;
		}

		public Date getLastMsgTime() {
			return lastMsgTime;
		}

		public void setLastMsgTime(Date lastMsgTime) {
			this.lastMsgTime = lastMsgTime;
		}

		public Long getMaxMsgVersion() {
			return maxMsgVersion;
		}

		public void setMaxMsgVersion(Long maxMsgVersion) {
			this.maxMsgVersion = maxMsgVersion;
		}
	}

	@TransferBean
	public static class UserIdUnReadNum implements Serializable {

		private static final long serialVersionUID = 1L;
		@TransferID
		private Long userId; // 用户ID
		private Integer count; // 未读数

		public Long getUserId() {
			return userId;
		}

		public void setUserId(Long userId) {
			this.userId = userId;
		}

		public Integer getCount() {
			return count;
		}

		public void setCount(Integer count) {
			this.count = count;
		}
	}

}
