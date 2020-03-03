package com.minigod.api.inform.enums;

/**
 * @Author: PENGFENG
 * @Description:
 * @Date: Created in 11:29 2017/10/16
 * @Modified By:
 */
public class InformEnum {

    // 模板类型业务类型
    public enum BusTypeEnum {
        MAIL(1,"邮件通知"),
        MOBILE(2,"短信通知"),
        SYS(3,"系统通知"),
        MSG(4,"消息通知");

        private Integer typeCode;
        private String typeValue;

        private BusTypeEnum (Integer typeCode , String typeValue) {
            this.typeCode = typeCode;
            this.typeValue = typeValue;
        }

        public Integer getTypeCode () { return this.typeCode; }

        public static Integer getTypeCode (Integer index) {
            for (BusTypeEnum typeEnum : BusTypeEnum.values()) {
                if (typeEnum.getTypeCode().equals(index)) {
                    return typeEnum.typeCode;
                }
            }
            return null;
        }

        public static String getTypeValue(Integer index) {
            for (BusTypeEnum typeEnum : BusTypeEnum.values()) {
                if (typeEnum.getTypeCode().equals(index)) {
                    return typeEnum.typeValue;
                }
            }
            return null;
        }
    }

    // 模板类型中发送方式
    public enum SendWayEnum {
        SELF_MOTION(0,"自动"),
        MANUAL_OPERATION(1,"手动");

        private Integer typeCode;
        private String typeValue;

        private SendWayEnum (Integer typeCode , String typeValue) {
            this.typeCode = typeCode;
            this.typeValue = typeValue;
        }

        public Integer getTypeCode () { return this.getTypeCode(); }

        public static Integer getTypeCode (Integer index) {
            for (SendWayEnum wayEnum : SendWayEnum.values()) {
                if (wayEnum.getTypeCode().equals(index)) {
                    return wayEnum.typeCode;
                }
            }
            return null;
        }

        public static String getTypeValue (Integer index) {
            for (SendWayEnum wayEnum : SendWayEnum.values()) {
                if (wayEnum.getTypeCode().equals(index)) {
                    return wayEnum.typeValue;
                }
            }
            return null;
        }

    }

    // 系统通知信息 消息类型
    public enum MsgType {
        ACTIVITY("A","活动"),
        REMIND("R" , "提醒"),
        NOTICE("N" , "公告"),
        IMPORTANT_NEWS("X" , "要闻"),
        BROADCAST("B" , "播报");

        private String typeCode;
        private String typeValue;

        private MsgType (String typeCode , String typeValue) {
            this.typeCode = typeCode;
            this.typeValue = typeValue;
        }

        public String getTypeCode() {
            return typeCode;
        }

        public void setTypeCode(String typeCode) {
            this.typeCode = typeCode;
        }

        public String getTypeValue() {
            return typeValue;
        }

        public void setTypeValue(String typeValue) {
            this.typeValue = typeValue;
        }
    }

    // 系统通知信息 消息级别
    public enum MsgLevelEnum {
        IMPORTANCE("I" , "重要"),
        BENERAL("G" , "普通");

        private String typeCode;
        private String typeValue;

        private MsgLevelEnum (String typeCode , String typeValue) {
            this.typeCode = typeCode;
            this.typeValue = typeValue;
        }

        public String getTypeCode() {
            return typeCode;
        }

        public void setTypeCode(String typeCode) {
            this.typeCode = typeCode;
        }

        public String getTypeValue() {
            return typeValue;
        }

        public void setTypeValue(String typeValue) {
            this.typeValue = typeValue;
        }
    }

//    // 系统通知信息 客户端类型
//    public enums ClientTypeEnum {
//        ALL(-1 , "全部终端"),
//        ANDROID(1 , "安卓"),
//        IOS(0 , "苹果");
//
//        private Integer typeCode;
//        private String typeValue;
//
//        private ClientTypeEnum (Integer typeCode , String typeValue) {
//            this.typeCode = typeCode;
//            this.typeValue = typeValue;
//        }
//
//        public Integer getTypeCode() {
//            return typeCode;
//        }
//
//        public void setTypeCode(Integer typeCode) {
//            this.typeCode = typeCode;
//        }
//
//        public String getTypeValue() {
//            return typeValue;
//        }
//
//        public void setTypeValue(String typeValue) {
//            this.typeValue = typeValue;
//        }
//    }

