package com.sunline.modules.account.professional.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Lists;
import com.sunline.common.ConfigUtils;
import org.activiti.engine.task.Task;
import com.sunline.modules.account.online.entity.OpenAccountProcessLogEntity;
import com.sunline.modules.account.online.service.OpenAccountProcessLogService;
import com.sunline.modules.account.professional.dao.ProfessionalInvestorApplicationDao;
import com.sunline.modules.account.professional.entity.ProfessionalInvestorApplicationEntity;
import com.sunline.modules.account.professional.model.query.ProfessionalAppQueryModel;
import com.sunline.modules.account.professional.protocol.ProfessionalApplyResultRequest;
import com.sunline.modules.account.professional.service.ProfessionalInvestorApplicationService;
import com.sunline.modules.activiti.dto.ProcessTaskDto;
import com.sunline.modules.activiti.entity.ExtendActTasklogEntity;
import com.sunline.modules.activiti.service.ActModelerService;
import com.sunline.modules.activiti.utils.ActUtils;
import com.sunline.modules.analysis.dao.ClientAssetFlowInfoDao;
import com.sunline.modules.analysis.entity.ClientFundCountEntity;
import com.sunline.modules.common.common.BpmCommonEnum;
import com.sunline.modules.common.common.CommonResponse;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.common.CrmCommonEnum;
import com.sunline.modules.common.exception.MyException;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.page.PageHelper;
import com.sunline.modules.common.pojo.rest.GenericSunlineRequest;
import com.sunline.modules.common.utils.*;
import com.sunline.modules.common.vo.ResponseVO;
import com.sunline.modules.fund.entity.ClientFundDepositImageEntity;
import com.sunline.modules.fund.service.ClientFundDepositImageService;
import com.sunline.modules.hundsun.protocol.request.FundAccountRequest;
import com.sunline.modules.hundsun.protocol.response.FundAccountResponse;
import com.sunline.modules.hundsun.service.HsCommManageService;
import com.sunline.modules.notice.entity.MessageSendInfoEntity;
import com.sunline.modules.notice.service.MessageSendInfoService;
import com.sunline.modules.sys.entity.UserEntity;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.activiti.engine.repository.ProcessDefinition;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 专业投资者认定申请信息表
 *
 * @author jim
 * @email jim@zszhizhu.com
 * @date 2019-12-04 11:31:49
 */

