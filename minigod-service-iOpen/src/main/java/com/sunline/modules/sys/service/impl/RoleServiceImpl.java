package com.sunline.modules.sys.service.impl;


import com.google.common.collect.Maps;
import com.sunline.modules.common.utils.UserUtils;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.page.PageHelper;
import com.sunline.modules.common.utils.Utils;
import com.sunline.modules.sys.dao.RoleDao;
import com.sunline.modules.sys.dao.RoleMenuDao;
import com.sunline.modules.sys.dao.UserRoleDao;
import com.sunline.modules.sys.entity.RoleEntity;
import com.sunline.modules.sys.entity.UserEntity;
import com.sunline.modules.sys.entity.UserWindowDto;
import com.sunline.modules.sys.service.RoleService;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Autowired
    private RoleMenuDao roleMenuDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Override
    public RoleEntity queryObject(String id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return roleDao.queryObject(id);
    }

    @Override
    public List<RoleEntity> queryList(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return roleDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return roleDao.queryTotal(map);
    }


    @Override
    @Transactional
    public void save(RoleEntity role) throws Exception{
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        UserEntity currentUser = UserUtils.getCurrentUser();
        role.setBapid(currentUser.getBapid());
        role.setBaid(currentUser.getBaid());
        role.setCreateId(currentUser.getId());
        role.setId(Utils.uuid());
        role.setCreateTime(new Date());
        role.setUpdateTime(new Date());
        roleDao.save(role);
        saveRtable(role);
    }

    /**
     * 保存角色与菜单，角色与组织，角色与渠道关系表
     * @param role
     */
    public void saveRtable(RoleEntity role){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        if(role.getMenuIdList() != null && role.getMenuIdList().size()>0){
            Map map = Maps.newHashMap();
            map.put("roleId",role.getId());
            map.put("menuIdList",role.getMenuIdList());
            roleMenuDao.save(map);
        }
        if(role.getOrganIdList() != null && role.getOrganIdList().size()>0){
            Map organ = Maps.newHashMap();
            organ.put("role_id",role.getId());
            organ.put("organIdList",role.getOrganIdList());
            roleDao.batchSaveRoleOrgan(organ);
        }
        if(role.getChannelIdList() != null && role.getChannelIdList().size()>0){
            String userName = UserUtils.getCurrentUser().getUserName();
            Map channel = Maps.newHashMap();
            channel.put("roleId",role.getId());
            channel.put("createUser",UserUtils.getCurrentUserId());
            channel.put("channelIdList",role.getChannelIdList());
            roleMenuDao.saveChannel(channel);
        }
    }

    @Transactional
    @Override
    public void update(RoleEntity role){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        role.setUpdateTime(new Date());
        role.setUpdateId(UserUtils.getCurrentUser().getId());
        roleDao.update(role);
        //先删除所有角色菜单关系，再批量保存
        roleMenuDao.delete(role.getId());
        roleMenuDao.deleteChannel(role.getId());
        //先删除所有角色组织关系，再批量保存
        roleDao.delRoleOrganByRoleId(role.getId());
        saveRtable(role);
    }

    @Transactional
    @Override
    public void updateByOption(RoleEntity role){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        role.setUpdateTime(new Date());
        role.setUpdateId(UserUtils.getCurrentUser().getId());
        roleDao.update(role);
        switch (role.getOption()) {
//            case 0:
//                roleMenuDao.delete(role.getId());
//                roleMenuDao.deleteChannel(role.getId());
//                roleDao.delRoleOrganByRoleId(role.getId());
            case 1:
                //先删除所有角色菜单关系，再批量保存
                roleMenuDao.delete(role.getId());
                break;
            case 2:
                roleDao.delRoleOrganByRoleId(role.getId());
                break;
            case 3:
                //先删除所有角色组织关系，再批量保存
                roleMenuDao.deleteChannel(role.getId());
                break;
            default:

        }
        saveRtable(role);
    }

    @Override
    public void delete(String id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        roleDao.delete(id);
    }

    @Transactional
    @Override
    public void deleteBatch(String[] ids) throws Exception{
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        roleDao.deleteBatch(ids);
        roleMenuDao.deleteBatch(ids);
        userRoleDao.deleteBatchByRoleId(ids);
    }

    @Override
    public List<RoleEntity> queryByUserId(String userId, String status) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return roleDao.queryByUserId(userId,status);
    }

    @Override
    public List<String> queryOrganRoleByRoleId(String roleId) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        Map params = Maps.newHashMap();
        params.put("roleId",roleId);
        params.put("isDel", Constant.YESNO.NO.getValue());
        return roleDao.queryOrganRoleByRoleId(params);
    }

    @Override
    public Page<UserWindowDto> queryPageByDto(UserWindowDto userWindowDto, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        PageHelper.startPage(pageNum, Constant.pageSize);
        roleDao.queryPageByDto(userWindowDto);
        return PageHelper.endPage();
    }

    @Override
    public int updateBatchStatus(String[] ids, String status) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        Map<String,Object> params = Maps.newHashMap();
        params.put("ids",ids);
        params.put("status",status);
        return roleDao.updateBatchStatus(params);
    }
}
