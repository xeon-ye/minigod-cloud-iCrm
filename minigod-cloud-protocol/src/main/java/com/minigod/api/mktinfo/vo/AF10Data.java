package com.minigod.api.mktinfo.vo;

import java.io.Serializable;

/**
 * Created by 9f on 2017/6/27.
 */
public class AF10Data implements Serializable {

	private static final long serialVersionUID = 4743192175367367617L;
	private String assetId; //资产id  GPDM
    private String stkCode; //股票代码
    private String mktCode; //市场
    private double flshr; // 流通股本  LTAG
    private double total; // 总股本 ZGB
    private double bps; // 净资产 JZC
    private double eps; // 收益 ZGG

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getStkCode() {
        return stkCode;
    }

    public void setStkCode(String stkCode) {
        this.stkCode = stkCode;
    }

    public String getMktCode() {
        return mktCode;
    }

    public void setMktCode(String mktCode) {
        this.mktCode = mktCode;
    }

    public double getFlshr() {
        return flshr;
    }

    public void setFlshr(double flshr) {
        this.flshr = flshr;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getBps() {
        return bps;
    }

    public void setBps(double bps) {
        this.bps = bps;
    }

    public double getEps() {
        return eps;
    }

    public void setEps(double eps) {
        this.eps = eps;
    }
}
