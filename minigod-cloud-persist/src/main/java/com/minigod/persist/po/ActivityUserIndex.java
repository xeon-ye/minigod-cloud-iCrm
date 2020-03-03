package com.minigod.persist.po;
import com.minigod.persist.tables.TActivityUserIndex;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TActivityUserIndex.class)
public class ActivityUserIndex implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer actUserIndexId;//记录用户所猜指数ID
	private String mobile;
	private Date tradeday;//用户预测指数所属交易日
	private Double userIndex;//记录用户所猜指数
	private Date createTime;//记录创建时间
	private Date updateTime;//记录修改时间
	private Integer isStatus;//状态 0停用，1正常使用

    public Integer getActUserIndexId () {
        return actUserIndexId;
    }

    public void setActUserIndexId (Integer actUserIndexId) {
        this.actUserIndexId = actUserIndexId;
    }

    public String getMobile () {
        return mobile;
    }

    public void setMobile (String mobile) {
        this.mobile = mobile;
    }

    public Date getTradeday () {
        return tradeday;
    }

    public void setTradeday (Date tradeday) {
        this.tradeday = tradeday;
    }

    public Double getUserIndex () {
        return userIndex;
    }

    public void setUserIndex (Double userIndex) {
        this.userIndex = userIndex;
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

    public Integer getIsStatus () {
        return isStatus;
    }

    public void setIsStatus (Integer isStatus) {
        this.isStatus = isStatus;
    }
}