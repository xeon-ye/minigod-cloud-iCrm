package com.sunline.modules.fund.service;

import com.sunline.modules.activiti.dto.ProcessTaskDto;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.fund.entity.ClientFundWithdrawApplyEntity;
import com.sunline.modules.fund.entity.FundWithdrawRefundApplyEntity;
import com.sunline.modules.fund.model.FundWithdrawRefundApplyInfo;
import org.activiti.engine.task.Task;

import java.util.List;
import java.util.Map;

/**
 * 客户出金退款申请表
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2019-05-23 13:23:38
 */
public interface FundWithdrawRefundApplyService {

    FundWithdrawRefundApplyEntity queryObject(Long id);

    List<FundWithdrawRefundApplyEntity> queryList(FundWithdrawRefundApplyEntity entity);

    List<FundWithdrawRefundApplyEntity> queryListByBean(FundWithdrawRefundApplyEntity entity);

    int queryTotal(Map<String, Object> map);

    int save(FundWithdrawRefundApplyEntity entity);

    int update(FundWithdrawRefundApplyEntity entity);

    int delete(Long id);

    int deleteBatch(Long[] ids);

    /**
     * 提交出金退款申请并启动工作流
     *
     * @param fundWithdrawRefundApplyEntity
     * @return
     */
    String commitFundWithdrawRefundApply(FundWithdrawRefundApplyEntity fundWithdrawRefundApplyEntity);

    /**
     * 出金退款工作流回调业务处理
     *
     * @param fundWithdrawRefundApplyInfo
     * @param processTaskDto
     * @param task
     */
    void approveCallback(FundWithdrawRefundApplyInfo fundWithdrawRefundApplyInfo, ProcessTaskDto processTaskDto, Task task);

    /**
     * 分页查询出金退款申请记录
     *
     * @param fundWithdrawRefundApplyEntity
     * @param pageNum
     * @return
     */
    Page<FundWithdrawRefundApplyEntity> findPage(FundWithdrawRefundApplyEntity fundWithdrawRefundApplyEntity, int pageNum);

    /**
     * 通过预约号查询
     *
     * @param applicationId
     * @return
     */
    FundWithdrawRefundApplyEntity queryByApplicationId(String applicationId);

    /**
     * 查询审核列表
     *
     * @param fundWithdrawRefundApplyEntity
     * @param pageNum
     * @return
     */
    Page<FundWithdrawRefundApplyEntity> queryAuditList(FundWithdrawRefundApplyEntity fundWithdrawRefundApplyEntity, int pageNum);

    /**
     * 查询审核列表
     *
     * @param fundWithdrawRefundApplyEntity
     * @return
     */
    List<FundWithdrawRefundApplyEntity> queryAuditList(FundWithdrawRefundApplyEntity fundWithdrawRefundApplyEntity);

    /**
     * 更新指定审核人
     *
     * @param entity
     * @return
     */
    int updateAssignDrafter(FundWithdrawRefundApplyEntity entity);

    /**
     * 终止流程
     *
     * @param entity
     * @param processTaskDto
     * @return
     */
    boolean terminateApplication(FundWithdrawRefundApplyEntity entity, ProcessTaskDto processTaskDto);

    /**
     * 通过预约号更新
     * @param fundWithdrawRefundApplyEntity
     * @return
     */
    int updateByApplicationId(FundWithdrawRefundApplyEntity fundWithdrawRefundApplyEntity);
}
