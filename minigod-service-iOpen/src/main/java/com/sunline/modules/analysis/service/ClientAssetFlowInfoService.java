package com.sunline.modules.analysis.service;

import com.sunline.modules.analysis.entity.ClientAssetFlowInfoEntity;
import com.sunline.modules.analysis.entity.ClientFundCountEntity;
import com.sunline.modules.common.page.Page;

import java.util.List;

/**
 * 客户资金流水汇总表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-04-28 14:24:52
 */
public interface ClientAssetFlowInfoService {

    /**
     * 资金查询
     *
     * @param clientAssetFlowInfoEntity
     * @param pageNum
     * @return
     */
    Page<ClientAssetFlowInfoEntity> findPage(ClientAssetFlowInfoEntity clientAssetFlowInfoEntity, int pageNum);

    /**
     * 资金统计
     *
     * @param clientAssetFlowInfoEntity
     * @param pageNum
     * @return
     */
    Page<ClientAssetFlowInfoEntity> findGroupPage(ClientAssetFlowInfoEntity clientAssetFlowInfoEntity, int pageNum);

    /**
     * 资金查询导出excel数据
     *
     * @param clientAssetFlowInfoEntity
     * @return
     */
    List<ClientAssetFlowInfoEntity> findAssetDetailListExcelList(ClientAssetFlowInfoEntity clientAssetFlowInfoEntity);

    /**
     * 资金统计导出excel数据
     *
     * @param clientAssetFlowInfoEntity
     * @return
     */
    List<ClientAssetFlowInfoEntity> findAssetGroupListExcelList(ClientAssetFlowInfoEntity clientAssetFlowInfoEntity);

    /**
     * 获取总资产大于0的客户名单
     * @param clientAssetFlowInfoEntity
     * @return
     */
    List<ClientAssetFlowInfoEntity> getAssetGtZeroClientList(ClientAssetFlowInfoEntity clientAssetFlowInfoEntity);

    /**
     * 资金统计图数据查询
     *
     * @param clientAssetFlowInfoEntity
     * @return
     */
    public List<ClientFundCountEntity> getClientFundCountGraphic(ClientFundCountEntity clientAssetFlowInfoEntity);

    /**
     * 获取连续X交易日，资产大于amount的客户信息
     * @param clientAssetFlowInfoEntity
     * @return
     */
    List<Object> getAssetGtTradeDateClientInfoList(ClientAssetFlowInfoEntity clientAssetFlowInfoEntity);

}
