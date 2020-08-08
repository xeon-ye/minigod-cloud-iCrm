package com.sunline.modules.account.online.entity;

import java.io.Serializable;
import java.util.Date;

public class AyersClientInfoEntity implements Serializable {
    private String uuid;
    private String clientId;
    //名字（默认英文）
    private String name;
    //名字繁体
    private String big5Names;
    //名字简体
    private String gbNames;
    //名字英文
    private String engNames;
    private String idType;
    private String idCode;
    private String aeCode;
    private String email;
    private String phone;
    private String otherPhone;
    private String addr_1;
    private String addr_2;
    private String addr_3;
    private String addr_4;
    private String gender;
    private Date dateOfBirth;
    private String clientGroupCode;
    private String clientType;
    private String statementLang;
    //国籍
    private String nationality;
    private String stmtEmail;
    //每月发送邮件
    private String stmtEmailMonthly;
    private String stmtMail;
    private String stmtMailMonthly;
    private String fax;
    private String contactPerson;
    private String employmentName;
    private String payeeBankCode;
    private String payeeBankAcc;
    private String occupation;
    private String stmtFax;
    private String createUser;
    private Date createTime;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBig5Names() {
        return big5Names;
    }

    public void setBig5Names(String big5Names) {
        this.big5Names = big5Names;
    }

    public String getGbNames() {
        return gbNames;
    }

    public void setGbNames(String gbNames) {
        this.gbNames = gbNames;
    }

    public String getEngNames() {
        return engNames;
    }

    public void setEngNames(String engNames) {
        this.engNames = engNames;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public String getAeCode() {
        return aeCode;
    }

    public void setAeCode(String aeCode) {
        this.aeCode = aeCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOtherPhone() {
        return otherPhone;
    }

    public void setOtherPhone(String otherPhone) {
        this.otherPhone = otherPhone;
    }

    public String getAddr_1() {
        return addr_1;
    }

    public void setAddr_1(String addr_1) {
        this.addr_1 = addr_1;
    }

    public String getAddr_2() {
        return addr_2;
    }

    public void setAddr_2(String addr_2) {
        this.addr_2 = addr_2;
    }

    public String getAddr_3() {
        return addr_3;
    }

    public void setAddr_3(String addr_3) {
        this.addr_3 = addr_3;
    }

    public String getAddr_4() {
        return addr_4;
    }

    public void setAddr_4(String addr_4) {
        this.addr_4 = addr_4;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getClientGroupCode() {
        return clientGroupCode;
    }

    public void setClientGroupCode(String clientGroupCode) {
        this.clientGroupCode = clientGroupCode;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getStatementLang() {
        return statementLang;
    }

    public void setStatementLang(String statementLang) {
        this.statementLang = statementLang;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getStmtEmail() {
        return stmtEmail;
    }

    public void setStmtEmail(String stmtEmail) {
        this.stmtEmail = stmtEmail;
    }

    public String getStmtEmailMonthly() {
        return stmtEmailMonthly;
    }

    public void setStmtEmailMonthly(String stmtEmailMonthly) {
        this.stmtEmailMonthly = stmtEmailMonthly;
    }

    public String getStmtMail() {
        return stmtMail;
    }

    public void setStmtMail(String stmtMail) {
        this.stmtMail = stmtMail;
    }

    public String getStmtMailMonthly() {
        return stmtMailMonthly;
    }

    public void setStmtMailMonthly(String stmtMailMonthly) {
        this.stmtMailMonthly = stmtMailMonthly;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getEmploymentName() {
        return employmentName;
    }

    public void setEmploymentName(String employmentName) {
        this.employmentName = employmentName;
    }

    public String getPayeeBankCode() {
        return payeeBankCode;
    }

    public void setPayeeBankCode(String payeeBankCode) {
        this.payeeBankCode = payeeBankCode;
    }

    public String getPayeeBankAcc() {
        return payeeBankAcc;
    }

    public void setPayeeBankAcc(String payeeBankAcc) {
        this.payeeBankAcc = payeeBankAcc;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getStmtFax() {
        return stmtFax;
    }

    public void setStmtFax(String stmtFax) {
        this.stmtFax = stmtFax;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
