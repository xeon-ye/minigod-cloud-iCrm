package com.sunline.modules.stock.dao;


import com.sunline.modules.common.dao.BaseDao;
import com.sunline.modules.stock.entity.DonatedStockApplicationInfoEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 赠股申请信息表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-12-07 15:05:58
 */
@Mapper
public interface DonatedStockApplicationInfoDao extends BaseDao<DonatedStockApplicationInfoEntity> {
    /**
     * 领取列表
     */
    List<DonatedStockApplicationInfoEntity> selectApproveList(DonatedStockApplicationInfoEntity query);

    int updateAssignDrafter(DonatedStockApplicationInfoEntity donatedStockApproveInfo);

    /**
     * 通过预约流水号更新信息
     * @param entity
     * @return
     */
    int updateByApplicationId(DonatedStockApplicationInfoEntity entity);

    /**
     * 根据流水号查询
     * @param applicationId
     * @return
     */
    DonatedStockApplicationInfoEntity queryByApplicationId(String applicationId);

    /**
     * 领取列表查看详情
     * @param applicationId
     * @return
     */
    DonatedStockApplicationInfoEntity queryDetailByApplicationId(String applicationId);

    /**
     * 待入账列表打印查询
     * @param query
     * @return
     */
    List<DonatedStockApplicationInfoEntity> selectDealAccountList(DonatedStockApplicationInfoEntity query);

    /**
     * 待入账列表查询
     * @param query
     * @return
     */
    List<DonatedStockApplicationInfoEntity> querytWaitEntryList(DonatedStockApplicationInfoEntity query);

    /**
     * 待入账列表带排序查询
     * @param map
     * @return
     */
    List<DonatedStockApplicationInfoEntity> queryEntryListByOrder(Map<String, Object> map);
    /**
     * 根据ids查询
     * @param ids
     * @return
     */
    List<DonatedStockApplicationInfoEntity> queryObjectIds(String ids);

    /**
     * 查询待入账、入账失败记录
     * @return
     */
    List<DonatedStockApplicationInfoEntity> selectWaitStockDeposit();

    /**
     * 领取列表数量
     * @return
     */
    List<DonatedStockApplicationInfoEntity> selectApproveListCount(DonatedStockApplicationInfoEntity queryCondition);


}
