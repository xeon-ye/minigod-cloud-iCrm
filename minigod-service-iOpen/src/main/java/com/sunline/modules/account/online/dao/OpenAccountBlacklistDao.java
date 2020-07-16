package com.sunline.modules.account.online.dao;


import com.sunline.modules.account.online.entity.OpenAccountBlacklistEntity;
import com.sunline.modules.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 黑名单信息表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-10-11 12:19:54
 */
@Mapper
public interface OpenAccountBlacklistDao extends BaseDao<OpenAccountBlacklistEntity> {
    /**
     * 校验黑名单
     * @param idKind
     * @param idCard
     * @return
     */
    OpenAccountBlacklistEntity isExistedBlacklist(OpenAccountBlacklistEntity entity);
}
