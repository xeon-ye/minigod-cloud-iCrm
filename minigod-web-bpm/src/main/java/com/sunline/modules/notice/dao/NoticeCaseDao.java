package com.sunline.modules.notice.dao;

import com.sunline.modules.notice.entity.NoticeCaseEntity;
import com.sunline.modules.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author lcs
 * @email ${email}
 * @date 2018-12-11 10:28:38
 */
@Mapper
public interface NoticeCaseDao extends BaseDao<NoticeCaseEntity> {
    NoticeCaseEntity queryByCode(String noticeCaseCode);
}
