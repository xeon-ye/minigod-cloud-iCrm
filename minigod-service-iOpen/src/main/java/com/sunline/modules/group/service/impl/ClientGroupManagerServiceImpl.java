package com.sunline.modules.group.service.impl;

import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.page.PageHelper;
import com.sunline.modules.common.utils.UserUtils;
import com.sunline.modules.sys.entity.UserEntity;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.sunline.modules.common.utils.Utils;
import com.sunline.modules.group.dao.ClientGroupManagerDao;
import com.sunline.modules.group.entity.ClientGroupManagerEntity;
import com.sunline.modules.group.service.ClientGroupManagerService;


/**
 * @author jim
 * @email
 * @date 2018-03-12 11:14:27
 */
@Service("clientGroupManagerService")
public class ClientGroupManagerServiceImpl implements ClientGroupManagerService {
    @Autowired
    private ClientGroupManagerDao clientGroupManagerDao;

    @Override
    public ClientGroupManagerEntity queryObject(Integer id) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientGroupManagerDao.queryObject(id);
    }

    @Override
    public List<ClientGroupManagerEntity> queryList(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientGroupManagerDao.queryList(map);
    }

    @Override
    public List<ClientGroupManagerEntity> queryListByBean(ClientGroupManagerEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientGroupManagerDao.queryListByBean(entity);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientGroupManagerDao.queryTotal(map);
    }

    @Override
    public int save(ClientGroupManagerEntity clientGroupManager) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        UserEntity user = UserUtils.getCurrentUser();
        clientGroupManager.setCreateUser(user.getUserName());
        clientGroupManager.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        return clientGroupManagerDao.save(clientGroupManager);
    }

    @Override
    public int update(ClientGroupManagerEntity clientGroupManager) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientGroupManagerDao.update(clientGroupManager);
    }

    @Override
    public int delete(Integer id) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientGroupManagerDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientGroupManagerDao.deleteBatch(ids);
    }

    /**
     *  分页查询
     * @param clientGroupManagerEntity
     * @param pageNum
     * @return
     */
    @Override
    public Page<ClientGroupManagerEntity> findPage(ClientGroupManagerEntity clientGroupManagerEntity, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        PageHelper.startPage(pageNum, Constant.pageSize);
        clientGroupManagerDao.queryList(clientGroupManagerEntity);
        return PageHelper.endPage();
    }

    /**
     * 分组名称查询
     * @param clientGroupManagerEntity
     * @return
     */
    @Override
    public int queryByGroupName(ClientGroupManagerEntity clientGroupManagerEntity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientGroupManagerDao.queryByGroupName(clientGroupManagerEntity);
    }
    /**
     * 分组编号查询
     * @param clientGroupManagerEntity
     * @return
     */
    @Override
    public int queryByGroupNo(ClientGroupManagerEntity clientGroupManagerEntity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientGroupManagerDao.queryByGroupNo(clientGroupManagerEntity);
    }

}
