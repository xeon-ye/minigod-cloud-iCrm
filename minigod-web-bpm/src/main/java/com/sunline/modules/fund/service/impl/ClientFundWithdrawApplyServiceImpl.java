package com.sunline.modules.fund.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Lists;
import com.sunline.common.ConfigUtils;
import com.sunline.modules.activiti.dto.ProcessTaskDto;
import com.sunline.modules.activiti.service.ActModelerService;
import com.sunline.modules.activiti.utils.ActUtils;
import com.sunline.modules.common.common.BpmCommonEnum;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.page.PageHelper;
import com.sunline.modules.common.pojo.rest.GenericSunlineRequest;
import com.sunline.modules.common.utils.CodeUtils;
import com.sunline.modules.common.utils.HttpClientUtils;
import com.sunline.modules.common.utils.OrderUtil;
import com.sunline.modules.common.utils.UserUtils;
import com.sunline.modules.common.vo.ResponseVO;
import com.sunline.modules.customer.dao.SecUserInfoDao;
import com.sunline.modules.customer.entity.SecuritiesUserInfoEntity;
import com.sunline.modules.fund.dao.ClientFundWithdrawApplyDao;
import com.sunline.modules.fund.entity.ClientFundWithdrawApplyEntity;
import com.sunline.modules.fund.model.ClientFundWithdrawApplyInfo;
import com.sunline.modules.fund.proxy.request.FundWithdrawResultRequest;
import com.sunline.modules.fund.service.ClientFundWithdrawApplyService;
import com.sunline.modules.notice.entity.MessageSendInfoEntity;
import com.sunline.modules.notice.service.MessageSendInfoService;
import com.sunline.modules.sys.entity.UserEntity;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 客户出金申请信息表
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2019-04-01 16:23:18
 */

@Service("clientFundWithdrawApplyService")
public class ClientFundWithdrawApplyServiceImpl implements ClientFundWithdrawApplyService {

    private static final Logger logger = LoggerFactory.getLogger(ClientFundWithdrawApplyServiceImpl.class);

    private static final String CLIENT_FUND_WITHDRAW_FLOW_MODEL_KEY = "clientFundWithdrawApplication";

    @Autowired
    private ClientFundWithdrawApplyDao clientFundWithdrawApplyDao;
    @Autowired
    ActModelerService actModelerService;
    @Autowired
    MessageSendInfoService messageSendInfoService;
    @Autowired
    private SecUserInfoDao secUserInfoDao;

    @Override
    public ClientFundWithdrawApplyEntity queryObject(Long id) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFundWithdrawApplyDao.queryObject(id);
    }

    @Override
    public List<ClientFundWithdrawApplyEntity> queryList(ClientFundWithdrawApplyEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFundWithdrawApplyDao.queryList(entity);
    }

    @Override
    public List<ClientFundWithdrawApplyEntity> queryAuditList(ClientFundWithdrawApplyEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFundWithdrawApplyDao.queryAuditList(entity);
    }

    @Override
    public List<ClientFundWithdrawApplyEntity> queryListByBean(ClientFundWithdrawApplyEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFundWithdrawApplyDao.queryListByBean(entity);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFundWithdrawApplyDao.queryTotal(map);
    }

    @Override
    public int save(ClientFundWithdrawApplyEntity clientFundWithdrawApplication) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
