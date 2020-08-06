package com.sunline.modules.account.online.entity;

import com.sunline.modules.activiti.annotation.ActTable;
import com.sunline.modules.common.entity.ActivitiBaseEntity;

import java.io.Serializable;
import java.util.Date;


/**
 * 增开Margin申请表
 *
 * @author Tim
 * @email
 * @date 2020-08-05 10:00:00
 */
@ActTable(tableName = "customer_account_margin_open_application", pkName = "application_id")
public class CustomerAccountMarginOpenApplyEntity extends ActivitiBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    // 自增ID
    private Long id;
    // 预约流水号
    private String applicationId;
    // 申请标题
    private String applicationTitle;
    // 当前节点名称
    private String currentNode;
    // 审核结果[0-未知 1-待处理 2-成功 3-失败 4-处理中 5-未处理]
    private Integer approveResult;
    // 当前开户步奏 [enum OpenAccountStep]
    private Integer currentAccountOpenStep;
    // 当前开户步奏处理状态[enum CommonProcessStatus]
    private Integer currentAccountOpenStepStatus;
    // 开户结果状态[enum CommonProcessStatus]
    private Integer accountOpenResultStatus;
    // 最后审核人
    private String lastApprovalUser;
    // 最后审核意见
    private String approvalOpinion;
    // 审核不通过的图片，JSON[{"imageLocation":1,"imageLocationType":1},{"imageLocation":2,"imageLocationType":2}]
    private String errorImages;
    // 具体文本资料错误类型，JSON[1,2,3]
    private String errorContentTypes;
    // 开户结果回调结果状态[0-未知 1-待处理 2-成功 3-失败 4-处理中 5-未处理]
    private Integer callbackStatus;
    // 业务流程状态[1=草稿 2=审批中 3=结束]
    private String status;
    // 流程实例ID
    private String instanceId;
    // 流程定义ID
    private String defid;
    // 业务流程单据编号
    private String code;
    // 流程发起人ID
    private String startUserId;
    // 流程发起人ID
    private String createUser;
    // 流程更新人ID
    private String updateUser;
    // 流程发起时间
    private Date startTime;
    // 备注
    private String remark;
    // 流程审批结果[1-同意 2-不同意 3-审批中]
    private String actResult;
    // 预约申请状态[0-未知 1-初审中 2-复审中 3-终审中 4-预批成功 5-预批失败 6-已开户 7-已退回 8-已终止 9-已拒绝 10-已拒绝(加入黑名单)]
    private Integer applicationStatus;
    // 是否流程退回[0-否 1-是]
    private Integer isBack;
    // 指定任务处理人
    private String assignDrafter;
    // 流程审核记录
    private String flowPath;
    // 新建时间
    private Date createTime;
    // 更新时间
    private Date updateTime;
    // 加急处理
    private Integer fireAid;

    //见证人
    private String witnessUser;
    //见证人类型
    private  String witnessesType;
    //牌照号码
    private  String licenseNumber;
    //提交审批人
    private  String submitApprovalUser;
    //其他理由
    private String otherReasons;
    private Integer isExpExcel;

    public String getWitnessUser() {
        return witnessUser;
    }

    public void setWitnessUser(String witnessUser) {
        this.witnessUser = witnessUser;
    }

    public String getWitnessesType() {
        return witnessesType;
    }

    public void setWitnessesType(String witnessesType) {
        this.witnessesType = witnessesType;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getSubmitApprovalUser() {
        return submitApprovalUser;
    }

    public void setSubmitApprovalUser(String submitApprovalUser) {
        this.submitApprovalUser = submitApprovalUser;
    }


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

    public String getApplicationTitle() {
        return applicationTitle;
    }

    public void setApplicationTitle(String applicationTitle) {
        this.applicationTitle = applicationTitle;
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

    public Integer getCurrentAccountOpenStep() {
        return currentAccountOpenStep;
    }

    public void setCurrentAccountOpenStep(Integer currentAccountOpenStep) {
        this.currentAccountOpenStep = currentAccountOpenStep;
    }

    public Integer getCurrentAccountOpenStepStatus() {
        return currentAccountOpenStepStatus;
    }

    public void setCurrentAccountOpenStepStatus(Integer currentAccountOpenStepStatus) {
        this.currentAccountOpenStepStatus = currentAccountOpenStepStatus;
    }

    public Integer getAccountOpenResultStatus() {
        return accountOpenResultStatus;
    }

    public void setAccountOpenResultStatus(Integer accountOpenResultStatus) {
        this.accountOpenResultStatus = accountOpenResultStatus;
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

    public String getErrorImages() {
        return errorImages;
    }

    public void setErrorImages(String errorImages) {
        this.errorImages = errorImages;
    }

    public String getErrorContentTypes() {
        return errorContentTypes;
    }

    public void setErrorContentTypes(String errorContentTypes) {
        this.errorContentTypes = errorContentTypes;
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
    public String getRemark() {
        return remark;
    }

    @Override
    public void setRemark(String remark) {
        this.remark = remark;
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

    public Integer getIsBack() {
        return isBack;
    }

    public void setIsBack(Integer isBack) {
        this.isBack = isBack;
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

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    public Integer getFireAid() {
        return fireAid;
    }

    public void setFireAid(Integer fireAid) {
        this.fireAid = fireAid;
    }

    public String getOtherReasons() {
        return otherReasons;
    }

    public void setOtherReasons(String otherReasons) {
        this.otherReasons = otherReasons;
    }

    public Integer getIsExpExcel() {
        return isExpExcel;
    }

    public void setIsExpExcel(Integer isExpExcel) {
        this.isExpExcel = isExpExcel;
    }
}
