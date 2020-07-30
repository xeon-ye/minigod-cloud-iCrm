package com.minigod.account.service;

import com.minigod.protocol.account.request.params.VerifyReqParams;
import com.minigod.protocol.account.response.VerifyResVo;

//import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

//@FeignClient(value = "minigod-account-service")
public interface VerifyService {
    // 手机号是否使用
    @PostMapping("/is_phone_used")
    public Boolean isPhoneUsed(String phone);

    // 邮箱是否使用
    @PostMapping("/is_email_used")
    public Boolean isEmailUsed(String email);

    // 身份证是否使用
    @PostMapping("/is_id_card_used")
    public Boolean isIdCardUsed(String idCard);

    // 身份证是否认证
    @PostMapping("/is_id_card_valid")
    public Boolean isIdCardValid(String idCard, String userName);

    // 银行卡是否认证
    @PostMapping("/is_bank_card_valid")
    public Boolean isBankCardValid(String idCard, String userName, String bankCard);

    // 邮箱校验
    @PostMapping("/verify_phone")
    public VerifyResVo verifyPhone(VerifyReqParams phoneReqParams);

    // 邮箱校验
    @PostMapping("/verify_email")
    public VerifyResVo verifyEmail(VerifyReqParams emailReqParams);

    // 身份证校验
    @PostMapping("/verify_id_card")
    public VerifyResVo verifyIdCard(VerifyReqParams idCardReqParams);

    // 银行卡四要素校验
    @PostMapping("/verify_bank_card_4e")
    public VerifyResVo verifyBankCard4E(VerifyReqParams bankCardReqParams);

    // 静态活体检验
    @PostMapping("/verify_live_face")
    VerifyResVo verifyLiveFace(VerifyReqParams params, Integer userId);
}
