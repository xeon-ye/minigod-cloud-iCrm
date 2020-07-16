package com.sunline.modules.fund.service.impl;

import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.page.PageHelper;
import com.sunline.modules.fund.dao.ClientBankCardInfoDao;
import com.sunline.modules.fund.entity.ClientBankCardInfoEntity;
import com.sunline.modules.fund.service.ClientBankCardInfoService;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 银行卡管理记录表
 *
 * @author lidh
 * @email jim@zszhizhu.com
 * @date 2019-06-01 14:52:31
 */

@Service("clientBankCardInfoService")
public class ClientBankCardInfoServiceImpl implements ClientBankCardInfoService {
    @Autowired
    private ClientBankCardInfoDao clientBankCardInfoDao;

    @Override
    public ClientBankCardInfoEntity queryObject(Long id) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientBankCardInfoDao.queryObject(id);
    }

    @Override
    public List<ClientBankCardInfoEntity> queryList(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientBankCardInfoDao.queryList(map);
    }

    @Override
    public List<ClientBankCardInfoEntity> queryListByBean(ClientBankCardInfoEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientBankCardInfoDao.queryList(entity);
    }

    @Override
    public Page<ClientBankCardInfoEntity> findPage(ClientBankCardInfoEntity entity, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        PageHelper.startPage(pageNum, Constant.pageSize);
        clientBankCardInfoDao.queryList(entity);
        return PageHelper.endPage();
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientBankCardInfoDao.queryTotal(map);
    }

    @Override
    public int save(ClientBankCardInfoEntity clientBankCardInfo) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
//        clientBankCardInfo.setId(Utils.uuid());
        return clientBankCardInfoDao.save(clientBankCardInfo);
    }

    @Override
    public int update(ClientBankCardInfoEntity clientBankCardInfo) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientBankCardInfoDao.update(clientBankCardInfo);
    }

    @Override
    public int delete(Long id) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientBankCardInfoDao.delete(id);
    }

    @Override
    public int deleteBatch(Long[] ids) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientBankCardInfoDao.deleteBatch(ids);
    }

}
