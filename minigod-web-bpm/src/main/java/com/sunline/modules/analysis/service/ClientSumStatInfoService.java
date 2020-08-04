package com.sunline.modules.analysis.service;


import com.sunline.modules.analysis.entity.ClientSumStatInfoEntity;

import java.util.List;

/**
 * 客户数统计
 *
 * @author lcs
 * @email
 * @date 2018-05-9 14:56:39
 */
public interface ClientSumStatInfoService {

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
    List<ClientSumStatInfoEntity> queryDataWeek(ClientSumStatInfoEntity entity);
    List<ClientSumStatInfoEntity> queryDataDay(ClientSumStatInfoEntity entity);
}
