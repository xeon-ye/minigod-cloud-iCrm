package com.sunline.modules.marker.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

public class CompBusiPersonModel extends BaseRowModel{

    @ExcelProperty(value = "序号",index = 0)
    private Integer id;

    @ExcelProperty(value = "员工姓名",index = 1)
    private String personnelName;
    /**
     * 员工角色[0-经理人 1-见证人]
     */
    @ExcelProperty(value = "员工角色",index = 2)
    private String personnelRole;
    /**
     * 性别[0-未知 1-男 2-女]
     */
    @ExcelProperty(value = "性别",index = 3)
    private String sex;
    /**
     * 学历[0-其他 1-博士 2-硕士 3-学士 4-大专 5-中专 6-高中 7-初中及其以下]
     */
    @ExcelProperty(value = "学历",index = 4)
    private String educationType;
    /**
     * 员工状态[0-删除 1-正常 2-禁用 3-离职 4-待审核 5-审核不通过]
     */
    @ExcelProperty(value = "员工状态",index = 5)
    private String personnelStatus;

    @ExcelProperty(value = "出生日期",index = 6)
    private String birthdayDate;
    /**
     *  证件类型[0-其他有效证件 1-身份证 2-本国护照 3-国外护照 4-台湾通行证及其他有效旅行证 5-武警文职干部证 6-13 武警士兵证  7-社会团体 8-临时身份证 9-全国组织机构代码 10-海外客户编号 11-境外身份证 12-港澳台居民身份证 13-营业执照]
     */
    @ExcelProperty(value = "证件类型",index = 7)
    private String idType;

    @ExcelProperty(value = "证件号码",index = 8)
    private String idNo;

    @ExcelProperty(value = "职位",index = 9)
    private String jobPosition;

    @ExcelProperty(value = "证券从业资格证编号",index = 10)
    private String sacNo;

    @ExcelProperty(value = "见证资格证编号",index = 11)
    private String witnessNo;

    @ExcelProperty(value = "办公电话",index = 12)
    private String officePhone;

    @ExcelProperty(value = "移动电话",index = 13)
    private String mobilePhone;

    @ExcelProperty(value = "家庭电话",index = 14)
    private String homePhone;

    @ExcelProperty(value = "传真电话",index = 15)
    private String faxPhone;

    @ExcelProperty(value = "联系地址",index = 16)
    private String contactAddress;

    @ExcelProperty(value = "邮编号码",index = 17)
    private String postCode;

    @ExcelProperty(value = "电子邮件",index = 18)
    private String email;

    @ExcelProperty(value = "邀约码",index = 19)
    private String aeCode;

    @ExcelProperty(value = "创建人",index = 20)
    private String createUser;

    @ExcelProperty(value = "修改人",index = 21)
    private String modifyUser;

    @ExcelProperty(value = "创建时间",index = 22)
    private String createTime;

