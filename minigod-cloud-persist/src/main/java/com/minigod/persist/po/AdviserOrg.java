package com.minigod.persist.po;
import com.minigod.persist.tables.TAdviserOrg;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 投顾机构信息表
 */
@Entity(table=TAdviserOrg.class)
public class AdviserOrg implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer adviserOrgId;
	private Integer orgType;//投顾机构类别(1： 表示证券公司;2： 表示证券投资咨询机构)
	private String orgName;//投顾机构的名称
	private Boolean isStatus = true;//默认1有效，0无效
	private Integer creVersion = 1;//创建版本号
	private Integer updVersion = 1;//修改版本号
	private Date createTime;//记录创建时间
	private Date updateTime;//记录修改时间

    public Integer getAdviserOrgId () {
        return adviserOrgId;
    }

    public void setAdviserOrgId (Integer adviserOrgId) {
        this.adviserOrgId = adviserOrgId;
    }

    public Integer getOrgType () {
        return orgType;
    }

    public void setOrgType (Integer orgType) {
        this.orgType = orgType;
    }

    public String getOrgName () {
        return orgName;
    }

    public void setOrgName (String orgName) {
        this.orgName = orgName;
    }

    public Boolean getIsStatus () {
        return isStatus;
    }

    public void setIsStatus (Boolean isStatus) {
        this.isStatus = isStatus;
    }

    public Integer getCreVersion () {
        return creVersion;
    }

    public void setCreVersion (Integer creVersion) {
        this.creVersion = creVersion;
    }

    public Integer getUpdVersion () {
        return updVersion;
    }

    public void setUpdVersion (Integer updVersion) {
        this.updVersion = updVersion;
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