    // 系统通知消息 消息分组
    public enum MsgGroupEnum {
        PERSON("P" , "个人"),
        ALL("A" , "全站"),
        LABEL("L" , "标签用户"),
        TEAM("T" , "用户分组");

        private String typeCode;
        private String typeValue;

        private MsgGroupEnum (String typeCode , String typeValue) {
            this.typeCode = typeCode;
            this.typeValue = typeValue;
        }

        public String getTypeCode() {
            return typeCode;
        }

        public void setTypeCode(String typeCode) {
            this.typeCode = typeCode;
        }

        public String getTypeValue() {
            return typeValue;
        }

        public void setTypeValue(String typeValue) {
            this.typeValue = typeValue;
        }
    }

    // 短信通知  用户类型
    public enum UserTypeEnum {
        ALL(0,"全部用户"),
        TD_USER(1,"特定用户"),
        IMPORT_USER(2,"导入用户");

        private Integer typeCode;
        private String typeValue;

        private UserTypeEnum (Integer typeCode , String typeValue) {
            this.typeCode = typeCode;
            this.typeValue = typeValue;
        }

        public Integer getTypeCode() {
            return typeCode;
        }

        public void setTypeCode(Integer typeCode) {
            this.typeCode = typeCode;
        }

        public String getTypeValue() {
            return typeValue;
        }

        public void setTypeValue(String typeValue) {
            this.typeValue = typeValue;
        }
    }

    // 系统通知信息 推送类型
    public enum SendTypeEnum {
        STRONG(0 , "强消息"),
        WEAK(1 , "弱消息");

        private Integer typeCode;
        private String typeValue;

        private SendTypeEnum (Integer typeCode , String typeValue) {
            this.typeCode = typeCode;
            this.typeValue = typeValue;
        }

        public Integer getTypeCode() {
            return typeCode;
        }

        public void setTypeCode(Integer typeCode) {
            this.typeCode = typeCode;
        }

        public String getTypeValue() {
            return typeValue;
        }

        public void setTypeValue(String typeValue) {
            this.typeValue = typeValue;
        }
    }

    public enum SendWayTimeEnum {
        FORTHWITH(0 , "即时"),
        TIMING(1 , "定时");

        private Integer typeCode;
        private String  typeValue;

        private SendWayTimeEnum (Integer typeCode , String typeValue) {
            this.typeCode = typeCode;
            this.typeValue = typeValue;
        }

        public Integer getTypeCode() {
            return typeCode;
        }

        public void setTypeCode(Integer typeCode) {
            this.typeCode = typeCode;
        }

        public String getTypeValue() {
            return typeValue;
        }

        public void setTypeValue(String typeValue) {
            this.typeValue = typeValue;
        }
    }

    // 消息发送通用状态
    public enum SendStatusEnum {
        NO_SEND(0 , "未发送"),
        SUCCESS_SEND(1 , "发送成功"),
        FAIL_SEND(2 , "发送失败"),
        DO_SEND(3 , "已发送");

        private Integer typeCode;
        private String typeValue;

        private SendStatusEnum (Integer typeCode , String typeValue) {
            this.typeCode = typeCode;
            this.typeValue = typeValue;
        }

        public Integer getTypeCode() {
            return typeCode;
        }

        public void setTypeCode(Integer typeCode) {
            this.typeCode = typeCode;
        }

        public String getTypeValue() {
            return typeValue;
        }

        public void setTypeValue(String typeValue) {
            this.typeValue = typeValue;
        }
    }

    // 短信渠道
    public enum ChannelEnum {
        JF(1 , "玖富");

        private Integer typeCode;
        private String typeValue;

        private ChannelEnum (Integer typeCode , String typeValue) {
            this.typeCode = typeCode;
            this.typeValue = typeValue;
        }

        public Integer getTypeCode() {
            return typeCode;
        }

