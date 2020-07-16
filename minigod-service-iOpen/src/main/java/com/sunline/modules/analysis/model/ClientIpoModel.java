package com.sunline.modules.analysis.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @description: 打新查询导出Excel模板
 * @author: fuyy
 * @date: 2018/11/28
 * @version: v1.0
 */
@Data
public class ClientIpoModel extends BaseRowModel {

    @ExcelProperty(value = "序号" ,index = 0)
    private String id;

    @ExcelProperty(value = "小神号" ,index = 1)
    private String userId;

    @ExcelProperty(value = "客户姓名" ,index = 2)
    private String clientName;

    @ExcelProperty(value = "手机号码" ,index = 3)
    private String phoneNumber;

    @ExcelProperty(value = "交易帐号" ,index = 4)
    private String clientId;

    @ExcelProperty(value = "资金帐号" ,index = 5)
    private String fundAccount;

    @ExcelProperty(value = "渠道" ,index = 6)
    private String channelId;

    @ExcelProperty(value = "认购日期" ,index = 7)
    private String currDate;

    @ExcelProperty(value = "证券代码" ,index = 8)
    private String stockCode;

    @ExcelProperty(value = "证券市场" ,index = 9)
    private String exchangeType;

    @ExcelProperty(value = "认购方式" ,index = 10)
    private String type;

    @ExcelProperty(value = "申购状态" ,index = 11)
    private String status;

    @ExcelProperty(value = "申购数量" ,index = 12)
    private String quantityApply;

    @ExcelProperty(value = "总申购金额" ,index = 13)
    private String applyAmount;

    @ExcelProperty(value = "申购资金比例" ,index = 14)
    private String depositRate;

    @ExcelProperty(value = "客户申购资金" ,index = 15)
    private String depositAmount;

    @ExcelProperty(value = "中签数量" ,index = 16)
    private String quantityAllotted;

    @ExcelProperty(value = "IPO利率" ,index = 17)
    private String ipoIntrate;

    @ExcelProperty(value = "中签金额" ,index = 18)
    private BigDecimal finalAmount;

    @ExcelProperty(value = "手续费" ,index = 19)
    private BigDecimal handlingFee;

    @ExcelProperty(value = "融资利息" ,index = 20)
    private BigDecimal financingAmount;

    @ExcelProperty(value = "截至日期" ,index = 21)
    private String cutoffDate;

    @ExcelProperty(value = "上市日期" ,index = 22)
    private String tradingDate;

}
