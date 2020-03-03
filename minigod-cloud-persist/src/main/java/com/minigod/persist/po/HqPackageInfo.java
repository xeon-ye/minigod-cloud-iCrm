package com.minigod.persist.po;
import com.minigod.persist.tables.THqPackageInfo;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=THqPackageInfo.class)
public class HqPackageInfo implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long packageId;
	private String packageName;//套餐名称
	private String packageCode;
	private String packageDesc;//描述
	private String picUrl;//图片地址
	private Double oldPrice;//原价格
	private Double newPrice;//最新价格
	private String ccyType;//CNY-人民币，USD-美元，HKD-港币
	private Integer totalNum;//套餐总数
	private Integer restNum;//剩余数量
	private Date expiryDate;//截至日期
	private Long createUser;
	private Long updateUser;
	private Date createTime;
	private Date updateTime;
	private Boolean isStatus = true;//0-无效，1-有效
	private Double discount = 0.00d;//优惠率
	private Long marketId;

    public Long getPackageId () {
        return packageId;
    }

    public void setPackageId (Long packageId) {
        this.packageId = packageId;
    }

    public String getPackageName () {
        return packageName;
    }

    public void setPackageName (String packageName) {
        this.packageName = packageName;
    }

    public String getPackageCode () {
        return packageCode;
    }

    public void setPackageCode (String packageCode) {
        this.packageCode = packageCode;
    }

    public String getPackageDesc () {
        return packageDesc;
    }

    public void setPackageDesc (String packageDesc) {
        this.packageDesc = packageDesc;
    }

    public String getPicUrl () {
        return picUrl;
    }

    public void setPicUrl (String picUrl) {
        this.picUrl = picUrl;
    }

    public Double getOldPrice () {
        return oldPrice;
    }

    public void setOldPrice (Double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public Double getNewPrice () {
        return newPrice;
    }

    public void setNewPrice (Double newPrice) {
        this.newPrice = newPrice;
    }

    public String getCcyType () {
        return ccyType;
    }

    public void setCcyType (String ccyType) {
        this.ccyType = ccyType;
    }

    public Integer getTotalNum () {
        return totalNum;
    }

    public void setTotalNum (Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getRestNum () {
        return restNum;
    }

    public void setRestNum (Integer restNum) {
        this.restNum = restNum;
    }

    public Date getExpiryDate () {
        return expiryDate;
    }

    public void setExpiryDate (Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Long getCreateUser () {
        return createUser;
    }

    public void setCreateUser (Long createUser) {
        this.createUser = createUser;
    }

    public Long getUpdateUser () {
        return updateUser;
    }

    public void setUpdateUser (Long updateUser) {
        this.updateUser = updateUser;
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

    public Boolean getIsStatus () {
        return isStatus;
    }

    public void setIsStatus (Boolean isStatus) {
        this.isStatus = isStatus;
    }

    public Double getDiscount () {
        return discount;
    }

    public void setDiscount (Double discount) {
        this.discount = discount;
    }

    public Long getMarketId () {
        return marketId;
    }

    public void setMarketId (Long marketId) {
        this.marketId = marketId;
    }
}