package com.sunline.modules.account.online.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 补充资料文件上传表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-09-28 11:39:54
 */
public class OpenAccountAdditionalFileEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private String id;
	//预约流水号
	private String applicationId;
	//关联ID（UUID）
	private String additionalId;
	//文件名
	private String fileName;
	//文件类型[0-图片 1-视频/音频 3-资料修改凭证 4-见证人证书]
	private Integer fileType;
	//存储文件名
	private String fileStorageName;
	//文件拓展名
	private String fileExtName;
	//指定存储点路径
	private String filePath;
	//创建人
	private String createUser;
	//更新人
	private String updateUser;
	//创建时间
	private Date createTime;
	//更新时间
	private Date updateTime;

	private String remark;

	private String createUserName;

    //地址集合
    private List<OpenAccountAdditionalFileEntity> pathList;
	/**
	 * 设置：主键ID
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：主键ID
	 */
	public String getId() {
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
	 * 设置：关联ID（UUID）
	 */
	public void setAdditionalId(String additionalId) {
		this.additionalId = additionalId;
	}
	/**
	 * 获取：关联ID（UUID）
	 */
	public String getAdditionalId() {
		return additionalId;
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
	 * 设置：文件类型[0-图片 1-视频/音频]
	 */
	public void setFileType(Integer fileType) {
		this.fileType = fileType;
	}
	/**
	 * 获取：文件类型[0-图片 1-视频/音频]
	 */
	public Integer getFileType() {
		return fileType;
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
	public void setFileExtName(String fileExtName) {
		this.fileExtName = fileExtName;
	}
	/**
	 * 获取：文件拓展名
	 */
	public String getFileExtName() {
		return fileExtName;
	}
	/**
	 * 设置：指定存储点路径
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	/**
	 * 获取：指定存储点路径
	 */
	public String getFilePath() {
		return filePath;
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

    public List<OpenAccountAdditionalFileEntity> getPathList() {
        return pathList;
    }

    public void setPathList(List<OpenAccountAdditionalFileEntity> pathList) {
        this.pathList = pathList;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }
}
