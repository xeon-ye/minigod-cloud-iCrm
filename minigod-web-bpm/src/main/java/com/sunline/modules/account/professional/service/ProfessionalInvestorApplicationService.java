package com.sunline.modules.account.professional.service;

import org.activiti.engine.task.Task;
import com.sunline.modules.account.professional.entity.ProfessionalInvestorApplicationEntity;
import com.sunline.modules.account.professional.model.query.ProfessionalAppQueryModel;
import com.sunline.modules.account.professional.protocol.ProfessionalApplyResultRequest;
import com.sunline.modules.activiti.dto.ProcessTaskDto;
import com.sunline.modules.activiti.entity.ExtendActTasklogEntity;
import com.sunline.modules.analysis.entity.ClientFundCountEntity;
import com.sunline.modules.common.common.CommonResponse;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.vo.ResponseVO;
import com.sunline.modules.hundsun.protocol.request.FundAccountRequest;

import java.util.List;
import java.util.Map;

/**
 * 专业投资者管理service
 * 
 * @author jim
 * @email jim@zszhizhu.com
 * @date 2019-12-04 11:31:49
 */
public interface ProfessionalInvestorApplicationService {

	/**
	 * 提交专业投资者认定申请
	 */
	String commitApply(ProfessionalInvestorApplicationEntity applyEntity, List<String> assetsImgs, List<String> addImgs);

	/**
	 *  根据流水号查询申请记录
	 * @param applicationid
	 */
	ProfessionalInvestorApplicationEntity queryByApplicationId(String applicationid);

	/**
	 * 工作流回调业务处理
	 *
	 * @param currentNode
	 * @param currentNode
	 * @param processTaskDto
	 */
	void approveCallback(String currentNode, ProcessTaskDto processTaskDto, Task task);

	/**
	 * 短信通知生成
	 * */
	boolean generateSendSms(Integer templateCode, String phoneNumber, List<String> paramList);

	/**
	 * 发送邮件通知
	 *
	 * @param title
	 * @param content
	 * @param recipients
	 */
	void generateSendEmail(String title, String content, String recipients);

	/**
	 * 更新指定审核人
	 *
	 * @param applyEntity
	 * @return
	 */
	int updateAssignDrafter(ProfessionalInvestorApplicationEntity applyEntity);

	/**
	 * 审核处理结果推送
	 *
	 * @param request
	 * @return
	 */
	ResponseVO pushFundDepositResult(ProfessionalApplyResultRequest request);

	/**
	 * 错误理由拼接
	 *
	 * @param tasklogList
	 * @return
	 */
	List<ExtendActTasklogEntity> joinBackReasonType(List<ExtendActTasklogEntity> tasklogList);

	/**
	 * 终止任务
	 *
	 * @param processTaskDto
	 * @param applyStatus
	 * @param backReasons
	 * @return
	 */
	boolean terminateApply(ProcessTaskDto processTaskDto, Integer applyStatus, String backReasons);

	ProfessionalInvestorApplicationEntity queryObject(Long id);
	
	List<ProfessionalInvestorApplicationEntity> queryList(Map<String, Object> map);

    List<ProfessionalInvestorApplicationEntity> queryListByBean(ProfessionalInvestorApplicationEntity entity);

	Page queryCheckList(ProfessionalAppQueryModel query, int pageNum);
	
	int queryTotal(Map<String, Object> map);
	
	int save(ProfessionalInvestorApplicationEntity professionalInvestorApplication);
	
	int update(ProfessionalInvestorApplicationEntity professionalInvestorApplication);
	
	int delete(Long id);
	
	int deleteBatch(Long[] ids);

	ClientFundCountEntity queryTotalAssetByDate(ClientFundCountEntity params);

	/**
	 * 同步客户级别至柜台
	 *
	 * @param
	 * @return
	 */
	public CommonResponse sysApplyToHs(FundAccountRequest.FundAccountGetRequest fundAccountGetRequest, Integer roomCode);
}
