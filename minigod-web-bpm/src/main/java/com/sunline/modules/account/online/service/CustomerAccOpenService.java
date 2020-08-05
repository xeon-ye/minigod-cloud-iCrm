package com.sunline.modules.account.online.service;

import com.sunline.modules.account.online.entity.CustomerAccountOpenApplyEntity;
import com.sunline.modules.account.online.entity.CustomerAccountOpenInfoEntity;
import com.sunline.modules.account.online.model.*;
import com.sunline.modules.account.online.model.query.AccountOpenApplyAllotQuery;
import com.sunline.modules.account.online.protocol.AccountOpenApplyCallBackProtocol;
import com.sunline.modules.account.online.protocol.OpenAccountImageInfo;
import com.sunline.modules.activiti.dto.ProcessTaskDto;
import com.sunline.modules.activiti.entity.ExtendActTasklogEntity;
import com.sunline.modules.common.page.Page;
import org.activiti.engine.task.Task;

import java.util.List;
import java.util.Map;

/**
 * @author LiYangFeng
 * @createDate 2018/3/14
 * @description
 * @email justbelyf@gmail.com
 */
public interface CustomerAccOpenService {
    Page<AccountOpenApplyDetailInfo> findPage(AccountOpenApplyQuery query, int pageNum);

    List<AccountOpenApplyDetailInfo> findList(AccountOpenApplyQuery query);

    Page<AccountOpenApplyDetailInfo> findDistributePage(AccountOpenApplyAllotQuery query, int pageNum);

    List<AccountOpenApplyDetailInfo> findDistributeList(AccountOpenApplyAllotQuery query);

    AccountOpenApplyDetailInfo findByApplicationId(String applicationId);

    String commitAccountOpenApplication(CustomerAccountOpenInfoEntity customerAccountOpenInfoEntity, List<OpenAccountImageInfo> openAccountImagesInfo);

    String commitAccountMarginOpenApplication(CustomerAccountOpenInfoEntity customerAccountOpenInfoEntity);

    /**
     * 开户流程回调
     * 正常开户
     * @param customerAccountOpenApproveInfo
     * @param processTaskDto
     * @param task
     */
    void approveCallback(CustomerAccOpenApproveInfo customerAccountOpenApproveInfo, ProcessTaskDto processTaskDto, Task task);

    /**
     * 停止开户流程
     * 结束
     * @param applicationInfo
     * @param processTaskDto
     * @param rejectType
     * @return
     */
    boolean terminateAccountOpenApplication(CustomerAccountOpenApplyEntity applicationInfo, ProcessTaskDto processTaskDto, int rejectType);

    Map<String, Integer> statisticsOpenAccountErrors(List<CustomerAccOpenDetailModel> accountsOpenInfo);

    boolean distributeTask(List<String> accountOpenApplicationsIds, List<String> userIds);

    boolean cancelDistributeTask(List<String> accountOpenApplicationsIds);

    void backupAccountOpenReport(String tradeAccount, String customerAccountOpenInfoId);

    void backupAccountOpenImage(String tradeAccount, String customerAccountOpenInfoId);

    void backInitialUpdateAccOpenApply(ProcessTaskDto processTaskDto, int applicationStatus);

    Page<AccountOpenApplyDetailInfo> findPageCheck(AccountOpenApplyQuery query, int pageNum);

    void sendAccountOpenEmail(AccountOpenApplyDetailInfo accountOpenApplicationDetailInfo);

    boolean openAccountResultUserSMSNotice(AccountOpenApplyDetailInfo accountOpenApplicationDetailInfo, boolean result);

    /**
     * 编辑資料，補充資料后更新日志表、转待办
     *
     * @param applicationId
     * @param isEdit
     * @param isAdditional
     */
    void updateOpenAccountProcessLog(String applicationId, Integer isEdit, Integer isAdditional);

    /**
     * 错误理由拼接
     *
     * @param tasklogList
     * @return
     */
    List<ExtendActTasklogEntity> joinBackReasonType(List<ExtendActTasklogEntity> tasklogList);

    /**
     * 备份AML开户文件
     *
     * @param tradeAccount
     * @param customerAccountOpenInfoId
     */
    void backupAccountOpenAml(String tradeAccount, String customerAccountOpenInfoId);

    /**
     * 开户申请条数
     *
     * @return
     */
    public int myOpenApplicationCount() throws Exception;


    /**
     *  CA认证回调
     */
    boolean doCaVerityCallBack(AccountOpenApplyCallBackProtocol protocol);

    /**
     * 查询开户退回记录
     *
     * @param accountOpenApplicationQuery
     * @return
     */
    List<AccountOpenApplyDetailInfo> selectAccountOpenBackDetailInfo(AccountOpenApplyQuery accountOpenApplicationQuery);

    List<AccountOpenApplyDetailInfo> selectAccOpenDetailInfoByApplicationIds(String[] applicationIds);

    /**
     * 查询增开列表
     * @param query
     * @param pageNum
     * @return
     */
    Page<AccountOpenApplyDetailInfo> findMarginPage(AccountOpenApplyQuery query, int pageNum);

    /**
     * 增开流程回调
     * @param customerAccountOpenApproveInfo
     * @param processTaskDto
     * @param task
     */
    void approveMarginCallback(CustomerAccOpenApproveInfo customerAccountOpenApproveInfo, ProcessTaskDto processTaskDto, Task task);

    /**
     * 查询增开列表
     * @param query
     * @return
     */
    List<AccountOpenApplyDetailInfo> findMarginApplyList(AccountOpenApplyQuery query);
}
