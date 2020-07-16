package com.sunline.modules.activiti.service.impl;

import com.google.common.collect.Maps;
import com.sunline.modules.activiti.annotation.ActField;
import com.sunline.modules.activiti.dao.ExtendActBusinessDao;
import com.sunline.modules.activiti.entity.ExtendActBusinessEntity;
import com.sunline.modules.activiti.service.ExtendActBusinessService;
import com.sunline.modules.activiti.utils.AnnotationUtils;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.exception.MyException;
import com.sunline.modules.common.utils.StringUtils;
import com.sunline.modules.common.utils.UserUtils;
import com.sunline.modules.common.utils.Utils;
import com.sunline.modules.sys.entity.UserEntity;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service("extendActBusinessService")
public class ExtendActBusinessServiceImpl implements ExtendActBusinessService {
	@Autowired
	private ExtendActBusinessDao extendActBusinessDao;
	
	@Override
	public ExtendActBusinessEntity queryObject(String id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
	    if(StringUtils.isEmpty(id)){
	        throw new MyException("节点id不能为空");
        }
		return extendActBusinessDao.queryObject(id);
	}
	
	@Override
	public List<ExtendActBusinessEntity> queryList(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return extendActBusinessDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return extendActBusinessDao.queryTotal(map);
	}

	@Override
	public int delete(String id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return extendActBusinessDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		extendActBusinessDao.deleteBatch(ids);
	}

	@Override
	public List<ExtendActBusinessEntity> queryListByBean(ExtendActBusinessEntity extendActBusinessEntity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        List<ExtendActBusinessEntity> busList = extendActBusinessDao.queryListByBean(extendActBusinessEntity);
        UserEntity currentUser = UserUtils.getCurrentUser();
        if(busList ==null || busList.size()<1){
            ExtendActBusinessEntity bus = new ExtendActBusinessEntity();
            bus.setId(Utils.uuid());
            bus.setName("业务树根目录");
            bus.setOpen("true");
            bus.setActKey("root");
            bus.setParentId(bus.getId());
            bus.setSort("1");
            bus.setType(Constant.ActBusType.ROOT.getValue());
            bus.setCreateTime(new Date());
            bus.setBaid(currentUser.getBaid());
            bus.setBapid(currentUser.getBapid());//未改
            bus.setCreateId(currentUser.getId());
            bus.setRemark("业务树初始化");
            int count = extendActBusinessDao.save(bus);
            if(count>0){
                busList.add(bus);
            }
        }
        return busList;
	}

    @Override
    public int edit(ExtendActBusinessEntity bus) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        UserEntity currentUser = UserUtils.getCurrentUser();
        bus.setBapid(currentUser.getBapid());
        bus.setBaid(currentUser.getBaid()); //未改
	    if(StringUtils.isEmpty(bus.getId())){
            //保存
            bus.setCreateTime(new Date());
            bus.setCreateId(currentUser.getId());
            bus.setId(Utils.uuid());
            return extendActBusinessDao.save(bus);
        }else {
	        //更新
            bus.setUpdateId(currentUser.getId());
            bus.setUpdateTime(new Date());
            return extendActBusinessDao.update(bus);
        }
    }

    @Override
    public List<ExtendActBusinessEntity> queryBusTree() {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return extendActBusinessDao.queryBusTree(Constant.ActBusType.GROUP.getValue(),Constant.ActBusType.BUS.getValue());
    }

    @Override
    public ExtendActBusinessEntity queryActBusByModelId(String modelId) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        ExtendActBusinessEntity businessEntity = extendActBusinessDao.queryActBusByModelId(modelId);
        //业务实体类
        String classurl = businessEntity.getClassurl();
        List<Map<String,Object>> writes=new ArrayList<Map<String,Object>>();//可写
        List<Map<String,Object>> judgs=new ArrayList<>();//可设置为条件
        Map<String,Object> temMap = Maps.newHashMap();
        temMap.put("value", "isAgree");
        temMap.put("name", "是否通过");
        judgs.add(temMap);
        //writes.add(temMap);
        List<Map<String, Object>> mapList = AnnotationUtils.getActFieldByClazz(classurl);
        for (Map remap:mapList){
            temMap = Maps.newHashMap();
            ActField actField= (ActField) remap.get("actField");
            String keyName = (String) remap.get("keyName");
            if(actField!=null){
                temMap.put("value", keyName);
                temMap.put("name", actField.name());
                writes.add(temMap);
                if(actField.isJudg()){
                    temMap.put("allow", actField.isJudg());
                    judgs.add(temMap);
                }
            }
        }
        businessEntity.setJudgs(judgs);
        businessEntity.setWrites(writes);
        return businessEntity;
    }

    @Override
    public List<Map<String,Object>> queryCalBackByPid(String parentId) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return extendActBusinessDao.queryCalBackByPid(parentId);
    }

    @Override
    public ExtendActBusinessEntity queryByActKey(String actKey) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return extendActBusinessDao.queryByActKey(actKey);
    }
}
