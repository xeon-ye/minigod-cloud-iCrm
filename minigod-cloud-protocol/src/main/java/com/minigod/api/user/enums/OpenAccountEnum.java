package com.minigod.api.user.enums;

/**
 * @Author: PENGFENG
 * @Description:
 * @Date: Created in 16:04 2017/8/31
 * @Modified By:
 */
public final class OpenAccountEnum {

    public enum OpenAccountStatus {
        OPEN_SUCCESS(0, "开户成功"),
        OPEN_DOING(1, "开户中"),
        OPEN_FAIL(2, "开户失败"),
        INFO_ERROR(3, "基本资料错误"),
        PIC_ERROR(4, "影像资料错误"),
        INFO_PIC_ERROR(5, "基本资料和影像资料错误"),
        N_COMMIT_INFO(6, "未提交开户资料");

        private OpenAccountStatus(int code, String message) {
            this.code = code;
            this.message = message;
        }

        private int code;
        private String message;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    public enum OpenAccountType {
        ONLINE(1,"线上开户"),
        OFFLINE(2,"线下开户");

        private OpenAccountType(int code, String message) {
            this.code = code;
            this.message = message;
        }

        private int code;
        private String message;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    public enum OpenStatus {
        OPEN_DONE(0,"已开户"),
        OPEN_DOING(1,"开户中"),
        REFUSED_FAIL(2,"已退回"),
        REGISTER_DONE(3,"已注册");

        private OpenStatus(int code , String message) {
            this.code = code;
            this.message = message;
        }

        private int code;
        private String message;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    public enum OpenApplyStatus {
        NO_DREDGE(0,"未开通"),
        DREDGE(1,"已开通"),
        CHECKING(2,"审核中"),
        FAIL_DREDGE(3,"开通失败");

        private OpenApplyStatus(int code , String message) {
            this.code = code;
            this.message = message;
        }

        private int code;
        private String message;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
