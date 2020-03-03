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

public class AdLinkRespVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private List<AdLinkRespVO_data> posCodes; 
	
	public List<AdLinkRespVO_data> getPosCodes() {
		return posCodes;
	}

	public void setPosCodes(List<AdLinkRespVO_data> posCodes) {
		this.posCodes = posCodes;
	}

	public static class AdLinkRespVO_data{
		private Integer posCode;
		private Integer adId;
		private String url;
		private String img;
		private String desc;
		
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
		public String getImg() {
			return img;
		}
		public void setImg(String img) {
			this.img = img;
		}
		public Integer getPosCode() {
			return posCode;
		}
		public void setPosCode(Integer posCode) {
			this.posCode = posCode;
		}
		public Integer getAdId() {
			return adId;
		}
		public void setAdId(Integer adId) {
			this.adId = adId;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
	}
	
	
}
