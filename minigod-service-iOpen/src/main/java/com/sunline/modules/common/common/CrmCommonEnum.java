package com.sunline.modules.common.common;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @description: CRM通用枚举
 * @author: Larry Lai
 * @date: 2018/4/27 11:25
 * @version: v1.0
 */

public final class CrmCommonEnum {

    private static final Map<Integer, CodeType> map = Maps.newHashMap();

    private CrmCommonEnum() {
    }

    /**
     * 公共模块相关
     */
    public enum CodeType {

        OK(0, "调用成功"),
        ERROR(-1, "error"),
        NONE_DATA(201, "无满足条件的数据"),
        EXIST_ERROR(300, "有重复值存在"),
        PARAMETER_DISMATCH(301, "参数不匹配"),
        PARAMETER_ERROR(400, "参数错误"),
        PARAMS_PARAMETER_ERROR(401, "params参数错误"),
        SING_PARAMETER_ERROR(402, "签名参数SIGN错误"),
        KEY_PARAMETER_ERROR(403, "签名参数KEY错误"),
        SESSION_PARAMETER_ERROR(405, "参数SESSION_ID错误"),
        SOCKET_ERROR(404, "网络异常"),
        INTERNAL_ERROR(500, "请求异常，请重试"),
        UNBIND_WECHAT_ACC(600, "未绑定微信账号"),
        SIGN_ERROR(889, "签名错误"),
        ERROR_UNKNOWN(9999, "未知错误"),
        SESSION_INVALID(-9999, "未登录或者session已失效"),
        WEB_SUCCESS(0, "ok"),
        WEB_ERROR(-1, "error"),
        WEB_DUPLICATE(-2, "exist");

        private int code;
        private String message;

        CodeType(int code, String message) {
            this.code = code;
            this.message = message;
            map.put(code, this);
        }

        public int getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }

