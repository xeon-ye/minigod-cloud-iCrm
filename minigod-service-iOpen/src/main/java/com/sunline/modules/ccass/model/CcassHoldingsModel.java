package com.sunline.modules.ccass.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * @description: 参与者持仓信息
 * @author: Larry Lai
 * @date: 2019/1/9 9:05
 * @version: v1.0
 */

public class CcassHoldingsModel extends BaseRowModel {

    @ExcelProperty(value = "序号", index = 0)
    private String id;

    // 股票代码
    @ExcelProperty(value = "股票代码", index = 1)
    private String stockCode;

    // 股票英文名
    @ExcelProperty(value = "股票名称", index = 2)
    private String stockNameEn;

    // 持股数量
    @ExcelProperty(value = "持股数量", index = 3)
    private String stockHolding;

    // 持股市值
    @ExcelProperty(value = "持股市值", index = 4)
    private String stockValue;

    // 持股比例
    @ExcelProperty(value = "持股比例", index = 5)
    private String stakePercentage;

    // 持股日期
    @ExcelProperty(value = "持股变动日期", index = 6)
    private String holdDate;

    // CCASS更新日期
    @ExcelProperty(value = "更新日期", index = 7)
    private String updateDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockNameEn() {
        return stockNameEn;
    }

    public void setStockNameEn(String stockNameEn) {
        this.stockNameEn = stockNameEn;
    }

    public String getStockHolding() {
        return stockHolding;
    }

    public void setStockHolding(String stockHolding) {
        this.stockHolding = stockHolding;
    }

    public String getStockValue() {
        return stockValue;
    }

    public void setStockValue(String stockValue) {
        this.stockValue = stockValue;
    }

    public String getStakePercentage() {
        return stakePercentage;
    }

    public void setStakePercentage(String stakePercentage) {
        this.stakePercentage = stakePercentage;
    }

    public String getHoldDate() {
        return holdDate;
    }

    public void setHoldDate(String holdDate) {
        this.holdDate = holdDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }
}
