package com.minigod.persist.po;
import com.minigod.persist.tables.TUserInvestIdx;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 */
@Entity(table=TUserInvestIdx.class)
public class UserInvestIdx implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer userId;//用户ID
	private Date indexDate;//指数日期
	private BigDecimal userIndex;
	private Date createTime;
	private BigDecimal yesterdayMv;// 昨天市值
	private BigDecimal todayMv;//今天市值
	private BigDecimal flowAmount;//今日净注入金额

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public Date getIndexDate () {
        return indexDate;
    }

    public void setIndexDate (Date indexDate) {
        this.indexDate = indexDate;
    }

    public BigDecimal getUserIndex () {
        return userIndex;
    }

    public void setUserIndex (BigDecimal userIndex) {
        this.userIndex = userIndex;
    }

    public Date getCreateTime () {
        return createTime;
    }

    public void setCreateTime (Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getYesterdayMv () {
        return yesterdayMv;
    }

    public void setYesterdayMv (BigDecimal yesterdayMv) {
        this.yesterdayMv = yesterdayMv;
    }

    public BigDecimal getTodayMv () {
        return todayMv;
    }

    public void setTodayMv (BigDecimal todayMv) {
        this.todayMv = todayMv;
    }

    public BigDecimal getFlowAmount () {
        return flowAmount;
    }

    public void setFlowAmount (BigDecimal flowAmount) {
        this.flowAmount = flowAmount;
    }
}