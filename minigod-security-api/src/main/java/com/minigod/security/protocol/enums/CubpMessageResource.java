package com.minigod.security.protocol.enums;

public class CubpMessageResource {
    public static final String FAIL_FETCH_CAPTCHA = "FAIL_FETCH_CAPTCHA"; // 获取验证码失败
    public static final String FETCH_SMS_CAPTCHA_OFTEN = "FETCH_SMS_CAPTCHA_OFTEN"; // 获取验证码过于频繁
    public static final String FETCH_EMAIL_CAPTCHA_OFTEN = "FETCH_EMAIL_CAPTCHA_OFTEN"; // 获取验证码过于频繁
    public static final String FAIL_LOGIN = "FAIL_LOGIN"; //登录失败
    public static final String NO_USER = "NO_USER"; //用户不存在
    public static final String BAD_ACCOUNT_OR_PWD = "BAD_ACCOUNT_OR_PWD"; //账号或密码错误
    public static final String BAD_OR_EXPIRE_CAPTCHA  = "BAD_OR_EXPIRE_CAPTCHA "; //验证码错误或已失效


    // 手机号校验
    public static final String BAD_FORMAT_PHONE = "BAD_FORMAT_PHONE"; // 手机号格式错误
    public static final String PHONE_IS_USED = "PHONE_IS_USED"; // 手机号已使用
    public static final String FAIL_VERIFY_PHONE = "FAIL_VERIFY_PHONE"; // 邮箱校验失败

    // 邮箱校验
    public static final String BAD_FORMAT_EMAIL = "BAD_FORMAT_EMAIL"; // 邮箱格式错误
    public static final String EMAIL_IS_USED = "EMAIL_IS_USED"; // 邮箱已使用
    public static final String FAIL_VERIFY_EMAIL = "FAIL_VERIFY_EMAIL"; // 邮箱校验失败

    // 身份证校验
    public static final String BAD_FORMAT_ID_CARD = "BAD_FORMAT_ID_CARD";// 身份证格式错误
    public static final String ID_CARD_USED_OR_UNSUPPORT = "ID_CARD_USED_OR_UNSUPPORT"; // 身份证已使用或不支持
    public static final String FAIL_VERIFY_ID_CARD = "FAIL_VERIFY_ID_CARD";// 身份证校验失败
    public static final String FAIL_VERIFY_ID_CARD_COUNT = "FAIL_VERIFY_ID_CARD_COUNT";// 身份证校验每日次数上限

    public static final String FAIL_OCR = "FAIL_OCR"; // 身份证/银行卡识别失败

    // 银行卡校验
    public static final String BAD_FORMAT_BANK_CARD = "BAD_FORMAT_BANK_CARD";//银行卡格式错误
    public static final String BANK_CARD_USED_OR_UNSUPPORT = "BANK_CARD_USED_OR_UNSUPPORT"; // 银行卡已使用或不支持
    public static final String FAIL_VERIFY_BANK_CARD = "FAIL_VERIFY_BANK_CARD";// 银行卡校验失败
    public static final String FAIL_VERIFY_BANK_CARD_COUNT = "FAIL_VERIFY_BANK_CARD_COUNT";// 银行卡校验每日次数上限

    // 缓存数据
    public static final String FAIL_SAVE_CACHE_INFO = "FAIL_SAVE_CACHE_INFO"; // 保存缓存信息异常
    public static final String FAIL_SAVE_CACHE_IMG = "FAIL_SAVE_CACHE_IMG"; // 保存图片异常
    public static final String FAIL_GET_CACHE_DATA = "FAIL_GET_CACHE_DATA"; // 获取缓存数据异常

    // 提交数据
    public static final String FAIL_SUBMIT_OPEN_INFO = "FAIL_SUBMIT_OPEN_INFO"; //
    public static final String NO_SUBMIT_OPEN_INFO_REPEAT = "NO_SUBMIT_OPEN_INFO_REPEAT"; //
    public static final String ABO_ACCOUNT = "ABO_ACCOUNT"; //


}
