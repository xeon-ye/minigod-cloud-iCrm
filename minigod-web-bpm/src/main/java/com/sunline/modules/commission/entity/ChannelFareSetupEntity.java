package com.sunline.modules.commission.entity;

import com.sunline.modules.activiti.annotation.ActTable;
import com.sunline.modules.common.entity.ActivitiBaseEntity;
import io.swagger.models.auth.In;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 渠道佣金套餐设置表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-08-21 21:25:11
 */
@ActTable(tableName = "channel_fare_setup",pkName="bus_id")
public class ChannelFareSetupEntity extends ActivitiBaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//自增ID
	private Integer id;
	//渠道号
	private Integer channelId;
	//是否参与开户免佣[0-否 1-是]
	private Integer isFreeCommission;
	//免佣期天数
	private Integer freeCommissionDays;
	//套餐编号
	private String fareKind;
	//渠道套餐类别[0-目前方案 1-下一方案]
	private String channelFareType;
	//开始日期
	private Date beginDate;
	//结束日期
	private Date endDate;
	//创建人
	private String createUser;
	//修改人
	private String updateUser;
	//审核人
	private String auditUser;
	//审核状态[0-未审核 1-审核通过 2-审核不通过]
	private Integer auditStatus;
	//审核时间
	private Date auditTime;
	//同步状态[0-未同步 1-正在同步 2-同步完成 3-同步失败]
	private Integer syncStatus;
	//同步时间
	private Date syncTime;
	//创建时间
	private Date createTime;
	//修改时间
	private Date updateTime;

	private String clientId;

	private String fundAccount;

	// 开户时间
	private Date openAccountTime;

    private String channelName;

    // 流程编号
    private String busId;

    // 业务编号
    private String code;

    //有效状态 [ 0 无效 1 有效]
    private Integer recordStatus;

    private List<String> fareKindList;


    public String getBusId() {
        return busId;
    }

    public void setBusId(String busId) {
        this.busId = busId;
    }

    /**
	 * 设置：自增ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：自增ID
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：渠道号
	 */
	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}
	/**
	 * 获取：渠道号
	 */
	public Integer getChannelId() {
		return channelId;
	}
	/**
	 * 设置：是否参与免佣[0-否 1-是]
	 */
	public void setIsFreeCommission(Integer isFreeCommission) {
		this.isFreeCommission = isFreeCommission;
	}
	/**
	 * 获取：是否参与免佣[0-否 1-是]
	 */
	public Integer getIsFreeCommission() {
		return isFreeCommission;
	}
	/**
	 * 设置：免佣期天数
	 */
	public void setFreeCommissionDays(Integer freeCommissionDays) {
		this.freeCommissionDays = freeCommissionDays;
	}
	/**
	 * 获取：免佣期天数
	 */
	public Integer getFreeCommissionDays() {
		return freeCommissionDays;
	}
	/**
	 * 设置：套餐编号
	 */
	public void setFareKind(String fareKind) {
		this.fareKind = fareKind;
	}
	/**
	 * 获取：套餐编号
	 */
	public String getFareKind() {
		return fareKind;
	}
	/**
	 * 设置：渠道套餐类别[0-目前方案 1-下一方案]
	 */
	public void setChannelFareType(String channelFareType) {
		this.channelFareType = channelFareType;
	}
	/**
	 * 获取：渠道套餐类别[0-目前方案 1-下一方案]
	 */
	public String getChannelFareType() {
		return channelFareType;
	}
	/**
	 * 设置：开始日期
	 */
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	/**
	 * 获取：开始日期
	 */
	public Date getBeginDate() {
		return beginDate;
	}
	/**
	 * 设置：结束日期
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/**
	 * 获取：结束日期
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取：创建人
	 */
	public String getCreateUser() {
		return createUser;
	}
	/**
	 * 设置：修改人
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	/**
	 * 获取：修改人
	 */
	public String getUpdateUser() {
		return updateUser;
	}
	/**
	 * 设置：审核人
	 */
	public void setAuditUser(String auditUser) {
		this.auditUser = auditUser;
	}
	/**
	 * 获取：审核人
	 */
	public String getAuditUser() {
		return auditUser;
	}
	/**
	 * 设置：审核状态[0-未审核 1-审核通过 2-审核不通过]
	 */
	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}
	/**
	 * 获取：审核状态[0-未审核 1-审核通过 2-审核不通过]
	 */
	public Integer getAuditStatus() {
		return auditStatus;
	}
	/**
	 * 设置：审核时间
	 */
	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}
	/**
	 * 获取：审核时间
	 */
	public Date getAuditTime() {
		return auditTime;
	}
	/**
	 * 设置：同步状态[0-未同步 1-正在同步 2-同步完成 3-同步失败]
	 */
	public void setSyncStatus(Integer syncStatus) {
		this.syncStatus = syncStatus;
	}
	/**
	 * 获取：同步状态[0-未同步 1-正在同步 2-同步完成 3-同步失败]
	 */
	public Integer getSyncStatus() {
		return syncStatus;
	}
	/**
	 * 设置：同步时间
	 */
	public void setSyncTime(Date syncTime) {
		this.syncTime = syncTime;
	}
	/**
	 * 获取：同步时间
	 */
	public Date getSyncTime() {
		return syncTime;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：修改时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getFundAccount() {
        return fundAccount;
    }

    public void setFundAccount(String fundAccount) {
        this.fundAccount = fundAccount;
    }

    public Date getOpenAccountTime() {
        return openAccountTime;
    }

    public void setOpenAccountTime(Date openAccountTime) {
        this.openAccountTime = openAccountTime;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    public Integer getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Integer recordStatus) {
        this.recordStatus = recordStatus;
    }

    public List<String> getFareKindList() {
        return fareKindList;
    }

    public void setFareKindList(List<String> fareKindList) {
        this.fareKindList = fareKindList;
    }
}
