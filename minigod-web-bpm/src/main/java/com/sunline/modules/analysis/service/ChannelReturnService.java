package com.sunline.modules.analysis.service;

import com.sunline.modules.analysis.entity.ChannelReturnEntity;
import com.sunline.modules.common.page.Page;

import java.util.List;
import java.util.Map;

/**
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2019-06-10 17:17:58
 */
public interface ChannelReturnService {

    ChannelReturnEntity queryObject(Long id);

    List<ChannelReturnEntity> queryList(ChannelReturnEntity queryCondition);

    List<ChannelReturnEntity> queryListByBean(ChannelReturnEntity entity);

    int queryTotal(Map<String, Object> map);

    int save(ChannelReturnEntity channelBrokerageReturnInfo);

    int update(ChannelReturnEntity channelBrokerageReturnInfo);

    int delete(Long id);

    int deleteBatch(Long[] ids);

    /**
     * 返佣列表查询
     *
     * @param queryCondition
     * @param pageNum
     * @return
     */
    Page<ChannelReturnEntity> findPage(ChannelReturnEntity queryCondition, int pageNum);

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
