package com.sunline.modules.customer.service;

import com.sunline.modules.common.page.Page;
import com.sunline.modules.customer.entity.ActivityStatisticsEntity;
import com.sunline.modules.customer.entity.SecuritiesUserInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * 客户管理
 * @author jim
 * @email
 * @date 2018-03-12 11:14:27
 */
public interface SecUserInfoService {

    SecuritiesUserInfoEntity queryObject(SecuritiesUserInfoEntity entity);

    SecuritiesUserInfoEntity queryById(SecuritiesUserInfoEntity entity);

    List<SecuritiesUserInfoEntity> queryList(Map<String, Object> map);

    List<SecuritiesUserInfoEntity> queryListByBean(SecuritiesUserInfoEntity entity);

    int queryTotal(Map<String, Object> map);

    int save(SecuritiesUserInfoEntity securitiesUserInfo);

    int update(SecuritiesUserInfoEntity securitiesUserInfo);

    int delete(String gid);

    int deleteBatch(String[] gids);



    /**
     * 分页列表
     * @param securitiesUserInfoEntity
     * @param pageNum
     * @return
     */
    Page<SecuritiesUserInfoEntity> findPage(SecuritiesUserInfoEntity securitiesUserInfoEntity, int pageNum);

    /**
     * 综合查询的分页列表
     * @param securitiesUserInfoEntity
     * @param pageNum
     * @return
     */
    Page<SecuritiesUserInfoEntity> queryPage(SecuritiesUserInfoEntity securitiesUserInfoEntity, int pageNum);

    List<SecuritiesUserInfoEntity> queryListFilter(SecuritiesUserInfoEntity securitiesUserInfoEntity);

    /**
     * 过滤  查不存在的用户
     * @param securitiesUserInfoEntity
     * @param pageNum
     * @return
     */
    Page<SecuritiesUserInfoEntity> findPageFilter(SecuritiesUserInfoEntity securitiesUserInfoEntity, int pageNum);

    /**
     * 小神用户查询分页列表
     * @param securitiesUserInfoEntity
     * @param pageNum
     * @return
     */
    Page<SecuritiesUserInfoEntity> userPageList(SecuritiesUserInfoEntity securitiesUserInfoEntity, int pageNum);

    /**
     * 查询userID是否存在
     * @param userInfo
     * @return
     */
    SecuritiesUserInfoEntity queryByUserId(SecuritiesUserInfoEntity userInfo);

    /**
     * 查询交易账户是否存在
     * @param userInfo
     * @return
     */
    int queryByTradeAcc(SecuritiesUserInfoEntity userInfo);

    /**
     * 客户基本查询 excel导出
     * @param userInfo
     * @return
     */
    List<SecuritiesUserInfoEntity> customerListExcelList(SecuritiesUserInfoEntity userInfo);

    /**
     * 客户综合查询 excel导出
     * @param userInfo
     * @return
     */
    List<SecuritiesUserInfoEntity> cusSynListExcelList(SecuritiesUserInfoEntity userInfo);

    /**
     * 小神用户查询 excel导出
     * @param userInfo
     * @return
     */
    List<SecuritiesUserInfoEntity> cusUserListExcelList(SecuritiesUserInfoEntity userInfo);

    /**
     * 小神用户资料详情
     * @param userId
     * @return
     */
    SecuritiesUserInfoEntity getUserInfo(String userId);

    int updateUserInfo(SecuritiesUserInfoEntity entity);

    /**
     * 查询活动统计
     * @param queryCondition
     * @param pageNum
     * @return
     */
    Page<ActivityStatisticsEntity> queryActivityStatistics(ActivityStatisticsEntity queryCondition, int pageNum);

    /**
     *活动统计
     * @param queryCondition
     * @return
     */
    List<ActivityStatisticsEntity> queryActivityStatistics(ActivityStatisticsEntity queryCondition);
}
