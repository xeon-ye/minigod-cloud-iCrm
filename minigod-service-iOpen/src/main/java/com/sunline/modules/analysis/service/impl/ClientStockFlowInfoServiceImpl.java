package com.sunline.modules.analysis.service.impl;

import com.sunline.modules.analysis.dao.ClientStockFlowInfoDao;
import com.sunline.modules.analysis.entity.ClientStockFlowInfoEntity;
import com.sunline.modules.analysis.service.ClientStockFlowInfoService;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.page.PageHelper;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 客户股票流水汇总表
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-05-02 17:12:17
 */

@Service("clientStockFlowInfoService")
public class ClientStockFlowInfoServiceImpl implements ClientStockFlowInfoService {

    @Autowired
    private ClientStockFlowInfoDao clientStockFlowInfoDao;

    /**
     * 股份查询
     *
     * @param clientStockFlowInfoEntity
     * @param pageNum
     * @return
     */
    @Override
    public Page<ClientStockFlowInfoEntity> findPage(ClientStockFlowInfoEntity clientStockFlowInfoEntity, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        PageHelper.startPage(pageNum, Constant.pageSize);
        clientStockFlowInfoDao.queryList(clientStockFlowInfoEntity);
        return PageHelper.endPage();
    }

    /**
     * 股份统计
     *
     * @param clientStockFlowInfoEntity
     * @param pageNum
     * @return
     */
    @Override
    public Page<ClientStockFlowInfoEntity> findGroupPage(ClientStockFlowInfoEntity clientStockFlowInfoEntity, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        PageHelper.startPage(pageNum, Constant.pageSize);
        clientStockFlowInfoDao.queryGroupList(clientStockFlowInfoEntity);
        return PageHelper.endPage();
    }

    /**
     * 股份查询导出Excel数据
     *
     * @param clientStockFlowInfoEntity
     * @return
     */
    @Override
    public List<ClientStockFlowInfoEntity> findStkDetailListExcelList(ClientStockFlowInfoEntity clientStockFlowInfoEntity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        List<ClientStockFlowInfoEntity> clientAssetFlowInfoList = clientStockFlowInfoDao.queryList(clientStockFlowInfoEntity);
        return clientAssetFlowInfoList;
    }

    /**
     * 股份统计导出Excel数据
     *
     * @param clientStockFlowInfoEntity
     * @return
     */
    @Override
    public List<ClientStockFlowInfoEntity> findStkGroupListExcelList(ClientStockFlowInfoEntity clientStockFlowInfoEntity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        List<ClientStockFlowInfoEntity> clientAssetFlowInfoList = clientStockFlowInfoDao.queryGroupList(clientStockFlowInfoEntity);
        return clientAssetFlowInfoList;
    }
}
