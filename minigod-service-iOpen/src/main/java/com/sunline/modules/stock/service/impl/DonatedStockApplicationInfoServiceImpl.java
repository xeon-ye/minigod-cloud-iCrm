package com.sunline.modules.stock.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Maps;
import com.sunline.common.ConfigUtils;
import com.sunline.modules.activiti.dto.ProcessTaskDto;
import com.sunline.modules.api.entity.SecuritiesUserModel;
import com.sunline.modules.api.service.SecuritiesUserInfoService;
import com.sunline.modules.common.common.BpmCommonEnum;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.page.PageHelper;
import com.sunline.modules.common.pojo.rest.GenericHsRequest;
import com.sunline.modules.common.utils.*;
import com.sunline.modules.common.vo.ResponseVO;
import com.sunline.modules.hundsun.protocol.request.FundRequest;
import com.sunline.modules.hundsun.service.HsStockManageService;
import com.sunline.modules.notice.entity.MessageSendInfoEntity;
import com.sunline.modules.notice.entity.NoticeCaseEntity;
import com.sunline.modules.notice.service.MessageSendInfoService;
import com.sunline.modules.notice.service.NoticeCaseService;
import com.sunline.modules.stock.dao.DonatedStockApplicationInfoDao;
import com.sunline.modules.stock.entity.DonatedStockApplicationInfoEntity;
import com.sunline.modules.stock.entity.StockOrderInfoEntity;
import com.sunline.modules.stock.entity.StockPositionEntity;
import com.sunline.modules.stock.model.DonatedStockApproveInfo;
import com.sunline.modules.stock.service.DonatedStockApplicationInfoService;
import com.sunline.modules.stock.utils.StockUtils;
import com.sunline.modules.sys.entity.NoticeEntity;
import com.sunline.modules.sys.entity.RoleEntity;
import com.sunline.modules.sys.entity.UserEntity;
import com.sunline.modules.sys.service.RoleService;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 赠股申请信息表
 *
 * @author fuyy
 * @email
 * @date 2018-12-07 15:05:58
 */

@Service("donatedStockApplicationInfoService")
public class DonatedStockApplicationInfoServiceImpl implements DonatedStockApplicationInfoService {

    private static final Logger logger = LoggerFactory.getLogger(DonatedStockApplicationInfoServiceImpl.class);

    @Autowired
    SecuritiesUserInfoService securitiesUserInfoService;
    @Autowired
    DonatedStockApplicationInfoService donatedStockService;
    @Autowired
    DonatedStockApplicationInfoDao donatedStockApplicationInfoDao;
    @Autowired
    MessageSendInfoService messageSendInfoService;
    @Autowired
    NoticeCaseService noticeCaseService;
    @Autowired
    RoleService roleService;

