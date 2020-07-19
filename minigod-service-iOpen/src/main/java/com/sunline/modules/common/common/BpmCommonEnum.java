package com.sunline.modules.common.common;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author LiYangFeng
 * @createDate 2017/1/17
 * @description
 * @email justbelyf@gmail.com
 */

public final class BpmCommonEnum {

    private static final Map<Integer, CodeType> map = Maps.newHashMap();

    private BpmCommonEnum() {
    }

    /**
     * 公共模块相关
     */
    public enum CodeType {

        OK(0, "调用成功"),
        ERROR(-1, "error"),
        NONE_DATA(201, "无满足条件的数据"),
        EXIST_ERROR(300, "有重复值存在"),
        PARAMETER_DISMATCH(301, "参数不匹配"),
        PARAMETER_ERROR(400, "参数错误"),
        PARAMS_PARAMETER_ERROR(401, "params参数错误"),
        SING_PARAMETER_ERROR(402, "签名参数SIGN错误"),
        KEY_PARAMETER_ERROR(403, "签名参数KEY错误"),
        SESSION_PARAMETER_ERROR(405, "参数SESSION_ID错误"),
        SOCKET_ERROR(404, "网络异常"),
        INTERNAL_ERROR(500, "请求异常，请重试"),
        UNBIND_WECHAT_ACC(600, "未绑定微信账号"),
        SIGN_ERROR(889, "签名错误"),
        ERROR_UNKNOWN(9999, "未知错误"),
        SESSION_INVALID(-9999, "未登录或者session已失效"),
        WEB_SUCCESS(0, "ok"),
        WEB_ERROR(-1, "error"),
        WEB_DUPLICATE(-2, "exist");

        private int code;
        private String message;

        CodeType(int code, String message) {
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

        public static String getMessage(int code) {
            CodeType codeType = map.get(code);
            if (codeType == null) {
                return ERROR_UNKNOWN.getMessage();
            }
            return codeType.getMessage();
        }
    }

    /**
     * 返回结果
     */
    public enum CommonEnum {

        /**
         * 返回结果
         */
        COMMON_CODE_SUCCESS(0, "成功"),
        COMMON_CODE_FAILED(-1, "失败");

        private final int index;
        private final String name;

        CommonEnum(int index, String name) {
            this.index = index;
            this.name = name;
        }

        public static String getName(int index) {
            for (CommonEnum c : CommonEnum.values()) {
                if (c.getIndex() == index) {
                    return c.name;
                }
            }
            return null;
        }

        public int getIndex() {
            return index;
        }

        public String getName() {
            return name;
        }
    }

    /**
     * 是否类型
     */
    public enum YesNo {

        /**
         * 返回结果
         */
        NO(0, "否"),
        YES(1, "是");

        private final int index;
        private final String name;

        YesNo(int index, String name) {
            this.index = index;
            this.name = name;
        }

        public static String getName(int index) {
            for (YesNo c : YesNo.values()) {
                if (c.getIndex() == index) {
                    return c.name;
                }
            }
            return null;
        }

        public int getIndex() {
            return index;
        }

        public String getName() {
            return name;
        }
    }

    /**
     * 恒生系统开户业务步骤
     */
    public enum OpenAccountStep {
        OPEN_ACCOUNT_STEP_UN_KNOWN(0, 0),
        OPEN_ACCOUNT_STEP_CRATE_USER_ACCOUNT(1100, 1100),   // 创建客户号
        OPEN_ACCOUNT_STEP_IDENTIFY_USER_ACCOUNT(1200, 1200),    // 认证客户号
        OPEN_ACCOUNT_STEP_CREATE_FUND_ACCOUNT(1300, 1300),  // 创建资金帐号
        OPEN_ACCOUNT_STEP_IDENTIFY_FUND_ACCOUNT(1400, 1400),    // 认证资金帐号
        OPEN_ACCOUNT_STEP_CREATE_CURRENCY_ACCOUNT_CNY(1500, 1500),  // 开通币种人民币
        OPEN_ACCOUNT_STEP_CREATE_CURRENCY_ACCOUNT_HKD(1501, 1501),  // 开通币种港币
        OPEN_ACCOUNT_STEP_CREATE_CURRENCY_ACCOUNT_USD(1502, 1502),  // 开通币种美元
        OPEN_ACCOUNT_STEP_CREATE_STOCK_ACCOUNT_HK(1600, 1600),  // 开通港股市场
        OPEN_ACCOUNT_STEP_CREATE_STOCK_ACCOUNT_US(1601, 1601),  // 开通美股市场
        OPEN_ACCOUNT_STEP_SETTING_USER_BROKER_RELATION(1700, 1700), // 设置经纪人关系
        OPEN_ACCOUNT_STEP_SETTING_TRANSACTION_EXPENSES(1800, 1800), // 设置交易费用
        OPEN_ACCOUNT_STEP_MANAGE_NOTIFICATION_DAILY(1900, 1900),    // 每日通知管理
        OPEN_ACCOUNT_STEP_MANAGE_NOTIFICATION_MONTHLY(1901, 1901),  // 每月通知管理
        OPEN_ACCOUNT_STEP_MANAGE_ADDRESS(2000, 2000);   // 客户地址管理


        public static final int OPEN_ACCOUNT_STEP_UN_KNOWN_VALUE = 0;
        public static final int OPEN_ACCOUNT_STEP_CRATE_USER_ACCOUNT_VALUE = 1100;
        public static final int OPEN_ACCOUNT_STEP_IDENTIFY_USER_ACCOUNT_VALUE = 1200;
        public static final int OPEN_ACCOUNT_STEP_CREATE_FUND_ACCOUNT_VALUE = 1300;
        public static final int OPEN_ACCOUNT_STEP_IDENTIFY_FUND_ACCOUNT_VALUE = 1400;
        public static final int OPEN_ACCOUNT_STEP_CREATE_CURRENCY_ACCOUNT_CNY_VALUE = 1500;
        public static final int OPEN_ACCOUNT_STEP_CREATE_CURRENCY_ACCOUNT_HKD_VALUE = 1501;
        public static final int OPEN_ACCOUNT_STEP_CREATE_CURRENCY_ACCOUNT_USD_VALUE = 1502;
        public static final int OPEN_ACCOUNT_STEP_CREATE_STOCK_ACCOUNT_HK_VALUE = 1600;
        public static final int OPEN_ACCOUNT_STEP_CREATE_STOCK_ACCOUNT_US_VALUE = 1601;
        public static final int OPEN_ACCOUNT_STEP_SETTING_USER_BROKER_RELATION_VALUE = 1700;
        public static final int OPEN_ACCOUNT_STEP_SETTING_TRANSACTION_EXPENSES_VALUE = 1800;
        public static final int OPEN_ACCOUNT_STEP_MANAGE_NOTIFICATION_DAILY_VALUE = 1900;
        public static final int OPEN_ACCOUNT_STEP_MANAGE_NOTIFICATION_MONTHLY_VALUE = 1901;
        public static final int OPEN_ACCOUNT_STEP_MANAGE_ADDRESS_VALUE = 2000;

        public final int getNumber() {
            return value;
        }

        public static OpenAccountStep valueOf(int value) {
            switch (value) {
                case 0:
                    return OPEN_ACCOUNT_STEP_UN_KNOWN;
                case 1100:
                    return OPEN_ACCOUNT_STEP_CRATE_USER_ACCOUNT;
                case 1200:
                    return OPEN_ACCOUNT_STEP_IDENTIFY_USER_ACCOUNT;
                case 1300:
                    return OPEN_ACCOUNT_STEP_CREATE_FUND_ACCOUNT;
                case 1400:
                    return OPEN_ACCOUNT_STEP_IDENTIFY_FUND_ACCOUNT;
                case 1500:
                    return OPEN_ACCOUNT_STEP_CREATE_CURRENCY_ACCOUNT_CNY;
                case 1501:
                    return OPEN_ACCOUNT_STEP_CREATE_CURRENCY_ACCOUNT_HKD;
                case 1502:
                    return OPEN_ACCOUNT_STEP_CREATE_CURRENCY_ACCOUNT_USD;
                case 1600:
                    return OPEN_ACCOUNT_STEP_CREATE_STOCK_ACCOUNT_HK;
                case 1601:
                    return OPEN_ACCOUNT_STEP_CREATE_STOCK_ACCOUNT_US;
                case 1700:
                    return OPEN_ACCOUNT_STEP_SETTING_USER_BROKER_RELATION;
                case 1800:
                    return OPEN_ACCOUNT_STEP_SETTING_TRANSACTION_EXPENSES;
                case 1900:
                    return OPEN_ACCOUNT_STEP_MANAGE_NOTIFICATION_DAILY;
                case 1901:
                    return OPEN_ACCOUNT_STEP_MANAGE_NOTIFICATION_MONTHLY;
                case 2000:
                    return OPEN_ACCOUNT_STEP_MANAGE_ADDRESS;
                default:
                    return null;

            }

        }

        private final int value;

        private OpenAccountStep(int index, int value) {
            this.value = value;
        }
    }

    /**
     * 通用处理过程状态
     */
    public enum CommonProcessStatus {
        COMMON_PROCESS_STATUS_UN_KNOW(0, 0),    // 未知
        COMMON_PROCESS_STATUS_WAITING(1, 1),    // 待处理
        COMMON_PROCESS_STATUS_SUCCEED(2, 2),    // 成功
        COMMON_PROCESS_STATUS_FAILED(3, 3),     // 失败
        COMMON_PROCESS_STATUS_IN_PROCESS(4, 4), // 处理中
        COMMON_PROCESS_STATUS_UN_PROCESS(5, 5); // 未处理

        public static final int COMMON_PROCESS_STATUS_UN_KNOW_VALUE = 0;
        public static final int COMMON_PROCESS_STATUS_WAITING_VALUE = 1;
        public static final int COMMON_PROCESS_STATUS_SUCCEED_VALUE = 2;
        public static final int COMMON_PROCESS_STATUS_FAILED_VALUE = 3;
        public static final int COMMON_PROCESS_STATUS_IN_PROCESS_VALUE = 4;
        public static final int COMMON_PROCESS_STATUS_UN_PROCESS_VALUE = 5;

        public final int getNumber() {
            return value;
        }

        public static CommonProcessStatus valueOf(int value) {
            switch (value) {
                case 0:
                    return COMMON_PROCESS_STATUS_UN_KNOW;
                case 1:
                    return COMMON_PROCESS_STATUS_WAITING;
                case 2:
                    return COMMON_PROCESS_STATUS_SUCCEED;
                case 3:
                    return COMMON_PROCESS_STATUS_FAILED;
                case 4:
                    return COMMON_PROCESS_STATUS_IN_PROCESS;
                case 5:
                    return COMMON_PROCESS_STATUS_UN_PROCESS;
                default:
                    return null;
            }
        }

