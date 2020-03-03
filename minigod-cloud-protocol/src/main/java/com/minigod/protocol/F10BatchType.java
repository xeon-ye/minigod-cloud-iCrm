package com.minigod.protocol;

/**
 * @Author: PENGFENG
 * @Description:
 * @Date: Created in 16:42 2017/9/5
 * @Modified By:
 */
public enum F10BatchType {
    HK_INSTITUTION_INFO(1001, "公司基本信息"),
    HK_STOCK_INFO(1002, "股票基本信息"),
    HK_CHANGE_OF_SHARES(1003, "股本变动信息"),
    HK_DIVIDEND(1004, "派息记录"),
    HK_BOARD_MEETING_NOTIFICATIONS(1005, "董事会会议"),
    HK_DER_WARRANTSINFO(1006, "窝轮基本信息"),
    HK_DRE_CBBC_INFO(1007, "牛熊证基本信息"),
    HK_IPO_INFO(1008, "IPO信息"),
    HK_IPO_INVESTOR_INFO(1009, "IPO基本投资者信息"),
    HK_MANAGER(1010, "高管信息"),
    HK_SPLITMERGE(1011, "分拆合并"),
    HK_CURRENCY_CONVERSION(1012, "货币兑换参数"),
    HK_PUBLIC_HOLIDAYS(1013, "香港公众假期"),
    HK_EARNINGS_SUMMARY(1014, "盈利摘要"),
    HK_FIN_INCOME(1015, "利润(非银行)"),
    HK_FIN_BANK_OF_INCOME(1016, "利润(银行)"),
    HK_FIN_BALANCE(1017, "资产负债(非银行)"),
    HK_FIN_BANK_OF_BALANCE(1018, "资产负债(银行)"),
    HK_FIN_CASH_FLOW(1019, "现金流量"),

    US_INSTITUTION_INFO(2001,"公司基本信息"),
    US_MMANAGER(2002,"高管任职"),
    US_CHANGE_OF_SHARES(2003,"股本信息"),
    US_DIVIDEND(2004,"分红派息"),
    US_N_IPO(2005,"IPO信息"),
    US_SUSPENSION_REASON(2006,"停牌原因"),
    US_SUSPENSION_TIPS(2007,"停牌提示"),
    US_EARNINGS_SUMMARY_TEMP(2008,"盈利摘要"),
    US_FIN_FINANCIAL_RATIOS(2009,"财务比率"),
    US_FIN_INCOME(2010,"利润"),
    US_FIN_BALANCE(2021,"资产负债"),
    US_FIN_CASH_FLOW(2022,"现金流量");

    private F10BatchType(int typeKey , String typeValue) {
        this.typeKey = typeKey;
        this.typeValue = typeValue;
    }

    private int typeKey;
    private String typeValue;

    public int getTypeKey() {
        return typeKey;
    }

    public void setTypeKey(int typeKey) {
        this.typeKey = typeKey;
    }

    public String getTypeValue() {
        return typeValue;
    }

    public void setTypeValue(String typeValue) {
        this.typeValue = typeValue;
    }

    public static void main(String[] args) {
        System.out.println(F10BatchType.HK_BOARD_MEETING_NOTIFICATIONS.getTypeKey());
    }
}
