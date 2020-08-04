package com.sunline.modules.call.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 通话记录导出model
 * 
 * @author lcs
 * @date 2019-03-06 16:32:55
 */
@Data
public class CallRecordModel extends BaseRowModel {

    @ExcelProperty(value = "序号" ,index = 0)
    private String id;
    @ExcelProperty(value = "坐席工号" ,index = 1)
    private String exten;
    @ExcelProperty(value = "坐席姓名" ,index = 2)
    private String extenName;
    @ExcelProperty(value = "通话ID" ,index = 3)
    private String callId;
    @ExcelProperty(value = "通话开始时间" ,index = 4)
    private String beginTime;
    @ExcelProperty(value = "通话结束时间" ,index = 5)
    private String endTime;
    @ExcelProperty(value = "呼叫发起时间" ,index = 6)
    private String offeringTime;
    @ExcelProperty(value = "通话时长" ,index = 7)
    private String callTimeLength;
    @ExcelProperty(value = "呼叫类型" ,index = 8)
    private String connectType;
    @ExcelProperty(value = "主叫号码" ,index = 9)
    private String callNo;
    @ExcelProperty(value = "被叫号码" ,index = 10)
    private String calledNo;
    @ExcelProperty(value = "处理状态" ,index = 11)
    private String status;
    @ExcelProperty(value = "小神号" ,index = 12)
    private String userId;
    @ExcelProperty(value = "客户账号" ,index = 13)
    private String clientId;
    @ExcelProperty(value = "备注" ,index = 14)
    private String remark;

}
