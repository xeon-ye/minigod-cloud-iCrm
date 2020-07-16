package com.sunline.modules.sys.service.impl;

import com.sunline.modules.common.utils.UserUtils;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.utils.Utils;
import com.sunline.modules.sys.dao.MenuDao;
import com.sunline.modules.sys.entity.MenuEntity;
import com.sunline.modules.sys.entity.UserEntity;
import com.sunline.modules.sys.service.MenuService;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Service("menuService")
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuDao menuDao;

	@Override
	public MenuEntity queryObject(String id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return menuDao.queryObject(id);
	}

	@Override
	public List<MenuEntity> queryList(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return menuDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return menuDao.queryTotal(map);
	}

	@Override
	public String save(MenuEntity menu){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        UserEntity currentUser = UserUtils.getCurrentUser();
        menu.setId(Utils.uuid());
        menu.setCreateId(currentUser.getId());
        menu.setStatus(Constant.YESNO.NO.getValue());
        menu.setCreateTime(new Date());
        menu.setBapid(currentUser.getBapid());
        menu.setBaid(currentUser.getBaid());
        menuDao.save(menu);
        return menu.getId();
	}

	@Override
	public void update(MenuEntity menu){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        UserEntity currentUser = UserUtils.getCurrentUser();
        menu.setUpdateTime(new Date());
        menu.setUpdateId(currentUser.getId());
        menuDao.update(menu);
	}

	@Override
	public void delete(String id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		menuDao.delete(id);
	}

	@Override
	public void deleteBatch(String[] ids){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		menuDao.deleteBatch(ids);
	}

	@Override
	public List<MenuEntity> queryByUserId(String userId) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        List<MenuEntity> menuEntities = menuDao.queryByUserId(userId);
        for (int i=0;i<menuEntities.size();i++){
            MenuEntity menu = menuEntities.get(i);
            if(menu == null || null == menu.getId()){
                menuEntities.remove(i);
            }
        }
		return menuEntities;
	}
	@Override
	public List<MenuEntity> queryListParentId(String parenId) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return menuDao.queryListParentId(parenId);
	}
	@Override
	public List<MenuEntity> queryListUser(String userId) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        List<MenuEntity> menuEntities=null;
	    if(userId.equals(Constant.SUPERR_USER)){
            menuEntities = menuDao.queryList(new HashedMap());
        }else {
            menuEntities = menuDao.queryByUserId(userId);
        }
        List<String> menuIds = new ArrayList<>();
        for (MenuEntity menu:menuEntities){
            if(menu != null && null != menu.getId()){
                menuIds.add(menu.getId());
            }
        }
        //查询出根菜单
        List<MenuEntity> rootMenus = queryMenuByParentId("0", menuIds);
        //递归查询出所有子资源的子资源
        List<MenuEntity> treeMenus = getTreeMenus(rootMenus, menuIds);
        return treeMenus;
	}

    /**
     * 根据上级父id，查询出下级所有该用户已授权资源
     * @param parentId 父id
     * @param menuIds 授权资源ids
     * @return
     */
	public List<MenuEntity> queryMenuByParentId(String parentId, List<String> menuIds){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
	    //根据父Id,查询所有下级资源
        List<MenuEntity> menuEntities = menuDao.queryListParentId(parentId);
        List<MenuEntity> reMenus= new ArrayList<>();
        for (MenuEntity menu:menuEntities){
            //如果下级资源在用户授权资源中,则添加
            if(menuIds.contains(menu.getId())){
                reMenus.add(menu);
            }
        }
        return reMenus;
    }

    /**
     * 递归查询出所有菜单的子菜单，子菜单的所有子菜单 只包括用户授权的资源
     * @param resouces 源菜单
     * @param menuIds 用户所有授权资源
     * @return
     */
    public List<MenuEntity> getTreeMenus(List<MenuEntity> resouces, List<String> menuIds){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        List<MenuEntity> treeMenus = new ArrayList<>();
        for (MenuEntity menu:resouces){
            if(Constant.MenuType.CATALOG.getValue().equals(menu.getType())){
                List<MenuEntity> childMenus = queryMenuByParentId(menu.getId(), menuIds);
                menu.setList(getTreeMenus(childMenus, menuIds));
            }
            treeMenus.add(menu);
        }
        return treeMenus;
    }

	@Override
	public List<MenuEntity> queryNotButtonnList() {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        List<MenuEntity> menuList = menuDao.queryNotButtonnList(new String[]{Constant.MenuType.CATALOG.getValue(), Constant.MenuType.MENU.getValue()});
        return menuList;
	}
}
