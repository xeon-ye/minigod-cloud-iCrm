/**
 * @Title: SevenPtfPromotionRespVO.java
 * @Copyright: © 2016 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.resp;

import java.io.Serializable;
import java.util.List;

import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2016-1-4 下午4:24:42
 * @version v1.0
 */
@TransferBean
public class SevenPtfPromotionRespVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer status;
	@TransferID
	private List<SevenPtfPromotionRespVO_data> datas;
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<SevenPtfPromotionRespVO_data> getDatas() {
		return datas;
	}

	public void setDatas(List<SevenPtfPromotionRespVO_data> datas) {
		this.datas = datas;
	}

	@TransferBean
	public static class SevenPtfPromotionRespVO_data implements Serializable {
		private static final long serialVersionUID = 1L;
		
		@TransferID
		private String ptfId;
		private String userName;
		private String code;
		private Double targetYield;
		private Double price;
		private String ptfName;
		public String getPtfName() {
			return ptfName;
		}
		public void setPtfName(String ptfName) {
			this.ptfName = ptfName;
		}
		public Double getPrice() {
			return price;
		}
		public void setPrice(Double price) {
			this.price = price;
		}
		public String getPtfId() {
			return ptfId;
		}
		public void setPtfId(String ptfId) {
			this.ptfId = ptfId;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public Double getTargetYield() {
			return targetYield;
		}
		public void setTargetYield(Double targetYield) {
			this.targetYield = targetYield;
		}
	}
}
