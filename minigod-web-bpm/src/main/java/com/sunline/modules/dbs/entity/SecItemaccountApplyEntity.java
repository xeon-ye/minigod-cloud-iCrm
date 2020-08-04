package com.sunline.modules.dbs.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 中银子账号配置表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2019-07-03 11:22:55
 */
public class SecItemaccountApplyEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private Long id;
	//申请人账号
	private Long outsideId;
	//
	private Integer userId;
	//申请人英文名称
	private String userNameEn;
	//申请人中文名称
	private String userNameCn;
	//申请状态 0申请中1申请成功2失效3审核中
	private Integer state;
	//创建时间
	private Date createTime;
	//更新时间
	private Date updateTime;
	//中银子账号
	private String subAccountNo;
	//资金账号
	private String fundAccount;
	//交易账号
	private String clientId;
	//是否查询全部
	private Integer isFind;
	//申请人户名
	private String accountName;
	//导出状态 0未导出 1已导出
	private Integer exportState;

	/**
	 * 设置：主键
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：主键
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：申请人账号
	 */
	public void setOutsideId(Long outsideId) {
		this.outsideId = outsideId;
	}
	/**
	 * 获取：申请人账号
	 */
	public Long getOutsideId() {
		return outsideId;
	}
	/**
	 * 设置：
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * 获取：
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * 设置：申请人英文名称
	 */
	public void setUserNameEn(String userNameEn) {
		this.userNameEn = userNameEn;
	}
	/**
	 * 获取：申请人英文名称
	 */
	public String getUserNameEn() {
		return userNameEn;
	}
	/**
	 * 设置：申请人中文名称
	 */
	public void setUserNameCn(String userNameCn) {
		this.userNameCn = userNameCn;
	}
	/**
	 * 获取：申请人中文名称
	 */
	public String getUserNameCn() {
		return userNameCn;
	}
	/**
	 * 设置：申请状态 0申请中1申请成功2失效3审核中
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * 获取：申请状态 0申请中1申请成功2失效3审核中
	 */
	public Integer getState() {
		return state;
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
	 * 设置：更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：中银子账号
	 */
	public void setSubAccountNo(String subAccountNo) {
		this.subAccountNo = subAccountNo;
	}
	/**
	 * 获取：中银子账号
	 */
	public String getSubAccountNo() {
		return subAccountNo;
	}
	/**
	 * 设置：资金账号
	 */
	public void setFundAccount(String fundAccount) {
		this.fundAccount = fundAccount;
	}
	/**
	 * 获取：资金账号
	 */
	public String getFundAccount() {
		return fundAccount;
	}
	/**
	 * 设置：交易账号
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	/**
	 * 获取：交易账号
	 */
	public String getClientId() {
		return clientId;
	}
	/**
	 * 设置：是否查询全部
	 */
	public void setIsFind(Integer isFind) {
		this.isFind = isFind;
	}
	/**
	 * 获取：是否查询全部
	 */
	public Integer getIsFind() {
		return isFind;
	}
	/**
	 * 设置：申请人户名
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	/**
	 * 获取：申请人户名
	 */
	public String getAccountName() {
		return accountName;
	}
	/**
	 * 设置：导出状态 0未导出 1已导出
	 */
	public void setExportState(Integer exportState) {
		this.exportState = exportState;
	}
	/**
	 * 获取：导出状态 0未导出 1已导出
	 */
	public Integer getExportState() {
		return exportState;
	}
}
