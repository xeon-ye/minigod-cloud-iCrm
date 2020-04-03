package com.minigod.protocol.account.model;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomOpenBackErrorMap implements Serializable {
    /**
    * 配置id（自增主键）
    */
    private Long id;

    /**
    * 手机号码
    */
    private Integer code;

    /**
    * 对应语言配置config_key
    */
    private String configKey;

    private static final long serialVersionUID = 1L;
}