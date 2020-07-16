package com.sunline.modules.fund.service.impl;

import com.alibaba.fastjson.JSON;
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
import com.sunline.modules.fund.dao.ClientFundWithdrawApplyDao;
import com.sunline.modules.fund.dao.FundWithdrawRefundApplyDao;
import com.sunline.modules.fund.entity.ClientFundWithdrawApplyEntity;
import com.sunline.modules.fund.entity.FundWithdrawRefundApplyEntity;
import com.sunline.modules.fund.model.FundWithdrawRefundApplyInfo;
import com.sunline.modules.fund.proxy.request.FundWithdrawResultRequest;
import com.sunline.modules.fund.service.FundWithdrawRefundApplyService;
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
 * 客户出金退款申请表
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2019-05-23 13:23:38
 */

@Service("fundWithdrawRefundApplyService")
public class FundWithdrawRefundApplyServiceImpl implements FundWithdrawRefundApplyService {

    private static final Logger logger = LoggerFactory.getLogger(FundWithdrawRefundApplyServiceImpl.class);

    private static final String FUND_WITHDRAW_REFUND_FLOW_MODEL_KEY = "fundWithdrawRefundApplication";

    @Autowired
    private FundWithdrawRefundApplyDao fundWithdrawRefundApplyDao;
    @Autowired
    ActModelerService actModelerService;
    @Autowired
    private ClientFundWithdrawApplyDao clientFundWithdrawApplyDao;

