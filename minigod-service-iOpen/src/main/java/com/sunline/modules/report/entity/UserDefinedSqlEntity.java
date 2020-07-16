package com.sunline.modules.report.entity;


import java.io.Serializable;
import java.util.Date;

/**
 * 用户自定义数据库查询表
 *
 * @author fuyy
 * @email
 * @date 2018-11-30 14:22:50
 */
public class UserDefinedSqlEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //自增ID
    private Integer id;
    //查询结果列字段名称，使用竖线分隔："|"
    private String defTitle;
    //sql语句
    private String defSql;
    //sql的功能描述
    private String defDesc;
    //备注：注意事项，字段说明等
    private String defRemark;
    //创建人
    private String createOpr;
    //更新人
    private String updateOpr;
    //状态，0无效，1有效
    private Integer isStatus;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
    //起始时间
    private String beginDate;
    //结束时间
    private String endDate;
    private String params;
    private String authUserList;

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
     * 设置：查询结果列字段名称，使用竖线分隔："|"
     */
    public void setDefTitle(String defTitle) {
        this.defTitle = defTitle;
    }
    /**
     * 获取：查询结果列字段名称，使用竖线分隔："|"
     */
    public String getDefTitle() {
        return defTitle;
    }
    /**
     * 设置：sql语句
     */
    public void setDefSql(String defSql) {
        this.defSql = defSql;
    }
    /**
     * 获取：sql语句
     */
    public String getDefSql() {
        return defSql;
    }
    /**
     * 设置：sql的功能描述
     */
    public void setDefDesc(String defDesc) {
        this.defDesc = defDesc;
    }
    /**
     * 获取：sql的功能描述
     */
    public String getDefDesc() {
        return defDesc;
    }
    /**
     * 设置：备注：注意事项，字段说明等
     */
    public void setDefRemark(String defRemark) {
        this.defRemark = defRemark;
    }
    /**
     * 获取：备注：注意事项，字段说明等
     */
    public String getDefRemark() {
        return defRemark;
    }
    /**
     * 设置：创建人
     */
    public void setCreateOpr(String createOpr) {
        this.createOpr = createOpr;
    }
    /**
     * 获取：创建人
     */
    public String getCreateOpr() {
        return createOpr;
    }
    /**
     * 设置：更新人
     */
    public void setUpdateOpr(String updateOpr) {
        this.updateOpr = updateOpr;
    }
    /**
     * 获取：更新人
     */
    public String getUpdateOpr() {
        return updateOpr;
    }
    /**
     * 设置：状态，0无效，1有效
     */
    public void setIsStatus(Integer isStatus) {
        this.isStatus = isStatus;
    }
    /**
     * 获取：状态，0无效，1有效
     */
    public Integer getIsStatus() {
        return isStatus;
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

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getAuthUserList() {
        return authUserList;
    }

    public void setAuthUserList(String authUserList) {
        this.authUserList = authUserList;
    }
}