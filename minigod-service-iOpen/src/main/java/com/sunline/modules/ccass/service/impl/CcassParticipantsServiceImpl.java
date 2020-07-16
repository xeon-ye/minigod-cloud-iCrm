package com.sunline.modules.ccass.service.impl;

import com.sunline.modules.ccass.dao.CcassParticipantsDao;
import com.sunline.modules.ccass.entity.CcassParticipantsEntity;
import com.sunline.modules.ccass.service.CcassParticipantsService;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.page.PageHelper;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * CCASS
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-05-17 16:05:58
 */


@Service("ccassParticipantsService")
public class CcassParticipantsServiceImpl implements CcassParticipantsService {
    @Autowired
    private CcassParticipantsDao ccassParticipantsDao;

    @Override
    public CcassParticipantsEntity queryObject(CcassParticipantsEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        return ccassParticipantsDao.queryObject(entity);
    }

    @Override
    public List<CcassParticipantsEntity> queryList(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        return ccassParticipantsDao.queryList(map);
    }

    @Override
    public List<CcassParticipantsEntity> queryListByBean(CcassParticipantsEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        return ccassParticipantsDao.queryListByBean(entity);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        return ccassParticipantsDao.queryTotal(map);
    }

    @Override
    public int save(CcassParticipantsEntity ccassParticipants) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return ccassParticipantsDao.save(ccassParticipants);
    }

    @Override
    public int saveBatch(List<CcassParticipantsEntity> ccassParticipantsEntityList) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return ccassParticipantsDao.saveBatch(ccassParticipantsEntityList);
    }

    @Override
    public int update(CcassParticipantsEntity ccassParticipants) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return ccassParticipantsDao.update(ccassParticipants);
    }

    @Override
    public int delete(Integer id) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return ccassParticipantsDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return ccassParticipantsDao.deleteBatch(ids);
    }

    /**
     * 获取CCASS参与者信息列表
     * @param ccassParticipantsEntity
     * @param pageNum
     * @return
     */
    @Override
    public Page<CcassParticipantsEntity> findPage(CcassParticipantsEntity ccassParticipantsEntity, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        PageHelper.startPage(pageNum, Constant.pageSize);
        ccassParticipantsDao.queryList(ccassParticipantsEntity);
        return PageHelper.endPage();
    }

    /**
     * CCASS参与者信息列表导出列表
     * @param ccassParticipantsEntity
     * @return
     */
    @Override
    public List<CcassParticipantsEntity> findCcassParticiInfoExcelList(CcassParticipantsEntity ccassParticipantsEntity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        List<CcassParticipantsEntity> ccassParticipantsList=ccassParticipantsDao.queryList(ccassParticipantsEntity);
        return ccassParticipantsList;
    }

}
