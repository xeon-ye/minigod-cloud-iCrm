package com.minigod.protocol.account.enums;

import lombok.Getter;

public final class CustomOpenAccountEnum {
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
    public enum OpenType {
        ONLINE_CN(1, "线上内地开户"),
        OFFLINE(2, "线下（开户宝）"),
        ONLINE_HK(3, "线上香港开户");

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


}
