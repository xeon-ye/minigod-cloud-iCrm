package com.minigod.protocol.account.enums;

import lombok.Getter;

import java.util.ArrayList;

public final class CustomOpenAccountEnum {
    @Getter
    public enum OpenType {
        ONLINE_CN(1, "线上内地开户"),
        ONLINE_HK(2, "线上香港开户"),
        OFFLINE(3, "线下（开户宝）");

        private Integer code;
        private String message;

        private OpenType(Integer code, String message) {
            this.code = code;
            this.message = message;
        }

        public static OpenType getType(Integer code) {
            for (OpenType c : OpenType.values()) {
                if (c.getCode().equals(code)) {
                    return c;
                }
            }
            return null;
        }

        public static boolean isContainCertType(Integer code) {
            boolean bool = false;
            for (OpenType way : OpenType.values()) {
                if (code.equals(way.getCode())) {
                    bool = true;
                }
            }
            return bool;
        }
    }

    @Getter
    public enum OpenAccessWay {
        H5(1, "H5开户"),
        APP(2, "APP开户");

        private Integer code;
        private String message;

        private OpenAccessWay(Integer code, String message) {
            this.code = code;
            this.message = message;
        }

        public static OpenAccessWay getWay(Integer code) {
            for (OpenAccessWay c : OpenAccessWay.values()) {
                if (c.getCode().equals(code)) {
                    return c;
                }
            }
            return null;
        }

        public static boolean isContainCertType(Integer code) {
            boolean bool = false;
            for (OpenAccessWay way : OpenAccessWay.values()) {
                if (code.equals(way.getCode())) {
                    bool = true;
                }
            }
            return bool;
        }
    }

    @Getter
    public enum FundAccountType {
        CASH(1, "现金账户"),
        MARGIN(2, "融资账户");

        private Integer code;
        private String message;

        private FundAccountType(Integer code, String message) {
            this.code = code;
            this.message = message;
        }

        public static FundAccountType getType(Integer code) {
            for (FundAccountType c : FundAccountType.values()) {
                if (c.getCode().equals(code)) {
                    return c;
                }
            }
            return null;
        }

        public static boolean isContainCertType(Integer code) {
            boolean bool = false;
            for (FundAccountType way : FundAccountType.values()) {
                if (code.equals(way.getCode())) {
                    bool = true;
                }
            }
            return bool;
        }
    }

    @Getter
    public enum OpenAccountMarket {
        HK_TRADE(1, "港股交易"),
        US_TRADE(2, "美股交易"),
        NORTH_TRADE(3, "中华通交易");

        private Integer code;
        private String message;

        private OpenAccountMarket(Integer code, String message) {
            this.code = code;
            this.message = message;
        }

        public static Integer getFlag(ArrayList<Integer> codes, OpenAccountMarket market) {
            Integer bool = 0;
            for (FundAccountType way : FundAccountType.values()) {
                if (codes.contains(market.getCode())) {
                    bool = 1;
                }
            }
            return bool;
        }
    }

    @Getter
    public enum OpenStatus {
        UN_START(-1, "未开始", true),
        UN_SUBMIT(0, "未提交", true),
        PENDING(1, "开户中", false),
        CANCELED(2, "开户已取消", true),
        SUCCESS(3, "开户成功", false),
        FAILED(4, "开户失败", true),
        ACCOUNT_OFF(5, "销户", true),
        ACCOUNT_ABO(6, "账户异常", false);

        private Integer code;
        private String message;
        private Boolean isSubmit;

        private OpenStatus(Integer code, String message, Boolean isSubmit) {
            this.code = code;
            this.message = message;
            this.isSubmit = isSubmit;
        }


        public static OpenStatus getStatus(Integer code) {
            for (OpenStatus c : OpenStatus.values()) {
                if (c.getCode().equals(code)) {
                    return c;
                }
            }
            return OpenStatus.UN_START;
        }
    }

    // 开户失败状态
    @Getter
    public enum FailStatusType {
        UN_KNOW(-1, "未知"),
        ERROR_OTHER(0, "其他错误"),
        ERROR_INFO(1, "基本数据错误"),
        ERROR_PIC(2, "影像数据错误"),
        ERROR_INFO_PIC(3, "基本或影像数据错误"),
        ERROR_CA(4, "CA数据错误");

        private Integer code;
        private String message;

        private FailStatusType(Integer code, String message) {
            this.code = code;
            this.message = message;
        }

        public static FailStatusType getType(Integer code) {
            for (FailStatusType c : FailStatusType.values()) {
                if (c.getCode().equals(code)) {
                    return c;
                }
            }
            return FailStatusType.UN_KNOW;
        }

    }


    // 开户中状态
    @Getter
    public enum PendingStatusType {
        UN_KNOW(-1, "未知"),
        DOING(0, "预批中"),
        APPROVE(1, "审批中"),
        CA(2, "CA认证中"),
        OPEN(3, "柜台开户中");

        private Integer code;
        private String message;

        private PendingStatusType(Integer code, String message) {
            this.code = code;
            this.message = message;
        }

        public static PendingStatusType getType(Integer code) {
            for (PendingStatusType c : PendingStatusType.values()) {
                if (c.getCode().equals(code)) {
                    return c;
                }
            }
            return PendingStatusType.UN_KNOW;
        }
    }

    @Getter
    public enum CaStatus {
        //        CA认证状态， 0:无，1:需要认证，2:认证完成（待推送），3:已推送
        NONE(0, "无"),
        IS_NEED_VERIFY(1, "需要认证"),
        IS_NEED_PUSH(2, "认证完成（待推送）"),
        IS_PUSHED(3, "已推送");

        private Integer code;
        private String message;

        private CaStatus(Integer code, String message) {
            this.code = code;
            this.message = message;
        }


        public static CaStatus getStatus(Integer code) {
            for (CaStatus c : CaStatus.values()) {
                if (c.getCode().equals(code)) {
                    return c;
                }
            }
            return CaStatus.NONE;
        }
    }

}
