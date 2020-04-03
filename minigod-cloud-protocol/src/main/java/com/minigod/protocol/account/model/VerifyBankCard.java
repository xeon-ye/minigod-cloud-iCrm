package com.minigod.protocol.account.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VerifyBankCard implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 身份证
     */
    private String idCard;

    /**
     * 银行卡号
     */
    private String bankCard;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 状态(-1: 未校验，0:不通过 1:通过)
     */
    private Integer status;

    private String remark;

    /**
     * 验证次数
     */
    private Integer checkCount;

    /**
     * 验证时间
     */
    private Date checkDate;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后修改时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}