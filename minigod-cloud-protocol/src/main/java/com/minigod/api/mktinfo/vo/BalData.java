package com.minigod.api.mktinfo.vo;

import java.util.Date;

/**
 * Created by huhu on 2016/7/7.
 */
public class BalData {
    private String Code;//证券代号
    private Date AnnounceDate;//业绩公布日期
    private Date YearEndDate;//财政年度年结日期
    private String Currency;//报表货币
    private Float ExRate;//汇率(报表货币兑港元)
    private String IPOStatus;//上市前业绩标记
    private String StatementType;//报表种类
    private Integer CoverPeriod;//覆盖时期(月)
    private Double FixAss;//固定资产
    private Double Invest;//投资
    private Double OtherAss;//其他非流动资产
    private Double TotalNonCurrAss;//非流动资产总额
    private Double Inventory;//存货
    private Double TradeDebtors;//贸易应收款项
    private Double MarketSecurities;//金融资产
    private Double CashNearCash;//现金及银行结存
    private Double OtherCurrAss;//其他流动资产
    private Double CurrAss;//流动资产总额
    private Double TotalAss;//总资产
    private Double TradeCreditors;//贸易应付款项
    private Double STDebt;//短期债项
    private Double OtherSTLiab;//其他短期负债
    private Double CurrLiab;//流动负债总额
    private Double LTDebt;//长期债项
    private Double OtherLiabNOMI;//其他非流动负债
    private Double TotalNonCurrLiab;//非流动负债总额
    private Double ShareCapComm;//股本 (普通股)
    private Double ShareCapPref;//股本 (优先股)
    private Double ShareCap;//股本总额
    private Double TotalReservesExclPerpetualSecurities;//储备总额
    private Double EquityExclPerpetualSecurities;//本公司拥有人应占权益
    private Double PerpetualSecurities;//永久资本证券
    private Double MinoritiesBS;//非控股权益
    private Double TotalEquity;//权益总额
    private Double QuickAssets;//速动资产
    private Double TotalDebt;//总债项
    private Double NetDebt;//净现金/(债项)
    private Double CurrAssLessCurrLiab;//营运资金
    private Double Capex;//已动用资本
    private Double TotalAssLessCurrLiab;//总资产减流动负债
    private Double NetAssTotalLiab;//资产净值
    private Double LiabTotal;//总负债
    private String Auditor;//核数师意见

    private Double InvestmentProperties;
    private Double PropertyEquipment;
    private Double LeaseholdLandRights;
    private Double PrepaidLandLeasePremium;
    private Double DebtSecurities;
    private Double EquitySecurities;
    private Double Loans;
    private Double InvestmentOther;
    private Double IntAssociates;
    private Double IntJointVentures;
    private Double GoodwillOnly;
    private Double AssetOtherIntangile;
    private Double InsuranceReceivable;
    private Double AssetReinsurance;
    private Double AmountDueFromRelatedParties;
    private Double AcquisitionCostDeferredPolicy;
    private Double AssetDeferredTax;
    private Double DepositsStatutory;
    private Double InsuranceFund;
    private Double InsuranceProtectionFund;
    private Double InsurancePayable;
    private Double LiabInvContract;
    private Double AssetSoldAgreement;
    private Double AmountDueToRelatedParties;
    private Double TaxationCurr;
    private Double LiabDeferredTax;
    private Double InvestmentTotal;
    private Double IntAssociatesJointVentures;
    private Double Goodwill;
    private Double EmbeddedValue;
    private Double EnterpriseValue;
    private Double CashShortTermFund;
    private Double CollectionFromBank;
    private Double PlacingWithBank;
    private Double TradingBill;
    private Double TradingAsset;
    private Double DerivativesAsset;
    private Double DepositHold;
    private Double LoanToBank;
    private Double LoanToCustomer;
    private Double FinancialInvestment;
    private Double InterestAssociate;
    private Double GoodWill;
    private Double AssetOther;
    private Double CurrencyNoteInCirculation;
    private Double DepositsFromBank;
    private Double DepositsFromCustomer;
    private Double PlacementFromBank;
    private Double LiabTrading;
    private Double FinancialLiabFairValue;
    private Double DerivativesLiabilities;
    private Double LiabSubOrdinated;
    private Double LiabOther;
    private Double GrossAdvToCustomers;
    private Double ImpAdvToCustomers;
    private Double LoanToBankCustomer;
    private Double DepositsFromBankCustomer;
    private Double TotalDebtInstruments;

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public Date getAnnounceDate() {
        return AnnounceDate;
    }

