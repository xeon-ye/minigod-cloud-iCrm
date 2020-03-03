package com.minigod.persist.po;
import com.minigod.persist.tables.TFprdCurrencyScale;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 理财活期总规模控制计划表
 */
@Entity(table=TFprdCurrencyScale.class)
public class FprdCurrencyScale implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer currencyScaleId;//控制ID  主键，自增长字段
	private Date beginTime;//计划生效时间  计划开始生效时间
	private BigDecimal scale;//周期的规模 累计售出的金额不能大于本值
	private String notified;//是否已发放额度更新通知
	private Integer createBy;//由谁创建  OMS操作人ID
	private Integer updateBy;//由谁更改  OMS操作人ID
	private Date createTime;//记录创建时间
	private Date updateTime;//记录修改时间

    public Integer getCurrencyScaleId () {
        return currencyScaleId;
    }

    public void setCurrencyScaleId (Integer currencyScaleId) {
        this.currencyScaleId = currencyScaleId;
    }

    public Date getBeginTime () {
        return beginTime;
    }

    public void setBeginTime (Date beginTime) {
        this.beginTime = beginTime;
    }

    public BigDecimal getScale () {
        return scale;
    }

    public void setScale (BigDecimal scale) {
        this.scale = scale;
    }

    public String getNotified () {
        return notified;
    }

    public void setNotified (String notified) {
        this.notified = notified;
    }

    public Integer getCreateBy () {
        return createBy;
    }

    public void setCreateBy (Integer createBy) {
        this.createBy = createBy;
    }

    public Integer getUpdateBy () {
        return updateBy;
    }

    public void setUpdateBy (Integer updateBy) {
        this.updateBy = updateBy;
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