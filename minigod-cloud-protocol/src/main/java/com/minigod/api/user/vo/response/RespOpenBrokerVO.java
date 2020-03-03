/**
 * @Title: RespOpenBrokerVO.java
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
 * @date 2015-4-23 下午8:11:08
 * @version v1.0
 */

public class RespOpenBrokerVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<RespOpenBrokerVO_data> data;

	public List<RespOpenBrokerVO_data> getData() {
		return data;
	}

	public void setData(List<RespOpenBrokerVO_data> data) {
		this.data = data;
	}

	public static class RespOpenBrokerVO_data {
		private Integer brkId;
		private String brkName;
		private String brkIcon;
		private List<String> uIcons;
		private Integer num;
		private String markName;
		private String markUrl;
		private String openUrl;
		private Integer isOpen;
		private String appCode;

		public Integer getBrkId() {
			return brkId;
		}

		public void setBrkId(Integer brkId) {
			this.brkId = brkId;
		}

		public String getAppCode() {
			return appCode;
		}

		public void setAppCode(String appCode) {
			this.appCode = appCode;
		}

		public Integer getIsOpen() {
			return isOpen;
		}

		public void setIsOpen(Integer isOpen) {
			this.isOpen = isOpen;
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

		public List<String> getuIcons() {
			return uIcons;
		}

		public void setuIcons(List<String> uIcons) {
			this.uIcons = uIcons;
		}

		public Integer getNum() {
			return num;
		}

		public void setNum(Integer num) {
			this.num = num;
		}

		public String getMarkName() {
			return markName;
		}

		public void setMarkName(String markName) {
			this.markName = markName;
		}

		public String getMarkUrl() {
			return markUrl;
		}

		public void setMarkUrl(String markUrl) {
			this.markUrl = markUrl;
		}

		public String getOpenUrl() {
			return openUrl;
		}

		public void setOpenUrl(String openUrl) {
			this.openUrl = openUrl;
		}
	}
}