    public void setAnnounceDate(Date announceDate) {
        AnnounceDate = announceDate;
    }

    public Date getYearEndDate() {
        return YearEndDate;
    }

    public void setYearEndDate(Date yearEndDate) {
        YearEndDate = yearEndDate;
    }

    public String getCurrency() {
        return Currency;
    }

    public void setCurrency(String currency) {
        Currency = currency;
    }

    public Float getExRate() {
        return ExRate;
    }

    public void setExRate(Float exRate) {
        ExRate = exRate;
    }

    public String getIPOStatus() {
        return IPOStatus;
    }

    public void setIPOStatus(String IPOStatus) {
        this.IPOStatus = IPOStatus;
    }

    public String getStatementType() {
        return StatementType;
    }

    public void setStatementType(String statementType) {
        StatementType = statementType;
    }

    public Integer getCoverPeriod() {
        return CoverPeriod;
    }

    public void setCoverPeriod(Integer coverPeriod) {
        CoverPeriod = coverPeriod;
    }

    public Double getFixAss() {
        return FixAss;
    }

    public void setFixAss(Double fixAss) {
        FixAss = fixAss;
    }

    public Double getInvest() {
        return Invest;
    }

    public void setInvest(Double invest) {
        Invest = invest;
    }

    public Double getOtherAss() {
        return OtherAss;
    }

    public void setOtherAss(Double otherAss) {
        OtherAss = otherAss;
    }

    public Double getTotalNonCurrAss() {
        return TotalNonCurrAss;
    }

    public void setTotalNonCurrAss(Double totalNonCurrAss) {
        TotalNonCurrAss = totalNonCurrAss;
    }

    public Double getInventory() {
        return Inventory;
    }

    public void setInventory(Double inventory) {
        Inventory = inventory;
    }

    public Double getTradeDebtors() {
        return TradeDebtors;
    }

    public void setTradeDebtors(Double tradeDebtors) {
        TradeDebtors = tradeDebtors;
    }

    public Double getMarketSecurities() {
        return MarketSecurities;
    }

    public void setMarketSecurities(Double marketSecurities) {
        MarketSecurities = marketSecurities;
    }

    public Double getCashNearCash() {
        return CashNearCash;
    }

    public void setCashNearCash(Double cashNearCash) {
        CashNearCash = cashNearCash;
    }

    public Double getOtherCurrAss() {
        return OtherCurrAss;
    }

    public void setOtherCurrAss(Double otherCurrAss) {
        OtherCurrAss = otherCurrAss;
    }

    public Double getCurrAss() {
        return CurrAss;
    }

    public void setCurrAss(Double currAss) {
        CurrAss = currAss;
    }

    public Double getTotalAss() {
        return TotalAss;
    }

    public void setTotalAss(Double totalAss) {
        TotalAss = totalAss;
    }

    public Double getTradeCreditors() {
        return TradeCreditors;
    }

    public void setTradeCreditors(Double tradeCreditors) {
        TradeCreditors = tradeCreditors;
    }

    public Double getSTDebt() {
        return STDebt;
    }

    public void setSTDebt(Double STDebt) {
        this.STDebt = STDebt;
    }

    public Double getOtherSTLiab() {
        return OtherSTLiab;
    }

    public void setOtherSTLiab(Double otherSTLiab) {
        OtherSTLiab = otherSTLiab;
    }

    public Double getCurrLiab() {
        return CurrLiab;
    }