//        clientFundWithdrawApplication.setId(Utils.uuid());
        return clientFundWithdrawApplyDao.save(clientFundWithdrawApplication);
    }

    @Override
    public int update(ClientFundWithdrawApplyEntity clientFundWithdrawApplication) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFundWithdrawApplyDao.update(clientFundWithdrawApplication);
    }

    @Override
    public int delete(Long id) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFundWithdrawApplyDao.delete(id);
    }

    @Override
    public int deleteBatch(Long[] ids) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFundWithdrawApplyDao.deleteBatch(ids);
    }

    /**
     * 通过预约号查询
     *
     * @param applicationId
     * @return
     */
    @Override
    public ClientFundWithdrawApplyEntity queryByApplicationId(String applicationId) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFundWithdrawApplyDao.queryByApplicationId(applicationId);
    }

    /**
     * 提交出金申请并启动工作流
     *
     * @param clientFundWithdrawApplyEntity
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String commitClientFundWithdrawApply(ClientFundWithdrawApplyEntity clientFundWithdrawApplyEntity) {
        try {
            DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
            UserEntity workflowUser = UserUtils.getBackgroundWorkflowUser();
            // 检验预约流水号的唯一性
            String applicationId = OrderUtil.getOrderNoByAtomic(4);
            ClientFundWithdrawApplyEntity isExistedInfo = clientFundWithdrawApplyDao.queryByApplicationId(applicationId);
            while (null != isExistedInfo) {
                applicationId = OrderUtil.getOrderNoByAtomic(4);
                isExistedInfo = clientFundWithdrawApplyDao.queryByApplicationId(applicationId);
            }

            // 英文姓名处理
            SecuritiesUserInfoEntity queryCondition = new SecuritiesUserInfoEntity();
            queryCondition.setFundAccount(clientFundWithdrawApplyEntity.getFundAccount());
            SecuritiesUserInfoEntity securitiesUserInfo = secUserInfoDao.queryObject(queryCondition);
            if (null != securitiesUserInfo) {
//                clientFundWithdrawApplyEntity.setClientNameSpell(PinyinHelper.convertToPinyinString(securitiesUserInfo.getFamilyName(), "", PinyinFormat.WITHOUT_TONE).toUpperCase()
//                        + " " + PinyinHelper.convertToPinyinString(securitiesUserInfo.getGivenName(), "", PinyinFormat.WITHOUT_TONE).toUpperCase());
                clientFundWithdrawApplyEntity.setClientNameSpell(securitiesUserInfo.getClientNameSpell());
            }

            clientFundWithdrawApplyEntity.setApplicationId(applicationId);
            clientFundWithdrawApplyEntity.setCurrentNode("提交");
            clientFundWithdrawApplyEntity.setCode(applicationId);
            clientFundWithdrawApplyEntity.setCreateUser(workflowUser.getId());
            clientFundWithdrawApplyEntity.setApproveResult(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
            clientFundWithdrawApplyEntity.setStatus(Constant.ActStauts.DRAFT.getValue());
            clientFundWithdrawApplyEntity.setBapid(workflowUser.getBapid());
            clientFundWithdrawApplyEntity.setBaid(workflowUser.getBaid());
            clientFundWithdrawApplyEntity.setApplicationStatus(BpmCommonEnum.FundWithdrawApplicationStatus.FUND_WITHDRAW_APPLY_STATUS_INITIAL_AUDIT_VALUE);
            clientFundWithdrawApplyEntity.setCreateTime(new Date());
            clientFundWithdrawApplyEntity.setUpdateTime(new Date());

            int count = clientFundWithdrawApplyDao.save(clientFundWithdrawApplyEntity);

            if (count > 0) {
                ProcessDefinition clientFundWithdrawProcessDefinition = ActUtils.getlastProcessDefinition(CLIENT_FUND_WITHDRAW_FLOW_MODEL_KEY);
                ProcessTaskDto processTaskDto = new ProcessTaskDto();
                processTaskDto.setDefId(clientFundWithdrawProcessDefinition.getId());
                processTaskDto.setBusId(clientFundWithdrawApplyEntity.getApplicationId());
                processTaskDto.setActKey(clientFundWithdrawProcessDefinition.getKey());
                processTaskDto.setNodeType("2");

                actModelerService.startFlow(processTaskDto);

                return clientFundWithdrawApplyEntity.getApplicationId();
            }

            return null;

        } catch (Exception e) {
            logger.error("提交出金申请启动工作流流程失败", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return null;
        }
    }

    /**
     * 出金工作流回调业务处理
     *
     * @param clientFundWithdrawApplyInfo
     * @param processTaskDto
     * @param task
     */
    @Override
    public void approveCallback(ClientFundWithdrawApplyInfo clientFundWithdrawApplyInfo, ProcessTaskDto processTaskDto, Task task) {
        try {

            DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
            ClientFundWithdrawApplyEntity clientFundWithdrawInfo = clientFundWithdrawApplyDao.queryByApplicationId(clientFundWithdrawApplyInfo.getApplicationId());

            // 初审节点回调业务处理
            if (CodeUtils.getCodeName("FUND_WITHDRAW_NODE_NAME", "1").equals(clientFundWithdrawApplyInfo.getCurrentNode())) {

                ClientFundWithdrawApplyEntity clientFundWithdrawApplyEntity = new ClientFundWithdrawApplyEntity();
                clientFundWithdrawApplyEntity.setApplicationId(clientFundWithdrawApplyInfo.getApplicationId());
                clientFundWithdrawApplyEntity.setApplicationStatus(BpmCommonEnum.FundWithdrawApplicationStatus.FUND_WITHDRAW_APPLY_STATUS_INITIAL_AUDIT_VALUE);
                clientFundWithdrawApplyEntity.setLastApprovalUser(processTaskDto.getDealId());
                clientFundWithdrawApplyEntity.setApprovalOpinion(processTaskDto.getRemark());
                clientFundWithdrawApplyEntity.setUpdateTime(new Date());

                clientFundWithdrawApplyDao.updateByApplicationId(clientFundWithdrawApplyEntity);
            }

            // 复审节点回调业务处理
            if (CodeUtils.getCodeName("FUND_WITHDRAW_NODE_NAME", "2").equals(clientFundWithdrawApplyInfo.getCurrentNode())) {

                ClientFundWithdrawApplyEntity clientFundWithdrawApplyEntity = new ClientFundWithdrawApplyEntity();
                clientFundWithdrawApplyEntity.setApplicationId(clientFundWithdrawApplyInfo.getApplicationId());
                clientFundWithdrawApplyEntity.setApplicationStatus(BpmCommonEnum.FundWithdrawApplicationStatus.FUND_WITHDRAW_APPLY_RECHECK_AUDIT_VALUE);
                clientFundWithdrawApplyEntity.setLastApprovalUser(processTaskDto.getDealId());
                clientFundWithdrawApplyEntity.setApprovalOpinion(processTaskDto.getRemark());
                clientFundWithdrawApplyEntity.setUpdateTime(new Date());

                clientFundWithdrawApplyDao.updateByApplicationId(clientFundWithdrawApplyEntity);

                // 回调APP
                FundWithdrawResultRequest request = new FundWithdrawResultRequest();
                request.setApplicationId(clientFundWithdrawApplyInfo.getApplicationId());
                request.setWithdrawStatus(1);

                ResponseVO response = pushFundWithdrawResult(request);

            }

            // 汇款节点回调业务处理
            if (CodeUtils.getCodeName("FUND_WITHDRAW_NODE_NAME", "3").equals(clientFundWithdrawApplyInfo.getCurrentNode())) {

                ClientFundWithdrawApplyEntity clientFundWithdrawApplyEntity = new ClientFundWithdrawApplyEntity();
                clientFundWithdrawApplyEntity.setApplicationId(clientFundWithdrawApplyInfo.getApplicationId());
                clientFundWithdrawApplyEntity.setApplicationStatus(BpmCommonEnum.FundWithdrawApplicationStatus.FUND_WITHDRAW_APPLY_REMIT_MONEY_VALUE);
                clientFundWithdrawApplyEntity.setLastApprovalUser(processTaskDto.getDealId());
                clientFundWithdrawApplyEntity.setApprovalOpinion(processTaskDto.getRemark());
                clientFundWithdrawApplyEntity.setUpdateTime(new Date());

                clientFundWithdrawApplyDao.updateByApplicationId(clientFundWithdrawApplyEntity);
            }

            // 出账节点回调业务处理
            if (CodeUtils.getCodeName("FUND_WITHDRAW_NODE_NAME", "4").equals(clientFundWithdrawApplyInfo.getCurrentNode())) {

                ClientFundWithdrawApplyEntity clientFundWithdrawApplyEntity = new ClientFundWithdrawApplyEntity();
                clientFundWithdrawApplyEntity.setApplicationId(clientFundWithdrawApplyInfo.getApplicationId());
                clientFundWithdrawApplyEntity.setApplicationStatus(BpmCommonEnum.FundWithdrawApplicationStatus.FUND_WITHDRAW_APPLY_FINAL_AUDIT_VALUE);
                clientFundWithdrawApplyEntity.setLastApprovalUser(processTaskDto.getDealId());
                clientFundWithdrawApplyEntity.setApprovalOpinion(processTaskDto.getRemark());
                clientFundWithdrawApplyEntity.setUpdateTime(new Date());

                clientFundWithdrawApplyDao.updateByApplicationId(clientFundWithdrawApplyEntity);
            }

            // 完成节点回调业务处理
            if (CodeUtils.getCodeName("FUND_WITHDRAW_NODE_NAME", "5").equals(clientFundWithdrawApplyInfo.getCurrentNode())) {


                if (!CodeUtils.getCodeName("FUND_WITHDRAW_NODE_NAME", "6").equals(clientFundWithdrawInfo.getCurrentNode())) {

                    ClientFundWithdrawApplyEntity clientFundWithdrawApplyEntity = new ClientFundWithdrawApplyEntity();

                    if (BpmCommonEnum.FundWithdrawStatus.FUND_WITHDRAW_STATUS_SUCCESS_VALUE == clientFundWithdrawInfo.getWithdrawStatus()) {

                        // 发送短信通知
                        List<String> paramList = Lists.newArrayList();

                        paramList.clear();
                        paramList.add(clientFundWithdrawInfo.getClientName() != null ? clientFundWithdrawInfo.getClientName() : clientFundWithdrawInfo.getClientNameSpell());
                        paramList.add(clientFundWithdrawInfo.getOccurBalance() + CodeUtils.getCodeName("SEC_MONEY_TYPE_TRD", String.valueOf(clientFundWithdrawInfo.getMoneyType())));

                        // 发送短信
                        generateFundWithdrawRetSendSms(2004, clientFundWithdrawInfo.getPhoneNumber(), paramList);

                        // 回调APP
                        FundWithdrawResultRequest request = new FundWithdrawResultRequest();
                        request.setApplicationId(clientFundWithdrawApplyInfo.getApplicationId());
                        request.setWithdrawStatus(3);

                        ResponseVO response = pushFundWithdrawResult(request);

                        clientFundWithdrawApplyEntity.setApplicationStatus(BpmCommonEnum.FundWithdrawApplicationStatus.FUND_WITHDRAW_APPLY_STATUS_SUCCESS_VALUE);
                    }

                    if (BpmCommonEnum.FundWithdrawStatus.FUND_WITHDRAW_STATUS_FAILURE_VALUE == clientFundWithdrawInfo.getWithdrawStatus()) {
                        String backReason="";
                        // 发送短信通知
                        List<String> paramList = Lists.newArrayList();

                        paramList.clear();
                        paramList.add(clientFundWithdrawInfo.getClientName() != null ? clientFundWithdrawInfo.getClientName() : clientFundWithdrawInfo.getClientNameSpell());
                        paramList.add(clientFundWithdrawInfo.getOccurBalance() + CodeUtils.getCodeName("SEC_MONEY_TYPE_TRD", String.valueOf(clientFundWithdrawInfo.getMoneyType())));
//                        paramList.add(String.valueOf(clientFundWithdrawInfo.getApprovalOpinion()));

                        if (clientFundWithdrawInfo.getApprovalOpinion().contains("其他原因：")) {
                            backReason=clientFundWithdrawInfo.getApprovalOpinion().replace("其他原因：", "");
                        } else {
                            backReason=clientFundWithdrawInfo.getApprovalOpinion();
                        }
                        paramList.add(backReason);
                        // 发送短信
                        generateFundWithdrawRetSendSms(2005, clientFundWithdrawInfo.getPhoneNumber(), paramList);

                        // 回调APP
                        FundWithdrawResultRequest request = new FundWithdrawResultRequest();
                        request.setApplicationId(clientFundWithdrawApplyInfo.getApplicationId());
                        request.setWithdrawStatus(2);
                        request.setBackReason(backReason);

                        ResponseVO response = pushFundWithdrawResult(request);

                        clientFundWithdrawApplyEntity.setApplicationStatus(BpmCommonEnum.FundWithdrawApplicationStatus.FUND_WITHDRAW_APPLY_STATUS_FAILURE_VALUE);
                    }

                    clientFundWithdrawApplyEntity.setCallbackStatus(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
                    clientFundWithdrawApplyEntity.setApplicationId(clientFundWithdrawApplyInfo.getApplicationId());
                    clientFundWithdrawApplyEntity.setLastApprovalUser(processTaskDto.getDealId());
                    clientFundWithdrawApplyEntity.setApprovalOpinion(processTaskDto.getRemark());
                    clientFundWithdrawApplyEntity.setUpdateTime(new Date());

                    clientFundWithdrawApplyDao.updateByApplicationId(clientFundWithdrawApplyEntity);
                }
            }

            // 终止节点回调业务处理
            if (CodeUtils.getCodeName("FUND_WITHDRAW_NODE_NAME", "6").equals(clientFundWithdrawApplyInfo.getCurrentNode())) {

                ClientFundWithdrawApplyEntity clientFundWithdrawApplyEntity = new ClientFundWithdrawApplyEntity();
                String backReason="";
                if (clientFundWithdrawInfo.getApplicationStatus() != BpmCommonEnum.FundWithdrawApplicationStatus.FUND_WITHDRAW_APPLY_APPROVAL_CANCEL_VALUE) {
                    // 发送短信通知
                    List<String> paramList = Lists.newArrayList();
                    paramList.clear();
                    paramList.add(clientFundWithdrawInfo.getClientName() != null ? clientFundWithdrawInfo.getClientName() : clientFundWithdrawInfo.getClientNameSpell());
                    paramList.add(clientFundWithdrawInfo.getOccurBalance() + CodeUtils.getCodeName("SEC_MONEY_TYPE_TRD", String.valueOf(clientFundWithdrawInfo.getMoneyType())));

                    if (clientFundWithdrawInfo.getApprovalOpinion().contains("其他原因：")) {
                        backReason=clientFundWithdrawInfo.getApprovalOpinion().replace("其他原因：", "");
                    } else {
                        backReason=clientFundWithdrawInfo.getApprovalOpinion();
                    }
                    paramList.add(backReason);

                    // 发送短信
                    generateFundWithdrawRetSendSms(2003, clientFundWithdrawInfo.getPhoneNumber(), paramList);

                    clientFundWithdrawApplyEntity.setApplicationStatus(BpmCommonEnum.FundWithdrawApplicationStatus.FUND_WITHDRAW_APPLY_APPROVAL_REJECT_VALUE);
                }

                clientFundWithdrawApplyEntity.setCallbackStatus(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
                clientFundWithdrawApplyEntity.setWithdrawStatus(BpmCommonEnum.FundWithdrawStatus.FUND_WITHDRAW_STATUS_FAILURE_VALUE);
                clientFundWithdrawApplyEntity.setApplicationId(clientFundWithdrawApplyInfo.getApplicationId());
                clientFundWithdrawApplyEntity.setLastApprovalUser(processTaskDto.getDealId());
                clientFundWithdrawApplyEntity.setApprovalOpinion(processTaskDto.getRemark());
                clientFundWithdrawApplyEntity.setUpdateTime(new Date());

                clientFundWithdrawApplyDao.updateByApplicationId(clientFundWithdrawApplyEntity);

                // 回调APP
                FundWithdrawResultRequest request = new FundWithdrawResultRequest();
                request.setApplicationId(clientFundWithdrawApplyInfo.getApplicationId());
                request.setWithdrawStatus(2);
                request.setBackReason(backReason);

                ResponseVO response = pushFundWithdrawResult(request);
            }

            // 拼接流程审核记录串
            ClientFundWithdrawApplyEntity clientFundWithdrawApplyEntity = new ClientFundWithdrawApplyEntity();
            clientFundWithdrawApplyEntity.setApplicationId(clientFundWithdrawInfo.getApplicationId());
            clientFundWithdrawApplyEntity.setCurrentNode(clientFundWithdrawApplyInfo.getCurrentNode());
            clientFundWithdrawApplyEntity.setApplicationStatus(null);
            clientFundWithdrawApplyEntity.setLastApprovalUser(null);
//            clientFundWithdrawInfo.setApprovalOpinion(null);
            clientFundWithdrawApplyEntity.setAssignDrafter(null);
            clientFundWithdrawApplyEntity.setUpdateTime(new Date());

            if (!CodeUtils.getCodeName("FUND_WITHDRAW_NODE_NAME", "0").equals(clientFundWithdrawApplyInfo.getCurrentNode())) {
                clientFundWithdrawApplyDao.updateByApplicationId(clientFundWithdrawApplyEntity);
            }

            // 重置指定处理人为null
            clientFundWithdrawApplyDao.updateAssignDrafter(clientFundWithdrawApplyEntity);

        } catch (Exception e) {
            logger.error("出金工作流回调业务处理异常", e);
        }

    }

    /**
     * 分页查询出金记录
     *
     * @param clientFundWithdrawApplyEntity
     * @param pageNum
     * @return
     */
    @Override
    public Page<ClientFundWithdrawApplyEntity> findPage(ClientFundWithdrawApplyEntity clientFundWithdrawApplyEntity, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        PageHelper.startPage(pageNum, Constant.pageSize);
        clientFundWithdrawApplyDao.queryList(clientFundWithdrawApplyEntity);
        return PageHelper.endPage();
    }

    /**
     * 更新指定审核人
     *
     * @param entity
     * @return
     */
    @Override
    public int updateAssignDrafter(ClientFundWithdrawApplyEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFundWithdrawApplyDao.updateAssignDrafter(entity);
    }

    /**
     * 终止流程
     *
     * @param entity
     * @param processTaskDto
     * @return
     */
    @Override
    public boolean terminateApplication(ClientFundWithdrawApplyEntity entity, ProcessTaskDto processTaskDto) {

        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);

        ClientFundWithdrawApplyInfo clientFundWithdrawApplyInfo = new ClientFundWithdrawApplyInfo();

        clientFundWithdrawApplyInfo.setApplicationId(entity.getApplicationId());
        clientFundWithdrawApplyInfo.setCurrentNode(CodeUtils.getCodeName("FUND_WITHDRAW_NODE_NAME", "6"));

        // 更新申请表相关信息
        ClientFundWithdrawApplyEntity clientFundWithdrawApplyEntity = new ClientFundWithdrawApplyEntity();
        clientFundWithdrawApplyEntity.setApplicationId(clientFundWithdrawApplyInfo.getApplicationId());
        clientFundWithdrawApplyEntity.setUpdateTime(new Date());
        clientFundWithdrawApplyEntity.setLastApprovalUser(UserUtils.getCurrentUserId());
        clientFundWithdrawApplyEntity.setApprovalOpinion(entity.getApprovalOpinion());
        clientFundWithdrawApplyDao.updateByApplicationId(clientFundWithdrawApplyEntity);

        approveCallback(clientFundWithdrawApplyInfo, processTaskDto, null);

        return true;
    }

    /**
     * 更新流程信息
     *
     * @param entity
     * @param processTaskDto
     * @return
     */
    @Override
    public boolean updateProcessInfo(ClientFundWithdrawApplyEntity entity, ProcessTaskDto processTaskDto) {

        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);

        ClientFundWithdrawApplyInfo clientFundWithdrawApplyInfo = new ClientFundWithdrawApplyInfo();

        clientFundWithdrawApplyInfo.setApplicationId(entity.getApplicationId());

        // 更新申请表相关信息
        ClientFundWithdrawApplyEntity clientFundWithdrawApplyEntity = new ClientFundWithdrawApplyEntity();
        clientFundWithdrawApplyEntity.setApplicationId(clientFundWithdrawApplyInfo.getApplicationId());
        clientFundWithdrawApplyEntity.setUpdateTime(new Date());
        clientFundWithdrawApplyEntity.setApprovalOpinion(entity.getApprovalOpinion());
        clientFundWithdrawApplyEntity.setApplicationStatus(entity.getApplicationStatus());
        clientFundWithdrawApplyEntity.setCurrentNode(entity.getCurrentNode());
        clientFundWithdrawApplyEntity.setWithdrawStatus(entity.getWithdrawStatus());
        clientFundWithdrawApplyEntity.setCallbackStatus(entity.getCallbackStatus());
        clientFundWithdrawApplyEntity.setHsBankId(entity.getHsBankId());
        clientFundWithdrawApplyEntity.setHsBankAccount(entity.getHsBankAccount());
        clientFundWithdrawApplyEntity.setRemittanceType(entity.getRemittanceType());
        clientFundWithdrawApplyDao.updateByApplicationId(clientFundWithdrawApplyEntity);

        return true;
    }

    /**
     * 查询审核列表
     *
     * @param entity
     * @return
     */
    @Override
    public Page<ClientFundWithdrawApplyEntity> queryAuditList(ClientFundWithdrawApplyEntity entity, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        PageHelper.startPage(pageNum, Constant.pageSize);
        clientFundWithdrawApplyDao.queryAuditList(entity);
        return PageHelper.endPage();
    }

    /**
     * 出金业务短信通知生成
     *
     * @param templateCode
     * @param phoneNumber
     * @param paramList
     * @return
     */
    @Override
    public boolean generateFundWithdrawRetSendSms(Integer templateCode, String phoneNumber, List<String> paramList) {
        try {

            JSONObject paraMap = new JSONObject();

            paraMap.put("userType", 1);
            paraMap.put("sendType", 0);
            paraMap.put("phone", phoneNumber);
            paraMap.put("params", paramList);
            paraMap.put("templateCode", templateCode);

            MessageSendInfoEntity messageSendInfoEntity = new MessageSendInfoEntity();
            messageSendInfoEntity.setMessageType(BpmCommonEnum.MessageNoticeType.MESSAGE_NOTICE_TYPE_PLATFORM_SEND_SMS_VALUE);
            messageSendInfoEntity.setRecipients(ConfigUtils.get("message.center.sms.url"));
            messageSendInfoEntity.setMessageTitle("宝新证券出金业务通知");
            messageSendInfoEntity.setSendResult(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
            messageSendInfoEntity.setMessageContent(JSON.toJSONString(paraMap, SerializerFeature.WriteMapNullValue));
            messageSendInfoEntity.setContentType(1);
            messageSendInfoEntity.setAttachmentUris("");
            int isSucceed = messageSendInfoService.save(messageSendInfoEntity);

            return 1 == isSucceed;
        } catch (Exception e) {
            logger.error("出金业务短信发送异常", e);
        }

        return false;
    }

    /**
     * 批量更新
     *
     * @param applicationIds
     * @return
     */
    @Override
    public int updateBatchByApplicationIds(String applicationIds) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFundWithdrawApplyDao.updateBatchByApplicationIds(applicationIds);
    }

    /**
     * 通过预约号更新
     *
     * @param entity
     * @return
     */
    @Override
    public int updateByApplicationId(ClientFundWithdrawApplyEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFundWithdrawApplyDao.updateByApplicationId(entity);
    }


    /**
     * 出金业务审核处理结果推送
     *
     * @param request
     * @return
     */
    private static ResponseVO pushFundWithdrawResult(FundWithdrawResultRequest request) {
        try {

            GenericSunlineRequest<FundWithdrawResultRequest> genericRequest = new GenericSunlineRequest<>();


            genericRequest.setParams(request);

            logger.info("出金申请回调参数：" + JSON.toJSONString(genericRequest));

            String response = HttpClientUtils.postJson(ConfigUtils.get("sunline.service.url") + "/sec_api/update_fund_withdraw_status", JSON.toJSONString(genericRequest));

            logger.info("出金申请回调结果：" + response);

            return JSON.parseObject(response, ResponseVO.class);

        } catch (Exception e) {
            logger.error("出金业务审核处理结果推送异常：", e);
        }
        return null;
    }

    /**
     * 通过预约号批量查询
     *
     * @param applicationIds
     * @return
     */
    @Override
    public List<ClientFundWithdrawApplyEntity> queryByApplicationIds(String applicationIds) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFundWithdrawApplyDao.queryByApplicationIds(applicationIds);
    }
}
