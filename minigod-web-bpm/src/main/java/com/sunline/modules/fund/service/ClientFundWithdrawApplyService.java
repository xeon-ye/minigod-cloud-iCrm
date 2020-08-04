package com.sunline.modules.fund.service;

import com.sunline.modules.activiti.dto.ProcessTaskDto;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.fund.entity.ClientFundWithdrawApplyEntity;
import com.sunline.modules.fund.model.ClientFundWithdrawApplyInfo;
import org.activiti.engine.task.Task;

import java.util.List;
import java.util.Map;

/**
 * 客户出金申请信息表
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2019-04-01 16:23:18
 */
public interface ClientFundWithdrawApplyService {

    ClientFundWithdrawApplyEntity queryObject(Long id);

    List<ClientFundWithdrawApplyEntity> queryList(ClientFundWithdrawApplyEntity entity);

    List<ClientFundWithdrawApplyEntity> queryAuditList(ClientFundWithdrawApplyEntity entity);

    List<ClientFundWithdrawApplyEntity> queryListByBean(ClientFundWithdrawApplyEntity entity);

    int queryTotal(Map<String, Object> map);

    int save(ClientFundWithdrawApplyEntity clientFundWithdrawApplication);

    int update(ClientFundWithdrawApplyEntity clientFundWithdrawApplication);

    int delete(Long id);

    int deleteBatch(Long[] ids);

    /**
     * 通过预约号查询
     *
     * @param applicationId
     * @return
     */
    ClientFundWithdrawApplyEntity queryByApplicationId(String applicationId);

    /**
     * 提交出金申请
     *
     * @param clientFundWithdrawApplyEntity
     * @return
     */
    String commitClientFundWithdrawApply(ClientFundWithdrawApplyEntity clientFundWithdrawApplyEntity);

    /**
     * 出金工作流回调业务处理
     *
     * @param clientFundWithdrawApplyInfo
     * @param processTaskDto
     * @param task
     */
    void approveCallback(ClientFundWithdrawApplyInfo clientFundWithdrawApplyInfo, ProcessTaskDto processTaskDto, Task task);

    /**
     * 分页查询出金申请记录
     *
     * @param clientFundWithdrawApplyEntity
     * @param pageNum
     * @return
     */
    Page<ClientFundWithdrawApplyEntity> findPage(ClientFundWithdrawApplyEntity clientFundWithdrawApplyEntity, int pageNum);

    /**
     * 更新指定审核人
     *
     * @param entity
     * @return
     */
    int updateAssignDrafter(ClientFundWithdrawApplyEntity entity);

    /**
     * 终止流程
     *
     * @param entity
     * @param processTaskDto
     * @return
     */
    boolean terminateApplication(ClientFundWithdrawApplyEntity entity, ProcessTaskDto processTaskDto);

    /**
     * 更新流程信息
     *
     * @param entity
     * @param processTaskDto
     * @return
     */
    boolean updateProcessInfo(ClientFundWithdrawApplyEntity entity, ProcessTaskDto processTaskDto);

    /**
     * 查询审核列表
     *
     * @param entity
     * @param pageNum
     * @return
     */
    Page<ClientFundWithdrawApplyEntity> queryAuditList(ClientFundWithdrawApplyEntity entity, int pageNum);

    /**
     * 出金业务短信通知生成
     *
     * @param templateCode
     * @param phoneNumber
     * @param paramList
     * @return
     */
    boolean generateFundWithdrawRetSendSms(Integer templateCode, String phoneNumber, List<String> paramList);

    /**
     * 批量更新
     *
     * @param applicationIds
     * @return
     */
    int updateBatchByApplicationIds(String applicationIds);

    /**
     * 通过预约号更新
     *
     * @param entity
     * @return
     */
    int updateByApplicationId(ClientFundWithdrawApplyEntity entity);

    /**
     * 通过预约号批量查询
     *
     * @param applicationIds
     * @return
     */
    List<ClientFundWithdrawApplyEntity> queryByApplicationIds(String applicationIds);
}
