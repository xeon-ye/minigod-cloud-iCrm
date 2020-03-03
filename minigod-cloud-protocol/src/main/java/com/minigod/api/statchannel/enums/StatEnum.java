package com.minigod.api.statchannel.enums;

import com.minigod.api.inform.enums.InformEnum;

public class StatEnum {

    // 模板类型业务类型
    public enum TypeEnum {
        Register(1,"注册"),
        Open(2,"开户"),
        Deposit(3,"入金");

        private Integer typeCode;
        private String typeValue;

        private TypeEnum (Integer typeCode , String typeValue) {
            this.typeCode = typeCode;
            this.typeValue = typeValue;
        }

        public Integer getTypeCode () {
            return this.typeCode;
        }

        public static Integer getTypeCode (Integer index) {
            for (StatEnum.TypeEnum typeEnum : StatEnum.TypeEnum.values()) {
                if (typeEnum.getTypeCode().equals(index)) {
                    return typeEnum.typeCode;
                }
            }
            return null;
        }

        public static String getTypeValue(Integer index) {
            for (StatEnum.TypeEnum typeEnum : StatEnum.TypeEnum.values()) {
                if (typeEnum.getTypeCode().equals(index)) {
                    return typeEnum.typeValue;
                }
            }
            return null;
        }
    }


    public static void main(String[] args) {
        Integer typeCode = StatEnum.TypeEnum.getTypeCode(1);
        System.out.println(typeCode);

        System.out.println(StatEnum.TypeEnum.getTypeValue(2));

        System.out.println(StatEnum.TypeEnum.Register.getTypeCode());
    }
}
