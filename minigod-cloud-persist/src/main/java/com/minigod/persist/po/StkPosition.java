package com.minigod.persist.po;
import com.minigod.persist.tables.TStkPosition;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;

/**
 * 
 */
@Entity(table=TStkPosition.class)
public class StkPosition implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer positionId;
	private String stkcode;
	private String stkname;
	private Double stkbal;
	private Double stkavl;
	private Double stkbuy;
	private Double stksale;
	private Double costprice;
	private String inputid;
	private String secuid;
	private String market;
	private Double profitprice;
	private String poststr = "1";

    public Integer getPositionId () {
        return positionId;
    }

    public void setPositionId (Integer positionId) {
        this.positionId = positionId;
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

    public Double getStkbal () {
        return stkbal;
    }

    public void setStkbal (Double stkbal) {
        this.stkbal = stkbal;
    }

    public Double getStkavl () {
        return stkavl;
    }

    public void setStkavl (Double stkavl) {
        this.stkavl = stkavl;
    }

    public Double getStkbuy () {
        return stkbuy;
    }

    public void setStkbuy (Double stkbuy) {
        this.stkbuy = stkbuy;
    }

    public Double getStksale () {
        return stksale;
    }

    public void setStksale (Double stksale) {
        this.stksale = stksale;
    }

    public Double getCostprice () {
        return costprice;
    }

    public void setCostprice (Double costprice) {
        this.costprice = costprice;
    }

    public String getInputid () {
        return inputid;
    }

    public void setInputid (String inputid) {
        this.inputid = inputid;
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

    public Double getProfitprice () {
        return profitprice;
    }

    public void setProfitprice (Double profitprice) {
        this.profitprice = profitprice;
    }

    public String getPoststr () {
        return poststr;
    }

    public void setPoststr (String poststr) {
        this.poststr = poststr;
    }
}