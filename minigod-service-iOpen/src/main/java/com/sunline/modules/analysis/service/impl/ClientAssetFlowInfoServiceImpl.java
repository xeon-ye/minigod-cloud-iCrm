package com.sunline.modules.analysis.service.impl;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import com.google.common.collect.Lists;
import com.sunline.modules.analysis.dao.ClientAssetFlowInfoDao;
import com.sunline.modules.analysis.entity.ClientAssetFlowInfoEntity;
import com.sunline.modules.analysis.entity.ClientFundCountEntity;
import com.sunline.modules.analysis.service.ClientAssetFlowInfoService;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.page.PageHelper;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 客户资金流水汇总表
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-04-28 14:24:52
 */

@Service("clientAssetFlowInfoService")
public class ClientAssetFlowInfoServiceImpl implements ClientAssetFlowInfoService {

    @Autowired
    private ClientAssetFlowInfoDao clientAssetFlowInfoDao;

    /**
     * 资金查询
     *
     * @param clientAssetFlowInfoEntity
     * @param pageNum
     * @return
     */
    @Override
    public Page<ClientAssetFlowInfoEntity> findPage(ClientAssetFlowInfoEntity clientAssetFlowInfoEntity, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        PageHelper.startPage(pageNum, Constant.pageSize);
        clientAssetFlowInfoDao.queryList(clientAssetFlowInfoEntity);
        return PageHelper.endPage();
    }

    /**
     * 资金统计
     *
     * @param clientAssetFlowInfoEntity
     * @param pageNum
     * @return
     */
    @Override
    public Page<ClientAssetFlowInfoEntity> findGroupPage(ClientAssetFlowInfoEntity clientAssetFlowInfoEntity, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        PageHelper.startPage(pageNum, Constant.pageSize);
        clientAssetFlowInfoDao.queryGroupList(clientAssetFlowInfoEntity);
        return PageHelper.endPage();
    }

    /**
     * 资金查询导出Excel数据
     * @param clientAssetFlowInfoEntity
     * @return
     */
    @Override
    public List<ClientAssetFlowInfoEntity> findAssetDetailListExcelList(ClientAssetFlowInfoEntity clientAssetFlowInfoEntity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        List<ClientAssetFlowInfoEntity> clientAssetFlowInfoList = clientAssetFlowInfoDao.queryList(clientAssetFlowInfoEntity);
        return clientAssetFlowInfoList;
    }

    /**
     * 资金统计导出Excel数据
     * @param clientAssetFlowInfoEntity
     * @return
     */
    @Override
    public List<ClientAssetFlowInfoEntity> findAssetGroupListExcelList(ClientAssetFlowInfoEntity clientAssetFlowInfoEntity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        List<ClientAssetFlowInfoEntity> clientAssetFlowInfoList = clientAssetFlowInfoDao.queryGroupList(clientAssetFlowInfoEntity);
        return clientAssetFlowInfoList;
    }

    /**
     * 获取总资产大于0的客户名单
     * @param clientAssetFlowInfoEntity
     * @return
     */
    @Override
    public List<ClientAssetFlowInfoEntity> getAssetGtZeroClientList(ClientAssetFlowInfoEntity clientAssetFlowInfoEntity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        List<ClientAssetFlowInfoEntity> clientAssetFlowInfoList = clientAssetFlowInfoDao.getAssetGtZeroClientList(clientAssetFlowInfoEntity);
        return clientAssetFlowInfoList;
    }

    @Override
    public List<ClientFundCountEntity> getClientFundCountGraphic(ClientFundCountEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        if("2".equals(entity.getDateType())){
            List<ClientFundCountEntity> monthCount = Lists.newArrayList();
            String year = String.valueOf(DateUtil.parse(entity.getTradeDate()).year());
            for(int i = 1;i<=12;i++){
                String month;
                if(i<10){
                    month = "0"+i;
                }else{
                    month = String.valueOf(i);
                }
                String tableName = "client_asset_flow_info_" + year+month;
                entity.setTableName1(tableName);
                entity.setTradeDate(year+month);
                List<ClientFundCountEntity> entityList = clientAssetFlowInfoDao.countFundByMonth(entity);
                monthCount.addAll(entityList);
            }
            return monthCount;
        }else {
            String tableName1 = "client_asset_flow_info_" + DateUtil.format(DateUtil.offset(DateUtil.parse(entity.getTradeDate()), DateField.MONTH, -1),"yyyyMM");
            entity.setTableName1(tableName1);
            String tableName2 = "client_asset_flow_info_" + DateUtil.format(DateUtil.parse(entity.getTradeDate()),"yyyyMM");
            entity.setTableName2(tableName2);
            return clientAssetFlowInfoDao.countFundByDay(entity);
        }
    }

    @Override
    public List<Object> getAssetGtTradeDateClientInfoList(ClientAssetFlowInfoEntity clientAssetFlowInfoEntity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        return clientAssetFlowInfoDao.getAssetGtTradeDateClientInfoList(clientAssetFlowInfoEntity);
    }
}
