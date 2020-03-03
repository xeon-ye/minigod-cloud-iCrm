/**
 * @Title: BrokerLoginInfoRequestVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.req;

import java.math.BigDecimal;
import java.util.Date;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.vo.BaseVO;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

@TransferBean
public class ApplySubscribeOrderRequestVO extends SNVersion {

	private static final long serialVersionUID = 1L;
	@TransferID
	private ApplySubscribeOrderVO params;

	public ApplySubscribeOrderVO getParams() {
		return params;
	}

	public void setParams(ApplySubscribeOrderVO params) {
		this.params = params;
	}
	
	@TransferBean
	public static class ApplySubscribeOrderVO extends BaseVO {
		private static final long serialVersionUID = 1L;
		
		@TransferID
		private Long ptfId;//组合ID
		private String ptfName;//组合名	String	
		private String targetTimeDesc;//目标收益时间限制描述	String	
		private String saleDesc;//促销描述	String	
		private String priceType;//价格类型	String	N:正价 S:优惠价格 客户可享受的价格类型
		private BigDecimal price;//价格	String	订单价格
		private BigDecimal salePrice;//价格	String	订单价格
		private BigDecimal vipPrice;//价格	String	订单价格
		private BigDecimal targetYield;//目标收益率	String	
		private Date beginDate;//服务开始日期	Int64	
		private Date endDate;//服务结束日期	Int64
		private String payChannel;
		
		//测试使用，可删掉
		private Boolean wxPayTestFlag;

		
		
		public BigDecimal getSalePrice() {
			return salePrice;
		}
		public void setSalePrice(BigDecimal salePrice) {
			this.salePrice = salePrice;
		}
		public String getSaleDesc() {
			return saleDesc;
		}
		public void setSaleDesc(String saleDesc) {
			this.saleDesc = saleDesc;
		}
		public Long getPtfId() {
			return ptfId;
		}
		public void setPtfId(Long ptfId) {
			this.ptfId = ptfId;
		}
		public String getPtfName() {
			return ptfName;
		}
		public void setPtfName(String ptfName) {
			this.ptfName = ptfName;
		}
		public String getTargetTimeDesc() {
			return targetTimeDesc;
		}
		public void setTargetTimeDesc(String targetTimeDesc) {
			this.targetTimeDesc = targetTimeDesc;
		}
		public String getPriceType() {
			return priceType;
		}
		public void setPriceType(String priceType) {
			this.priceType = priceType;
		}
		public BigDecimal getPrice() {
			return price;
		}
		public void setPrice(BigDecimal price) {
			this.price = price;
		}
		public BigDecimal getTargetYield() {
			return targetYield;
		}
		public void setTargetYield(BigDecimal targetYield) {
			this.targetYield = targetYield;
		}
		public Date getBeginDate() {
			return beginDate;
		}
		public void setBeginDate(Date beginDate) {
			this.beginDate = beginDate;
		}
		public Date getEndDate() {
			return endDate;
		}
		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}
		public String getPayChannel() {
			return payChannel;
		}
		public void setPayChannel(String payChannel) {
			this.payChannel = payChannel;
		}
		
		
		public Boolean getWxPayTestFlag() {
			return wxPayTestFlag;
		}
		public void setWxPayTestFlag(Boolean wxPayTestFlag) {
			this.wxPayTestFlag = wxPayTestFlag;
		}
		public BigDecimal getVipPrice() {
			return vipPrice;
		}
		public void setVipPrice(BigDecimal vipPrice) {
			this.vipPrice = vipPrice;
		}
		
		
	}
	
}
