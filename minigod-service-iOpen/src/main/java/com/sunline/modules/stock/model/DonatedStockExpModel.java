package com.sunline.modules.stock.model;


import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

/**
 * @description: 待入账列表导出
 * @author: lcs
 * @date: 2018/11/28 16:33
 * @version: v1.0
 */
@Data
public class DonatedStockExpModel extends BaseRowModel {

    @ExcelProperty(value = "序号" ,index = 0)
    private String id;

    @ExcelProperty(value = "预约流水号" ,index = 1)
    private String applicationId;

    @ExcelProperty(value = "客户账号" ,index = 2)
    private String clientId;

    @ExcelProperty(value = "资金账号" ,index = 3)
    private String fundAccount;

    @ExcelProperty(value = "中文姓名" ,index = 4)
    private String clientName;

    @ExcelProperty(value = "英文姓名" ,index = 5)
    private String clientNameSpell;

    @ExcelProperty(value = "开户日期" ,index = 6)
    private String openAccountTime;

    @ExcelProperty(value = "开户方式" ,index = 7)
    private String openAccountType;

    @ExcelProperty(value = "首次入金日期" ,index = 8)
    private String firstIncomeDate;

    @ExcelProperty(value = "首次入金金额HKD" ,index = 9)
    private String firstIncome;

    @ExcelProperty(value = "首次转仓日期" ,index = 10)
    private String firstTransferDate;

    @ExcelProperty(value = "首次转仓市值HKD" ,index = 11)
    private String firstTransfer;

    @ExcelProperty(value = "市场" ,index = 12)
    private String exchangeType;

    @ExcelProperty(value = "赠股原因" ,index = 13)
    private String activType;

    @ExcelProperty(value = "股票代码" ,index = 14)
    private String stockCode;

    @ExcelProperty(value = "股票名称" ,index = 15)
    private String stockName;

    @ExcelProperty(value = "股票数量" ,index = 16)
    private String stockQuantity;

    @ExcelProperty(value = "收盘价" ,index = 17)
    private String closingPrice;

    @ExcelProperty(value = "收盘价日期" ,index = 18)
    private String closingPriceDate;

    @ExcelProperty(value = "印花税率" ,index = 19)
    private String stampDutyRatio;

    @ExcelProperty(value = "印花税(客户)" ,index = 20)
    private String stampDutyC;

    @ExcelProperty(value = "印花税(自营)" ,index = 21)
    private String stampDutyZ;

    @ExcelProperty(value = "合计" ,index = 22)
    private String total;


}
