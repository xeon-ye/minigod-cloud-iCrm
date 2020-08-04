package com.sunline.modules.analysis.service.impl;

import com.sunline.modules.analysis.dao.ClientIpoDao;
import com.sunline.modules.analysis.dao.ClientIpoIncomeDao;
import com.sunline.modules.analysis.entity.ClientIpoEntity;
import com.sunline.modules.analysis.entity.ClientIpoIncomeEntity;
import com.sunline.modules.analysis.service.ClientIpoService;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.page.PageHelper;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 打新查询
 *
 * @author lcs
 * @date 2018-06-22 14:00:00
 * @
 */
@Service("clientIpoService")
public class ClientIpoServiceImpl implements ClientIpoService {
    @Autowired
    private ClientIpoDao clientIpoDao;
    @Autowired
    private ClientIpoIncomeDao clientIpoIncomeDao;

    @Override
    public List<ClientIpoEntity> hitNewQqueryList(ClientIpoEntity clientIpoEntity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        return clientIpoDao.queryList(clientIpoEntity);
    }

    @Override
    public Page<ClientIpoEntity> queryList(ClientIpoEntity clientIpoEntity, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        PageHelper.startPage(pageNum, Constant.pageSize);
        clientIpoDao.queryList(clientIpoEntity);
        return PageHelper.endPage();
    }

    @Override
    public Page<ClientIpoIncomeEntity> getIpoIncomeList(ClientIpoIncomeEntity clientIpoIncomeEntity, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        PageHelper.startPage(pageNum, Constant.pageSize);
        clientIpoIncomeDao.queryList(clientIpoIncomeEntity);
        return PageHelper.endPage();
    }

    @Override
    public List<ClientIpoIncomeEntity> getIpoIncomeList(ClientIpoIncomeEntity clientIpoIncomeEntity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        return clientIpoIncomeDao.queryList(clientIpoIncomeEntity);
    }

    /**
     * 查询IPO融资信息
     *
     * @param queryCondition
     * @return
     */
    @Override
    public List<ClientIpoEntity> queryIpoFinancing(ClientIpoEntity queryCondition) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        return clientIpoDao.queryIpoFinancing(queryCondition);
    }

    /**
     * 查询客户首次认购IPO信息
     *
     * @param queryCondition
     * @return
     */
    @Override
    public List<ClientIpoEntity> queryFirstBuyIpo(ClientIpoEntity queryCondition) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        return clientIpoDao.queryFirstBuyIpo(queryCondition);
    }
}
