package com.minigod.persist.po;
import com.minigod.persist.tables.TActivPresentPomegranate;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 送石榴信息表
 */
@Entity(table=TActivPresentPomegranate.class)
public class ActivPresentPomegranate implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long id;//主键
	private Integer userId;//客户id
	private String userName;//客户名称
	private String userPhonenum;//客户手机号
	private String locationAddress;//所在地区
	private String detailAddress;//详细地址
	private Integer inviteUsersNumber = 0;//邀请用户数
	private Integer receiveNumber = 0;//奖品领取箱数
	private Integer rewardType = 0;//记录状态:1:开户奖励,2:邀请注册奖励
	private Integer grantStatus = 0;//发放状态:1:未发放,2:已发放
	private Date createdTime;//创建时间
	private Date updateTime;//修改时间
	private String createdBy;//创建人
	private String updateBy;//修改人
	private Integer recordStatus = 0;//记录状态:0:有效1:无效
	private String rmk;//备注

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public String getUserName () {
        return userName;
    }

    public void setUserName (String userName) {
        this.userName = userName;
    }

    public String getUserPhonenum () {
        return userPhonenum;
    }

    public void setUserPhonenum (String userPhonenum) {
        this.userPhonenum = userPhonenum;
    }

    public String getLocationAddress () {
        return locationAddress;
    }

    public void setLocationAddress (String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public String getDetailAddress () {
        return detailAddress;
    }

    public void setDetailAddress (String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public Integer getInviteUsersNumber () {
        return inviteUsersNumber;
    }

    public void setInviteUsersNumber (Integer inviteUsersNumber) {
        this.inviteUsersNumber = inviteUsersNumber;
    }

    public Integer getReceiveNumber () {
        return receiveNumber;
    }

    public void setReceiveNumber (Integer receiveNumber) {
        this.receiveNumber = receiveNumber;
    }

    public Integer getRewardType () {
        return rewardType;
    }

    public void setRewardType (Integer rewardType) {
        this.rewardType = rewardType;
    }

    public Integer getGrantStatus () {
        return grantStatus;
    }

    public void setGrantStatus (Integer grantStatus) {
        this.grantStatus = grantStatus;
    }

    public Date getCreatedTime () {
        return createdTime;
    }

    public void setCreatedTime (Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdateTime () {
        return updateTime;
    }

    public void setUpdateTime (Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreatedBy () {
        return createdBy;
    }

    public void setCreatedBy (String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdateBy () {
        return updateBy;
    }

    public void setUpdateBy (String updateBy) {
        this.updateBy = updateBy;
    }

    public Integer getRecordStatus () {
        return recordStatus;
    }

    public void setRecordStatus (Integer recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getRmk () {
        return rmk;
    }

    public void setRmk (String rmk) {
        this.rmk = rmk;
    }
}