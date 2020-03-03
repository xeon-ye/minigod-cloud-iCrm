/**
 * @Title: AdInvestmentAdviserRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.user.vo.response;

import java.io.Serializable;
import java.util.List;

import com.minigod.security.SecurityKey;
import com.minigod.security.util.IDTransUtil;

/**
 * @description 投顾活动返回值对象
 * 
 * @author minigod
 * @date 2015-7-21 上午11:28:41
 * @version v1.0
 */

public class AdInvestmentAdviserRespVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer adId;
	private List<InvestmentAdviserRespVO_Datas> datas;

	public Integer getAdId() {
		return adId;
	}

	public void setAdId(Integer adId) {
		this.adId = adId;
	}

	public List<InvestmentAdviserRespVO_Datas> getDatas() {
		return datas;
	}

	public void setDatas(List<InvestmentAdviserRespVO_Datas> datas) {
		this.datas = datas;
	}

	public static class InvestmentAdviserRespVO_Datas implements Serializable {
		private static final long serialVersionUID = 1L;

		private String userId;
		private String uName;
		private String uImg;
		private String sig;
		private String type;

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = IDTransUtil.encodeId(Long.valueOf(userId), SecurityKey.ID_KEY).toString();
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

		public String getSig() {
			return sig;
		}

		public void setSig(String sig) {
			this.sig = sig;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

	}

}
