//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.minigod.common.odps.service;

import com.minigod.common.exception.OdpsException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class SingleService {
    private static final Map<String, String> mapNames = new ConcurrentHashMap();

    @Autowired
    public StringRedisTemplate redisTemplate;

    public static final int DEFAULS_EXPIRE = 36000;

    public AtomicLong number = new AtomicLong(1L);

    public SingleService() {
    }

    public static <T extends Serializable> String getMapName(Class<T> clazz) {
        String name = clazz.getName();
        String mapName = (String)mapNames.get(name);
        if (StringUtils.isEmpty(mapName)) {
            mapName = getSimpleName(clazz.getSimpleName());
            mapNames.put(name, mapName);
        }
        return mapName;
    }

    private static final <T extends Serializable> String getSimpleName(String simpleName) {
        char[] chars = simpleName.toCharArray();
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < chars.length; ++i) {
            char c = chars[i];
            if (i > 0 && isUpperEnglishChar(c)) {
                sb.append("_").append(String.valueOf(c).toLowerCase());
            } else {
                sb.append(String.valueOf(c).toLowerCase());
            }
        }
        return new String(sb);
    }

    private static final boolean isUpperEnglishChar(char value) {
        return value >= 'A' && value <= 'Z';
    }

    public <T extends Serializable> Boolean exists(final Class<T> clazz, final Object... key) {
        if (clazz != null && key != null && key.length != 0) {
            return this.redisTemplate.hasKey(SingleService.getMapName(clazz) + ":" + key[0]);
        } else {
            throw new OdpsException("exists cache clazz and key is not null.");
        }
    }

    public <T extends Serializable> Long ttl(final Class<T> clazz, Object... key) {
        if (clazz == null) {
            throw new OdpsException("ttl cache clazz is not null.");
        } else {
            return this.redisTemplate.getExpire(SingleService.getMapName(clazz));
        }
    }

    public <T extends Serializable> Boolean uniquene(final Object value, final int... expTime) {
        if (value == null) {
            throw new OdpsException("uniquene value not null.");
        } else {
            String key = "uniquene:" + String.valueOf(value);
            Boolean uniquene = this.redisTemplate.hasKey(key);
            if (!uniquene.booleanValue()) {
                int seconds = 36000;
                if (expTime != null && expTime.length > 0) {
                    seconds = expTime[0];
                }
                this.redisTemplate.opsForValue().set(key, String.valueOf(value), seconds, TimeUnit.MINUTES);
            }
            return uniquene;
        }
    }

    public <T extends Serializable> String getSet(final Object key, final String value, final int... expTime) {
        if (value == null) {
            throw new OdpsException("getSet value not null.");
        } else {
            String _key = "gs:" + String.valueOf(key);
            int seconds = 36000;
            if (expTime != null && expTime.length > 0) {
                seconds = expTime[0];
            }
            String ret = this.redisTemplate.opsForValue().getAndSet(_key, value);
            this.redisTemplate.expire(_key, seconds, TimeUnit.SECONDS);
            return ret;
        }
    }

    public <T extends Serializable> Long incrBy(final String key, final long integer, final int... expTime) {
        if (key == null) {
            throw new OdpsException("incrBy cache key or integer is not null.");
        } else {
            if (expTime != null && expTime.length > 0) {
                long ret = this.redisTemplate.opsForValue().increment(key, integer);
                this.redisTemplate.expire(key, expTime[0], TimeUnit.SECONDS);
                return ret;
            } else {
                Long retx = this.redisTemplate.opsForValue().increment(key, integer);
                this.redisTemplate.persist(key);
                return retx;
            }
        }
    }

}
