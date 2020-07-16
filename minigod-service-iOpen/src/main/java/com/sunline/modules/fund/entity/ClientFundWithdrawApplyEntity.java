package com.sunline.modules.fund.entity;

import com.sunline.modules.activiti.annotation.ActTable;
import com.sunline.modules.common.entity.ActivitiBaseEntity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * 客户出金申请信息表
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2019-04-01 16:23:18
 */
@ActTable(tableName = "client_fund_withdraw_application", pkName = "application_id")
public class ClientFundWithdrawApplyEntity extends ActivitiBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //自增ID
    private Long id;
    //流水号
    private String applicationId;
    //交易帐号
    private String clientId;
    //资金帐号
    private String fundAccount;
    //收款人名称
    private String clientNameSpell;
    //提取方式[0-香港银行卡 1-大陆银行卡]
    private Integer withdrawType;
    //收款银行名称
    private String bankName;
    //收款银行帐户
    private String bankNo;
    //SWIFT代码
    private String swiftCode;
    //出金银行代码
    private String bankCode;
    //联系地址
    private String contactAddress;
    //币种代码[0-人民币 1-美元 2-港币]
    private String moneyType;
    //提取金额
    private BigDecimal occurBalance;
    //提取手续费
    private BigDecimal chargeMoney;
    //实际提取金额
    private BigDecimal actualBalance;
    //冻结资金
    private BigDecimal frozenBalance;
    //现金余额
    private BigDecimal currentBalance;
    //反向流水号
    private Integer revertSerialNo;
    //资金冻结日期
    private Integer initDate;
    //当前节点名称
    private String currentNode;
    //审核结果[0-未知 1-待处理 2-成功 3-失败 4-处理中 5-未处理]
    private Integer approveResult;
    //最后审核人
    private String lastApprovalUser;
    //最后审核意见
    private String approvalOpinion;
    //回调APP端结果状态[0-未知 1-待处理 2-成功 3-失败 4-处理中 5-未处理]
    private Integer callbackStatus;
    //业务流程状态[1=草稿 2=审批中 3=结束]
    private String status;
    //流程实例ID
    private String instanceId;
    //流程定义ID
    private String defid;
    //业务流程单据编号
    private String code;
    //流程发起人ID
    private String startUserId;
    //流程发起人ID
    private String createUser;
    //流程更新人ID
    private String updateUser;
    //流程发起时间
    private Date startTime;
    //流程审批结果[1-同意 2-不同意 3-审批中]
    private String actResult;
    //预约申请状态[0-未知 1-初审中 2-复审中 3-汇款中 4-终审中 5-出金成功 6-出金失败 7-已完成 8-已终止]
    private Integer applicationStatus;
    //出金状态[0-未知 1-出金成功 2-出金失败]
    private Integer withdrawStatus;
    //导出状态[0-未知 1-已导出 2-未导出]
    private Integer exportStatus;
    //恒生银行编号
    private String hsBankId;
    //恒生银行帐户
    private String hsBankAccount;
    //恒生银行名称
    private String hsBankName;
    //恒生业务处理步骤[10007-资金取出 10009-资金解冻]
    private Integer hsBusinessStep;
    //指定任务处理人
    private String assignDrafter;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;

    private Integer userId;
    private String clientName;
    private Integer sex;
    private String phoneNumber;
    private Integer sourceChannelId;
    private Integer idKind;
    private String idNo;
    private String clientNameEn;

    private String beginTime;
    private String endTime;
    private String fundWithdrawBalance;

    private List<String> currentNodes;

    // 列表展示标识
    private String flag;

    // 汇款方式[0-未知 1-网银汇款 2-支票汇款]
    private Integer remittanceType;

    //恒生处理状态[0-未知 1-处理成功 2-处理失败]
    private Integer hsDealStatus;

    // 支票本[1-汇丰银行 2-中国银行（香港）]
    private Integer chequeType;

    private String day;
    private String month;
    private String year;

    private List<String> applicationIds;

    /**
     * 设置：自增ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：自增ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置：流水号
     */
    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    /**
     * 获取：流水号
     */
    public String getApplicationId() {
        return applicationId;
    }

    /**
     * 设置：交易帐号
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    /**
     * 获取：交易帐号
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * 设置：资金帐号
     */
    public void setFundAccount(String fundAccount) {
        this.fundAccount = fundAccount;
    }

    /**
     * 获取：资金帐号
     */
    public String getFundAccount() {
        return fundAccount;
    }

    /**
     * 设置：收款人名称
     */
    public void setClientNameSpell(String clientNameSpell) {
        this.clientNameSpell = clientNameSpell;
    }

    /**
     * 获取：收款人名称
     */
    public String getClientNameSpell() {
        return clientNameSpell;
    }

    public Integer getWithdrawType() {
        return withdrawType;
    }

    public void setWithdrawType(Integer withdrawType) {
        this.withdrawType = withdrawType;
    }

    /**
     * 设置：收款银行名称
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     * 获取：收款银行名称
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * 设置：收款银行帐户
     */
    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }

    /**
     * 获取：收款银行帐户
     */
    public String getBankNo() {
        return bankNo;
    }

    /**
     * 设置：SWIFT代码
     */
    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }

    /**
     * 获取：SWIFT代码
     */
    public String getSwiftCode() {
        return swiftCode;
    }

    /**
     * 设置：联系地址
     */
    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    /**
     * 获取：联系地址
     */
    public String getContactAddress() {
        return contactAddress;
    }

    /**
     * 设置：币种代码[0-人民币 1-美元 2-港币]
     */
    public void setMoneyType(String moneyType) {
        this.moneyType = moneyType;
    }

    /**
     * 获取：币种代码[0-人民币 1-美元 2-港币]
     */
    public String getMoneyType() {
        return moneyType;
    }

    /**
     * 设置：提取金额
     */
    public void setOccurBalance(BigDecimal occurBalance) {
        this.occurBalance = occurBalance;
    }

    /**
     * 获取：提取金额
     */
    public BigDecimal getOccurBalance() {
        return occurBalance;
    }

    /**
     * 设置：冻结资金
     */
    public void setFrozenBalance(BigDecimal frozenBalance) {
        this.frozenBalance = frozenBalance;
    }

    /**
     * 获取：冻结资金
     */
    public BigDecimal getFrozenBalance() {
        return frozenBalance;
    }

    /**
     * 设置：现金余额
     */
    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    /**
     * 获取：现金余额
     */
    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    /**
     * 设置：当前节点名称
     */
    public void setCurrentNode(String currentNode) {
        this.currentNode = currentNode;
    }

    /**
     * 获取：当前节点名称
     */
    public String getCurrentNode() {
        return currentNode;
    }

    /**
     * 设置：审核结果[0-未知 1-待处理 2-成功 3-失败 4-处理中 5-未处理]
     */
    public void setApproveResult(Integer approveResult) {
        this.approveResult = approveResult;
    }

    /**
     * 获取：审核结果[0-未知 1-待处理 2-成功 3-失败 4-处理中 5-未处理]
     */
    public Integer getApproveResult() {
        return approveResult;
    }

    /**
     * 设置：最后审核人
     */
    public void setLastApprovalUser(String lastApprovalUser) {
        this.lastApprovalUser = lastApprovalUser;
    }

    /**
     * 获取：最后审核人
     */
    public String getLastApprovalUser() {
        return lastApprovalUser;
    }

    /**
     * 设置：最后审核意见
     */
    public void setApprovalOpinion(String approvalOpinion) {
        this.approvalOpinion = approvalOpinion;
    }

    /**
     * 获取：最后审核意见
     */
    public String getApprovalOpinion() {
        return approvalOpinion;
    }

    /**
     * 设置：回调APP端结果状态[0-未知 1-待处理 2-成功 3-失败 4-处理中 5-未处理]
     */
    public void setCallbackStatus(Integer callbackStatus) {
        this.callbackStatus = callbackStatus;
    }

    /**
     * 获取：回调APP端结果状态[0-未知 1-待处理 2-成功 3-失败 4-处理中 5-未处理]
     */
    public Integer getCallbackStatus() {
        return callbackStatus;
    }

    /**
     * 设置：业务流程状态[1=草稿 2=审批中 3=结束]
     */
    @Override
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取：业务流程状态[1=草稿 2=审批中 3=结束]
     */
    @Override
    public String getStatus() {
        return status;
    }

    /**
     * 设置：流程实例ID
     */
    @Override
    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    /**
     * 获取：流程实例ID
     */
    @Override
    public String getInstanceId() {
        return instanceId;
    }

    /**
     * 设置：流程定义ID
     */
    @Override
    public void setDefid(String defid) {
        this.defid = defid;
    }

    /**
     * 获取：流程定义ID
     */
    @Override
    public String getDefid() {
        return defid;
    }

    /**
     * 设置：业务流程单据编号
     */
    @Override
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取：业务流程单据编号
     */
    @Override
    public String getCode() {
        return code;
    }

    /**
     * 设置：流程发起人ID
     */
    @Override
    public void setStartUserId(String startUserId) {
        this.startUserId = startUserId;
    }

    /**
     * 获取：流程发起人ID
     */
    @Override
    public String getStartUserId() {
        return startUserId;
    }

    /**
     * 设置：流程发起人ID
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * 获取：流程发起人ID
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 设置：流程更新人ID
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * 获取：流程更新人ID
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * 设置：流程发起时间
     */
    @Override
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取：流程发起时间
     */
    @Override
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 设置：流程审批结果[1-同意 2-不同意 3-审批中]
     */
    @Override
    public void setActResult(String actResult) {
        this.actResult = actResult;
    }

    /**
     * 获取：流程审批结果[1-同意 2-不同意 3-审批中]
     */
    @Override
    public String getActResult() {
        return actResult;
    }

    /**
     * 设置：预约申请状态[0-未知 1-初审中 2-复审中 3-已通过 4-已拒绝]
     */
    public void setApplicationStatus(Integer applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    /**
     * 获取：预约申请状态[0-未知 1-初审中 2-复审中 3-已通过 4-已拒绝]
     */
    public Integer getApplicationStatus() {
        return applicationStatus;
    }

    /**
     * 设置：指定任务处理人
     */
    public void setAssignDrafter(String assignDrafter) {
        this.assignDrafter = assignDrafter;
    }

    /**
     * 获取：指定任务处理人
     */
    public String getAssignDrafter() {
        return assignDrafter;
    }

    /**
     * 设置：创建时间
     */
    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取：创建时间
     */
    @Override
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置：更新时间
     */
    @Override
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取：更新时间
     */
    @Override
    public Date getUpdateTime() {
        return updateTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getSourceChannelId() {
        return sourceChannelId;
    }

    public void setSourceChannelId(Integer sourceChannelId) {
        this.sourceChannelId = sourceChannelId;
    }

    public Integer getIdKind() {
        return idKind;
    }

    public void setIdKind(Integer idKind) {
        this.idKind = idKind;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getClientNameEn() {
        return clientNameEn;
    }

    public void setClientNameEn(String clientNameEn) {
        this.clientNameEn = clientNameEn;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public List<String> getCurrentNodes() {
        return currentNodes;
    }

    public void setCurrentNodes(List<String> currentNodes) {
        this.currentNodes = currentNodes;
    }

    public Integer getWithdrawStatus() {
        return withdrawStatus;
    }

    public void setWithdrawStatus(Integer withdrawStatus) {
        this.withdrawStatus = withdrawStatus;
    }

    public Integer getExportStatus() {
        return exportStatus;
    }

    public void setExportStatus(Integer exportStatus) {
        this.exportStatus = exportStatus;
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

    public String getHsBankId() {
        return hsBankId;
    }

    public void setHsBankId(String hsBankId) {
        this.hsBankId = hsBankId;
    }

    public String getHsBankAccount() {
        return hsBankAccount;
    }

    public void setHsBankAccount(String hsBankAccount) {
        this.hsBankAccount = hsBankAccount;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Integer getHsBusinessStep() {
        return hsBusinessStep;
    }

    public void setHsBusinessStep(Integer hsBusinessStep) {
        this.hsBusinessStep = hsBusinessStep;
    }

    public String getFundWithdrawBalance() {
        return fundWithdrawBalance;
    }

    public void setFundWithdrawBalance(String fundWithdrawBalance) {
        this.fundWithdrawBalance = fundWithdrawBalance;
    }

    public Integer getRemittanceType() {
        return remittanceType;
    }

    public void setRemittanceType(Integer remittanceType) {
        this.remittanceType = remittanceType;
    }

    public Integer getHsDealStatus() {
        return hsDealStatus;
    }

    public void setHsDealStatus(Integer hsDealStatus) {
        this.hsDealStatus = hsDealStatus;
    }

    public Integer getChequeType() {
        return chequeType;
    }

    public void setChequeType(Integer chequeType) {
        this.chequeType = chequeType;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getHsBankName() {
        return hsBankName;
    }

    public void setHsBankName(String hsBankName) {
        this.hsBankName = hsBankName;
    }

    public List<String> getApplicationIds() {
        return applicationIds;
    }

    public void setApplicationIds(List<String> applicationIds) {
        this.applicationIds = applicationIds;
    }

    public BigDecimal getChargeMoney() {
        return chargeMoney;
    }

    public void setChargeMoney(BigDecimal chargeMoney) {
        this.chargeMoney = chargeMoney;
    }

    public BigDecimal getActualBalance() {
        return actualBalance;
    }

    public void setActualBalance(BigDecimal actualBalance) {
        this.actualBalance = actualBalance;
    }
}
