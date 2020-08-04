package com.sunline.modules.marker.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.page.PageHelper;
import com.sunline.modules.common.utils.UserUtils;
import com.sunline.modules.marker.dao.CompBusiPersonDao;
import com.sunline.modules.marker.entity.CompBusiPersonEntity;
import com.sunline.modules.marker.enums.ComBusPerEnum;
import com.sunline.modules.marker.service.CompBusiPersonService;
import com.sunline.modules.sys.entity.UserEntity;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;



/**
 * 渠道信息表
 *
 * @author lcs
 * @email
 * @date 2018-04-25 09:31:43
 */
@Service("compBusiPersonService")
public class CompBusiPersonServiceImpl implements CompBusiPersonService {
    @Autowired
    private CompBusiPersonDao compBusiPersonDao;

    @Override
    public CompBusiPersonEntity queryObject(Integer id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return compBusiPersonDao.queryObject(id);
    }

    @Override
    public List<CompBusiPersonEntity> queryList(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return compBusiPersonDao.queryList(map);
    }

    @Override
    public List<CompBusiPersonEntity> queryListByBean(CompBusiPersonEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return compBusiPersonDao.queryListByBean(entity);
    }

    @Override
    public int queryTotal(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return compBusiPersonDao.queryTotal(map);
    }

    /**
     *   营销人员新增
     * @param compBusiPersonEntity
     * @return
     */
    @Override
    public int save(CompBusiPersonEntity compBusiPersonEntity){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        UserEntity currentUser = UserUtils.getCurrentUser();
        compBusiPersonEntity.setCreateUser(currentUser.getUserName());
        //生成6位数字字符的随机数
        String aeCode;
        int count;
        do{
            aeCode = RandomUtil.randomNumbers(6);
            count = compBusiPersonDao.getObjectByAeCode(aeCode);
        }while(count!=0);
        compBusiPersonEntity.setAeCode(aeCode);
        //新增经理人默认状态为正常  见证人默认状态为待审核
        if(ComBusPerEnum.PersonnelRole.PERSONNEL_ROLE_SYN.getIndex().equalsIgnoreCase(compBusiPersonEntity.getPersonnelRole())){
            compBusiPersonEntity.setPersonnelStatus(ComBusPerEnum.PersonnelStatus.PERSONNEL_STATUS_NOL.getIndex());
        }else
        if(ComBusPerEnum.PersonnelRole.PERSONNEL_ROLE_EYE.getIndex().equalsIgnoreCase(compBusiPersonEntity.getPersonnelRole())){
            compBusiPersonEntity.setPersonnelStatus(ComBusPerEnum.PersonnelStatus.PERSONNEL_STATUS_CEK.getIndex());
        }
        return compBusiPersonDao.save(compBusiPersonEntity);
    }

    /**
     * 修改
     * @param compBusiPersonEntity
     * @return
     */
    @Override
    public int update(CompBusiPersonEntity compBusiPersonEntity){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        UserEntity currentUser = UserUtils.getCurrentUser();
        compBusiPersonEntity.setModifyUser(currentUser.getUserName());
        return compBusiPersonDao.update(compBusiPersonEntity);
    }

    @Override
    public int delete(Integer id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return compBusiPersonDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[] ids){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return compBusiPersonDao.deleteBatch(ids);
    }

    /**
     * 分页查询
     * @param compBusiPersonEntity
     * @param pageNum
     * @return
     */
    @Override
    public Page<CompBusiPersonEntity> findPage(CompBusiPersonEntity compBusiPersonEntity, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        PageHelper.startPage(pageNum, Constant.pageSize);
        compBusiPersonDao.queryList(compBusiPersonEntity);
        return PageHelper.endPage();
    }


    /**
     *  营销人员管理导出excel
     * @param compBusiPersonEntity
     * @return
     */
    @Override
    public List<CompBusiPersonEntity> comBusPerListExcelList(CompBusiPersonEntity compBusiPersonEntity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return compBusiPersonDao.queryList(compBusiPersonEntity);
    }
}
