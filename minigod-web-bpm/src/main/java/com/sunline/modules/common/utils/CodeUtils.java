package com.sunline.modules.common.utils;


import com.google.common.collect.Lists;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.sys.entity.CodeEntity;
import com.sunline.modules.sys.service.CodeService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;
import java.util.Map;

/**
 * 类的功能描述.
 * 数据字典工具类
 *
 * @Auther hxy
 * @Date 2017/7/25
 */

public class CodeUtils {

    private static final Log logger = LogFactory.getLog(CodeUtils.class);

    private static CodeService codeService = SpringContextUtils.getBean(CodeService.class);

    public static RedisUtil buildRedisUtils() {
        return (RedisUtil) SpringContextUtils.getBean("redisUtil");
    }


    /**
     * 根据字典标识获取字典名称
     *
     * @param value
     * @return
     */
    public static String getCodeName(String preName, String value) {
        String name = "";
//        Map<String,Map<String,Object>> allMap = CodeCache.get(Constant.CODE_CACHE);
        Map<String, Map<String, Object>> allMap = null;
        try {
            allMap = (Map<String, Map<String, Object>>) buildRedisUtils().getObject(Constant.CODE_CACHE);
        } catch (Exception e) {
            logger.error("获取字典名称异常", e);
        }
        // 首先从redis中取，没有再去数据库查询
        if (allMap != null && allMap.size() > 0) {
            Map<String, Object> markMap = allMap.get(preName + "_" + value);
            if (markMap != null && markMap.size() > 0) {
                name = (String) markMap.get("name");
                return name;
            }
        }
        // 缓存中没有数据,数据库中查询
        CodeEntity codeEntity = codeService.queryByMark(preName + "_" + value);
        if (codeEntity != null) {
            name = codeEntity.getName();
        }

        logger.warn("Redis缓存数据找不到[" + preName + "_" + value + "]对应值，从数据库中读取返回");
        return name;
    }

    /**
     * 根据字典标识获取字典码值
     *
     * @param preName
     * @param value
     * @return
     */
    public static String getCodeValue(String preName, String value) {
        String key = "";
//        Map<String,Map<String,Object>> allMap = CodeCache.get(Constant.CODE_CACHE);
        Map<String, Map<String, Object>> allMap = null;
        try {
            allMap = (Map<String, Map<String, Object>>) buildRedisUtils().getObject(Constant.CODE_CACHE);
        } catch (Exception e) {
            logger.error("获取字典码值", e);
        }
        // 首先从redis中取，没有再去数据库查询
        if (allMap != null && allMap.size() > 0) {
            Map<String, Object> markMap = allMap.get(preName + "_" + value);
            if (markMap != null && markMap.size() > 0) {
                key = (String) markMap.get("value");
                return key;
            }
        }
        // 缓存中没有数据，数据库中查询
        CodeEntity codeEntity = codeService.queryByMark(preName + "_" + value);
        if (codeEntity != null) {
            key = codeEntity.getValue();
        }

        logger.warn("Redis缓存数据找不到[" + preName + "_" + value + "]对应值，从数据库中读取返回");
        return key;
    }

    /**
     * 根据父节点字典标识获取子字典
     *
     * @param parentMark
     * @return
     */
    public static List<CodeEntity> getCodeInfoByParentMark(String parentMark) {
//        String name ="";
////        Map<String,Map<String,Object>> allMap = CodeCache.get(Constant.CODE_CACHE);
//        Map<String,Map<String,Object>> allMap = null;
//        try {
//            allMap = (Map<String, Map<String, Object>>) buildRedisUtils().getObject(Constant.CODE_CACHE);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        //首先从redis中取，没有再去数据库查询
//        if(allMap != null && allMap.size()>0){
//            Map<String,Object> markMap = allMap.get(preName+"_"+value);
//            if(markMap !=null && markMap.size()>0){
//                name =(String) markMap.get("name");
//                return name;
//            }
//        }
        // 缓存中没有数据,数据库中查询
        List<CodeEntity> codeEntity = codeService.queryChildsByMark(parentMark);
        if (codeEntity != null) {
            return codeEntity;
        }
        logger.warn("Redis缓存数据找不到[" + parentMark + "]对应值，从数据库中读取返回");
        return Lists.newArrayList();
    }

    private static String buildCodeKey(String key) {
        return Constant.CODE_CACHE + ":" + key;
    }
}
