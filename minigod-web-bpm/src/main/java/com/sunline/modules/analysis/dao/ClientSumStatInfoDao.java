package com.sunline.modules.analysis.dao;

import com.sunline.modules.analysis.entity.ClientSumStatInfoEntity;
import com.sunline.modules.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 客户数统计
 *
 * @author lcs
 * @email
 * @date 2018-05-9 14:56:39
 */
@Mapper
public interface ClientSumStatInfoDao extends BaseDao {
    /**
     * 客户数统计
     * @param clientSumStatInfoEntity
     * @return
     */
     ClientSumStatInfoEntity clientTotalCount(ClientSumStatInfoEntity clientSumStatInfoEntity);

    /**
     * 客户数统计 安卓和ios分类
     * @param clientSumStatInfoEntity
     * @return
     */
    ClientSumStatInfoEntity clientTotalGroupCount(ClientSumStatInfoEntity clientSumStatInfoEntity);

    List<ClientSumStatInfoEntity> queryDataMonth(ClientSumStatInfoEntity entity);
    List<ClientSumStatInfoEntity> queryMonthRegCount(ClientSumStatInfoEntity entity);
    List<ClientSumStatInfoEntity> queryMonthOpenCount(ClientSumStatInfoEntity entity);
    List<ClientSumStatInfoEntity> queryMonthIncomeCount(ClientSumStatInfoEntity entity);
    List<ClientSumStatInfoEntity> queryMonthTradeCount(ClientSumStatInfoEntity entity);
    List<ClientSumStatInfoEntity> queryDataWeek(ClientSumStatInfoEntity entity);
    List<ClientSumStatInfoEntity> queryDataDay(ClientSumStatInfoEntity entity);
}
