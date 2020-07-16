package com.sunline.modules.analysis.service.impl;

import com.sunline.modules.analysis.dao.ClientTradeFlowInfoDao;
import com.sunline.modules.analysis.entity.ClientTradeFlowInfoEntity;
import com.sunline.modules.analysis.service.ClientTradeFlowInfoService;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.page.PageHelper;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 客户交易流水汇总表
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-04-24 17:56:39
 */

@Service("clientTradeFlowInfoService")
public class ClientTradeFlowInfoServiceImpl implements ClientTradeFlowInfoService {

    @Autowired
    private ClientTradeFlowInfoDao clientTradeFlowInfoDao;

    /**
     * 交易查询
     *
     * @param clientTradeFlowInfoEntity
     * @param pageNum
     * @return
     */
    @Override
    public Page<ClientTradeFlowInfoEntity> findPage(ClientTradeFlowInfoEntity clientTradeFlowInfoEntity, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        PageHelper.startPage(pageNum, Constant.pageSize);
        clientTradeFlowInfoDao.queryList(clientTradeFlowInfoEntity);
        return PageHelper.endPage();
    }

    /**
     * 交易查询导出Excel数据
     *
     * @param clientTradeFlowInfoEntity
     * @return
     */
    @Override
    public List<ClientTradeFlowInfoEntity> findTrdDetailListExcelList(ClientTradeFlowInfoEntity clientTradeFlowInfoEntity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        List<ClientTradeFlowInfoEntity> clientTradeFlowInfoList = clientTradeFlowInfoDao.queryList(clientTradeFlowInfoEntity);
        return clientTradeFlowInfoList;
    }

    /**
     * 交易统计
     *
     * @param clientTradeFlowInfoEntity
     * @param pageNum
     * @return
     */
    @Override
    public Page<ClientTradeFlowInfoEntity> findGroupPage(ClientTradeFlowInfoEntity clientTradeFlowInfoEntity, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        PageHelper.startPage(pageNum, Constant.pageSize);
        clientTradeFlowInfoDao.queryGroupList(clientTradeFlowInfoEntity);
        return PageHelper.endPage();
    }

    /**
     * 交易统计导出Excel数据
     *
     * @param clientTradeFlowInfoEntity
     * @return
     */
    @Override
    public List<ClientTradeFlowInfoEntity> findTrdGroupListExcelList(ClientTradeFlowInfoEntity clientTradeFlowInfoEntity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        List<ClientTradeFlowInfoEntity> clientTradeFlowInfoList = clientTradeFlowInfoDao.queryGroupList(clientTradeFlowInfoEntity);
        return clientTradeFlowInfoList;
    }


    /**
     * 交易查询  图示数据
     *
     * @param entity
     * @return
     */
    @Override
    public List<ClientTradeFlowInfoEntity> queryListGroupByParam(ClientTradeFlowInfoEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        return clientTradeFlowInfoDao.queryListGroupByParam(entity);
    }

    /**
     * 获取客户首次交易信息
     *
     * @param entity
     * @return
     */
    @Override
    public List<ClientTradeFlowInfoEntity> getFirstTrdInfo(ClientTradeFlowInfoEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        return clientTradeFlowInfoDao.getFirstTrdInfo(entity);
    }

    /**
     * 获取渠道返佣数据
     *
     * @param queryCondition
     * @return
     */
    @Override
    public List<ClientTradeFlowInfoEntity> findChannelReturnList(ClientTradeFlowInfoEntity queryCondition) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        return clientTradeFlowInfoDao.queryChannelReturnList(queryCondition);
    }

    /**
     * 批量插入
     *
     * @param list
     * @return
     */
    @Override
    public int saveBatch(List<ClientTradeFlowInfoEntity> list) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientTradeFlowInfoDao.saveBatch(list);
    }
}