@Service("professionalInvestorApplicationService")
public class ProfessionalInvestorApplicationServiceImpl implements ProfessionalInvestorApplicationService {
    private static final Logger logger = LoggerFactory.getLogger(ProfessionalInvestorApplicationServiceImpl.class);
    private static final String PROFESSIONAL_FLOW_MODEL_KEY = "professionalApplication";
    @Autowired
    private ProfessionalInvestorApplicationDao professionalInvestorApplicationDao;
    @Autowired
    private ClientFundDepositImageService clientFundDepositImageService;
    @Autowired
    private ActModelerService actModelerService;
    @Autowired
    OpenAccountProcessLogService openAccountProcessLogService;
    @Autowired
    MessageSendInfoService messageSendInfoService;
    @Autowired
    private ClientAssetFlowInfoDao clientAssetFlowInfoDao;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public String commitApply(ProfessionalInvestorApplicationEntity applicationEntity, List<String> assetsImgs, List<String> addImgs) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        try {
            //生成唯一预约号
            UserEntity workflowUser = UserUtils.getBackgroundWorkflowUser();
            String applicationId = OrderUtil.getOrderNoByAtomic(8);
            ProfessionalInvestorApplicationEntity isExsistInfo = professionalInvestorApplicationDao.queryByApplicationId(applicationId);
            while (null != isExsistInfo) {
                applicationId = OrderUtil.getOrderNoByAtomic(8);
                isExsistInfo = professionalInvestorApplicationDao.queryByApplicationId(applicationId);
            }
            //保存凭证图片
            saveFundDepositImages(applicationId, assetsImgs, workflowUser.getId(), 3);
            saveFundDepositImages(applicationId, addImgs, workflowUser.getId(), 4);
            //保存申请信息
            applicationEntity.setApplicationId(applicationId);
            applicationEntity.setCurrentNode(CodeUtils.getCodeName("PROFESSIONAL_NODE_NAME", "0"));
            applicationEntity.setCreateUser(workflowUser.getId());
            applicationEntity.setStatus(Constant.ActStauts.APPROVAL.getValue());
            applicationEntity.setApproveResult(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
            applicationEntity.setApplicationStatus(BpmCommonEnum.ProfessionalApplicationStatus.PROFESSIONAL_APPLY_STATUS_INITCHECK_VALIUE);
            applicationEntity.setBapid(workflowUser.getBapid());
            applicationEntity.setBaid(workflowUser.getBaid());
            applicationEntity.setCreateTime(new Date());
            applicationEntity.setUpdateTime(new Date());
            applicationEntity.setFlowPath(CodeUtils.getCodeName("PROFESSIONAL_NODE_NAME", "0"));
            int save = professionalInvestorApplicationDao.save(applicationEntity);
            //启动工作流
            if (save > 0) {
                ProcessDefinition funDepositProcess = ActUtils.getlastProcessDefinition(PROFESSIONAL_FLOW_MODEL_KEY);
                ProcessTaskDto processTaskDto = new ProcessTaskDto();
                processTaskDto.setDefId(funDepositProcess.getId());
                processTaskDto.setBusId(applicationEntity.getApplicationId());
                processTaskDto.setActKey(funDepositProcess.getKey());
                processTaskDto.setNodeType("2");
                processTaskDto.setDealId(workflowUser.getId());
                actModelerService.startFlow(processTaskDto);
                return applicationEntity.getApplicationId();
            } else {
                return null;
            }
        } catch (Exception e) {
            logger.error("专业投资者申请启动工作流信息{}", JSON.toJSON(applicationEntity));
            logger.error("专业投资者申请启动工作流失败....", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return null;
        }
    }

    /**
     * 客户凭证
     *
     * @param userId  [操作人id]
     * @param imgType [0-入金客户凭证 1-入金银行凭证 2-专业投资者资产凭证 3-专业投资者补充凭证]
     * @return
     */
    private void saveFundDepositImages(String applicationId, List<String> images, String userId, int imgType) {
        if (null == images || images.size() < 0) {
            return;
        }
        String fileName = "";
        if (imgType == 3) {
            fileName = "资产凭证";
        }
        if (imgType == 4) {
            fileName = "补充凭证";
        }
        for (String url : images) {
            ClientFundDepositImageEntity image = new ClientFundDepositImageEntity();
            image.setApplicationId(applicationId);
            image.setFileName(fileName);
            image.setImageType(imgType);
            image.setFileStorageName(Utils.uuid());
            image.setStoragePath(ConfigUtils.get("crm.file.path") + "/professional/" + new SimpleDateFormat("yyyyMMdd").format(new Date()) + "/");
            image.setExtName(FileOperaterUtil.getFileExtendName(url));
            image.setCreateUser(userId);
            image.setUpdateUser(userId);
            image.setCreateTime(new Date());
            image.setUpdateTime(new Date());
            FileOperaterUtil.downloadFileByUrl(url, image.getStoragePath(), image.getFileStorageName());
            int count = clientFundDepositImageService.save(image);
        }
    }

    @Override
    public ProfessionalInvestorApplicationEntity queryByApplicationId(String applicationid) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return professionalInvestorApplicationDao.queryByApplicationId(applicationid);
    }