    public void setCurrLiab(Double currLiab) {
        CurrLiab = currLiab;
    }

    public Double getLTDebt() {
        return LTDebt;
    }

    public void setLTDebt(Double LTDebt) {
        this.LTDebt = LTDebt;
    }

    public Double getOtherLiabNOMI() {
        return OtherLiabNOMI;
    }

    public void setOtherLiabNOMI(Double otherLiabNOMI) {
        OtherLiabNOMI = otherLiabNOMI;
    }

    public Double getTotalNonCurrLiab() {
        return TotalNonCurrLiab;
    }

    public void setTotalNonCurrLiab(Double totalNonCurrLiab) {
        TotalNonCurrLiab = totalNonCurrLiab;
    }

    public Double getShareCapComm() {
        return ShareCapComm;
    }

    public void setShareCapComm(Double shareCapComm) {
        ShareCapComm = shareCapComm;
    }

    public Double getShareCapPref() {
        return ShareCapPref;
    }

    public void setShareCapPref(Double shareCapPref) {
        ShareCapPref = shareCapPref;
    }

    public Double getShareCap() {
        return ShareCap;
    }

    public void setShareCap(Double shareCap) {
        ShareCap = shareCap;
    }

    public Double getTotalReservesExclPerpetualSecurities() {
        return TotalReservesExclPerpetualSecurities;
    }

    public void setTotalReservesExclPerpetualSecurities(Double totalReservesExclPerpetualSecurities) {
        TotalReservesExclPerpetualSecurities = totalReservesExclPerpetualSecurities;
    }

    public Double getEquityExclPerpetualSecurities() {
        return EquityExclPerpetualSecurities;
    }

    public void setEquityExclPerpetualSecurities(Double equityExclPerpetualSecurities) {
        EquityExclPerpetualSecurities = equityExclPerpetualSecurities;
    }

    public Double getPerpetualSecurities() {
        return PerpetualSecurities;
    }

    public void setPerpetualSecurities(Double perpetualSecurities) {
        PerpetualSecurities = perpetualSecurities;
    }

    public Double getMinoritiesBS() {
        return MinoritiesBS;
    }

    public void setMinoritiesBS(Double minoritiesBS) {
        MinoritiesBS = minoritiesBS;
    }

    public Double getTotalEquity() {
        return TotalEquity;
    }

    public void setTotalEquity(Double totalEquity) {
        TotalEquity = totalEquity;
    }

    public Double getQuickAssets() {
        return QuickAssets;
    }

    public void setQuickAssets(Double quickAssets) {
        QuickAssets = quickAssets;
    }

    public Double getTotalDebt() {
        return TotalDebt;
    }

    public void setTotalDebt(Double totalDebt) {
        TotalDebt = totalDebt;
    }

    public Double getNetDebt() {
        return NetDebt;
    }

    public void setNetDebt(Double netDebt) {
        NetDebt = netDebt;
    }

    public Double getCurrAssLessCurrLiab() {
        return CurrAssLessCurrLiab;
    }

    public void setCurrAssLessCurrLiab(Double currAssLessCurrLiab) {
        CurrAssLessCurrLiab = currAssLessCurrLiab;
    }

    public Double getCapex() {
        return Capex;
    }

    public void setCapex(Double capex) {
        Capex = capex;
    }

    public Double getTotalAssLessCurrLiab() {
        return TotalAssLessCurrLiab;
    }

    public void setTotalAssLessCurrLiab(Double totalAssLessCurrLiab) {
        TotalAssLessCurrLiab = totalAssLessCurrLiab;
    }

    public Double getNetAssTotalLiab() {
        return NetAssTotalLiab;
    }

    public void setNetAssTotalLiab(Double netAssTotalLiab) {
        NetAssTotalLiab = netAssTotalLiab;
    }

    public Double getLiabTotal() {
        return LiabTotal;
    }

    public void setLiabTotal(Double liabTotal) {
        LiabTotal = liabTotal;
    }

