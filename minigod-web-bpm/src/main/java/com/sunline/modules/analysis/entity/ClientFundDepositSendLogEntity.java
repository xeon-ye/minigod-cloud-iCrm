package com.sunline.modules.analysis.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 客户出入金信息发送日志表
 * 
 * @author LiYangFeng
 * @email justbelyf@gmail.com
 * @date 2018-07-10 15:22:34
 */
public class ClientFundDepositSendLogEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//自增ID
	private Integer id;
	//出入金定位串(唯一标识)
	private String positionStr;
	//发送状态[0-未发送 1-已发送]
	private Integer sendStatus;
    // 发送类型[0-出入金 1-转仓]
	private Integer sendType;
	// 首次入金标识[0-否 1-是]
	private Integer isFirst;
	//创建时间
	private Date createTime;
	//修改时间
	private Date updateTime;

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
	 * 设置：出入金定位串(唯一标识)
	 */
	public void setPositionStr(String positionStr) {
		this.positionStr = positionStr;
	}
	/**
	 * 获取：出入金定位串(唯一标识)
	 */
	public String getPositionStr() {
		return positionStr;
	}
	/**
	 * 设置：发送状态[0-未发送 1-已发送]
	 */
	public void setSendStatus(Integer sendStatus) {
		this.sendStatus = sendStatus;
	}
	/**
	 * 获取：发送状态[0-未发送 1-已发送]
	 */
	public Integer getSendStatus() {
		return sendStatus;
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

    public Integer getSendType() {
        return sendType;
    }

    public void setSendType(Integer sendType) {
        this.sendType = sendType;
    }

    public Integer getIsFirst() {
        return isFirst;
    }

    public void setIsFirst(Integer isFirst) {
        this.isFirst = isFirst;
    }
}
