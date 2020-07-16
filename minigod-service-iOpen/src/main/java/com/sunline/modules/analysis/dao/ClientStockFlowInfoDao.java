package com.sunline.modules.analysis.dao;

import com.sunline.modules.analysis.entity.ClientStockFlowInfoEntity;
import com.sunline.modules.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 客户股票流水汇总表
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-05-02 17:12:17
 */
@Mapper
public interface ClientStockFlowInfoDao extends BaseDao<ClientStockFlowInfoEntity> {

    /**
     * 股份统计
     *
     * @param id
     * @return
     */
    List<ClientStockFlowInfoEntity> queryGroupList(Object id);
}