    public String getAuditor() {
        return Auditor;
    }

    public void setAuditor(String auditor) {
        Auditor = auditor;
    }

    public Double getInvestmentProperties() {
        return InvestmentProperties;
    }

    public void setInvestmentProperties(Double investmentProperties) {
        InvestmentProperties = investmentProperties;
    }

    public Double getPropertyEquipment() {
        return PropertyEquipment;
    }

    public void setPropertyEquipment(Double propertyEquipment) {
        PropertyEquipment = propertyEquipment;
    }

    public Double getLeaseholdLandRights() {
        return LeaseholdLandRights;
    }

    public void setLeaseholdLandRights(Double leaseholdLandRights) {
        LeaseholdLandRights = leaseholdLandRights;
    }

    public Double getPrepaidLandLeasePremium() {
        return PrepaidLandLeasePremium;
    }

    public void setPrepaidLandLeasePremium(Double prepaidLandLeasePremium) {
        PrepaidLandLeasePremium = prepaidLandLeasePremium;
    }

    public Double getDebtSecurities() {
        return DebtSecurities;
    }

    public void setDebtSecurities(Double debtSecurities) {
        DebtSecurities = debtSecurities;
    }

    public Double getEquitySecurities() {
        return EquitySecurities;
    }

    public void setEquitySecurities(Double equitySecurities) {
        EquitySecurities = equitySecurities;
    }

    public Double getLoans() {
        return Loans;
    }

    public void setLoans(Double loans) {
        Loans = loans;
    }

    public Double getInvestmentOther() {
        return InvestmentOther;
    }

    public void setInvestmentOther(Double investmentOther) {
        InvestmentOther = investmentOther;
    }

    public Double getIntAssociates() {
        return IntAssociates;
    }

    public void setIntAssociates(Double intAssociates) {
        IntAssociates = intAssociates;
    }

    public Double getIntJointVentures() {
        return IntJointVentures;
    }

    public void setIntJointVentures(Double intJointVentures) {
        IntJointVentures = intJointVentures;
    }

    public Double getGoodwillOnly() {
        return GoodwillOnly;
    }

    public void setGoodwillOnly(Double goodwillOnly) {
        GoodwillOnly = goodwillOnly;
    }

    public Double getAssetOtherIntangile() {
        return AssetOtherIntangile;
    }

    public void setAssetOtherIntangile(Double assetOtherIntangile) {
        AssetOtherIntangile = assetOtherIntangile;
    }

    public Double getInsuranceReceivable() {
        return InsuranceReceivable;
    }

    public void setInsuranceReceivable(Double insuranceReceivable) {
        InsuranceReceivable = insuranceReceivable;
    }

    public Double getAssetReinsurance() {
        return AssetReinsurance;
    }

    public void setAssetReinsurance(Double assetReinsurance) {
        AssetReinsurance = assetReinsurance;
    }

    public Double getAmountDueFromRelatedParties() {
        return AmountDueFromRelatedParties;
    }

    public void setAmountDueFromRelatedParties(Double amountDueFromRelatedParties) {
        AmountDueFromRelatedParties = amountDueFromRelatedParties;
    }

    public Double getAcquisitionCostDeferredPolicy() {
        return AcquisitionCostDeferredPolicy;
    }

    public void setAcquisitionCostDeferredPolicy(Double acquisitionCostDeferredPolicy) {
        AcquisitionCostDeferredPolicy = acquisitionCostDeferredPolicy;
    }

    public Double getAssetDeferredTax() {
        return AssetDeferredTax;
    }

    public void setAssetDeferredTax(Double assetDeferredTax) {
        AssetDeferredTax = assetDeferredTax;
    }

    public Double getDepositsStatutory() {
        return DepositsStatutory;
    }

    public void setDepositsStatutory(Double depositsStatutory) {
        DepositsStatutory = depositsStatutory;
    }

    public Double getInsuranceFund() {
        return InsuranceFund;
    }

