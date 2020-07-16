package com.sunline.modules.common.service.impl;

import com.sunline.modules.common.dao.NationalPhoneAreaCodeDao;
import com.sunline.modules.common.entity.NationalPhoneAreaCodeEntity;
import com.sunline.modules.common.service.NationalPhoneAreaCodeService;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 
 *
 * @author lcs
 * @email
 * @date 2018-11-06 13:49:14
 */

@Service("nationalPhoneAreaCodeService")
public class NationalPhoneAreaCodeServiceImpl implements NationalPhoneAreaCodeService {
    @Autowired
    private NationalPhoneAreaCodeDao nationalPhoneAreaCodeDao;

    @Override
    public int save(NationalPhoneAreaCodeEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return nationalPhoneAreaCodeDao.save(entity);
    }

    @Override
    public List<NationalPhoneAreaCodeEntity> queryList(NationalPhoneAreaCodeEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return nationalPhoneAreaCodeDao.queryList(entity);
    }
}
