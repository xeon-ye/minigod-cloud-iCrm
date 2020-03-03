package com.minigod.persist.po;
import com.minigod.persist.tables.TGrmServerType;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TGrmServerType.class)
public class GrmServerType implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer typeId;
	private String typeCode;
	private String typeName;
	private String typeDesc;
	private Date createDate;
	private String remark;

    public Integer getTypeId () {
        return typeId;
    }

    public void setTypeId (Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeCode () {
        return typeCode;
    }

    public void setTypeCode (String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeName () {
        return typeName;
    }

    public void setTypeName (String typeName) {
        this.typeName = typeName;
    }

    public String getTypeDesc () {
        return typeDesc;
    }

    public void setTypeDesc (String typeDesc) {
        this.typeDesc = typeDesc;
    }

    public Date getCreateDate () {
        return createDate;
    }

    public void setCreateDate (Date createDate) {
        this.createDate = createDate;
    }

    public String getRemark () {
        return remark;
    }

    public void setRemark (String remark) {
        this.remark = remark;
    }
}