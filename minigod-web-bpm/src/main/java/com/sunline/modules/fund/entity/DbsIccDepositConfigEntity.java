package com.sunline.modules.fund.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * DBS入金参数配置
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2020-03-04 16:45:18
 */
public class DbsIccDepositConfigEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //自增ID
    private Long id;
    //币种
    private String ccy;
    //入金上限金额
    private BigDecimal maxAmount;
    //生效时间
    private Date validTime;
    //失效时间
    private Date invalidTime;
    //失效状态[0-否 1-是]
    private Integer isInvalid;
    //创建用户
    private String createUser;
    //更新用户
    private String updateUser;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;

    private Integer status;

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
     * 设置：币种
     */
    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    /**
     * 获取：币种
     */
    public String getCcy() {
        return ccy;
    }

    /**
     * 设置：入金上限金额
     */
    public void setMaxAmount(BigDecimal maxAmount) {
        this.maxAmount = maxAmount;
    }

    /**
     * 获取：入金上限金额
     */
    public BigDecimal getMaxAmount() {
        return maxAmount;
    }

    /**
     * 设置：生效时间
     */
    public void setValidTime(Date validTime) {
        this.validTime = validTime;
    }

    /**
     * 获取：生效时间
     */
    public Date getValidTime() {
        return validTime;
    }

    /**
     * 设置：失效时间
     */
    public void setInvalidTime(Date invalidTime) {
        this.invalidTime = invalidTime;
    }

    /**
     * 获取：失效时间
     */
    public Date getInvalidTime() {
        return invalidTime;
    }

    /**
     * 设置：失效状态[0-否 1-是]
     */
    public void setIsInvalid(Integer isInvalid) {
        this.isInvalid = isInvalid;
    }

    /**
     * 获取：失效状态[0-否 1-是]
     */
    public Integer getIsInvalid() {
        return isInvalid;
    }

    /**
     * 设置：创建用户
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * 获取：创建用户
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 设置：更新用户
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * 获取：更新用户
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
