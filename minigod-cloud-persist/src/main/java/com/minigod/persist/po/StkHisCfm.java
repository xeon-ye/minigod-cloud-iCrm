package com.minigod.persist.po;
import com.minigod.persist.tables.TStkHisCfm;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TStkHisCfm.class)
public class StkHisCfm implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer matchcode;
	private Integer ordersno;
	private String stkcode;
	private String stkname;
	private String bsflag;
	private String matchtype;
	private Double matchprice;
	private Double matchamt;
	private String secuid;
	private String market;
	private String inputid;
	private Date matchdate;
	private Double feeYhs;
	private Double feeGhf;
	private Double feeQsf;
	private Integer orderid;
	private String poststr;

    public Integer getMatchcode () {
        return matchcode;
    }

    public void setMatchcode (Integer matchcode) {
        this.matchcode = matchcode;
    }

    public Integer getOrdersno () {
        return ordersno;
    }

    public void setOrdersno (Integer ordersno) {
        this.ordersno = ordersno;
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

    public String getMatchtype () {
        return matchtype;
    }

    public void setMatchtype (String matchtype) {
        this.matchtype = matchtype;
    }

    public Double getMatchprice () {
        return matchprice;
    }

    public void setMatchprice (Double matchprice) {
        this.matchprice = matchprice;
    }

    public Double getMatchamt () {
        return matchamt;
    }

    public void setMatchamt (Double matchamt) {
        this.matchamt = matchamt;
    }

    public String getSecuid () {
        return secuid;
    }

    public void setSecuid (String secuid) {
        this.secuid = secuid;
    }

    public String getMarket () {
        return market;
    }

    public void setMarket (String market) {
        this.market = market;
    }

    public String getInputid () {
        return inputid;
    }

    public void setInputid (String inputid) {
        this.inputid = inputid;
    }

    public Date getMatchdate () {
        return matchdate;
    }

    public void setMatchdate (Date matchdate) {
        this.matchdate = matchdate;
    }

    public Double getFeeYhs () {
        return feeYhs;
    }

    public void setFeeYhs (Double feeYhs) {
        this.feeYhs = feeYhs;
    }

    public Double getFeeGhf () {
        return feeGhf;
    }

    public void setFeeGhf (Double feeGhf) {
        this.feeGhf = feeGhf;
    }

    public Double getFeeQsf () {
        return feeQsf;
    }

    public void setFeeQsf (Double feeQsf) {
        this.feeQsf = feeQsf;
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