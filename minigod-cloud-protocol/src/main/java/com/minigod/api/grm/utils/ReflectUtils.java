package com.minigod.api.grm.utils;

import org.apache.log4j.Logger;
import org.apache.poi.ss.formula.functions.T;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by CaiJianbo on 2016/4/25 16:15.
 * minigod
 */
public class ReflectUtils {

    private static Logger logger = Logger.getLogger(ReflectUtils.class);

    public static Method getGetMethod(Class clazz, Field field) {
        if (null != clazz && null != field) {
            String fieldName = field.getName();
            try {
                return clazz.getMethod("get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1));
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                logger.debug(e);
            }
        }
        return null;
    }

    public static Method getSetMethod(Class clazz, Field field) {
        if (null != clazz && null != field) {
            String fieldName = field.getName();
            try {
                return clazz.getMethod("set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1), field.getType());
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                logger.debug(e);
            }
        }
        return null;
    }

    public static Object getValue(Object o, Class typeClass) {
        if (null != o && typeClass != null) {
            if (typeClass.getName().equals("java.lang.String")) {
                return String.valueOf(o);
            }
        }
        return o;
    }

    public static <T extends Object> T copyFieldFromObj(T dstObj, Object srcObj) {
        if (null != dstObj && null != srcObj) {
            try {
                Class dstClazz = dstObj.getClass();
                Class srcClazz = srcObj.getClass();
                List<Field> dstFields = Arrays.asList(dstObj.getClass().getDeclaredFields());
                List<Field> srcFields = Arrays.asList(srcObj.getClass().getDeclaredFields());
                /*if (dstObj instanceof Serializable) {
                    dstFields.remove(dstObj.getClass().getField("serialVersionUID"));
                }
                if (srcObj instanceof Serializable) {
                    srcFields.remove(srcObj.getClass().getField("serialVersionUID"));
                }*/
                Map<String, Method> getMethods = new HashMap<>();
                Map<String, Method> setMethods = new HashMap<>();
                for (Field field : srcFields) {
                    if(!field.getName().equals("serialVersionUID")) {
                        getMethods.put(field.getName(), getGetMethod(srcClazz, field));
                    }
                }
                for (Field field : dstFields) {
                    if(!field.getName().equals("serialVersionUID")) {
                        setMethods.put(field.getName(), getSetMethod(dstClazz, field));
                    }
                }
                Set<String> keys = setMethods.keySet();
                Iterator<String> it = keys.iterator();
                String key;
                while (it.hasNext()) {
                    key = it.next();
                    if (getMethods.containsKey(key)) {
                        setMethods.get(key).invoke(dstObj, getMethods.get(key).invoke(srcObj));
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return dstObj;
    }
}
