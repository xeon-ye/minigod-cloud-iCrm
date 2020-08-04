package com.sunline.modules.notice.dao;

import com.sunline.modules.common.dao.BaseDao;
import com.sunline.modules.notice.entity.MessageSendInfoEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 消息发送日志
 *
 * @author LiYangFeng
 * @email justbelyf@gmail.com
 * @date 2018-03-22 19:20:59
 */
@Mapper
public interface MessageSendInfoDao extends BaseDao<MessageSendInfoEntity> {
    List<MessageSendInfoEntity> queryUnFinishedMessage();

}
