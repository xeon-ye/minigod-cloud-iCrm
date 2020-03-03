package com.minigod.persist.po;
import com.minigod.persist.tables.TSecItemaccountApply;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 中银子账号配置表
 */
@Entity(table=TSecItemaccountApply.class)
public class SecItemaccountApply implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long id;//主键
	private Long outsideId;//申请人账号
	private Integer userId;
	private String userNameEn;//申请人英文名称
	private String userNameCn;//申请人中文名称
	private Integer state;//申请状态 0申请中1申请成功2失效3审核中
	private Date createTime;//创建时间
	private Date updateTime;//更新时间
	private String subAccountNo;//中银子账号
	private String fundAccount;//资金账号
	private String clientId;//交易账号
	private Integer isFind = 1;//是否查询全部
	private String accountName;//申请人户名
	private Integer exportState;//导出状态 0未导出 1已导出

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public Long getOutsideId () {
        return outsideId;
    }

    public void setOutsideId (Long outsideId) {
        this.outsideId = outsideId;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public String getUserNameEn () {
        return userNameEn;
    }

    public void setUserNameEn (String userNameEn) {
        this.userNameEn = userNameEn;
    }

    public String getUserNameCn () {
        return userNameCn;
    }

    public void setUserNameCn (String userNameCn) {
        this.userNameCn = userNameCn;
    }

    public Integer getState () {
        return state;
    }

    public void setState (Integer state) {
        this.state = state;
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

    public String getSubAccountNo () {
        return subAccountNo;
    }

    public void setSubAccountNo (String subAccountNo) {
        this.subAccountNo = subAccountNo;
    }

    public String getFundAccount () {
        return fundAccount;
    }

    public void setFundAccount (String fundAccount) {
        this.fundAccount = fundAccount;
    }

    public String getClientId () {
        return clientId;
    }

    public void setClientId (String clientId) {
        this.clientId = clientId;
    }

    public Integer getIsFind () {
        return isFind;
    }

    public void setIsFind (Integer isFind) {
        this.isFind = isFind;
    }

    public String getAccountName () {
        return accountName;
    }

    public void setAccountName (String accountName) {
        this.accountName = accountName;
    }

    public Integer getExportState () {
        return exportState;
    }

    public void setExportState (Integer exportState) {
        this.exportState = exportState;
    }
}