    @Override
    public DonatedStockApplicationInfoEntity queryObject(Long id) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return donatedStockApplicationInfoDao.queryObject(id);
    }

    @Override
    public List<DonatedStockApplicationInfoEntity> queryList(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return donatedStockApplicationInfoDao.queryList(map);
    }

    @Override
    public List<DonatedStockApplicationInfoEntity> queryListByBean(DonatedStockApplicationInfoEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return donatedStockApplicationInfoDao.queryListByBean(entity);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return donatedStockApplicationInfoDao.queryTotal(map);
    }

    @Override
    public int save(DonatedStockApplicationInfoEntity donatedStockApplicationInfo) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        UserEntity supperUser = UserUtils.getManagerUser();

        // 检验预约流水号的唯一性
        String applicationId = OrderUtil.getOrderNoByAtomic(3);
        DonatedStockApplicationInfoEntity donatedStock = donatedStockApplicationInfoDao.queryByApplicationId(applicationId);
        while (null != donatedStock) {
            applicationId = OrderUtil.getOrderNoByAtomic(3);
            donatedStock = donatedStockApplicationInfoDao.queryByApplicationId(applicationId);
        }

        donatedStockApplicationInfo.setCode(applicationId);
        donatedStockApplicationInfo.setApplicationId(donatedStockApplicationInfo.getCode());
        donatedStockApplicationInfo.setCreateUser(supperUser.getId());
        donatedStockApplicationInfo.setCreateTime(new Date());
        donatedStockApplicationInfo.setUpdateTime(new Date());
        donatedStockApplicationInfo.setStatus(Constant.ActStauts.DRAFT.getValue());
        donatedStockApplicationInfo.setBapid(supperUser.getBapid());
        donatedStockApplicationInfo.setBaid(supperUser.getBaid());
        donatedStockApplicationInfo.setApplicationStatus(BpmCommonEnum.DonatedStockApplicationStatus.DONATED_STK_APPLICATE_STATUS_INITIAL_AUDIT_VALUE);
        donatedStockApplicationInfo.setStampDutyStatus(1);
        donatedStockApplicationInfo.setPrintStatus(1);
        return donatedStockApplicationInfoDao.save(donatedStockApplicationInfo);
    }

    @Override
    public int update(DonatedStockApplicationInfoEntity donatedStockApplicationInfo) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return donatedStockApplicationInfoDao.update(donatedStockApplicationInfo);
    }

    @Override
    public int delete(Long id) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return donatedStockApplicationInfoDao.delete(id);
    }

    @Override
    public int deleteBatch(Long[] ids) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return donatedStockApplicationInfoDao.deleteBatch(ids);
    }

    /**
     * 领取列表分页查询
     *
     * @param query
     * @param pageNum
     * @return
     */
    @Override
    public Page<DonatedStockApplicationInfoEntity> findPageList(DonatedStockApplicationInfoEntity query, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        PageHelper.startPage(pageNum, Constant.pageSize);
        donatedStockApplicationInfoDao.selectApproveList(query);
        return PageHelper.endPage();
    }

    /**
     * 工作流回调业务处理
     *
     * @param donatedStockApproveInfo
     * @param processTaskDto
     * @param task
     */
    @Override
    public void approveCallback(DonatedStockApproveInfo donatedStockApproveInfo, ProcessTaskDto processTaskDto, Task task) {
        try {

            DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
            DonatedStockApplicationInfoEntity applicationInfo = queryByApplicationId(donatedStockApproveInfo.getApplicationId());

            // 初审节点回调业务处理
            if (CodeUtils.getCodeName("OPEN_ACCOUNT_NODE_NAME", "1").equals(donatedStockApproveInfo.getCurrentNode())) {

                // 更新赠股申请信息表
                DonatedStockApplicationInfoEntity donatedStockApplyEntity = new DonatedStockApplicationInfoEntity();
                donatedStockApplyEntity.setApplicationId(applicationInfo.getApplicationId());
                donatedStockApplyEntity.setApplicationStatus(BpmCommonEnum.DonatedStockApplicationStatus.DONATED_STK_APPLICATE_STATUS_INITIAL_AUDIT_VALUE);
                donatedStockApplyEntity.setUpdateTime(new Date());
                donatedStockApplyEntity.setLastApprovalUser(processTaskDto.getDealId());
                donatedStockApplyEntity.setApprovalOpinion(processTaskDto.getRemark());

                donatedStockService.updateByApplicationId(donatedStockApplyEntity);

            }

            // 复审节点回调业务处理
            if (CodeUtils.getCodeName("OPEN_ACCOUNT_NODE_NAME", "2").equals(donatedStockApproveInfo.getCurrentNode())) {

                // 更新赠股申请信息表
                DonatedStockApplicationInfoEntity customerAccOpenApplyEntity = new DonatedStockApplicationInfoEntity();
                customerAccOpenApplyEntity.setApplicationId(donatedStockApproveInfo.getApplicationId());
                customerAccOpenApplyEntity.setApplicationStatus(BpmCommonEnum.DonatedStockApplicationStatus.DONATED_STK_APPLICATE_STATUS_RECHECK_AUDIT_VALUE);
                customerAccOpenApplyEntity.setUpdateTime(new Date());
                customerAccOpenApplyEntity.setLastApprovalUser(processTaskDto.getDealId());
                customerAccOpenApplyEntity.setApprovalOpinion(processTaskDto.getRemark());

                donatedStockService.updateByApplicationId(customerAccOpenApplyEntity);

            }

            // 完成节点回调业务处理
            if (CodeUtils.getCodeName("OPEN_ACCOUNT_NODE_NAME", "6").equals(donatedStockApproveInfo.getCurrentNode())) {

                if (CodeUtils.getCodeName("OPEN_ACCOUNT_NODE_NAME", "2").equals(applicationInfo.getCurrentNode())) {
                    // 更新赠股申请信息表
                    DonatedStockApplicationInfoEntity customerAccOpenApplyEntity = new DonatedStockApplicationInfoEntity();
//					customerAccOpenApplyEntity.setCallbackStatus(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
                    customerAccOpenApplyEntity.setApplicationId(donatedStockApproveInfo.getApplicationId());
                    customerAccOpenApplyEntity.setApplicationStatus(BpmCommonEnum.DonatedStockApplicationStatus.DONATED_STK_APPLICATE_STATUS_PASS_VALUE);
                    customerAccOpenApplyEntity.setUpdateTime(new Date());
                    customerAccOpenApplyEntity.setLastApprovalUser(processTaskDto.getDealId());
                    customerAccOpenApplyEntity.setApprovalOpinion(processTaskDto.getRemark());

                    int count = donatedStockService.updateByApplicationId(customerAccOpenApplyEntity);
                    if (count > 0) {
                        String fundAccount = SysConfigUtil.getSysConfigValue("DONATED_STK_FUND_ACCOUNT", null);
                        GenericHsRequest<FundRequest> clientFareInfoProtoRequest = new GenericHsRequest<>();
                        FundRequest fundProtocol = new FundRequest();
                        fundProtocol.setFundAccount(fundAccount);
                        clientFareInfoProtoRequest.setParams(fundProtocol);
                        ResponseVO stockInfoResponseVo = HsStockManageService.getStockInfo(clientFareInfoProtoRequest);
                        List<StockPositionEntity> stockPositionList = JsonUtil.getList(JsonUtil.getJsonByObj(stockInfoResponseVo.getResult()), StockPositionEntity.class);

                        String stockCode = applicationInfo.getStockCode();
                        BigDecimal positionAmount = new BigDecimal(0.00);
                        for (StockPositionEntity stockPosition : stockPositionList) {
                            if (stockCode.equals(stockPosition.getAssetId())) {
                                positionAmount = stockPosition.getCurrentAmount();
                            }
                        }

                        //查询该股票 代缴纳合计总数
                        DonatedStockApplicationInfoEntity queryEntity = new DonatedStockApplicationInfoEntity();
                        queryEntity.setStampDutyStatus(1);
                        queryEntity.setApplicationStatus(3);
                        queryEntity.setStockCode(applicationInfo.getStockCode());
                        List<DonatedStockApplicationInfoEntity> waitDealList = donatedStockService.queryListByBean(queryEntity);
                        int stockQuantityTotal = 0;
                        for (DonatedStockApplicationInfoEntity entity : waitDealList) {
                            stockQuantityTotal += entity.getStockQuantity();
                        }

                        if (0 < new BigDecimal(stockQuantityTotal).divide(positionAmount, 2, BigDecimal.ROUND_HALF_EVEN).compareTo(new BigDecimal(0.8))) {

                            // 发送通知
                            NoticeEntity params = new NoticeEntity();
                            String context = null;
                            if (0 < new BigDecimal(stockQuantityTotal).divide(positionAmount, 2, BigDecimal.ROUND_HALF_EVEN).compareTo(new BigDecimal(0.9))) {
                                //通知的方案code 为 4
                                NoticeCaseEntity noticeCase = noticeCaseService.queryByCode("4");
                                context = noticeCase.getNoticeContext();
                                params.setTitle(noticeCase.getNoticeCaseName());
                                context = context.replace("{stockName}", applicationInfo.getStockName()).replace("{stockQuantity}", String.valueOf(stockQuantityTotal)).replace("{positionQuantity}", String.valueOf(positionAmount.intValue()));
                                params.setContext(context);
                                StockUtils.sendStockNotice(params, "4");
                            } else {
                                //通知的方案code 为 3
                                NoticeCaseEntity noticeCase = noticeCaseService.queryByCode("3");
                                context = noticeCase.getNoticeContext();
                                params.setTitle(noticeCase.getNoticeCaseName());
                                context = context.replace("{stockName}", applicationInfo.getStockName()).replace("{stockQuantity}", String.valueOf(stockQuantityTotal)).replace("{positionQuantity}", String.valueOf(positionAmount.intValue()));
                                params.setContext(context);
                                StockUtils.sendStockNotice(params, "3");
                            }

                            //发送邮件
                            StockOrderInfoEntity stockOrderInfo = new StockOrderInfoEntity();
                            stockOrderInfo.setStockName(applicationInfo.getStockName());
                            stockOrderInfo.setStockQuantity(String.valueOf(stockQuantityTotal));
                            stockOrderInfo.setPositionAmount(String.valueOf(positionAmount.intValue()));
                            if (0 < new BigDecimal(String.valueOf(stockQuantityTotal)).divide(positionAmount, 2, BigDecimal.ROUND_HALF_EVEN).compareTo(new BigDecimal(0.9))) {
                                StockUtils.sendStockEmail(stockOrderInfo, "4", VelocityUtil.POSITION_INSUFFICIENT_90);
                            } else {
                                StockUtils.sendStockEmail(stockOrderInfo, "3", VelocityUtil.POSITION_INSUFFICIENT_80);
                            }
                        }

                    }
                }
            }

            // 终止节点回调业务处理
            if (CodeUtils.getCodeName("OPEN_ACCOUNT_NODE_NAME", "7").equals(donatedStockApproveInfo.getCurrentNode())) {

                applicationInfo.setCallbackStatus(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
                applicationInfo.setApproveResult(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_FAILED_VALUE);
                applicationInfo.setStatus(Constant.ActStauts.END.getValue());
                applicationInfo.setActResult("2");

            }

            // 拼接流程审核记录串
            String flowPath = applicationInfo.getFlowPath() != null ? applicationInfo.getFlowPath() + "-" + donatedStockApproveInfo.getCurrentNode() : donatedStockApproveInfo.getCurrentNode();
            applicationInfo.setCurrentNode(donatedStockApproveInfo.getCurrentNode());
            applicationInfo.setFlowPath(flowPath);
            applicationInfo.setApplicationStatus(null);
            applicationInfo.setLastApprovalUser(null);
            applicationInfo.setApprovalOpinion(null);
            applicationInfo.setAssignDrafter(null);
            applicationInfo.setUpdateTime(new Date());

            if (!CodeUtils.getCodeName("OPEN_ACCOUNT_NODE_NAME", "0").equals(donatedStockApproveInfo.getCurrentNode())) {
                donatedStockService.update(applicationInfo);
            }

            // 重置指定处理人为null
            donatedStockApplicationInfoDao.updateAssignDrafter(applicationInfo);
        } catch (Exception e) {
            logger.error("工作流回调业务处理异常", e);
        }
    }

    /**
     * 根据流水号更新
     *
     * @param entity
     * @return
     */
    @Override
    public int updateByApplicationId(DonatedStockApplicationInfoEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return donatedStockApplicationInfoDao.updateByApplicationId(entity);
    }

    /**
     * 根据流水号详情
     *
     * @param applicationId
     * @return
     */
    @Override
    public DonatedStockApplicationInfoEntity queryByApplicationId(String applicationId) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return donatedStockApplicationInfoDao.queryByApplicationId(applicationId);
    }

    @Override
    public boolean terminateDonatedApplication(DonatedStockApplicationInfoEntity entity, ProcessTaskDto processTaskDto) {
        donatedStockService.update(entity);

        DonatedStockApproveInfo donatedStockApproveInfo = new DonatedStockApproveInfo();
        donatedStockApproveInfo.setApplicationId(entity.getApplicationId());
        donatedStockApproveInfo.setCurrentNode(CodeUtils.getCodeName("OPEN_ACCOUNT_NODE_NAME", "7"));

        // 更新申请表相关信息
        DonatedStockApplicationInfoEntity donatedStockApplicationInfoEntity = new DonatedStockApplicationInfoEntity();
        donatedStockApplicationInfoEntity.setApplicationId(donatedStockApproveInfo.getApplicationId());
        //设置状态为已拒绝
        donatedStockApplicationInfoEntity.setApplicationStatus(BpmCommonEnum.DonatedStockApplicationStatus.DONATED_STK_APPLICATE_STATUS_APPROVAL_REJECT_VALUE);
        donatedStockApplicationInfoEntity.setUpdateTime(new Date());
        donatedStockApplicationInfoEntity.setLastApprovalUser(UserUtils.getCurrentUserId());
        donatedStockApplicationInfoEntity.setApprovalOpinion(processTaskDto.getRemark());
        donatedStockService.updateByApplicationId(donatedStockApplicationInfoEntity);

        approveCallback(donatedStockApproveInfo, processTaskDto, null);

        return true;
    }

    /**
     * 领取列表查看详情
     *
     * @param applicationId
     * @return
     */
    @Override
    public DonatedStockApplicationInfoEntity queryDetailByApplicationId(String applicationId) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return donatedStockApplicationInfoDao.queryDetailByApplicationId(applicationId);
    }

    /**
     * 领取列表导出查询
     *
     * @param query
     * @return
     */
    @Override
    public List<DonatedStockApplicationInfoEntity> findPageListExecl(DonatedStockApplicationInfoEntity query) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return donatedStockApplicationInfoDao.selectDealAccountList(query);
    }

    /**
     * 待入账列表分页查询
     *
     * @param query
     * @param pageNum
     * @return
     */
    @Override
    public Page<DonatedStockApplicationInfoEntity> findPageDealAccount(DonatedStockApplicationInfoEntity query, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        PageHelper.startPage(pageNum, Constant.pageSize);
        donatedStockApplicationInfoDao.querytWaitEntryList(query);
        return PageHelper.endPage();
    }

    /**
     * 待入账列表带排序查询
     * @param map
     * @return
     */
    @Override
    public List<DonatedStockApplicationInfoEntity> queryEntryListByOrder(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return donatedStockApplicationInfoDao.queryEntryListByOrder(map);
    }
    /**
     * 查询打印信息
     *
     * @param query
     * @return
     */
    @Override
    public List<DonatedStockApplicationInfoEntity> queryDealAccountPrint(DonatedStockApplicationInfoEntity query) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return donatedStockApplicationInfoDao.selectDealAccountList(query);
    }

    /**
     * 通过ids查询集合信息
     *
     * @param ids
     * @return
     */
    @Override
    public List<DonatedStockApplicationInfoEntity> queryObjectIds(String ids) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return donatedStockApplicationInfoDao.queryObjectIds(ids);
    }

    /**
     * 增股入帐 邮件通知
     *
     * @param donatedStockInfoEntity
     */
    @Override
    public void sendDonatedStockEmail(DonatedStockApplicationInfoEntity donatedStockInfoEntity) {
        SecuritiesUserModel securitiesUserModel = new SecuritiesUserModel();
        securitiesUserModel.setUserId(donatedStockInfoEntity.getUserId());
        ResponseVO responseVO = securitiesUserInfoService.querySecuritiesUserInfo(securitiesUserModel);
        SecuritiesUserModel securitiesUserInfoEntity = (SecuritiesUserModel) responseVO.getResult();

        if (securitiesUserInfoEntity == null) {
            logger.error("增股入账发送邮件失败，查询证券信息表不存在小神号：" + donatedStockInfoEntity.getUserId());
        }

        if (securitiesUserInfoEntity != null) {
            MessageSendInfoEntity messageSendInfoEntity = new MessageSendInfoEntity();
            messageSendInfoEntity.setMessageType(BpmCommonEnum.MessageNoticeType.MESSAGE_NOTICE_TYPE_EMAIL_VALUE);
            messageSendInfoEntity.setRecipients(securitiesUserInfoEntity.getEmail());
            messageSendInfoEntity.setMessageTitle("智珠证券赠股入帐通知");
            messageSendInfoEntity.setSendResult(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
            Map<String, String> emailModel = Maps.newHashMap();
            emailModel.put("clientName", donatedStockInfoEntity.getClientName());
            emailModel.put("stockName", donatedStockInfoEntity.getStockName());
            emailModel.put("stockQuantity", donatedStockInfoEntity.getStockQuantity().toString());
            messageSendInfoEntity.setMessageContent(VelocityUtil.fillTemplate(VelocityUtil.DONATED_STOCK_SUCCEED_EMAIL_TEMPLATE, emailModel));
            messageSendInfoEntity.setContentType(2);

            messageSendInfoService.save(messageSendInfoEntity);
        }


    }

    /**
     * 增股入帐 邮件拒绝通知
     *
     * @param donatedStockInfoEntity
     */
    @Override
    public void sendDonatedStockRefuseEmail(DonatedStockApplicationInfoEntity donatedStockInfoEntity) {
        SecuritiesUserModel securitiesUserModel = new SecuritiesUserModel();
        securitiesUserModel.setUserId(donatedStockInfoEntity.getUserId());
        ResponseVO responseVO = securitiesUserInfoService.querySecuritiesUserInfo(securitiesUserModel);
        SecuritiesUserModel securitiesUserInfoEntity = (SecuritiesUserModel) responseVO.getResult();

        if (securitiesUserInfoEntity == null) {
            logger.error("增股入账发送邮件失败，查询证券信息表不存在小神号：" + donatedStockInfoEntity.getUserId());
        }

        if (securitiesUserInfoEntity != null) {
            MessageSendInfoEntity messageSendInfoEntity = new MessageSendInfoEntity();
            messageSendInfoEntity.setMessageType(BpmCommonEnum.MessageNoticeType.MESSAGE_NOTICE_TYPE_EMAIL_VALUE);
            messageSendInfoEntity.setRecipients(securitiesUserInfoEntity.getEmail());
            messageSendInfoEntity.setMessageTitle("智珠证券赠股领取被拒绝通知");
            messageSendInfoEntity.setSendResult(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
            Map<String, String> emailModel = Maps.newHashMap();
            emailModel.put("clientName", donatedStockInfoEntity.getClientName());
            messageSendInfoEntity.setMessageContent(VelocityUtil.fillTemplate(VelocityUtil.DONATED_STOCK_REFUSED_EMAIL_TEMPLATE, emailModel));
            messageSendInfoEntity.setContentType(2);

            messageSendInfoService.save(messageSendInfoEntity);
        }
    }

    /**
     * 赠股入账-审核通过 已拒绝 短信通知
     *
     * @param templateCode
     * @param phoneNumber
     * @param paramList
     * @return
     */
    @Override
    public boolean generateDonatedStockRetSendSms(Integer templateCode, String phoneNumber, List<String> paramList) {
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
            messageSendInfoEntity.setMessageTitle("智珠证券赠股通知");
            messageSendInfoEntity.setSendResult(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
            messageSendInfoEntity.setMessageContent(JSON.toJSONString(paraMap, SerializerFeature.WriteMapNullValue));
            messageSendInfoEntity.setContentType(1);
            messageSendInfoEntity.setAttachmentUris("");
            int isSucceed = messageSendInfoService.save(messageSendInfoEntity);

            return 1 == isSucceed;
        } catch (Exception e) {
            logger.error("赠股短信发送异常", e);
        }

        return false;
    }

    /**
     * 查询待入账 入账失败数据
     *
     * @return
     */
    @Override
    public List<DonatedStockApplicationInfoEntity> selectWaitStockDeposit() {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return donatedStockApplicationInfoDao.selectWaitStockDeposit();
    }

    @Override
    public int myStockNoticeCount() {

        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);

        int count = 0;

        List<RoleEntity> roleList = roleService.queryByUserId(UserUtils.getCurrentUserId(), "0");

        for (RoleEntity role : roleList) {
            if ("赠股运营".equals(role.getName())) {
                DonatedStockApplicationInfoEntity queryCondition = new DonatedStockApplicationInfoEntity();
                queryCondition.setApplicationStatus(BpmCommonEnum.DonatedStockApplicationStatus.DONATED_STK_APPLICATE_STATUS_INITIAL_AUDIT_VALUE);
                List<DonatedStockApplicationInfoEntity> donatedApproveList = donatedStockApplicationInfoDao.selectApproveListCount(queryCondition);
                count = donatedApproveList == null ? 0 : donatedApproveList.size();
            }

            if ("运营主管".equals(role.getName())) {
                DonatedStockApplicationInfoEntity queryCondition = new DonatedStockApplicationInfoEntity();
                queryCondition.setApplicationStatus(BpmCommonEnum.DonatedStockApplicationStatus.DONATED_STK_APPLICATE_STATUS_RECHECK_AUDIT_VALUE);
                List<DonatedStockApplicationInfoEntity> donatedApproveList = donatedStockApplicationInfoDao.selectApproveListCount(queryCondition);
                count = donatedApproveList == null ? 0 : donatedApproveList.size();
            }

            if ("结算".equals(role.getName())) {
                DonatedStockApplicationInfoEntity donatedStockEntity = new DonatedStockApplicationInfoEntity();
                donatedStockEntity.setApplicationStatus(3);
                donatedStockEntity.setPrintStatus(1);
                List<DonatedStockApplicationInfoEntity> donatedList = donatedStockApplicationInfoDao.selectApproveListCount(donatedStockEntity);
                count = donatedList == null ? 0 : donatedList.size();
            }
        }
        return count;
    }
}