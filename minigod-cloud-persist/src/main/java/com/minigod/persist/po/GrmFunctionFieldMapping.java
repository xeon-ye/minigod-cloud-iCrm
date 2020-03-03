package com.minigod.persist.po;
import com.minigod.persist.tables.TGrmFunctionFieldMapping;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;

/**
 * 
 */
@Entity(table=TGrmFunctionFieldMapping.class)
public class GrmFunctionFieldMapping implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer ffmapId;
	private Integer functionId;
	private Integer fieldId;
	private Boolean isRequired;
	private Boolean isReq;
	private Boolean isRes;

    public Integer getFfmapId () {
        return ffmapId;
    }

    public void setFfmapId (Integer ffmapId) {
        this.ffmapId = ffmapId;
    }

    public Integer getFunctionId () {
        return functionId;
    }

    public void setFunctionId (Integer functionId) {
        this.functionId = functionId;
    }

    public Integer getFieldId () {
        return fieldId;
    }

    public void setFieldId (Integer fieldId) {
        this.fieldId = fieldId;
    }

    public Boolean getIsRequired () {
        return isRequired;
    }

    public void setIsRequired (Boolean isRequired) {
        this.isRequired = isRequired;
    }

    public Boolean getIsReq () {
        return isReq;
    }

    public void setIsReq (Boolean isReq) {
        this.isReq = isReq;
    }

    public Boolean getIsRes () {
        return isRes;
    }

    public void setIsRes (Boolean isRes) {
        this.isRes = isRes;
    }
}