    public void setInsuranceFund(Double insuranceFund) {
        InsuranceFund = insuranceFund;
    }

    public Double getInsuranceProtectionFund() {
        return InsuranceProtectionFund;
    }

    public void setInsuranceProtectionFund(Double insuranceProtectionFund) {
        InsuranceProtectionFund = insuranceProtectionFund;
    }

    public Double getInsurancePayable() {
        return InsurancePayable;
    }

    public void setInsurancePayable(Double insurancePayable) {
        InsurancePayable = insurancePayable;
    }

    public Double getLiabInvContract() {
        return LiabInvContract;
    }

    public void setLiabInvContract(Double liabInvContract) {
        LiabInvContract = liabInvContract;
    }

    public Double getAssetSoldAgreement() {
        return AssetSoldAgreement;
    }

    public void setAssetSoldAgreement(Double assetSoldAgreement) {
        AssetSoldAgreement = assetSoldAgreement;
    }

    public Double getAmountDueToRelatedParties() {
        return AmountDueToRelatedParties;
    }

    public void setAmountDueToRelatedParties(Double amountDueToRelatedParties) {
        AmountDueToRelatedParties = amountDueToRelatedParties;
    }

    public Double getTaxationCurr() {
        return TaxationCurr;
    }

    public void setTaxationCurr(Double taxationCurr) {
        TaxationCurr = taxationCurr;
    }

    public Double getLiabDeferredTax() {
        return LiabDeferredTax;
    }

    public void setLiabDeferredTax(Double liabDeferredTax) {
        LiabDeferredTax = liabDeferredTax;
    }

    public Double getInvestmentTotal() {
        return InvestmentTotal;
    }

    public void setInvestmentTotal(Double investmentTotal) {
        InvestmentTotal = investmentTotal;
    }

    public Double getIntAssociatesJointVentures() {
        return IntAssociatesJointVentures;
    }

    public void setIntAssociatesJointVentures(Double intAssociatesJointVentures) {
        IntAssociatesJointVentures = intAssociatesJointVentures;
    }

    public Double getGoodwill() {
        return Goodwill;
    }

    public void setGoodwill(Double goodwill) {
        Goodwill = goodwill;
    }

    public Double getEmbeddedValue() {
        return EmbeddedValue;
    }

    public void setEmbeddedValue(Double embeddedValue) {
        EmbeddedValue = embeddedValue;
    }

    public Double getEnterpriseValue() {
        return EnterpriseValue;
    }

    public void setEnterpriseValue(Double enterpriseValue) {
        EnterpriseValue = enterpriseValue;
    }

    public Double getCashShortTermFund() {
        return CashShortTermFund;
    }

    public void setCashShortTermFund(Double cashShortTermFund) {
        CashShortTermFund = cashShortTermFund;
    }

    public Double getCollectionFromBank() {
        return CollectionFromBank;
    }

    public void setCollectionFromBank(Double collectionFromBank) {
        CollectionFromBank = collectionFromBank;
    }

    public Double getPlacingWithBank() {
        return PlacingWithBank;
    }

    public void setPlacingWithBank(Double placingWithBank) {
        PlacingWithBank = placingWithBank;
    }

    public Double getTradingBill() {
        return TradingBill;
    }

    public void setTradingBill(Double tradingBill) {
        TradingBill = tradingBill;
    }

    public Double getTradingAsset() {
        return TradingAsset;
    }

    public void setTradingAsset(Double tradingAsset) {
        TradingAsset = tradingAsset;
    }

    public Double getDerivativesAsset() {
        return DerivativesAsset;
    }

    public void setDerivativesAsset(Double derivativesAsset) {
        DerivativesAsset = derivativesAsset;
    }

    public Double getDepositHold() {
        return DepositHold;
    }

    public void setDepositHold(Double depositHold) {
        DepositHold = depositHold;
    }

    public Double getLoanToBank() {
        return LoanToBank;
    }

    public void setLoanToBank(Double loanToBank) {
        LoanToBank = loanToBank;
    }

