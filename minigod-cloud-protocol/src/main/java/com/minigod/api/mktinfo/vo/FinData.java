package com.minigod.api.mktinfo.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
public class FinData implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private String Code;//证券代码
	private Date ListingDate;//上市日期
	private Date LastDealDate;//退市日期
	private Date DelistingDate;//除牌日期
	private String TradeCurrency;//交易货币
	private Integer BoardLot;//买卖单位
	private String TradingStatus;//上市状态
	private String IndicatorShortSell;//可进行卖空
	private String IndicatorStampDuty;//缴纳印花税
	private String IndicatorCCASS;//中央结算系统
	private String ISINCode;//国际证券号码
	private String IndexChiName;//指数成份股
	private Float IndexWeight;//指数比重
	private Float IndexSp;//每价位指数变动
	private String IndustryChiName;//新鸿基行业名称
	private Float IndustryWeight;//新鸿基行业指数比重
	private Float IndustrySp;//新鸿基行业每价位指数变动
	private String ChiOfferPrice;//上市发售价详细
	private Float AdjOfferPriceChange;//距经调整上市发售价变动
	private Integer ParallelCode;//并行买卖编号
	private String ParallelPeriod;//并行买卖期间
	private String SuspensionPeriod;//原有股份暂停买卖期间
	private Double IssueCap;//已发行股本 (百万股)
	private Double IssueCapH;//已发行股本 - H 股 (百万股)
	private Double MarketCap;//市价总值 (百万元)
	private Float ClosePrice;//最后收市价
	private Date ClosePriceDate;//最后收市价日期
	private Double LastVolume;//最后成交股数
	private Float OneDayVolumeChange;//一日成交股数变动
	private Float YTDHigh;//今年最高价
	private Float YTDLow;//今年最低价
	private Double YTDAvgTurnover;//今年平均成交金额
	private Double YTDAvgVolume;//今年平均成交量
	private Float W52High;//五十二周最高价
	private Float W52Low;//五十二周最低价
	private Float W52HighChange;//距五十二周最高价变动
	private Float W52LowChange;//距五十二周最低价变动
	private Float OneDayPriceChange;//一日股价变动
	private Float OneWeekPriceChange;//一星期股价变动
	private Float TwoWeekPriceChange;//二星期股价变动
	private Float OneMonthPriceChange;//一个月股价变动
	private Float ThreeMonthPriceChange;//三个月股价变动
	private Float SixMonthPriceChange;//六个月股价变动
	private Float OneYearPriceChange;//五十二周股价变动
	private Float YTDPriceChange;//今年股价变动
	private Float OneMonthMarketChange;//一个月相对恒指股价变动
	private Float ThreeMonthMarketChange;//三个月相对恒指股价变动
	private Float SixMonthMarketChange;//六个月相对恒指股价变动
	private Float OneYearMarketChange;//五十二周相对恒指股价变动
	private Float YTDMarketChange;//今年相对恒指股价变动
	private Double OneWeekAvgVolume;//一星期平均成交股数
	private Double OneWeekAvgTurnover;//一星期平均成交金额
	private Double OneMonthAvgVolume;//一个月平均成交股数
	private Double OneMonthAvgTurnover;//一个月平均成交金额
	private Double ThreeMonthAvgVolume;//三个月平均成交股数
	private Double ThreeMonthAvgTurnover;//三个月平均成交金额
	private Float Ma10;//十天平均线
	private Float Ma20;//二十天平均线
	private Float Ma50;//五十天平均线
	private Float Ma90;//九十天平均线
	private Float Ma250;//二百五十天平均线
	private Float Rsi10;//十天强弱指数
	private Float Rsi14;//十四天强弱指数
	private Float Osc10;//十天摆动指数
	private Float LastPE;//市盈率 (化作年计)
	private Float LastYield;//周息率(化作年计)
	private Float LastPriceBook;//股价/每股资产净值
	private Float LastPrice2CashPS;//股价/每股现金
	private Float LastPrice2DebtPS;//股价/每股负债
	private Float LastPrice2CashflowPS;
	private Float LastEPSGrowth;//股价盈利增长
	private Date YearEndDate;//财政年度年结日期
	private String Currency;//报表货币
	private String StatementType;//报表种类
	private String OutputUnit;//Data unit used
	private String ReportDateString;//最新公布业绩
	private String YearEndString;//财政年度
	private Double EPS;//每股盈利
	private Double DPS;//每股派息
	private Double NAV;//每股资产净值
	private Double IncomeInterest;//利息收益净额
	private Double IncomeTotalOtherOperating;//其他营业收益
	private Double TotalOperExpenses;//经营开支总额
	private Double TotalImpairmentLoss;//减值损失及准备总额
	private Double NetInsuranceClaim;//保险索偿净额
	private Double OperProfitLoss;//营业溢利
	private Double ExceptionalItem;//特殊项目
	private Double PBT;//除税前溢利
	private Double NetProf;//股东应占溢利
	private Double FixAss;//固定资产
	private Double GoodWill;//无形资产
	private Double LoanToCustomer;//客户贷款及垫款
	private Double CashShortTermFund;//库存现金及短期资金
	private Double AssetOther;//其他资产
	private Double TotalAss;//总资产
	private Double DepositsFromCustomer;//客户存款
	private Double DerivativesAsset;//衍生工具 (负债)
	private Double LiabOther;//其他负债
	private Double Equity;//股东资金
	private Double CapitalAdequacyReported;//资本充足比率
	private Double CostIncome;//成本/收入
	private Double loansGrowth;//贷款按年变动
	private Double depositsGrowth;//存款按年变动
	private Double LfDeposits;//流动资金/存款
	private Double LiquidityRatioReported;//平均流动资金比率
	private Double LoansDeposits;//贷款/存款
	private Double LoansTotalEquity;//贷款/权益总额
	private Double LoansTa;//贷款/总资产
	private Double DepositsTotalEquity;//存款/权益总额
	private Double depositsTa;//存款/总资产
	private Double ROAvgLoans;//平均贷款回报率
	private Double ROAvgDeposits;//平均存款回报率
    private Double Turnover;//营业额
    private Double operProfit;//营业溢利
    private Double exceptItem;//特殊项目
    private Double pbt;//除税前溢利
    private Double taxation;//税项
    private Double netProf;//股东应占溢利
    private Double deprec;//折旧
    private Double intPaid;//贷款利息
    private Double intCap;//利息拨作发展资本
    private Double fixAss;//固定资产
    private Double invest;//投资
    private Double currAss;//流动资产
    private Double cash;//现金及银行结存
    private Double inventory;//存货
    private Double totalAss;//总资产
    private Double currLiab;//流动负债
    private Double stDebt;//短期债项
    private Double ltDebt;//长期债项
    private Double equity;//股东权益
    private Double CurrentRatio;//流动比率
    private Double QuickRatio;//速动比率
    private Double LtdEquity;//长期债项/股东权益
    private Double TdEquity;//总债项/股东权益
    private Double TdCapex;//总债项/资本运用
    private Double NdEquity;//净债项/股东权益
    private Double Roequity;//股东权益回报率
    private Double Rota;//总资产回报率
    private Double Opm;//经营利润率
    private Double Npm;//边际利润率
    private Double InventoryTurnover;//存货周转率
    private Double Dividendpayout;//派息比率
    private Double FYHighPE;//财政年度最高市盈率
    private Double FYLowPE;//财政年度最低市盈率
    private Double FYHighYield;//财政年度最高周息
    private Double FYLowYield;//财政年度最低周息



    public String getCode () {
        return Code;
    }

    public void setCode (String Code) {
        this.Code = Code;
    }

    public Date getListingDate () {
        return ListingDate;
    }

    public void setListingDate (Date ListingDate) {
        this.ListingDate = ListingDate;
    }

    public Date getLastDealDate () {
        return LastDealDate;
    }

    public void setLastDealDate (Date LastDealDate) {
        this.LastDealDate = LastDealDate;
    }

    public Date getDelistingDate () {
        return DelistingDate;
    }

    public void setDelistingDate (Date DelistingDate) {
        this.DelistingDate = DelistingDate;
    }

    public String getTradeCurrency () {
        return TradeCurrency;
    }

    public void setTradeCurrency (String TradeCurrency) {
        this.TradeCurrency = TradeCurrency;
    }

    public Integer getBoardLot () {
        return BoardLot;
    }

    public void setBoardLot (Integer BoardLot) {
        this.BoardLot = BoardLot;
    }

    public String getTradingStatus () {
        return TradingStatus;
    }

    public void setTradingStatus (String TradingStatus) {
        this.TradingStatus = TradingStatus;
    }

    public String getIndicatorShortSell () {
        return IndicatorShortSell;
    }

    public void setIndicatorShortSell (String IndicatorShortSell) {
        this.IndicatorShortSell = IndicatorShortSell;
    }

    public String getIndicatorStampDuty () {
        return IndicatorStampDuty;
    }

    public void setIndicatorStampDuty (String IndicatorStampDuty) {
        this.IndicatorStampDuty = IndicatorStampDuty;
    }

    public String getIndicatorCCASS () {
        return IndicatorCCASS;
    }

    public void setIndicatorCCASS (String IndicatorCCASS) {
        this.IndicatorCCASS = IndicatorCCASS;
    }

    public String getISINCode () {
        return ISINCode;
    }

    public void setISINCode (String ISINCode) {
        this.ISINCode = ISINCode;
    }

    public String getIndexChiName () {
        return IndexChiName;
    }

    public void setIndexChiName (String IndexChiName) {
        this.IndexChiName = IndexChiName;
    }

    public Float getIndexWeight () {
        return IndexWeight;
    }

    public void setIndexWeight (Float IndexWeight) {
        this.IndexWeight = IndexWeight;
    }

    public Float getIndexSp () {
        return IndexSp;
    }

    public void setIndexSp (Float IndexSp) {
        this.IndexSp = IndexSp;
    }

    public String getIndustryChiName () {
        return IndustryChiName;
    }

    public void setIndustryChiName (String IndustryChiName) {
        this.IndustryChiName = IndustryChiName;
    }

    public Float getIndustryWeight () {
        return IndustryWeight;
    }

    public void setIndustryWeight (Float IndustryWeight) {
        this.IndustryWeight = IndustryWeight;
    }

    public Float getIndustrySp () {
        return IndustrySp;
    }

    public void setIndustrySp (Float IndustrySp) {
        this.IndustrySp = IndustrySp;
    }

    public String getChiOfferPrice () {
        return ChiOfferPrice;
    }

    public void setChiOfferPrice (String ChiOfferPrice) {
        this.ChiOfferPrice = ChiOfferPrice;
    }

    public Float getAdjOfferPriceChange () {
        return AdjOfferPriceChange;
    }

    public void setAdjOfferPriceChange (Float AdjOfferPriceChange) {
        this.AdjOfferPriceChange = AdjOfferPriceChange;
    }

    public Integer getParallelCode () {
        return ParallelCode;
    }

    public void setParallelCode (Integer ParallelCode) {
        this.ParallelCode = ParallelCode;
    }

    public String getParallelPeriod () {
        return ParallelPeriod;
    }

    public void setParallelPeriod (String ParallelPeriod) {
        this.ParallelPeriod = ParallelPeriod;
    }

    public String getSuspensionPeriod () {
        return SuspensionPeriod;
    }

    public void setSuspensionPeriod (String SuspensionPeriod) {
        this.SuspensionPeriod = SuspensionPeriod;
    }

    public Double getIssueCap () {
        return IssueCap;
    }

    public void setIssueCap (Double IssueCap) {
        this.IssueCap = IssueCap;
    }

    public Double getIssueCapH () {
        return IssueCapH;
    }

    public void setIssueCapH (Double IssueCapH) {
        this.IssueCapH = IssueCapH;
    }

    public Double getMarketCap () {
        return MarketCap;
    }

    public void setMarketCap (Double MarketCap) {
        this.MarketCap = MarketCap;
    }

    public Float getClosePrice () {
        return ClosePrice;
    }

    public void setClosePrice (Float ClosePrice) {
        this.ClosePrice = ClosePrice;
    }

    public Date getClosePriceDate () {
        return ClosePriceDate;
    }

    public void setClosePriceDate (Date ClosePriceDate) {
        this.ClosePriceDate = ClosePriceDate;
    }

    public Double getLastVolume () {
        return LastVolume;
    }

    public void setLastVolume (Double LastVolume) {
        this.LastVolume = LastVolume;
    }

    public Float getOneDayVolumeChange () {
        return OneDayVolumeChange;
    }

    public void setOneDayVolumeChange (Float OneDayVolumeChange) {
        this.OneDayVolumeChange = OneDayVolumeChange;
    }

    public Float getYTDHigh () {
        return YTDHigh;
    }

    public void setYTDHigh (Float YTDHigh) {
        this.YTDHigh = YTDHigh;
    }

    public Float getYTDLow () {
        return YTDLow;
    }

    public void setYTDLow (Float YTDLow) {
        this.YTDLow = YTDLow;
    }

    public Double getYTDAvgTurnover () {
        return YTDAvgTurnover;
    }

    public void setYTDAvgTurnover (Double YTDAvgTurnover) {
        this.YTDAvgTurnover = YTDAvgTurnover;
    }

    public Double getYTDAvgVolume () {
        return YTDAvgVolume;
    }

    public void setYTDAvgVolume (Double YTDAvgVolume) {
        this.YTDAvgVolume = YTDAvgVolume;
    }

    public Float getW52High () {
        return W52High;
    }

    public void setW52High (Float W52High) {
        this.W52High = W52High;
    }

    public Float getW52Low () {
        return W52Low;
    }

    public void setW52Low (Float W52Low) {
        this.W52Low = W52Low;
    }

    public Float getW52HighChange () {
        return W52HighChange;
    }

    public void setW52HighChange (Float W52HighChange) {
        this.W52HighChange = W52HighChange;
    }

    public Float getW52LowChange () {
        return W52LowChange;
    }

    public void setW52LowChange (Float W52LowChange) {
        this.W52LowChange = W52LowChange;
    }

    public Float getOneDayPriceChange () {
        return OneDayPriceChange;
    }

    public void setOneDayPriceChange (Float OneDayPriceChange) {
        this.OneDayPriceChange = OneDayPriceChange;
    }

    public Float getOneWeekPriceChange () {
        return OneWeekPriceChange;
    }

    public void setOneWeekPriceChange (Float OneWeekPriceChange) {
        this.OneWeekPriceChange = OneWeekPriceChange;
    }

    public Float getTwoWeekPriceChange () {
        return TwoWeekPriceChange;
    }

    public void setTwoWeekPriceChange (Float TwoWeekPriceChange) {
        this.TwoWeekPriceChange = TwoWeekPriceChange;
    }

    public Float getOneMonthPriceChange () {
        return OneMonthPriceChange;
    }

    public void setOneMonthPriceChange (Float OneMonthPriceChange) {
        this.OneMonthPriceChange = OneMonthPriceChange;
    }

    public Float getThreeMonthPriceChange () {
        return ThreeMonthPriceChange;
    }

    public void setThreeMonthPriceChange (Float ThreeMonthPriceChange) {
        this.ThreeMonthPriceChange = ThreeMonthPriceChange;
    }

    public Float getSixMonthPriceChange () {
        return SixMonthPriceChange;
    }

    public void setSixMonthPriceChange (Float SixMonthPriceChange) {
        this.SixMonthPriceChange = SixMonthPriceChange;
    }

    public Float getOneYearPriceChange () {
        return OneYearPriceChange;
    }

    public void setOneYearPriceChange (Float OneYearPriceChange) {
        this.OneYearPriceChange = OneYearPriceChange;
    }

    public Float getYTDPriceChange () {
        return YTDPriceChange;
    }

    public void setYTDPriceChange (Float YTDPriceChange) {
        this.YTDPriceChange = YTDPriceChange;
    }

    public Float getOneMonthMarketChange () {
        return OneMonthMarketChange;
    }

    public void setOneMonthMarketChange (Float OneMonthMarketChange) {
        this.OneMonthMarketChange = OneMonthMarketChange;
    }

    public Float getThreeMonthMarketChange () {
        return ThreeMonthMarketChange;
    }

    public void setThreeMonthMarketChange (Float ThreeMonthMarketChange) {
        this.ThreeMonthMarketChange = ThreeMonthMarketChange;
    }

    public Float getSixMonthMarketChange () {
        return SixMonthMarketChange;
    }

    public void setSixMonthMarketChange (Float SixMonthMarketChange) {
        this.SixMonthMarketChange = SixMonthMarketChange;
    }

    public Float getOneYearMarketChange () {
        return OneYearMarketChange;
    }

    public void setOneYearMarketChange (Float OneYearMarketChange) {
        this.OneYearMarketChange = OneYearMarketChange;
    }

    public Float getYTDMarketChange () {
        return YTDMarketChange;
    }

    public void setYTDMarketChange (Float YTDMarketChange) {
        this.YTDMarketChange = YTDMarketChange;
    }

    public Double getOneWeekAvgVolume () {
        return OneWeekAvgVolume;
    }

    public void setOneWeekAvgVolume (Double OneWeekAvgVolume) {
        this.OneWeekAvgVolume = OneWeekAvgVolume;
    }

    public Double getOneWeekAvgTurnover () {
        return OneWeekAvgTurnover;
    }

    public void setOneWeekAvgTurnover (Double OneWeekAvgTurnover) {
        this.OneWeekAvgTurnover = OneWeekAvgTurnover;
    }

    public Double getOneMonthAvgVolume () {
        return OneMonthAvgVolume;
    }

    public void setOneMonthAvgVolume (Double OneMonthAvgVolume) {
        this.OneMonthAvgVolume = OneMonthAvgVolume;
    }

    public Double getOneMonthAvgTurnover () {
        return OneMonthAvgTurnover;
    }

    public void setOneMonthAvgTurnover (Double OneMonthAvgTurnover) {
        this.OneMonthAvgTurnover = OneMonthAvgTurnover;
    }

    public Double getThreeMonthAvgVolume () {
        return ThreeMonthAvgVolume;
    }

    public void setThreeMonthAvgVolume (Double ThreeMonthAvgVolume) {
        this.ThreeMonthAvgVolume = ThreeMonthAvgVolume;
    }

    public Double getThreeMonthAvgTurnover () {
        return ThreeMonthAvgTurnover;
    }

    public void setThreeMonthAvgTurnover (Double ThreeMonthAvgTurnover) {
        this.ThreeMonthAvgTurnover = ThreeMonthAvgTurnover;
    }

    public Float getMa10 () {
        return Ma10;
    }

    public void setMa10 (Float Ma10) {
        this.Ma10 = Ma10;
    }

    public Float getMa20 () {
        return Ma20;
    }

    public void setMa20 (Float Ma20) {
        this.Ma20 = Ma20;
    }

    public Float getMa50 () {
        return Ma50;
    }

    public void setMa50 (Float Ma50) {
        this.Ma50 = Ma50;
    }

    public Float getMa90 () {
        return Ma90;
    }

    public void setMa90 (Float Ma90) {
        this.Ma90 = Ma90;
    }

    public Float getMa250 () {
        return Ma250;
    }

    public void setMa250 (Float Ma250) {
        this.Ma250 = Ma250;
    }

    public Float getRsi10 () {
        return Rsi10;
    }

    public void setRsi10 (Float Rsi10) {
        this.Rsi10 = Rsi10;
    }

    public Float getRsi14 () {
        return Rsi14;
    }

    public void setRsi14 (Float Rsi14) {
        this.Rsi14 = Rsi14;
    }

    public Float getOsc10 () {
        return Osc10;
    }

    public void setOsc10 (Float Osc10) {
        this.Osc10 = Osc10;
    }

    public Float getLastPE () {
        return LastPE;
    }

    public void setLastPE (Float LastPE) {
        this.LastPE = LastPE;
    }

    public Float getLastYield () {
        return LastYield;
    }

    public void setLastYield (Float LastYield) {
        this.LastYield = LastYield;
    }

    public Float getLastPriceBook () {
        return LastPriceBook;
    }

    public void setLastPriceBook (Float LastPriceBook) {
        this.LastPriceBook = LastPriceBook;
    }

    public Float getLastPrice2CashPS () {
        return LastPrice2CashPS;
    }

    public void setLastPrice2CashPS (Float LastPrice2CashPS) {
        this.LastPrice2CashPS = LastPrice2CashPS;
    }

    public Float getLastPrice2DebtPS () {
        return LastPrice2DebtPS;
    }

    public void setLastPrice2DebtPS (Float LastPrice2DebtPS) {
        this.LastPrice2DebtPS = LastPrice2DebtPS;
    }

    public Float getLastPrice2CashflowPS () {
        return LastPrice2CashflowPS;
    }

    public void setLastPrice2CashflowPS (Float LastPrice2CashflowPS) {
        this.LastPrice2CashflowPS = LastPrice2CashflowPS;
    }

    public Float getLastEPSGrowth () {
        return LastEPSGrowth;
    }

    public void setLastEPSGrowth (Float LastEPSGrowth) {
        this.LastEPSGrowth = LastEPSGrowth;
    }

    public Date getYearEndDate () {
        return YearEndDate;
    }

    public void setYearEndDate (Date YearEndDate) {
        this.YearEndDate = YearEndDate;
    }

    public String getCurrency () {
        return Currency;
    }

    public void setCurrency (String Currency) {
        this.Currency = Currency;
    }

    public String getStatementType () {
        return StatementType;
    }

    public void setStatementType (String StatementType) {
        this.StatementType = StatementType;
    }

    public String getOutputUnit () {
        return OutputUnit;
    }

    public void setOutputUnit (String OutputUnit) {
        this.OutputUnit = OutputUnit;
    }

    public String getReportDateString () {
        return ReportDateString;
    }

    public void setReportDateString (String ReportDateString) {
        this.ReportDateString = ReportDateString;
    }

    public String getYearEndString () {
        return YearEndString;
    }

    public void setYearEndString (String YearEndString) {
        this.YearEndString = YearEndString;
    }

    public Double getEPS () {
        return EPS;
    }

    public void setEPS (Double EPS) {
        this.EPS = EPS;
    }

    public Double getDPS () {
        return DPS;
    }

    public void setDPS (Double DPS) {
        this.DPS = DPS;
    }

    public Double getNAV () {
        return NAV;
    }

    public void setNAV (Double NAV) {
        this.NAV = NAV;
    }

    public Double getIncomeInterest () {
        return IncomeInterest;
    }

    public void setIncomeInterest (Double IncomeInterest) {
        this.IncomeInterest = IncomeInterest;
    }

    public Double getIncomeTotalOtherOperating () {
        return IncomeTotalOtherOperating;
    }

    public void setIncomeTotalOtherOperating (Double IncomeTotalOtherOperating) {
        this.IncomeTotalOtherOperating = IncomeTotalOtherOperating;
    }

    public Double getTotalOperExpenses () {
        return TotalOperExpenses;
    }

    public void setTotalOperExpenses (Double TotalOperExpenses) {
        this.TotalOperExpenses = TotalOperExpenses;
    }

    public Double getTotalImpairmentLoss () {
        return TotalImpairmentLoss;
    }

    public void setTotalImpairmentLoss (Double TotalImpairmentLoss) {
        this.TotalImpairmentLoss = TotalImpairmentLoss;
    }

    public Double getNetInsuranceClaim () {
        return NetInsuranceClaim;
    }

    public void setNetInsuranceClaim (Double NetInsuranceClaim) {
        this.NetInsuranceClaim = NetInsuranceClaim;
    }

    public Double getOperProfitLoss () {
        return OperProfitLoss;
    }

    public void setOperProfitLoss (Double OperProfitLoss) {
        this.OperProfitLoss = OperProfitLoss;
    }

    public Double getExceptionalItem () {
        return ExceptionalItem;
    }

    public void setExceptionalItem (Double ExceptionalItem) {
        this.ExceptionalItem = ExceptionalItem;
    }

    public Double getPBT () {
        return PBT;
    }

    public void setPBT (Double PBT) {
        this.PBT = PBT;
    }

    public Double getNetProf () {
        return NetProf;
    }

    public void setNetProf (Double NetProf) {
        this.NetProf = NetProf;
    }

    public Double getFixAss () {
        return FixAss;
    }

    public void setFixAss (Double FixAss) {
        this.FixAss = FixAss;
    }

    public Double getGoodWill () {
        return GoodWill;
    }

    public void setGoodWill (Double GoodWill) {
        this.GoodWill = GoodWill;
    }

    public Double getLoanToCustomer () {
        return LoanToCustomer;
    }

    public void setLoanToCustomer (Double LoanToCustomer) {
        this.LoanToCustomer = LoanToCustomer;
    }

    public Double getCashShortTermFund () {
        return CashShortTermFund;
    }

    public void setCashShortTermFund (Double CashShortTermFund) {
        this.CashShortTermFund = CashShortTermFund;
    }

    public Double getAssetOther () {
        return AssetOther;
    }

    public void setAssetOther (Double AssetOther) {
        this.AssetOther = AssetOther;
    }

    public Double getTotalAss () {
        return TotalAss;
    }

    public void setTotalAss (Double TotalAss) {
        this.TotalAss = TotalAss;
    }

    public Double getDepositsFromCustomer () {
        return DepositsFromCustomer;
    }

    public void setDepositsFromCustomer (Double DepositsFromCustomer) {
        this.DepositsFromCustomer = DepositsFromCustomer;
    }

    public Double getDerivativesAsset () {
        return DerivativesAsset;
    }

    public void setDerivativesAsset (Double DerivativesAsset) {
        this.DerivativesAsset = DerivativesAsset;
    }

    public Double getLiabOther () {
        return LiabOther;
    }

    public void setLiabOther (Double LiabOther) {
        this.LiabOther = LiabOther;
    }

    public Double getEquity () {
        return Equity;
    }

    public void setEquity (Double Equity) {
        this.Equity = Equity;
    }

    public Double getCapitalAdequacyReported () {
        return CapitalAdequacyReported;
    }

    public void setCapitalAdequacyReported (Double CapitalAdequacyReported) {
        this.CapitalAdequacyReported = CapitalAdequacyReported;
    }

    public Double getCostIncome () {
        return CostIncome;
    }

    public void setCostIncome (Double CostIncome) {
        this.CostIncome = CostIncome;
    }

    public Double getLoansGrowth () {
        return loansGrowth;
    }

    public void setLoansGrowth (Double loansGrowth) {
        this.loansGrowth = loansGrowth;
    }

    public Double getDepositsGrowth () {
        return depositsGrowth;
    }

    public void setDepositsGrowth (Double depositsGrowth) {
        this.depositsGrowth = depositsGrowth;
    }

    public Double getLfDeposits () {
        return LfDeposits;
    }

    public void setLfDeposits (Double LfDeposits) {
        this.LfDeposits = LfDeposits;
    }

    public Double getLiquidityRatioReported () {
        return LiquidityRatioReported;
    }

    public void setLiquidityRatioReported (Double LiquidityRatioReported) {
        this.LiquidityRatioReported = LiquidityRatioReported;
    }

    public Double getLoansDeposits () {
        return LoansDeposits;
    }

    public void setLoansDeposits (Double LoansDeposits) {
        this.LoansDeposits = LoansDeposits;
    }

    public Double getLoansTotalEquity () {
        return LoansTotalEquity;
    }

    public void setLoansTotalEquity (Double LoansTotalEquity) {
        this.LoansTotalEquity = LoansTotalEquity;
    }

    public Double getLoansTa () {
        return LoansTa;
    }

    public void setLoansTa (Double LoansTa) {
        this.LoansTa = LoansTa;
    }

    public Double getDepositsTotalEquity () {
        return DepositsTotalEquity;
    }

    public void setDepositsTotalEquity (Double DepositsTotalEquity) {
        this.DepositsTotalEquity = DepositsTotalEquity;
    }

    public Double getDepositsTa () {
        return depositsTa;
    }

    public void setDepositsTa (Double depositsTa) {
        this.depositsTa = depositsTa;
    }

    public Double getROAvgLoans () {
        return ROAvgLoans;
    }

    public void setROAvgLoans (Double ROAvgLoans) {
        this.ROAvgLoans = ROAvgLoans;
    }

    public Double getROAvgDeposits () {
        return ROAvgDeposits;
    }

    public void setROAvgDeposits (Double ROAvgDeposits) {
        this.ROAvgDeposits = ROAvgDeposits;
    }

    public Double getRoequity () {
        return Roequity;
    }

    public void setRoequity (Double Roequity) {
        this.Roequity = Roequity;
    }

    public Double getRota () {
        return Rota;
    }

    public void setRota (Double Rota) {
        this.Rota = Rota;
    }

    public Double getDividendpayout () {
        return Dividendpayout;
    }

    public void setDividendpayout (Double Dividendpayout) {
        this.Dividendpayout = Dividendpayout;
    }

    public Double getFYHighPE () {
        return FYHighPE;
    }

    public void setFYHighPE (Double FYHighPE) {
        this.FYHighPE = FYHighPE;
    }

    public Double getFYLowPE () {
        return FYLowPE;
    }

    public void setFYLowPE (Double FYLowPE) {
        this.FYLowPE = FYLowPE;
    }

    public Double getFYHighYield () {
        return FYHighYield;
    }

    public void setFYHighYield (Double FYHighYield) {
        this.FYHighYield = FYHighYield;
    }

    public Double getFYLowYield () {
        return FYLowYield;
    }

    public void setFYLowYield (Double FYLowYield) {
        this.FYLowYield = FYLowYield;
    }

    public Double getTurnover() {
        return Turnover;
    }

    public void setTurnover(Double turnover) {
        Turnover = turnover;
    }

    public Double getOperProfit() {
        return operProfit;
    }

    public void setOperProfit(Double operProfit) {
        this.operProfit = operProfit;
    }

    public Double getExceptItem() {
        return exceptItem;
    }

    public void setExceptItem(Double exceptItem) {
        this.exceptItem = exceptItem;
    }

    public Double getPbt() {
        return pbt;
    }

    public void setPbt(Double pbt) {
        this.pbt = pbt;
    }

    public Double getTaxation() {
        return taxation;
    }

    public void setTaxation(Double taxation) {
        this.taxation = taxation;
    }

    public Double getDeprec() {
        return deprec;
    }

    public void setDeprec(Double deprec) {
        this.deprec = deprec;
    }

    public Double getIntPaid() {
        return intPaid;
    }

    public void setIntPaid(Double intPaid) {
        this.intPaid = intPaid;
    }

    public Double getIntCap() {
        return intCap;
    }

    public void setIntCap(Double intCap) {
        this.intCap = intCap;
    }

    public Double getInvest() {
        return invest;
    }

    public void setInvest(Double invest) {
        this.invest = invest;
    }

    public Double getCurrAss() {
        return currAss;
    }

    public void setCurrAss(Double currAss) {
        this.currAss = currAss;
    }

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public Double getInventory() {
        return inventory;
    }

    public void setInventory(Double inventory) {
        this.inventory = inventory;
    }

    public Double getCurrLiab() {
        return currLiab;
    }

    public void setCurrLiab(Double currLiab) {
        this.currLiab = currLiab;
    }

    public Double getStDebt() {
        return stDebt;
    }

    public void setStDebt(Double stDebt) {
        this.stDebt = stDebt;
    }

    public Double getLtDebt() {
        return ltDebt;
    }

    public void setLtDebt(Double ltDebt) {
        this.ltDebt = ltDebt;
    }

    public Double getCurrentRatio() {
        return CurrentRatio;
    }

    public void setCurrentRatio(Double currentRatio) {
        CurrentRatio = currentRatio;
    }

    public Double getQuickRatio() {
        return QuickRatio;
    }

    public void setQuickRatio(Double quickRatio) {
        QuickRatio = quickRatio;
    }

    public Double getLtdEquity() {
        return LtdEquity;
    }

    public void setLtdEquity(Double ltdEquity) {
        LtdEquity = ltdEquity;
    }

    public Double getTdEquity() {
        return TdEquity;
    }

    public void setTdEquity(Double tdEquity) {
        TdEquity = tdEquity;
    }

    public Double getTdCapex() {
        return TdCapex;
    }

    public void setTdCapex(Double tdCapex) {
        TdCapex = tdCapex;
    }

    public Double getNdEquity() {
        return NdEquity;
    }

    public void setNdEquity(Double ndEquity) {
        NdEquity = ndEquity;
    }

    public Double getOpm() {
        return Opm;
    }

    public void setOpm(Double opm) {
        Opm = opm;
    }

    public Double getNpm() {
        return Npm;
    }

    public void setNpm(Double npm) {
        Npm = npm;
    }

    public Double getInventoryTurnover() {
        return InventoryTurnover;
    }

    public void setInventoryTurnover(Double inventoryTurnover) {
        InventoryTurnover = inventoryTurnover;
    }
}