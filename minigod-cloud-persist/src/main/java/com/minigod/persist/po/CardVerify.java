package com.minigod.persist.po;
import com.minigod.persist.tables.TCardVerify;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 银行卡四要素验证信息表
 */
@Entity(table=TCardVerify.class)
public class CardVerify implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long id;//主键
	private String userName;//用户名称
	private String cellPhone;//手机号
	private String idCard;//身份证
	private String bankCard;//银行卡号
	private Date createDate;//创建时间
	private Integer state;//状态(0:不通过 1:通过)
	private Integer verifyCount;//验证次数

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
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

    public String getIdCard () {
        return idCard;
    }

    public void setIdCard (String idCard) {
        this.idCard = idCard;
    }

    public String getBankCard () {
        return bankCard;
    }

    public void setBankCard (String bankCard) {
        this.bankCard = bankCard;
    }

    public Date getCreateDate () {
        return createDate;
    }

    public void setCreateDate (Date createDate) {
        this.createDate = createDate;
    }

    public Integer getState () {
        return state;
    }

    public void setState (Integer state) {
        this.state = state;
    }

    public Integer getVerifyCount () {
        return verifyCount;
    }

    public void setVerifyCount (Integer verifyCount) {
        this.verifyCount = verifyCount;
    }
}