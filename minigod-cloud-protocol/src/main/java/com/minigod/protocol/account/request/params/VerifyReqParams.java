package com.minigod.protocol.account.request.params;

import com.minigod.common.pojo.request.BaseRequestParams;
import lombok.Data;

import java.io.Serializable;

@Data
public class VerifyReqParams extends BaseRequestParams implements Serializable {
    private static final long serialVersionUID = 1L;

    private String userName; // 用户名
    private String idCard; // 身份证号
    private String bankCard; // 银行卡号
    private String phone;// 手机号码
    private String email;
}
