package com.sunline.modules.report.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @description: 交易统计报表导出excel
 * @version: v1.0
 */

@Data
public class TradeReportModel extends BaseRowModel {

    @ExcelProperty(value = "序号" ,index = 0)
    private String id;

    @ExcelProperty(value = "时间" ,index = 1)
    private String date;

    @ExcelProperty(value = "客户类型" ,index = 2)
    private String clientType;

    @ExcelProperty(value = "委托客户数" ,index = 3)
    private int entrustClientCount;

    @ExcelProperty(value = "委托笔数" ,index = 4)
    private int entrustCount;

    @ExcelProperty(value = "委托类型" ,index = 5)
    private String entrustWay;

    @ExcelProperty(value = "成交笔数" ,index = 6)
    private int tradeCount;

    @ExcelProperty(value = "去年成交笔数同比%" ,index = 7)
    private double countRatioT;


    @ExcelProperty(value = "去年成交笔数环比%" ,index = 8)
    private double countRatioH;

    @ExcelProperty(value = "成交金额" ,index = 9)
    private BigDecimal tradeBalance;

    @ExcelProperty(value = "去年成交金额同比%" ,index = 10)
    private double balanceRatioT;

    @ExcelProperty(value = "去年成交金额环比%" ,index = 11)
    private double balanceRatioH;
}
