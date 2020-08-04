package com.sunline.modules.hundsun.protocol.response;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @description: 用户登录响应协议
 * @author: Larry Lai
 * @date: 2019/7/19 10:05
 * @version: v1.0
 */

public class UserLoginResponse {

    /**
     * 错误提示
     */
    @JSONField(name = "error_info")
    private String errorInfo;

    /**
     * 错误编号
     */
    @JSONField(name = "error_no")
    private Integer errorNo;

    /**
     * 操作员编号
     */
    @JSONField(name = "operator_no")
    private String operatorNo;

    /**
     * 操作员分支代码
     */
    @JSONField(name = "op_branch_no")
    private Integer opBranchNo;

    /**
     * 主分支代码
     */
    @JSONField(name = "main_branch_no")
    private Integer mainBranchNo;

    /**
     * 默认币种
     */
    @JSONField(name = "def_money_type")
    private String defMoneyType;

    /**
     * 操作员类型
     */
    @JSONField(name = "operator_kind")
    private String operatorKind;

    /**
     * 操作员姓名
     */
    @JSONField(name = "operator_name")
    private String operatorName;

    /**
     * 汉字输入方法
     */
    @JSONField(name = "imename")
    private String imename;

    /**
     * 客户输入方法
     */
    @JSONField(name = "client_input")
    private String clientInput;

    /**
     * 认证类型
     */
    @JSONField(name = "token_type")
    private String tokenType;

    /**
     * 菜单修改次数
     */
    @JSONField(name = "menu_times")
    private Integer menuTimes;

    /**
     * 系统字典修改次数
     */
    @JSONField(name = "dictionary_times")
    private Integer dictionaryTimes;

    /**
     * 业务标志修改次数
     */
    @JSONField(name = "busiflag_times")
    private Integer busiflagTimes;

    /**
     * 公司名称
     */
    @JSONField(name = "company_name")
    private String companyName;

    /**
     * 初始化日期
     */
    @JSONField(name = "init_date")
    private Integer initDate;

    /**
     * 系统状态[0-停止 1-运行 2-测试 5-系统维护 6-系统清算]
     */
    @JSONField(name = "sys_status")
    private String sysStatus;

    /**
     * 系统名称
     */
    @JSONField(name = "system_name")
    private String systemName;

    /**
     * 系统状态名称
     */
    @JSONField(name = "sys_status_name")
    private String sysStatusName;

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    public Integer getErrorNo() {
        return errorNo;
    }

    public void setErrorNo(Integer errorNo) {
        this.errorNo = errorNo;
    }

    public String getOperatorNo() {
        return operatorNo;
    }

    public void setOperatorNo(String operatorNo) {
        this.operatorNo = operatorNo;
    }

    public Integer getOpBranchNo() {
        return opBranchNo;
    }

    public void setOpBranchNo(Integer opBranchNo) {
        this.opBranchNo = opBranchNo;
    }

    public Integer getMainBranchNo() {
        return mainBranchNo;
    }

    public void setMainBranchNo(Integer mainBranchNo) {
        this.mainBranchNo = mainBranchNo;
    }

    public String getDefMoneyType() {
        return defMoneyType;
    }

    public void setDefMoneyType(String defMoneyType) {
        this.defMoneyType = defMoneyType;
    }

    public String getOperatorKind() {
        return operatorKind;
    }

    public void setOperatorKind(String operatorKind) {
        this.operatorKind = operatorKind;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getImename() {
        return imename;
    }

    public void setImename(String imename) {
        this.imename = imename;
    }

    public String getClientInput() {
        return clientInput;
    }

    public void setClientInput(String clientInput) {
        this.clientInput = clientInput;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public Integer getMenuTimes() {
        return menuTimes;
    }

    public void setMenuTimes(Integer menuTimes) {
        this.menuTimes = menuTimes;
    }

    public Integer getDictionaryTimes() {
        return dictionaryTimes;
    }

    public void setDictionaryTimes(Integer dictionaryTimes) {
        this.dictionaryTimes = dictionaryTimes;
    }

    public Integer getBusiflagTimes() {
        return busiflagTimes;
    }

    public void setBusiflagTimes(Integer busiflagTimes) {
        this.busiflagTimes = busiflagTimes;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getInitDate() {
        return initDate;
    }

    public void setInitDate(Integer initDate) {
        this.initDate = initDate;
    }

    public String getSysStatus() {
        return sysStatus;
    }

    public void setSysStatus(String sysStatus) {
        this.sysStatus = sysStatus;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getSysStatusName() {
        return sysStatusName;
    }

    public void setSysStatusName(String sysStatusName) {
        this.sysStatusName = sysStatusName;
    }
}
