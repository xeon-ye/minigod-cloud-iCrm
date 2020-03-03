package com.minigod.persist.po;
import com.minigod.persist.tables.THqMarketInfo;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=THqMarketInfo.class)
public class HqMarketInfo implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long marketId;
	private String marketName;//行情名称
	private String marketVersion = "3";//1-内地版,2-海外版,3-通用版
	private String marketType;//1-港股行情，2-美股行情
	private String marketCode;//行情代码
	private String feeWay;//1-串流，2-bmp，3-点击，
	private Double feeScale;//收费价格
	private String ccyType;//CNY-人民币，USD-美元，HKD-港币
	private Integer usePeriod = 0;//使用期限
	private Integer clickNum = 0;//使用点数
	private String srcType;//来源类型支持(APP WEB PC)
	private Boolean isStatus = true;//0-无效，1-有效
	private Long createUser;
	private Long updateUser;
	private Date createTime;
	private Date updateTime;

    public Long getMarketId () {
        return marketId;
    }

    public void setMarketId (Long marketId) {
        this.marketId = marketId;
    }

    public String getMarketName () {
        return marketName;
    }

    public void setMarketName (String marketName) {
        this.marketName = marketName;
    }

    public String getMarketVersion () {
        return marketVersion;
    }

    public void setMarketVersion (String marketVersion) {
        this.marketVersion = marketVersion;
    }

    public String getMarketType () {
        return marketType;
    }

    public void setMarketType (String marketType) {
        this.marketType = marketType;
    }

    public String getMarketCode () {
        return marketCode;
    }

    public void setMarketCode (String marketCode) {
        this.marketCode = marketCode;
    }

    public String getFeeWay () {
        return feeWay;
    }

    public void setFeeWay (String feeWay) {
        this.feeWay = feeWay;
    }

    public Double getFeeScale () {
        return feeScale;
    }

    public void setFeeScale (Double feeScale) {
        this.feeScale = feeScale;
    }

    public String getCcyType () {
        return ccyType;
    }

    public void setCcyType (String ccyType) {
        this.ccyType = ccyType;
    }

    public Integer getUsePeriod () {
        return usePeriod;
    }

    public void setUsePeriod (Integer usePeriod) {
        this.usePeriod = usePeriod;
    }

    public Integer getClickNum () {
        return clickNum;
    }

    public void setClickNum (Integer clickNum) {
        this.clickNum = clickNum;
    }

    public String getSrcType () {
        return srcType;
    }

    public void setSrcType (String srcType) {
        this.srcType = srcType;
    }

    public Boolean getIsStatus () {
        return isStatus;
    }

    public void setIsStatus (Boolean isStatus) {
        this.isStatus = isStatus;
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
}