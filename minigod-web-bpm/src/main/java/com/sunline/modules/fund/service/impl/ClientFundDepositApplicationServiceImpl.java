package com.sunline.modules.fund.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.github.pagehelper.util.StringUtil;
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
import com.sunline.modules.common.utils.*;
import com.sunline.modules.common.vo.ResponseVO;
import com.sunline.modules.fund.dao.ClientFundDepositApplicationDao;
import com.sunline.modules.fund.entity.ClientFundDepositApplicationEntity;
import com.sunline.modules.fund.entity.ClientFundDepositImageEntity;
import com.sunline.modules.fund.model.ClientFundDepositWorkFlow;
import com.sunline.modules.fund.proxy.request.FundDepositResultRequest;
import com.sunline.modules.fund.service.ClientFundDepositApplicationService;
import com.sunline.modules.fund.service.ClientFundDepositImageService;
import com.sunline.modules.notice.entity.MessageSendInfoEntity;
import com.sunline.modules.notice.service.MessageSendInfoService;
import com.sunline.modules.sys.entity.RoleEntity;
import com.sunline.modules.sys.entity.UserEntity;
import com.sunline.modules.sys.service.RoleService;
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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 客户入金申请信息表
 *
 * @author lidh
 * @email jim@zszhizhu.com
 * @date 2019-06-01 14:52:31
 */

@Service("clientFundDepositApplicationService")
public class ClientFundDepositApplicationServiceImpl implements ClientFundDepositApplicationService {
    private static final Logger logger = LoggerFactory.getLogger(ClientFundDepositApplicationServiceImpl.class);
    private static final String CLIENT_FUND_DEPOSIT_FLOW_MODEL_KEY = "fundDepositApplication";
    @Autowired
    private ClientFundDepositApplicationDao clientFundDepositApplicationDao;
    @Autowired
    ActModelerService actModelerService;
    @Autowired
    ClientFundDepositImageService clientFundDepositImageService;
    @Autowired
    private MessageSendInfoService messageSendInfoService;

    @Autowired
    RoleService roleService;

    @Override
    public ClientFundDepositApplicationEntity queryObject(Long id) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFundDepositApplicationDao.queryObject(id);
    }

    @Override
    public List<ClientFundDepositApplicationEntity> queryList(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFundDepositApplicationDao.queryList(map);
    }

    @Override
    public List<ClientFundDepositApplicationEntity> queryListByBean(ClientFundDepositApplicationEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFundDepositApplicationDao.queryListByBean(entity);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFundDepositApplicationDao.queryTotal(map);
    }

    @Override
    public int save(ClientFundDepositApplicationEntity clientFundDepositApplication) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