    @Override
    public FundWithdrawRefundApplyEntity queryObject(Long id) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return fundWithdrawRefundApplyDao.queryObject(id);
    }

    @Override
    public List<FundWithdrawRefundApplyEntity> queryList(FundWithdrawRefundApplyEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return fundWithdrawRefundApplyDao.queryList(entity);
    }

    @Override
    public List<FundWithdrawRefundApplyEntity> queryListByBean(FundWithdrawRefundApplyEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return fundWithdrawRefundApplyDao.queryListByBean(entity);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return fundWithdrawRefundApplyDao.queryTotal(map);
    }

    @Override
    public int save(FundWithdrawRefundApplyEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
//        fundWithdrawRefundApplication.setId(Utils.uuid());
        return fundWithdrawRefundApplyDao.save(entity);
    }

    @Override
    public int update(FundWithdrawRefundApplyEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return fundWithdrawRefundApplyDao.update(entity);
    }

    @Override
    public int delete(Long id) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return fundWithdrawRefundApplyDao.delete(id);
    }

    @Override
    public int deleteBatch(Long[] ids) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return fundWithdrawRefundApplyDao.deleteBatch(ids);
    }


    /**
     * 提交出金退款申请并启动工作流
     *
     * @param fundWithdrawRefundApplyEntity
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String commitFundWithdrawRefundApply(FundWithdrawRefundApplyEntity fundWithdrawRefundApplyEntity) {
        try {
            DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);

            UserEntity workflowUser = UserUtils.getBackgroundWorkflowUser();
            // 检验预约流水号的唯一性
            String applicationId = OrderUtil.getOrderNoByAtomic(5);
            FundWithdrawRefundApplyEntity isExistedInfo = fundWithdrawRefundApplyDao.queryByApplicationId(applicationId);
            while (null != isExistedInfo) {
                applicationId = OrderUtil.getOrderNoByAtomic(5);
                isExistedInfo = fundWithdrawRefundApplyDao.queryByApplicationId(applicationId);
            }

            fundWithdrawRefundApplyEntity.setApplicationId(applicationId);
            fundWithdrawRefundApplyEntity.setCurrentNode("提交");
            fundWithdrawRefundApplyEntity.setCode(applicationId);
            fundWithdrawRefundApplyEntity.setCreateUser(workflowUser.getId());
            fundWithdrawRefundApplyEntity.setApproveResult(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
            fundWithdrawRefundApplyEntity.setStatus(Constant.ActStauts.DRAFT.getValue());
            fundWithdrawRefundApplyEntity.setBapid(workflowUser.getBapid());
            fundWithdrawRefundApplyEntity.setBaid(workflowUser.getBaid());
            fundWithdrawRefundApplyEntity.setApplicationStatus(BpmCommonEnum.FundWithdrawRefundApplicationStatus.FUND_WITHDRAW_REFUND_APPLY_STATUS_PROGRESS_VALUE);
            fundWithdrawRefundApplyEntity.setCreateTime(new Date());
            fundWithdrawRefundApplyEntity.setUpdateTime(new Date());

            int count = fundWithdrawRefundApplyDao.save(fundWithdrawRefundApplyEntity);

            if (count > 0) {
                ProcessDefinition clientFundWithdrawProcessDefinition = ActUtils.getlastProcessDefinition(FUND_WITHDRAW_REFUND_FLOW_MODEL_KEY);
                ProcessTaskDto processTaskDto = new ProcessTaskDto();
                processTaskDto.setDefId(clientFundWithdrawProcessDefinition.getId());
                processTaskDto.setBusId(fundWithdrawRefundApplyEntity.getApplicationId());
                processTaskDto.setActKey(clientFundWithdrawProcessDefinition.getKey());
                processTaskDto.setNodeType("2");

                actModelerService.startFlow(processTaskDto);
            }

            return fundWithdrawRefundApplyEntity.getApplicationId();

        } catch (Exception e) {
            logger.error("提交出金退款申请启动工作流流程失败", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return null;
        }
    }

    /**
     * 出金退款工作流回调业务处理
     *
     * @param fundWithdrawRefundApplyInfo
     * @param processTaskDto
     * @param task
     */
    @Override
    public void approveCallback(FundWithdrawRefundApplyInfo fundWithdrawRefundApplyInfo, ProcessTaskDto processTaskDto, Task task) {
        try {

            DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
            FundWithdrawRefundApplyEntity fundWithdrawRefundInfo = fundWithdrawRefundApplyDao.queryByApplicationId(fundWithdrawRefundApplyInfo.getApplicationId());

            // 发起节点回调业务处理
            if (CodeUtils.getCodeName("FUND_WITHDRAW_REFUND_NODE_NAME", "1").equals(fundWithdrawRefundApplyInfo.getCurrentNode())) {
                FundWithdrawRefundApplyEntity fundWithdrawRefundApplyEntity = new FundWithdrawRefundApplyEntity();
                fundWithdrawRefundApplyEntity.setApplicationId(fundWithdrawRefundApplyInfo.getApplicationId());
                fundWithdrawRefundApplyEntity.setApplicationStatus(BpmCommonEnum.FundWithdrawRefundApplicationStatus.FUND_WITHDRAW_REFUND_APPLY_STATUS_PROGRESS_VALUE);
                fundWithdrawRefundApplyEntity.setLastApprovalUser(processTaskDto.getDealId());
                fundWithdrawRefundApplyEntity.setApprovalOpinion(processTaskDto.getRemark());
                fundWithdrawRefundApplyEntity.setUpdateTime(new Date());

                fundWithdrawRefundApplyDao.updateByApplicationId(fundWithdrawRefundApplyEntity);
            }

            // 审核节点回调业务处理
            if (CodeUtils.getCodeName("FUND_WITHDRAW_REFUND_NODE_NAME", "2").equals(fundWithdrawRefundApplyInfo.getCurrentNode())) {
                FundWithdrawRefundApplyEntity fundWithdrawRefundApplyEntity = new FundWithdrawRefundApplyEntity();
                fundWithdrawRefundApplyEntity.setApplicationId(fundWithdrawRefundApplyInfo.getApplicationId());
                fundWithdrawRefundApplyEntity.setApplicationStatus(BpmCommonEnum.FundWithdrawRefundApplicationStatus.FUND_WITHDRAW_REFUND_APPLY_STATUS_PROGRESS_VALUE);
                fundWithdrawRefundApplyEntity.setLastApprovalUser(processTaskDto.getDealId());
                fundWithdrawRefundApplyEntity.setApprovalOpinion(processTaskDto.getRemark());
                fundWithdrawRefundApplyEntity.setUpdateTime(new Date());

                fundWithdrawRefundApplyDao.updateByApplicationId(fundWithdrawRefundApplyEntity);
            }

            // 完成节点回调业务处理
            if (CodeUtils.getCodeName("FUND_WITHDRAW_REFUND_NODE_NAME", "3").equals(fundWithdrawRefundApplyInfo.getCurrentNode())) {

                if (BpmCommonEnum.FundWithdrawRefundApplicationStatus.FUND_WITHDRAW_REFUND_APPLY_STATUS_FAILURE_VALUE != fundWithdrawRefundInfo.getApplicationStatus()) {

                    FundWithdrawRefundApplyEntity fundWithdrawRefundApplyEntity = new FundWithdrawRefundApplyEntity();
                    fundWithdrawRefundApplyEntity.setApplicationId(fundWithdrawRefundApplyInfo.getApplicationId());
                    fundWithdrawRefundApplyEntity.setApplicationStatus(BpmCommonEnum.FundWithdrawRefundApplicationStatus.FUND_WITHDRAW_REFUND_APPLY_STATUS_SUCCESS_VALUE);
                    fundWithdrawRefundApplyEntity.setCallbackStatus(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
                    fundWithdrawRefundApplyEntity.setLastApprovalUser(processTaskDto.getDealId());
                    fundWithdrawRefundApplyEntity.setApprovalOpinion(processTaskDto.getRemark());
                    fundWithdrawRefundApplyEntity.setUpdateTime(new Date());

                    fundWithdrawRefundApplyDao.updateByApplicationId(fundWithdrawRefundApplyEntity);

                    // 更新对应的出金记录为退款已入账状态
                    ClientFundWithdrawApplyEntity clientFundWithdrawApplyEntity = new ClientFundWithdrawApplyEntity();
                    clientFundWithdrawApplyEntity.setApplicationId(fundWithdrawRefundInfo.getWithdrawApplicationId());
                    clientFundWithdrawApplyEntity.setApplicationStatus(BpmCommonEnum.FundWithdrawApplicationStatus.FUND_WITHDRAW_APPLY_REFUND_SUCCESS_VALUE);
                    clientFundWithdrawApplyEntity.setUpdateTime(new Date());

                    clientFundWithdrawApplyDao.updateByApplicationId(clientFundWithdrawApplyEntity);

                    // 回调APP
                    FundWithdrawResultRequest request = new FundWithdrawResultRequest();
                    request.setApplicationId(clientFundWithdrawApplyEntity.getApplicationId());
                    request.setWithdrawStatus(5);

                    ResponseVO response = pushFundWithdrawResult(request);
                }
            }

            // 终止节点回调业务处理
            if (CodeUtils.getCodeName("FUND_WITHDRAW_REFUND_NODE_NAME", "4").equals(fundWithdrawRefundApplyInfo.getCurrentNode())) {
                FundWithdrawRefundApplyEntity fundWithdrawRefundApplyEntity = new FundWithdrawRefundApplyEntity();
                fundWithdrawRefundApplyEntity.setApplicationId(fundWithdrawRefundApplyInfo.getApplicationId());
                fundWithdrawRefundApplyEntity.setApplicationStatus(BpmCommonEnum.FundWithdrawRefundApplicationStatus.FUND_WITHDRAW_REFUND_APPLY_STATUS_FAILURE_VALUE);
                fundWithdrawRefundApplyEntity.setLastApprovalUser(processTaskDto.getDealId());
                fundWithdrawRefundApplyEntity.setApprovalOpinion(processTaskDto.getRemark());
                fundWithdrawRefundApplyEntity.setUpdateTime(new Date());

                fundWithdrawRefundApplyDao.updateByApplicationId(fundWithdrawRefundApplyEntity);
            }

            // 拼接流程审核记录串
            FundWithdrawRefundApplyEntity fundWithdrawRefundApplyEntity = new FundWithdrawRefundApplyEntity();
            fundWithdrawRefundApplyEntity.setApplicationId(fundWithdrawRefundInfo.getApplicationId());
            fundWithdrawRefundApplyEntity.setCurrentNode(fundWithdrawRefundApplyInfo.getCurrentNode());
            fundWithdrawRefundApplyEntity.setApplicationStatus(null);
            fundWithdrawRefundApplyEntity.setLastApprovalUser(null);
//            clientFundWithdrawInfo.setApprovalOpinion(null);
            fundWithdrawRefundApplyEntity.setAssignDrafter(null);
            fundWithdrawRefundApplyEntity.setUpdateTime(new Date());

            if (!CodeUtils.getCodeName("FUND_WITHDRAW_NODE_NAME", "0").equals(fundWithdrawRefundApplyEntity.getCurrentNode())) {
                fundWithdrawRefundApplyDao.updateByApplicationId(fundWithdrawRefundApplyEntity);
            }

            // 重置指定处理人为null
            fundWithdrawRefundApplyDao.updateAssignDrafter(fundWithdrawRefundApplyEntity);

        } catch (Exception e) {
            logger.error("出金退款工作流回调业务处理异常", e);
        }
    }

    /**
     * 分页查询出金退款申请记录
     *
     * @param fundWithdrawRefundApplyEntity
     * @param pageNum
     * @return
     */
    @Override
    public Page<FundWithdrawRefundApplyEntity> findPage(FundWithdrawRefundApplyEntity fundWithdrawRefundApplyEntity, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        PageHelper.startPage(pageNum, Constant.pageSize);
        fundWithdrawRefundApplyDao.queryList(fundWithdrawRefundApplyEntity);
        return PageHelper.endPage();
    }

    /**
     * 通过预约号查询
     *
     * @param applicationId
     * @return
     */
    @Override
    public FundWithdrawRefundApplyEntity queryByApplicationId(String applicationId) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return fundWithdrawRefundApplyDao.queryByApplicationId(applicationId);
    }

    /**
     * 查询审核列表
     *
     * @param fundWithdrawRefundApplyEntity
     * @param pageNum
     * @return
     */
    @Override
    public Page<FundWithdrawRefundApplyEntity> queryAuditList(FundWithdrawRefundApplyEntity fundWithdrawRefundApplyEntity, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        PageHelper.startPage(pageNum, Constant.pageSize);
        fundWithdrawRefundApplyDao.queryAuditList(fundWithdrawRefundApplyEntity);
        return PageHelper.endPage();
    }

    /**
     * 查询审核列表
     *
     * @param fundWithdrawRefundApplyEntity
     * @return
     */
    @Override
    public List<FundWithdrawRefundApplyEntity> queryAuditList(FundWithdrawRefundApplyEntity fundWithdrawRefundApplyEntity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return fundWithdrawRefundApplyDao.queryAuditList(fundWithdrawRefundApplyEntity);
    }

    /**
     * 更新指定审核人
     *
     * @param entity
     * @return
     */
    @Override
    public int updateAssignDrafter(FundWithdrawRefundApplyEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return fundWithdrawRefundApplyDao.updateAssignDrafter(entity);
    }

    /**
     * 终止流程
     *
     * @param entity
     * @param processTaskDto
     * @return
     */
    @Override
    public boolean terminateApplication(FundWithdrawRefundApplyEntity entity, ProcessTaskDto processTaskDto) {

        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);

        FundWithdrawRefundApplyInfo fundWithdrawRefundApplyInfo = new FundWithdrawRefundApplyInfo();
        fundWithdrawRefundApplyInfo.setApplicationId(entity.getApplicationId());
        fundWithdrawRefundApplyInfo.setCurrentNode(CodeUtils.getCodeName("FUND_WITHDRAW_REFUND_NODE_NAME", "4"));

        // 更新申请表相关信息
        FundWithdrawRefundApplyEntity fundWithdrawRefundApplyEntity = new FundWithdrawRefundApplyEntity();
        fundWithdrawRefundApplyEntity.setApplicationId(fundWithdrawRefundApplyInfo.getApplicationId());
        fundWithdrawRefundApplyEntity.setUpdateTime(new Date());
        fundWithdrawRefundApplyEntity.setLastApprovalUser(UserUtils.getCurrentUserId());
        fundWithdrawRefundApplyEntity.setApprovalOpinion(processTaskDto.getRemark());
        fundWithdrawRefundApplyDao.updateByApplicationId(fundWithdrawRefundApplyEntity);

        approveCallback(fundWithdrawRefundApplyInfo, processTaskDto, null);

        return true;
    }

    /**
     * 通过预约号更新
     *
     * @param fundWithdrawRefundApplyEntity
     * @return
     */
    @Override
    public int updateByApplicationId(FundWithdrawRefundApplyEntity fundWithdrawRefundApplyEntity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return fundWithdrawRefundApplyDao.updateByApplicationId(fundWithdrawRefundApplyEntity);
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

            logger.info("出金退款回调参数：" + JSON.toJSONString(genericRequest));

            String response = HttpClientUtils.postJson(ConfigUtils.get("sunline.service.url") + "/sec_api/update_fund_withdraw_status", JSON.toJSONString(genericRequest));

            logger.info("出金退款回调结果：" + response);

            return JSON.parseObject(response, ResponseVO.class);

        } catch (Exception e) {
            logger.error("出金退款业务审核处理结果推送异常：", e);
        }
        return null;
    }
}
