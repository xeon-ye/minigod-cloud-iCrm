package com.sunline.modules.account.online.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * CA认证信息表
 *
 * @author lcs
 * @date 2019-01-17 10:10:43
 */
public class OpenAccountCaVerityInfoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //主键ID
    private Long id;
    //预约流水号
    private String applicationId;
    //用户证书主题
    private String caCertDn;
    //证书序列号
    private String caCertSn;
    //认证时间
    private Date certTime;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;

    private int userId;

    /**
     * 设置：主键ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：主键ID
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
     * 设置：用户证书主题
     */
    public void setCaCertDn(String caCertDn) {
        this.caCertDn = caCertDn;
    }

    /**
     * 获取：用户证书主题
     */
    public String getCaCertDn() {
        return caCertDn;
    }

    /**
     * 设置：证书序列号
     */
    public void setCaCertSn(String caCertSn) {
        this.caCertSn = caCertSn;
    }

    /**
     * 获取：证书序列号
     */
    public String getCaCertSn() {
        return caCertSn;
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

    public Date getCertTime() {
        return certTime;
    }

    public void setCertTime(Date certTime) {
        this.certTime = certTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