        private final int value;

        private CommonProcessStatus(int index, int value) {
            this.value = value;
        }

    }


    /**
     * 通用完成类型
     */
    public enum CommonFinishType {
        COMMON_FINISH_TYPE_UKNOW(0, 0),         // 未知
        COMMON_FINISH_TYPE_UN_FINISHED(1, 1),   // 未完成
        COMMON_FINISH_TYPE_PART_FINISHED(2, 2),  // 部分完成
        COMMON_FINISH_TYPE_ALL_FINISHED(3, 3);  // 全部完成

        public static final int COMMON_FINISH_TYPE_UKNOW_VALUE = 0;
        public static final int COMMON_FINISH_TYPE_UN_FINISHED_VALUE = 1;
        public static final int COMMON_FINISH_TYPE_PART_FINISHED_VALUE = 2;
        public static final int COMMON_FINISH_TYPE_ALL_FINISHED_VALUE = 3;

        public final int getNumber() {
            return value;
        }

        public static CommonFinishType valueOf(int value) {
            switch (value) {
                case 0:
                    return COMMON_FINISH_TYPE_UKNOW;
                case 1:
                    return COMMON_FINISH_TYPE_UN_FINISHED;
                case 2:
                    return COMMON_FINISH_TYPE_PART_FINISHED;
                case 3:
                    return COMMON_FINISH_TYPE_ALL_FINISHED;
                default:
                    return null;
            }
        }

        private final int value;

        private CommonFinishType(int index, int value) {
            this.value = value;
        }

    }

    /**
     * 通用完成类型
     */
    public enum CommonProcessResultStatus {
        COMMON_PROCESS_RESULT_STATUS_UNKNOWN(0, 0),         // 未知
        COMMON_PROCESS_RESULT_STATUS_SUCCEED(1, 1),   // 成功
        COMMON_PROCESS_RESULT_STATUS_FAILED(2, 2),  // 失败
        COMMON_PROCESS_RESULT_STATUS_PART_SUCCEED(3, 3),  // 部分成功
        COMMON_PROCESS_RESULT_STATUS_ALL_SUCCEED(4, 4);  //  全部成功

        public static final int COMMON_PROCESS_RESULT_STATUS_UNKNOWN_VALUE = 0;
        public static final int COMMON_PROCESS_RESULT_STATUS_SUCCEED_VALUE = 1;
        public static final int COMMON_PROCESS_RESULT_STATUS_FAILED_VALUE = 2;
        public static final int COMMON_PROCESS_RESULT_STATUS_PART_SUCCEED_VALUE = 3;
        public static final int COMMON_PROCESS_RESULT_STATUS_ALL_SUCCEED_VALUE = 4;

        public final int getNumber() {
            return value;
        }

        public static CommonProcessResultStatus valueOf(int value) {
            switch (value) {
                case 0:
                    return COMMON_PROCESS_RESULT_STATUS_UNKNOWN;
                case 1:
                    return COMMON_PROCESS_RESULT_STATUS_SUCCEED;
                case 2:
                    return COMMON_PROCESS_RESULT_STATUS_FAILED;
                case 3:
                    return COMMON_PROCESS_RESULT_STATUS_PART_SUCCEED;
                case 4:
                    return COMMON_PROCESS_RESULT_STATUS_ALL_SUCCEED;
                default:
                    return null;
            }
        }

        private final int value;

        private CommonProcessResultStatus(int index, int value) {
            this.value = value;
        }

    }


    // 通用是否
    public enum CommonWhether {
        COMMON_WHETHER_UNKNOW(0, 0),      // 未知
        COMMON_WHETHER_YES(1, 1),         // 是
        COMMON_WHETHER_NO(2, 2);          // 否

        public static final int COMMON_WHETHER_UNKNOW_VALUE = 0;
        public static final int COMMON_WHETHER_YES_VALUE = 1;
        public static final int COMMON_WHETHER_NO_VALUE = 2;

        public final int getNumber() {
            return value;
        }

        public static CommonWhether valueOf(int value) {
            switch (value) {
                case 0:
                    return COMMON_WHETHER_UNKNOW;
                case 1:
                    return COMMON_WHETHER_YES;
                case 2:
                    return COMMON_WHETHER_NO;
                default:
                    return null;
            }
        }

        private final int value;

        private CommonWhether(int index, int value) {
            this.value = value;
        }
    }


    // 通用日期类型
    public enum CommonDayType {
        COMMON_DAY_TYPE(0, 0),                    // 未知
        COMMON_DAY_TYPE_WORK_DAY(1, 1),           // 工作日
        COMMON_DAY_TYPE_WEEKEND(2, 2);            // 周末

        public static final int COMMON_DAY_TYPE_VALUE = 0;
        public static final int COMMON_DAY_TYPE_WORK_DAY_VALUE = 1;
        public static final int COMMON_DAY_TYPE_WEEKEND_VALUE = 2;

        public final int getNumber() {
            return value;
        }

        public static CommonDayType valueOf(int value) {
            switch (value) {
                case 0:
                    return COMMON_DAY_TYPE;
                case 1:
                    return COMMON_DAY_TYPE_WORK_DAY;
                case 2:
                    return COMMON_DAY_TYPE_WEEKEND;
                default:
                    return null;
            }
        }

        private final int value;

        private CommonDayType(int index, int value) {
            this.value = value;
        }
    }

    // 通用记录状态
    public enum CommonRecordStatus {
        COMMON_RECORD_STATUS_UNKNOWN(0, 0),      // 未知
        COMMON_RECORD_STATUS_ENABLE(1, 1),       // 有效
        COMMON_RECORD_STATUS_DISABLE(2, 2);      // 无效

        public static final int COMMON_RECORD_STATUS_UNKNOWN_VALUE = 0;
        public static final int COMMON_RECORD_STATUS_ENABLE_VALUE = 1;
        public static final int COMMON_RECORD_STATUS_DISABLE_VALUE = 2;

        public final int getNumber() {
            return value;
        }

        public static CommonRecordStatus valueOf(int value) {
            switch (value) {
                case 0:
                    return COMMON_RECORD_STATUS_UNKNOWN;
                case 1:
                    return COMMON_RECORD_STATUS_ENABLE;
                case 2:
                    return COMMON_RECORD_STATUS_DISABLE;
                default:
                    return null;
            }
        }

        private final int value;

        private CommonRecordStatus(int index, int value) {
            this.value = value;
        }
    }


    // 发货类型
    public enum ConsignmentType {
        CONSIGNMENT_TYPE_UNKNOWN(0, 0),                    // 未知
        CONSIGNMENT_TYPE_TEXT(1, 1),                      // 文本
        CONSIGNMENT_TYPE_IMAGE(2, 2),                     // 图片
        CONSIGNMENT_TYPE_TEXT_AND_IMAGE(3, 3);            // 文本+图片

        public static final int CONSIGNMENT_TYPE_UNKNOW_VALUE = 0;
        public static final int CONSIGNMENT_TYPE_TEXT_VALUE = 1;
        public static final int CONSIGNMENT_TYPE_IMAGE_VALUE = 2;
        public static final int CONSIGNMENT_TYPE_TEXT_AND_IMAGE_VALUE = 3;

        public final int getNumber() {
            return value;
        }

        public static ConsignmentType valueOf(int value) {
            switch (value) {
                case 0:
                    return CONSIGNMENT_TYPE_UNKNOWN;
                case 1:
                    return CONSIGNMENT_TYPE_TEXT;
                case 2:
                    return CONSIGNMENT_TYPE_IMAGE;
                case 3:
                    return CONSIGNMENT_TYPE_TEXT_AND_IMAGE;
                default:
                    return null;
            }
        }

        private final int value;

        private ConsignmentType(int index, int value) {
            this.value = value;
        }
    }


    // 见证人见证资质类型
    public enum WitnessQualificationType {
        WITNESS_QUALIFICATION_TYPE_UNKNOW(0, 0),                      // 未知
        WITNESS_QUALIFICATION_TYPE_SECURITY(1, 1);                    // 证券见证

        public static final int WITNESS_QUALIFICATION_TYPE_UNKNOW_VALUE = 0;
        public static final int WITNESS_QUALIFICATION_TYPE_SECURITY_VALUE = 1;

        public final int getNumber() {
            return value;
        }

        public static WitnessQualificationType valueOf(int value) {
            switch (value) {
                case 0:
                    return WITNESS_QUALIFICATION_TYPE_UNKNOW;
                case 1:
                    return WITNESS_QUALIFICATION_TYPE_SECURITY;
                default:
                    return null;
            }
        }

        private final int value;

        private WitnessQualificationType(int index, int value) {
            this.value = value;
        }
    }


    // 资料修改的主体申请类型
    public enum ModifySubjectType {
        MODIFY_SUBJECT_TYPE_UNKNOW(0, 0),                 // 未知
        MODIFY_SUBJECT_TYPE_WITNESSES(1, 1);              // 见证人资料

        public static final int MODIFY_SUBJECT_TYPE_UNKNOW_VALUE = 0;
        public static final int MODIFY_SUBJECT_TYPE_WITNESSES_VALUE = 1;

        public final int getNumber() {
            return value;
        }

        public static ModifySubjectType valueOf(int value) {
            switch (value) {
                case 0:
                    return MODIFY_SUBJECT_TYPE_UNKNOW;
                case 1:
                    return MODIFY_SUBJECT_TYPE_WITNESSES;
                default:
                    return null;
            }
        }

        private final int value;

        private ModifySubjectType(int index, int value) {
            this.value = value;
        }
    }


    // 资料修改的主体申请类型的具体类型
    public enum ModifySubordinateType {
        MODIFY_SUBORDINATE_TYPE_UNKNOW(0, 0),            // 未知
        MODIFY_SUBORDINATE_TYPE_HEAD_IMAGE(1, 1),         // 个人头像
        MODIFY_SUBORDINATE_TYPE_PHONE_NUMBER(2, 2),       // 手机号码
        MODIFY_SUBORDINATE_TYPE_EMAIL(3, 3),             // 电子邮箱
        MODIFY_SUBORDINATE_TYPE_CONTACT_ADDRESS(4, 4),    // 所在地区
        MODIFY_SUBORDINATE_TYPE_CONTACT_ADDRESS_DETAIL(5, 5),// 联系地址
        MODIFY_SUBORDINATE_TYPE_COMPANY_NAME(6, 6),        // 公司名称
        MODIFY_SUBORDINATE_TYPE_COMPANY_TEL(7, 7),        // 公司电话
        MODIFY_SUBORDINATE_TYPE_POSITION(8, 8);         // 职位

