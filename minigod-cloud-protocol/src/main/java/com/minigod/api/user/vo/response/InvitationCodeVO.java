package com.minigod.api.user.vo.response;

import java.io.Serializable;
import java.util.Date;

import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

@TransferBean
public class InvitationCodeVO implements Serializable {

	public static String USER_NAME = "user_name";//创建者姓名

	private static final long serialVersionUID = -634486050557989892L;

	private Integer invId;//邀请码ID
	@TransferID
	private Long userId = 0l;//创建人ID
	private String invCode;//邀请码(客户看到的码，注意需带至少2位校验码)
	private String beUserName;//被邀请人姓名
	private String bePhone;//被邀请人手机号
	private Integer invStatus = 0;//状态(0-未使用,1-已发送,2已使用)
	private Integer invUserId;//使用人ID
	private Date useTime;//使用时间
	private Boolean isStatus = true;//记录状态(0-无效，默认1-有效)
	private Date createTime;//创建时间
	private Date updateTime;//最后修改时间

	private String userName;//创建者姓名

	public Integer getInvId() {
		return invId;
	}

	public void setInvId(Integer invId) {
		this.invId = invId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getInvCode() {
		return invCode;
	}

	public void setInvCode(String invCode) {
		this.invCode = invCode;
	}

	public String getBeUserName() {
		return beUserName;
	}

	public void setBeUserName(String beUserName) {
		this.beUserName = beUserName;
	}

	public String getBePhone() {
		return bePhone;
	}

	public void setBePhone(String bePhone) {
		this.bePhone = bePhone;
	}

	public Integer getInvStatus() {
		return invStatus;
	}

	public void setInvStatus(Integer invStatus) {
		this.invStatus = invStatus;
	}

	public Integer getInvUserId() {
		return invUserId;
	}

	public void setInvUserId(Integer invUserId) {
		this.invUserId = invUserId;
	}

	public Date getUseTime() {
		return useTime;
	}

	public void setUseTime(Date useTime) {
		this.useTime = useTime;
	}

	public Boolean getIsStatus() {
		return isStatus;
	}

	public void setIsStatus(Boolean isStatus) {
		this.isStatus = isStatus;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
