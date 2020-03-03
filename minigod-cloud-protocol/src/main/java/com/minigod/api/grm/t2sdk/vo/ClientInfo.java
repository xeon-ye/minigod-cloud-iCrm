package com.minigod.api.grm.t2sdk.vo;

import com.minigod.api.grm.t2sdk.vo.FundAccountInfoWithCash;

import java.io.Serializable;
import java.util.List;

/**
 * Created by CaiJianbo on 2016/5/7 15:45.
 * minigod
 */
public class ClientInfo  implements Serializable{
    private static final long serialVersionUID = 1L;
    private String clientId;
    private String branchNo;
    private String clientName;
    private List<FundAccountInfoWithCash> fundAccts;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public List<FundAccountInfoWithCash> getFundAccts() {
        return fundAccts;
    }

    public void setFundAccts(List<FundAccountInfoWithCash> fundAccts) {
        this.fundAccts = fundAccts;
    }

    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo;
    }
}
