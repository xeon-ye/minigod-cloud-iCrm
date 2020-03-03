package com.minigod.api.mktserver;

import java.io.Serializable;


public class StkInfoExtCap implements Serializable{
    private static final long serialVersionUID = 1700343573208814084L;
    private String assetId;
    private Double issueCap;
    private Double eps;
    
	public String getAssetId() {
		return assetId;
	}
	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}
	public Double getIssueCap() {
		return issueCap;
	}
	public void setIssueCap(Double issueCap) {
		this.issueCap = issueCap;
	}
	public Double getEps() {
		return eps;
	}
	public void setEps(Double eps) {
		this.eps = eps;
	}

    
}



 
