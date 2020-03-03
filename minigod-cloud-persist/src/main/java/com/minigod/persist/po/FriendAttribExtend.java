package com.minigod.persist.po;
import com.minigod.persist.tables.TFriendAttribExtend;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TFriendAttribExtend.class)
public class FriendAttribExtend implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer attribExtendId;//属性扩展id
	private Integer userId;//用户id
	private Integer friendUserId;//好友用户ID
	private String profession;//职业
	private String investType;//投资喜好
	private String ageRange;//年龄范围
	private String assetSize;//资产规模
	private String openType;//开户信息
	private String listenHabits;//听消息习惯
	private Boolean gender;//用户性别(1男，0女)
	private String isMarried;//婚否
	private String haveChild;//有孩子否
	private String jobHour;//工作时长
	private String houseType;//房子信息
	private String carType;//车子信息
	private String comment;//备注信息
	private Boolean isStatus = true;//状态 0-无效，默认1-有效
	private Date createTime;//创建时间
	private Date updateTime;//修改时间

    public Integer getAttribExtendId () {
        return attribExtendId;
    }

    public void setAttribExtendId (Integer attribExtendId) {
        this.attribExtendId = attribExtendId;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public Integer getFriendUserId () {
        return friendUserId;
    }

    public void setFriendUserId (Integer friendUserId) {
        this.friendUserId = friendUserId;
    }

    public String getProfession () {
        return profession;
    }

    public void setProfession (String profession) {
        this.profession = profession;
    }

    public String getInvestType () {
        return investType;
    }

    public void setInvestType (String investType) {
        this.investType = investType;
    }

    public String getAgeRange () {
        return ageRange;
    }

    public void setAgeRange (String ageRange) {
        this.ageRange = ageRange;
    }

    public String getAssetSize () {
        return assetSize;
    }

    public void setAssetSize (String assetSize) {
        this.assetSize = assetSize;
    }

    public String getOpenType () {
        return openType;
    }

    public void setOpenType (String openType) {
        this.openType = openType;
    }

    public String getListenHabits () {
        return listenHabits;
    }

    public void setListenHabits (String listenHabits) {
        this.listenHabits = listenHabits;
    }

    public Boolean getGender () {
        return gender;
    }

    public void setGender (Boolean gender) {
        this.gender = gender;
    }

    public String getIsMarried () {
        return isMarried;
    }

    public void setIsMarried (String isMarried) {
        this.isMarried = isMarried;
    }

    public String getHaveChild () {
        return haveChild;
    }

    public void setHaveChild (String haveChild) {
        this.haveChild = haveChild;
    }

    public String getJobHour () {
        return jobHour;
    }

    public void setJobHour (String jobHour) {
        this.jobHour = jobHour;
    }

    public String getHouseType () {
        return houseType;
    }

    public void setHouseType (String houseType) {
        this.houseType = houseType;
    }

    public String getCarType () {
        return carType;
    }

    public void setCarType (String carType) {
        this.carType = carType;
    }

    public String getComment () {
        return comment;
    }

    public void setComment (String comment) {
        this.comment = comment;
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