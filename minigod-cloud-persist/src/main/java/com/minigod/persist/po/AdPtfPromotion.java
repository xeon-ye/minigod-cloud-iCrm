package com.minigod.persist.po;
import com.minigod.persist.tables.TAdPtfPromotion;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TAdPtfPromotion.class)
public class AdPtfPromotion implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer promotionId;
	private Integer adId;//广告id
	private Integer ptfId;//组合id
	private String code;
	private Boolean isStatus;//是否有效
	private Date createTime;//创建时间
	private Date updateTime;//更新时间

    public Integer getPromotionId () {
        return promotionId;
    }

    public void setPromotionId (Integer promotionId) {
        this.promotionId = promotionId;
    }

    public Integer getAdId () {
        return adId;
    }

    public void setAdId (Integer adId) {
        this.adId = adId;
    }

    public Integer getPtfId () {
        return ptfId;
    }

    public void setPtfId (Integer ptfId) {
        this.ptfId = ptfId;
    }

    public String getCode () {
        return code;
    }

    public void setCode (String code) {
        this.code = code;
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
}