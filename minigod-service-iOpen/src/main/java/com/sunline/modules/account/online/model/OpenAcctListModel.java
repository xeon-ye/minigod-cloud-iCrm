package com.sunline.modules.account.online.model;


import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @description: 开户记录导出model
 * @author: lcs
 * @date: 2019/02/20
 * @version: v1.0
 */
@Data
public class OpenAcctListModel extends BaseRowModel {

    @ExcelProperty(value = "序号" ,index = 0)
    private String id;
    @ExcelProperty(value = "预约号" ,index = 1)
    private String applicationId;
    @ExcelProperty(value = "申请时间" ,index = 2)
    private String applicationTime;
    @ExcelProperty(value = "开户途径" ,index = 3)
    private String openAccountType;
    @ExcelProperty(value = "小神号" ,index = 4)
    private String userId;
    @ExcelProperty(value = "客户姓名" ,index = 5)
    private String clientName;
    @ExcelProperty(value = "证件类型" ,index = 6)
    private String idKind;
    @ExcelProperty(value = "手机号码" ,index = 7)
    private String phoneNo;
    @ExcelProperty(value = "渠道" ,index = 8)
    private String channelId;
    @ExcelProperty(value = "开户状态" ,index = 9)
    private String applicationStatus;
    @ExcelProperty(value = "账户等级" ,index = 10)
    private String accountLevel;
    @ExcelProperty(value = "退回理由" ,index = 11)
    private String backReason;



}
