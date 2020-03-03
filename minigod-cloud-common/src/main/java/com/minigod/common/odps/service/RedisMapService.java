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
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

@Service
public class RedisMapService extends SingleService {
    public RedisMapService() {
    }

    public <T extends Serializable> T findObject(final Class<T> clazz, final Object key) {
        if (clazz != null && key != null) {
            Object cacheJson = this.redisTemplate.opsForHash().get(SingleService.getMapName(clazz), String.valueOf(key));
            T t = null;
            if (cacheJson != null) {
                t = JSONUtil.fromJson(cacheJson.toString(), clazz);
            }
            return t;
        } else {
            throw new OdpsException("findObject cache clazz and key is not null.");
        }
    }

    public <T extends Serializable> Map<String, T> findAllObject(final Class<T> clazz) {
        if (clazz == null) {
            throw new OdpsException("findAllObject cache clazz is not null.");
        } else {
            Map<Object, Object> cacheMap = this.redisTemplate.opsForHash().entries(SingleService.getMapName(clazz));
            Map<String, T> resMap = new HashMap();
            Iterator ite = cacheMap.entrySet().iterator();

            while(ite.hasNext()) {
                Entry<String, String> en = (Entry)ite.next();
                resMap.put(en.getKey(), JSONUtil.fromJson((String)en.getValue(), clazz));
            }
            return resMap;
        }
    }

    public <T extends Serializable> List<T> findListObject(final Class<T> clazz, final String... keys) {
        if (clazz != null && keys != null && keys.length != 0) {
            List<Object> list = this.redisTemplate.opsForHash().multiGet(SingleService.getMapName(clazz), Arrays.asList(keys));
            List<T> ts = new ArrayList();
            for(Object object : list){
                String json = (String)object;
                ts.add(JSONUtil.fromJson(json, clazz));
            }
            return ts;
        } else {
            throw new OdpsException("findListObject cache clazz and keys is not null.");
        }
    }

    public final <T extends Serializable> Long saveUpdateWriteClass(final T obj, final Object key, final int... expTime) {
        if (key != null && obj != null) {
            String mapName = SingleService.getMapName(obj.getClass());
            String mapKey = String.valueOf(key);
            String mapValue = JSONUtil.toJson(obj, new SerializerFeature[]{SerializerFeature.WriteClassName});
            Long set;
            if (expTime != null && expTime.length > 0) {
                this.redisTemplate.opsForHash().put(mapName, String.valueOf(mapKey), mapValue);
                this.redisTemplate.expire(mapName, expTime[0], TimeUnit.SECONDS);
                return null;
            } else {
                this.redisTemplate.opsForHash().put(mapName, String.valueOf(mapKey), mapValue);
                this.redisTemplate.persist(mapName);
                return null;
            }
        } else {
            throw new OdpsException("saveUpdateWriteClass cache key and cache is not null.");
        }
    }

    public final <T extends Serializable> Long saveUpdate(final T obj, final Object key, final int... expTime) {
        if (key != null && obj != null) {
            String mapName = SingleService.getMapName(obj.getClass());
            String mapKey = String.valueOf(key);
            String mapValue = JSONUtil.toJson(obj, new SerializerFeature[0]);
            this.redisTemplate.opsForHash().put(mapName, String.valueOf(mapKey), mapValue);
            if (expTime != null && expTime.length > 0) {
                this.redisTemplate.expire(mapName, expTime[0], TimeUnit.SECONDS);
            } else {
                this.redisTemplate.persist(mapName);
            }
            return null;
        } else {
            throw new OdpsException("saveUpdate cache key and cache is not null");
        }
    }

    public <T extends Serializable> List<Object> saveUpdateBatchWriteClass(final Class<T> clazz, final List<Pair> pairs, final int... expTime) {
        return this.saveUpdateBatch(clazz, pairs, expTime);
    }

    public <T extends Serializable> List<Object> saveUpdateBatch(final Class<T> clazz, final List<Pair> pairs, final int... expTime) {
        if (clazz != null && pairs != null && pairs.size() != 0) {
            final String mapName = SingleService.getMapName(clazz);
            return this.redisTemplate.executePipelined(new RedisCallback<Object>() {
                @Override
                public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                    try {
                        redisConnection.openPipeline();
                        for (Pair pair : pairs) {
                            byte[] kByte = mapName.getBytes();
                            byte[] mapKeyByte = String.valueOf(pair.getKey()).getBytes();
                            byte[] mapValueByte = JSONUtil.toJson(pair.getValue(), new SerializerFeature[]{SerializerFeature.WriteClassName}).getBytes();;
                            redisConnection.hSet(kByte, mapKeyByte, mapValueByte);
                            if(expTime[0]>0){
                                redisConnection.expire(kByte, expTime[0]);
                            }else{
                                redisConnection.persist(kByte);
                            }
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
            return this.redisTemplate.opsForHash().delete(SingleService.getMapName(clazz), new String[]{String.valueOf(key)});
        } else {
            throw new OdpsException("delete cache clazz and key is not null.");
        }
    }

    public <T extends Serializable> Long delete(final Class<T> clazz) {
        if (clazz == null) {
            throw new OdpsException("delete cache clazz is not null.");
        } else {
           return this.redisTemplate.opsForHash().delete(SingleService.getMapName(clazz));
        }
    }

    public <T extends Serializable> Long del(final String key) {
        if (key == null) {
            throw new OdpsException("del cache key is not null.");
        } else {
            return this.redisTemplate.opsForHash().delete(key);
        }
    }
}
