/**
 * @Title: NiuUserInfo.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.user.vo.response;

import java.io.Serializable;
import java.util.List;

import com.minigod.security.SecurityKey;
import com.minigod.security.util.IDTransUtil;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-6-15 下午7:18:36
 * @version v1.0
 */

public class NiuUserInfoRespVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer adId;
	private List<NiuUserInfoRespVO_Datas> datas;
	
	public Integer getAdId() {
		return adId;
	}

	public void setAdId(Integer adId) {
		this.adId = adId;
	}

	public List<NiuUserInfoRespVO_Datas> getDatas() {
		return datas;
	}

	public void setDatas(List<NiuUserInfoRespVO_Datas> datas) {
		this.datas = datas;
	}

	public static class NiuUserInfoRespVO_Datas implements Serializable{
		private static final long serialVersionUID = 1L;
		
		private String userId;
		private String uName;
		private String uImg;
		private String sig;
		private Integer friNum;
		private String ptfName;
		private String desc;
		private Double mYield;
		private String isAdd;
		private String yieldType;
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
		public Integer getFriNum() {
			return friNum;
		}
		public void setFriNum(Integer friNum) {
			this.friNum = friNum;
		}
		public String getPtfName() {
			return ptfName;
		}
		public void setPtfName(String ptfName) {
			this.ptfName = ptfName;
		}
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
		public Double getmYield() {
			return mYield;
		}
		public void setmYield(Double mYield) {
			this.mYield = mYield;
		}
		public String getIsAdd() {
			return isAdd;
		}
		public void setIsAdd(String isAdd) {
			this.isAdd = isAdd;
		}
		public String getYieldType() {
			return yieldType;
		}
		public void setYieldType(String yieldType) {
			this.yieldType = yieldType;
		}
	}
}
