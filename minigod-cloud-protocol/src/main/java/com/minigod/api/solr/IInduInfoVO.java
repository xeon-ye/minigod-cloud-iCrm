package com.minigod.api.solr;

import java.io.Serializable;

public class IInduInfoVO implements Serializable {

	private static final long serialVersionUID = 5043202543544121806L;

	private String induCode;//主键ID

	private String induName;//标签名称

	private String keywords;//关键词

	public String getInduCode() {
		return induCode;
	}

	public void setInduCode(String induCode) {
		this.induCode = induCode;
	}

	public String getInduName() {
		return induName;
	}

	public void setInduName(String induName) {
		this.induName = induName;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	
}
