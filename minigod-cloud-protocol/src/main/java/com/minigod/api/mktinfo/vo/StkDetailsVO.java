package com.minigod.api.mktinfo.vo;

import java.io.Serializable;

public class StkDetailsVO implements Serializable {

	private static final long serialVersionUID = 7184505879193249169L;
	/** 资产ID */
	private String assetId;
	/** 股票名称 */
	private String stkName;
	/** 最新价 */
	private String price;
	/** 昨收 */
	private String prevClose;
	/** 今开 */
	private String open;
	/** 最高 */
	private String high;
	/** 最低 */
	private String low;
	/** 交易总额 */
	private double turnOver;
	/** 交易总量 */
	private double volume;
	/** 涨跌额 */
	private double change;
	/** 涨跌幅 */
	private Double changePct;
	/** 动态市盈率 */
	private Double pe;
	/** 每股净资产 */
	private Double bps;
	/** 市净率 */
	private Double pb;
	/** 每股收益 */
	private Double eps;
	/** 股票状态 */
	private int status;
	/** 流通市值 */
	private Double fMktV;
	/** 总 市值 */
	private Double mktV;
	/** 股票类型 */
	private Integer stkType;

	public Integer getStkType() {
		return stkType;
	}

	public void setStkType(Integer stkType) {
		this.stkType = stkType;
	}

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public String getStkName() {
		return stkName;
	}

	public void setStkName(String stkName) {
		this.stkName = stkName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPrevClose() {
		return prevClose;
	}

	public void setPrevClose(String prevClose) {
		this.prevClose = prevClose;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public String getHigh() {
		return high;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	public String getLow() {
		return low;
	}

	public void setLow(String low) {
		this.low = low;
	}

	public double getTurnOver() {
		return turnOver;
	}

	public void setTurnOver(double turnOver) {
		this.turnOver = turnOver;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public double getChange() {
		return change;
	}

	public void setChange(double change) {
		this.change = change;
	}

	public Double getChangePct() {
		return changePct;
	}

	public void setChangePct(Double changePct) {
		this.changePct = changePct;
	}

	public Double getPe() {
		return pe;
	}

	public void setPe(Double pe) {
		this.pe = pe;
	}

	public Double getBps() {
		return bps;
	}

	public void setBps(Double bps) {
		this.bps = bps;
	}

	public Double getPb() {
		return pb;
	}

	public void setPb(Double pb) {
		this.pb = pb;
	}

	public Double getEps() {
		return eps;
	}

	public void setEps(Double eps) {
		this.eps = eps;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

}