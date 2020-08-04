package com.sunline.modules.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisConnectionException;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @description: Redis工具类
 * @author: Larry Lai
 * @date: 2018/10/11 16:18
 * @version: v1.0
 */

@Component
public class RedisUtil {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JedisPool jedisPool;

    private Jedis getJedis() {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis;
        } catch (JedisConnectionException e) {
            logger.error("获取Redis异常", e);
            throw e;
        }
    }


    /**
     * 保存对象到Redis 对象不过期
     *
     * @param key    待缓存的key
     * @param object 待缓存的对象
     * @return 返回是否缓存成功
     */
    public boolean setObject(String key, Object object) throws Exception {
        return setObject(key, object, -1);
    }

    /**
     * 保存对象到Redis 并设置超时时间
     *
     * @param key     缓存key
     * @param object  缓存对象
     * @param timeout 超时时间
     * @return 返回是否缓存成功
     * @throws Exception 异常上抛
     */
    public boolean setObject(String key, Object object, int timeout) throws Exception {
        String value = SerializeUtil.serialize(object);
        boolean result = false;
        try {
            //为-1时不设置超时时间
            if (timeout != -1) {
                setString(key, value, timeout);
            } else {
                setString(key, value);
            }
            result = true;
        } catch (Exception e) {
            logger.error("保存对象到Redis异常", e);
        }
        return result;
    }


    /**
     * 从Redis中获取对象
     *
     * @param key 待获取数据的key
     * @return 返回key对应的对象
     */
    public Object getObject(String key) throws Exception {
        Object object = null;
        try {
            String serializeObj = getString(key);
            if (null == serializeObj || serializeObj.length() == 0) {
                object = null;
            } else {
                object = SerializeUtil.deserialize(serializeObj);
            }
        } catch (Exception e) {
            logger.error("从Redis中获取对象异常", e);
        }
        return object;
    }

    /**
     * 缓存String类型的数据,数据不过期
     *
     * @param key   待缓存数据的key
     * @param value 需要缓存的额数据
     * @return 返回是否缓存成功
     */
    public boolean setString(String key, String value) throws Exception {
        return setString(key, value, -1);
    }

    /**
     * 缓存String类型的数据并设置超时时间
     *
     * @param key     key
     * @param value   value
     * @param timeout 超时时间
     * @return 返回是否缓存成功
     */
    public boolean setString(String key, String value, int timeout) throws Exception {
        String result;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            result = jedis.set(key, value);
            if (timeout != -1) {
                jedis.expire(key, timeout);
            }
            if ("OK".equals(result)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            logger.error("缓存String类型的数据并设置超时时间异常", e);
        } finally {
            releaseRedis(jedis);
        }

        return false;
    }

    /**
     * 获取String类型的数据
     *
     * @param key 需要获取数据的key
     * @return 返回key对应的数据
     */
    @SuppressWarnings("deprecation")
    public String getString(String key) throws Exception {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            return jedis.get(key);
        } catch (Exception e) {
            logger.error("获取String类型的数据异常", e);
        } finally {
            releaseRedis(jedis);
        }

        return null;
    }

    /**
     * Jedis 对象释放
     *
     * @param jedis
     */
    private void releaseRedis(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }

    /**
     * 删除缓存中的数据
     *
     * @param key 需要删除数据的key
     * @return 返回是否删除成功
     */
    public boolean del(String key) throws Exception {
        Long num;
        Jedis jedis = null;
        boolean result = false;
        try {
            jedis = getJedis();
            num = jedis.del(key);
            if (num.equals(1L)) {
                result = true;
            }
        } catch (Exception e) {
            logger.error("删除缓存中的数据异常", e);
        } finally {
            releaseRedis(jedis);
        }
        return result;
    }

    /**
     * 缓存Map类型的数据，数据不过期
     *
     * @param key   待缓存数据的key
     * @param value 需要缓存的额数据
     * @return 返回是否缓存成功
     */
    public boolean setMap(String key, Map<String, String> value) throws Exception {
        return setMap(key, value, -1);
    }

    /**
     * 缓存Map类型的数据并设置超时时间
     *
     * @param key
     * @param value
     * @param timeout
     * @return
     * @throws Exception
     */
    private boolean setMap(String key, Map<String, String> value, int timeout) throws Exception {
        String result;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            result = jedis.hmset(key, value);
            if (timeout != -1) {
                jedis.expire(key, timeout);
            }
            return "OK".equals(result);
        } catch (Exception e) {
            logger.error("缓存Map类型的数据并设置超时时间异常", e);
        } finally {
            releaseRedis(jedis);
        }
        return false;
    }

    /**
     * 获取Map类型的键个数
     *
     * @param key
     * @return
     * @throws Exception
     */
    @SuppressWarnings("deprecation")
    public Long getMapKeyLen(String key) throws Exception {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            return jedis.hlen(key);
        } catch (Exception e) {
            logger.error("获取Map类型的值异常", e);
        } finally {
            releaseRedis(jedis);
        }

        return null;
    }

    /**
     * 获取Map类型的键
     *
     * @param key
     * @return
     * @throws Exception
     */
    @SuppressWarnings("deprecation")
    public Set<String> getMapKey(String key) throws Exception {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            return jedis.hkeys(key);
        } catch (Exception e) {
            logger.error("获取Map类型的值异常", e);
        } finally {
            releaseRedis(jedis);
        }

        return null;
    }

    /**
     * 获取Map类型的值
     *
     * @param key
     * @return
     * @throws Exception
     */
    @SuppressWarnings("deprecation")
    public List<String> getMapValue(String key) throws Exception {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            return jedis.hvals(key);
        } catch (Exception e) {
            logger.error("获取Map类型的值异常", e);
        } finally {
            releaseRedis(jedis);
        }

        return null;
    }

    /**
     * 添加一个集合对象
     *
     * @param key
     * @param value vlaue可以是一个string数组，也可以是单个字符串
     */
    void add(String key, String... value) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.lpush(key, value);
        } catch (Exception e) {
            logger.error("添加一个集合对象异常", e);
        } finally {
            releaseRedis(jedis);
        }
    }

    /**
     * 获取list
     *
     * @param key return :list<String>
     */
    List<String> getList(String key, int start, int end) {
        Jedis jedis = null;

        try {
            jedis = getJedis();
            return jedis.lrange(key, start, end);
        } catch (Exception e) {
            logger.error("获取list异常", e);
        } finally {
            releaseRedis(jedis);
        }

        return null;
    }

    /**
     * 更新
     *
     * @param key
     * @param index
     * @param value
     */
    void setValue(String key, int index, String value) {
        Jedis jedis = null;

        try {
            jedis = getJedis();
            jedis.lset(key, index, value);
        } catch (Exception e) {
            logger.error("更新Redis异常", e);
        } finally {
            releaseRedis(jedis);
        }
    }

    /**
     * 删除
     */
    void remValue(String key, int count, String value) {
        Jedis jedis = null;

        try {
            jedis = getJedis();
            jedis.lrem(key, count, value);
        } catch (Exception e) {
            logger.error("删除Redis值异常", e);
        } finally {
            releaseRedis(jedis);
        }
    }

    /**
     * 查看list的长度
     *
     * @param key return :long
     */
    Long getListSize(String key) {
        Jedis jedis = null;

        try {
            jedis = getJedis();
            return jedis.llen(key);
        } catch (Exception e) {
            logger.error("查看list的长度异常", e);
        } finally {
            releaseRedis(jedis);
        }

        return 0L;

    }

}
