/**
 * @Title: AdViwePagerVO.java
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
 * @date 2015-10-12 上午10:25:01
 * @version v1.0
 */

public class AdViwePagerRespVO implements Serializable{
	private static final long serialVersionUID = 1L;

	private List<AdViwePagerRespVO_data> datas;
	
	public List<AdViwePagerRespVO_data> getDatas() {
		return datas;
	}

	public void setDatas(List<AdViwePagerRespVO_data> datas) {
		this.datas = datas;
	}

	public static class AdViwePagerRespVO_data implements Serializable{
		private static final long serialVersionUID = 1L;
		
		private Integer adId;
		private String adImg;
		private String adUrl;
		public Integer getAdId() {
			return adId;
		}
		public void setAdId(Integer adId) {
			this.adId = adId;
		}
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
	}
}
