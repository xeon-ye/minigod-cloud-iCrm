package com.minigod.api.ptf.vo.resp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @Title: PtfInfoListVO.java
 * @Description: 组合信息查询列表值对象
 * @Copyright: © 2014 minigod
 * @Company: minigod
 *
 * @author minigod
 * @date 2014-11-10 下午5:50:38
 * @version v1.0
 */
@TransferBean
public class PtfInfoListVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@TransferID
	private Long ptfId;
	
	private String name;
	
	@TransferID
	private Long userId;
	
	private String description;
	
	private Integer authQry;
	
	private Integer bchType;
	
	private String bchId;
	
	private Double volatility;
	
	private Date createTime;
	
	private Boolean isReal;
	
	private String authShare;
	
	private Double dayYield;
	
	private Double monthYield;
	
	private Double yearYield;
	
	private Double ptfIndex;
	
	private Double sinceCreateYield;
	
	private Date updateTime;
	
	private Integer realBrokerId;
	
	private String saleFlag;
	
//	private String saleDesc;
	
	private BigDecimal price;
	
	private BigDecimal salesPrice;
	
	private BigDecimal vipPrice;
	
	private BigDecimal targetYield;
	
	private Double natureDayYield;
	
	private Double natureMonthYield;
	
	private Double natureYearYield;
	
	

	public String getSaleFlag() {
		return saleFlag;
	}

	public void setSaleFlag(String saleFlag) {
		this.saleFlag = saleFlag;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(BigDecimal salesPrice) {
		this.salesPrice = salesPrice;
	}

	public BigDecimal getTargetYield() {
		return targetYield;
	}

	public void setTargetYield(BigDecimal targetYield) {
		this.targetYield = targetYield;
	}

	public Long getPtfId() {
		return ptfId;
	}

	public void setPtfId(Long ptfId) {
		this.ptfId = ptfId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getAuthQry() {
		return authQry;
	}

	public void setAuthQry(Integer authQry) {
		this.authQry = authQry;
	}

	public Integer getBchType() {
		return bchType;
	}

	public void setBchType(Integer bchType) {
		this.bchType = bchType;
	}

	public String getBchId() {
		return bchId;
	}

	public void setBchId(String bchId) {
		this.bchId = bchId;
	}

	public Double getVolatility() {
		return volatility;
	}

	public void setVolatility(Double volatility) {
		this.volatility = volatility;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Boolean getIsReal() {
		return isReal;
	}

	public void setIsReal(Boolean isReal) {
		this.isReal = isReal;
	}

	public String getAuthShare() {
		return authShare;
	}

	public void setAuthShare(String authShare) {
		this.authShare = authShare;
	}

	public Double getDayYield() {
		return dayYield;
	}

	public void setDayYield(Double dayYield) {
		this.dayYield = dayYield;
	}

	public Double getMonthYield() {
		return monthYield;
	}

	public void setMonthYield(Double monthYield) {
		this.monthYield = monthYield;
	}

	public Double getYearYield() {
		return yearYield;
	}

	public void setYearYield(Double yearYield) {
		this.yearYield = yearYield;
	}

	public Double getPtfIndex() {
		return ptfIndex;
	}

	public void setPtfIndex(Double ptfIndex) {
		this.ptfIndex = ptfIndex;
	}

	public Double getSinceCreateYield() {
		return sinceCreateYield;
	}

	public void setSinceCreateYield(Double sinceCreateYield) {
		this.sinceCreateYield = sinceCreateYield;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getRealBrokerId() {
		return realBrokerId;
	}

	public void setRealBrokerId(Integer realBrokerId) {
		this.realBrokerId = realBrokerId;
	}

	public BigDecimal getVipPrice() {
		return vipPrice;
	}

	public void setVipPrice(BigDecimal vipPrice) {
		this.vipPrice = vipPrice;
	}

	public Double getNatureDayYield() {
		return natureDayYield;
	}

	public void setNatureDayYield(Double natureDayYield) {
		this.natureDayYield = natureDayYield;
	}

	public Double getNatureMonthYield() {
		return natureMonthYield;
	}

	public void setNatureMonthYield(Double natureMonthYield) {
		this.natureMonthYield = natureMonthYield;
	}

	public Double getNatureYearYield() {
		return natureYearYield;
	}

	public void setNatureYearYield(Double natureYearYield) {
		this.natureYearYield = natureYearYield;
	}
	
	
	
	
}
