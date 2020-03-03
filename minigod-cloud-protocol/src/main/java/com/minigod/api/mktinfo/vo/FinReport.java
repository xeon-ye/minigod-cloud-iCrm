package com.minigod.api.mktinfo.vo;

import java.util.Date;

/**
 * Created by huhu on 2016/7/7.
 */
public class FinReport {

    private String CODE = "";
    private Date AnnounceDate;//業績公佈日期
    private Date YearEndDate;//財政年度年結日期
    private String Currency;//報表貨幣
    private Float ExRate;//匯率(報表貨幣兌港元)
    private String IPOStatus;//上市前業績標記
    private String StatementType;//報表種類
    private Integer CoverPeriod;//覆蓋時期(月)
    private Double TotalTurnover;//營業額
    private Double TaxationOther;//所得稅以外的稅金
    private Double COGS;//銷售成本
    private Double GrossProfit;//毛利
    private Double TotalOperExpenses;//經營開支總額
    private Double OperProfitBeforeGain;//核心溢利/(虧損)
    private Double NonRecurringItem;//公平值變動及減值
    private Double CoreProfitAfterProvision;//扣除公平值變動及減值之核心溢利/(虧損)
    private Double OtherRevenue;//其他收入
    private Double ExceptItem;//其他非經營項目
    private Double OperProfitLoss;//經營溢利/(虧損)
    private Double FinCosts;//財務成本
    private Double Associates;//共同控制公司及聯營公司
    private Double PBT;//除稅前溢利/(虧損)
    private Double Taxation;//稅項
    private Double ControlTransfer;//管制計劃調撥
    private Double ProfitYear;//本其間溢利/(虧損)
    private Double ProfitEquityHolder;//本公司股本持有人應佔
    private Double Minorities;//非控股權益
    private Double NetProf;//純利/(虧損)
    private Double CompIncomeOther;//其他全面收入
    private Double CompIncomeTotal;//全面收入總額
    private Double ReportedEPS;//財報每股基本盈利
    private Double DilutedReportedEps;//財報每股攤薄盈利
    private String ReportedDPSCurrency;//財報每股派息貨幣
    private Double ReportedDPS;//財報每股派息
    private Double EBITA;//除利息、稅項及攤銷前盈利
    private Double EBITDA;//除利息、稅項、折舊及攤銷前盈利
    private Double Deprec;//物業、機器及設備折舊
    private Double Amort;//無形資產攤銷
    private Double DeprecAmort;//折舊及攤銷
    private Double IntPaid;//貸款利息
    private Double IntCap;//利息撥作發展資本
    private Double EPS;//經調整每股基本盈利
    private Double DilutedEPS;//經調整每股攤薄盈利
    private Double DPS;//經調整每股派息
    private Double NAV;//經調整每股資產淨值
    private Double IssueCapWA;//加權平均普通股股數
    private Double TaxationRate;//稅率 (%)
    private Double TurnoverGrowth;//營業額按年變動(%)
    private Double NPGrowth;//盈利按年變動 (%)
    private Double EPSGrowth;//每股基本盈利按年變動 (%)
    private String Auditor;//核數師意見

    private Double IncomeInterest;
    private Double ExpenseInterest;
    private Double NetintInc;
    private Double IncomeNetFee;
    private Double IncomeNetTrading;
    private Double IncomeOtherOperating;
    private Double NetInsuranceClaim;
    private Double NetOperatingIncomeBeforeLoad;
    private Double TotalImpairmentLoss;
    private Double NetOperatingIncome;
    private Double GrossWrittenPremium;
    private Double NetEarnedPremium;
    private Double NetInvestmentIncome;
    private Double NetPremiumInvIncome;
    private Double NetRealisedUnrealisedGain;
    private Double NetForeignExchangeGain;
    private Double OtherIncome;
    private Double IncomeTotalOperating;
    private Double NetClaimsIncurred;
    private Double OtherOperExpenses;
    private Double TotalBenefitsClaimsExpenses;
    private Double OperProfitBeforeFinCosts;


    public String getCODE() {
        return CODE;
    }

