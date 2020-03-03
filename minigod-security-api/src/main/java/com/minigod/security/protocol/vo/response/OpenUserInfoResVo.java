package com.minigod.security.protocol.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OpenUserInfoResVo implements Serializable {
    private static final long serialVersionUID = 3357785549669365930L;

    private String phone;
    private String email;

//    private String bankCard; // 银行卡号
//    private String idCard; // 身份证号码

    private Integer openType; //开户方式：0:未知，1:线上内地开户，2:线下（开户宝）, 3:线上香港开户
    private Integer openStatus; //开户状态
    //    private String openStatusDesc; //开户状态描述
    private Integer pendType; //审核状态
    private Integer failType; //失败状态
    private String openResult; //开户结果

    private Integer accountType; // 账户类型 1：现金账户 2：融资账户
    private ArrayList<Integer> accountMarkets; // 账户类型：1：港股 2：美股 3：中华通
    private Date openDate; // 开户日期
    private String tradeAccount; // 客户号（交易帐号）
    private String fundAccount; // 资金账号
}
