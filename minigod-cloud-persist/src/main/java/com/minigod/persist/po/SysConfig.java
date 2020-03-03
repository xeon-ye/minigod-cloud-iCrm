package com.minigod.persist.po;
import com.minigod.persist.tables.TSysConfig;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 系统参数配置表
 */
@Entity(table=TSysConfig.class)
public class SysConfig implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer configId;//配置ID
	private String moduleName;
	private String keyName;
	private String remark;
	private String keyValue;
	private Boolean isStatus = true;//状态(0停用,默认1正常使用)
	private Date createTime;//记录创建时间
	private Date updateTime;//记录最后修改时间
	private Long updVersion = 1l;

    public Integer getConfigId () {
        return configId;
    }

    public void setConfigId (Integer configId) {
        this.configId = configId;
    }

    public String getModuleName () {
        return moduleName;
    }

    public void setModuleName (String moduleName) {
        this.moduleName = moduleName;
    }

    public String getKeyName () {
        return keyName;
    }

    public void setKeyName (String keyName) {
        this.keyName = keyName;
    }

    public String getRemark () {
        return remark;
    }

    public void setRemark (String remark) {
        this.remark = remark;
    }

    public String getKeyValue () {
        return keyValue;
    }

    public void setKeyValue (String keyValue) {
        this.keyValue = keyValue;
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

    public Long getUpdVersion () {
        return updVersion;
    }

    public void setUpdVersion (Long updVersion) {
        this.updVersion = updVersion;
    }
}