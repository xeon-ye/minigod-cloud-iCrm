package com.sunline.modules.account.online.model;

import com.sunline.modules.activiti.annotation.ActTable;
import com.sunline.modules.common.common.BpmCommonEnum;

import java.util.Date;


/**
 * 客户开户申请表
 *
 * @author LiYangFeng
 * @email justbelyf@gmail.com
 * @date 2018-03-20 16:45:27
 */
@ActTable(tableName = "customer_account_open_application",pkName="id")
public class CustomerAccOpenApplyModel{
    //自增ID
    private Long id;
    //预约流水号
    private String applicationId;
    //申请标题
    private String applicationTitle;
    //节点名称
    private String currentNode;
    //审核结果
    private Integer approveResult;
    //    //当前开户步奏 [enum OpenAccountStep]
//    private Integer currentAccountOpenStep;
//    //当前开户步奏处理状态[enum CommonProcessStatus]
//    private Integer currentAccountOpenStepStatus;
//    //开户结果状态[enum CommonProcessStatus]
//    private Integer accountOpenResultStatus;
    //最后审核人
    private String lastApprovalUser;
    //最后审核信息
    private String approvalOpinion;
    //审核不通过的图片，JSON[{"imageLocation":1,"imageLocationType":1},{"imageLocation":2,"imageLocationType":2}]
    private String errorImages;
    //具体文本资料错误类型，JSON[1,2,3]
    private String errorContentTypes;
    //    //开户结果回调结果状态[enum CommonProcessStatus]
//    private Integer callbackStatus;
    //业务流程状态[1=草稿 2=审批中 3=结束]
    private String status;
    //流程实例id
    private String instanceId;
    //流程定义id
    private String defid;
    //流程发起人
    private String startUserId;
    //业务流程单据编号
    private String code;
    //流程发起人ID
    private String createUser;
    //流程更新人ID
    private String updateUser;
    //流程发起时间
    private Date startTime;
    //备注
    private String remark;
    //审批结果[1-为同意 2-为不同意 3-为审批中]
    private String actResult;
    //指定任务处理人
    private String assignDrafter;
    //新建时间
    private Date createTime;
    //更新时间
    private Date updateTime;

    //当前开户步奏 [enum OpenAccountStep]
    private BpmCommonEnum.OpenAccountStep currentAccountOpenStep;
    //当前开户步奏处理状态[enum CommonProcessStatus]
    private BpmCommonEnum.CommonProcessStatus currentAccountOpenStepStatus;
    //开户结果状态[enum CommonProcessStatus]
    private BpmCommonEnum.CommonProcessStatus accountOpenResultStatus;
    //开户结果回调结果状态[enum CommonProcessStatus]
    private BpmCommonEnum.CommonProcessStatus callbackStatus;

    //见证人
    private String witnessUser;
    //见证人类型
    private  String witnessesType;
    //牌照号码
    private  String licenseNumber;
    //提交审批人
    private  String submitApprovalUser;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getDefid() {
        return defid;
    }

    public void setDefid(String defid) {
        this.defid = defid;
    }

    public String getStartUserId() {
        return startUserId;
    }

    public void setStartUserId(String startUserId) {
        this.startUserId = startUserId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getActResult() {
        return actResult;
    }

    public void setActResult(String actResult) {
        this.actResult = actResult;
    }

    public String getAssignDrafter() {
        return assignDrafter;
    }

    public void setAssignDrafter(String assignDrafter) {
        this.assignDrafter = assignDrafter;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public BpmCommonEnum.OpenAccountStep getCurrentAccountOpenStep() {
        return currentAccountOpenStep;
    }

    public void setCurrentAccountOpenStep(BpmCommonEnum.OpenAccountStep currentAccountOpenStep) {
        this.currentAccountOpenStep = currentAccountOpenStep;
    }

    public BpmCommonEnum.CommonProcessStatus getCurrentAccountOpenStepStatus() {
        return currentAccountOpenStepStatus;
    }

    public void setCurrentAccountOpenStepStatus(BpmCommonEnum.CommonProcessStatus currentAccountOpenStepStatus) {
        this.currentAccountOpenStepStatus = currentAccountOpenStepStatus;
    }

    public BpmCommonEnum.CommonProcessStatus getAccountOpenResultStatus() {
        return accountOpenResultStatus;
    }

    public void setAccountOpenResultStatus(BpmCommonEnum.CommonProcessStatus accountOpenResultStatus) {
        this.accountOpenResultStatus = accountOpenResultStatus;
    }

    public BpmCommonEnum.CommonProcessStatus getCallbackStatus() {
        return callbackStatus;
    }

    public void setCallbackStatus(BpmCommonEnum.CommonProcessStatus callbackStatus) {
        this.callbackStatus = callbackStatus;
    }
}