        public static final int MODIFY_SUBORDINATE_TYPE_UNKNOW_VALUE = 0;
        public static final int MODIFY_SUBORDINATE_TYPE_HEAD_IMAGE_VALUE = 1;
        public static final int MODIFY_SUBORDINATE_TYPE_PHONE_NUMBER_VALUE = 2;
        public static final int MODIFY_SUBORDINATE_TYPE_EMAIL_VALUE = 3;
        public static final int MODIFY_SUBORDINATE_TYPE_CONTACT_ADDRESS_VALUE = 4;
        public static final int MODIFY_SUBORDINATE_TYPE_CONTACT_ADDRESS_DETAIL_VALUE = 5;
        public static final int MODIFY_SUBORDINATE_TYPE_COMPANY_NAME_VALUE = 6;
        public static final int MODIFY_SUBORDINATE_TYPE_COMPANY_TEL_VALUE = 7;
        public static final int MODIFY_SUBORDINATE_TYPE_POSITION_VALUE = 8;

        public final int getNumber() {
            return value;
        }

        public static ModifySubordinateType valueOf(int value) {
            switch (value) {
                case 0:
                    return MODIFY_SUBORDINATE_TYPE_UNKNOW;
                case 1:
                    return MODIFY_SUBORDINATE_TYPE_HEAD_IMAGE;
                case 2:
                    return MODIFY_SUBORDINATE_TYPE_PHONE_NUMBER;
                case 3:
                    return MODIFY_SUBORDINATE_TYPE_EMAIL;
                case 4:
                    return MODIFY_SUBORDINATE_TYPE_CONTACT_ADDRESS;
                case 5:
                    return MODIFY_SUBORDINATE_TYPE_CONTACT_ADDRESS_DETAIL;
                case 6:
                    return MODIFY_SUBORDINATE_TYPE_COMPANY_NAME;
                case 7:
                    return MODIFY_SUBORDINATE_TYPE_COMPANY_TEL;
                case 8:
                    return MODIFY_SUBORDINATE_TYPE_POSITION;
                default:
                    return null;
            }
        }

        private final int value;

        private ModifySubordinateType(int index, int value) {
            this.value = value;
        }
    }


    // 文件类型
    public enum FileStorageType {
        FILE_STORAGE_TYPE_UNKNOW(0, 0),                   // 未知
        FILE_STORAGE_TYPE_IMAGE(1, 1),                    // 图片
        FILE_STORAGE_TYPE_PDF(2, 2),                      // PDF
        FILE_STORAGE_TYPE_TEXT(3, 3),                     // 文本
        FILE_STORAGE_TYPE_XLSX(4, 4),                     // EXCEL
        FILE_STORAGE_TYPE_DOC(5, 5);                     // WORD

        public static final int FILE_STORAGE_TYPE_UNKNOW_VALUE = 0;
        public static final int FILE_STORAGE_TYPE_IMAGE_VALUE = 1;
        public static final int FILE_STORAGE_TYPE_PDF_VALUE = 2;
        public static final int FILE_STORAGE_TYPE_TEXT_VALUE = 3;
        public static final int FILE_STORAGE_TYPE_XLSX_VALUE = 4;
        public static final int FILE_STORAGE_TYPE_DOC_VALUE = 5;

        public final int getNumber() {
            return value;
        }

        public static FileStorageType valueOf(int value) {
            switch (value) {
                case 0:
                    return FILE_STORAGE_TYPE_UNKNOW;
                case 1:
                    return FILE_STORAGE_TYPE_IMAGE;
                case 2:
                    return FILE_STORAGE_TYPE_PDF;
                case 3:
                    return FILE_STORAGE_TYPE_TEXT;
                case 4:
                    return FILE_STORAGE_TYPE_XLSX;
                case 5:
                    return FILE_STORAGE_TYPE_DOC;
                default:
                    return null;
            }
        }

        private final int value;

        private FileStorageType(int index, int value) {
            this.value = value;
        }
    }

    // 存储路径类型
    public enum FilePathType {
        FILE_PATH_TYPE_UNKNOW(0, 0),                      // 未知
        FILE_PATH_TYPE_LOCAL(1, 1),                       // 本地
        FILE_PATH_TYPE_URI(2, 2);                         // URI

        public static final int FILE_PATH_TYPE_UNKNOW_VALUE = 0;
        public static final int FILE_PATH_TYPE_LOCAL_VALUE = 1;
        public static final int FILE_PATH_TYPE_URI_VALUE = 2;

        public final int getNumber() {
            return value;
        }

        public static FilePathType valueOf(int value) {
            switch (value) {
                case 0:
                    return FILE_PATH_TYPE_UNKNOW;
                case 1:
                    return FILE_PATH_TYPE_LOCAL;
                case 2:
                    return FILE_PATH_TYPE_URI;
                default:
                    return null;
            }
        }

        private final int value;

        private FilePathType(int index, int value) {
            this.value = value;
        }
    }

    // 文件业务信息的所有者类型
    public enum FileBusinessInfoOwnerType {
        FILE_BUSINESS_INFO_OWNER_TYPE_UNKNOW(0, 0),                   // 未知
        FILE_BUSINESS_INFO_OWNER_TYPE_WITNESS(1, 1),                  // 见证人
        FILE_BUSINESS_INFO_OWNER_TYPE_WITNESS_ORDER(2, 2),            // 见证订单
        FILE_BUSINESS_INFO_OWNER_TYPE_OPEN_ACCOUNT_INFO(3, 3),        // 开户资料信息
        FILE_BUSINESS_INFO_OWNER_TYPE_WITNESS_OPEN_ACCOUNT_APPLY(4, 4);        // 线下见证预约申请

        public static final int FILE_BUSINESS_INFO_OWNER_TYPE_UNKNOW_VALUE = 0;
        public static final int FILE_BUSINESS_INFO_OWNER_TYPE_WITNESS_VALUE = 1;
        public static final int FILE_BUSINESS_INFO_OWNER_TYPE_WITNESS_ORDER_VALUE = 2;
        public static final int FILE_BUSINESS_INFO_OWNER_TYPE_OPEN_ACCOUNT_INFO_VALUE = 3;
        public static final int FILE_BUSINESS_INFO_OWNER_TYPE_WITNESS_OPEN_ACCOUNT_APPLY_VALUE = 4;

        public final int getNumber() {
            return value;
        }

        public static FileBusinessInfoOwnerType valueOf(int value) {
            switch (value) {
                case 0:
                    return FILE_BUSINESS_INFO_OWNER_TYPE_UNKNOW;
                case 1:
                    return FILE_BUSINESS_INFO_OWNER_TYPE_WITNESS;
                case 2:
                    return FILE_BUSINESS_INFO_OWNER_TYPE_WITNESS_ORDER;
                case 3:
                    return FILE_BUSINESS_INFO_OWNER_TYPE_OPEN_ACCOUNT_INFO;
                case 4:
                    return FILE_BUSINESS_INFO_OWNER_TYPE_WITNESS_OPEN_ACCOUNT_APPLY;
                default:
                    return null;
            }
        }

        private final int value;

        private FileBusinessInfoOwnerType(int index, int value) {
            this.value = value;
        }
    }

    // 通用流程操作类型
    public enum CommonWorkflowOperateType {
        COMMON_WORKFLOW_OPERATE_TYPE_UNKNOWN(0, 0),         // 未知
        COMMON_WORKFLOW_OPERATE_TYPE_COMMIT(1, 1),          // 提交
        COMMON_WORKFLOW_OPERATE_TYPE_REFUND(2, 2),          // 退回
        COMMON_WORKFLOW_OPERATE_TYPE_TERMINATION(3, 3),     // 终止
        COMMON_WORKFLOW_OPERATE_TYPE_FINISH(4, 4);          // 完成

        public static final int COMMON_WORKFLOW_OPERATE_TYPE_UNKNOWN_VALUE = 0;
        public static final int COMMON_WORKFLOW_OPERATE_TYPE_COMMIT_VALUE = 1;
        public static final int COMMON_WORKFLOW_OPERATE_TYPE_REFUND_VALUE = 2;
        public static final int COMMON_WORKFLOW_OPERATE_TYPE_TERMINATION_VALUE = 3;
        public static final int COMMON_WORKFLOW_OPERATE_TYPE_FINISH_VALUE = 4;

        public final int getNumber() {
            return value;
        }

        public static CommonWorkflowOperateType valueOf(int value) {
            switch (value) {
                case 0:
                    return COMMON_WORKFLOW_OPERATE_TYPE_UNKNOWN;
                case 1:
                    return COMMON_WORKFLOW_OPERATE_TYPE_COMMIT;
                case 2:
                    return COMMON_WORKFLOW_OPERATE_TYPE_REFUND;
                case 3:
                    return COMMON_WORKFLOW_OPERATE_TYPE_TERMINATION;
                case 4:
                    return COMMON_WORKFLOW_OPERATE_TYPE_FINISH;
                default:
                    return null;
            }
        }

        private final int value;

        private CommonWorkflowOperateType(int index, int value) {
            this.value = value;
        }
    }


    // 名单颜色类型 ^_^这个命名有点尴尬
    public enum ListColourType {
        LIST_COLOUR_TYPE_UNKNOWN(0, 0),               // 未知
        LIST_COLOUR_TYPE_BLACK(1, 1),                 // 黑名单
        LIST_COLOUR_TYPE_WHITE(2, 2),                 // 白名单
        LIST_COLOUR_TYPE_RED(3, 3);                   // 红名单

        public static final int LIST_COLOUR_TYPE_UNKNOWN_VALUE = 0;
        public static final int LIST_COLOUR_TYPE_BLACK_VALUE = 1;
        public static final int LIST_COLOUR_TYPE_WHITE_VALUE = 2;
        public static final int LIST_COLOUR_TYPE_RED_VALUE = 3;

        public final int getNumber() {
            return value;
        }

        public static ListColourType valueOf(int value) {
            switch (value) {
                case 0:
                    return LIST_COLOUR_TYPE_UNKNOWN;
                case 1:
                    return LIST_COLOUR_TYPE_BLACK;
                case 2:
                    return LIST_COLOUR_TYPE_WHITE;
                case 3:
                    return LIST_COLOUR_TYPE_RED;
                default:
                    return null;
            }
        }

        private final int value;

        private ListColourType(int index, int value) {
            this.value = value;
        }
    }


    // 见证订单处理结果状态
    public enum WitnessOrderProcessResultStatus {
        WITNESS_ORDER_PROCESS_RESULT_UNKNOW(0, 0),                // 未知
        WITNESS_ORDER_PROCESS_RESULT_WAITING_APPROVE(1, 1),               // 待审核
        WITNESS_ORDER_PROCESS_RESULT_REFUND(2, 2),                // 已退回
        WITNESS_ORDER_PROCESS_RESULT_FINISHED(3, 3),              // 已完成
        WITNESS_ORDER_PROCESS_RESULT_CLOSED(4, 4),                // 已关闭
        WITNESS_ORDER_PROCESS_RESULT_WAITING_WITNESS(5, 5);       // 待见证

