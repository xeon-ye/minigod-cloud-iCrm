package com.sunline.modules.fund.service;


import com.sunline.modules.activiti.dto.ProcessTaskDto;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.vo.ResponseVO;
import com.sunline.modules.fund.entity.ClientFundDepositApplicationEntity;
import com.sunline.modules.fund.model.ClientFundDepositWorkFlow;
import com.sunline.modules.fund.proxy.request.FundDepositResultRequest;
import org.activiti.engine.task.Task;

import java.util.List;
import java.util.Map;

/**
 * 客户入金申请信息表
 * 
 * @author lidh
 * @email jim@zszhizhu.com
 * @date 2019-06-01 14:52:31
 */
public interface ClientFundDepositApplicationService {
	
	ClientFundDepositApplicationEntity queryObject(Long id);
	
	List<ClientFundDepositApplicationEntity> queryList(Map<String, Object> map);

    List<ClientFundDepositApplicationEntity> queryListByBean(ClientFundDepositApplicationEntity entity);
	
	int queryTotal(Map<String, Object> map);
	
	int save(ClientFundDepositApplicationEntity clientFundDepositApplication);
	
	int update(ClientFundDepositApplicationEntity clientFundDepositApplication);
	
	int delete(Long id);
	
	int deleteBatch(Long[] ids);

    /**
     * 提交入金申请
     */
    String commitFundDepositApply(ClientFundDepositApplicationEntity clientFundDepositApplication, List<String> images);
    /**
     * 分页查询入金申请记录
     *
     * @param clientFundDepositApplication
     * @param pageNum
     * @return
     */
    Page<ClientFundDepositApplicationEntity> findPage(ClientFundDepositApplicationEntity clientFundDepositApplication, int pageNum);

    List<ClientFundDepositApplicationEntity> queryList(ClientFundDepositApplicationEntity clientFundDepositApplication);
    /**
     *  根据流水号查询申请记录
     * @param applicationid
     */
    ClientFundDepositApplicationEntity queryByApplicationId(String applicationid);

    /**
     * 入金工作流回调业务处理
     *
     * @param workFlow
     * @param processTaskDto
     * @param task
     */
    void approveCallback(ClientFundDepositWorkFlow workFlow, ProcessTaskDto processTaskDto, Task task);

    /**
     * 入金业务审核处理结果推送
     *
     * @param request
     * @return
     */
    ResponseVO pushFundDepositResult(FundDepositResultRequest request);

    /**
     * 入金业务短信通知生成
     * */
    boolean generateSendSms(Integer templateCode, String phoneNumber, List<String> paramList);
    /**
     * 更新指定审核人
     *
     * @param entity
     * @return
     */
    int updateAssignDrafter(ClientFundDepositApplicationEntity entity);

    /**
     * 终止流程
     *
     * @param entity
     * @param processTaskDto
     * @return
     */
    boolean terminateApplication(ClientFundDepositApplicationEntity entity, ProcessTaskDto processTaskDto);

    /**
     * 查询申请信息
     * */
    Page<ClientFundDepositApplicationEntity> queryInfoList(ClientFundDepositApplicationEntity entity,int pageNum);

    /**
     * 查询当前入金申请数量
     */
    int myFundDepositCount();

    /**
     * 加急处理任务
     */
    int updateBatchByApplicationIds(String applicationIds);

    /**
     * 查询审核列表
     * 审核列表的排序等与其他审批页面不同，故单独列出
     * */
    Page<ClientFundDepositApplicationEntity> queryBankCheckList(ClientFundDepositApplicationEntity entity,int pageNum);

    /**
     * 星展跳过凭证处理
     * @param applicationId
     */
    void skipFundDepositImages(String applicationId);
}
