package com.sunline.modules.group.entity;

import java.io.Serializable;
import java.util.List;


/**
 * @author jim
 * @email
 * @date 2018-03-12 11:14:27
 */
public class ClientGroupMemberInfoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *  自增ID
     */
    private String id;

    /**
     * 分组编号
     */
    private Integer groupNo;
    /**
     * 交易帐号
     */
    private Integer clientId;
    /**
     * 客户姓名
     */
    private String clientName;
    /**
     * 联系电话
     */
    private String phoneNumber;
    /**
     *电子邮件
     */
    private String email;
    /**
     * 备注
     */
    private String remark;
    /**
     * 修改时间
     */
    private String createTime;
    /**
     * 修改时间
     */
    private String updateTime;

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
     * 设置：客户姓名
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * 获取：客户姓名
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * 设置：联系电话
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * 获取：联系电话
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 设置：电子邮件
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取：电子邮件
     */
    public String getEmail() {
        return email;
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


    /**
     * 小神号
     */
    private String userId;
    /**
     * 生日
     */
    private String birthday;
    /**
     * 性别
     */
    private String sex;
    /**
     * 客户编号
     */
    private String gid;

    /**
     * 渠道
     */
    private String sourceChannelName;
    /**
     * 渠道号
     */
    private String sourceChannelId;

    /**
     * 客户类型
     */

    private String clientType;
    private String clientStatus;
    /**
     * 渠道授权
     */
    private List<String> channelIds;

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
    public String getClientStatus() {
        return clientStatus;
    }

    public void setClientStatus(String clientStatus) {
        this.clientStatus = clientStatus;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getSourceChannelName() {
        return sourceChannelName;
    }

    public void setSourceChannelName(String sourceChannelName) {
        this.sourceChannelName = sourceChannelName;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getTradeAccount() {
        return tradeAccount;
    }

    public void setTradeAccount(String tradeAccount) {
        this.tradeAccount = tradeAccount;
    }

    /**
     * 交易账户
     */
    private String tradeAccount;

    public void setOpenAccountTime(String openAccountTime) {
        this.openAccountTime = openAccountTime;
    }

    public String getOpenAccountTime() {
        return openAccountTime;
    }

    public String getSourceChannelId() {
        return sourceChannelId;
    }

    public void setSourceChannelId(String sourceChannelId) {
        this.sourceChannelId = sourceChannelId;
    }

    /**
     * 开户日期
     */
    private String openAccountTime;
}
