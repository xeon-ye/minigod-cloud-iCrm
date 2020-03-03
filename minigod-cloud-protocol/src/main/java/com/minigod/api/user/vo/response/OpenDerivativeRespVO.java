package com.minigod.api.user.vo.response;

import java.io.Serializable;

/**
 * @Author: PENGFENG
 * @Description:
 * @Date: Created in 13:28 2017/10/12
 * @Modified By:
 */
public class OpenDerivativeRespVO implements Serializable {

    private static final long serialVersionUID = 5686950467311934966L;

    // 是否允许衍生品交易[0=否 1=是]
    private Integer isAllowDerivativesTransaction;

    // 股票投资经验类型 [0=没有经验 1=少于一年 2=一至三年 3=三至五年 4=五年以上]
    private Integer stocksInvestmentExperienceType;

    // 认证股权投资经验类型 [0=没有经验 1=少于一年 2=一至三年 3=三至五年 4=五年以上]
    private Integer warrantsInvestmentExperienceType;

    // 期货投资经验类型 [0=没有经验 1=少于一年 2=一至三年 3=三至五年 4=五年以上]
    private Integer futuresInvestmentExperienceType;

    public Integer getIsAllowDerivativesTransaction() {
        return isAllowDerivativesTransaction;
    }

    public void setIsAllowDerivativesTransaction(Integer isAllowDerivativesTransaction) {
        this.isAllowDerivativesTransaction = isAllowDerivativesTransaction;
    }

    public Integer getStocksInvestmentExperienceType() {
        return stocksInvestmentExperienceType;
    }

    public void setStocksInvestmentExperienceType(Integer stocksInvestmentExperienceType) {
        this.stocksInvestmentExperienceType = stocksInvestmentExperienceType;
    }

    public Integer getWarrantsInvestmentExperienceType() {
        return warrantsInvestmentExperienceType;
    }

    public void setWarrantsInvestmentExperienceType(Integer warrantsInvestmentExperienceType) {
        this.warrantsInvestmentExperienceType = warrantsInvestmentExperienceType;
    }

    public Integer getFuturesInvestmentExperienceType() {
        return futuresInvestmentExperienceType;
    }

    public void setFuturesInvestmentExperienceType(Integer futuresInvestmentExperienceType) {
        this.futuresInvestmentExperienceType = futuresInvestmentExperienceType;
    }
}
