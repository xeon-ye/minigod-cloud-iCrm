package com.sunline.modules.stock.service;



import com.sunline.modules.activiti.dto.ProcessTaskDto;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.stock.entity.DonatedStockApplicationInfoEntity;
import com.sunline.modules.stock.model.DonatedStockApproveInfo;
import org.activiti.engine.task.Task;
import java.util.List;
import java.util.Map;

/**
 * 赠股申请信息表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-12-07 15:05:58
 */
public interface DonatedStockApplicationInfoService {
	
	DonatedStockApplicationInfoEntity queryObject(Long id);
	
	List<DonatedStockApplicationInfoEntity> queryList(Map<String, Object> map);

    List<DonatedStockApplicationInfoEntity> queryListByBean(DonatedStockApplicationInfoEntity entity);
	
	int queryTotal(Map<String, Object> map);
	
	int save(DonatedStockApplicationInfoEntity donatedStockApplicationInfo);
	
	int update(DonatedStockApplicationInfoEntity donatedStockApplicationInfo);
	
	int delete(Long id);
	
	int deleteBatch(Long[] ids);

	/**
	 * 领取列表
	 * @param query
	 * @param pageNum
	 * @return
	 */
	Page<DonatedStockApplicationInfoEntity> findPageList(DonatedStockApplicationInfoEntity query, int pageNum);

	/**
	 * 统一回调
	 * @param donatedStockApproveInfo
	 * @param processTaskDto
	 * @param task
	 */
	void approveCallback(DonatedStockApproveInfo donatedStockApproveInfo, ProcessTaskDto processTaskDto, Task task);

	/**
	 * 根据流水号更新
	 * @param entity
	 * @return
	 */
	int updateByApplicationId(DonatedStockApplicationInfoEntity entity);

	/**
	 * 根据流水号详情
	 * @param applicationId
	 * @return
	 */
	DonatedStockApplicationInfoEntity queryByApplicationId(String  applicationId);

	boolean terminateDonatedApplication(DonatedStockApplicationInfoEntity entity, ProcessTaskDto processTaskDto);

	/**
	 * 领取列表查看详情
	 * @param applicationId
	 * @return
	 */
	DonatedStockApplicationInfoEntity queryDetailByApplicationId(String  applicationId);

	/**
	 * 领取列表导出查询
	 * @param query
	 * @return
	 */
	List<DonatedStockApplicationInfoEntity> findPageListExecl(DonatedStockApplicationInfoEntity query);

	/**
	 *待入账列表分页查询
	 * @param query
	 * @param pageNum
	 * @return
	 */
	Page<DonatedStockApplicationInfoEntity> findPageDealAccount(DonatedStockApplicationInfoEntity query, int pageNum);

	/**
	 * 待入账列表带排序查询
	 * @param map
	 * @return
	 */
	List<DonatedStockApplicationInfoEntity> queryEntryListByOrder(Map<String, Object> map);

	/**
	 * 待入账列表 打印
	 * @param query
	 * @return
	 */
	List<DonatedStockApplicationInfoEntity> queryDealAccountPrint(DonatedStockApplicationInfoEntity query);

	/**
	 * 根据ids查询
	 * @param ids
	 * @return
	 */
	List<DonatedStockApplicationInfoEntity> queryObjectIds(String ids);

	/**
	 * 增股入帐 邮件通知
	 * @param donatedStockInfoEntity
	 */
	void sendDonatedStockEmail(DonatedStockApplicationInfoEntity donatedStockInfoEntity);

    /**
     * 增股入帐 邮件拒绝通知
     * @param donatedStockInfoEntity
     */
    void sendDonatedStockRefuseEmail(DonatedStockApplicationInfoEntity donatedStockInfoEntity);

	/**
	 * 赠股入账-审核通过 已拒绝 短信通知
	 * @param templateCode
	 * @param phoneNumber
	 * @param paramList
	 * @return
	 */
	boolean generateDonatedStockRetSendSms(Integer templateCode, String phoneNumber, List<String> paramList);

	/**
	 * 查询待入账、入账失败
	 * @return
	 */
	List<DonatedStockApplicationInfoEntity> selectWaitStockDeposit();

    /**
     * 赠股通知条数
     * @return
     */
    int myStockNoticeCount();

}
