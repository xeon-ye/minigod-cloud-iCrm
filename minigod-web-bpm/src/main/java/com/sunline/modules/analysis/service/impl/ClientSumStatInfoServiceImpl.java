package com.sunline.modules.analysis.service.impl;

import com.sunline.modules.analysis.dao.ClientSumStatInfoDao;
import com.sunline.modules.analysis.entity.ClienIncomeCountEntity;
import com.sunline.modules.analysis.entity.ClientSumStatInfoEntity;
import com.sunline.modules.analysis.service.ClientSumStatInfoService;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 客户数统计
 *
 * @author lcs
 * @email
 * @date 2018-05-9 14:56:39
 */
@Service("clientSumStatInfoService")
public class ClientSumStatInfoServiceImpl  implements ClientSumStatInfoService {

    @Autowired
    private ClientSumStatInfoDao clientSumStatInfoDao;


    /**
     * 客户数统计
     * @return
     */
    @Override
    public ClientSumStatInfoEntity clientTotalCount(ClientSumStatInfoEntity clientSumStatInfoEntity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        return clientSumStatInfoDao.clientTotalCount(clientSumStatInfoEntity);
    }

    /**
     * 客户数统计 安卓和ios分类
     * @return
     */
    @Override
    public ClientSumStatInfoEntity clientTotalGroupCount(ClientSumStatInfoEntity clientSumStatInfoEntity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        return clientSumStatInfoDao.clientTotalGroupCount(clientSumStatInfoEntity);
    }


    @Override
    public List<ClientSumStatInfoEntity> queryDataMonth(ClientSumStatInfoEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        if(entity.getType().equals("reg")){
            return clientSumStatInfoDao.queryMonthRegCount(entity);
        }else
        if(entity.getType().equals("open")){
            return clientSumStatInfoDao.queryMonthOpenCount(entity);
        }else
        if(entity.getType().equals("income")){
            return clientSumStatInfoDao.queryMonthIncomeCount(entity);
        }else
        if(entity.getType().equals("trade")){
            return clientSumStatInfoDao.queryMonthTradeCount(entity);
        }else{
            return clientSumStatInfoDao.queryDataMonth(entity);
        }
    }

    @Override
    public List<ClientSumStatInfoEntity> queryDataWeek(ClientSumStatInfoEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        return clientSumStatInfoDao.queryDataWeek(entity);
    }

    @Override
    public List<ClientSumStatInfoEntity> queryDataDay(ClientSumStatInfoEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        return clientSumStatInfoDao.queryDataDay(entity);
    }
}