    public void setCODE(String CODE) {
        this.CODE = CODE;
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

    public Double getTotalTurnover() {
        return TotalTurnover;
    }

    public void setTotalTurnover(Double totalTurnover) {
        TotalTurnover = totalTurnover;
    }

    public Double getTaxationOther() {
        return TaxationOther;
    }

    public void setTaxationOther(Double taxationOther) {
        TaxationOther = taxationOther;
    }

    public Double getCOGS() {
        return COGS;
    }

    public void setCOGS(Double COGS) {
        this.COGS = COGS;
    }

    public Double getGrossProfit() {
        return GrossProfit;
    }

    public void setGrossProfit(Double grossProfit) {
        GrossProfit = grossProfit;
    }

    public Double getTotalOperExpenses() {
        return TotalOperExpenses;
    }

    public void setTotalOperExpenses(Double totalOperExpenses) {
        TotalOperExpenses = totalOperExpenses;
    }

    public Double getOperProfitBeforeGain() {
        return OperProfitBeforeGain;
    }

    public void setOperProfitBeforeGain(Double operProfitBeforeGain) {
        OperProfitBeforeGain = operProfitBeforeGain;
    }

    public Double getNonRecurringItem() {
        return NonRecurringItem;
    }

    public void setNonRecurringItem(Double nonRecurringItem) {
        NonRecurringItem = nonRecurringItem;
    }

    public Double getCoreProfitAfterProvision() {
        return CoreProfitAfterProvision;
    }

    public void setCoreProfitAfterProvision(Double coreProfitAfterProvision) {
        CoreProfitAfterProvision = coreProfitAfterProvision;
    }

    public Double getOtherRevenue() {
        return OtherRevenue;
    }

    public void setOtherRevenue(Double otherRevenue) {
        OtherRevenue = otherRevenue;
    }

    public Double getExceptItem() {
        return ExceptItem;
    }

    public void setExceptItem(Double exceptItem) {
        ExceptItem = exceptItem;
    }

    public Double getOperProfitLoss() {
        return OperProfitLoss;
    }

    public void setOperProfitLoss(Double operProfitLoss) {
        OperProfitLoss = operProfitLoss;
    }

    public Double getFinCosts() {
        return FinCosts;
    }

    public void setFinCosts(Double finCosts) {
        FinCosts = finCosts;
    }

    public Double getAssociates() {
        return Associates;
    }

    public void setAssociates(Double associates) {
        Associates = associates;
    }

    public Double getPBT() {
        return PBT;
    }

    public void setPBT(Double PBT) {
        this.PBT = PBT;
    }

    public Double getTaxation() {
        return Taxation;
    }

    public void setTaxation(Double taxation) {
        Taxation = taxation;
    }

    public Double getControlTransfer() {
        return ControlTransfer;
    }

    public void setControlTransfer(Double controlTransfer) {
        ControlTransfer = controlTransfer;
    }

    public Double getProfitYear() {
        return ProfitYear;
    }

    public void setProfitYear(Double profitYear) {
        ProfitYear = profitYear;
    }

    public Double getProfitEquityHolder() {
        return ProfitEquityHolder;
    }

    public void setProfitEquityHolder(Double profitEquityHolder) {
        ProfitEquityHolder = profitEquityHolder;
    }

    public Double getMinorities() {
        return Minorities;
    }

    public void setMinorities(Double minorities) {
        Minorities = minorities;
    }

    public Double getNetProf() {
        return NetProf;
    }

    public void setNetProf(Double netProf) {
        NetProf = netProf;
    }

    public Double getCompIncomeOther() {
        return CompIncomeOther;
    }

    public void setCompIncomeOther(Double compIncomeOther) {
        CompIncomeOther = compIncomeOther;
    }

    public Double getCompIncomeTotal() {
        return CompIncomeTotal;
    }

    public void setCompIncomeTotal(Double compIncomeTotal) {
        CompIncomeTotal = compIncomeTotal;
    }

    public Double getReportedEPS() {
        return ReportedEPS;
    }

    public void setReportedEPS(Double reportedEPS) {
        ReportedEPS = reportedEPS;
    }

    public Double getDilutedReportedEps() {
        return DilutedReportedEps;
    }

    public void setDilutedReportedEps(Double dilutedReportedEps) {
        DilutedReportedEps = dilutedReportedEps;
    }

    public String getReportedDPSCurrency() {
        return ReportedDPSCurrency;
    }

    public void setReportedDPSCurrency(String reportedDPSCurrency) {
        ReportedDPSCurrency = reportedDPSCurrency;
    }

    public Double getReportedDPS() {
        return ReportedDPS;
    }

    public void setReportedDPS(Double reportedDPS) {
        ReportedDPS = reportedDPS;
    }

    public Double getEBITA() {
        return EBITA;
    }

    public void setEBITA(Double EBITA) {
        this.EBITA = EBITA;
    }

    public Double getEBITDA() {
        return EBITDA;
    }

    public void setEBITDA(Double EBITDA) {
        this.EBITDA = EBITDA;
    }

    public Double getDeprec() {
        return Deprec;
    }

    public void setDeprec(Double deprec) {
        Deprec = deprec;
    }

    public Double getAmort() {
        return Amort;
    }

    public void setAmort(Double amort) {
        Amort = amort;
    }

    public Double getDeprecAmort() {
        return DeprecAmort;
    }

    public void setDeprecAmort(Double deprecAmort) {
        DeprecAmort = deprecAmort;
    }

    public Double getIntPaid() {
        return IntPaid;
    }

    public void setIntPaid(Double intPaid) {
        IntPaid = intPaid;
    }

    public Double getIntCap() {
        return IntCap;
    }

    public void setIntCap(Double intCap) {
        IntCap = intCap;
    }

    public Double getEPS() {
        return EPS;
    }

    public void setEPS(Double EPS) {
        this.EPS = EPS;
    }

    public Double getDilutedEPS() {
        return DilutedEPS;
    }

    public void setDilutedEPS(Double dilutedEPS) {
        DilutedEPS = dilutedEPS;
    }

    public Double getDPS() {
        return DPS;
    }

    public void setDPS(Double DPS) {
        this.DPS = DPS;
    }

    public Double getNAV() {
        return NAV;
    }

    public void setNAV(Double NAV) {
        this.NAV = NAV;
    }

    public Double getIssueCapWA() {
        return IssueCapWA;
    }

    public void setIssueCapWA(Double issueCapWA) {
        IssueCapWA = issueCapWA;
    }

    public Double getTaxationRate() {
        return TaxationRate;
    }

    public void setTaxationRate(Double taxationRate) {
        TaxationRate = taxationRate;
    }

    public Double getTurnoverGrowth() {
        return TurnoverGrowth;
    }

    public void setTurnoverGrowth(Double turnoverGrowth) {
        TurnoverGrowth = turnoverGrowth;
    }

    public Double getNPGrowth() {
        return NPGrowth;
    }

    public void setNPGrowth(Double NPGrowth) {
        this.NPGrowth = NPGrowth;
    }

    public Double getEPSGrowth() {
        return EPSGrowth;
    }

    public void setEPSGrowth(Double EPSGrowth) {
        this.EPSGrowth = EPSGrowth;
    }

    public String getAuditor() {
        return Auditor;
    }

    public void setAuditor(String auditor) {
        Auditor = auditor;
    }

    public Double getIncomeInterest() {
        return IncomeInterest;
    }

    public void setIncomeInterest(Double incomeInterest) {
        IncomeInterest = incomeInterest;
    }

    public Double getExpenseInterest() {
        return ExpenseInterest;
    }

    public void setExpenseInterest(Double expenseInterest) {
        ExpenseInterest = expenseInterest;
    }

    public Double getNetintInc() {
        return NetintInc;
    }

    public void setNetintInc(Double netintInc) {
        NetintInc = netintInc;
    }

    public Double getIncomeNetFee() {
        return IncomeNetFee;
    }

    public void setIncomeNetFee(Double incomeNetFee) {
        IncomeNetFee = incomeNetFee;
    }

    public Double getIncomeNetTrading() {
        return IncomeNetTrading;
    }

    public void setIncomeNetTrading(Double incomeNetTrading) {
        IncomeNetTrading = incomeNetTrading;
    }

    public Double getIncomeOtherOperating() {
        return IncomeOtherOperating;
    }

    public void setIncomeOtherOperating(Double incomeOtherOperating) {
        IncomeOtherOperating = incomeOtherOperating;
    }

    public Double getNetInsuranceClaim() {
        return NetInsuranceClaim;
    }

    public void setNetInsuranceClaim(Double netInsuranceClaim) {
        NetInsuranceClaim = netInsuranceClaim;
    }

    public Double getNetOperatingIncomeBeforeLoad() {
        return NetOperatingIncomeBeforeLoad;
    }

    public void setNetOperatingIncomeBeforeLoad(Double netOperatingIncomeBeforeLoad) {
        NetOperatingIncomeBeforeLoad = netOperatingIncomeBeforeLoad;
    }

    public Double getTotalImpairmentLoss() {
        return TotalImpairmentLoss;
    }

    public void setTotalImpairmentLoss(Double totalImpairmentLoss) {
        TotalImpairmentLoss = totalImpairmentLoss;
    }

    public Double getNetOperatingIncome() {
        return NetOperatingIncome;
    }

    public void setNetOperatingIncome(Double netOperatingIncome) {
        NetOperatingIncome = netOperatingIncome;
    }

    public Double getGrossWrittenPremium() {
        return GrossWrittenPremium;
    }

    public void setGrossWrittenPremium(Double grossWrittenPremium) {
        GrossWrittenPremium = grossWrittenPremium;
    }

    public Double getNetEarnedPremium() {
        return NetEarnedPremium;
    }

    public void setNetEarnedPremium(Double netEarnedPremium) {
        NetEarnedPremium = netEarnedPremium;
    }

    public Double getNetInvestmentIncome() {
        return NetInvestmentIncome;
    }

    public void setNetInvestmentIncome(Double netInvestmentIncome) {
        NetInvestmentIncome = netInvestmentIncome;
    }

    public Double getNetPremiumInvIncome() {
        return NetPremiumInvIncome;
    }

    public void setNetPremiumInvIncome(Double netPremiumInvIncome) {
        NetPremiumInvIncome = netPremiumInvIncome;
    }

    public Double getNetRealisedUnrealisedGain() {
        return NetRealisedUnrealisedGain;
    }

    public void setNetRealisedUnrealisedGain(Double netRealisedUnrealisedGain) {
        NetRealisedUnrealisedGain = netRealisedUnrealisedGain;
    }

    public Double getNetForeignExchangeGain() {
        return NetForeignExchangeGain;
    }

    public void setNetForeignExchangeGain(Double netForeignExchangeGain) {
        NetForeignExchangeGain = netForeignExchangeGain;
    }

    public Double getOtherIncome() {
        return OtherIncome;
    }

    public void setOtherIncome(Double otherIncome) {
        OtherIncome = otherIncome;
    }

    public Double getIncomeTotalOperating() {
        return IncomeTotalOperating;
    }

    public void setIncomeTotalOperating(Double incomeTotalOperating) {
        IncomeTotalOperating = incomeTotalOperating;
    }

    public Double getNetClaimsIncurred() {
        return NetClaimsIncurred;
    }

    public void setNetClaimsIncurred(Double netClaimsIncurred) {
        NetClaimsIncurred = netClaimsIncurred;
    }

    public Double getOtherOperExpenses() {
        return OtherOperExpenses;
    }

    public void setOtherOperExpenses(Double otherOperExpenses) {
        OtherOperExpenses = otherOperExpenses;
    }

    public Double getTotalBenefitsClaimsExpenses() {
        return TotalBenefitsClaimsExpenses;
    }

    public void setTotalBenefitsClaimsExpenses(Double totalBenefitsClaimsExpenses) {
        TotalBenefitsClaimsExpenses = totalBenefitsClaimsExpenses;
    }

    public Double getOperProfitBeforeFinCosts() {
        return OperProfitBeforeFinCosts;
    }

    public void setOperProfitBeforeFinCosts(Double operProfitBeforeFinCosts) {
        OperProfitBeforeFinCosts = operProfitBeforeFinCosts;
    }
}
