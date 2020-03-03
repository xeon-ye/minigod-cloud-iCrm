package com.minigod.persist.po;
import com.minigod.persist.tables.TAdInfo;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TAdInfo.class)
public class AdInfo implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer adId;//广告ID
	private Integer positionCode;//广告位
	private String adCode;//活动标志码
	private Integer groupId;//广告用户群分组
	private Integer adFlag;//广告展示的判断条件
	private String img;//广告图片地址
	private String url;
	private String linkType;//广告的调转类型(V-观点详情,P-组合详情,A-广告详情页)
	private String adDesc;
	private Date startTime;//广告开始时间
	private Date endTime;//广告结束时间
	private Integer priority;//数字越小优先级越高，同个用户群有多个广告时展示优先级最高的
	private Integer activityNum;//活动参与人数
	private Integer createOpr;//创建人id
	private Integer updateOpr;//更新人id
	private Boolean isStatus;//是否上架(0-未上架,1-上架)
	private Date createTime;//创建时间
	private Date updateTime;//更新时间
	private String bananerImg;//活动专栏banner图
	private String maskChannel;//屏蔽渠道

    public Integer getAdId () {
        return adId;
    }

    public void setAdId (Integer adId) {
        this.adId = adId;
    }

    public Integer getPositionCode () {
        return positionCode;
    }

    public void setPositionCode (Integer positionCode) {
        this.positionCode = positionCode;
    }

    public String getAdCode () {
        return adCode;
    }

    public void setAdCode (String adCode) {
        this.adCode = adCode;
    }

    public Integer getGroupId () {
        return groupId;
    }

    public void setGroupId (Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getAdFlag () {
        return adFlag;
    }

    public void setAdFlag (Integer adFlag) {
        this.adFlag = adFlag;
    }

    public String getImg () {
        return img;
    }

    public void setImg (String img) {
        this.img = img;
    }

    public String getUrl () {
        return url;
    }

    public void setUrl (String url) {
        this.url = url;
    }

    public String getLinkType () {
        return linkType;
    }

    public void setLinkType (String linkType) {
        this.linkType = linkType;
    }

    public String getAdDesc () {
        return adDesc;
    }

    public void setAdDesc (String adDesc) {
        this.adDesc = adDesc;
    }

    public Date getStartTime () {
        return startTime;
    }

    public void setStartTime (Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime () {
        return endTime;
    }

    public void setEndTime (Date endTime) {
        this.endTime = endTime;
    }

    public Integer getPriority () {
        return priority;
    }

    public void setPriority (Integer priority) {
        this.priority = priority;
    }

    public Integer getActivityNum () {
        return activityNum;
    }

    public void setActivityNum (Integer activityNum) {
        this.activityNum = activityNum;
    }

    public Integer getCreateOpr () {
        return createOpr;
    }

    public void setCreateOpr (Integer createOpr) {
        this.createOpr = createOpr;
    }

    public Integer getUpdateOpr () {
        return updateOpr;
    }

    public void setUpdateOpr (Integer updateOpr) {
        this.updateOpr = updateOpr;
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

    public String getBananerImg () {
        return bananerImg;
    }

    public void setBananerImg (String bananerImg) {
        this.bananerImg = bananerImg;
    }

    public String getMaskChannel () {
        return maskChannel;
    }

    public void setMaskChannel (String maskChannel) {
        this.maskChannel = maskChannel;
    }
}