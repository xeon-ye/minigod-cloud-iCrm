package com.minigod.persist.po;
import com.minigod.persist.tables.TPtfIdxChgHis;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TPtfIdxChgHis.class)
public class PtfIdxChgHis implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer ptfIdxChgId;//组合指数调整id
	private Integer ptfId;//组合id
	private Double ptfIndex;//组合指数
	private Boolean isReal;//是否实盘
	private Date createTime;//创建时间
	private Date updateTime;//更新时间
	private Boolean isStatus;//记录是否有效。1有效；0无效

    public Integer getPtfIdxChgId () {
        return ptfIdxChgId;
    }

    public void setPtfIdxChgId (Integer ptfIdxChgId) {
        this.ptfIdxChgId = ptfIdxChgId;
    }

    public Integer getPtfId () {
        return ptfId;
    }

    public void setPtfId (Integer ptfId) {
        this.ptfId = ptfId;
    }

    public Double getPtfIndex () {
        return ptfIndex;
    }

    public void setPtfIndex (Double ptfIndex) {
        this.ptfIndex = ptfIndex;
    }

    public Boolean getIsReal () {
        return isReal;
    }

    public void setIsReal (Boolean isReal) {
        this.isReal = isReal;
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

    public Boolean getIsStatus () {
        return isStatus;
    }

    public void setIsStatus (Boolean isStatus) {
        this.isStatus = isStatus;
    }
}