package com.minigod.persist.po;
import com.minigod.persist.tables.TStkHisOrder;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TStkHisOrder.class)
public class StkHisOrder implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer ordersno;
	private String secuid;
	private String stkcode;
	private String stkname;
	private String bsflag;
	private String orderstatus;
	private Double orderprice;
	private Double orderqty;
	private Double cancelqty;
	private Integer opertime;
	private String market;
	private Double matchamt;
	private String fundid;
	private String cancelflag;
	private Date createTime;
	private Date updateTime;
	private String inputid;
	private Date orderdate;
	private Integer orderid;
	private String poststr;

    public Integer getOrdersno () {
        return ordersno;
    }

    public void setOrdersno (Integer ordersno) {
        this.ordersno = ordersno;
    }

    public String getSecuid () {
        return secuid;
    }

    public void setSecuid (String secuid) {
        this.secuid = secuid;
    }

    public String getStkcode () {
        return stkcode;
    }

    public void setStkcode (String stkcode) {
        this.stkcode = stkcode;
    }

    public String getStkname () {
        return stkname;
    }

    public void setStkname (String stkname) {
        this.stkname = stkname;
    }

    public String getBsflag () {
        return bsflag;
    }

    public void setBsflag (String bsflag) {
        this.bsflag = bsflag;
    }

    public String getOrderstatus () {
        return orderstatus;
    }

    public void setOrderstatus (String orderstatus) {
        this.orderstatus = orderstatus;
    }

    public Double getOrderprice () {
        return orderprice;
    }

    public void setOrderprice (Double orderprice) {
        this.orderprice = orderprice;
    }

    public Double getOrderqty () {
        return orderqty;
    }

    public void setOrderqty (Double orderqty) {
        this.orderqty = orderqty;
    }

    public Double getCancelqty () {
        return cancelqty;
    }

    public void setCancelqty (Double cancelqty) {
        this.cancelqty = cancelqty;
    }

    public Integer getOpertime () {
        return opertime;
    }

    public void setOpertime (Integer opertime) {
        this.opertime = opertime;
    }

    public String getMarket () {
        return market;
    }

    public void setMarket (String market) {
        this.market = market;
    }

    public Double getMatchamt () {
        return matchamt;
    }

    public void setMatchamt (Double matchamt) {
        this.matchamt = matchamt;
    }

    public String getFundid () {
        return fundid;
    }

    public void setFundid (String fundid) {
        this.fundid = fundid;
    }

    public String getCancelflag () {
        return cancelflag;
    }

    public void setCancelflag (String cancelflag) {
        this.cancelflag = cancelflag;
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

    public String getInputid () {
        return inputid;
    }

    public void setInputid (String inputid) {
        this.inputid = inputid;
    }

    public Date getOrderdate () {
        return orderdate;
    }

    public void setOrderdate (Date orderdate) {
        this.orderdate = orderdate;
    }

    public Integer getOrderid () {
        return orderid;
    }

    public void setOrderid (Integer orderid) {
        this.orderid = orderid;
    }

    public String getPoststr () {
        return poststr;
    }

    public void setPoststr (String poststr) {
        this.poststr = poststr;
    }
}