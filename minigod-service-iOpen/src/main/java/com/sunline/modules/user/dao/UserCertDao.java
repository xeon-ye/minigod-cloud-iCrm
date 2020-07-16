package com.sunline.modules.user.dao;

import com.sunline.modules.user.entity.UserCertEntity;
import com.sunline.modules.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户登录凭证表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2019-03-22 13:26:40
 */
@Mapper
public interface UserCertDao extends BaseDao<UserCertEntity> {
    UserCertEntity queryObject(UserCertEntity entity);
}
