package com.minigod.security.service;

import com.minigod.security.protocol.vo.request.params.VerifyReqParams;
import com.minigod.security.protocol.vo.response.VerifyResVo;
import org.json.JSONObject;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "minigod-security-service")
public interface VerifyService {
    // 手机号是否使用
    @PostMapping("/is_phone_used")
    public Boolean isPhoneUsed(String phone);

    // 邮箱是否使用
    @PostMapping("/is_email_used")
    public Boolean isEmailUsed(String email);

    // 邮箱是否使用
    @PostMapping("/is_id_card_used")
    public Boolean isIdCardUsed(String idCard);

    // 邮箱校验
    @PostMapping("/verify_phone")
    public VerifyResVo verifyPhone(VerifyReqParams idCardReqParams);

    // 邮箱校验
    @PostMapping("/verify_email")
    public VerifyResVo verifyEmail(VerifyReqParams idCardReqParams);

    // 身份证校验
    @PostMapping("/verify_id_card")
    public VerifyResVo verifyIdCard(VerifyReqParams idCardReqParams);


    // 银行卡四要素校验
    @PostMapping("/verify_bank_card_4e")
    public VerifyResVo verifyBankCard4E(VerifyReqParams bankCardReqParams);

}
