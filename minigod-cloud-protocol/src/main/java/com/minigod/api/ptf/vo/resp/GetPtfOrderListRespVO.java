package com.minigod.api.ptf.vo.resp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.minigod.api.ptf.vo.req.GetPtfOrderListRequestVO.OrderStatus;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;


@TransferBean
public class GetPtfOrderListRespVO implements Serializable {
	private static final long serialVersionUID = 1L;
	@TransferID
	private List<GetPtfOrderListItem> soldList;
	private Integer totalCount;
	
	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public List<GetPtfOrderListItem> getSoldList() {
		return soldList;
	}

	public void setSoldList(List<GetPtfOrderListItem> soldList) {
		this.soldList = soldList;
	}

	@TransferBean
	public static class GetPtfOrderListItem implements Serializable {


		private static final long serialVersionUID = 1L;
			
		@TransferID
		private Long orderId;//订单ID
		private String priceType;//售出的价格类型
		private BigDecimal soldPrice;//售出价格
		private String buyerIcon;//订阅者图标Url
		private String buyerName;//订阅者名称
		private Integer buyerUType;//订阅者用户类型
		private Date beginTime;//服务开始时间戳
		private Date endTime;//服务结束时间戳
		private Date achieveDay;//服务结束时间戳
		private BigDecimal targetYield;//目标收益率
		private BigDecimal currentYield;//当前收益率
		private Integer restServiceDay;//剩余服务日期
		private OrderStatus orderStatus;//服务状态
		
		
		
		public Date getAchieveDay() {
			return achieveDay;
		}
		public void setAchieveDay(Date achieveDay) {
			this.achieveDay = achieveDay;
		}
		public Long getOrderId() {
			return orderId;
		}
		public void setOrderId(Long orderId) {
			this.orderId = orderId;
		}
		public String getPriceType() {
			return priceType;
		}
		public void setPriceType(String priceType) {
			this.priceType = priceType;
		}
		
		public BigDecimal getSoldPrice() {
			return soldPrice;
		}
		public void setSoldPrice(BigDecimal soldPrice) {
			this.soldPrice = soldPrice;
		}
		public String getBuyerIcon() {
			return buyerIcon;
		}
		public void setBuyerIcon(String buyerIcon) {
			this.buyerIcon = buyerIcon;
		}
		public String getBuyerName() {
			return buyerName;
		}
		public void setBuyerName(String buyerName) {
			this.buyerName = buyerName;
		}
		public Date getBeginTime() {
			return beginTime;
		}
		public void setBeginTime(Date beginTime) {
			this.beginTime = beginTime;
		}
		public Date getEndTime() {
			return endTime;
		}
		public void setEndTime(Date endTime) {
			this.endTime = endTime;
		}
		
		public BigDecimal getTargetYield() {
			return targetYield;
		}
		public void setTargetYield(BigDecimal targetYield) {
			this.targetYield = targetYield;
		}
		public BigDecimal getCurrentYield() {
			return currentYield;
		}
		public void setCurrentYield(BigDecimal currentYield) {
			this.currentYield = currentYield;
		}
		public Integer getRestServiceDay() {
			return restServiceDay;
		}
		public void setRestServiceDay(Integer restServiceDay) {
			this.restServiceDay = restServiceDay;
		}
		public OrderStatus getOrderStatus() {
			return orderStatus;
		}
		public void setOrderStatus(OrderStatus orderStatus) {
			this.orderStatus = orderStatus;
		}
		public Integer getBuyerUType() {
			return buyerUType;
		}
		public void setBuyerUType(Integer buyerUType) {
			this.buyerUType = buyerUType;
		}
	}
}
