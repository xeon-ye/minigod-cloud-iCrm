package com.sunline.modules.account.online.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 客户开户申请图片信息表
 *
 * @author lcs
 * @email
 * @date 2018-09-28 14:10:21
 */
public class CustomerAccountOpenImgEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //自增ID
    private Long id;
    //预约流水号
    private String applicationId;
    //文件名
    private String fileName;
    //存储文件名
    private String fileStorageName;
    //文件拓展名
    private String extName;
    //	//客户资料ID[dataRef customer_account_open_info]
//	private String customerAccountOpenInfoId;
    //图片位置[0=未知 1=身份证正面照坐标 2=身份证反面照片坐标 3=指定动作1照坐标 4=指定动作2照坐标 5=指定动作3照坐标 6=电子签名照坐标]
    private Integer imageLocation;
    //图片位置类型[0=未知 1=身份证正面照 2=身份证反面照片 3=左手竖起1个指头 4=右手竖起1个指头 5=左手竖起2个指头 6=右手竖起2个指头 7=左手竖起3个指头 8=右手竖起3个指头 9=正面照 10=电子签名照]
    private Integer imageLocationType;
    //指定存储点路径
    private String storagePath;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
    //备注
    private String remark;

    private String createUser;
    private String updateUser;

    public CustomerAccountOpenImgEntity() {

    }

    public CustomerAccountOpenImgEntity(Integer imageLocationType, String fileName) {
        super();
        this.imageLocationType = imageLocationType;
        this.fileName = fileName;
    }

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
     * 设置：图片位置[0=未知 1=身份证正面照坐标 2=身份证反面照片坐标 3=指定动作1照坐标 4=指定动作2照坐标 5=指定动作3照坐标 6=电子签名照坐标]
     */
    public void setImageLocation(Integer imageLocation) {
        this.imageLocation = imageLocation;
    }

    /**
     * 获取：图片位置[0=未知 1=身份证正面照坐标 2=身份证反面照片坐标 3=指定动作1照坐标 4=指定动作2照坐标 5=指定动作3照坐标 6=电子签名照坐标]
     */
    public Integer getImageLocation() {
        return imageLocation;
    }

    /**
     * 设置：图片位置类型[0=未知 1=身份证正面照 2=身份证反面照片 3=左手竖起1个指头 4=右手竖起1个指头 5=左手竖起2个指头 6=右手竖起2个指头 7=左手竖起3个指头 8=右手竖起3个指头 9=正面照 10=电子签名照]
     */
    public void setImageLocationType(Integer imageLocationType) {
        this.imageLocationType = imageLocationType;
    }

    /**
     * 获取：图片位置类型[0=未知 1=身份证正面照 2=身份证反面照片 3=左手竖起1个指头 4=右手竖起1个指头 5=左手竖起2个指头 6=右手竖起2个指头 7=左手竖起3个指头 8=右手竖起3个指头 9=正面照 10=电子签名照]
     */
    public Integer getImageLocationType() {
        return imageLocationType;
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

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else {
            if (obj instanceof CustomerAccountOpenImgEntity) {
                CustomerAccountOpenImgEntity entity = (CustomerAccountOpenImgEntity) obj;
                return this.fileName.equals(entity.fileName)
                        && this.imageLocationType.equals(entity.getImageLocationType());
            }
            return super.equals(obj);
        }
    }
}
