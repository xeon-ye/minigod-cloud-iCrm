package com.minigod.api.solr;

import java.io.Serializable;

public class IStockInfoVO implements Serializable {

	/** [股票基本信息检索] */
	private static final long serialVersionUID = -1256242655693685993L;

	private String assetId;//资产ID

	private String stkCode;//股票代码

	private String stkName;//股票代码

	private String spelling;//拼音

	private String spellingAbbr;//拼音简称

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

	public String getSpelling() {
		return spelling;
	}

	public void setSpelling(String spelling) {
		this.spelling = spelling;
	}

	public String getSpellingAbbr() {
		return spellingAbbr;
	}

	public void setSpellingAbbr(String spellingAbbr) {
		this.spellingAbbr = spellingAbbr;
	}
}
