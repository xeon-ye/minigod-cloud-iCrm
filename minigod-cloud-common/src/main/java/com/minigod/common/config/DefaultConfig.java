package com.minigod.common.config;

import com.minigod.common.config.supers.SuperInfo;
import com.minigod.common.exception.MiniGodException;
import com.minigod.common.security.AESUtil;
import com.minigod.common.utils.HttpClientUtils;
import com.minigod.common.utils.JSONUtil;
import com.minigod.common.utils.PropUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 读取本地properties配置
 */

public class DefaultConfig {
    private static final Logger logger = LoggerFactory.getLogger(DefaultConfig.class);

    //应用的ID
    private String appId;
    //应用的配置文件的名称
    private String fileName;

    //属性的
    private static Map<String, String> configMap = new LinkedHashMap<String, String>();

    private OrderSafeProperties properties;

    //是否开启远程
    private static boolean fromRemote = false;

    public void showConf() {
        for (Map.Entry<String, String> en : configMap.entrySet()) {
            logger.info(">>>>>>" + en.getKey() + "=" + en.getValue());
        }
    }

    public DefaultConfig() {
    }

    public DefaultConfig(String appId) {
        this.appId = appId;
        init();
    }

    //初始化配置
    public void init() {
        if (appId == null) {
            throw new RuntimeException("no appId found!");
        }
        try {
            properties = getBootConfig();
            if (properties != null) {
                fromRemote = Boolean.valueOf((String) properties.get("server.remote"));
            }
            //获取远程配置
            if (fromRemote) {
                String remoteUrl = (String) properties.get("server.remote.url");
                if (StringUtils.isBlank(remoteUrl)) {
                    throw new MiniGodException("boot.cfg config 'server.remote.url' is handler.");
                }
                try {

                    String keys = getAppId() + getAppId();
                    if (keys.length() > 16) {
                        keys = keys.substring(0, 16);
                    }

                    //先将本地配置加载到远程服务器
                    boolean isRemote = loadConfig(remoteUrl, keys);
                    if (!isRemote) {
                        throw new MiniGodException("加载本地属性到配置中心异常.");
                    }

                    String url = remoteUrl + "/superConfig/getConfig/?appId=" + getAppId();
                    String configStr = getRemoteMaps(url);
                    configStr = configStr.replaceAll("\\s*", "");

                    //加载远程配置异常
                    if (StringUtils.isEmpty(configStr) || configStr.indexOf("ApacheTomcat") > -1) {
                        //如果无法获取远程配置,则异常
                        throw new MiniGodException("获取配置中心属性异常.");
                    }
                    //加载远程文件
                    else {
                        //解密配置中心加密数据
                        configStr = AESUtil.decrypt(configStr, keys);
                        List<SuperInfo> supers = JSONUtil.getList(configStr, SuperInfo.class);
                        //必须先清空
                        configMap = new LinkedHashMap<String, String>();
                        for (SuperInfo en : supers) {
                            String key = en.getKey();
                            String val = en.getMd5();
                            boolean encryption = en.isEncryption();
                            if (encryption) {
                                logger.debug(">>>>>>>>>>>>>from remote.[" + en.getNote() + ":" + key + "=******]");
                            } else {
                                logger.debug(">>>>>>>>>>>>>from remote.[" + key + "=" + val + "]");
                            }
                            configMap.put(key, val);
                        }
                    }
                } catch (Exception e) {
                    //如果无法获取远程配置,则直接获取本地配置
                    logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                    throw new MiniGodException("获取远程配置中心属性异常.", e);
                }
            }
            //获取本地配置
            if (!fromRemote) {
                loadProperties();
            }
        } catch (Exception e) {
            logger.error("init handler.", e);
            System.exit(1);
        }
    }

    private boolean loadConfig(String remoteUrl, String keys) {
        //加载本地配置
        loadProperties();

        String configStr = JSONUtil.toJson(configMap);

        LinkedHashMap<String, String> maps = new LinkedHashMap<String, String>();
        //加密
        maps.put("configs", AESUtil.encrypt(configStr, keys));

        String loadUrl = remoteUrl + "/superConfig/loadConfig/?appId=" + getAppId();
        //提交到远端
        String ret = HttpClientUtils.post(loadUrl, maps);

        String conf = ret.replaceAll("\\s*", "");

        logger.info(">>>>>>>>>>>>>load configuration from db.[" + loadUrl + "]>>>>>>>>>>>>>");

        conf = ret.replaceAll("\\s*", "");
        if (StringUtils.isEmpty(conf) || conf.indexOf("ApacheTomcat") > -1) {
            logger.error("===put config handler.");
            //加载远程错误,加载本地
            return false;
        } else {
            Map<?, ?> map = JSONUtil.fromJson(ret, Map.class);
            if (map != null && map.size() > 0) {
                boolean bol = (Boolean) map.get("success");
                if (!bol) {
                    logger.info("put config handler.");
                    //加载本地
                    return false;
                } else {
                    logger.info("put config success.");
                    return true;
                }
            } else {
                //加载远程错误,加载本地
                logger.error("===put config handler.");
                return false;
            }
        }
    }

    private String getRemoteMaps(String remoteUrl) {
        logger.info(">>>>>>>>>>>>>get configuration from remote.[" + remoteUrl + "]>>>>>>>>>>>>>");
        return HttpClientUtils.get(remoteUrl, Charset.forName("UTF-8"));
    }

    //加载本地配置属性
    private void loadProperties() {
        logger.info(">>>>>>>>>>>>>loading config from local.[" + fileName + "]>>>>>>>>>>>>>");
        String[] fileNames = fileName.split(";");
        for (String fileName : fileNames) {
            properties = PropUtil.getProperties(fileName);
            for (Map.Entry<Object, Object> en : properties.entrySet()) {
                String key = (String) en.getKey();
                String val = (String) en.getValue();
                synchronized (key) {
                    configMap.put(key, val);
                }
            }
            logger.info(">>>>>>>>>>>>>get configuration from local.[" + fileName + "]>>>>>>>>>>>>>");
        }
        if (configMap == null || configMap.size() == 0) {
            throw new RuntimeException("no propertie found in configuration.");
        }
    }

    public void put(String key, Object value) {
        properties.put(key, value);
    }

    public OrderSafeProperties getBootConfig() {
        try {
            return PropUtil.getProperties("boot.cfg");
        } catch (Exception e) {
            return null;
        }
    }

    public Map<String, String> getVal() {
        return configMap;
    }

    public String getVal(String key) {
        String value = configMap.get(key);
        if (value == null) {
            throw new RuntimeException((!fromRemote) ? ("from local" + " no propertie [" + key + "] found in configuration.") : ("from remote" + " no propertie [" + key + "] found in configuration."));
        }
        return value;
    }

    public Integer getInt(String key) {
        String value = getVal(key);
        return Integer.parseInt(value);
    }

    public Long getLong(String key) {
        String value = getVal(key);
        return Long.parseLong(value);
    }

    public Float getFloat(String key) {
        String value = getVal(key);
        return Float.parseFloat(value);
    }

    public Double getDouble(String key) {
        String value = getVal(key);
        return Double.parseDouble(value);
    }

    public Boolean getBoolean(String key) {
        String value = getVal(key);
        return Boolean.parseBoolean(value);
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}