    public Double getLoanToCustomer() {
        return LoanToCustomer;
    }

    public void setLoanToCustomer(Double loanToCustomer) {
        LoanToCustomer = loanToCustomer;
    }

    public Double getFinancialInvestment() {
        return FinancialInvestment;
    }

    public void setFinancialInvestment(Double financialInvestment) {
        FinancialInvestment = financialInvestment;
    }

    public Double getInterestAssociate() {
        return InterestAssociate;
    }

    public void setInterestAssociate(Double interestAssociate) {
        InterestAssociate = interestAssociate;
    }

    public Double getGoodWill() {
        return GoodWill;
    }

    public void setGoodWill(Double goodWill) {
        GoodWill = goodWill;
    }

    public Double getAssetOther() {
        return AssetOther;
    }

    public void setAssetOther(Double assetOther) {
        AssetOther = assetOther;
    }

    public Double getCurrencyNoteInCirculation() {
        return CurrencyNoteInCirculation;
    }

    public void setCurrencyNoteInCirculation(Double currencyNoteInCirculation) {
        CurrencyNoteInCirculation = currencyNoteInCirculation;
    }

    public Double getDepositsFromBank() {
        return DepositsFromBank;
    }

    public void setDepositsFromBank(Double depositsFromBank) {
        DepositsFromBank = depositsFromBank;
    }

    public Double getDepositsFromCustomer() {
        return DepositsFromCustomer;
    }

    public void setDepositsFromCustomer(Double depositsFromCustomer) {
        DepositsFromCustomer = depositsFromCustomer;
    }

    public Double getPlacementFromBank() {
        return PlacementFromBank;
    }

    public void setPlacementFromBank(Double placementFromBank) {
        PlacementFromBank = placementFromBank;
    }

    public Double getLiabTrading() {
        return LiabTrading;
    }

    public void setLiabTrading(Double liabTrading) {
        LiabTrading = liabTrading;
    }

    public Double getFinancialLiabFairValue() {
        return FinancialLiabFairValue;
    }

    public void setFinancialLiabFairValue(Double financialLiabFairValue) {
        FinancialLiabFairValue = financialLiabFairValue;
    }

    public Double getDerivativesLiabilities() {
        return DerivativesLiabilities;
    }

    public void setDerivativesLiabilities(Double derivativesLiabilities) {
        DerivativesLiabilities = derivativesLiabilities;
    }

    public Double getLiabSubOrdinated() {
        return LiabSubOrdinated;
    }

    public void setLiabSubOrdinated(Double liabSubOrdinated) {
        LiabSubOrdinated = liabSubOrdinated;
    }

    public Double getLiabOther() {
        return LiabOther;
    }

    public void setLiabOther(Double liabOther) {
        LiabOther = liabOther;
    }

    public Double getGrossAdvToCustomers() {
        return GrossAdvToCustomers;
    }

    public void setGrossAdvToCustomers(Double grossAdvToCustomers) {
        GrossAdvToCustomers = grossAdvToCustomers;
    }

    public Double getImpAdvToCustomers() {
        return ImpAdvToCustomers;
    }

    public void setImpAdvToCustomers(Double impAdvToCustomers) {
        ImpAdvToCustomers = impAdvToCustomers;
    }

    public Double getLoanToBankCustomer() {
        return LoanToBankCustomer;
    }

    public void setLoanToBankCustomer(Double loanToBankCustomer) {
        LoanToBankCustomer = loanToBankCustomer;
    }

    public Double getDepositsFromBankCustomer() {
        return DepositsFromBankCustomer;
    }

    public void setDepositsFromBankCustomer(Double depositsFromBankCustomer) {
        DepositsFromBankCustomer = depositsFromBankCustomer;
    }

    public Double getTotalDebtInstruments() {
        return TotalDebtInstruments;
    }

    public void setTotalDebtInstruments(Double totalDebtInstruments) {
        TotalDebtInstruments = totalDebtInstruments;
    }
}
