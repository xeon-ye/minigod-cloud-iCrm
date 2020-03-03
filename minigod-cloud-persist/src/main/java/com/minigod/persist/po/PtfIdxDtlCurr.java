package com.minigod.persist.po;
import com.minigod.persist.tables.TPtfIdxDtlCurr;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TPtfIdxDtlCurr.class)
public class PtfIdxDtlCurr implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer ptfIdxDtlId;//组合拐点明细表id
	private Integer ptfId;//组合ID
	private Integer sortNo;//排序编号。用于前端展示
	private String assetId;
	private Double hldPrc;
	private Date hldBeginTime;//开始持仓时间
	private Double balance;//资产余额
	private Double price;//资产价格
	private Date createTime;//创建时间
	private Date updateTime;//修改时间
	private Integer lockVersion;//乐观锁版本号

    public Integer getPtfIdxDtlId () {
        return ptfIdxDtlId;
    }

    public void setPtfIdxDtlId (Integer ptfIdxDtlId) {
        this.ptfIdxDtlId = ptfIdxDtlId;
    }

    public Integer getPtfId () {
        return ptfId;
    }

    public void setPtfId (Integer ptfId) {
        this.ptfId = ptfId;
    }

    public Integer getSortNo () {
        return sortNo;
    }

    public void setSortNo (Integer sortNo) {
        this.sortNo = sortNo;
    }

    public String getAssetId () {
        return assetId;
    }

    public void setAssetId (String assetId) {
        this.assetId = assetId;
    }

    public Double getHldPrc () {
        return hldPrc;
    }

    public void setHldPrc (Double hldPrc) {
        this.hldPrc = hldPrc;
    }

    public Date getHldBeginTime () {
        return hldBeginTime;
    }

    public void setHldBeginTime (Date hldBeginTime) {
        this.hldBeginTime = hldBeginTime;
    }

    public Double getBalance () {
        return balance;
    }

    public void setBalance (Double balance) {
        this.balance = balance;
    }

    public Double getPrice () {
        return price;
    }

    public void setPrice (Double price) {
        this.price = price;
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