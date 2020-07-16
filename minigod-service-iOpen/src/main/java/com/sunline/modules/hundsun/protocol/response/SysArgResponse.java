package com.sunline.modules.hundsun.protocol.response;

/**
 * @description: 系统参数
 * @author: Larry Lai
 * @date: 2019/8/23 14:36
 * @version: v1.0
 */

public class SysArgResponse {

    /**
     * 初始化日期
     */
    private String initDate;

    /**
     * 系统状态[0-停止 1-运行 2-测试 5-系统维护 6-系统清算]
     */
    private String sysStatus;

    /**
     * 银行状态[0-无效 1-有效]
     */
    private String bankStatus;

    public String getInitDate() {
        return initDate;
    }

    public void setInitDate(String initDate) {
        this.initDate = initDate;
    }

    public String getSysStatus() {
        return sysStatus;
    }

    public void setSysStatus(String sysStatus) {
        this.sysStatus = sysStatus;
    }

    public String getBankStatus() {
        return bankStatus;
    }

    public void setBankStatus(String bankStatus) {
        this.bankStatus = bankStatus;
    }
}
