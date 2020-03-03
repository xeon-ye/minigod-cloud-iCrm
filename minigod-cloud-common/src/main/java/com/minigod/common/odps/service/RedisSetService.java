//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.minigod.common.odps.service;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.minigod.common.exception.OdpsException;
import com.minigod.common.utils.JSONUtil;
import com.minigod.common.odps.po.Pair;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
public class RedisSetService extends SingleService {
    public RedisSetService() {
    }

    public <T extends Serializable> T findObject(final Class<T> clazz, final Object key) {
        if (clazz != null && key != null) {
            String cacheJson = this.redisTemplate.opsForValue().get(SingleService.getMapName(clazz) + ":" + key);
            T t = null;
            if (cacheJson != null) {
                t = JSONUtil.fromJson(cacheJson, clazz);
            }
            return t;
        } else {
            throw new OdpsException("findObject cache clazz and key is not null.");
        }
    }

    public <T extends Serializable> Map<String, T> findAllObject(Class<T> clazz) {
        throw new OdpsException("findAllObject not support.");
    }

    public <T extends Serializable> List<T> findListObject(Class<T> clazz, String... keys) {
        throw new OdpsException("findListObject not support.");
    }

    public <T extends Serializable> Long sadd(final String key, final String... members) {
        if (key != null && members != null) {
            return this.redisTemplate.opsForSet().add(key, members);
        } else {
            throw new OdpsException("sadd cache key or members is not null.");
        }
    }

    public <T extends Serializable> Long srem(final String key, final String... members) {
        if (key != null && members != null) {
            return this.redisTemplate.opsForSet().remove(key, members);
        } else {
            throw new OdpsException("srem cache key or members is not null.");
        }
    }

    public <T extends Serializable> Set<String> findALL(final String key) {
        if (key == null) {
            throw new OdpsException("findALL cache key is not null.");
        } else {
            return this.redisTemplate.opsForSet().members(key);
        }
    }

    public <T extends Serializable> Set<String> findALLByLike(final String key) {
        if (key == null) {
            throw new OdpsException("findALLByLike cache  key is not null.");
        } else {
            return (Set) this.redisTemplate.opsForHash().keys(key);
        }
    }

    public <T extends Serializable> String saveUpdate(final T obj, final Object key, final int... expTime) {
        if (obj != null && key != null) {
            int seconds = 36000;
            if (expTime != null && expTime.length > 0) {
                seconds = expTime[0];
            }
            String k = SingleService.getMapName(obj.getClass()) + ":" + key;
            String v = JSONUtil.toJson(obj, new SerializerFeature[0]);
            this.redisTemplate.opsForValue().set(k, v, seconds, TimeUnit.MINUTES);
            return null;
        } else {
            throw new OdpsException("saveUpdate cache clazz and key is not null.");
        }
    }

    public <T extends Serializable> List<Object> saveUpdateBatch(final Class<T> clazz, final List<Pair> pairs, final int... expTime) {
        if (clazz != null && pairs != null) {
            return this.redisTemplate.executePipelined(new RedisCallback<Object>() {
                @Override
                public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                    try {
                        redisConnection.openPipeline();
                        for (Pair pair : pairs) {
                            byte[] kByte = (SingleService.getMapName(clazz) + ":" + pair.getKey()).getBytes();
                            byte[] vByte = JSONUtil.toJson(pair.getValue(), new SerializerFeature[0]).getBytes();
                            redisConnection.setEx(kByte, expTime[0], vByte);
                        }
                    } finally {
                        redisConnection.closePipeline();
                    }
                    return null;
                }
            });
        } else {
            throw new OdpsException("saveUpdateBatch class and pairs is not null.");
        }
    }

    public <T extends Serializable> Long delete(final Class<T> clazz, final Object key) {
        if (clazz != null && key != null) {
            this.redisTemplate.delete(SingleService.getMapName(clazz) + ":" + key);
            return null;
        } else {
            throw new OdpsException("delete cache clazz and key is not null.");
        }
    }

    public <T extends Serializable> Long delete(final Class<T> clazz) {
        if (clazz == null) {
            throw new OdpsException("delete cache clazz is not null.");
        } else {
            Set<String> keys = this.redisTemplate.keys(SingleService.getMapName(clazz) + "*");
            this.redisTemplate.delete(keys);
            return Long.valueOf(keys.size());
        }
    }

    public <T extends Serializable> Long del(final String key) {
        if (key == null) {
            throw new OdpsException("del cache key is not null.");
        } else {
            this.redisTemplate.delete(key);
            return null;
        }
    }

    public <T extends Serializable> Long dels(final String[] keys) {
        if (keys != null && keys.length != 0) {
            this.redisTemplate.delete(Arrays.asList(keys));
            return Long.valueOf(keys.length);
        } else {
            throw new OdpsException("dels cache key is not null.");
        }
    }
}
