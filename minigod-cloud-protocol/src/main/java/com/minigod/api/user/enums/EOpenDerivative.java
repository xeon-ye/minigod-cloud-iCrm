package com.minigod.api.user.enums;

/**
 * @Author: PENGFENG
 * @Description:
 * @Date: Created in 17:19 2017/10/16
 * @Modified By:
 */
public enum  EOpenDerivative {

    NO_DREDGE(0,"未开通"),
    CHECKING(1,"审核中"),
    DREDGE(2,"已开通"),
    FAIL_DREDGE(3,"开通失败");

    private Integer typeCode;
    private String typeValue;

    private EOpenDerivative (Integer typeCode , String typeValue) {
        this.typeCode = typeCode;
        this.typeValue = typeValue;
    }

    private Integer getTypeCode () { return this.typeCode; }

    public static Integer getTypeCode (Integer index) {
        for (EOpenDerivative typeEnum : EOpenDerivative.values()) {
            if (typeEnum.getTypeCode().equals(index)) {
                return typeEnum.typeCode;
            }
        }
        return null;
    }

    public static String getTypeValue(Integer index) {
        for (EOpenDerivative typeEnum : EOpenDerivative.values()) {
            if (typeEnum.getTypeCode().equals(index)) {
                return typeEnum.typeValue;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(EOpenDerivative.getTypeValue(0));
    }
}