    @ExcelProperty(value = "修改时间",index = 23)
    private String updateTime;

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
     * 设置：员工姓名
     */
    public void setPersonnelName(String personnelName) {
        this.personnelName = personnelName;
    }
    /**
     * 获取：员工姓名
     */
    public String getPersonnelName() {
        return personnelName;
    }
    /**
     * 设置：员工角色[0-经理人 1-见证人]
     */
    public void setPersonnelRole(String personnelRole) {
        this.personnelRole = personnelRole;
    }
    /**
     * 获取：员工角色[0-经理人 1-见证人]
     */
    public String getPersonnelRole() {
        return personnelRole;
    }
    /**
     * 设置：性别[0-未知 1-男 2-女]
     */
    public void setSex(String sex) {
        this.sex = sex;
    }
    /**
     * 获取：性别[0-未知 1-男 2-女]
     */
    public String getSex() {
        return sex;
    }
    /**
     * 设置：学历[0-其他 1-博士 2-硕士 3-学士 4-大专 5-中专 6-高中 7-初中及其以下]
     */
    public void setEducationType(String educationType) {
        this.educationType = educationType;
    }
    /**
     * 获取：学历[0-其他 1-博士 2-硕士 3-学士 4-大专 5-中专 6-高中 7-初中及其以下]
     */
    public String getEducationType() {
        return educationType;
    }
    /**
     * 设置：员工状态[0-删除 1-正常 2-禁用 3-离职 4-待审核 5-审核不通过]
     */
    public void setPersonnelStatus(String personnelStatus) {
        this.personnelStatus = personnelStatus;
    }
    /**
     * 获取：员工状态[0-删除 1-正常 2-禁用 3-离职 4-待审核 5-审核不通过]
     */
    public String getPersonnelStatus() {
        return personnelStatus;
    }
    /**
     * 设置：出生日期
     */
    public void setBirthdayDate(String birthdayDate) {
        this.birthdayDate = birthdayDate;
    }
    /**
     * 获取：出生日期
     */
    public String getBirthdayDate() {
        return birthdayDate;
    }
    /**
     * 设置：证件类型[0-其他有效证件 1-身份证 2-本国护照 3-国外护照 4-台湾通行证及其他有效旅行证 5-武警文职干部证 6-13 武警士兵证  7-社会团体 8-临时身份证 9-全国组织机构代码 10-海外客户编号 11-境外身份证 12-港澳台居民身份证 13-营业执照]
     */
    public void setIdType(String idType) {
        this.idType = idType;
    }
    /**
     * 获取：证件类型[0-其他有效证件 1-身份证 2-本国护照 3-国外护照 4-台湾通行证及其他有效旅行证 5-武警文职干部证 6-13 武警士兵证  7-社会团体 8-临时身份证 9-全国组织机构代码 10-海外客户编号 11-境外身份证 12-港澳台居民身份证 13-营业执照]
     */
    public String getIdType() {
        return idType;
    }
    /**
     * 设置：证件号码
     */
    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }
    /**
     * 获取：证件号码
     */
    public String getIdNo() {
        return idNo;
    }
    /**
     * 设置：职位
     */
    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }
    /**
     * 获取：职位
     */
    public String getJobPosition() {
        return jobPosition;
    }
    /**
     * 设置：证券从业资格证编号
     */
    public void setSacNo(String sacNo) {
        this.sacNo = sacNo;
    }
    /**
     * 获取：证券从业资格证编号
     */
    public String getSacNo() {
        return sacNo;
    }
    /**
     * 设置：见证资格证编号
     */
    public void setWitnessNo(String witnessNo) {
        this.witnessNo = witnessNo;
    }
    /**
     * 获取：见证资格证编号
     */
    public String getWitnessNo() {
        return witnessNo;
    }
    /**
     * 设置：办公电话
     */
    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }
    /**
     * 获取：办公电话
     */
    public String getOfficePhone() {
        return officePhone;
    }
    /**
     * 设置：移动电话
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
    /**
     * 获取：移动电话
     */
    public String getMobilePhone() {
        return mobilePhone;
    }
    /**
     * 设置：家庭电话
     */
    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }
    /**
     * 获取：家庭电话
     */
    public String getHomePhone() {
        return homePhone;
    }
    /**
     * 设置：传真电话
     */
    public void setFaxPhone(String faxPhone) {
        this.faxPhone = faxPhone;
    }
    /**
     * 获取：传真电话
     */
    public String getFaxPhone() {
        return faxPhone;
    }
    /**
     * 设置：联系地址
     */
    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }
    /**
     * 获取：联系地址
     */
    public String getContactAddress() {
        return contactAddress;
    }
    /**
     * 设置：邮编号码
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
    /**
     * 获取：邮编号码
     */
    public String getPostCode() {
        return postCode;
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
     * 设置：邀约码
     */
    public void setAeCode(String aeCode) {
        this.aeCode = aeCode;
    }
    /**
     * 获取：邀约码
     */
    public String getAeCode() {
        return aeCode;
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
