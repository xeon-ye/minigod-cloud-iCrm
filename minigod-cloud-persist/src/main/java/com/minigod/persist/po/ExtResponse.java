package com.minigod.persist.po;
import com.minigod.persist.tables.TExtResponse;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TExtResponse.class)
public class ExtResponse implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer responseId;//主键
	private String responseValue;//外部系统返回信息
	private Date createTime;

    public Integer getResponseId () {
        return responseId;
    }

    public void setResponseId (Integer responseId) {
        this.responseId = responseId;
    }

    public String getResponseValue () {
        return responseValue;
    }

    public void setResponseValue (String responseValue) {
        this.responseValue = responseValue;
    }

    public Date getCreateTime () {
        return createTime;
    }

    public void setCreateTime (Date createTime) {
        this.createTime = createTime;
    }
}