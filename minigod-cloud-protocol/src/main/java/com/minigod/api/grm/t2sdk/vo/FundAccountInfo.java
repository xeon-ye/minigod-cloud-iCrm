package com.minigod.api.grm.t2sdk.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by CaiJianbo on 2016/5/7 15:47.
 * minigod
 */
public class FundAccountInfo implements Serializable{
    private static final long serialVersionUID = 1L;
    private String fundAccount;
    private String assetProp;
    private String restriction;
    private String mainFlag;
    private String branchNo;

    public String getFundAccount() {
        return fundAccount;
    }

    public void setFundAccount(String fundAccount) {
        this.fundAccount = fundAccount;
    }

    public String getAssetProp() {
        return assetProp;
    }

    public void setAssetProp(String assetProp) {
        this.assetProp = assetProp;
    }

    public String getRestriction() {
        return restriction;
    }

    public void setRestriction(String restriction) {
        this.restriction = restriction;
    }

    public String getMainFlag() {
        return mainFlag;
    }

    public void setMainFlag(String mainFlag) {
        this.mainFlag = mainFlag;
    }


    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo;
    }

}
