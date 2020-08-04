package com.sunline.modules.commission.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 渠道佣金套餐设置日志表 业务类
 * 
 * @author lcs
 * @date 2018-08-21 17:05:24
 */
public class ChannelFareLogApplicationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

    //自增ID
    private Integer id;
    //渠道号
    private Integer channelId;
    //是否参与免佣[0-否 1-是]
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
    //操作标识[0-新增 1-修改 2-删除]
    private String opFlag;
    //创建人
    private String createUser;
    //修改人
    private String updateUser;
    //创建时间
    private Date createTime;
    //修改时间
    private Date updateTime;
    //上一套餐编号
    private String lastFareKind;

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
    //渠道名
    private String channelName;
    //上级渠道名
    private String parentName;
    //所属大区名
    private String areaName;

    // 记录状态
    private Integer recordStatus;



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
     * 设置：操作标识[0-新增 1-修改 2-删除]
     */
    public void setOpFlag(String opFlag) {
        this.opFlag = opFlag;
    }
    /**
     * 获取：操作标识[0-新增 1-修改 2-删除]
     */
    public String getOpFlag() {
        return opFlag;
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

    public String getLastFareKind() {
        return lastFareKind;
    }

    public void setLastFareKind(String lastFareKind) {
        this.lastFareKind = lastFareKind;
    }

    public String getAuditUser() {
        return auditUser;
    }

    public void setAuditUser(String auditUser) {
        this.auditUser = auditUser;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }

    public Date getSyncTime() {
        return syncTime;
    }

    public void setSyncTime(Date syncTime) {
        this.syncTime = syncTime;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Integer recordStatus) {
        this.recordStatus = recordStatus;
    }
}
