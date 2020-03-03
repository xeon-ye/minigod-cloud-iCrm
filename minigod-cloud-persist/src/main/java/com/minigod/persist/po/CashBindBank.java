package com.minigod.persist.po;
import com.minigod.persist.tables.TCashBindBank;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 自媒体支付绑定银行卡
 */
@Entity(table=TCashBindBank.class)
public class CashBindBank implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long bindId;//主键
	private Integer userId;//用户ID
	private String userName;//持卡人姓名
	private String cellPhone;//手机号
	private String idCardNo;//身份证号
	private String bankCode;//银行卡代码
	private String bankName;//银行卡名称
	private String bankNo;//银行卡号
	private Boolean isStatus = true;//绑定状态
	private Date createTime;//创建时间
	private Date updateTime;//修改时间

    public Long getBindId () {
        return bindId;
    }

    public void setBindId (Long bindId) {
        this.bindId = bindId;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public String getUserName () {
        return userName;
    }

    public void setUserName (String userName) {
        this.userName = userName;
    }

    public String getCellPhone () {
        return cellPhone;
    }

    public void setCellPhone (String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getIdCardNo () {
        return idCardNo;
    }

    public void setIdCardNo (String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public String getBankCode () {
        return bankCode;
    }

    public void setBankCode (String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName () {
        return bankName;
    }

    public void setBankName (String bankName) {
        this.bankName = bankName;
    }

    public String getBankNo () {
        return bankNo;
    }

    public void setBankNo (String bankNo) {
        this.bankNo = bankNo;
    }

    public Boolean getIsStatus () {
        return isStatus;
    }

    public void setIsStatus (Boolean isStatus) {
        this.isStatus = isStatus;
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