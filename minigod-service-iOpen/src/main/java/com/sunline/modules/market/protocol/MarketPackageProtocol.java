package com.sunline.modules.market.protocol;

import com.sunline.modules.common.pojo.rest.BaseParameter;

import java.math.BigDecimal;

/**
 * 行情套餐购买
 * @author lidh
 * @email jim@zszhizhu.com
 * @date 2019-05-13 11:07:10
 */
public class MarketPackageProtocol extends BaseParameter {
    private static final long serialVersionUID = -6016628474122917135L;

    //交易帐号
    private String clientId;
    //资金帐号
    private String fundAccount;
    //行情套餐[1-国际标准版 2-内地优惠手机版 3-内地优惠升级版]
    private Integer packageName;
    //行情类型[1-港股行情 2-美股行情]
    private Integer packageType;
    //单价
    private BigDecimal packagePrice;
    //总价
    private BigDecimal totalCost;
    //币种代码[0-人民币 1-美元 2-港币]
    private String moneyType;
    //有效期
    private String validityPeriod;
    //购买日期
    private String buyDate;
    //预约号
    private String applicationId;

    /**
     * 获取 clientId
     *
     * @return clientId
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * 设置 clientId
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    /**
     * 获取 fundAccount
     *
     * @return fundAccount
     */
    public String getFundAccount() {
        return fundAccount;
    }

    /**
     * 设置 fundAccount
     */
    public void setFundAccount(String fundAccount) {
        this.fundAccount = fundAccount;
    }

    /**
     * 获取 packageName
     *
     * @return packageName
     */
    public Integer getPackageName() {
        return packageName;
    }

    /**
     * 设置 packageName
     */
    public void setPackageName(Integer packageName) {
        this.packageName = packageName;
    }

    public Integer getPackageType() {
        return packageType;
    }

    public void setPackageType(Integer packageType) {
        this.packageType = packageType;
    }

    /**
     * 获取 packagePrice
     *
     * @return packagePrice
     */
    public BigDecimal getPackagePrice() {
        return packagePrice;
    }

    /**
     * 设置 packagePrice
     */
    public void setPackagePrice(BigDecimal packagePrice) {
        this.packagePrice = packagePrice;
    }

    /**
     * 获取 totalCost
     *
     * @return totalCost
     */
    public BigDecimal getTotalCost() {
        return totalCost;
    }

    /**
     * 设置 totalCost
     */
    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    /**
     * 获取 moneyType
     *
     * @return moneyType
     */
    public String getMoneyType() {
        return moneyType;
    }

    /**
     * 设置 moneyType
     */
    public void setMoneyType(String moneyType) {
        this.moneyType = moneyType;
    }

    /**
     * 获取 validityPeriod
     *
     * @return validityPeriod
     */
    public String getValidityPeriod() {
        return validityPeriod;
    }

    /**
     * 设置 validityPeriod
     */
    public void setValidityPeriod(String validityPeriod) {
        this.validityPeriod = validityPeriod;
    }

    public String getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(String buyDate) {
        this.buyDate = buyDate;
    }

    /**
     * 获取 applicationId
     *
     * @return applicationId
     */
    public String getApplicationId() {
        return applicationId;
    }

    /**
     * 设置 applicationId
     */
    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }
}
