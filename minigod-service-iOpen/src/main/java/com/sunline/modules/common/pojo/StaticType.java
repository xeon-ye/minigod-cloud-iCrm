package com.sunline.modules.common.pojo;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 公共的静态类型
 * @author: Larry Lai
 * @date: 2018/8/16 10:55
 * @version: v1.0
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

    private static final Map<Integer, CodeType> map = Maps.newHashMap();

    //公共模块相关
    public enum CodeType {
        OK(0, "调用成功"), //
        NONE_DATA(201, "无满足条件的数据"), //
        EXIST_ERROR(300, "有重复值存在"), //
        PARAMETER_DISMATCH(301, "参数不匹配"), //
        PARAMETER_ERROR(400, "参数错误"), //
        PARAMS_PARAMETER_ERROR(401, "params参数错误"), //
        SING_PARAMETER_ERROR(402, "签名参数SIGN错误"), //
        KEY_PARAMETER_ERROR(403, "签名参数KEY错误"), //
        SESSION_PARAMETER_ERROR(405, "参数SESSION_ID错误"), //
        SOCKET_ERROR(404, "网络异常"), //
        INTERNAL_ERROR(500, "请求异常,请重试"), //
        UNBIND_WECHAT_ACC(600, "未绑定微信账号"),
        DISPLAY_ERROR(888, ""), // 前端直接给用户显示的错误信息
        SIGN_ERROR(889, "签名错误"), //
        ERROR_UNKNOWN(9999, "未知错误"), //
        SESSION_INVALID(-9999,"未登录或者session已失效");

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
