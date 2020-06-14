package com.minigod.common.pojo;

import java.util.HashMap;
import java.util.Map;

/**
 * 公共的静态类型
 */

public class StaticType {

    public static class StatusValid {
        public static final int VALID = 1;// 有效的
        public static final int IN_VALID = 0;// 无效的
        public static final int DEL_VALID = -1;// 删除的
    }

    /**
     * <code>TaskStatus<code> 任务的状态。
     */
    public static enum JobStatus {
        N, // 待运行
        R, // 运行中
        Y, // 运行完成
        F, // 运行失败
    }

    private static final Map<Integer, CodeType> map = new HashMap<Integer, CodeType>();

    //公共模块相关
    public enum CodeType {
        OK(0, "调用成功"),
        ERROR_UNKNOWN(-1, "未知错误"),
        BAD_REQUEST(400, "错误的请求"),
        BAD_ARGS(401, "参数错误"),
        BAD_PARAMS(402, "params参数错误"),
        BAD_PARAM_SIGN(403, "签名参数SIGN错误"),
        BAD_SOCKET(404, "网络异常"),
        BAD_PARAM_KEY(405, "签名参数KEY错误"),
        BAD_PARAM_SESSION(406, "参数SESSION_ID错误"),
        BAD_PROXY_SECRET(407, "参数SECRET错误"),
        BAD_PROXY_AUTH_CODE(408, "参数AUTH_CODE错误"),
        ERROR_INTERNAL(500, "请求异常,请重试"),
        NONE_DATA(501, "无满足条件的数据"),
        EXIST_DATA(502, "有重复值存在"),
        SERVICE_UN_SUPPORT(503, "业务不支持"),
        ERROR_SIGN(504, "签名错误"),
        DISPLAY_ERROR(888, "系统异常"), // 前端直接给用户显示的错误信息
        SESSION_INVALID(-9999, "未登录或者session已失效");

        private int code;
        private String message;

        private CodeType(int code, String message) {
            this.code = code;
            this.message = message;
            map.put(code, this);
        }

        public int getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }

