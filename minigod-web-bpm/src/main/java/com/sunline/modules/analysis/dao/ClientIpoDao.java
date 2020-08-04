package com.sunline.modules.analysis.dao;

import com.sunline.modules.analysis.entity.ClientIpoEntity;
import com.sunline.modules.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * 打新查询entity
 *
 * @author  lcs
 * @date 2018-06-22 14:00:00
 * @
 */
@Mapper
public interface ClientIpoDao extends BaseDao<ClientIpoEntity>{

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
