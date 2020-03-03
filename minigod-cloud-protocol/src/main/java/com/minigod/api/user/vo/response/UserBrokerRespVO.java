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

public class UserBrokerRespVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private List<UserBrokerRespVO_data> data;
	
	public List<UserBrokerRespVO_data> getData() {
		return data;
	}
	public void setData(List<UserBrokerRespVO_data> data) {
		this.data = data;
	}

	public static class UserBrokerRespVO_data{
		private Integer brkId;
		private String brkName;
		private String brkIcon;
		private Integer isCut;
		private String depAcc;
		public Integer getBrkId() {
			return brkId;
		}
		public void setBrkId(Integer brkId) {
			this.brkId = brkId;
		}
		public String getBrkName() {
			return brkName;
		}
		public void setBrkName(String brkName) {
			this.brkName = brkName;
		}
		public String getBrkIcon() {
			return brkIcon;
		}
		public void setBrkIcon(String brkIcon) {
			this.brkIcon = brkIcon;
		}
		public Integer getIsCut() {
			return isCut;
		}
		public void setIsCut(Integer isCut) {
			this.isCut = isCut;
		}
		public String getDepAcc() {
			return depAcc;
		}
		public void setDepAcc(String depAcc) {
			this.depAcc = depAcc;
		}
		
	}
}
