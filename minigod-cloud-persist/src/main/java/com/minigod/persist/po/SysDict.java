package com.minigod.persist.po;
import com.minigod.persist.tables.TSysDict;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 系统字典表
 */
@Entity(table=TSysDict.class)
public class SysDict implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer dictId;//字典ID
	private String dictCode = "";
	private String dictName;
	private String valueCode = "";
	private String valueName;
	private String valueRemark;
	private Boolean isStatus;//有效标志(0无效，默认1有效)
	private Date createTime;//记录创建时间
	private Date updateTime;//最后修改时间

    public Integer getDictId () {
        return dictId;
    }

    public void setDictId (Integer dictId) {
        this.dictId = dictId;
    }

    public String getDictCode () {
        return dictCode;
    }

    public void setDictCode (String dictCode) {
        this.dictCode = dictCode;
    }

    public String getDictName () {
        return dictName;
    }

    public void setDictName (String dictName) {
        this.dictName = dictName;
    }

    public String getValueCode () {
        return valueCode;
    }

    public void setValueCode (String valueCode) {
        this.valueCode = valueCode;
    }

    public String getValueName () {
        return valueName;
    }

    public void setValueName (String valueName) {
        this.valueName = valueName;
    }

    public String getValueRemark () {
        return valueRemark;
    }

    public void setValueRemark (String valueRemark) {
        this.valueRemark = valueRemark;
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