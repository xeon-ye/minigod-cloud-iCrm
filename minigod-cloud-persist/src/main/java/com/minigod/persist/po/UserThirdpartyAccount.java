package com.minigod.persist.po;
import com.minigod.persist.tables.TUserThirdpartyAccount;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TUserThirdpartyAccount.class)
public class UserThirdpartyAccount implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer id;
	private Integer userId;
	private Integer accType;
	private String accountNo;
	private Integer accStatus;
	private Date regTime;
	private Date delTime;

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public Integer getAccType () {
        return accType;
    }

    public void setAccType (Integer accType) {
        this.accType = accType;
    }

    public String getAccountNo () {
        return accountNo;
    }

    public void setAccountNo (String accountNo) {
        this.accountNo = accountNo;
    }

    public Integer getAccStatus () {
        return accStatus;
    }

    public void setAccStatus (Integer accStatus) {
        this.accStatus = accStatus;
    }

    public Date getRegTime () {
        return regTime;
    }

    public void setRegTime (Date regTime) {
        this.regTime = regTime;
    }

    public Date getDelTime () {
        return delTime;
    }

    public void setDelTime (Date delTime) {
        this.delTime = delTime;
    }
}