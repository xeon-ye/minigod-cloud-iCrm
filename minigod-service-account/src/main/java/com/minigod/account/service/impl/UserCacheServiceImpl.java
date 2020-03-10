package com.minigod.account.service.impl;

import com.minigod.common.utils.DateUtils;
import com.minigod.common.bean.BaseBeanFactory;
import com.minigod.account.helper.RedisTokenManager;
import com.minigod.account.mapper.CustomSessionMapper;
import com.minigod.protocol.account.model.CustomSession;
import com.minigod.account.service.UserCacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Slf4j
@RestController
public class UserCacheServiceImpl extends BaseBeanFactory implements UserCacheService {
    @Autowired
    CustomSessionMapper customSessionMapper;

    @Autowired
    RedisTokenManager redisTokenManager;

    private static final Date SESSION_ERPIRE_TIME = DateUtils.stringToDate("9999-12-31 12:00:00");


    @Override
    public CustomSession saveCustomSession(Integer userId) {
        Date date = new Date();
        // 添加新会话
        CustomSession sessionInfo = new CustomSession();
        sessionInfo.setUserId(userId);
        sessionInfo.setDeviceId(-1);//未知
        sessionInfo.setToken("");
        sessionInfo.setIsStatus(true);
        sessionInfo.setExpireTime(SESSION_ERPIRE_TIME);
        sessionInfo.setCreateTime(date);
        sessionInfo.setUpdateTime(date);
        customSessionMapper.insertSelective(sessionInfo);

        // 生成永远不重复的Session
        sessionInfo.setToken(redisTokenManager.createToken(sessionInfo));

        // 更新数据库
        customSessionMapper.updateByPrimaryKeySelective(sessionInfo);

        return sessionInfo;
    }
}
