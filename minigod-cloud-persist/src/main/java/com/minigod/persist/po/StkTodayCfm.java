package com.minigod.persist.po;
import com.minigod.persist.tables.TStkTodayCfm;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;

/**
 * 
 */
@Entity(table=TStkTodayCfm.class)
public class StkTodayCfm implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer matchcode;
	private String ordersno;
	private String stkcode;
	private String stkname;
	private String bsflag;
	private String matchtype;
	private Double matchprice;
	private Double matchamt;
	private String secuid;
	private String market;
	private String inputid;
	private String orderid;
	private Double matchqty;
	private String poststr = "1";

    public Integer getMatchcode () {
        return matchcode;
    }

    public void setMatchcode (Integer matchcode) {
        this.matchcode = matchcode;
    }

    public String getOrdersno () {
        return ordersno;
    }

    public void setOrdersno (String ordersno) {
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

    public String getOrderid () {
        return orderid;
    }

    public void setOrderid (String orderid) {
        this.orderid = orderid;
    }

    public Double getMatchqty () {
        return matchqty;
    }

    public void setMatchqty (Double matchqty) {
        this.matchqty = matchqty;
    }

    public String getPoststr () {
        return poststr;
    }

    public void setPoststr (String poststr) {
        this.poststr = poststr;
    }
}