    @Override
    public void approveCallback(String currentNode, ProcessTaskDto processTaskDto,Task task) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        //查询申请
        ProfessionalInvestorApplicationEntity applicationEntity = professionalInvestorApplicationDao.queryByApplicationId(processTaskDto.getBusId());
        if (applicationEntity == null) {
            logger.error("[专业投资者流程操作]查询申请表失败:{}", processTaskDto.getBusId());
            throw new MyException("办理失败");
        }
        try {
            //初审
            if (CodeUtils.getCodeName("PROFESSIONAL_NODE_NAME", "1").equals(currentNode)) {
                ProfessionalInvestorApplicationEntity update = new ProfessionalInvestorApplicationEntity();
                update.setApplicationId(applicationEntity.getApplicationId());
                update.setApplicationStatus(BpmCommonEnum.ProfessionalApplicationStatus.PROFESSIONAL_APPLY_STATUS_INITCHECK_VALIUE);
                update.setLastApprovalUser(processTaskDto.getDealId());
                update.setApprovalOpinion(processTaskDto.getRemark());
                update.setUpdateTime(new Date());
                update.setUpdateUser(processTaskDto.getDealId());
                professionalInvestorApplicationDao.update(update);

                //新增业务流程日志记录
                OpenAccountProcessLogEntity openAccountProcessLogEntity = new OpenAccountProcessLogEntity();
                openAccountProcessLogEntity.setApplicationId(processTaskDto.getBusId());
                openAccountProcessLogEntity.setCurrentNode(currentNode);
                openAccountProcessLogEntity.setTaskId(Integer.valueOf(task.getId()));
                openAccountProcessLogEntity.setIsEdit(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsAdditional(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsBackWorkflow(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsBackApp(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsReject(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsRejectBlacklist(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setCreateUser(processTaskDto.getDealId());
                openAccountProcessLogEntity.setCreateTime(new Date());
                openAccountProcessLogService.save(openAccountProcessLogEntity);
            }
            //复审
            if (CodeUtils.getCodeName("PROFESSIONAL_NODE_NAME", "2").equals(currentNode)) {
                ProfessionalInvestorApplicationEntity update = new ProfessionalInvestorApplicationEntity();
                update.setApplicationId(applicationEntity.getApplicationId());
                update.setApplicationStatus(BpmCommonEnum.ProfessionalApplicationStatus.PROFESSIONAL_APPLY_STATUS_RECHECK_VALIUE);
                update.setLastApprovalUser(processTaskDto.getDealId());
                update.setApprovalOpinion(processTaskDto.getRemark());
                update.setUpdateTime(new Date());
                update.setUpdateUser(processTaskDto.getDealId());
                professionalInvestorApplicationDao.update(update);

                //新增业务流程日志记录
                OpenAccountProcessLogEntity openAccountProcessLogEntity = new OpenAccountProcessLogEntity();
                openAccountProcessLogEntity.setApplicationId(processTaskDto.getBusId());
                openAccountProcessLogEntity.setCurrentNode(currentNode);
                openAccountProcessLogEntity.setTaskId(Integer.valueOf(task.getId()));
                openAccountProcessLogEntity.setIsEdit(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsAdditional(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsBackWorkflow(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsBackApp(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsReject(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsRejectBlacklist(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setCreateUser(processTaskDto.getDealId());
                openAccountProcessLogEntity.setCreateTime(new Date());
                openAccountProcessLogService.save(openAccountProcessLogEntity);
            }
            //完成
            if (CodeUtils.getCodeName("PROFESSIONAL_NODE_NAME", "3").equals(currentNode)) {
                ProfessionalInvestorApplicationEntity update = new ProfessionalInvestorApplicationEntity();
                update.setApplicationId(applicationEntity.getApplicationId());
                update.setApplicationStatus(BpmCommonEnum.ProfessionalApplicationStatus.PROFESSIONAL_APPLY_STATUS_SUCCESS_VALIUE);
                update.setLastApprovalUser(processTaskDto.getDealId());
                update.setApprovalOpinion(processTaskDto.getRemark());
                update.setUpdateTime(new Date());
                update.setUpdateUser(processTaskDto.getDealId());
                update.setCallbackStatus(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
                update.setAccreditTime(new Date());
                update.setExpireTime(DateUtil.offset(new Date(), DateField.YEAR,1));
                professionalInvestorApplicationDao.update(update);

                //新增业务流程日志记录
                OpenAccountProcessLogEntity openAccountProcessLogEntity = new OpenAccountProcessLogEntity();
                openAccountProcessLogEntity.setApplicationId(processTaskDto.getBusId());
                openAccountProcessLogEntity.setCurrentNode(currentNode);
                openAccountProcessLogEntity.setTaskId(null);
                openAccountProcessLogEntity.setIsEdit(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsAdditional(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsBackWorkflow(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsBackApp(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsReject(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsRejectBlacklist(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setCreateUser(processTaskDto.getDealId());
                openAccountProcessLogEntity.setCreateTime(new Date());
                openAccountProcessLogService.save(openAccountProcessLogEntity);
            }
            //终止
            if (CodeUtils.getCodeName("PROFESSIONAL_NODE_NAME", "4").equals(currentNode)) {
                ProfessionalInvestorApplicationEntity update = new ProfessionalInvestorApplicationEntity();
                update.setApplicationId(applicationEntity.getApplicationId());
                update.setApplicationStatus(BpmCommonEnum.ProfessionalApplicationStatus.PROFESSIONAL_APPLY_STATUS_TERMINATION_VALIUE);
                update.setLastApprovalUser(processTaskDto.getDealId());
                update.setApprovalOpinion(processTaskDto.getRemark());
                update.setUpdateTime(new Date());
                update.setUpdateUser(processTaskDto.getDealId());
                professionalInvestorApplicationDao.update(update);

                // 新增业务流程日志记录
                OpenAccountProcessLogEntity openAccountProcessLogEntity = new OpenAccountProcessLogEntity();
                openAccountProcessLogEntity.setApplicationId(processTaskDto.getBusId());
                openAccountProcessLogEntity.setCurrentNode(currentNode);
                openAccountProcessLogEntity.setTaskId(null);
                openAccountProcessLogEntity.setIsEdit(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsAdditional(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsBackWorkflow(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsBackApp(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsReject(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsRejectBlacklist(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setCreateUser(processTaskDto.getDealId());
                openAccountProcessLogEntity.setCreateTime(new Date());
                openAccountProcessLogService.save(openAccountProcessLogEntity);
            }

            //更新审核流程记录
            ProfessionalInvestorApplicationEntity updateAssignDrafter = new ProfessionalInvestorApplicationEntity();
            updateAssignDrafter.setApplicationId(processTaskDto.getBusId());
            updateAssignDrafter.setFlowPath(applicationEntity.getFlowPath() + "——" + currentNode);
            updateAssignDrafter.setCurrentNode(currentNode);
            if (!CodeUtils.getCodeName("PROFESSIONAL_NODE_NAME", "0").equals(currentNode)) {
                professionalInvestorApplicationDao.update(updateAssignDrafter);
            }
            //更新处理人
            updateAssignDrafter.setAssignDrafter(null);
            updateAssignDrafter.setUpdateTime(new Date());
            professionalInvestorApplicationDao.updateAssignDrafter(updateAssignDrafter);
        } catch (Exception e) {
            logger.error("专业投资者认定工作流回调业务处理异常", e);
        }
    }

    @Override
    public boolean generateSendSms(Integer templateCode, String phoneNumber, List<String> paramList) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
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
            messageSendInfoEntity.setMessageTitle("专业投资者认定业务通知");
            messageSendInfoEntity.setSendResult(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
            messageSendInfoEntity.setMessageContent(JSON.toJSONString(paraMap, SerializerFeature.WriteMapNullValue));
            messageSendInfoEntity.setContentType(1);
            messageSendInfoEntity.setAttachmentUris("");
            int isSucceed = messageSendInfoService.save(messageSendInfoEntity);

            return 1 == isSucceed;
        } catch (Exception e) {
            logger.error("专业投资者认定业务通知短信发送异常", e);
        }

        return false;
    }

    /**
     * 发送邮件通知
     *
     * @param title
     * @param content
     * @param recipients
     */
    @Override
    public void generateSendEmail(String title, String content, String recipients) {
        MessageSendInfoEntity messageSendInfoEntity = new MessageSendInfoEntity();
        messageSendInfoEntity.setMessageType(BpmCommonEnum.MessageNoticeType.MESSAGE_NOTICE_TYPE_EMAIL_VALUE);
        messageSendInfoEntity.setRecipients(recipients);
        messageSendInfoEntity.setMessageTitle(title);
        messageSendInfoEntity.setSendResult(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
        messageSendInfoEntity.setMessageContent(content);
        messageSendInfoEntity.setContentType(0);

        messageSendInfoService.save(messageSendInfoEntity);
    }

    @Override
    public int updateAssignDrafter(ProfessionalInvestorApplicationEntity applyEntity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return professionalInvestorApplicationDao.updateAssignDrafter(applyEntity);
    }

    @Override
    public ResponseVO pushFundDepositResult(ProfessionalApplyResultRequest request) {
        try {

            GenericSunlineRequest<ProfessionalApplyResultRequest> genericRequest = new GenericSunlineRequest<>();

            genericRequest.setParams(request);

            logger.info("专业投资者认定申请回调参数：" + JSON.toJSONString(genericRequest));

            String response = HttpClientUtils.postJson(ConfigUtils.get("sunline.service.url") + "/professional_investor/update_status", JSON.toJSONString(genericRequest));

            logger.info("专业投资者认定申请回调结果：" + response);

            return JSON.parseObject(response, ResponseVO.class);

        } catch (Exception e) {
            logger.error("专业投资者认定业务结果推送异常：", e);
        }
        return null;
    }

    @Override
    public List<ExtendActTasklogEntity> joinBackReasonType(List<ExtendActTasklogEntity> tasklogList) {
        for (int i = 0; i < tasklogList.size(); i++) {
            List<String> backReasonTypeList = JSON.parseArray(tasklogList.get(i).getBackReasonType(), String.class);
            StringBuilder backReasonType = new StringBuilder();
            if (null != backReasonTypeList) {
                for (String type : backReasonTypeList) {
                    String conErrorType = CodeUtils.getCodeName("PROFESSIONA_BACK_TYPE", type);
                    if (StringUtils.isNotBlank(conErrorType)) {
                        backReasonType.append(conErrorType).append("，");
                    } else if (StringUtils.isNotBlank(backReasonType)) {
                        backReasonType.deleteCharAt(backReasonType.length() - 1).append("：").append(type).append("，");
                    }
                }
                tasklogList.get(i).setBackReasonType(backReasonType.length() > 0 ? backReasonType.substring(0, backReasonType.length() - 1) : "");
            }
        }
        return tasklogList;
    }

    @Override
    public boolean terminateApply(ProcessTaskDto processTaskDto, Integer applyStatus,String backReasons) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        String currentNode = CodeUtils.getCodeName("PROFESSIONAL_NODE_NAME", "4");
        approveCallback(currentNode, processTaskDto,null);

        ProfessionalInvestorApplicationEntity appEntity = new ProfessionalInvestorApplicationEntity();
        appEntity.setApplicationId(processTaskDto.getBusId());
        appEntity.setApplicationStatus(applyStatus);
        professionalInvestorApplicationDao.update(appEntity);

        //退回和终止信息推送
        appEntity = professionalInvestorApplicationDao.queryByApplicationId(processTaskDto.getBusId());
        List<String> paramList = Lists.newArrayList();
        paramList.add(StringUtils.isNotBlank(appEntity.getClientName()) ? appEntity.getClientName() : appEntity.getClientNameSpell());
        if (BpmCommonEnum.ProfessionalApplicationStatus.PROFESSIONAL_APPLY_STATUS_TERMINATION_VALIUE == applyStatus) {
            generateSendSms(2035, appEntity.getPhoneNumber(), paramList);

            pushFundDepositResult(new ProfessionalApplyResultRequest(processTaskDto.getBusId()
                    , BpmCommonEnum.ProfessionalApplicationStatus.PROFESSIONAL_APPLY_STATUS_TERMINATION_VALIUE, null));

        } else if (BpmCommonEnum.ProfessionalApplicationStatus.PROFESSIONAL_APPLY_STATUS_BACK_VALIUE == applyStatus) {
            List<String> backReasonTypeList = JSON.parseArray(backReasons, String.class);
            StringBuilder backReasonType = new StringBuilder();
            if (null != backReasonTypeList) {
                for (String type : backReasonTypeList) {
                    String conErrorType = CodeUtils.getCodeName("PROFESSIONA_BACK_TYPE", type);
                    if (StringUtils.isNotBlank(conErrorType)) {
                        backReasonType.append(conErrorType).append("，");
                    } else if (StringUtils.isNotBlank(backReasonType)) {
                        backReasonType.deleteCharAt(backReasonType.length() - 1).append("：").append(type).append("，");
                    }
                }
            }
            String backReason = backReasonType.length() > 0 ? backReasonType.substring(0, backReasonType.length() - 1) : "";
            paramList.add(backReason);
            generateSendSms(2034, appEntity.getPhoneNumber(), paramList);
            pushFundDepositResult(new ProfessionalApplyResultRequest(processTaskDto.getBusId()
                    , BpmCommonEnum.ProfessionalApplicationStatus.PROFESSIONAL_APPLY_STATUS_BACK_VALIUE
                    , backReason));
        }
        return true;
    }

    @Override
    public ClientFundCountEntity queryTotalAssetByDate(ClientFundCountEntity params) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        if (StringUtils.isBlank(params.getClientId()) || null == params.getStDate() || null == params.getEdDate()) {
            return null;
        }
        List<ClientFundCountEntity> assetsList = new ArrayList<>();

        ClientFundCountEntity query = new ClientFundCountEntity();
        query.setClientId(params.getClientId());
//        query.setFundAccount(params.getFundAccount());
        Date stDate = DateUtil.parse(params.getStDate());
        Date edDate = DateUtil.parse(params.getEdDate());

        ClientFundCountEntity clientAssetsInfo;

        //结束日期的月份
        String table = DateUtil.format(edDate, "yyyyMM");
        query.setTableName1("client_asset_flow_info_" + table);
        query.setStDate(DateUtil.format(DateUtil.beginOfMonth(edDate), "yyyy-MM-dd"));
        query.setEdDate(params.getEdDate());
        clientAssetsInfo = clientAssetFlowInfoDao.queryAssetsByDate(query);
        if (null != clientAssetsInfo) {
            clientAssetsInfo.setClientId(params.getClientId());
            clientAssetsInfo.setFundAccount(params.getFundAccount());
            return clientAssetsInfo;
        }

        //中间月份
        Date date = DateUtil.offsetMonth(DateUtil.beginOfMonth(edDate), -1);
        while (0 < DateUtil.between(date, DateUtil.beginOfMonth(stDate), DateUnit.DAY)) {
            table = DateUtil.format(date, "yyyyMM");
            query.setTableName1("client_asset_flow_info_" + table);
            query.setStDate(null);
            query.setEdDate(null);
            clientAssetsInfo = clientAssetFlowInfoDao.queryAssetsByDate(query);
            if (null != clientAssetsInfo) {
                clientAssetsInfo.setClientId(params.getClientId());
                clientAssetsInfo.setFundAccount(params.getFundAccount());
                return clientAssetsInfo;
            }
            date = DateUtil.offsetMonth(date, -1);
        }

        //开始日期的月份
        String stTable = DateUtil.format(stDate, "yyyyMM");
        String tableName = "client_asset_flow_info_" + stTable;
        query.setTableName1(tableName);
        query.setStDate(params.getStDate());
        query.setEdDate(DateUtil.format(DateUtil.endOfMonth(stDate), "yyyy-MM-dd"));
        clientAssetsInfo = clientAssetFlowInfoDao.queryAssetsByDate(query);
        if (null != clientAssetsInfo) {
            clientAssetsInfo.setClientId(params.getClientId());
            clientAssetsInfo.setFundAccount(params.getFundAccount());
            return clientAssetsInfo;
        }
        return null;
    }

    /**
     * 同步客户级别至柜台
     *
     * @param
     * @return
     */
    @Override
    public CommonResponse sysApplyToHs(FundAccountRequest.FundAccountGetRequest fundAccountGetRequest, Integer roomCode) {
        CommonResponse getResponse = HsCommManageService.send("hundsunProxyService/getHkFundAccount.do", fundAccountGetRequest);

        if (null != getResponse && String.valueOf(CrmCommonEnum.CodeType.OK.getCode()).equals(getResponse.getCommonErrorCode().getErrorCode())) {
            FundAccountResponse.FundAccountGetResponse fundAccountGetResponse = JSON.parseObject(JSON.toJSONString(getResponse.getDataResult()), FundAccountResponse.FundAccountGetResponse.class);

            FundAccountRequest.FundAccountModiRequest fundAccountModiRequest = new FundAccountRequest.FundAccountModiRequest();
            fundAccountModiRequest.setClientId(fundAccountGetResponse.getClientId());
            fundAccountModiRequest.setFundAccount(fundAccountGetResponse.getFundAccount());
            fundAccountModiRequest.setFundacctStatus(fundAccountGetResponse.getFundacctStatus());
            fundAccountModiRequest.setMainFlag(fundAccountGetResponse.getMainFlag());
            fundAccountModiRequest.setBankNo(fundAccountGetResponse.getBankNo());
            fundAccountModiRequest.setBankBatch(fundAccountGetResponse.getBankBatch());
            fundAccountModiRequest.setBankAC(fundAccountGetResponse.getBankAC());
            fundAccountModiRequest.setEnEntrustWay(fundAccountGetResponse.getEnEntrustWay());
            fundAccountModiRequest.setRestriction(fundAccountGetResponse.getRestriction());
            fundAccountModiRequest.setRoomCode(roomCode);
            fundAccountModiRequest.setClientGroup(fundAccountGetResponse.getClientGroup());
            fundAccountModiRequest.setFareKindStr(fundAccountGetResponse.getFareKindStr());
            fundAccountModiRequest.setOpenTrades(fundAccountGetResponse.getOpenTrades());
            fundAccountModiRequest.setProfitFlag(fundAccountGetResponse.getProfitFlag());
            fundAccountModiRequest.setRemark(fundAccountGetResponse.getRemark());
            fundAccountModiRequest.setAssetProp(fundAccountGetResponse.getAssetProp());
            fundAccountModiRequest.setOrganFlag(fundAccountGetResponse.getOrganFlag());
            fundAccountModiRequest.setSaveKeeping(fundAccountGetResponse.getSaveKeeping());
            fundAccountModiRequest.setClientMarked(fundAccountGetResponse.getClientMarked());
            fundAccountModiRequest.setCashRA(fundAccountGetResponse.getCashRA());
            fundAccountModiRequest.setValidDate(fundAccountGetResponse.getValidDate());
            fundAccountModiRequest.setExpiryDateExpiry(fundAccountGetResponse.getExpiryDateExpiry());
            fundAccountModiRequest.setFareKindPrior(fundAccountGetResponse.getFareKindPrior());
            fundAccountModiRequest.setFareKindPost(fundAccountGetResponse.getFareKindPost());

            return HsCommManageService.send("hundsunProxyService/modiHkFundAccount.do", fundAccountModiRequest);
        } else {
            logger.error("profesional investor job error - clientId:{}", fundAccountGetRequest.getClientId());
            return null;
        }
    }

    @Override
    public ProfessionalInvestorApplicationEntity queryObject(Long id) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return professionalInvestorApplicationDao.queryObject(id);
    }

    @Override
    public List<ProfessionalInvestorApplicationEntity> queryList(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return professionalInvestorApplicationDao.queryList(map);
    }

    @Override
    public List<ProfessionalInvestorApplicationEntity> queryListByBean(ProfessionalInvestorApplicationEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return professionalInvestorApplicationDao.queryListByBean(entity);
    }

    @Override
    public Page queryCheckList(ProfessionalAppQueryModel query, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        PageHelper.startPage(pageNum, Constant.pageSize);
        professionalInvestorApplicationDao.queryCheckList(query);
        return PageHelper.endPage();
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return professionalInvestorApplicationDao.queryTotal(map);
    }

    @Override
    public int save(ProfessionalInvestorApplicationEntity professionalInvestorApplication) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return professionalInvestorApplicationDao.save(professionalInvestorApplication);
    }

    @Override
    public int update(ProfessionalInvestorApplicationEntity professionalInvestorApplication) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return professionalInvestorApplicationDao.update(professionalInvestorApplication);
    }

    @Override
    public int delete(Long id) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return professionalInvestorApplicationDao.delete(id);
    }

    @Override
    public int deleteBatch(Long[] ids) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return professionalInvestorApplicationDao.deleteBatch(ids);
    }

}
