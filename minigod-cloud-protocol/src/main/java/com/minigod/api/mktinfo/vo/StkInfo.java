package com.minigod.api.mktinfo.vo;

import java.io.Serializable;

/**
 * <code>StkInfoVO<code>[包括股本，财务指标，停牌信息的股票对象]
 *
 * @author Colin
 * @since MiniGod v0.0.1(2014-11-11)
 */

public class StkInfo implements Serializable {

    private static final long serialVersionUID = -9131264100638653497L;
    private String assetId;// 资产ID
    private String stkCode;// 股票代码
    private String stkName;// 股票名称
    private String stkNameLong;// 股票全称
    private String market;// 市场
    private String spellingAbbr;// 拼音简称
    private String spelling;// 拼音
    private String engName;// 英文名
    private int secType = -1;// 股票类别
    private int secSType = -1;// 股票细分类别
    private int boardCode;// 块板名称
    private int corpCode;// 公司代码
    private String secTypeName;// 股票类别
    private String secSTypeName;// 股票细分类别
    private String boardName;// 块板名称
    private String listingDate;// 上市日期
    private String delistDate;// 退市日期
    private String ccyType;// 币种
    private int version;// 版本号
    private String upDateTime;// 更新时间
    private int lotSize;// 每手股数
    private Double changeLimit;// 涨跌幅限制
    private boolean isInvest = true;// 是否可以交易
    private Boolean isStatus;
    private String exchange;//美股交易市场
    private String mapStkCode;//（港股/A股映射股票代码）// add by jjchou
    
    

    public String getMapStkCode() {
		return mapStkCode;
	}

	public void setMapStkCode(String mapStkCode) {
		this.mapStkCode = mapStkCode;
	}

	public String getExchange() {
		return exchange;
	}

	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

	public boolean getIsInvest() {
        return isInvest;
    }

    public void setIsInvest(boolean isInvest) {
        this.isInvest = isInvest;
    }

    public Boolean getIsStatus() {
        return isStatus;
    }

    public void setIsStatus(Boolean isStatus) {
        this.isStatus = isStatus;
    }

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

    public String getStkName() {
        return stkName;
    }

    public void setStkName(String stkName) {
        this.stkName = stkName;
    }

    public String getStkNameLong() {
        return stkNameLong;
    }

    public void setStkNameLong(String stkNameLong) {
        this.stkNameLong = stkNameLong;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getSpellingAbbr() {
        return spellingAbbr;
    }

    public void setSpellingAbbr(String spellingAbbr) {
        this.spellingAbbr = spellingAbbr;
    }

    public String getSpelling() {
        return spelling;
    }

    public void setSpelling(String spelling) {
        this.spelling = spelling;
    }

    public String getEngName() {
        return engName;
    }

    public void setEngName(String engName) {
        this.engName = engName;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public String getListingDate() {
        return listingDate;
    }

    public void setListingDate(String listingDate) {
        this.listingDate = listingDate;
    }

    public String getDelistDate() {
        return delistDate;
    }

    public void setDelistDate(String delistDate) {
        this.delistDate = delistDate;
    }

    public String getCcyType() {
        return ccyType;
    }

    public void setCcyType(String ccyType) {
        this.ccyType = ccyType;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getUpDateTime() {
        return upDateTime;
    }

    public void setUpDateTime(String upDateTime) {
        this.upDateTime = upDateTime;
    }

    public int getSecType() {
        return secType;
    }

    public void setSecType(int secType) {
        this.secType = secType;
    }

    public int getSecSType() {
        return secSType;
    }

    public void setSecSType(int secSType) {
        this.secSType = secSType;
    }

    public int getBoardCode() {
        return boardCode;
    }

    public void setBoardCode(int boardCode) {
        this.boardCode = boardCode;
    }

    public String getSecTypeName() {
        return secTypeName;
    }

    public void setSecTypeName(String secTypeName) {
        this.secTypeName = secTypeName;
    }

    public String getSecSTypeName() {
        return secSTypeName;
    }

    public void setSecSTypeName(String secSTypeName) {
        this.secSTypeName = secSTypeName;
    }

    public int getCorpCode() {
        return corpCode;
    }

    public void setCorpCode(int corpCode) {
        this.corpCode = corpCode;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }

    public Double getChangeLimit() {
        return changeLimit;
    }

    public void setChangeLimit(Double changeLimit) {
        this.changeLimit = changeLimit;
    }

}
