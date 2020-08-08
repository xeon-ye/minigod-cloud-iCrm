package com.sunline.modules.account.online.service.impl;

import com.sunline.modules.account.online.dao.AyersClientAccDao;
import com.sunline.modules.account.online.dao.AyersClientInfoDao;
import com.sunline.modules.account.online.entity.AyersClientAccEntity;
import com.sunline.modules.account.online.entity.AyersClientInfoEntity;
import com.sunline.modules.account.online.service.AyersAccOpenService;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ayersAccOpenService")
public class AyersAccOpenServiceImpl implements AyersAccOpenService {

    @Autowired
    private AyersClientAccDao clientAccDao;

    @Autowired
    private AyersClientInfoDao clientInfoDao;

    @Override
    public int saveClientInfo(AyersClientInfoEntity infoEntity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SUNLINE);
        return clientInfoDao.save(infoEntity);
    }

    @Override
    public int saveClineAcc(AyersClientAccEntity accEntity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SUNLINE);
        return clientAccDao.save(accEntity);
    }
}
