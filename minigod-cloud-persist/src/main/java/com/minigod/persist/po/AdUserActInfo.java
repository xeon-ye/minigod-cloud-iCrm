package com.minigod.persist.po;
import com.minigod.persist.tables.TAdUserActInfo;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TAdUserActInfo.class)
public class AdUserActInfo implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer adUserActId;
	private Integer adId;//广告id
	private Integer userId;//用户id
	private Integer ptfId;//组合id
	private String strA;//卡牌数量
	private String strB;//金币数量
	private String strC;//金额
	private String strD;//记录活动结果
	private String strE;
	private Integer lockVersion;//乐观锁
	private Date updateTime;//更新时间
	private Date createTime;//创建时间

    public Integer getAdUserActId () {
        return adUserActId;
    }

    public void setAdUserActId (Integer adUserActId) {
        this.adUserActId = adUserActId;
    }

    public Integer getAdId () {
        return adId;
    }

    public void setAdId (Integer adId) {
        this.adId = adId;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public Integer getPtfId () {
        return ptfId;
    }

    public void setPtfId (Integer ptfId) {
        this.ptfId = ptfId;
    }

    public String getStrA () {
        return strA;
    }

    public void setStrA (String strA) {
        this.strA = strA;
    }

    public String getStrB () {
        return strB;
    }

    public void setStrB (String strB) {
        this.strB = strB;
    }

    public String getStrC () {
        return strC;
    }

    public void setStrC (String strC) {
        this.strC = strC;
    }

    public String getStrD () {
        return strD;
    }

    public void setStrD (String strD) {
        this.strD = strD;
    }

    public String getStrE () {
        return strE;
    }

    public void setStrE (String strE) {
        this.strE = strE;
    }

    public Integer getLockVersion () {
        return lockVersion;
    }

    public void setLockVersion (Integer lockVersion) {
        this.lockVersion = lockVersion;
    }

    public Date getUpdateTime () {
        return updateTime;
    }

    public void setUpdateTime (Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime () {
        return createTime;
    }

    public void setCreateTime (Date createTime) {
        this.createTime = createTime;
    }
}