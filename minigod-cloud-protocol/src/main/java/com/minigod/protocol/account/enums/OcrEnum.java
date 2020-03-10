package com.minigod.protocol.account.enums;

import lombok.Getter;

public final class OcrEnum {
    @Getter
    public enum IdCardSide {
        FRONT(1, "FRONT"),
        BACK(2, "BACK");


        private Integer code;
        private String value;

        private IdCardSide(Integer code, String value) {
            this.code = code;
            this.value = value;
        }

        public static IdCardSide getData(Integer code) {
            for (IdCardSide data : IdCardSide.values()) {
                if (code.equals(data.getCode())) {
                    return data;
                }
            }
            return null;
        }
    }

    ;

    // 护照类型 1 CN | 2 HK | 3 GENERAL | 4 THAI
    @Getter
    public enum PassportType {
        CN(1, "CN"),
        HK(2, "HK"),
        GENERAL(3, "GENERAL"),
        THAI(4, "THAI");


        private Integer code;
        private String value;

        private PassportType(Integer code, String value) {
            this.code = code;
            this.value = value;
        }

        public static PassportType getData(Integer code) {
            for (PassportType data : PassportType.values()) {
                if (code.equals(data.getCode())) {
                    return data;
                }
            }
            return null;
        }
    }

    ;

    @Getter
    public enum CardType {
        BankCardOCR(1, "银行卡"),
        IdCardOCR(2, "身份证"),
        PermitOCR(3, "港澳通行证"),
        PassportOCR(4, "护照");

        private Integer code;
        private String message;

        private CardType(Integer code, String message) {
            this.code = code;
            this.message = message;
        }

        public static boolean isContainCertType(Integer code) {
            boolean bool = false;
            for (CardType type : CardType.values()) {
                if (code.equals(type.getCode())) {
                    bool = true;
                }
            }
            return bool;
        }
    }

    @Getter
    public enum ImageLocation {
        BankCard("2", "201", "银行卡"),
        IdCardFront("1", "101", "身份证正面"),
        IdCardBack("1", "102", "身份证反面"),
        Permit("1", "103", "港澳通行证"),
        Passport("1", "104", "护照");

        private String locationKey;
        private String locationType;
        private String message;

        private ImageLocation(String locationKey, String locationType, String message) {
            this.locationKey = locationKey;
            this.locationType = locationType;
            this.message = message;
        }
    }

}
