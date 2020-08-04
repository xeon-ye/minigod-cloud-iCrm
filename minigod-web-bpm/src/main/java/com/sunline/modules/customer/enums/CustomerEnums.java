package com.sunline.modules.customer.enums;

/**
 *
 *
 * @author lcs
 * @email
 * @date 2018-04-25 09:31:43
 */
public final class CustomerEnums {
    private CustomerEnums() {
    }
    /**
     * 客户类型
     */
    public enum ClientType {
        CLIENT_TYPE_NOR("0", "正常"),
        CLIENT_TYPE_POT("1", "潜在用户");

        private final String index;
        private final String name;

        ClientType(String index, String name){
            this.index = index;
            this.name = name;
        };

        public String getIndex() {
            return index;
        }

        public String getName() {
            return name;
        }

        public static String getName(String index) {
            for (ClientType c : ClientType.values()) {
                if (c.getIndex().equals(index)) {
                    return c.getName();
                }
            }
            return null;
        }
    }

    /**
     * 开户状态
     */
    public enum OpenAccountType {
        OPEN_ACCOUNT_TYPE_NET("1", "互联网"),
        OPEN_ACCOUNT_TYPE_WIT("2", "见证宝"),
        OPEN_ACCOUNT_TYPE_BPM("3", "BPM");

        private final String index;
        private final String name;

        OpenAccountType(String index, String name){
            this.index = index;
            this.name = name;
        };

        public String getIndex() {
            return index;
        }

        public String getName() {
            return name;
        }

        public static String getName(String index) {
            for (OpenAccountType o : OpenAccountType.values()) {
                if (o.getIndex().equals(index)) {
                    return o.getName();
                }
            }
            return null;
        }
    }

    /**
     * 性别
     */
    public enum Sex {
        SEX_MAN("0", "男"),
        SEX_WOM("1", "女"),
        SEX_ELS("2", "其他");

        private final String index;
        private final String name;

        Sex(String index, String name){
            this.index = index;
            this.name = name;
        };

        public String getIndex() {
            return index;
        }

        public String getName() {
            return name;
        }

        public static String getName(String index) {
            for (Sex s : Sex.values()) {
                if (s.getIndex().equals(index)) {
                    return s.getName();
                }
            }
            return null;
        }
    }

    /**
     * 年收入
     */
    public enum Income {
        INCOME_20W("1", "<20万"),
        INCOME_50W("2", "20万-50万"),
        INCOME_100W("3", "50万-100万"),
        INCOME_500W("4", "100万-500万"),
        INCOME_Over500W("5", ">500万");

        private final String index;
        private final String name;

        Income(String index, String name){
            this.index = index;
            this.name = name;
        };

        public String getIndex() {
            return index;
        }

        public String getName() {
            return name;
        }

        public static String getName(String index) {
            for (Income i : Income.values()) {
                if (i.getIndex().equals(index)) {
                    return i.getName();
                }
            }
            return null;
        }
    }

    /**
     * 净资产范围类型
     */
    public enum NetCapital {
        NET_CAPITAL_20W("1", "<20万"),
        NET_CAPITAL_50W("2", "20万-50万"),
        NET_CAPITAL_100W("3", "50万-100万"),
        NET_CAPITAL_500W("4", "100万-500万"),
        NET_CAPITAL_Over500W("5", ">500万");

        private final String index;
        private final String name;

        NetCapital(String index, String name){
            this.index = index;
            this.name = name;
        };

        public String getIndex() {
            return index;
        }

        public String getName() {
            return name;
        }

        public static String getName(String index) {
            for (NetCapital n : NetCapital.values()) {
                if (n.getIndex().equals(index)) {
                    return n.getName();
                }
            }
            return null;
        }
    }

    /**
     * 股票投资经验类型
     */
    public enum InvestTarget {
        INVEST_TARGET_NOT("0", "没有经验"),
        INVEST_TARGET_ONE("1", "小于一年"),
        INVEST_TARGET_THR("2", "一年至三年"),
        INVEST_TARGET_FIV("3", "三年至五年"),
        INVEST_TARGET_OVF("4", "五年以上");

        private final String index;
        private final String name;

        InvestTarget(String index, String name){
            this.index = index;
            this.name = name;
        };

