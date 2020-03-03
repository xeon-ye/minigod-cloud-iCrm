package com.minigod.persist.po;
import com.minigod.persist.tables.TPtfIdxHis;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TPtfIdxHis.class)
public class PtfIdxHis implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer ptfId;//组合id
	private Date indexDate;//指数日期
	private Boolean isReal;//是否实盘
	private Double ptfIndex;//组合指数
	private Double ptfVolatility;//组合的波动率
	private Date createTime;//创建时间

    public Integer getPtfId () {
        return ptfId;
    }

    public void setPtfId (Integer ptfId) {
        this.ptfId = ptfId;
    }

    public Date getIndexDate () {
        return indexDate;
    }

    public void setIndexDate (Date indexDate) {
        this.indexDate = indexDate;
    }

    public Boolean getIsReal () {
        return isReal;
    }

    public void setIsReal (Boolean isReal) {
        this.isReal = isReal;
    }

    public Double getPtfIndex () {
        return ptfIndex;
    }

    public void setPtfIndex (Double ptfIndex) {
        this.ptfIndex = ptfIndex;
    }

    public Double getPtfVolatility () {
        return ptfVolatility;
    }

    public void setPtfVolatility (Double ptfVolatility) {
        this.ptfVolatility = ptfVolatility;
    }

    public Date getCreateTime () {
        return createTime;
    }

    public void setCreateTime (Date createTime) {
        this.createTime = createTime;
    }
}