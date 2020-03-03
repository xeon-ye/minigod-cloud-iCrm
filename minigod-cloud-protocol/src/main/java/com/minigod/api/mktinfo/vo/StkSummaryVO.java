package com.minigod.api.mktinfo.vo;

import java.io.Serializable;

public class StkSummaryVO implements Serializable {
	/**
	 * 股票概要信息
	 */
	private static final long serialVersionUID = 8173159973823660757L;
	/** 资产ID */
	private String id;
	/** 股票名称 */
	private String name;
	/** 资产类型 */
	private String type;
	/** 时间 */
	private String time;
	/** 动态市盈率 */
	private Double pe;
	/** 市净率 */
	private Double pb;
	/** 变动，因停牌显示问题，设为对象，允许为null， */
	private Double changePct;
	/** 现价 */
	private String price;
	/** 流通市值 */
	private Double fMktV;
	/** 总 市值 */
	private Double mktV;
	/* 0.正常交易, 1.涨停, 2.跌停, 3.停牌， 4. 表示退市， 5. IPO期间 */
	private int status;
	/** 简介 */
	private String pro;

	private String relateCct;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Double getPe() {
		return pe;
	}

	public void setPe(Double pe) {
		this.pe = pe;
	}

	public Double getPb() {
		return pb;
	}

	public void setPb(Double pb) {
		this.pb = pb;
	}

	public Double getChangePct() {
		return changePct;
	}

	public void setChangePct(Double changePct) {
		this.changePct = changePct;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Double getfMktV() {
		return fMktV;
	}

	public void setfMktV(Double fMktV) {
		this.fMktV = fMktV;
	}

	public Double getMktV() {
		return mktV;
	}

	public void setMktV(Double mktV) {
		this.mktV = mktV;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getPro() {
		return pro;
	}

	public void setPro(String pro) {
		this.pro = pro;
	}

	public String getRelateCct() {
		return relateCct;
	}

	public void setRelateCct(String relateCct) {
		this.relateCct = relateCct;
	}

}
