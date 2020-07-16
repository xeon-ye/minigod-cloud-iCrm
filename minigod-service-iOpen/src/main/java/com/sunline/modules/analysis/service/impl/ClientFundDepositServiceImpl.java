package com.sunline.modules.analysis.service.impl;

import com.sunline.modules.analysis.dao.ClientFundDepositDao;
import com.sunline.modules.analysis.entity.ClientFundDepositEntity;
import com.sunline.modules.analysis.service.ClientFundDepositService;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.page.PageHelper;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 客户出入金查询
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-05-04 16:22:19
 */

@Service("clientFundDepositService")
public class ClientFundDepositServiceImpl implements ClientFundDepositService {

    @Autowired
    private ClientFundDepositDao clientFundDepositDao;

    /**
     * 客户出入金查询
     *
     * @param clientFundDepositEntity
     * @param pageNum
     * @return
     */
    @Override
    public Page<ClientFundDepositEntity> findPage(ClientFundDepositEntity clientFundDepositEntity, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        PageHelper.startPage(pageNum, Constant.pageSize);
        clientFundDepositDao.queryList(clientFundDepositEntity);
        return PageHelper.endPage();
    }

    /**
     * 客户出入金查询导出excel数据
     *
     * @param clientFundDepositEntity
     * @return
     */
    @Override
    public List<ClientFundDepositEntity> findClientFundDepExcelList(ClientFundDepositEntity clientFundDepositEntity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        return clientFundDepositDao.queryList(clientFundDepositEntity);
    }

    /**
     * 客户出入金发送记录查询
     * @param clientFundDepositEntity
     * @return
     */
    @Override
    public List<ClientFundDepositEntity> queryClientFundDepositSend(ClientFundDepositEntity clientFundDepositEntity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        return clientFundDepositDao.queryClientFundDepositSend(clientFundDepositEntity);
    }

    /**
     * 客户首次入金发送记录查询
     * @param clientFundDepositEntity
     * @return
     */
    @Override
    public List<ClientFundDepositEntity> queryClientFirstDepositSend(ClientFundDepositEntity clientFundDepositEntity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        return clientFundDepositDao.queryClientFirstDepositSend(clientFundDepositEntity);
    }

    /**
     * 客户累计入金额大于年收入or财产总额
     *
     * @param clientFundDepositEntity
     * @return
     */
    @Override
    public List<ClientFundDepositEntity> queryTotalIncAmountAbnormal(ClientFundDepositEntity clientFundDepositEntity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        return clientFundDepositDao.queryTotalIncAmountAbnormal(clientFundDepositEntity);
    }

    /**
     * 获取客户首天累计入金金额
     *
     * @param entity
     * @return
     */
    @Override
    public List<ClientFundDepositEntity> queryFirstFundDepTotal(ClientFundDepositEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        return clientFundDepositDao.queryFirstFundDepTotal(entity);
    }

    @Override
    public List<ClientFundDepositEntity> queryFundDepTotal(ClientFundDepositEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        return clientFundDepositDao.queryFundDepTotal(entity);
    }

    /**
     * 获取客户新增资金
     *
     * @param entity
     * @return
     */
    @Override
    public List<ClientFundDepositEntity> queryAddAsset(ClientFundDepositEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        return clientFundDepositDao.queryAddAsset(entity);
    }
}
