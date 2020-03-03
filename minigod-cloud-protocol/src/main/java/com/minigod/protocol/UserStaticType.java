package com.minigod.protocol;

import java.util.HashMap;
import java.util.Map;

public class UserStaticType {

    private static final Map<Integer, CodeType> map = new HashMap<Integer, UserStaticType.CodeType>();

    public static final String APP_CHECK_MESSAGE_0 = "已是最新版本,无需升级"; //版本升级
    public static final String APP_CHECK_MESSAGE_1 = "有新版本%s,是否升级";
    public static final String APP_CHECK_MESSAGE_2 = "有新版本%s,建议升级";
    public static final String APP_CHECK_MESSAGE_3 = "当前版本太旧,需要升级后才可以使用哦";

    public static final String FIND_NEW_FRIEND_MSG = "来自通讯录"; //加好友列表
    public static final String FIND_NEW_FRIEND_WEIXIN_MSG = "来自微信邀请"; //加好友列表

    //短信验证码最多容许错误的次数
    public static final Integer SMS_CAPTCHA_ERROR_COUNT = 3;

    //密码容许错误的次数
    public static final Integer PWD_ERROR_COUNT = 5;

    //用户模块相关
    public enum CodeType {

        USER_REG_EXIST_ERROR(888, "%s已被注册"), //注册:手机号或微信已被注册
        USER_CODE_ERROR(888, "犇犇号错误"),
        PC_USER_REG_EXIST_ERROR(888, "手机号码已注册"), //注册:手机号或微信已被注册

        SENSITIVE_WORD_ERROR(888, "昵称不能包含敏感词"), //注册,修改昵称

        REGISTER_NICKNAME_LENGTH_ERROR(888, "昵称超过最大长度"), //注册,修改昵称

        PWD_COUNT_ERROR(888, "密码错误次数过多，账号被锁定，您可以通过“忘记密码”解锁"), //登录
        ACCOUNT_DISABLE__ERROR(888, "账号被停用，请联系玖富证卷客服启用！"), //登录

        PHONE_BIND_REG_ERROR(888, "手机号码未注册，快去注册吧"), //回密码

        PWD_UPDATE_ERROR(888, "原密码输入错误"), //修改密码

        USER_OR_PASS_ERROR(888, "用户名或密码错误"), //登录

        PHONE_ERROR(888, "手机号码不正确，请重新输入"), //手机注册,找回密码手机格式

        TRD_ACCOUNT_ERROR(888, "交易帐号不正确，请重新输入"), //交易帐号
        TRD_UNBIND_ERROR(888, "未绑定交易帐号"), //交易帐号
        TRD_BIND_ERROR(888, "已绑定交易帐号"), //交易帐号
        TRD_ACCOUNT_USE(2001, "绑定失败，交易帐号已绑定犇犇号"), //交易帐号

        TRD_ORG_ERROR(888, "交易帐号查询营业部异常"), //交易帐号
        TRD_UPPWD_ERROR(888, "修改交易密码失败"), //交易帐号
        HQ_FIND_ERROR(888, "查询行情信息异常"), //交易帐号

        TRD_ERROR(888, "交易帐号不正确，请重新输入"), //交易帐号

        EMAIL_ERROR(888, "邮箱格式不正确，请重新输入"), //邮箱注册,找回密码邮箱格式

        EMAIL_NOT_EXIST(888, "用户信息不存在"), //邮箱注册,找回密码邮箱格式
        EMAIL_EXIST(888, "邮箱已被使用"), //邮箱注册,找回密码邮箱格式
        USERCODE_NOT_EXIST(888, "用户信息不存在"), //邮箱注册,找回密码邮箱格式

        WEIXIN_REG_ERROR(888, "网络异常，请稍后重试"), //微信注册异常

        MSG_GET_CODE_FAIL(888, "验证码获取失败，请稍后重试"), //验证码获取失败

        MSG_CODE_ERROR(888, "验证码错误或已过期"), //全局短信验证提示

        PHONE_CODE_ERROR(888, "手机号已被其他用户注册"), //更改手机号

        PHONE_CODE_EQ_ERROR(888, "新手机号和旧手机号一样"), //更改手机号

        MSG_REQUEST_FREQUENT(888, "验证码验证次数超限，请重新获取"), //短信验证

        MSG_CREATE_CODE_ERROR(888, "验证码请求过于频繁，请稍后重试"), //短信验证

        MSG_ISUSED_CODE_ERROR(888, "验证码已被使用，请重新获取"), //短信验证

        NOT_SET_PWD_ERROR(888, "您还未设置密码，请通过忘记密码进行设置"), //旧用户升级

        PWD_ERROR(888, "密码验证异常，请重新输入"), //密码解析异常

        SESSION_ERROR(1006, "会话失效，请重新登录"), //无效的SESSION和会话过期

        FORCED_UPGRADE(1004, APP_CHECK_MESSAGE_3), //升级:不存在的版本号

        APP_VERSION_ERROR(1020, "错误的版本号"), //升级

        IS_NOT_REQUEST_FRIEND(1008, "无需添加自己为好友"), //加好友:不容许自己添加自己为好友

        IS_NOT_REQUEST_RECOMMEND(1009, "不需要推荐给他自己哦"), //引荐和被引荐者不能为同一人

        PONHE_ERROR(1021, "通讯录为空"), //异常:上传通讯录为空

        PHONE_NOT_BIND(1022, "手机号未绑定"), //新版本不存在

