package com.minigod.api.mktserver;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by CaiJianbo on 2016/5/26 18:35.
 * minigod
 */
public class StkInfoExt implements Serializable{
    private static final long serialVersionUID = 1700343573208814084L;
    private String assetId;
    private String subEnd;
    private Double conPrice;
    private Double subRatio;
    private Double lastGearing;
    private Double lastPremium;
    private Double w52High;     //52周最高
    private Double w52Low;  //52周最低
    private BigDecimal warrInMarket;
    private Double warrInMarketPer;
    private BigDecimal marketCap;   //总市值
    private Double issueCap;
    private BigDecimal issueMarketCap;
    private BigDecimal currIssueMarketCap;
    private Double ma10;
    private Double ma50;
    private Double rsi10;
    private Double osc10;
    private Double lastPE;  //最新市盈率
    private Double lastYield;   //最新周息率
    private String[] relatedSeurities;
    private String subIndustryChiName;
    private String principleActivitiesChi;
    private Double callPrice;
    private String SecSector;
    private String SecGroup;
    private String SectorCode; //公司分类
    private String IndustryCode; //行业
    private String SubIndustryCode; //行业细分
    private Set<Integer> labels;    //概念


    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }


    public String getSubEnd() {
        return subEnd;
    }

    public void setSubEnd(String subEnd) {
        this.subEnd = subEnd;
    }

    public Double getConPrice() {
        return conPrice;
    }

    public void setConPrice(Double conPrice) {
        this.conPrice = conPrice;
    }

    public Double getSubRatio() {
        return subRatio;
    }

    public void setSubRatio(Double subRatio) {
        this.subRatio = subRatio;
    }

    public Double getLastGearing() {
        return lastGearing;
    }

    public void setLastGearing(Double lastGearing) {
        this.lastGearing = lastGearing;
    }

    public Double getLastPremium() {
        return lastPremium;
    }

    public void setLastPremium(Double lastPremium) {
        this.lastPremium = lastPremium;
    }

    public Double getW52High() {
        return w52High;
    }

    public void setW52High(Double w52High) {
        this.w52High = w52High;
    }

    public Double getW52Low() {
        return w52Low;
    }

    public void setW52Low(Double w52Low) {
        this.w52Low = w52Low;
    }

    public BigDecimal getWarrInMarket() {
        return warrInMarket;
    }

    public void setWarrInMarket(BigDecimal warrInMarket) {
        this.warrInMarket = warrInMarket;
    }

    public Double getWarrInMarketPer() {
        return warrInMarketPer;
    }

    public void setWarrInMarketPer(Double warrInMarketPer) {
        this.warrInMarketPer = warrInMarketPer;
    }

    public BigDecimal getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(BigDecimal marketCap) {
        this.marketCap = marketCap;
    }

    public BigDecimal getIssueMarketCap() {
        return issueMarketCap;
    }

    public void setIssueMarketCap(BigDecimal issueMarketCap) {
        this.issueMarketCap = issueMarketCap;
    }

    public BigDecimal getCurrIssueMarketCap() {
        return currIssueMarketCap;
    }

    public void setCurrIssueMarketCap(BigDecimal currIssueMarketCap) {
        this.currIssueMarketCap = currIssueMarketCap;
    }

    public Double getMa10() {
        return ma10;
    }

    public void setMa10(Double ma10) {
        this.ma10 = ma10;
    }

    public Double getMa50() {
        return ma50;
    }

    public void setMa50(Double ma50) {
        this.ma50 = ma50;
    }

    public Double getRsi10() {
        return rsi10;
    }

    public void setRsi10(Double rsi10) {
        this.rsi10 = rsi10;
    }

    public Double getOsc10() {
        return osc10;
    }

    public void setOsc10(Double osc10) {
        this.osc10 = osc10;
    }

    public Double getLastPE() {
        return lastPE;
    }

    public void setLastPE(Double lastPE) {
        this.lastPE = lastPE;
    }

    public Double getLastYield() {
        return lastYield;
    }

    public void setLastYield(Double lastYield) {
        this.lastYield = lastYield;
    }

    public String[] getRelatedSeurities() {
        return relatedSeurities;
    }

    public void setRelatedSeurities(String[] relatedSeurities) {
        this.relatedSeurities = relatedSeurities;
    }

    public String getSubIndustryChiName() {
        return subIndustryChiName;
    }

    public void setSubIndustryChiName(String subIndustryChiName) {
        this.subIndustryChiName = subIndustryChiName;
    }

    public String getPrincipleActivitiesChi() {
        return principleActivitiesChi;
    }

    public void setPrincipleActivitiesChi(String principleActivitiesChi) {
        this.principleActivitiesChi = principleActivitiesChi;
    }

    public Double getCallPrice() {
        return callPrice;
    }

    public void setCallPrice(Double callPrice) {
        this.callPrice = callPrice;
    }


    public Double getIssueCap() {
        return issueCap;
    }

    public void setIssueCap(Double issueCap) {
        this.issueCap = issueCap;
    }

    public String getSecSector() {
        return SecSector;
    }

    public void setSecSector(String secSector) {
        SecSector = secSector;
    }

    public String getSecGroup() {
        return SecGroup;
    }

    public void setSecGroup(String secGroup) {
        SecGroup = secGroup;
    }

    public String getSectorCode() {
        return SectorCode;
    }

    public void setSectorCode(String sectorCode) {
        SectorCode = sectorCode;
    }

    public String getIndustryCode() {
        return IndustryCode;
    }

    public void setIndustryCode(String industryCode) {
        IndustryCode = industryCode;
    }

    public String getSubIndustryCode() {
        return SubIndustryCode;
    }

    public void setSubIndustryCode(String subIndustryCode) {
        SubIndustryCode = subIndustryCode;
    }

    public Set<Integer> getLabels() {
        return labels;
    }

    public void setLabels(Set<Integer> labels) {
        this.labels = labels;
    }
}
