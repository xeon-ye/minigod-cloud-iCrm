package com.minigod.persist.po;
import com.minigod.persist.tables.TGrmFunction;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TGrmFunction.class)
public class GrmFunction implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private String functionCode;
	private String functionName;
	private Date createDate;
	private Integer functionState;
	private String functionDesc;
	private String remark;

    public String getFunctionCode () {
        return functionCode;
    }

    public void setFunctionCode (String functionCode) {
        this.functionCode = functionCode;
    }

    public String getFunctionName () {
        return functionName;
    }

    public void setFunctionName (String functionName) {
        this.functionName = functionName;
    }

    public Date getCreateDate () {
        return createDate;
    }

    public void setCreateDate (Date createDate) {
        this.createDate = createDate;
    }

    public Integer getFunctionState () {
        return functionState;
    }

    public void setFunctionState (Integer functionState) {
        this.functionState = functionState;
    }

    public String getFunctionDesc () {
        return functionDesc;
    }

    public void setFunctionDesc (String functionDesc) {
        this.functionDesc = functionDesc;
    }

    public String getRemark () {
        return remark;
    }

    public void setRemark (String remark) {
        this.remark = remark;
    }
}