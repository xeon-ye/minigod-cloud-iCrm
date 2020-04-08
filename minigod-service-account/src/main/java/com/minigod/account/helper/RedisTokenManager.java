package com.minigod.account.helper;


import com.minigod.common.odps.service.RedisMapService;
import com.minigod.common.utils.DateUtils;
import com.minigod.protocol.account.model.CustomDevice;
import com.minigod.protocol.account.model.CustomSession;
import com.minigod.account.utils.UserUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 通过 Redis 存储和验证 token 的实现类
 *
 * @author ScienJus
 * @date 2015/7/31.
 */
@Service
@Slf4j
public class RedisTokenManager {
    @Autowired
    public RedisMapService redisMapService;

    private static final Date SESSION_ERPIRE_TIME = DateUtils.stringToDate("9999-12-31 12:00:00");

    public String createToken(CustomSession customSession) {
        String token = UserUtil.getUUIDCode(customSession.getId());
        Date expireTime = customSession.getExpireTime();
        try {
            int expire = 0;
            if (!expireTime.equals(SESSION_ERPIRE_TIME)) {
                expire = (int) DateUtils.getTimeDiff(expireTime, new Date());
            }
            if (expire != 0) {
                redisMapService.saveUpdate(customSession, token, expire);
            } else {
                redisMapService.saveUpdate(customSession, token);
            }
        } catch (Exception e) {
            log.error("redis更新session异常", e);
        }
        return token;
    }

    public void expireToken(String token) {
        CustomSession customSession = redisMapService.findObject(CustomSession.class, token);
        if (customSession != null) {
            customSession.setIsStatus(false);
            redisMapService.saveUpdate(customSession, token);
        }
    }

    public Integer getUserId(String token) {
        try {
            if (StringUtils.isBlank(token)) {
                return null;
            }

            CustomSession customSession = redisMapService.findObject(CustomSession.class, token);

            if (customSession == null || !customSession.getIsStatus() || DateUtils.isBeforeNow(customSession.getExpireTime())) {
                return null;
            }

            return customSession.getUserId();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean checkToken(String userToken) {

        CustomSession customSession = redisMapService.findObject(CustomSession.class, userToken);

        if (customSession == null || !customSession.getIsStatus() || DateUtils.isBeforeNow(customSession.getExpireTime())) {
            return false;
        }

        return true;
    }

}