package com.minigod.persist.po;
import com.minigod.persist.tables.TPtfInfo;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 组合基本信息表
 */
@Entity(table=TPtfInfo.class)
public class PtfInfo implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer ptfId;//组合id
	private Integer ptfVersion;//组合版本
	private String name;
	private String description;
	private Integer bchType;//业绩基准类型
	private String bchId;
	private Integer userId;//创建用户ID
	private Integer authQry;//查询权限。0私密；1部分好友；2所有好友
	private String authShare = "Y";//分享权限
	private Date idxTime;//指数时间
	private Double ptfIndex;//指数
	private Double volatility;//组合波动率
	private Boolean isReal = false;//是否实盘
	private Boolean isRealCfm = false;//实盘是否成交
	private Date realTime;//实盘时间
	private Integer realBrokerId;//实盘券商ID
	private String realBrkCustid;
	private Date lastTransTime;
	private String saleFlag = "N";//是否付费可见
	private BigDecimal price;//组合收费单月费用
	private BigDecimal salesPrice;//优惠价格
	private BigDecimal vipPrice;//vip价格
	private BigDecimal targetYield;//组合收费目标收益率
	private Boolean isStatus = true;//记录是否有效
	private Date createTime;//创建时间
	private Date updateTime;//更新时间
	private Integer lockVersion;//乐观锁版本号

    public Integer getPtfId () {
        return ptfId;
    }

    public void setPtfId (Integer ptfId) {
        this.ptfId = ptfId;
    }

    public Integer getPtfVersion () {
        return ptfVersion;
    }

    public void setPtfVersion (Integer ptfVersion) {
        this.ptfVersion = ptfVersion;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription (String description) {
        this.description = description;
    }

    public Integer getBchType () {
        return bchType;
    }

    public void setBchType (Integer bchType) {
        this.bchType = bchType;
    }

    public String getBchId () {
        return bchId;
    }

    public void setBchId (String bchId) {
        this.bchId = bchId;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public Integer getAuthQry () {
        return authQry;
    }

    public void setAuthQry (Integer authQry) {
        this.authQry = authQry;
    }

    public String getAuthShare () {
        return authShare;
    }

    public void setAuthShare (String authShare) {
        this.authShare = authShare;
    }

    public Date getIdxTime () {
        return idxTime;
    }

    public void setIdxTime (Date idxTime) {
        this.idxTime = idxTime;
    }

    public Double getPtfIndex () {
        return ptfIndex;
    }

    public void setPtfIndex (Double ptfIndex) {
        this.ptfIndex = ptfIndex;
    }

    public Double getVolatility () {
        return volatility;
    }

    public void setVolatility (Double volatility) {
        this.volatility = volatility;
    }

    public Boolean getIsReal () {
        return isReal;
    }

    public void setIsReal (Boolean isReal) {
        this.isReal = isReal;
    }

    public Boolean getIsRealCfm () {
        return isRealCfm;
    }

    public void setIsRealCfm (Boolean isRealCfm) {
        this.isRealCfm = isRealCfm;
    }

    public Date getRealTime () {
        return realTime;
    }

    public void setRealTime (Date realTime) {
        this.realTime = realTime;
    }

    public Integer getRealBrokerId () {
        return realBrokerId;
    }

    public void setRealBrokerId (Integer realBrokerId) {
        this.realBrokerId = realBrokerId;
    }

    public String getRealBrkCustid () {
        return realBrkCustid;
    }

    public void setRealBrkCustid (String realBrkCustid) {
        this.realBrkCustid = realBrkCustid;
    }

    public Date getLastTransTime () {
        return lastTransTime;
    }

    public void setLastTransTime (Date lastTransTime) {
        this.lastTransTime = lastTransTime;
    }

    public String getSaleFlag () {
        return saleFlag;
    }

    public void setSaleFlag (String saleFlag) {
        this.saleFlag = saleFlag;
    }

    public BigDecimal getPrice () {
        return price;
    }

    public void setPrice (BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getSalesPrice () {
        return salesPrice;
    }

    public void setSalesPrice (BigDecimal salesPrice) {
        this.salesPrice = salesPrice;
    }

    public BigDecimal getVipPrice () {
        return vipPrice;
    }

    public void setVipPrice (BigDecimal vipPrice) {
        this.vipPrice = vipPrice;
    }

    public BigDecimal getTargetYield () {
        return targetYield;
    }

    public void setTargetYield (BigDecimal targetYield) {
        this.targetYield = targetYield;
    }

    public Boolean getIsStatus () {
        return isStatus;
    }

    public void setIsStatus (Boolean isStatus) {
        this.isStatus = isStatus;
    }

    public Date getCreateTime () {
        return createTime;
    }

    public void setCreateTime (Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime () {
        return updateTime;
    }

    public void setUpdateTime (Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getLockVersion () {
        return lockVersion;
    }

    public void setLockVersion (Integer lockVersion) {
        this.lockVersion = lockVersion;
    }
}