        public static final int WITNESS_ORDER_PROCESS_RESULT_UNKNOW_VALUE = 0;
        public static final int WITNESS_ORDER_PROCESS_RESULT_WAITING_APPROVE_VALUE = 1;
        public static final int WITNESS_ORDER_PROCESS_RESULT_REFUND_VALUE = 2;
        public static final int WITNESS_ORDER_PROCESS_RESULT_FINISHED_VALUE = 3;
        public static final int WITNESS_ORDER_PROCESS_RESULT_CLOSED_VALUE = 4;
        public static final int WITNESS_ORDER_PROCESS_RESULT_WAITING_WITNESS_VALUE = 5;

        public final int getNumber() {
            return value;
        }

        public static WitnessOrderProcessResultStatus valueOf(int value) {
            switch (value) {
                case 0:
                    return WITNESS_ORDER_PROCESS_RESULT_UNKNOW;
                case 1:
                    return WITNESS_ORDER_PROCESS_RESULT_WAITING_APPROVE;
                case 2:
                    return WITNESS_ORDER_PROCESS_RESULT_REFUND;
                case 3:
                    return WITNESS_ORDER_PROCESS_RESULT_FINISHED;
                case 4:
                    return WITNESS_ORDER_PROCESS_RESULT_CLOSED;
                case 5:
                    return WITNESS_ORDER_PROCESS_RESULT_WAITING_WITNESS;
                default:
                    return null;
            }
        }

        private final int value;

        private WitnessOrderProcessResultStatus(int index, int value) {
            this.value = value;
        }
    }


    // 开户资料文本资料的内容详细类型
    public enum OpenAccountDetailInfoContentType {
        OPEN_ACCOUNT_DETAIL_INFO_CONTENT_TYPE_UNKNOWN(0, 0),                    // 未知
        OPEN_ACCOUNT_DETAIL_INFO_CONTENT_TYPE_CONTACT_INFO(1, 1),               // 联系信息
        OPEN_ACCOUNT_DETAIL_INFO_CONTENT_TYPE_ASSET_AND_INVEST(2, 2),           // 资产与投资情况
        OPEN_ACCOUNT_DETAIL_INFO_CONTENT_TYPE_PERSONAL_INFO(3, 3),              // 个人信息
        OPEN_ACCOUNT_DETAIL_INFO_CONTENT_TYPE_INVESTMENT_EXPERIENCE(4, 4),      // 投资经验
        OPEN_ACCOUNT_DETAIL_INFO_CONTENT_TYPE_DERIVATIVE(5, 5),                 // 衍生品问卷调查
        OPEN_ACCOUNT_DETAIL_INFO_CONTENT_TYPE_OTHER_INFO(6, 6);                 // 其他信息披露


        public static final int OPEN_ACCOUNT_DETAIL_INFO_CONTENT_TYPE_UNKNOWN_VALUE = 0;
        public static final int OPEN_ACCOUNT_DETAIL_INFO_CONTENT_TYPE_CONTACT_INFO_VALUE = 1;
        public static final int OPEN_ACCOUNT_DETAIL_INFO_CONTENT_TYPE_ASSET_AND_INVEST_VALUE = 2;
        public static final int OPEN_ACCOUNT_DETAIL_INFO_CONTENT_TYPE_PERSONAL_INFO_VALUE = 3;
        public static final int OPEN_ACCOUNT_DETAIL_INFO_CONTENT_TYPE_INVESTMENT_EXPERIENCE_VALUE = 4;
        public static final int OPEN_ACCOUNT_DETAIL_INFO_CONTENT_TYPE_DERIVATIVE_VALUE = 5;
        public static final int OPEN_ACCOUNT_DETAIL_INFO_CONTENT_TYPE_OTHER_INFO_VALUE = 6;

        public final int getNumber() {
            return value;
        }

        public static OpenAccountDetailInfoContentType valueOf(int value) {
            switch (value) {
                case 0:
                    return OPEN_ACCOUNT_DETAIL_INFO_CONTENT_TYPE_UNKNOWN;
                case 1:
                    return OPEN_ACCOUNT_DETAIL_INFO_CONTENT_TYPE_CONTACT_INFO;
                case 2:
                    return OPEN_ACCOUNT_DETAIL_INFO_CONTENT_TYPE_ASSET_AND_INVEST;
                case 3:
                    return OPEN_ACCOUNT_DETAIL_INFO_CONTENT_TYPE_PERSONAL_INFO;
                case 4:
                    return OPEN_ACCOUNT_DETAIL_INFO_CONTENT_TYPE_INVESTMENT_EXPERIENCE;
                case 5:
                    return OPEN_ACCOUNT_DETAIL_INFO_CONTENT_TYPE_DERIVATIVE;
                case 6:
                    return OPEN_ACCOUNT_DETAIL_INFO_CONTENT_TYPE_OTHER_INFO;
                default:
                    return null;
            }
        }

        private final int value;

        private OpenAccountDetailInfoContentType(int index, int value) {
            this.value = value;
        }
    }

    // 文件的主业务类型
    public enum FileBusinessPrincipalType {
        FILE_BUSINESS_PRINCIPAL_TYPE_UNKNOW(0, 0),                    // 未知
        FILE_BUSINESS_PRINCIPAL_TYPE_ID_CARD(1, 1),               // 身份证信息
        FILE_BUSINESS_PRINCIPAL_TYPE_GROUP_PHOTO(2, 2),           // 客户见证人合影照
        FILE_BUSINESS_PRINCIPAL_TYPE_OPEN_ACCOUNT_FORM(3, 3);              // 开户表格影像


        public static final int FILE_BUSINESS_PRINCIPAL_TYPE_UNKNOW_VALUE = 0;
        public static final int FILE_BUSINESS_PRINCIPAL_TYPE_ID_CARD_VALUE = 1;
        public static final int FILE_BUSINESS_PRINCIPAL_TYPE_GROUP_PHOTO_VALUE = 2;
        public static final int FILE_BUSINESS_PRINCIPAL_TYPE_OPEN_ACCOUNT_FORM_VALUE = 3;

        public final int getNumber() {
            return value;
        }

        public static FileBusinessPrincipalType valueOf(int value) {
            switch (value) {
                case 0:
                    return FILE_BUSINESS_PRINCIPAL_TYPE_UNKNOW;
                case 1:
                    return FILE_BUSINESS_PRINCIPAL_TYPE_ID_CARD;
                case 2:
                    return FILE_BUSINESS_PRINCIPAL_TYPE_GROUP_PHOTO;
                case 3:
                    return FILE_BUSINESS_PRINCIPAL_TYPE_OPEN_ACCOUNT_FORM;
                default:
                    return null;
            }
        }

        private final int value;

        private FileBusinessPrincipalType(int index, int value) {
            this.value = value;
        }
    }

    // 用户资料完成类型
    public enum UserInfoFinishedType {
        USER_INFO_FINISHED_TYPE_UNKNOWN(0, 0),           // 未知
        USER_INFO_FINISHED_TYPE_ALL(1, 1),               // 全部完成
        USER_INFO_FINISHED_TYPE_TEXT(2, 2),              // 文本资料
        USER_INFO_FINISHED_TYPE_IMAGES(3, 3);            // 影像资料


        public static final int USER_INFO_FINISHED_TYPE_UNKNOWN_VALUE = 0;
        public static final int USER_INFO_FINISHED_TYPE_ALL_VALUE = 1;
        public static final int USER_INFO_FINISHED_TYPE_TEXT_VALUE = 2;
        public static final int USER_INFO_FINISHED_TYPE_IMAGES_VALUE = 3;

        public final int getNumber() {
            return value;
        }

        public static UserInfoFinishedType valueOf(int value) {
            switch (value) {
                case 0:
                    return USER_INFO_FINISHED_TYPE_UNKNOWN;
                case 1:
                    return USER_INFO_FINISHED_TYPE_ALL;
                case 2:
                    return USER_INFO_FINISHED_TYPE_TEXT;
                case 3:
                    return USER_INFO_FINISHED_TYPE_IMAGES;
                default:
                    return null;
            }
        }

        private final int value;

        private UserInfoFinishedType(int index, int value) {
            this.value = value;
        }
    }

    // 文件的主业务类型
    public enum FileBusinessSubordinateType {
        FILE_BUSINESS_SUBORDINATE_TYPE_UNKNOW(0, 0),                                // 未知
        FILE_BUSINESS_SUBORDINATE_TYPE_ID_CARD_POSITIVE_PHOTO(1, 1),                // 身份证正面照
        FILE_BUSINESS_SUBORDINATE_TYPE_ID_CARD_NEGATIVE_PHOTO(2, 2),                // 身份证反面照
        FILE_BUSINESS_SUBORDINATE_TYPE_USER_AND_WITNESSES_GROUP_PHOTO(3, 3),        // 客户见证人合影照
        FILE_BUSINESS_SUBORDINATE_TYPE_OPEN_ACCOUNT_FORM_PHOTO(4, 4),               // 开户表格照
        FILE_BUSINESS_SUBORDINATE_TYPE_USER_SELF_PROVE_FORM_PHOTO(5, 5),            // 自我证明表格照
        FILE_BUSINESS_SUBORDINATE_TYPE_SELF_PROOF_PHOTO(6, 6),                      // 身份证明照
        FILE_BUSINESS_SUBORDINATE_TYPE_W8_FORM_PHOTO(7, 7),                         // W8表格照
        FILE_BUSINESS_SUBORDINATE_TYPE_W9_FORM_PHOTO(8, 8),                         // W9表格照
        FILE_BUSINESS_SUBORDINATE_TYPE_ADDRESS_PROOF_PHOTO(9, 9),                   // 地址证明文件照
        FILE_BUSINESS_SUBORDINATE_TYPE_NOT_FACE_TO_FACE_SIGN(10, 10);               // 非单面签署协议照


        public static final int FILE_BUSINESS_SUBORDINATE_TYPE_UNKNOW_VALUE = 0;
        public static final int FILE_BUSINESS_SUBORDINATE_TYPE_ID_CARD_POSITIVE_PHOTO_VALUE = 1;
        public static final int FILE_BUSINESS_SUBORDINATE_TYPE_ID_CARD_NEGATIVE_PHOTO_VALUE = 2;
        public static final int FILE_BUSINESS_SUBORDINATE_TYPE_USER_AND_WITNESSES_GROUP_PHOTO_VALUE = 3;
        public static final int FILE_BUSINESS_SUBORDINATE_TYPE_OPEN_ACCOUNT_FORM_PHOTO_VALUE = 4;
        public static final int FILE_BUSINESS_SUBORDINATE_TYPE_USER_SELF_PROVE_FORM_PHOTO_VALUE = 5;
        public static final int FILE_BUSINESS_SUBORDINATE_TYPE_SELF_PROOF_PHOTO_VALUE = 6;
        public static final int FILE_BUSINESS_SUBORDINATE_TYPE_W8_FORM_PHOTO_VALUE = 7;
        public static final int FILE_BUSINESS_SUBORDINATE_TYPE_W9_FORM_PHOTO_VALUE = 8;
        public static final int FILE_BUSINESS_SUBORDINATE_TYPE_ADDRESS_PROOF_PHOTO_VALUE = 9;
        public static final int FILE_BUSINESS_SUBORDINATE_TYPE_NOT_FACE_TO_FACE_SIGN_VALUE = 10;