//        clientFundDepositApplication.setId(Utils.uuid());
        return clientFundDepositApplicationDao.save(clientFundDepositApplication);
    }

    @Override
    public int update(ClientFundDepositApplicationEntity clientFundDepositApplication) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFundDepositApplicationDao.update(clientFundDepositApplication);
    }

    @Override
    public int delete(Long id) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFundDepositApplicationDao.delete(id);
    }

    @Override
    public int deleteBatch(Long[] ids) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFundDepositApplicationDao.deleteBatch(ids);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String commitFundDepositApply(ClientFundDepositApplicationEntity clientFundDepositApplication, List<String> images) {
        try {

            DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);

            UserEntity workflowUser = UserUtils.getBackgroundWorkflowUser();
            String applicationId = OrderUtil.getOrderNoByAtomic(7);
            ClientFundDepositApplicationEntity isExsistInfo = clientFundDepositApplicationDao.queryByApplicationId(applicationId);
            while (null != isExsistInfo) {
                applicationId = OrderUtil.getOrderNoByAtomic(7);
                isExsistInfo = clientFundDepositApplicationDao.queryByApplicationId(applicationId);
            }
            clientFundDepositApplication.setApplicationId(applicationId);
            clientFundDepositApplication.setCurrentNode(CodeUtils.getCodeName("FUND_DEPOSIT_NODE_NAME", "0"));
            clientFundDepositApplication.setCreateUser(workflowUser.getId());
            clientFundDepositApplication.setStatus(Constant.ActStauts.DRAFT.getValue());
            clientFundDepositApplication.setApproveResult(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
            clientFundDepositApplication.setApplicationStatus(BpmCommonEnum.FundDepositApplicationStatus.FUND_DEPOSIT_APPLY_STATUS_WAIT_VALUE);
            clientFundDepositApplication.setBapid(workflowUser.getBapid());
            clientFundDepositApplication.setBaid(workflowUser.getBaid());
            clientFundDepositApplication.setCreateTime(new Date());
            clientFundDepositApplication.setUpdateTime(new Date());
            clientFundDepositApplication.setFireAid(0);
            saveFundDepositImages(applicationId, images, workflowUser.getId());
            int count = clientFundDepositApplicationDao.save(clientFundDepositApplication);
            if (count > 0) {
                ProcessDefinition funDepositProcess = ActUtils.getlastProcessDefinition(CLIENT_FUND_DEPOSIT_FLOW_MODEL_KEY);
                ProcessTaskDto processTaskDto = new ProcessTaskDto();
                processTaskDto.setDefId(funDepositProcess.getId());
                processTaskDto.setBusId(clientFundDepositApplication.getApplicationId());
                processTaskDto.setActKey(funDepositProcess.getKey());
                processTaskDto.setNodeType("2");
                actModelerService.startFlow(processTaskDto);
                return clientFundDepositApplication.getApplicationId();
            } else {
                return null;
            }
        } catch (Exception e) {
            logger.error("入金申请启动工作流失败....", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return null;
        }
    }

    /**
     * 星展银行跳过凭证处理
     */
    @Override
    public void skipFundDepositImages(String applicationId){
        try {
            ClientFundDepositApplicationEntity depositApplicationEntity = clientFundDepositApplicationDao.queryByApplicationId(applicationId);
            UserEntity workflowUser = UserUtils.getBackgroundWorkflowUser();
            //如果入金是星展银行自动跳过凭证处理 benefit_bank=1
            if(StringUtil.isNotEmpty(depositApplicationEntity.getBenefitBank()) && "1".equals(depositApplicationEntity.getBenefitBank())){
                ClientFundDepositApplicationEntity updateApplication = new ClientFundDepositApplicationEntity();
                updateApplication.setId(depositApplicationEntity.getId());
                updateApplication.setApplicationStatus(BpmCommonEnum.FundDepositApplicationStatus.FUND_DEPOSIT_APPLY_STATUS_WAIT_VALUE);
                updateApplication.setLastApprovalUser(workflowUser.getId());
                updateApplication.setUpdateTime(new Date());
                updateApplication.setUpdateUser(workflowUser.getId());
                clientFundDepositApplicationDao.update(updateApplication);
                // 驱动工作流到下一步
                actModelerService.doNextFlow(depositApplicationEntity.getApplicationId(), depositApplicationEntity.getInstanceId(), "");
            }
        } catch (Exception e) {
            logger.error(applicationId+"星展银行入金跳过凭证处理失败....", e);
        }
    }

    /**
     * 客户凭证
     *
     * @return
     */
    private void saveFundDepositImages(String applicationId, List<String> images, String userId) {
        if (null == images || images.size() < 0) {
            return;
        }
        for (String url : images) {
            ClientFundDepositImageEntity image = new ClientFundDepositImageEntity();
            image.setApplicationId(applicationId);
            image.setFileName("客户凭证");
            image.setImageType(0);
            image.setFileStorageName(Utils.uuid());
            image.setStoragePath(ConfigUtils.get("crm.file.path") + "/deposit/" + new SimpleDateFormat("yyyyMMdd").format(new Date()) + "/");
            image.setExtName(FileOperaterUtil.getFileExtendName(url));
            image.setCreateUser(userId);
            image.setUpdateUser(userId);
            image.setCreateTime(new Date());
            image.setUpdateTime(new Date());
            FileOperaterUtil.downloadFileByUrl(url, image.getStoragePath(), image.getFileStorageName());
//            FileUpload.getHtmlPicture(url,image.getStoragePath(),image.getFileStorageName());
            int count = clientFundDepositImageService.save(image);
        }
    }

    @Override
    public Page<ClientFundDepositApplicationEntity> findPage(ClientFundDepositApplicationEntity clientFundDepositApplication, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        PageHelper.startPage(pageNum, Constant.pageSize);
        clientFundDepositApplicationDao.queryList(clientFundDepositApplication);
        return PageHelper.endPage();
    }

    @Override
    public List<ClientFundDepositApplicationEntity> queryList(ClientFundDepositApplicationEntity clientFundDepositApplication) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFundDepositApplicationDao.queryList(clientFundDepositApplication);
    }

    @Override
    public ClientFundDepositApplicationEntity queryByApplicationId(String applicationid) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFundDepositApplicationDao.queryByApplicationId(applicationid);
    }

    @Override
    public void approveCallback(ClientFundDepositWorkFlow workFlow, ProcessTaskDto processTaskDto, Task task) {
        try {
            ClientFundDepositApplicationEntity depositApplicationEntity = clientFundDepositApplicationDao.queryByApplicationId(workFlow.getApplicationId());
            //凭证处理
            if (CodeUtils.getCodeName("FUND_DEPOSIT_NODE_NAME", "1").equals(workFlow.getCurrentNode())) {
                depositApplicationEntity.setApplicationStatus(BpmCommonEnum.FundDepositApplicationStatus.FUND_DEPOSIT_APPLY_STATUS_WAIT_VALUE);
                depositApplicationEntity.setLastApprovalUser(processTaskDto.getDealId());
                depositApplicationEntity.setApprovalOpinion(processTaskDto.getRemark());
                depositApplicationEntity.setUpdateTime(new Date());
                depositApplicationEntity.setUpdateUser(UserUtils.getBackgroundWorkflowUser().getId());
                clientFundDepositApplicationDao.update(depositApplicationEntity);
            }
            //审核
            if (CodeUtils.getCodeName("FUND_DEPOSIT_NODE_NAME", "2").equals(workFlow.getCurrentNode())) {
                depositApplicationEntity.setApplicationStatus(BpmCommonEnum.FundDepositApplicationStatus.FUND_DEPOSIT_APPLY_STATUS_CHECK_VALUE);
                depositApplicationEntity.setLastApprovalUser(processTaskDto.getDealId());
                depositApplicationEntity.setApprovalOpinion(processTaskDto.getRemark());
                depositApplicationEntity.setUpdateTime(new Date());
                String currentUserId = null;
                try {
                    currentUserId = UserUtils.getCurrentUserId();
                } catch (Exception e) {
                    UserEntity workflowUser = UserUtils.getBackgroundWorkflowUser();
                    currentUserId = workflowUser.getId();
                }
                depositApplicationEntity.setUpdateUser(currentUserId);
                clientFundDepositApplicationDao.update(depositApplicationEntity);
            }
            //复审
//            if(CodeUtils.getCodeName("FUND_DEPOSIT_NODE_NAME","3").equals(depositApplicationEntity.getCurrentNode())){
//                depositApplicationEntity.setApplicationStatus(BpmCommonEnum.FundDepositApplicationStatus.FUND_DEPOSIT_APPLY_STATUS_CHECK_VALUE);
//                depositApplicationEntity.setLastApprovalUser(processTaskDto.getDealId());
//                depositApplicationEntity.setApprovalOpinion(processTaskDto.getRemark());
//                depositApplicationEntity.setUpdateTime(new Date());
//                depositApplicationEntity.setUpdateUser(UserUtils.getCurrentUserId());
//                clientFundDepositApplicationDao.update(depositApplicationEntity);
//            }
            //入账处理
            if (CodeUtils.getCodeName("FUND_DEPOSIT_NODE_NAME", "4").equals(workFlow.getCurrentNode())) {
                depositApplicationEntity.setApplicationStatus(BpmCommonEnum.FundDepositApplicationStatus.FUND_DEPOSIT_APPLY_STATUS_ENTRY_WAIT_VALUE);
                depositApplicationEntity.setLastApprovalUser(processTaskDto.getDealId());
                depositApplicationEntity.setApprovalOpinion(processTaskDto.getRemark());
                depositApplicationEntity.setUpdateTime(new Date());
                String currentUserId = null;
                try {
                    currentUserId = UserUtils.getCurrentUserId();
                } catch (Exception e) {
                    UserEntity workflowUser = UserUtils.getBackgroundWorkflowUser();
                    currentUserId = workflowUser.getId();
                }
                depositApplicationEntity.setUpdateUser(currentUserId);
                clientFundDepositApplicationDao.update(depositApplicationEntity);
            }
            //结束
            if (CodeUtils.getCodeName("FUND_DEPOSIT_NODE_NAME", "5").equals(workFlow.getCurrentNode())) {
                if(!CodeUtils.getCodeName("FUND_DEPOSIT_NODE_NAME", "6").equals(depositApplicationEntity.getCurrentNode())) {
                    depositApplicationEntity.setApplicationStatus(BpmCommonEnum.FundDepositApplicationStatus.FUND_DEPOSIT_APPLY_STATUS_ENTRY_VALUE);
                    depositApplicationEntity.setCallbackStatus(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
                    depositApplicationEntity.setLastApprovalUser(processTaskDto.getDealId());
                    depositApplicationEntity.setApprovalOpinion(processTaskDto.getRemark());
                    depositApplicationEntity.setUpdateTime(new Date());
                    String currentUserId = null;
                    try {
                        currentUserId = UserUtils.getCurrentUserId();
                    } catch (Exception e) {
                        UserEntity workflowUser = UserUtils.getBackgroundWorkflowUser();
                        currentUserId = workflowUser.getId();
                    }
                    depositApplicationEntity.setUpdateUser(currentUserId);
                    depositApplicationEntity.setFireAid(0);
                    clientFundDepositApplicationDao.update(depositApplicationEntity);
                }
            }
            //终止
            if (CodeUtils.getCodeName("FUND_DEPOSIT_NODE_NAME", "6").equals(workFlow.getCurrentNode())) {
                List<String> paramList = Lists.newArrayList();
                paramList.add(depositApplicationEntity.getClientName() != null ? depositApplicationEntity.getClientName() : depositApplicationEntity.getClientNameSpell());
                paramList.add(depositApplicationEntity.getDepositBalance() + CodeUtils.getCodeName("SEC_MONEY_TYPE_TRD", depositApplicationEntity.getMoneyType()));
                String backReason = "";
                if (depositApplicationEntity.getApprovalOpinion().contains("其他原因：")) {
                    backReason = depositApplicationEntity.getApprovalOpinion().replace("其他原因：", "");
                } else {
                    backReason = depositApplicationEntity.getApprovalOpinion();
                }
                paramList.add(backReason);
                //回调中台
                pushFundDepositResult(new FundDepositResultRequest(depositApplicationEntity.getApplicationId(), 2, backReason));
                //短信发送
                generateSendSms(2015, depositApplicationEntity.getPhoneNumber(), paramList);

                depositApplicationEntity.setApplicationStatus(BpmCommonEnum.FundDepositApplicationStatus.FUND_DEPOSIT_APPLY_STATUS_REJECT_VALUE);
                depositApplicationEntity.setCallbackStatus(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
                depositApplicationEntity.setLastApprovalUser(processTaskDto.getDealId());
                depositApplicationEntity.setApprovalOpinion(processTaskDto.getRemark());
                depositApplicationEntity.setUpdateTime(new Date());
                depositApplicationEntity.setUpdateUser(UserUtils.getCurrentUserId());
                depositApplicationEntity.setFireAid(0);
                clientFundDepositApplicationDao.update(depositApplicationEntity);
            }
            ClientFundDepositApplicationEntity entity = new ClientFundDepositApplicationEntity();
            entity.setApplicationId(depositApplicationEntity.getApplicationId());
            entity.setCurrentNode(workFlow.getCurrentNode());
            entity.setApplicationStatus(null);
            entity.setLastApprovalUser(null);
            entity.setAssignDrafter(null);
            entity.setUpdateTime(new Date());
            if (!CodeUtils.getCodeName("FUND_DEPOSIT_NODE_NAME", "0").equals(workFlow.getCurrentNode())) {
                clientFundDepositApplicationDao.update(entity);
            }
            clientFundDepositApplicationDao.updateAssignDrafter(entity);
        } catch (Exception e) {
            logger.error("入金工作流回调业务处理异常", e);
        }
    }


    @Override
    public ResponseVO pushFundDepositResult(FundDepositResultRequest request) {
        try {

            GenericSunlineRequest<FundDepositResultRequest> genericRequest = new GenericSunlineRequest<>();

            genericRequest.setParams(request);

            logger.info("入金申请回调参数：" + JSON.toJSONString(genericRequest));

            String response = HttpClientUtils.postJson(ConfigUtils.get("sunline.service.url") + "/sec_api/update_deposit_funds_status", JSON.toJSONString(genericRequest));

            logger.info("入金申请回调结果：" + response);

            return JSON.parseObject(response, ResponseVO.class);

        } catch (Exception e) {
            logger.error("入金业务结果推送异常：", e);
        }
        return null;
    }

    @Override
    public boolean generateSendSms(Integer templateCode, String phoneNumber, List<String> paramList) {
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
            messageSendInfoEntity.setMessageTitle("宝新证券入金业务通知");
            messageSendInfoEntity.setSendResult(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
            messageSendInfoEntity.setMessageContent(JSON.toJSONString(paraMap, SerializerFeature.WriteMapNullValue));
            messageSendInfoEntity.setContentType(1);
            messageSendInfoEntity.setAttachmentUris("");
            int isSucceed = messageSendInfoService.save(messageSendInfoEntity);

            return 1 == isSucceed;
        } catch (Exception e) {
            logger.error("入金业务短信发送异常", e);
        }

        return false;
    }

    @Override
    public int updateAssignDrafter(ClientFundDepositApplicationEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFundDepositApplicationDao.updateAssignDrafter(entity);
    }

    @Override
    public boolean terminateApplication(ClientFundDepositApplicationEntity entity, ProcessTaskDto processTaskDto) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        ClientFundDepositWorkFlow workFlow = new ClientFundDepositWorkFlow();

        workFlow.setApplicationId(entity.getApplicationId());
        workFlow.setCurrentNode(CodeUtils.getCodeName("FUND_DEPOSIT_NODE_NAME", "6"));

        approveCallback(workFlow, processTaskDto, null);

        return true;
    }

    @Override
    public Page<ClientFundDepositApplicationEntity> queryInfoList(ClientFundDepositApplicationEntity entity, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        PageHelper.startPage(pageNum, Constant.pageSize);
        clientFundDepositApplicationDao.queryInfoList(entity);
        return PageHelper.endPage();
    }

    @Override
    public int myFundDepositCount() {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        ClientFundDepositApplicationEntity query = new ClientFundDepositApplicationEntity();
        List<String> currentNodes = new ArrayList<>();
        Map<String, List<String>> modelNodeRoleList = null;
        try {
            modelNodeRoleList = actModelerService.getModelNodeUser(SysConfigUtil.getSysConfigValue("FUND_DEPOSIT_MODEL_ID", null));
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<RoleEntity> roleList = roleService.queryByUserId(UserUtils.getCurrentUserId(), "0");
        for (String key : modelNodeRoleList.keySet()) {
            List<String> modelNodeRole = modelNodeRoleList.get(key);
            for (String aModelNodeRole : modelNodeRole) {
                for (RoleEntity role : roleList) {
                    if (role.getId().equals(aModelNodeRole)) {
                        currentNodes.add(key);
                    }
                }
            }
        }

        //超级管理员不做权限验证
        if (UserUtils.getCurrentUserId().equals(Constant.SUPERR_USER)) {
            query.setCurrentNode(null);
        } else {
            query.setCurrentNodes(currentNodes.size() > 0 ? currentNodes : Lists.newArrayList());
        }

        query.setAssignDrafter(UserUtils.getCurrentUserId());
        return clientFundDepositApplicationDao.myFundDepositCount(query);
    }

    @Override
    public int updateBatchByApplicationIds(String applicationIds) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        String[] applicationId = applicationIds.split(",");
        return clientFundDepositApplicationDao.updateBatchByApplicationIds(applicationId);
    }

    @Override
    public Page<ClientFundDepositApplicationEntity> queryBankCheckList(ClientFundDepositApplicationEntity entity, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        PageHelper.startPage(pageNum, Constant.pageSize);
        clientFundDepositApplicationDao.queryBankCheckList(entity);
        return PageHelper.endPage();
    }

}
