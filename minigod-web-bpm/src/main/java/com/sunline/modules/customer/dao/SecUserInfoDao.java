package com.sunline.modules.customer.dao;

import com.sunline.modules.common.dao.BaseDao;
import com.sunline.modules.customer.entity.ActivityStatisticsEntity;
import com.sunline.modules.customer.entity.SecuritiesUserInfoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 客户管理
 *
 * @author jim
 * @email
 * @date 2018-03-12 11:14:27
 */
@Mapper
public interface SecUserInfoDao extends BaseDao<SecuritiesUserInfoEntity> {
    /**
     * 综合查询客户
     *
     * @param entity
     * @return
     */
    SecuritiesUserInfoEntity queryById(SecuritiesUserInfoEntity entity);

    /**
     * 查询用户
     */
    List<SecuritiesUserInfoEntity> queryUserList(Object id);

    /**
     * 综合查询
     *
     * @param securitiesUserInfoEntity
     * @return
     */
    List<SecuritiesUserInfoEntity> querySynList(SecuritiesUserInfoEntity securitiesUserInfoEntity);

    /**
     * 过滤掉已存在于分组之内的客户信息
     *
     * @param securitiesUserInfoEntity
     * @return
     */
    List<SecuritiesUserInfoEntity> queryListFilter(SecuritiesUserInfoEntity securitiesUserInfoEntity);

    /**
     * userID、交易帐号查询是否存在
     *
     * @param userInfo
     * @return
     */
    SecuritiesUserInfoEntity queryByUserId(SecuritiesUserInfoEntity userInfo);

    /**
     * 交易账户查询是否存在
     *
     * @param userInfo
     * @return
     */

    int queryByTradeAcc(SecuritiesUserInfoEntity userInfo);

    /**
     * 查询客户列表（API）
     *
     * @param securitiesUserInfoEntity
     * @return
     */
    List<SecuritiesUserInfoEntity> selectClientInfoList(SecuritiesUserInfoEntity securitiesUserInfoEntity);

    /**
     * 查询客户（API）
     *
     * @param securitiesUserInfoEntity
     * @return
     */
    SecuritiesUserInfoEntity selectClientInfo(SecuritiesUserInfoEntity securitiesUserInfoEntity);

    /**
     * 查询客户是否已存在（API）
     *
     * @param securitiesUserInfoEntity
     * @return
     */
    SecuritiesUserInfoEntity queryClient(SecuritiesUserInfoEntity securitiesUserInfoEntity);

    /**
     * 查询小神用户详情
     * @param userId
     * @return
     */
    SecuritiesUserInfoEntity getUserInfo(@Param("userId") String userId);

    int updateUserInfo(SecuritiesUserInfoEntity entity);

    /**
     * 查询活动统计
     */
    List<ActivityStatisticsEntity> queryActivityStatistics(ActivityStatisticsEntity queryCondition);

}