        public final int getNumber() {
            return value;
        }

        public static FileBusinessSubordinateType valueOf(int value) {
            switch (value) {
                case 0:
                    return FILE_BUSINESS_SUBORDINATE_TYPE_UNKNOW;
                case 1:
                    return FILE_BUSINESS_SUBORDINATE_TYPE_ID_CARD_POSITIVE_PHOTO;
                case 2:
                    return FILE_BUSINESS_SUBORDINATE_TYPE_ID_CARD_NEGATIVE_PHOTO;
                case 3:
                    return FILE_BUSINESS_SUBORDINATE_TYPE_USER_AND_WITNESSES_GROUP_PHOTO;
                case 4:
                    return FILE_BUSINESS_SUBORDINATE_TYPE_OPEN_ACCOUNT_FORM_PHOTO;
                case 5:
                    return FILE_BUSINESS_SUBORDINATE_TYPE_USER_SELF_PROVE_FORM_PHOTO;
                case 6:
                    return FILE_BUSINESS_SUBORDINATE_TYPE_SELF_PROOF_PHOTO;
                case 7:
                    return FILE_BUSINESS_SUBORDINATE_TYPE_W8_FORM_PHOTO;
                case 8:
                    return FILE_BUSINESS_SUBORDINATE_TYPE_W9_FORM_PHOTO;
                case 9:
                    return FILE_BUSINESS_SUBORDINATE_TYPE_ADDRESS_PROOF_PHOTO;
                case 10:
                    return FILE_BUSINESS_SUBORDINATE_TYPE_NOT_FACE_TO_FACE_SIGN;
                default:
                    return null;
            }
        }

        private final int value;

        private FileBusinessSubordinateType(int index, int value) {
            this.value = value;
        }
    }


    /**
     * 通用处理结果状态
     */
    public enum WitnessOrderApproveNode {
        WITNESS_ORDER_APPROVE_NODE_UNKNOWN(0, 0),
        WITNESS_ORDER_APPROVE_NODE_WITNESS(1, 1),
        WITNESS_ORDER_APPROVE_NODE_SERVICE(2, 2),
        WITNESS_ORDER_APPROVE_NODE_AE(3, 3),
        WITNESS_ORDER_APPROVE_NODE_RO(4, 4),
        WITNESS_ORDER_APPROVE_NODE_BACKEND_OPEN_ACCOUNT(5, 5),
        WITNESS_ORDER_APPROVE_NODE_END(6, 6);

        public static final int WITNESS_ORDER_APPROVE_NODE_UNKNOWN_VALUE = 0;
        public static final int WITNESS_ORDER_APPROVE_NODE_WITNESS_VALUE = 1;
        public static final int WITNESS_ORDER_APPROVE_NODE_SERVICE_VALUE = 2;
        public static final int WITNESS_ORDER_APPROVE_NODE_AE_VALUE = 3;
        public static final int WITNESS_ORDER_APPROVE_NODE_RO_VALUE = 4;
        public static final int WITNESS_ORDER_APPROVE_NODE_BACKEND_OPEN_ACCOUNT_VALUE = 5;
        public static final int WITNESS_ORDER_APPROVE_NODE_END_VALUE = 6;

        public final int getNumber() {
            return value;
        }

        public static WitnessOrderApproveNode valueOf(int value) {
            switch (value) {
                case 0:
                    return WITNESS_ORDER_APPROVE_NODE_UNKNOWN;
                case 1:
                    return WITNESS_ORDER_APPROVE_NODE_WITNESS;
                case 2:
                    return WITNESS_ORDER_APPROVE_NODE_SERVICE;
                case 3:
                    return WITNESS_ORDER_APPROVE_NODE_AE;
                case 4:
                    return WITNESS_ORDER_APPROVE_NODE_RO;
                case 5:
                    return WITNESS_ORDER_APPROVE_NODE_BACKEND_OPEN_ACCOUNT;
                case 6:
                    return WITNESS_ORDER_APPROVE_NODE_END;
                default:
                    return null;
            }
        }

        private final int value;

        private WitnessOrderApproveNode(int index, int value) {
            this.value = value;
        }

    }

    /**
     * 客户线下见证订单处理步骤
     */
    public enum CustomerProcessingStepType {
        ORDER_PROCESSING_STEP_TYPE_0(0, 0), //等待见证人联系
        ORDER_PROCESSING_STEP_TYPE_1(1, 1), //变更了见证人
        ORDER_PROCESSING_STEP_TYPE_2(2, 2),//见证人已经提交了客户的资料
        ORDER_PROCESSING_STEP_TYPE_3(3, 3),//资料被驳回
        ORDER_PROCESSING_STEP_TYPE_4(4, 4),//客户开户结束,可以进行风批
        ORDER_PROCESSING_STEP_TYPE_5(5, 5),//客户风批结束,完成开户
        ORDER_PROCESSING_STEP_TYPE_7(7, 7),//客户所在地区没有见证人
        ORDER_PROCESSING_STEP_TYPE_9(9, 9);//客户申请信息关闭

        public static final int WORDER_PROCESSING_STEP_TYPE_0_VALUE = 0;
        public static final int WORDER_PROCESSING_STEP_TYPE_1_VALUE = 1;
        public static final int WORDER_PROCESSING_STEP_TYPE_2_VALUE = 2;
        public static final int WORDER_PROCESSING_STEP_TYPE_3_VALUE = 3;
        public static final int WORDER_PROCESSING_STEP_TYPE_4_VALUE = 4;
        public static final int WORDER_PROCESSING_STEP_TYPE_5_VALUE = 5;
        public static final int WORDER_PROCESSING_STEP_TYPE_7_VALUE = 7;
        public static final int WORDER_PROCESSING_STEP_TYPE_9_VALUE = 9;

        public static CustomerProcessingStepType valueOf(int value) {
            switch (value) {
                case 0:
                    return ORDER_PROCESSING_STEP_TYPE_0;
                case 1:
                    return ORDER_PROCESSING_STEP_TYPE_1;
                case 2:
                    return ORDER_PROCESSING_STEP_TYPE_2;
                case 3:
                    return ORDER_PROCESSING_STEP_TYPE_3;
                case 4:
                    return ORDER_PROCESSING_STEP_TYPE_4;
                case 5:
                    return ORDER_PROCESSING_STEP_TYPE_5;
                case 7:
                    return ORDER_PROCESSING_STEP_TYPE_7;
                case 9:
                    return ORDER_PROCESSING_STEP_TYPE_9;
                default:
                    return null;
            }
        }

        private CustomerProcessingStepType(int code, int value) {
            this.code = code;
            this.value = value;
        }

        private int code;
        private int value;

        public int getCode() {
            return code;
        }

        public int getMessage() {
            return value;
        }

    }

    /**
     * 审批业务类型
     */
    public enum ApprovalBusinessType {
        APPROVAL_BUSINESS_TYPE_UNKNOWN(0, 0),    // 未知
        APPROVAL_BUSINESS_TYPE_DERIVATIVES_TRANSACTION(1, 1),    // 衍生品交易权限
        APPROVAL_BUSINESS_TYPE_OPEN_ACCOUNT_USA(2, 2);          // 美股增开户申请

        public static final int APPROVAL_BUSINESS_TYPE_UNKNOWN_VALUE = 0;
        public static final int APPROVAL_BUSINESS_TYPE_DERIVATIVES_TRANSACTION_VALUE = 1;
        public static final int APPROVAL_BUSINESS_TYPE_OPEN_ACCOUNT_USA_VALUE = 2;

        public final int getNumber() {
            return value;
        }

        public static ApprovalBusinessType valueOf(int value) {
            switch (value) {
                case 0:
                    return APPROVAL_BUSINESS_TYPE_UNKNOWN;
                case 1:
                    return APPROVAL_BUSINESS_TYPE_DERIVATIVES_TRANSACTION;
                case 2:
                    return APPROVAL_BUSINESS_TYPE_OPEN_ACCOUNT_USA;
                default:
                    return null;
            }
        }

        private final int value;

        private ApprovalBusinessType(int index, int value) {
            this.value = value;
        }

    }

    /**
     * 任务状态
     */
    public enum TaskStatus {
        TASK_STATUS_UNKNOWN(0, 0),        // 未知
        TASK_STATUS_PROCESS(1, 1),        // 处理中
        TASK_STATUS_SUCCESS(2, 2),        // 已办结
        TASK_STATUS_FAIL(3, 3),           // 失败
        TASK_STATUS_PAUSE(4, 4);          // 暂停

        public static final int TASK_STATUS_UNKNOWN_VALUE = 0;
        public static final int TASK_STATUS_PROCESS_VALUE = 1;
        public static final int TASK_STATUS_SUCCESS_VALUE = 2;
        public static final int TASK_STATUS_FAIL_VALUE = 3;
        public static final int TASK_STATUS_PAUSE_VALUE = 4;


        public final int getNumber() {
            return value;
        }

        public static TaskStatus valueOf(int value) {
            switch (value) {
                case 0:
                    return TASK_STATUS_UNKNOWN;
                case 1:
                    return TASK_STATUS_PROCESS;
                case 2:
                    return TASK_STATUS_SUCCESS;
                case 3:
                    return TASK_STATUS_FAIL;
                case 4:
                    return TASK_STATUS_PAUSE;
                default:
                    return null;
            }
        }

        private final int value;

        private TaskStatus(int index, int value) {
            this.value = value;
        }

    }


    /**
     * 任务的业务类型
     */
    public enum TaskBusinessType {
        TASK_BUSINESS_TYPE_UNKNOWN(0, 0),        // 未知
        TASK_BUSINESS_TYPE_DERIVATIVES_AUTHORIZATION(1, 1),        // 衍生品授权
        TASK_BUSINESS_TYPE_SECURITIES_USER_DATA_SYNC(2, 2),        // 证券用户数据同步
        TASK_BUSINESS_TYPE_OPEN_USA_STOCK_MARKET(3, 3),           // 美股增开户
        TASK_BUSINESS_TYPE_DERIVATIVES_RESTRICT(4, 4);            // 限制衍生品交易

