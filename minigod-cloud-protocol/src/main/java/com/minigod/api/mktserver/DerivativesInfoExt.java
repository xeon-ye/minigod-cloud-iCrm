package com.minigod.api.mktserver;

import com.minigod.api.grm.utils.ESubStkType;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by CaiJianbo on 2016/9/8 9:37.
 * minigod
 */
public class DerivativesInfoExt implements Serializable {
    private static final long serialVersionUID = -5726439232089988051L;

    private String assetId;
    /**
     * 发行商
     */
    private String issuer;
    /**
     * 关联正股
     */
    private String ul;
    private ESubStkType subType;
    private String type;
    private String cbbcCategory;
    private Date listingDate;
    private Date maturity;
    private String strikecurrency;
    //行使价
    private Double strikeLevel;
    //回收价
    private Double callLevel;
    //换股比率
    private Double entitlementRatio;
    //发行量
    private Long issueSize;
    //街货比
    private Double osRatio;
    private String tradeCurrency;
    private Double closingPrice;
    private Double turnover;
    private String ulCurrency;
    private Double ulPrice;

    //对冲值
    private Double delta;
    //引申波幅
    private Double iv;

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getUl() {
        return ul;
    }

    public void setUl(String ul) {
        this.ul = ul;
    }

    public ESubStkType getSubType() {
        return subType;
    }

    public void setSubType(ESubStkType subType) {
        this.subType = subType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCbbcCategory() {
        return cbbcCategory;
    }

    public void setCbbcCategory(String cbbcCategory) {
        this.cbbcCategory = cbbcCategory;
    }

    public Date getListingDate() {
        return listingDate;
    }

    public void setListingDate(Date listingDate) {
        this.listingDate = listingDate;
    }

    public Date getMaturity() {
        return maturity;
    }

    public void setMaturity(Date maturity) {
        this.maturity = maturity;
    }

    public String getStrikecurrency() {
        return strikecurrency;
    }

    public void setStrikecurrency(String strikecurrency) {
        this.strikecurrency = strikecurrency;
    }

    public Double getStrikeLevel() {
        return strikeLevel;
    }

    public void setStrikeLevel(Double strikeLevel) {
        this.strikeLevel = strikeLevel;
    }

    public Double getCallLevel() {
        return callLevel;
    }

    public void setCallLevel(Double callLevel) {
        this.callLevel = callLevel;
    }

    public Double getEntitlementRatio() {
        return entitlementRatio;
    }

    public void setEntitlementRatio(Double entitlementRatio) {
        this.entitlementRatio = entitlementRatio;
    }

    public Long getIssueSize() {
        return issueSize;
    }

    public void setIssueSize(Long issueSize) {
        this.issueSize = issueSize;
    }

    public Double getOsRatio() {
        return osRatio;
    }

    public void setOsRatio(Double osRatio) {
        this.osRatio = osRatio;
    }

    public String getTradeCurrency() {
        return tradeCurrency;
    }

    public void setTradeCurrency(String tradeCurrency) {
        this.tradeCurrency = tradeCurrency;
    }


    public Double getClosingPrice() {
        return closingPrice;
    }

    public void setClosingPrice(Double closingPrice) {
        this.closingPrice = closingPrice;
    }

    public Double getTurnover() {
        return turnover;
    }

    public void setTurnover(Double turnover) {
        this.turnover = turnover;
    }

    public String getUlCurrency() {
        return ulCurrency;
    }

    public void setUlCurrency(String ulCurrency) {
        this.ulCurrency = ulCurrency;
    }

    public Double getUlPrice() {
        return ulPrice;
    }

    public void setUlPrice(Double ulPrice) {
        this.ulPrice = ulPrice;
    }

    public Double getDelta() {
        return delta;
    }

    public void setDelta(Double delta) {
        this.delta = delta;
    }

    public Double getIv() {
        return iv;
    }

    public void setIv(Double iv) {
        this.iv = iv;
    }
}
