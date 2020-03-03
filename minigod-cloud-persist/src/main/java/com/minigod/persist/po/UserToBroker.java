package com.minigod.persist.po;
import com.minigod.persist.tables.TUserToBroker;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户关联券商信息
 */
@Entity(table=TUserToBroker.class)
public class UserToBroker implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long id;//主键
	private Integer userId;//犇犇号
	private String cellPhone;//手机号码
	private Integer brokerType;//券商类型
	private String brokerName;//券商名称
	private Boolean isBinding = false;//是否绑定(1:已绑定 0:未绑定 )
	private Date openAccountTime;//开户时间，最后一次点击开户按钮时间
	private Integer openAccountCount = 0;//开户次数，点击开户按钮次数
	private Date bindingTime;//绑定时间，最后一次点击绑定按钮时间
	private Integer bindingCount = 0;//绑定次数，点击绑定按钮次数
	private Date transactionTime;//交易时间，最后一次点击时间(绑定后统计)
	private Integer transactionCount = 0;//交易次数,访问交易table次数

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

    public String getCellPhone () {
        return cellPhone;
    }

    public void setCellPhone (String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public Integer getBrokerType () {
        return brokerType;
    }

    public void setBrokerType (Integer brokerType) {
        this.brokerType = brokerType;
    }

    public String getBrokerName () {
        return brokerName;
    }

    public void setBrokerName (String brokerName) {
        this.brokerName = brokerName;
    }

    public Boolean getIsBinding () {
        return isBinding;
    }

    public void setIsBinding (Boolean isBinding) {
        this.isBinding = isBinding;
    }

    public Date getOpenAccountTime () {
        return openAccountTime;
    }

    public void setOpenAccountTime (Date openAccountTime) {
        this.openAccountTime = openAccountTime;
    }

    public Integer getOpenAccountCount () {
        return openAccountCount;
    }

    public void setOpenAccountCount (Integer openAccountCount) {
        this.openAccountCount = openAccountCount;
    }

    public Date getBindingTime () {
        return bindingTime;
    }

    public void setBindingTime (Date bindingTime) {
        this.bindingTime = bindingTime;
    }

    public Integer getBindingCount () {
        return bindingCount;
    }

    public void setBindingCount (Integer bindingCount) {
        this.bindingCount = bindingCount;
    }

    public Date getTransactionTime () {
        return transactionTime;
    }

    public void setTransactionTime (Date transactionTime) {
        this.transactionTime = transactionTime;
    }

    public Integer getTransactionCount () {
        return transactionCount;
    }

    public void setTransactionCount (Integer transactionCount) {
        this.transactionCount = transactionCount;
    }
}