        public static final int TASK_BUSINESS_TYPE_UNKNOWN_VALUE = 0;
        public static final int TASK_BUSINESS_TYPE_DERIVATIVES_AUTHORIZATION_VALUE = 1;
        public static final int TASK_BUSINESS_TYPE_SECURITIES_USER_DATA_SYNC_VALUE = 2;
        public static final int TASK_BUSINESS_TYPE_OPEN_USA_STOCK_MARKET_VALUE = 3;
        public static final int TASK_BUSINESS_TYPE_DERIVATIVES_RESTRICT_VALUE = 4;

        public final int getNumber() {
            return value;
        }

        public static TaskBusinessType valueOf(int value) {
            switch (value) {
                case 0:
                    return TASK_BUSINESS_TYPE_UNKNOWN;
                case 1:
                    return TASK_BUSINESS_TYPE_DERIVATIVES_AUTHORIZATION;
                case 2:
                    return TASK_BUSINESS_TYPE_SECURITIES_USER_DATA_SYNC;
                case 3:
                    return TASK_BUSINESS_TYPE_OPEN_USA_STOCK_MARKET;
                case 4:
                    return TASK_BUSINESS_TYPE_DERIVATIVES_RESTRICT;
                default:
                    return null;
            }
        }

        private final int value;

        private TaskBusinessType(int index, int value) {
            this.value = value;
        }

    }

    /**
     * 审批业务类型名称
     */
    public enum ApprovalBusinessName {

        APPROVAL_BUSINESS_NAME_UNKNOWN(0, "未知"),    // 未知
        APPROVAL_BUSINESS_NAME_DERIVATIVES_TRANSACTION(1, "衍生品授权"),    // 衍生品授权
        APPROVAL_BUSINESS_NAME_OPEN_ACCOUNT_USA(2, "美股增开户");          // 美股增开户

        private final int index;
        private final String name;

        private ApprovalBusinessName(int index, String name) {
            this.index = index;
            this.name = name;
        }

        public static String getName(int index) {
            for (ApprovalBusinessName c : ApprovalBusinessName.values()) {
                if (c.getIndex() == index) {
                    return c.name;
                }
            }
            return null;
        }

        public int getIndex() {
            return index;
        }

        public String getName() {
            return name;
        }
    }

    /**
     * 限制业务类型
     */
    public enum RestrictBusinessType {
        RESTRICT_BUSINESS_TYPE_UNKNOWN(0, 0),        // 未知
        RESTRICT_BUSINESS_TYPE_DERIVATIVES_PRODUCTS(1, 1);        // 衍生品产品

        public static final int RESTRICT_BUSINESS_TYPE_UNKNOWN_VALUE = 0;
        public static final int RESTRICT_BUSINESS_TYPE_DERIVATIVES_PRODUCTS_VALUE = 1;

        public final int getNumber() {
            return value;
        }

        public static RestrictBusinessType valueOf(int value) {
            switch (value) {
                case 0:
                    return RESTRICT_BUSINESS_TYPE_UNKNOWN;
                case 1:
                    return RESTRICT_BUSINESS_TYPE_DERIVATIVES_PRODUCTS;
                default:
                    return null;
            }
        }

        private final int value;

        private RestrictBusinessType(int index, int value) {
            this.value = value;
        }

    }

    /**
     * 消息通知类型
     */
    public enum MessageNoticeType {
        MESSAGE_NOTICE_TYPE_UNKNOWN(0, 0),              // 未知
        MESSAGE_NOTICE_TYPE_EMAIL(1, 1),                // 邮件
        MESSAGE_NOTICE_TYPE_SMS(2, 2),                  // 短信
        MESSAGE_NOTICE_TYPE_PLATFORM_SEND_SMS(3, 3);    // 统一消息中心推送接口

        public static final int MESSAGE_NOTICE_TYPE_UNKNOWN_VALUE = 0;
        public static final int MESSAGE_NOTICE_TYPE_EMAIL_VALUE = 1;
        public static final int MESSAGE_NOTICE_TYPE_SMS_VALUE = 2;
        public static final int MESSAGE_NOTICE_TYPE_PLATFORM_SEND_SMS_VALUE = 3;

        public final int getNumber() {
            return value;
        }

        public static MessageNoticeType valueOf(int value) {
            switch (value) {
                case 0:
                    return MESSAGE_NOTICE_TYPE_UNKNOWN;
                case 1:
                    return MESSAGE_NOTICE_TYPE_EMAIL;
                case 2:
                    return MESSAGE_NOTICE_TYPE_SMS;
                case 3:
                    return MESSAGE_NOTICE_TYPE_PLATFORM_SEND_SMS;
                default:
                    return null;
            }
        }

        private final int value;

        private MessageNoticeType(int index, int value) {
            this.value = value;
        }

    }

    /**
     * 开户资料报表
     */
    public enum AccountOpenReport {
        ACCOUNT_OPEN_REPORT_USER_FORM_REPORT(1, 1), // 开户报表
        ACCOUNT_OPEN_REPORT_USER_W8_REPORT(2, 2),   // W8报表
        ACCOUNT_OPEN_REPORT_USER_SELF_PROVE_REPORT(3, 3), // 自我证明报表
        ACCOUNT_OPEN_REPORT_USER_SELF_CERTIFICATION_ON_US_REPORT(4, 4); // 美国公民身份证明报表


        public static final int ACCOUNT_OPEN_REPORT_USER_FORM_REPORT_VALUE = 1;
        public static final int ACCOUNT_OPEN_REPORT_USER_W8_REPORT_VALUE = 2;
        public static final int ACCOUNT_OPEN_REPORT_USER_SELF_PROVE_REPORT_VALUE = 3;
        public static final int ACCOUNT_OPEN_REPORT_USER_SELF_CERTIFICATION_ON_US_REPORT_VALUE = 4;

        public final int getNumber() {
            return value;
        }

        public static AccountOpenReport valueOf(int value) {
            switch (value) {
                case 0:
                    return ACCOUNT_OPEN_REPORT_USER_FORM_REPORT;
                case 1:
                    return ACCOUNT_OPEN_REPORT_USER_W8_REPORT;
                case 2:
                    return ACCOUNT_OPEN_REPORT_USER_SELF_PROVE_REPORT;
                case 3:
                    return ACCOUNT_OPEN_REPORT_USER_SELF_CERTIFICATION_ON_US_REPORT;
                default:
                    return null;
            }
        }

        private final int value;

        private AccountOpenReport(int index, int value) {
            this.value = value;
        }

    }

    /**
     * 开户资料报表
     */
    public enum AccountOpenReportTest {
        ACCOUNT_OPEN_REPORT_USER_FORM_REPORT(1, "开户报表"), // 开户报表
        ACCOUNT_OPEN_REPORT_USER_W8_REPORT(2, "W8报表"),   // W8报表
        ACCOUNT_OPEN_REPORT_USER_SELF_PROVE_REPORT(3, "自我证明报表"), // 自我证明报表
        ACCOUNT_OPEN_REPORT_USER_SELF_CERTIFICATION_ON_US_REPORT(4, "美国公民身份证明报表"); // 美国公民身份证明报表


        public static final int ACCOUNT_OPEN_REPORT_USER_FORM_REPORT_VALUE = 1;
        public static final int ACCOUNT_OPEN_REPORT_USER_W8_REPORT_VALUE = 2;
        public static final int ACCOUNT_OPEN_REPORT_USER_SELF_PROVE_REPORT_VALUE = 3;
        public static final int ACCOUNT_OPEN_REPORT_USER_SELF_CERTIFICATION_ON_US_REPORT_VALUE = 4;

        public final int getIndex() {
            return index;
        }

        public final String getDescription() {
            return value;
        }


        public static AccountOpenReportTest valueOf(int index) {
            switch (index) {
                case 0:
                    return ACCOUNT_OPEN_REPORT_USER_FORM_REPORT;
                case 1:
                    return ACCOUNT_OPEN_REPORT_USER_W8_REPORT;
                case 2:
                    return ACCOUNT_OPEN_REPORT_USER_SELF_PROVE_REPORT;
                case 3:
                    return ACCOUNT_OPEN_REPORT_USER_SELF_CERTIFICATION_ON_US_REPORT;
                default:
                    return null;
            }
        }

        private final int index;
        private final String value;


        private AccountOpenReportTest(int index, String value) {
            this.index = index;
            this.value = value;
        }

    }


    /**
     * 预约申请状态
     */
    public enum ApplicationStatus {
        /**
         * 未知
         */
        APPLICATION_STATUS_UNKNOW(0, 0),
        /**
         * 初审中
         */
        APPLICATION_STATUS_INITIAL_AUDIT(1, 1),
        /**
         * 复审中
         */
        APPLICATION_STATUS_RECHECK_AUDIT(2, 2),
        /**
         * 终审中
         */
        APPLICATION_STATUS_FINAL_AUDIT(3, 3),
        /**
         * 预批成功
         */
        APPLICATION_STATUS_APPROVAL_SUCCESS(4, 4),
        /**
         * 预批失败
         */
        APPLICATION_STATUS_APPROVAL_FAILURE(5, 5),
        /**
         * 已开户
         */
        APPLICATION_STATUS_OPEN_ACCOUNT(6, 6),
        /**
         * 已退回
         */
        APPLICATION_STATUS_RETURN_BACK(7, 7),
        /**
         * 已终止
         */
        APPLICATION_STATUS_APPROVAL_TERMINATION(8, 8),
        /**
         * 已拒绝
         */
        APPLICATION_STATUS_APPROVAL_REJECT(9, 9),
        /**
         * 已拒绝(加入黑名单)
         */
        APPLICATION_STATUS_REJECT_BLACKLIST(10, 10),
        /**
         * 预批中
         */
        APPLICATION_STATUS_APPROVAL_PROGRESS(11, 11),
        /**
         * 电子证书申请中
         */
        APPLICATION_STATUS_CA_VERIFY_PROGRESS(12, 12),
        /**
         * 电子证书申请成功
         */
        APPLICATION_STATUS_CA_VERIFY_SUCCESS(13, 13),
        /**
         * 电子证书申请失败
         */
        APPLICATION_STATUS_CA_VERIFY_FAILURE(14, 14);


