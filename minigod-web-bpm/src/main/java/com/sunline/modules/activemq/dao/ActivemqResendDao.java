package com.sunline.modules.activemq.dao;

import com.sunline.modules.activemq.entity.ActivemqResendEntity;
import com.sunline.modules.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * activemq消息推送失败列表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2019-07-08 09:12:37
 */
@Mapper
public interface ActivemqResendDao extends BaseDao<ActivemqResendEntity> {
	
}
