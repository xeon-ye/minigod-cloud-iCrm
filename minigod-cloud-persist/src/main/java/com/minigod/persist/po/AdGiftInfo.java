package com.minigod.persist.po;
import com.minigod.persist.tables.TAdGiftInfo;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TAdGiftInfo.class)
public class AdGiftInfo implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer adGiftId;
	private Integer adId;//广告id
	private String giftImg;//奖品图片路径
	private Integer giftNum;//奖品数量
	private String giftDesc;//奖品介绍
	private Integer unitNum;//兑换奖品所需的单位数量
	private Date updateTime;//更新时间
	private Date createTime;//创建时间

    public Integer getAdGiftId () {
        return adGiftId;
    }

    public void setAdGiftId (Integer adGiftId) {
        this.adGiftId = adGiftId;
    }

    public Integer getAdId () {
        return adId;
    }

    public void setAdId (Integer adId) {
        this.adId = adId;
    }

    public String getGiftImg () {
        return giftImg;
    }

    public void setGiftImg (String giftImg) {
        this.giftImg = giftImg;
    }

    public Integer getGiftNum () {
        return giftNum;
    }

    public void setGiftNum (Integer giftNum) {
        this.giftNum = giftNum;
    }

    public String getGiftDesc () {
        return giftDesc;
    }

    public void setGiftDesc (String giftDesc) {
        this.giftDesc = giftDesc;
    }

    public Integer getUnitNum () {
        return unitNum;
    }

    public void setUnitNum (Integer unitNum) {
        this.unitNum = unitNum;
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