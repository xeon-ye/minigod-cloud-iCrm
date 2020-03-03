package com.minigod.persist.po;
import com.minigod.persist.tables.TUserInfoExtend;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TUserInfoExtend.class)
public class UserInfoExtend implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer userExtendId;
	private Integer userId;//用户id
	private Integer cityId;//城市id
	private String assetSize;//资产规模
	private String investType;//投资喜好
	private String listenHabits;//听消息习惯
	private String analysisType;//分析类型
	private String assetIds;//资产id数组
	private Boolean isStatus = true;//记录状态 0-无效，默认1-有效 
	private Date createTime;//创建时间
	private Date updateTime;//修改时间

    public Integer getUserExtendId () {
        return userExtendId;
    }

    public void setUserExtendId (Integer userExtendId) {
        this.userExtendId = userExtendId;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public Integer getCityId () {
        return cityId;
    }

    public void setCityId (Integer cityId) {
        this.cityId = cityId;
    }

    public String getAssetSize () {
        return assetSize;
    }

    public void setAssetSize (String assetSize) {
        this.assetSize = assetSize;
    }

    public String getInvestType () {
        return investType;
    }

    public void setInvestType (String investType) {
        this.investType = investType;
    }

    public String getListenHabits () {
        return listenHabits;
    }

    public void setListenHabits (String listenHabits) {
        this.listenHabits = listenHabits;
    }

    public String getAnalysisType () {
        return analysisType;
    }

    public void setAnalysisType (String analysisType) {
        this.analysisType = analysisType;
    }

    public String getAssetIds () {
        return assetIds;
    }

    public void setAssetIds (String assetIds) {
        this.assetIds = assetIds;
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