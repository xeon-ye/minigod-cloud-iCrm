package com.minigod.api.solr;

import java.io.Serializable;

public class ILableInfoVO implements Serializable {

	private static final long serialVersionUID = -1256242655693685993L;

	private Integer lableId;// 概念ID

	private String lableName;// 概念名称

	private String keywords;// 关键字

	private String stkName;// 股票名称或者股票代码

	private Integer stkTotal = 0;// 股票数量

	public Integer getLableId() {
		return lableId;
	}

	public void setLableId(Integer lableId) {
		this.lableId = lableId;
	}

	public String getLableName() {
		return lableName;
	}

	public void setLableName(String lableName) {
		this.lableName = lableName;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getStkName() {
		return stkName;
	}

	public void setStkName(String stkName) {
		this.stkName = stkName;
	}

	public Integer getStkTotal() {
		return stkTotal;
	}

	public void setStkTotal(Integer stkTotal) {
		this.stkTotal = stkTotal;
	}
}
