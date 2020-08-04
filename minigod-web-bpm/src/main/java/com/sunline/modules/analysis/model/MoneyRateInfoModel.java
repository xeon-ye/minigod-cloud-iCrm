package com.sunline.modules.analysis.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * @description: 汇率查询导出Excel模板
 * @author: fuyy
 * @date: 2018/11/27 16:33
 * @version: v1.0
 */

public class MoneyRateInfoModel extends BaseRowModel {

    @ExcelProperty(value = "序号" ,index = 0)
    private String id;

    @ExcelProperty(value = "货币名称" ,index = 1)
    private String fromMoneyType;

    @ExcelProperty(value = "转换币种" ,index = 2)
    private String toMoneyType;

    @ExcelProperty(value = "汇率" ,index = 3)
    private String exchangeRate;

    @ExcelProperty(value = "同步日期" ,index = 4)
    private String initDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFromMoneyType() {
        return fromMoneyType;
    }

    public void setFromMoneyType(String fromMoneyType) {
        this.fromMoneyType = fromMoneyType;
    }

    public String getToMoneyType() {
        return toMoneyType;
    }

    public void setToMoneyType(String toMoneyType) {
        this.toMoneyType = toMoneyType;
    }

    public String getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(String exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getInitDate() {
        return initDate;
    }

    public void setInitDate(String initDate) {
        this.initDate = initDate;
    }
}
