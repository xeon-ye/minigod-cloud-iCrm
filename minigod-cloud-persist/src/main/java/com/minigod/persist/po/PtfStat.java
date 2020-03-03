package com.minigod.persist.po;
import com.minigod.persist.tables.TPtfStat;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 */
@Entity(table=TPtfStat.class)
public class PtfStat implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer ptfId;//用户ID
	private Integer hisHldCount;//历史持仓的个股数量
	private Integer hisHldWon;//历史持仓盈利的个股数量
	private BigDecimal hisHldDay;//历史平均持股天数
	private BigDecimal maxRetracement;//最大回撤
	private Date maxRetracementHigh;//最大回测最高点日期
	private Date maxRetracementLow;//最大回测最低点日期
	private Date createTime;//创建时间
	private Date updateTime;//更新时间
	private Integer lockVersion;//乐观锁版本号

    public Integer getPtfId () {
        return ptfId;
    }

    public void setPtfId (Integer ptfId) {
        this.ptfId = ptfId;
    }

    public Integer getHisHldCount () {
        return hisHldCount;
    }

    public void setHisHldCount (Integer hisHldCount) {
        this.hisHldCount = hisHldCount;
    }

    public Integer getHisHldWon () {
        return hisHldWon;
    }

    public void setHisHldWon (Integer hisHldWon) {
        this.hisHldWon = hisHldWon;
    }

    public BigDecimal getHisHldDay () {
        return hisHldDay;
    }

    public void setHisHldDay (BigDecimal hisHldDay) {
        this.hisHldDay = hisHldDay;
    }

    public BigDecimal getMaxRetracement () {
        return maxRetracement;
    }

    public void setMaxRetracement (BigDecimal maxRetracement) {
        this.maxRetracement = maxRetracement;
    }

    public Date getMaxRetracementHigh () {
        return maxRetracementHigh;
    }

    public void setMaxRetracementHigh (Date maxRetracementHigh) {
        this.maxRetracementHigh = maxRetracementHigh;
    }

    public Date getMaxRetracementLow () {
        return maxRetracementLow;
    }

    public void setMaxRetracementLow (Date maxRetracementLow) {
        this.maxRetracementLow = maxRetracementLow;
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