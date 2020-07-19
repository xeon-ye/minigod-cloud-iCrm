package com.sunline.modules.common.service;


import com.sunline.modules.common.entity.NationalPhoneAreaCodeEntity;

import java.util.List;

/**
 * 
 * 
 * @author lcs
 * @email
 * @date 2018-11-06 13:49:14
 */
public interface NationalPhoneAreaCodeService {

    List<NationalPhoneAreaCodeEntity> queryList(NationalPhoneAreaCodeEntity entity);

    int save(NationalPhoneAreaCodeEntity entity);

}
