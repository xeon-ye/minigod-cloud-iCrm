/**
 * @Title: GiftContentRespVO.java
 * @Copyright: © 2015 minigod
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
 * @date 2015-8-3 上午10:07:03
 * @version v1.0
 */
@TransferBean
public class GiftContentRespVO implements Serializable {
	private static final long serialVersionUID = 1L;
	@TransferID
	private List<GiftContentRespVO_data> datas;
	
	public List<GiftContentRespVO_data> getDatas() {
		return datas;
	}

	public void setDatas(List<GiftContentRespVO_data> datas) {
		this.datas = datas;
	}

	@TransferBean
	public static class GiftContentRespVO_data{
		@TransferID
		private String giftId;
		private String giftImg;
		private String giftDes;
		private Integer goldNum;
		private Integer giftNum;
		private Integer isStatus;
		public String getGiftId() {
			return giftId;
		}
		public void setGiftId(String giftId) {
			this.giftId = giftId;
		}
		public String getGiftDes() {
			return giftDes;
		}
		public void setGiftDes(String giftDes) {
			this.giftDes = giftDes;
		}
		public Integer getGoldNum() {
			return goldNum;
		}
		public void setGoldNum(Integer goldNum) {
			this.goldNum = goldNum;
		}
		public Integer getGiftNum() {
			return giftNum;
		}
		public void setGiftNum(Integer giftNum) {
			this.giftNum = giftNum;
		}
		public String getGiftImg() {
			return giftImg;
		}
		public void setGiftImg(String giftImg) {
			this.giftImg = giftImg;
		}
		public Integer getIsStatus() {
			return isStatus;
		}
		public void setIsStatus(Integer isStatus) {
			this.isStatus = isStatus;
		}
	}
}
