package com.sunline.modules.group.entity;

import java.io.Serializable;


/**
 * @author jim
 * @email
 * @date 2018-03-12 11:14:27
 */
public class ClientGroupManagerEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *  自增ID
     */
    private String id;
    /**
     *  分组编号
     */
    private Integer groupNo;
    /**
     * 分组名称
     */
    private String groupName;
    /**
     * 分组类型[0-CRM组 1-非CRM组]
     */
    private String groupType;
    /**
     * 备注
     */
    private String remark;
    /**
     * /创建人
     */
    private String createUser;
    /**
     * 修改人
     */
    private String modifyUser;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 修改时间
     */
    private String updateTime;


    /**
     * 分组人数
     */
    public String getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(String clientNumber) {
        this.clientNumber = clientNumber;
    }

    private String clientNumber;

    /**
     * 设置：自增ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取：自增ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置：分组编号
     */
    public void setGroupNo(Integer groupNo) {
        this.groupNo = groupNo;
    }

    /**
     * 获取：分组编号
     */
    public Integer getGroupNo() {
        return groupNo;
    }

    /**
     * 设置：分组名称
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * 获取：分组名称
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * 设置：分组类型[0-CRM组 1-非CRM组]
     */
    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    /**
     * 获取：分组类型[0-CRM组 1-非CRM组]
     */
    public String getGroupType() {
        return groupType;
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
     * 设置：修改人
     */
    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    /**
     * 获取：修改人
     */
    public String getModifyUser() {
        return modifyUser;
    }

    /**
     * 设置：创建时间
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取：创建时间
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 设置：修改时间
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取：修改时间
     */
    public String getUpdateTime() {
        return updateTime;
    }
}
