package com.sunline.modules.fund.service;

import com.sunline.modules.common.page.Page;
import com.sunline.modules.fund.entity.DepositBankBillFlowEntity;

import java.util.List;
import java.util.Map;

/**
 * 入金银行流水记录表
 * 
 * @author lidh
 * @email jim@zszhizhu.com
 * @date 2019-06-05 13:24:54
 */
public interface DepositBankBillFlowService {

	DepositBankBillFlowEntity queryObject(Long id);

	List<DepositBankBillFlowEntity> queryList(Map<String, Object> map);

	Page<DepositBankBillFlowEntity> queryPage(DepositBankBillFlowEntity entity, int pageNum);

	List<DepositBankBillFlowEntity> queryListByBean(DepositBankBillFlowEntity entity);

	int queryTotal(Map<String, Object> map);

	int save(DepositBankBillFlowEntity depositBankBillFlow);

	int saveOrUpdate(DepositBankBillFlowEntity depositBankBillFlow);

	int update(DepositBankBillFlowEntity depositBankBillFlow);

	int delete(Long id);

	int deleteBatch(Long[] ids);

	List<DepositBankBillFlowEntity> queryListByIds(String ids);

	/**
	 * 退回一条流水
	 *
	 * @param applicationId
	 */
	boolean backBankFlow(String applicationId);


	/**
	 * 批量处理流水
	 */
	Map<String, Integer> saveOrUpdate(List<DepositBankBillFlowEntity> entityList);

	/**
	 * 更新是否重复状态
	 */
	int updateRepeat(long id, int repeat);

	/**
	 * 更新指定审核人
	 *
	 * @param entity
	 * @return
	 */
	int updateAssignDrafter(DepositBankBillFlowEntity entity);

	/**
	 * 更新ARE数据
	 *
	 * @param entity
	 * @return
	 */
	int updateAREData(DepositBankBillFlowEntity entity);
}
