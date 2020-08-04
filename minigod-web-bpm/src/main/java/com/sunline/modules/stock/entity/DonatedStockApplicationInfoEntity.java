package com.sunline.modules.stock.entity;

import com.sunline.modules.activiti.annotation.ActTable;
import com.sunline.modules.common.entity.ActivitiBaseEntity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * 赠股申请信息表
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-12-07 15:05:58
 */
@ActTable(tableName = "donated_stock_application_info", pkName = "application_id")
public class DonatedStockApplicationInfoEntity extends ActivitiBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //自增ID
    private Long id;
    //流水号
    private String applicationId;
    //小神号
    private Integer userId;
    //渠道号
    private String channelId;
    //交易帐号/客户帐号
    private String clientId;
    //客户名称
    private String clientName;
    //证券手机号
    private String phoneNumber;
    //股票代码
    private String stockCode;
    //股票名称
    private String stockName;
    //股票数量
    private Integer stockQuantity;
    //总成本HKD
    private BigDecimal totalCost;
    //活动ID
    private String activityId;
    //活动名称
    private String activityName;
    //方案ID
    private String programmeId;
    //领取时间
    private Date receiveTime;
    //打印状态[1-未打印 2-已打印]
    private Integer printStatus;
    //打印操作人
    private String printOperator;
    //印花税状态[1-待缴纳 2-已缴纳]
    private Integer stampDutyStatus;
    //缴纳印花税操作人
    private String stampDutyOperator;
    //入账状态[0-未知 1-待入账 2-已入账 3-入账失败]
    private Integer accountEntryStatus;
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
    //预约申请状态[0-未知 1-初审中 2-复审中 3-已通过 4-已拒绝]
    private Integer applicationStatus;
    //指定任务处理人
    private String assignDrafter;
    //流程审核记录
    private String flowPath;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;

    //领取开始时间时间
    private String receiveTimeStart;

    //领取开始时间时间
    private String receiveTimeEnd;
    //节点集合
    private List<String> currentNodes;
    //渠道名字
    private String channelName;
    //注册时间
    private String registerTime;
    //开户时间
    private Date openAccountTime;
    //首次入金
    private String firstIncome;
    //首转仓
    private String firstTransfer;
    //平均成本HKD
    private String averageCost;
    //英文名称
    private String clientNameSpell;

    //资金帐号
    private String fundAccount;
    private String firstIncomeDate;
    private String firstTransferDate;

    //奖励类型 1开户 2入金 3转仓 5积分兑换
    private Integer activType;

    private Integer bankType;

    //开户方式
    private String openAccountType;

    //打印序号
    private int num;

    //排序列
    private String sidx;
    //排序方式
    private String order;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getProgrammeId() {
        return programmeId;
    }

    public void setProgrammeId(String programmeId) {
        this.programmeId = programmeId;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public Integer getPrintStatus() {
        return printStatus;
    }

    public void setPrintStatus(Integer printStatus) {
        this.printStatus = printStatus;
    }

    public String getPrintOperator() {
        return printOperator;
    }

    public void setPrintOperator(String printOperator) {
        this.printOperator = printOperator;
    }

    public Integer getStampDutyStatus() {
        return stampDutyStatus;
    }

    public void setStampDutyStatus(Integer stampDutyStatus) {
        this.stampDutyStatus = stampDutyStatus;
    }

    public String getStampDutyOperator() {
        return stampDutyOperator;
    }

    public void setStampDutyOperator(String stampDutyOperator) {
        this.stampDutyOperator = stampDutyOperator;
    }

    public Integer getAccountEntryStatus() {
        return accountEntryStatus;
    }

    public void setAccountEntryStatus(Integer accountEntryStatus) {
        this.accountEntryStatus = accountEntryStatus;
    }

    public String getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(String currentNode) {
        this.currentNode = currentNode;
    }

    public Integer getApproveResult() {
        return approveResult;
    }

    public void setApproveResult(Integer approveResult) {
        this.approveResult = approveResult;
    }

    public String getLastApprovalUser() {
        return lastApprovalUser;
    }

    public void setLastApprovalUser(String lastApprovalUser) {
        this.lastApprovalUser = lastApprovalUser;
    }

    public String getApprovalOpinion() {
        return approvalOpinion;
    }

    public void setApprovalOpinion(String approvalOpinion) {
        this.approvalOpinion = approvalOpinion;
    }

    public Integer getCallbackStatus() {
        return callbackStatus;
    }

    public void setCallbackStatus(Integer callbackStatus) {
        this.callbackStatus = callbackStatus;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String getInstanceId() {
        return instanceId;
    }

    @Override
    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    @Override
    public String getDefid() {
        return defid;
    }

    @Override
    public void setDefid(String defid) {
        this.defid = defid;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getStartUserId() {
        return startUserId;
    }

    @Override
    public void setStartUserId(String startUserId) {
        this.startUserId = startUserId;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    @Override
    public Date getStartTime() {
        return startTime;
    }

    @Override
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Override
    public String getActResult() {
        return actResult;
    }

    @Override
    public void setActResult(String actResult) {
        this.actResult = actResult;
    }

    public Integer getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(Integer applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public String getAssignDrafter() {
        return assignDrafter;
    }

    public void setAssignDrafter(String assignDrafter) {
        this.assignDrafter = assignDrafter;
    }

    public String getFlowPath() {
        return flowPath;
    }

    public void setFlowPath(String flowPath) {
        this.flowPath = flowPath;
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public Date getUpdateTime() {
        return updateTime;
    }

    @Override
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getReceiveTimeStart() {
        return receiveTimeStart;
    }

    public void setReceiveTimeStart(String receiveTimeStart) {
        this.receiveTimeStart = receiveTimeStart;
    }

    public String getReceiveTimeEnd() {
        return receiveTimeEnd;
    }

    public void setReceiveTimeEnd(String receiveTimeEnd) {
        this.receiveTimeEnd = receiveTimeEnd;
    }

    public List<String> getCurrentNodes() {
        return currentNodes;
    }

    public void setCurrentNodes(List<String> currentNodes) {
        this.currentNodes = currentNodes;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public Date getOpenAccountTime() {
        return openAccountTime;
    }

    public void setOpenAccountTime(Date openAccountTime) {
        this.openAccountTime = openAccountTime;
    }

    public String getFirstIncome() {
        return firstIncome;
    }

    public void setFirstIncome(String firstIncome) {
        this.firstIncome = firstIncome;
    }

    public String getFirstTransfer() {
        return firstTransfer;
    }

    public void setFirstTransfer(String firstTransfer) {
        this.firstTransfer = firstTransfer;
    }

    public String getAverageCost() {
        return averageCost;
    }

    public void setAverageCost(String averageCost) {
        this.averageCost = averageCost;
    }

    public String getClientNameSpell() {
        return clientNameSpell;
    }

    public void setClientNameSpell(String clientNameSpell) {
        this.clientNameSpell = clientNameSpell;
    }

    public String getFundAccount() {
        return fundAccount;
    }

    public void setFundAccount(String fundAccount) {
        this.fundAccount = fundAccount;
    }

    public String getFirstIncomeDate() {
        return firstIncomeDate;
    }

    public void setFirstIncomeDate(String firstIncomeDate) {
        this.firstIncomeDate = firstIncomeDate;
    }

    public String getFirstTransferDate() {
        return firstTransferDate;
    }

    public void setFirstTransferDate(String firstTransferDate) {
        this.firstTransferDate = firstTransferDate;
    }

    public Integer getBankType() {
        return bankType;
    }

    public void setBankType(Integer bankType) {
        this.bankType = bankType;
    }

    public Integer getActivType() {
        return activType;
    }

    public void setActivType(Integer activType) {
        this.activType = activType;
    }

    public String getOpenAccountType() {
        return openAccountType;
    }

    public void setOpenAccountType(String openAccountType) {
        this.openAccountType = openAccountType;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
