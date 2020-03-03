package com.minigod.persist.po;
import com.minigod.persist.tables.TOpenAccountSt;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 商汤识别信息表
 */
@Entity(table=TOpenAccountSt.class)
public class OpenAccountSt implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long id;//主键
	private Integer userId;//用户ID
	private String idCardName;//姓名
	private String idCardSex;//性别
	private String idCardNation;//名族
	private String idCardDate;//出生日期
	private String idCardAddress;//住址
	private String idCardId;//公民身份证号
	private String idCardAuthority;//签发机关
	private String idCardValidity;//有效期
	private String bankCardNumber;//银行卡号
	private String bankName;//发卡行名称
	private String bankCardId;//发卡行标识代码
	private String bankCardType;//卡片类型
	private String bankCardName;//卡片名称
	private Date createTime = new Date();//修改时间
	private Date updateTime = new Date();//修改时间

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public String getIdCardName () {
        return idCardName;
    }

    public void setIdCardName (String idCardName) {
        this.idCardName = idCardName;
    }

    public String getIdCardSex () {
        return idCardSex;
    }

    public void setIdCardSex (String idCardSex) {
        this.idCardSex = idCardSex;
    }

    public String getIdCardNation () {
        return idCardNation;
    }

    public void setIdCardNation (String idCardNation) {
        this.idCardNation = idCardNation;
    }

    public String getIdCardDate () {
        return idCardDate;
    }

    public void setIdCardDate (String idCardDate) {
        this.idCardDate = idCardDate;
    }

    public String getIdCardAddress () {
        return idCardAddress;
    }

    public void setIdCardAddress (String idCardAddress) {
        this.idCardAddress = idCardAddress;
    }

    public String getIdCardId () {
        return idCardId;
    }

    public void setIdCardId (String idCardId) {
        this.idCardId = idCardId;
    }

    public String getIdCardAuthority () {
        return idCardAuthority;
    }

    public void setIdCardAuthority (String idCardAuthority) {
        this.idCardAuthority = idCardAuthority;
    }

    public String getIdCardValidity () {
        return idCardValidity;
    }

    public void setIdCardValidity (String idCardValidity) {
        this.idCardValidity = idCardValidity;
    }

    public String getBankCardNumber () {
        return bankCardNumber;
    }

    public void setBankCardNumber (String bankCardNumber) {
        this.bankCardNumber = bankCardNumber;
    }

    public String getBankName () {
        return bankName;
    }

    public void setBankName (String bankName) {
        this.bankName = bankName;
    }

    public String getBankCardId () {
        return bankCardId;
    }

    public void setBankCardId (String bankCardId) {
        this.bankCardId = bankCardId;
    }

    public String getBankCardType () {
        return bankCardType;
    }

    public void setBankCardType (String bankCardType) {
        this.bankCardType = bankCardType;
    }

    public String getBankCardName () {
        return bankCardName;
    }

    public void setBankCardName (String bankCardName) {
        this.bankCardName = bankCardName;
    }

    public Date getCreateTime () {
        return createTime;
    }

    public void setCreateTime (Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime () {
        return updateTime;
    }

    public void setUpdateTime (Date updateTime) {
        this.updateTime = updateTime;
    }
}