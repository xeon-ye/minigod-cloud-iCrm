package com.sunline.modules.customer.service.impl;

import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.page.PageHelper;
import com.sunline.modules.customer.dao.ClientFareListDao;
import com.sunline.modules.customer.entity.ClientFareListEntity;
import com.sunline.modules.customer.service.ClientFareListService;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service("clientFareListService")
public class ClientFareListServiceImpl implements ClientFareListService {
    @Autowired
    private ClientFareListDao clientFareListDao;

    @Override
    public ClientFareListEntity queryObject(Integer id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFareListDao.queryObject(id);
    }

    @Override
    public List<ClientFareListEntity> queryList(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFareListDao.queryList(map);
    }

    @Override
    public List<ClientFareListEntity> queryListByBean(ClientFareListEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFareListDao.queryListByBean(entity);
    }

    @Override
    public int queryTotal(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFareListDao.queryTotal(map);
    }

    @Override
    public int save(ClientFareListEntity clientFareList){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFareListDao.save(clientFareList);
    }

    @Override
    public int update(ClientFareListEntity clientFareList){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFareListDao.update(clientFareList);
    }

    @Override
    public int delete(Integer id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFareListDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[] ids){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFareListDao.deleteBatch(ids);
    }

    /**
     * 基本查询分页
     * @param clientFareList
     * @param pageNum
     * @return
     */
    @Override
    public Page<ClientFareListEntity> findPage(ClientFareListEntity clientFareList, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        PageHelper.startPage(pageNum, Constant.pageSize);
        clientFareListDao.queryList(clientFareList);
        return PageHelper.endPage();
    }

    /**
     * 客户佣金套餐excle 导出
     * @param clientFareListEntity
     * @return
     */
    @Override
    public List<ClientFareListEntity> fareListExcelList(ClientFareListEntity clientFareListEntity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFareListDao.queryList(clientFareListEntity);
    }

    @Override
    public ClientFareListEntity queryByBean(ClientFareListEntity clientFareListEntity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFareListDao.queryByBean(clientFareListEntity);
    }

}
