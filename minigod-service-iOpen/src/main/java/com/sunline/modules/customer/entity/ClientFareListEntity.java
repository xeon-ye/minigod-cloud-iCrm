package com.sunline.modules.customer.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 客户费率设置表
 * 
 * @author lcs
 * @email 
 * @date 2018-05-10 16:47:30
 */
public class ClientFareListEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//自增ID
	private Integer id;
	//交易帐号
	private Integer clientId;
	//资金帐号
	private Integer fundAccount;
	//证券市场[K-港交所 P-美国市场]
	private String exchangeType;
	//费用类型[0-服务费 1-交易费]
	private String fareDict;
	//收费方式[0-按百分比 1-按固定笔数 5-按固定股数]
	private String feeType;
	//付费数值
	private String feeCount;
	//固定费用
	private String feeCountFix;
	//最低费用
	private String minFare;
	//最高费用
	private String maxFare;
	//开始日期
	private Date beginDate;
	//结束日期
	private Date endDate;
	//创建时间
	private Date createTime;
	//修改时间
	private Date updateTime;
	//授权渠道
    private List<String> channelIds;
    //套餐编号
    private String fareKind;
    //上一套餐编号
    private String lastFareKind;
    //审核状态
    private String auditStatus;
    //同步状态
    private String syncStatus;
    //修改人
    private String updateUser;
    //Fid client佣金设置表Id
    private String fId;

    /**
     * 弹出菜单选择的 渠道号
     * @return
     */
    private String checkedChannelId;

    public String getCheckedChannelId() {
        return checkedChannelId;
    }

    public void setCheckedChannelId(String checkedChannelId) {
        this.checkedChannelId = checkedChannelId;
    }

    /**
     *  菜单选择 多渠道号查询params
     * @return
     */

    private List<String> checkedChannelIds;

    public List<String> getCheckedChannelIds() {
        return checkedChannelIds;
    }

    public void setCheckedChannelIds(List<String> checkedChannelIds) {
        this.checkedChannelIds = checkedChannelIds;
    }

    public List<String> getChannelIds() {
        return channelIds;
    }

    public void setChannelIds(List<String> channelIds) {
        this.channelIds = channelIds;
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
	 * 设置：交易帐号
	 */
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
	/**
	 * 获取：交易帐号
	 */
	public Integer getClientId() {
		return clientId;
	}
	/**
	 * 设置：资金帐号
	 */
	public void setFundAccount(Integer fundAccount) {
		this.fundAccount = fundAccount;
	}
	/**
	 * 获取：资金帐号
	 */
	public Integer getFundAccount() {
		return fundAccount;
	}
	/**
	 * 设置：证券市场[K-港交所 P-美国市场]
	 */
	public void setExchangeType(String exchangeType) {
		this.exchangeType = exchangeType;
	}
	/**
	 * 获取：证券市场[K-港交所 P-美国市场]
	 */
	public String getExchangeType() {
		return exchangeType;
	}
	/**
	 * 设置：费用类型[0-服务费 1-交易费]
	 */
	public void setFareDict(String fareDict) {
		this.fareDict = fareDict;
	}
	/**
	 * 获取：费用类型[0-服务费 1-交易费]
	 */
	public String getFareDict() {
		return fareDict;
	}
	/**
	 * 设置：收费方式[0-按百分比 1-按固定笔数 5-按固定股数]
	 */
	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}
	/**
	 * 获取：收费方式[0-按百分比 1-按固定笔数 5-按固定股数]
	 */
	public String getFeeType() {
		return feeType;
	}
	/**
	 * 设置：付费数值
	 */
	public void setFeeCount(String feeCount) {
		this.feeCount = feeCount;
	}
	/**
	 * 获取：付费数值
	 */
	public String getFeeCount() {
		return feeCount;
	}
	/**
	 * 设置：固定费用
	 */
	public void setFeeCountFix(String feeCountFix) {
		this.feeCountFix = feeCountFix;
	}
	/**
	 * 获取：固定费用
	 */
	public String getFeeCountFix() {
		return feeCountFix;
	}
	/**
	 * 设置：最低费用
	 */
	public void setMinFare(String minFare) {
		this.minFare = minFare;
	}
	/**
	 * 获取：最低费用
	 */
	public String getMinFare() {
		return minFare;
	}
	/**
	 * 设置：最高费用
	 */
	public void setMaxFare(String maxFare) {
		this.maxFare = maxFare;
	}
	/**
	 * 获取：最高费用
	 */
	public String getMaxFare() {
		return maxFare;
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

    /**
     * 小神号
     */
	private String userId;
    /**
     * 用户名
     */
	private String clientName;
    /**
     * 渠道名
     */
    private String channelName;
    /**
     * 渠道名
     */
    private String channelId;

    /**
     * 佣金修改时间
     */
    private String modifyTime;

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getFareKind() {
        return fareKind;
    }

    public void setFareKind(String fareKind) {
        this.fareKind = fareKind;
    }

    public String getLastFareKind() {
        return lastFareKind;
    }

    public void setLastFareKind(String lastFareKind) {
        this.lastFareKind = lastFareKind;
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

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getfId() {
        return fId;
    }

    public void setfId(String fId) {
        this.fId = fId;
    }
}