        public static final int APPLICATION_STATUS_UNKNOW_VALUE = 0;
        public static final int APPLICATION_STATUS_INITIAL_AUDIT_VALUE = 1;
        public static final int APPLICATION_STATUS_RECHECK_AUDIT_VALUE = 2;
        public static final int APPLICATION_STATUS_FINAL_AUDIT_VALUE = 3;
        public static final int APPLICATION_STATUS_APPROVAL_SUCCESS_VALUE = 4;
        public static final int APPLICATION_STATUS_APPROVAL_FAILURE_VALUE = 5;
        public static final int APPLICATION_STATUS_OPEN_ACCOUNT_VALUE = 6;
        public static final int APPLICATION_STATUS_RETURN_BACK_VALUE = 7;
        public static final int APPLICATION_STATUS_APPROVAL_TERMINATION_VALUE = 8;
        public static final int APPLICATION_STATUS_APPROVAL_REJECT_VALUE = 9;
        public static final int APPLICATION_STATUS_REJECT_BLACKLIST_VALUE = 10;
        public static final int APPLICATION_STATUS_APPROVAL_PROGRESS_VALUE = 11;
        public static final int APPLICATION_STATUS_CA_VERIFY_PROGRESS_VALUE = 12;
        public static final int APPLICATION_STATUS_CA_VERIFY_SUCCESS_VALUE = 13;
        public static final int APPLICATION_STATUS_CA_VERIFY_FAILURE_VALUE = 14;

        public final int getNumber() {
            return value;
        }

        public static ApplicationStatus valueOf(int value) {
            switch (value) {
                case 0:
                    return APPLICATION_STATUS_UNKNOW;
                case 1:
                    return APPLICATION_STATUS_INITIAL_AUDIT;
                case 2:
                    return APPLICATION_STATUS_RECHECK_AUDIT;
                case 3:
                    return APPLICATION_STATUS_FINAL_AUDIT;
                case 4:
                    return APPLICATION_STATUS_APPROVAL_SUCCESS;
                case 5:
                    return APPLICATION_STATUS_APPROVAL_FAILURE;
                case 6:
                    return APPLICATION_STATUS_OPEN_ACCOUNT;
                case 7:
                    return APPLICATION_STATUS_RETURN_BACK;
                case 8:
                    return APPLICATION_STATUS_APPROVAL_TERMINATION;
                case 9:
                    return APPLICATION_STATUS_APPROVAL_REJECT;
                case 10:
                    return APPLICATION_STATUS_REJECT_BLACKLIST;
                case 11:
                    return APPLICATION_STATUS_APPROVAL_PROGRESS;
                default:
                    return null;
            }
        }

        private final int value;

        private ApplicationStatus(int index, int value) {
            this.value = value;
        }

    }

    /**
     * 赠股申请状态
     */
    public enum DonatedStockApplicationStatus {
        /**
         * 未知
         */
        DONATED_STK_APPLICATE_STATUS_UNKNOW(0, 0),
        /**
         * 待初审
         */
        DONATED_STK_APPLICATE_STATUS_INITIAL_AUDIT(1, 1),
        /**
         * 待复审
         */
        DONATED_STK_APPLICATE_STATUS_RECHECK_AUDIT(2, 2),
        /**
         * 已通过
         */
        DONATED_STK_APPLICATE_STATUS_PASS(3, 3),
        /**
         * 已拒绝
         */
        DONATED_STK_APPLICATE_STATUS_APPROVAL_REJECT(4, 4);


        public static final int DONATED_STK_APPLICATE_STATUS_UNKNOW_VALUE = 0;
        public static final int DONATED_STK_APPLICATE_STATUS_INITIAL_AUDIT_VALUE = 1;
        public static final int DONATED_STK_APPLICATE_STATUS_RECHECK_AUDIT_VALUE = 2;
        public static final int DONATED_STK_APPLICATE_STATUS_PASS_VALUE = 3;
        public static final int DONATED_STK_APPLICATE_STATUS_APPROVAL_REJECT_VALUE = 4;

        public final int getNumber() {
            return value;
        }

        public static DonatedStockApplicationStatus valueOf(int value) {
            switch (value) {
                case 0:
                    return DONATED_STK_APPLICATE_STATUS_UNKNOW;
                case 1:
                    return DONATED_STK_APPLICATE_STATUS_INITIAL_AUDIT;
                case 2:
                    return DONATED_STK_APPLICATE_STATUS_RECHECK_AUDIT;
                case 3:
                    return DONATED_STK_APPLICATE_STATUS_PASS;
                case 4:
                    return DONATED_STK_APPLICATE_STATUS_APPROVAL_REJECT;
                default:
                    return null;
            }
        }

        private final int value;

        private DonatedStockApplicationStatus(int index, int value) {
            this.value = value;
        }
    }

    /**
     * 打印状态
     */
    public enum PrintStatus {
        /**
         * 未打印
         */
        PRINT_STATUS_NO(1, 1),

        /**
         * 已打印
         */
        PRINT_STATUS_YES(2, 2);


        public static final int PRINT_STATUS_NO_VALUE = 1;
        public static final int PRINT_STATUS_YES_VALUE = 2;

        public final int getNumber() {
            return value;
        }

        public static PrintStatus valueOf(int value) {
            switch (value) {
                case 1:
                    return PRINT_STATUS_NO;
                case 2:
                    return PRINT_STATUS_YES;
                default:
                    return null;
            }
        }

        private final int value;

        private PrintStatus(int index, int value) {
            this.value = value;
        }

    }

    /**
     * 印花税状态
     */
    public enum StampDutyStatus {
        /**
         * 待缴纳
         */
        STAMP_DUTY_STATUS_NO(1, 1),

        /**
         * 已缴纳
         */
        STAMP_DUTY_STATUS_YES(2, 2);


        public static final int STAMP_DUTY_STATUS_NO_VALUE = 1;
        public static final int STAMP_DUTY_STATUS_YES_VALUE = 2;

        public final int getNumber() {
            return value;
        }

        public static StampDutyStatus valueOf(int value) {
            switch (value) {
                case 1:
                    return STAMP_DUTY_STATUS_NO;
                case 2:
                    return STAMP_DUTY_STATUS_YES;
                default:
                    return null;
            }
        }

        private final int value;

        private StampDutyStatus(int index, int value) {
            this.value = value;
        }

    }

    /**
     * 入账状态
     */
    public enum AccountEntryStatus {

        /**
         * 待入账
         */
        ACCOUNT_ENTRY_STATUS_NO(1, 1),

        /**
         * 已入账
         */
        ACCOUNT_ENTRY_STATUS_YES(2, 2),

        /**
         * 入账失败
         */
        ACCOUNT_ENTRY_STATUS_FAIL(3, 3),

        /**
         * 入账中
         */
        ACCOUNT_ENTRY_STATUS_DEALING(4, 4);

        public static final int ACCOUNT_ENTRY_STATUS_NO_VALUE = 1;
        public static final int ACCOUNT_ENTRY_STATUS_YES_VALUE = 2;
        public static final int ACCOUNT_ENTRY_STATUS_FAIL_VALUE = 3;
        public static final int ACCOUNT_ENTRY_STATUS_DEALING_VALUE = 4;

        public final int getNumber() {
            return value;
        }

        public static AccountEntryStatus valueOf(int value) {
            switch (value) {
                case 1:
                    return ACCOUNT_ENTRY_STATUS_NO;
                case 2:
                    return ACCOUNT_ENTRY_STATUS_YES;
                case 3:
                    return ACCOUNT_ENTRY_STATUS_FAIL;
                case 4:
                    return ACCOUNT_ENTRY_STATUS_DEALING;
                default:
                    return null;
            }
        }

        private final int value;

        private AccountEntryStatus(int index, int value) {
            this.value = value;
        }
    }


    /**
     * 出金申请状态
     */
    public enum FundWithdrawApplicationStatus {
        /**
         * 提交
         */
        FUND_WITHDRAW_APPLY_STATUS_UNKNOW(0, 0),
        /**
         * 初审中
         */
        FUND_WITHDRAW_APPLY_STATUS_INITIAL_AUDIT(1, 1),
        /**
         * 复审中
         */
        FUND_WITHDRAW_APPLY_RECHECK_AUDIT(2, 2),
        /**
         * 待汇款
         */
        FUND_WITHDRAW_APPLY_REMIT_MONEY(3, 3),
        /**
         * 待出账
         */
        FUND_WITHDRAW_APPLY_FINAL_AUDIT(4, 4),
        /**
         * 汇款成功
         */
        FUND_WITHDRAW_APPLY_STATUS_SUCCESS(5, 5),
        /**
         * 汇款失败
         */
        FUND_WITHDRAW_APPLY_STATUS_FAILURE(6, 6),
        /**
         * 已完成
         */
        FUND_WITHDRAW_APPLY_STATUS_PASS(7, 7),
        /**
         * 已拒绝
         */
        FUND_WITHDRAW_APPLY_APPROVAL_REJECT(8, 8),
        /**
         * 已取消
         */
        FUND_WITHDRAW_APPLY_APPROVAL_CANCEL(9, 9),
        /**
         * 退款待入账
         */
        FUND_WITHDRAW_APPLY_REFUND_PROGRESS(10, 10),
        /**
         * 退款已入账
         */
        FUND_WITHDRAW_APPLY_REFUND_SUCCESS(11, 11);


        public static final int FUND_WITHDRAW_APPLY_STATUS_UNKNOW_VALUE = 0;
        public static final int FUND_WITHDRAW_APPLY_STATUS_INITIAL_AUDIT_VALUE = 1;
        public static final int FUND_WITHDRAW_APPLY_RECHECK_AUDIT_VALUE = 2;
        public static final int FUND_WITHDRAW_APPLY_REMIT_MONEY_VALUE = 3;
        public static final int FUND_WITHDRAW_APPLY_FINAL_AUDIT_VALUE = 4;
        public static final int FUND_WITHDRAW_APPLY_STATUS_SUCCESS_VALUE = 5;
        public static final int FUND_WITHDRAW_APPLY_STATUS_FAILURE_VALUE = 6;
        public static final int FUND_WITHDRAW_APPLY_STATUS_PASS_VALUE = 7;
        public static final int FUND_WITHDRAW_APPLY_APPROVAL_REJECT_VALUE = 8;
        public static final int FUND_WITHDRAW_APPLY_APPROVAL_CANCEL_VALUE = 9;
        public static final int FUND_WITHDRAW_APPLY_REFUND_PROGRESS_VALUE = 10;
        public static final int FUND_WITHDRAW_APPLY_REFUND_SUCCESS_VALUE = 11;

        public final int getNumber() {
            return value;
        }

        public static FundWithdrawApplicationStatus valueOf(int value) {
            switch (value) {
                case 0:
                    return FUND_WITHDRAW_APPLY_STATUS_UNKNOW;
                case 1:
                    return FUND_WITHDRAW_APPLY_STATUS_INITIAL_AUDIT;
                case 2:
                    return FUND_WITHDRAW_APPLY_RECHECK_AUDIT;
                case 3:
                    return FUND_WITHDRAW_APPLY_REMIT_MONEY;
                case 4:
                    return FUND_WITHDRAW_APPLY_FINAL_AUDIT;
                case 5:
                    return FUND_WITHDRAW_APPLY_STATUS_SUCCESS;
                case 6:
                    return FUND_WITHDRAW_APPLY_STATUS_FAILURE;
                case 7:
                    return FUND_WITHDRAW_APPLY_STATUS_PASS;
                case 8:
                    return FUND_WITHDRAW_APPLY_APPROVAL_REJECT;
                case 9:
                    return FUND_WITHDRAW_APPLY_APPROVAL_CANCEL;
                case 10:
                    return FUND_WITHDRAW_APPLY_REFUND_PROGRESS;
                case 11:
                    return FUND_WITHDRAW_APPLY_REFUND_SUCCESS;
                default:
                    return null;
            }
        }

