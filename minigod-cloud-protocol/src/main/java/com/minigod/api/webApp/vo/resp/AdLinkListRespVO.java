/**
 * @Title: AdLinkListRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.resp;

import java.io.Serializable;
import java.util.List;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-12-28 上午10:24:28
 * @version v1.0
 */

public class AdLinkListRespVO implements Serializable{
	private static final long serialVersionUID = 1L;

	private List<AdLinkListRespVO_data> datas;
	
	public List<AdLinkListRespVO_data> getDatas() {
		return datas;
	}
	public void setDatas(List<AdLinkListRespVO_data> datas) {
		this.datas = datas;
	}

	public static class AdLinkListRespVO_data implements Serializable{
		private static final long serialVersionUID = 1L;
		
		private String adImg;
		private String adUrl;
		private Integer adId;
		public String getAdImg() {
			return adImg;
		}
		public void setAdImg(String adImg) {
			this.adImg = adImg;
		}
		public String getAdUrl() {
			return adUrl;
		}
		public void setAdUrl(String adUrl) {
			this.adUrl = adUrl;
		}
		public Integer getAdId() {
			return adId;
		}
		public void setAdId(Integer adId) {
			this.adId = adId;
		}
	}
}
