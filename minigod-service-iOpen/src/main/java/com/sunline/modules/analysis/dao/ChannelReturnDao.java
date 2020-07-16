package com.sunline.modules.analysis.dao;

import com.sunline.modules.analysis.entity.ChannelReturnEntity;
import com.sunline.modules.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2019-06-10 17:17:58
 */
@Mapper
public interface ChannelReturnDao extends BaseDao<ChannelReturnEntity> {
    /**
     * 批量更新
     *
     * @param ids
     * @return
     */
    int updateBatch(Long[] ids);

    /**
     * 查询入账标识
     *
     * @param queryCondition
     * @return
     */
    ChannelReturnEntity queryEntryNarrative(ChannelReturnEntity queryCondition);

    /**
     * 清空名单
     *
     * @return
     */
    int clean();

    /**
     * 汇总查询
     *
     * @param queryCondition
     * @return
     */
    List<ChannelReturnEntity> queryGroupList(ChannelReturnEntity queryCondition);
}