        public String getIndex() {
            return index;
        }

        public String getName() {
            return name;
        }

        public static String getName(String index) {
            for (InvestTarget t : InvestTarget.values()) {
                if (t.getIndex().equals(index)) {
                    return t.getName();
                }
            }
            return null;
        }
    }

    /**
     * 注册状态
     */
    public enum UserStatus {
        USER_STATUS_OFF("0","停用"),
        USER_STATUS_NOR("1","正常"),
        USER_STATUS_LOC("2","锁定");

        private final String index;
        private final String name;

        UserStatus(String index, String name){
            this.index = index;
            this.name = name;
        };

        public String getIndex() {
            return index;
        }

        public String getName() {
            return name;
        }

        public static String getName(String index) {
            for (UserStatus s : UserStatus.values()) {
                if (s.getIndex().equals(index)) {
                    return s.getName();
                }
            }
            return null;
        }
    }

    /**
     * 开户状态
     */
    public enum ClientStatus {
        CLIENT_STATUS_NOR("0","正常"),
        CLIENT_STATUS_FRE("1","冻结"),
        CLIENT_STATUS_LOS("2","挂失"),
        CLIENT_STATUS_CLO("3","销户"),
        CLIENT_STATUS_DOR("4","休眠"),
        CLIENT_STATUS_UNQ("5","不合格"),
        CLIENT_STATUS_LOC("6","锁定");

        private final String index;
        private final String name;

        ClientStatus(String index, String name){
            this.index = index;
            this.name = name;
        };

        public String getIndex() {
            return index;
        }

        public String getName() {
            return name;
        }

        public static String getName(String index) {
            for (ClientStatus c : ClientStatus.values()) {
                if (c.getIndex().equals(index)) {
                    return c.getName();
                }
            }
            return null;
        }
    }

    /**
     * 入金状态
     */
    public enum DepositTypeIn {
        DEPOSIT_TYPE_IN_YES("D","已入金"),
        DEPOSIT_TYPE_IN_NO("N","未入金");


        private final String index;
        private final String name;

        DepositTypeIn(String index, String name){
            this.index = index;
            this.name = name;
        };

        public String getIndex() {
            return index;
        }

        public String getName() {
            return name;
        }

        public static String getName(String index) {
            for (DepositTypeIn d : DepositTypeIn.values()) {
                if (d.getIndex().equals(index)) {
                    return d.getName();
                }
            }
            return null;
        }
    }

    /**
     * 出金状态
     */
    public enum DepositTypeOut {
        DEPOSIT_TYPE_OUT_YES("W","已出金"),
        DEPOSIT_TYPE_OUT_NO("N","未出金");


        private final String index;
        private final String name;

        DepositTypeOut(String index, String name){
            this.index = index;
            this.name = name;
        };

        public String getIndex() {
            return index;
        }

        public String getName() {
            return name;
        }

        public static String getName(String index) {
            for (DepositTypeOut d : DepositTypeOut.values()) {
                if (d.getIndex().equals(index)) {
                    return d.getName();
                }
            }
            return null;
        }
    }

    /**
     * 交易类型
     */
    public enum FareDict {

        FARE_DICT_SER("0","服务费"),
        FARE_DICT_TRA("1","交易费");


        private final String index;
        private final String name;

        FareDict(String index, String name){
            this.index = index;
            this.name = name;
        };

        public String getIndex() {
            return index;
        }

        public String getName() {
            return name;
        }

        public static String getName(String index) {
            for (FareDict f : FareDict.values()) {
                if (f.getIndex().equals(index)) {
                    return f.getName();
                }
            }
            return null;
        }
    }

    /**
     * 收费方式
     */
    public enum FeeType {

        FEE_TYPE_PER("0","百分比"),
        FEE_TYPE_COU("1","交易费"),
        FEE_TYPE_NUM("5","交易费");


        private final String index;
        private final String name;

        FeeType(String index, String name){
            this.index = index;
            this.name = name;
        };

        public String getIndex() {
            return index;
        }

        public String getName() {
            return name;
        }

        public static String getName(String index) {
            for (FeeType f : FeeType.values()) {
                if (f.getIndex().equals(index)) {
                    return f.getName();
                }
            }
            return null;
        }
    }
}
