package com.sunline.modules.marker.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


/**
 * 渠道信息表
 *
 * @author lcs
 * @email
 * @date 2018-04-25 09:31:43
 */
public class UserChannelInfoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 记录ID
     */
    private Integer id;
    /**
     * 渠道ID
     */
    private String channelId;
    /**
     * 渠道名称
     */
    private String channelName;
    /**
     * 公司名称
     */
    private String companyName;
    /**
     * 渠道父ID
     */
    private String parentId;

    /**
     * 预计接入点(1:首批)
     */
    private String accessPoint;
    /**
     * 导流方式（1:线上，2:线下）
     */
    private String diversMode;
    /**
     * 注册用户规模
     */
    private Integer regisUserSize;
    /**
     * 备注
     */
    private String rmk;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 修改人
     */
    private String updateBy;

    /**
     * 创建日期
     */
    private String createTime;
    /**
     * 修改日期
     */
    private String updateTime;

    /* 下一方案 参数 */
    /**
     * 下一方案(是否参加免佣)
     */
    private Integer nextFreeCommission;

    /**
     * 下一方案(免佣期)
     */
    private Integer nextFreeCommissionDays;

    /**
     * 下一方案(方案编号)
     */
    private String nextFareKind;

    /**
     * 下一方案(开始生效时间)
     */
    private String nextEndDate;

    /**
     * 下一方案(结束生效时间)
     */
    private String nextBeginDate;

    /**
     * 上一套餐编号
     */
    private String lastFareKind;

    /**
     * 上一套餐编号(下一方案)
     */
    private String lastNextFareKind;
    /**
     * 审核状态
     */
    private String auditStatus;
    /**
     * 同步状态状态
     */
    private String syncStatus;

    /**
     * 父节点名字
     */
    private String parentName;

    /**
     * 归属大区的标号
     */
    private String areaCode;

    /**
     * 大区名
     */
    private String areaName;

    /**
     * 类型 （大区或者渠道）
     */
    private String type;

    /**
     * 渠道IDssss
     *
     * @return
     */
    private List<String> channelIds;
    /**
     * 树显示的名字
     */
    private String name;

    /**
     * 弹出菜单选择的 渠道号
     *
     * @return
     */
    private String checkedChannelId;
    /**
     * 菜单选择 多渠道号查询params
     *
     * @return
     */
    private List<String> checkedChannelIds;

    /**
     * 是否参加开户免佣
     */
    private String isFreeCommission;

    /**
     * 免佣期
     */
    private String freeCommissionDays;

    /**
     * 佣金套餐 方案编号
     */
    private String fareKind;

    /**
     * 佣金套餐 开始时间 、结束时间
     */
    private String beginDate;
    private String endDate;

    //付费数值
    private BigDecimal balanceRatio;
    //固定费用
    private BigDecimal feeCountFix;
    //最低费用
    private BigDecimal minFare;
    //最高费用
    private BigDecimal maxFare;
    //证券市场[K-港交所 P-美国市场]
    private String exchangeType;


    /**
     * 设置：记录ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：记录ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置：渠道ID
     */
    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    /**
     * 获取：渠道ID
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * 设置：渠道名称
     */
    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    /**
     * 获取：渠道名称
     */
    public String getChannelName() {
        return channelName;
    }

    /**
     * 设置：公司名称
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * 获取：公司名称
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 设置：渠道父ID
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取：渠道父ID
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 设置：预计接入点(1:首批)
     */
    public void setAccessPoint(String accessPoint) {
        this.accessPoint = accessPoint;
    }

    /**
     * 获取：预计接入点(1:首批)
     */
    public String getAccessPoint() {
        return accessPoint;
    }

    /**
     * 设置：导流方式（1:线上，2:线下）
     */
    public void setDiversMode(String diversMode) {
        this.diversMode = diversMode;
    }

    /**
     * 获取：导流方式（1:线上，2:线下）
     */
    public String getDiversMode() {
        return diversMode;
    }

    /**
     * 设置：注册用户规模
     */
    public void setRegisUserSize(Integer regisUserSize) {
        this.regisUserSize = regisUserSize;
    }

    /**
     * 获取：注册用户规模
     */
    public Integer getRegisUserSize() {
        return regisUserSize;
    }

    /**
     * 设置：备注
     */
    public void setRmk(String rmk) {
        this.rmk = rmk;
    }

    /**
     * 获取：备注
     */
    public String getRmk() {
        return rmk;
    }

    /**
     * 设置：创建人
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取：创建人
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置：修改人
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 获取：修改人
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置：创建日期
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取：创建日期
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 设置：修改日期
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取：修改日期
     */
    public String getUpdateTime() {
        return updateTime;
    }


    public String getCheckedChannelId() {
        return checkedChannelId;
    }

    public void setCheckedChannelId(String checkedChannelId) {
        this.checkedChannelId = checkedChannelId;
    }


    public List<String> getCheckedChannelIds() {
        return checkedChannelIds;
    }

    public void setCheckedChannelIds(List<String> checkedChannelIds) {
        this.checkedChannelIds = checkedChannelIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }


    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public List<String> getChannelIds() {
        return channelIds;
    }

    public void setChannelIds(List<String> channelIds) {
        this.channelIds = channelIds;
    }

    public String getIsFreeCommission() {
        return isFreeCommission;
    }

    public void setIsFreeCommission(String isFreeCommission) {
        this.isFreeCommission = isFreeCommission;
    }

    public String getFreeCommissionDays() {
        return freeCommissionDays;
    }

    public void setFreeCommissionDays(String freeCommissionDays) {
        this.freeCommissionDays = freeCommissionDays;
    }

    public String getFareKind() {
        return fareKind;
    }

    public void setFareKind(String fareKind) {
        this.fareKind = fareKind;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getNextFreeCommission() {
        return nextFreeCommission;
    }

    public void setNextFreeCommission(Integer nextFreeCommission) {
        this.nextFreeCommission = nextFreeCommission;
    }

    public Integer getNextFreeCommissionDays() {
        return nextFreeCommissionDays;
    }

    public void setNextFreeCommissionDays(Integer nextFreeCommissionDays) {
        this.nextFreeCommissionDays = nextFreeCommissionDays;
    }

    public String getNextFareKind() {
        return nextFareKind;
    }

    public void setNextFareKind(String nextFareKind) {
        this.nextFareKind = nextFareKind;
    }

    public String getNextEndDate() {
        return nextEndDate;
    }

    public void setNextEndDate(String nextEndDate) {
        this.nextEndDate = nextEndDate;
    }

    public String getNextBeginDate() {
        return nextBeginDate;
    }

    public void setNextBeginDate(String nextBeginDate) {
        this.nextBeginDate = nextBeginDate;
    }

    public String getLastFareKind() {
        return lastFareKind;
    }

    public void setLastFareKind(String lastFareKind) {
        this.lastFareKind = lastFareKind;
    }

    public String getLastNextFareKind() {
        return lastNextFareKind;
    }

    public void setLastNextFareKind(String lastNextFareKind) {
        this.lastNextFareKind = lastNextFareKind;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(String syncStatus) {
        this.syncStatus = syncStatus;
    }

    public BigDecimal getBalanceRatio() {
        return balanceRatio;
    }

    public void setBalanceRatio(BigDecimal balanceRatio) {
        this.balanceRatio = balanceRatio;
    }

    public BigDecimal getFeeCountFix() {
        return feeCountFix;
    }

    public void setFeeCountFix(BigDecimal feeCountFix) {
        this.feeCountFix = feeCountFix;
    }

    public BigDecimal getMinFare() {
        return minFare;
    }

    public void setMinFare(BigDecimal minFare) {
        this.minFare = minFare;
    }

    public BigDecimal getMaxFare() {
        return maxFare;
    }

    public void setMaxFare(BigDecimal maxFare) {
        this.maxFare = maxFare;
    }

    public String getExchangeType() {
        return exchangeType;
    }

    public void setExchangeType(String exchangeType) {
        this.exchangeType = exchangeType;
    }
}
