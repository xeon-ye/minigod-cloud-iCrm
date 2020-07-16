package com.sunline.modules.hundsun.protocol.response;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @description: 资金冻结协议
 * @author: Larry Lai
 * @date: 2019/4/18 9:41
 * @version: v1.0
 */

public class FundFrozenResponse {
    /**
     * 错误提示
     */
    @JSONField(name = "error_info")
    private String errorInfo;

    /**
     * 错误序号
     */
    @JSONField(name = "error_id")
    private Integer errorId;

    /**
     * 流水号
     */
    @JSONField(name = "serial_no")
    private Integer serialNo;

    /**
     * 反向流水号
     */
    @JSONField(name = "revert_serial_no")
    private Integer revertSerialNo;

    /**
     * 资金冻结日期
     */
    @JSONField(name = "init_date")
    private Integer initDate;

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    public Integer getErrorId() {
        return errorId;
    }

    public void setErrorId(Integer errorId) {
        this.errorId = errorId;
    }

    public Integer getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }

    public Integer getRevertSerialNo() {
        return revertSerialNo;
    }

    public void setRevertSerialNo(Integer revertSerialNo) {
        this.revertSerialNo = revertSerialNo;
    }

    public Integer getInitDate() {
        return initDate;
    }

    public void setInitDate(Integer initDate) {
        this.initDate = initDate;
    }
}
