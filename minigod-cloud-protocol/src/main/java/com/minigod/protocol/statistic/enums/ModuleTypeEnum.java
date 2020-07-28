package com.minigod.protocol.statistic.enums;

import lombok.Getter;

@Getter
public enum ModuleTypeEnum {
    OCR("人脸识别", "OCR"),
    CA("深圳CA", "CA"),
    SMS("短信", "SMS"),
    EMAIL("邮件", "EMAIL");
    private String name;
    private String type;

    ModuleTypeEnum(String name, String type) {
        this.name = name;
        this.type = type;
    }
}
