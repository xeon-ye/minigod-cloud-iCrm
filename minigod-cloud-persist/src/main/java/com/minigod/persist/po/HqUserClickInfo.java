package com.minigod.persist.po;
import com.minigod.persist.tables.THqUserClickInfo;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=THqUserClickInfo.class)
public class HqUserClickInfo implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long userClickId;
	private Long packageId;//行情ID
	private Long userId;
	private Integer clickTotalNum;//总点击数
	private Integer clickRestNum;//剩余点击数
	private Integer clickUseNum;//已使用点数
	private Date createTime;
	private Date updateTime;
	private Boolean isStatus = true;//0-无效，1-有效

    public Long getUserClickId () {
        return userClickId;
    }

    public void setUserClickId (Long userClickId) {
        this.userClickId = userClickId;
    }

    public Long getPackageId () {
        return packageId;
    }

    public void setPackageId (Long packageId) {
        this.packageId = packageId;
    }

    public Long getUserId () {
        return userId;
    }

    public void setUserId (Long userId) {
        this.userId = userId;
    }

    public Integer getClickTotalNum () {
        return clickTotalNum;
    }

    public void setClickTotalNum (Integer clickTotalNum) {
        this.clickTotalNum = clickTotalNum;
    }

    public Integer getClickRestNum () {
        return clickRestNum;
    }

    public void setClickRestNum (Integer clickRestNum) {
        this.clickRestNum = clickRestNum;
    }

    public Integer getClickUseNum () {
        return clickUseNum;
    }

    public void setClickUseNum (Integer clickUseNum) {
        this.clickUseNum = clickUseNum;
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
}