        public static String getMessage(int code) {
            CodeType codeType = map.get(code);
            if (codeType == null) {
                return ERROR_UNKNOWN.getMessage();
            }
            return codeType.getMessage();
        }
    }

    /**
     * 返回结果
     */
    public enum CommonEnum {

        /**
         * 返回结果
         */
        COMMON_CODE_SUCCESS(0, "成功"),
        COMMON_CODE_FAILED(-1, "失败");

        private final int index;
        private final String name;

        CommonEnum(int index, String name) {
            this.index = index;
            this.name = name;
        }

        public static String getName(int index) {
            for (CommonEnum c : CommonEnum.values()) {
                if (c.getIndex() == index) {
                    return c.name;
                }
            }
            return null;
        }

        public int getIndex() {
            return index;
        }

        public String getName() {
            return name;
        }
    }

    /**
     * 证券业务数据字典
     */
    public enum SecDataDictionary {

        /**
         * 证券市场
         */
        SEC_EXCHANGE_TYPE_SEHK("K", "港交所"),
        SEC_EXCHANGE_TYPE_US("P", "美国市场"),

        /**
         * 交易类别
         */
        SEC_TRADE_KIND_BUY("0B", "买入"),
        SEC_TRADE_KIND_SELL("0S", "卖出"),

        /**
         * 委托方式
         */
        SEC_ENTRUST_WAY_IINTERNET("7", "网上委托"),
        SEC_ENTRUST_WAY_SELF("4", "自助委托"),
        SEC_ENTRUST_WAY_PHONE("T", "电话委托"),

        /**
         * 操作代码
         */
        SEC_STOCK_TRANSFER_DEP("3101", "转入"),
        SEC_STOCK_TRANSFER_WIT("3102", "转出"),
        SEC_STOCK_TRANSFER_SI_DEP("3027", "SI转入"),
        SEC_STOCK_TRANSFER_SI_WIT("3028", "SI转出"),

        /**
         * 操作代码
         */
        SEC_FUND_DEPOSIT_DEP("D", "存入"),
        SEC_FUND_DEPOSIT_WIT("W", "取出");


        private final String index;
        private final String name;

        SecDataDictionary(String index, String name) {
            this.index = index;
            this.name = name;
        }

        public static String getName(String index) {
            for (SecDataDictionary c : SecDataDictionary.values()) {
                if (c.getIndex().equals(index)) {
                    return c.name;
                }
            }
            return null;
        }

        public String getIndex() {
            return index;
        }

        public String getName() {
            return name;
        }
    }

    /**
     * 净资产范围类型
     */
    public enum SecNetCapital {
        AO_NET_CAPITAL_1("1", "<50万"),
        AO_NET_CAPITAL_2("2", "50万-250万"),
        AO_NET_CAPITAL_3("3", "250万-500万"),
        AO_NET_CAPITAL_4("4", ">500万");

        private final String index;
        private final String name;

        SecNetCapital(String index, String name) {
            this.index = index;
            this.name = name;
        }

        public static String getName(String index) {
            for (SecNetCapital c : SecNetCapital.values()) {
                if (c.getIndex().equals(index)) {
                    return c.name;
                }
            }
            return null;
        }

        public String getIndex() {
            return index;
        }

        public String getName() {
            return name;
        }
    }

    /**
     * 币种代码
     */
    public enum SecMoneyType {

        SEC_MONEY_TYPE_CNY("0", "人民币"),
        SEC_MONEY_TYPE_USD("1", "美元"),
        SEC_MONEY_TYPE_HKD("2", "港币"),
        SEC_MONEY_TYPE_AUD("6", "澳元"),
        SEC_MONEY_TYPE_CAD("E", "加元"),
        SEC_MONEY_TYPE_CHF("F", "瑞士法郎"),
        SEC_MONEY_TYPE_MYR("f", "马来西亚林吉特"),
        SEC_MONEY_TYPE_NZD("j", "新西兰元"),
        SEC_MONEY_TYPE_PHP("l", "菲律宾比索"),
        SEC_MONEY_TYPE_EUR("M", "欧元"),
        SEC_MONEY_TYPE_GBP("Q", "英镑"),
        SEC_MONEY_TYPE_IDR("S", "印度尼西亚卢比"),
        SEC_MONEY_TYPE_SGD("t", "新加坡元"),
        SEC_MONEY_TYPE_TWD("w", "台币"),
        SEC_MONEY_TYPE_MOP("d", "澳门元"),
        SEC_MONEY_TYPE_JPY("W", "日元"),
        SEC_MONEY_TYPE_KRW("Y", "韩元"),
        SEC_MONEY_TYPE_FRF("P", "法国法郎"),
        SEC_MONEY_TYPE_ZAR("x", "南非兰特"),
        SEC_MONEY_TYPE_THB("v", "泰铢"),
        SEC_MONEY_TYPE_SLL("u", "塞拉利昂利昂"),
        SEC_MONEY_TYPE_INR("U", "印度卢比"),
        SEC_MONEY_TYPE_ITL("V", "意大利里拉"),
        SEC_MONEY_TYPE_SEK("s", "瑞典克朗");

        private final String index;
        private final String name;

        SecMoneyType(String index, String name) {
            this.index = index;
            this.name = name;
        }

        public static String getName(String index) {
            for (SecMoneyType c : SecMoneyType.values()) {
                if (c.getIndex().equals(index)) {
                    return c.name;
                }
            }
            return null;
        }

        public String getIndex() {
            return index;
        }

        public String getName() {
            return name;
        }
    }

    /**
     * 证券类别
     */
    public enum SecStockType {
        SEC_STOCK_TYPE_STOCK("0", "股票"),
        SEC_STOCK_TYPE_FUND("1", "基金"),
        SEC_STOCK_TYPE_WARRANT("D", "权证"),
        SEC_STOCK_TYPE_CBB("CBB", "牛熊证"),
        SEC_STOCK_TYPE_OPT("OPT", "债券"),
        SEC_STOCK_TYPE_WTS("WTS", "涡轮"),
        SEC_STOCK_TYPE_DER("DER", "衍生权证");

        private final String index;
        private final String name;

        SecStockType(String index, String name) {
            this.index = index;
            this.name = name;
        }

        public static String getName(String index) {
            for (SecStockType c : SecStockType.values()) {
                if (c.getIndex().equals(index)) {
                    return c.name;
                }
            }
            return null;
        }

        public String getIndex() {
            return index;
        }

        public String getName() {
            return name;
        }
    }

    /**
     * 证券类别
     */
    public enum SecStockTransfer {
        /**
         * 证券市场缩写
         */
        SEC_EXCHANGE_TYPE_SUFFIX_SEHK("K", "HK"),
        SEC_EXCHANGE_TYPE_SUFFIX_US("P", "US");

        private final String index;
        private final String name;

        SecStockTransfer(String index, String name) {
            this.index = index;
            this.name = name;
        }

        public static String getName(String index) {
            for (SecStockTransfer c : SecStockTransfer.values()) {
                if (c.getIndex().equals(index)) {
                    return c.name;
                }
            }
            return null;
        }

        public String getIndex() {
            return index;
        }

        public String getName() {
            return name;
        }
    }

    /**
     * 审核状态
     */
    public enum AuditStatus {

        /**
         * 返回结果
         */
        AUDIT_STATUS_UNTREATED(0, "未审核"),
        AUDIT_STATUS_PROCESSING(1, "审核中"),
        AUDIT_STATUS_PASS(2, "审核通过"),
        AUDIT_STATUS_NOPASS(3, "审核不通过");

        private final int index;
        private final String name;

        AuditStatus(int index, String name) {
            this.index = index;
            this.name = name;
        }

        public static String getName(int index) {
            for (CommonEnum c : CommonEnum.values()) {
                if (c.getIndex() == index) {
                    return c.name;
                }
            }
            return null;
        }

        public int getIndex() {
            return index;
        }

        public String getName() {
            return name;
        }
    }

    /**
     * 同步状态
     */
    public enum SyncStatus {

        /**
         * 返回结果
         */
        SYNC_STATUS_UNTREATED(0, "未同步"),
        SYNC_STATUS_PROCESSING(1, "正在同步"),
        SYNC_STATUS_COMPLETE(2, "同步成功"),
        SYNC_STATUS_FAILURE(3, "同步失败");

        private final int index;
        private final String name;

        SyncStatus(int index, String name) {
            this.index = index;
            this.name = name;
        }

        public static String getName(int index) {
            for (CommonEnum c : CommonEnum.values()) {
                if (c.getIndex() == index) {
                    return c.name;
                }
            }
            return null;
        }

        public int getIndex() {
            return index;
        }

        public String getName() {
            return name;
        }
    }

    /**
     * 免佣类型
     */
    public enum FreeCommType {

        /**
         * 返回结果
         */
        FREE_COMM_TYPE_OPENACCOUNT(0, "开户免佣"),
        FREE_COMM_TYPE_INVITER(1, "推荐股友免佣"),
        FREE_COMM_TYPE_DEPOSIT(2, "入金免佣");

        private final int index;
        private final String name;

        FreeCommType(int index, String name) {
            this.index = index;
            this.name = name;
        }

        public static String getName(int index) {
            for (CommonEnum c : CommonEnum.values()) {
                if (c.getIndex() == index) {
                    return c.name;
                }
            }
            return null;
        }

        public int getIndex() {
            return index;
        }

        public String getName() {
            return name;
        }
    }

    /**
     * 费用类型
     */
    public enum SecFareDict {
        SEC_FARE_DICT_0("0", "服务费"),
        SEC_FARE_DICT_1("1", "交易费");

        private final String index;
        private final String name;

        SecFareDict(String index, String name) {
            this.index = index;
            this.name = name;
        }

        public static String getName(String index) {
            for (SecFareDict c : SecFareDict.values()) {
                if (c.getIndex().equals(index)) {
                    return c.name;
                }
            }
            return null;
        }

        public String getIndex() {
            return index;
        }

        public String getName() {
            return name;
        }
    }

    /**
     * 费用类型
     */
    public enum SecFeeType {
        SEC_FEE_TYPE_0("0", "按百分比"),
        SEC_FEE_TYPE_1("1", "按固定笔数"),
        SEC_FEE_TYPE_2("2", "按固定股数");

        private final String index;
        private final String name;

        SecFeeType(String index, String name) {
            this.index = index;
            this.name = name;
        }

        public static String getName(String index) {
            for (SecFeeType c : SecFeeType.values()) {
                if (c.getIndex().equals(index)) {
                    return c.name;
                }
            }
            return null;
        }

        public String getIndex() {
            return index;
        }

        public String getName() {
            return name;
        }
    }

    /**
     * 恒生出入业务步骤定义
     */
    public enum FundWithDrawStep {


        FUND_WITHDRAW_STEP_UN_KNOWN(0, 0),
        FUND_WITHDRAW_SFUND_CASH_GD_FETCH(10009, 10009),
        FUND_WITHDRAW_STEP_FUND_FROZEN_GD_CANCEL(10007, 10007);


        public static final int FUND_WITHDRAW_STEP_UN_KNOWN_VALUE = 0;
        public static final int FUND_WITHDRAW_STEP_FUND_FROZEN_GD_CANCEL_VALUE = 10007;
        public static final int FUND_WITHDRAW_SFUND_CASH_GD_FETCH_VALUE = 10009;

        public final int getNumber() {
            return value;
        }

        public static FundWithDrawStep valueOf(int value) {
            switch (value) {
                case 0:
                    return FUND_WITHDRAW_STEP_UN_KNOWN;
                case 10007:
                    return FUND_WITHDRAW_STEP_FUND_FROZEN_GD_CANCEL;
                case 10009:
                    return FUND_WITHDRAW_SFUND_CASH_GD_FETCH;
                default:
                    return null;
            }
        }

        private final int value;

        private FundWithDrawStep(int index, int value) {
            this.value = value;
        }
    }

    /**
     * 币种代码（英文）
     */
    public enum SecMoneyTypeEn {

        SEC_MONEY_TYPE_EN_CNY("CNY", "0"),
        SEC_MONEY_TYPE_EN_USD("USD", "1"),
        SEC_MONEY_TYPE_EN_HKD("HKD", "2");

        private final String index;
        private final String name;

        SecMoneyTypeEn(String index, String name) {
            this.index = index;
            this.name = name;
        }

        public static String getName(String index) {
            for (SecMoneyTypeEn c : SecMoneyTypeEn.values()) {
                if (c.getIndex().equals(index)) {
                    return c.name;
                }
            }
            return null;
        }

        public String getIndex() {
            return index;
        }

        public String getName() {
            return name;
        }
    }

}