        public static final String getMessage(int code) {
            CodeType _code = map.get(code);
            if (_code == null) {
                return ERROR_UNKNOWN.getMessage();
            }
            return _code.getMessage();
        }
    }

    public static class MessageResource {
        // 公共参数
        public static final String OK = "OK";
        public static final String ERROR_UNKNOWN = "ERROR_UNKNOWN";
        public static final String REMOTE_CONNECT_ERROR = "REMOTE_CONNECT_ERROR";
        public static final String REMOTE_REQUEST_ERROR = "REMOTE_REQUEST_ERROR";
        public static final String BAD_REQUEST = "BAD_REQUEST";
        public static final String BAD_ARGS = "BAD_ARGS";
        public static final String BAD_PARAMS = "BAD_PARAMS";
        public static final String BAD_PARAM_SIGN = "BAD_PARAM_SIGN";
        public static final String BAD_SOCKET = "BAD_SOCKET";
        public static final String BAD_PARAM_KEY = "BAD_PARAM_KEY";
        public static final String BAD_PARAM_SESSION = "BAD_PARAM_SESSION";
        public static final String BAD_PROXY_SECRET = "BAD_PROXY_SECRET";
        public static final String BAD_PROXY_AUTH_CODE = "BAD_PROXY_AUTH_CODE";
        public static final String ERROR_INTERNAL = "ERROR_INTERNAL";
        public static final String NONE_DATA = "NONE_DATA";
        public static final String EXIST_DATA = "EXIST_DATA";
        public static final String SERVICE_UN_SUPPORT = "SERVICE_UN_SUPPORT";
        public static final String ERROR_SIGN = "ERROR_SIGN";
        public static final String SESSION_INVALID = "SESSION_INVALID";

        // 格式校验
        public static final String BAD_FORMAT_PHONE = "BAD_FORMAT_PHONE"; // 手机号格式错误
        public static final String BAD_FORMAT_EMAIL = "BAD_FORMAT_EMAIL"; // 邮箱格式错误
        public static final String BAD_FORMAT_ID_CARD = "BAD_FORMAT_ID_CARD";// 身份证格式错误
        public static final String BAD_FORMAT_BANK_CARD = "BAD_FORMAT_BANK_CARD";//银行卡格式错误

        // 验证码相关
        public static final String FAIL_FETCH_CAPTCHA = "FAIL_FETCH_CAPTCHA"; // 获取验证码失败
        public static final String FETCH_SMS_CAPTCHA_OFTEN = "FETCH_SMS_CAPTCHA_OFTEN"; // 获取验证码过于频繁
        public static final String FETCH_EMAIL_CAPTCHA_OFTEN = "FETCH_EMAIL_CAPTCHA_OFTEN"; // 获取验证码过于频繁
        public static final String IS_USED_CAPTCHA = "IS_USED_CAPTCHA"; // 验证码已使用
        public static final String IS_OVET_TIMES_CAPTCHA = "IS_OVET_TIMES_CAPTCHA"; //验证码已使用

        // 登录
        public static final String FAIL_LOGIN = "FAIL_LOGIN"; //登录失败
        public static final String FAIL_LOGIN_BY_OTHER = "FAIL_LOGIN_BY_OTHER"; // 登录失败
        public static final String NO_USER = "NO_USER"; // 用户不存在
        public static final String BAD_ACCOUNT_OR_PWD = "BAD_ACCOUNT_OR_PWD"; // 账号或密码错误
        public static final String BAD_OR_EXPIRE_CAPTCHA = "BAD_OR_EXPIRE_CAPTCHA"; // 验证码错误或已失效

        // 手机号校验
        public static final String PHONE_IS_USED = "PHONE_IS_USED"; // 手机号已使用
        public static final String FAIL_VERIFY_PHONE = "FAIL_VERIFY_PHONE"; // 邮箱校验失败

        // 邮箱校验
        public static final String EMAIL_IS_USED = "EMAIL_IS_USED"; // 邮箱已使用
        public static final String FAIL_VERIFY_EMAIL = "FAIL_VERIFY_EMAIL"; // 邮箱校验失败

        // 身份证校验
        public static final String ID_CARD_USED_OR_UNSUPPORT = "ID_CARD_USED_OR_UNSUPPORT"; // 身份证已使用或不支持
        public static final String ID_CARD_AGE_LESS_18 = "ID_CARD_AGE_LESS_18"; // 未满18周岁不可开通股票账户
        public static final String FAIL_VERIFY_ID_CARD = "FAIL_VERIFY_ID_CARD";// 身份证校验失败
        public static final String FAIL_VERIFY_ID_CARD_COUNT = "FAIL_VERIFY_ID_CARD_COUNT";// 身份证校验每日次数上限

        // OCR识别
        public static final String FAIL_OCR = "FAIL_OCR"; // 身份证/银行卡识别失败

        // 获取开户进度
        public static final String FAIL_OPEN_PROGRESS = "FAIL_OPEN_PROGRESS"; // 开户进度

        // 银行卡校验
        public static final String BANK_CARD_USED_OR_UNSUPPORT = "BANK_CARD_USED_OR_UNSUPPORT"; // 银行卡已使用或不支持
        public static final String FAIL_VERIFY_BANK_CARD = "FAIL_VERIFY_BANK_CARD";// 银行卡校验失败
        public static final String FAIL_VERIFY_BANK_CARD_COUNT = "FAIL_VERIFY_BANK_CARD_COUNT";// 银行卡校验每日次数上限


        // 活体校验次数
        public static final String FAIL_VERIFY_LIVE_FACE = "FAIL_VERIFY_LIVE_FACE";//  活体校验失败
        public static final String FAIL_VERIFY_LIVE_FACE_COUNT = "FAIL_VERIFY_LIVE_FACE_COUNT";//  活体校验每日次数上限

        // SZCA校验
        public static final String FAIL_VERIFY_SZCA = "FAIL_VERIFY_SZCA";// SZCA校验失败
        public static final String FAIL_VERIFY_SZCA_COUNT = "FAIL_VERIFY_SZCA_COUNT";// SZCA校验每日次数上限

        // 缓存数据
        public static final String FAIL_SAVE_CACHE_INFO = "FAIL_SAVE_CACHE_INFO"; // 保存缓存信息异常
        public static final String FAIL_SAVE_CACHE_IMG = "FAIL_SAVE_CACHE_IMG"; // 保存图片异常
        public static final String FAIL_GET_CACHE_DATA = "FAIL_GET_CACHE_DATA"; // 获取缓存数据异常

        // 提交数据
        public static final String FAIL_SUBMIT_OPEN_INFO = "FAIL_SUBMIT_OPEN_INFO"; // 提交开户数据异常
        public static final String NO_SUBMIT_OPEN_INFO_REPEAT = "NO_SUBMIT_OPEN_INFO_REPEAT"; // 不可重复提交
        public static final String MISSING_IMAGES = "MISSING_IMAGES"; // 影像资源不完整
        public static final String MISSING_DATAS = "MISSING_DATAS "; // 资料不完整
        public static final String ABO_ACCOUNT = "ABO_ACCOUNT"; // 账号异常

        // 外部调用接口
        public static final String PROXY_ERROR_UN_KNOW_APPID= "PROXY_ERROR_UN_KNOW_APPID"; // appId不存在
        public static final String PROXY_ERROR_UN_SUPPORT_APPID= "PROXY_ERROR_UN_SUPPORT_APPID"; // appId被禁用
        public static final String PROXY_ERROR_BAD_SECRET = "PROXY_ERROR_BAD_SECRET"; // 密钥错误
        public static final String PROXY_ERROR_UN_SUPPORT_DEVICE = "PROXY_ERROR_UN_SUPPORT_DEVICE"; // 不符合设备类型限制
        public static final String PROXY_ERROR_UN_SUPPORT_OS_TYPE = "PROXY_ERROR_UN_SUPPORT_OS_TYPE"; // 不符合终端类型限制
        public static final String PROXY_ERROR_UN_SUPPORT_APP_VERSION = "PROXY_ERROR_UN_SUPPORT_APP_VERSION"; // 不符合版本限制
        public static final String PROXY_ERROR_LOCKED_DEVICE = "PROXY_ERROR_LOCKED_DEVICE"; // 设备被锁定
        public static final String PROXY_ERROR_SYS_ERROR = "PROXY_ERROR_SYS_ERROR"; // 系统异常

    }

    public static void main(String[] args) {
        System.err.println(StaticType.CodeType.OK.getMessage());
        System.err.println(StaticType.CodeType.OK.getCode());
        System.err.println(StaticType.CodeType.OK.code);
        System.err.println(StaticType.CodeType.OK.message);
        System.err.println(StaticType.CodeType.getMessage(200));
    }
}
