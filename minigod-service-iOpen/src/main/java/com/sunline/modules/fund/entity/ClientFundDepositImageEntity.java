package com.sunline.modules.fund.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 凭证存储表
 * 
 * @author lidh
 * @email jim@zszhizhu.com
 * @date 2019-06-01 14:52:30
 */
public class ClientFundDepositImageEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//自增ID
	private Long id;
	//预约流水号
	private String applicationId;
	//凭证类型[0-入金客户凭证 1-入金银行凭证 2-专业投资者资产凭证 3-专业投资者补充凭证]
	private Integer imageType;
	//文件名
	private String fileName;
	//存储文件名
	private String fileStorageName;
	//文件拓展名
	private String extName;
	//指定存储点路径
	private String storagePath;
	//创建人
	private String createUser;
	//更新人
	private String updateUser;
	//创建时间
	private Date createTime;
	//更新时间
	private Date updateTime;
	//备注
	private String remark;

	/**
	 * 设置：自增ID
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：自增ID
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：预约流水号
	 */
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
	/**
	 * 获取：预约流水号
	 */
	public String getApplicationId() {
		return applicationId;
	}
	/**
	 * 设置：凭证类型[0-客户凭证 1-银行凭证]
	 */
	public void setImageType(Integer imageType) {
		this.imageType = imageType;
	}
	/**
	 * 获取：凭证类型[0-客户凭证 1-银行凭证]
	 */
	public Integer getImageType() {
		return imageType;
	}
	/**
	 * 设置：文件名
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * 获取：文件名
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * 设置：存储文件名
	 */
	public void setFileStorageName(String fileStorageName) {
		this.fileStorageName = fileStorageName;
	}
	/**
	 * 获取：存储文件名
	 */
	public String getFileStorageName() {
		return fileStorageName;
	}
	/**
	 * 设置：文件拓展名
	 */
	public void setExtName(String extName) {
		this.extName = extName;
	}
	/**
	 * 获取：文件拓展名
	 */
	public String getExtName() {
		return extName;
	}
	/**
	 * 设置：指定存储点路径
	 */
	public void setStoragePath(String storagePath) {
		this.storagePath = storagePath;
	}
	/**
	 * 获取：指定存储点路径
	 */
	public String getStoragePath() {
		return storagePath;
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
	 * 设置：更新人
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	/**
	 * 获取：更新人
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
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
}
