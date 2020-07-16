package com.sunline.modules.ccass.service.impl;

import com.sunline.modules.ccass.dao.CcassHoldingsDao;
import com.sunline.modules.ccass.entity.CcassHoldingsEntity;
import com.sunline.modules.ccass.service.CcassHoldingsService;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.page.PageHelper;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("ccassHoldingsService")
public class CcassHoldingsServiceImpl implements CcassHoldingsService {
    @Autowired
    private CcassHoldingsDao ccassHoldingsDao;

    @Override
    public CcassHoldingsEntity queryObject(String stockCode) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        return ccassHoldingsDao.queryObject(stockCode);
    }

    @Override
    public List<CcassHoldingsEntity> queryList(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        return ccassHoldingsDao.queryList(map);
    }

    @Override
    public List<CcassHoldingsEntity> queryListByBean(CcassHoldingsEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        return ccassHoldingsDao.queryListByBean(entity);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        return ccassHoldingsDao.queryTotal(map);
    }

    @Override
    public int save(CcassHoldingsEntity ccassHoldings) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
//        ccassHoldings.setId(Utils.uuid());
        return ccassHoldingsDao.save(ccassHoldings);
    }

    @Override
    public int update(CcassHoldingsEntity ccassHoldings) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return ccassHoldingsDao.update(ccassHoldings);
    }

    @Override
    public int delete(Integer id) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return ccassHoldingsDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return ccassHoldingsDao.deleteBatch(ids);
    }

    /**
     * 获取CCASS参与者持仓信息
     *
     * @param ccassHoldingsEntity
     * @param pageNum
     * @return
     */
    @Override
    public Page<CcassHoldingsEntity> findPage(CcassHoldingsEntity ccassHoldingsEntity, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        PageHelper.startPage(pageNum, Constant.pageSize);
        ccassHoldingsDao.queryList(ccassHoldingsEntity);
        return PageHelper.endPage();
    }

    /**
     * CCASS参与者持仓信息导出列表
     *
     * @param ccassHoldingsEntity
     * @return
     */
    @Override
    public List<CcassHoldingsEntity> findCcassHoldingsInfoExcelList(CcassHoldingsEntity ccassHoldingsEntity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        List<CcassHoldingsEntity> ccassHoldingsList = ccassHoldingsDao.queryList(ccassHoldingsEntity);
        return ccassHoldingsList;
    }

}
