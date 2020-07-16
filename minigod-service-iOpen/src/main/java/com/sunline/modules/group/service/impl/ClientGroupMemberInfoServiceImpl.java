package com.sunline.modules.group.service.impl;

import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.page.PageHelper;
import com.sunline.modules.common.utils.Utils;
import com.sunline.modules.group.dao.ClientGroupMemberInfoDao;
import com.sunline.modules.group.entity.ClientGroupMemberInfoEntity;
import com.sunline.modules.group.service.ClientGroupMemberInfoService;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @author jim
 * @email
 * @date 2018-03-12 11:14:27
 */
@Service("clientGroupMemberInfoService")
public class ClientGroupMemberInfoServiceImpl implements ClientGroupMemberInfoService {


    @Autowired
    private ClientGroupMemberInfoDao clientGroupMemberInfoDao;

    @Override
    public ClientGroupMemberInfoEntity queryObject(Integer id) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientGroupMemberInfoDao.queryObject(id);
    }

    @Override
    public List<ClientGroupMemberInfoEntity> queryList(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientGroupMemberInfoDao.queryList(map);
    }

    @Override
    public List<ClientGroupMemberInfoEntity> query(ClientGroupMemberInfoEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientGroupMemberInfoDao.queryList(entity);
    }

    @Override
    public List<ClientGroupMemberInfoEntity> queryListByBean(ClientGroupMemberInfoEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientGroupMemberInfoDao.queryListByBean(entity);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientGroupMemberInfoDao.queryTotal(map);
    }

    @Override
    public int save(ClientGroupMemberInfoEntity clientGroupMemberInfo) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        clientGroupMemberInfo.setId(Utils.uuid());
        return clientGroupMemberInfoDao.save(clientGroupMemberInfo);
    }

    @Override
    public int update(ClientGroupMemberInfoEntity clientGroupMemberInfo) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientGroupMemberInfoDao.update(clientGroupMemberInfo);
    }

    @Override
    public int updateGroup(ClientGroupMemberInfoEntity clientGroupMemberInfo) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientGroupMemberInfoDao.updateGroup(clientGroupMemberInfo);
    }

    @Override
    public int delete(Integer id) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientGroupMemberInfoDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientGroupMemberInfoDao.deleteBatch(ids);
    }

    @Override
    public Page<ClientGroupMemberInfoEntity> groupListPage(ClientGroupMemberInfoEntity clientGroupMemberInfoEntity, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        PageHelper.startPage(pageNum, Constant.pageSize);
        clientGroupMemberInfoDao.quertListByGroup(clientGroupMemberInfoEntity);
        return PageHelper.endPage();
    }

    @Override
    public Page<ClientGroupMemberInfoEntity> findPage(ClientGroupMemberInfoEntity clientGroupMemberInfoEntity, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        PageHelper.startPage(pageNum, Constant.pageSize);
        clientGroupMemberInfoDao.queryList(clientGroupMemberInfoEntity);
        return PageHelper.endPage();
    }

    @Override
    public int deleteAll(Integer groupNo) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientGroupMemberInfoDao.deleteAll(groupNo);
    }

    @Override
    public List<ClientGroupMemberInfoEntity> clientGroupExpExcelList(ClientGroupMemberInfoEntity clientGroupMemberInfoEntity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientGroupMemberInfoDao.quertListByGroup(clientGroupMemberInfoEntity);
    }

    @Override
    public List<ClientGroupMemberInfoEntity>  selectRepeat() {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientGroupMemberInfoDao.selectRepeat();
    }
}