        IS_FRIEND_RECOMMEND(888, "他们已经是好友啦，推荐给其他人吧"), //好友引荐

        ISNOT_FRIEND_RECOMMEND(888, "还不是好友，无法推荐"), //好友引荐校验当前用户和源、目标用户是否为好友关系

        ISNOT_PRY_RECOMMEND(888, "对方设置了隐私权限，不允许被推荐"), //好友引荐

        IS_FRIEND_REQ(888, "他们有未处理的好友申请，不需要推荐哦"), //好友引荐

        EXCEED_FRIENDCEILING_REQ(888, "您的联系人数量已达%d人上限，无法继续添加"), //加好友

        EXCEED_ADVISERILING_REQ(1203,
                "信息过多会造成干扰哦，我们建议添加的投顾不超过%d人。\n\n若您想继续添加，需要先删除不满意的投顾：点击投顾的头像进入主页，点击右上角“...”，选择“删除投顾”"),

        EXCEED_FRIENDCEILING_RSP_TAR(888, "对方联系人数量已达上限，无法继续添加"), //处理好友添加请求

        EXCEED_ADVERSERCEILING_RSP_TAR(888, "对方体验人数已达上限，无法继续添加"), //处理投顾添加请求

        NOT_DEL_FRIEND_TAR_ISFOLLOW(888, "对方实盘买入了您的组合，无法删除"), //删除好友

        NOT_DEL_FRIEND_ISFOLLOW(888, "您实盘买入了对方的组合，无法删除"), //删除好友

        DEL_YQN_CODE_ERROR(888, "无法删除minigod證券國際官方账号"), //默认minigod證券國際关注

        REGISTER_PHONE_LENGTH_ERROR(888, "密码必须为6-16位字符"), //注册,找回密码

        //----------------

        TRADE_PWD_LENGTH_ERROR(888, "交易密码必须为8位"), //支付密码

        TRADE_PWD_LOCK_ERROR(1300, "交易密码输入错误次数过多已被锁定，请明日再试"), //支付密码输入错误次数过多

        TRADE_PWD_ERROR(1301, "交易密码验证错误，您还剩s%次验证机会"), //支付密码验证错误，您还剩s%次验证机会

        TRADE_SET_PWD_ERROR(888, "您未设置过交易密码，无需修改"),

        //----------------

        REGISTER_PWD_NULL_ERROR(888, "密码不能全是空格"),

        ERROR_UNKNOWN(100, "未知错误，请稍后重试或联系客服"),

        LENGTH_UPPER_LIMIT(1099, "您输入的内容超过最大上限"),

        NOT_AD_LINK(1023, "没有相关广告链接"),

        AD_LINK_IS_CLOSE(1024, "用户关闭广告链接"),

        NOT_EXIXT_AD_LINK(1025, "不存在此广告链接"),

        UNKNOW_ADD_FRIEND(1026, "添加失败,请重试！"),

        //----------------------------------------
        WEIXIN_BIND_ERROR(1027, "该微信号已绑定其他minigod證券國際帐号！"),

        WEIXIN_NOT_BIND_ERROR(1028, "微信已解绑！"),

        WEIXIN_NOT_UPDATE_ERROR(1029, "您已申请投顾认证，无法解绑微信号！"),

        UPLOAD_IMAGE_LIMIT3(1031, "最多只能上传3张照片"),

        UPLOAD_IMAGE_LIMIT6(1032, "最多只能上传6张照片"),

        UPLOAD_IMAGE_NULL(1033, "上传图片为空"),

        UPLOAD_IMAGE_LIMITSIZE(1034, "单张图片不能大于2M"),

        IMG_SUFFIX_LIMIT(1035, "只能上传图片文件"),

        NICKNAME_NOT_UPDATE_ERROR(1036, "投顾认证通过后，不允许修改昵称！"),

        GROUP_NAME_NULL(1037, "组名为空"),

        ADD_FRIENDE_ERROR(1099, "添加好友失败"),

        NICK_NAME_NULL(1038, "昵称不能为空"),

        IS_NOT_ADVISER(1039, "参数错误，非投顾类型"),

        OPEN_INSTRUCTION_NULL(1041, "开户说明不能为空"),

        OPEN_URL_NULL(1042, "开户链接不能为空"),

        INVALID_URL(1043, "开户链接是无效的"),

        OPEN_BROKERAGE_LIMIT(1044, "开户佣金内容超过最大上限"),

        OPEN_ACTIVITY_LIMIT(1045, "开户活动内容超过最大上限"),

        OPEN_INSTRUCTION_LIMIT(1046, "开户说明内容超过最大上限"),

        OPEN_URL_LIMIT(1047, "开户链接内容超过最大上限"),

        GUEST_NO_ACCESS(1111, "游客用户无权访问此接口，请注册正式用户"),

        IS_IN_BLACKLIST(1201, "对方拒绝了你的申请"),

        WAITING_FOR_ACCEPT(1202, "等待对方验证中"),
        NO_SET_PWD(1001, "未设置密码"),
        //----------------sn job----------------------//

        SnJOB_UN_SGIN_IN(2001,"已经签过到了"),
        SnJOB_SGIN_IN(2002,"可以签到"),
        //----------------sn job----------------------//

        A_STOCK_BINDING_STATUS(888 , "您未绑定A股交易账号"),
    	
    	USER_DOUBLE_VERIFY_PARAM_ERROR(2003,"二重认证参数错误");
    	
    	
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
}
