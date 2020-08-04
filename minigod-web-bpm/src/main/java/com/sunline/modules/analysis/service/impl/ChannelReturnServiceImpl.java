package com.sunline.modules.analysis.service.impl;

import com.sunline.modules.analysis.dao.ChannelReturnDao;
import com.sunline.modules.analysis.entity.ChannelReturnEntity;
import com.sunline.modules.analysis.service.ChannelReturnService;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.page.PageHelper;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2019-06-10 17:17:58
 */

@Service("channelReturnService")
public class ChannelReturnServiceImpl implements ChannelReturnService {
    @Autowired
    private ChannelReturnDao channelReturnDao;

    @Override
    public ChannelReturnEntity queryObject(Long id) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        return channelReturnDao.queryObject(id);
    }

    @Override
    public List<ChannelReturnEntity> queryList(ChannelReturnEntity queryCondition) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        return channelReturnDao.queryList(queryCondition);
    }

    @Override
    public List<ChannelReturnEntity> queryListByBean(ChannelReturnEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        return channelReturnDao.queryListByBean(entity);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        return channelReturnDao.queryTotal(map);
    }

    @Override
    public int save(ChannelReturnEntity channelBrokerageReturnInfo) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
//        channelBrokerageReturnInfo.setId(Utils.uuid());
        return channelReturnDao.save(channelBrokerageReturnInfo);
    }

    @Override
    public int update(ChannelReturnEntity channelBrokerageReturnInfo) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return channelReturnDao.update(channelBrokerageReturnInfo);
    }

    @Override
    public int delete(Long id) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return channelReturnDao.delete(id);
    }

    @Override
    public int deleteBatch(Long[] ids) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return channelReturnDao.deleteBatch(ids);
    }

    /**
     * 返佣列表查询
     *
     * @param queryCondition
     * @param pageNum
     * @return
     */
    @Override
    public Page<ChannelReturnEntity> findPage(ChannelReturnEntity queryCondition, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        PageHelper.startPage(pageNum, Constant.pageSize);
        channelReturnDao.queryList(queryCondition);
        return PageHelper.endPage();
    }

    /**
     * 批量更新
     *
     * @param ids
     * @return
     */
    @Override
    public int updateBatch(Long[] ids) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return channelReturnDao.updateBatch(ids);
    }

    /**
     * 查询入账标识
     *
     * @param queryCondition
     * @return
     */
    @Override
    public ChannelReturnEntity queryEntryNarrative(ChannelReturnEntity queryCondition) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return channelReturnDao.queryEntryNarrative(queryCondition);
    }

    /**
     * 清空名单
     *
     * @return
     */
    @Override
    public int clean() {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return channelReturnDao.clean();
    }

    /**
     * 汇总查询
     *
     * @param queryCondition
     * @return
     */
    @Override
    public List<ChannelReturnEntity> queryGroupList(ChannelReturnEntity queryCondition) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        return channelReturnDao.queryGroupList(queryCondition);
    }

}
