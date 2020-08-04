package com.sunline.modules.fund.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

/**
 * @description: 出金审核记录导出excel模板
 * @author: Larry Lai
 * @date: 2019/4/8 10:30
 * @version: v1.0
 */

@Data
public class ClientFundWithdrawApplyDealModel extends BaseRowModel {
    @ExcelProperty(value = {"NO.", "NO."}, index = 0)
    private int no;

    @ExcelProperty(value = {"ACCNT NO.", "ACCNT NO."}, index = 1)
    private String clientId;

    @ExcelProperty(value = {"NAME", "NAME"}, index = 2)
    private String clientNameSpell;

    @ExcelProperty(value = {"CHINESE NAME", "CHINESE NAME"}, index = 3)
    private String clientName;

    @ExcelProperty(value = {"可取现金结余", "可取现金结余"}, index = 4)
    private String currentBalance;

    @ExcelProperty(value = {"CLIENT A/C", "CCY"}, index = 5)
    private String ccy;

    @ExcelProperty(value = {"CLIENT A/C", "DEBIT"}, index = 6)
    private String occurBalance;

    @ExcelProperty(value = {"CLIENT A/C", "CREDIT"}, index = 7)
    private String emptyField1;

    @ExcelProperty(value = {"BANK A/C ", "CCY "}, index = 8)
    private String ccy1;

    @ExcelProperty(value = {"BANK A/C ", " DEBIT "}, index = 9)
    private String frozenBalance;

    @ExcelProperty(value = {"BANK A/C ", "CREDIT "}, index = 10)
    private String emptyField2;

    @ExcelProperty(value = {"CUSTDN", "CUSTDN"}, index = 11)
    private String emptyField3;

//    @ExcelProperty(value = {"PARTICULARS","PARTICULARS"}, index = 11)
//    private String particulars;
    @ExcelProperty(value = {"BANK CODE", "BANK CODE"}, index = 12)
    private String bankCode;

//    @ExcelProperty(value = {"H/T", "CODE"}, index = 12)
//    private String emptyField4;
    @ExcelProperty(value = {"BANK", "BANK"}, index = 13)
    private String bank;

    @ExcelProperty(value = {"BANK ACCOUNT", "BANK ACCOUNT"}, index = 14)
    private String bankAccount;

    @ExcelProperty(value = {"附言", "附言"}, index = 15)
    private String mark;

    @ExcelProperty(value = {"VALUE DATE", "VALUE DATE"}, index = 16)
    private String valueDate;

}