        private final int value;

        private FundWithdrawApplicationStatus(int index, int value) {
            this.value = value;
        }
    }

    /**
     * 出金结果状态
     */
    public enum FundWithdrawStatus {
        /**
         * 未知
         */
        FUND_WITHDRAW_STATUS_UNKNOW(0, 0),
        /**
         * 出金成功
         */
        FUND_WITHDRAW_STATUS_SUCCESS(5, 5),
        /**
         * 出金失败
         */
        FUND_WITHDRAW_STATUS_FAILURE(6, 6);


        public static final int FUND_WITHDRAW_STATUS_UNKNOW_VALUE = 0;
        public static final int FUND_WITHDRAW_STATUS_SUCCESS_VALUE = 5;
        public static final int FUND_WITHDRAW_STATUS_FAILURE_VALUE = 6;

        public final int getNumber() {
            return value;
        }

        public static FundWithdrawStatus valueOf(int value) {
            switch (value) {
                case 0:
                    return FUND_WITHDRAW_STATUS_UNKNOW;
                case 5:
                    return FUND_WITHDRAW_STATUS_SUCCESS;
                case 6:
                    return FUND_WITHDRAW_STATUS_FAILURE;
                default:
                    return null;
            }
        }

        private final int value;

        private FundWithdrawStatus(int index, int value) {
            this.value = value;
        }
    }

    /**
     * 出金退款申请状态
     */
    public enum FundWithdrawRefundApplicationStatus {
        /**
         * 提交
         */
        FUND_WITHDRAW_REFUND_APPLY_STATUS_UNKNOW(0, 0),
        /**
         * 退款待入账
         */
        FUND_WITHDRAW_REFUND_APPLY_STATUS_PROGRESS(1, 1),
        /**
         * 退款已入账
         */
        FUND_WITHDRAW_REFUND_APPLY_STATUS_SUCCESS(2, 2),
        /**
         * 退款不匹配
         */
        FUND_WITHDRAW_REFUND_APPLY_STATUS_FAILURE(3, 3);


        public static final int FUND_WITHDRAW_APPLY_STATUS_UNKNOW_VALUE = 0;
        public static final int FUND_WITHDRAW_REFUND_APPLY_STATUS_PROGRESS_VALUE = 1;
        public static final int FUND_WITHDRAW_REFUND_APPLY_STATUS_SUCCESS_VALUE = 2;
        public static final int FUND_WITHDRAW_REFUND_APPLY_STATUS_FAILURE_VALUE = 3;

        public final int getNumber() {
            return value;
        }

        public static FundWithdrawRefundApplicationStatus valueOf(int value) {
            switch (value) {
                case 0:
                    return FUND_WITHDRAW_REFUND_APPLY_STATUS_UNKNOW;
                case 1:
                    return FUND_WITHDRAW_REFUND_APPLY_STATUS_PROGRESS;
                case 2:
                    return FUND_WITHDRAW_REFUND_APPLY_STATUS_SUCCESS;
                case 3:
                    return FUND_WITHDRAW_REFUND_APPLY_STATUS_FAILURE;
                default:
                    return null;
            }
        }

        private final int value;

        private FundWithdrawRefundApplicationStatus(int index, int value) {
            this.value = value;
        }
    }

    /**
     * 入金申请状态
     */
    public enum FundDepositApplicationStatus {
        /**
         * 未知
         */
        FUND_DEPOSIT_APPLY_STATUS_UNKNOW(0, 0),
        /**
         * 待处理
         */
        FUND_DEPOSIT_APPLY_STATUS_WAIT(1, 1),
        /**
         * 初审中，作废
         */
        FUND_DEPOSIT_APPLY_STATUS_DEAL(2, 2),
        /**
         * 审核中
         */
        FUND_DEPOSIT_APPLY_STATUS_CHECK(3, 3),
        /**
         * 待入账
         */
        FUND_DEPOSIT_APPLY_STATUS_ENTRY_WAIT(4, 4),
        /**
         * 入账中
         */
        FUND_DEPOSIT_APPLY_STATUS_ENTRY(5, 5),
        /**
         * 已入账
         */
        FUND_DEPOSIT_APPLY_STATUS_SUCCESS(6, 6),
        /**
         * 退回客服,作废
         */
        FUND_DEPOSIT_APPLY_STATUS_BACK(7, 7),
        /**
         * 退回客户
         */
        FUND_DEPOSIT_APPLY_STATUS_REJECT(8, 8),
        /**
         * 入账失败
         */
        FUND_DEPOSIT_APPLY_STATUS_FAIL(9, 9),

        /**
         * 已忽略
         */
        FUND_DEPOSIT_APPLY_STATUS_IGNORE(10, 10);

        public static final int FUND_DEPOSIT_APPLY_STATUS_UNKNOW_VALUE = 0;
        public static final int FUND_DEPOSIT_APPLY_STATUS_WAIT_VALUE = 1;
        public static final int FUND_DEPOSIT_APPLY_STATUS_DEAL_VALUE = 2;
        public static final int FUND_DEPOSIT_APPLY_STATUS_CHECK_VALUE = 3;
        public static final int FUND_DEPOSIT_APPLY_STATUS_ENTRY_WAIT_VALUE = 4;
        public static final int FUND_DEPOSIT_APPLY_STATUS_ENTRY_VALUE = 5;
        public static final int FUND_DEPOSIT_APPLY_STATUS_SUCCESS_VALUE = 6;
        public static final int FUND_DEPOSIT_APPLY_STATUS_BACK_VALUE = 7;
        public static final int FUND_DEPOSIT_APPLY_STATUS_REJECT_VALUE = 8;
        public static final int FUND_DEPOSIT_APPLY_STATUS_FAIL_VALUE = 9;
        public static final int FUND_DEPOSIT_APPLY_STATUS_IGNORE_VALUE = 10;

        public final int getNumber() {
            return value;
        }

        public static FundDepositApplicationStatus valueOf(int value) {
            switch (value) {
                case 0:
                    return FUND_DEPOSIT_APPLY_STATUS_UNKNOW;
                case 1:
                    return FUND_DEPOSIT_APPLY_STATUS_WAIT;
                case 2:
                    return FUND_DEPOSIT_APPLY_STATUS_DEAL;
                case 3:
                    return FUND_DEPOSIT_APPLY_STATUS_CHECK;
                case 4:
                    return FUND_DEPOSIT_APPLY_STATUS_ENTRY_WAIT;
                case 5:
                    return FUND_DEPOSIT_APPLY_STATUS_ENTRY;
                case 6:
                    return FUND_DEPOSIT_APPLY_STATUS_SUCCESS;
                case 7:
                    return FUND_DEPOSIT_APPLY_STATUS_BACK;
                case 8:
                    return FUND_DEPOSIT_APPLY_STATUS_REJECT;
                case 9:
                    return FUND_DEPOSIT_APPLY_STATUS_FAIL;
                case 10:
                    return FUND_DEPOSIT_APPLY_STATUS_IGNORE;
                default:
                    return null;
            }
        }

        private final int value;

        private FundDepositApplicationStatus(int index, int value) {
            this.value = value;
        }
    }

    /**
     * 入金申请状态
     */
    public enum ProfessionalApplicationStatus {
        /**
         * 未知
         */
        PROFESSIONAL_APPLY_STATUS_UNKNOW(0, 0),
        /**
         * 初审中
         */
        PROFESSIONAL_APPLY_STATUS_INITCHECK(1, 1),
        /**
         * 复审中
         */
        PROFESSIONAL_APPLY_STATUS_RECHECK(2, 2),
        /**
         * 认定成功
         */
        PROFESSIONAL_APPLY_STATUS_SUCCESS(3, 3),
        /**
         * 已退回
         */
        PROFESSIONAL_APPLY_STATUS_BACK(4, 4),
        /**
         * 已终止
         */
        PROFESSIONAL_APPLY_STATUS_TERMINATION(5, 5),
        /**
         * 已撤销
         */
        PROFESSIONAL_APPLY_STATUS_REVOKE(6, 6),
        /**
         * 已失效
         */
        PROFESSIONAL_APPLY_STATUS_INVALID(7, 7),

        /**
         * 即将失效
         */
        PROFESSIONAL_APPLY_STATUS_WELL_INVALID(8, 8);

        public static final int PROFESSIONAL_APPLY_STATUS_UNKNOW_VALIUE = 0;
        public static final int PROFESSIONAL_APPLY_STATUS_INITCHECK_VALIUE = 1;
        public static final int PROFESSIONAL_APPLY_STATUS_RECHECK_VALIUE = 2;
        public static final int PROFESSIONAL_APPLY_STATUS_SUCCESS_VALIUE = 3;
        public static final int PROFESSIONAL_APPLY_STATUS_BACK_VALIUE = 4;
        public static final int PROFESSIONAL_APPLY_STATUS_TERMINATION_VALIUE = 5;
        public static final int PROFESSIONAL_APPLY_STATUS_REVOKE_VALIUE = 6;
        public static final int PROFESSIONAL_APPLY_STATUS_INVALID_VALIUE = 7;
        public static final int PROFESSIONAL_APPLY_STATUS_WELL_INVALID_VALIUE = 8;

        public final int getNumber() {
            return value;
        }

        public static ProfessionalApplicationStatus valueOf(int value) {
            switch (value) {
                case 0:
                    return PROFESSIONAL_APPLY_STATUS_UNKNOW;
                case 1:
                    return PROFESSIONAL_APPLY_STATUS_INITCHECK;
                case 2:
                    return PROFESSIONAL_APPLY_STATUS_RECHECK;
                case 3:
                    return PROFESSIONAL_APPLY_STATUS_SUCCESS;
                case 4:
                    return PROFESSIONAL_APPLY_STATUS_BACK;
                case 5:
                    return PROFESSIONAL_APPLY_STATUS_TERMINATION;
                case 6:
                    return PROFESSIONAL_APPLY_STATUS_REVOKE;
                case 7:
                    return PROFESSIONAL_APPLY_STATUS_INVALID;
                case 8:
                    return PROFESSIONAL_APPLY_STATUS_WELL_INVALID;
                default:
                    return null;
            }
        }

        private final int value;

        private ProfessionalApplicationStatus(int index, int value) {
            this.value = value;
        }
    }
}
