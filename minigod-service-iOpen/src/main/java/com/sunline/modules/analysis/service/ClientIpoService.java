package com.sunline.modules.analysis.service;

import com.sunline.modules.analysis.entity.ClientIpoEntity;
import com.sunline.modules.analysis.entity.ClientIpoIncomeEntity;
import com.sunline.modules.common.page.Page;

import java.util.List;

/**
 * 打新查询
 *
 * @author  lcs
 * @date 2018-06-22 14:00:00
 * @
 */
public interface ClientIpoService {

     List<ClientIpoEntity> hitNewQqueryList(ClientIpoEntity clientIpoEntity);

     Page<ClientIpoEntity> queryList(ClientIpoEntity clientIpoEntity, int pageNum);

    /**
     * 活动打新 2018-09-19
     */
     Page<ClientIpoIncomeEntity> getIpoIncomeList(ClientIpoIncomeEntity clientIpoIncomeEntity, int pageNum);

    /**
     * 活动打新 2018-09-19
     */
    List<ClientIpoIncomeEntity> getIpoIncomeList(ClientIpoIncomeEntity clientIpoIncomeEntity);

    /**
     * 查询IPO融资信息
     * @param queryCondition
     * @return
     */
    List<ClientIpoEntity> queryIpoFinancing(ClientIpoEntity queryCondition);

    /**
     * 查询客户首次认购IPO信息
     * @param queryCondition
     * @return
     */
    List<ClientIpoEntity> queryFirstBuyIpo(ClientIpoEntity queryCondition);
}