        public void setTypeCode(Integer typeCode) {
            this.typeCode = typeCode;
        }

        public String getTypeValue() {
            return typeValue;
        }

        public void setTypeValue(String typeValue) {
            this.typeValue = typeValue;
        }
    }

    public enum CodeToBusEnum {
        REGISTER_SUCCESS(1000 , "注册成功未开户"),
        COMMIT_OPEN_INFO(1001 , "提交开户资料"),
        OPEN_SUCCESS(1002 , "开户成功"),
        OPEN_FAIL(1003 , "开户失败"),
        COMMIT_SECACCOUNT(1004 , "子账户申请发起"),
        SECACCOUNT_SUCCESS(1005 , "子账户申请成功"),
        SHIFT_ACCEPT(1006 , "转入受理"),
        SHIFT_SUCCESS(1007 , "转入成功"),
        NO_LOAD(1008 , "免佣(通知)"),
        NO_LOAD_EXPIRE(1009 , "免佣到期(无入金客户)"),
        GRANT(1010 , "发放"),
        BIRTHDAY(1011 , "生日"),
        HOLIDAYS(1012 , "节假日"),
        ANNIVERSARY(1013 , "周年纪念日"),
        STOP_BUS(1014 , "休市"),
        LEVEL2_EXPIRE(1015 , "level2行情到期"),
        GETCASH_ACCEPT(1016 , "提取资金受理"),
        GETCASH_SUCCESS(1017 , "提出资金成功"),
        OUT_ACCEPT(1018 , "转出受理"),
        OUT_SUCCESS(1019 , "转出成功"),
        INTCASH_SUCCESS(1020 , "存入资金成功"),
        INTCASH_ACCEPT(1021 , "存入资金发起"),
        PRICE_UP_INFORM(1022 , "上涨提醒"),
        CHANGE_UP_INFORM(1023 , "涨幅提醒"),
        PRICE_DOWN_INFORM(1024 , "下跌提醒"),
        CHANGE_DOWN_INFORM(1025 , "跌幅提醒"),
        ADD_FRIEND_APPLY(1026 , "添加好友"),
        ADD_FRIEND_SUCCESS(1027 , "添加好友成功"),
        FRIEND_REGISTER(1028 , "好友注册"),
        FRIEND_OPEN_ACCOUNT(1029 , "好友开户"),
        HAS_LOAD_EXPIRE(1030 , "免佣到期(入金用户)"),
        US_ACCOUNT_SUCCESS(1031 , "美股开户成功"),
        US_ACCOUNT_FAIL(1032 , "美股开户失败"),
        HC_SUCCESS(1033 , "换汇成功"),
        HC_FAIL(1034 , "换汇失败"),
        OPEN_DERI_SUCCESS(1035 , "衍生品权限开通成功"),
        OPEN_DERI_FAIL(1036 , "衍生品权限开通失败"),
    	USER_DOUBLE_VERIFY_SUCCESS(1037,"您刚刚授权{0}为受信设备，此后在此设备登录不需再进行双重身份认证。当连续7日内未在此设备上登录，信任关系将被解除。如以上非您本人操作，请联系客服中心：400-810-8818转3。"),
        USGRANT(1038 , "美股发放"),
        BROKER_REG_CAPTCHA(1039 , "犇犇经理人手机验证码");
        private Integer typeCode;
        private String typeValue;

        private CodeToBusEnum (Integer typeCode , String typeValue) {
            this.typeCode = typeCode;
            this.typeValue = typeValue;
        }

        public Integer getTypeCode() {
            return typeCode;
        }

        public void setTypeCode(Integer typeCode) {
            this.typeCode = typeCode;
        }

        public String getTypeValue() {
            return typeValue;
        }

        public void setTypeValue(String typeValue) {
            this.typeValue = typeValue;
        }

    }

    public static void main(String[] args) {
        Integer typeCode = BusTypeEnum.getTypeCode(1);
        System.out.println(typeCode);

        System.out.println(BusTypeEnum.getTypeValue(2));

        System.out.println(MsgType.ACTIVITY.getTypeCode());
    }
}
