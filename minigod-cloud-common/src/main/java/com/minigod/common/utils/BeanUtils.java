package com.minigod.common.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import com.minigod.common.exception.MiniGodException;

public class BeanUtils {

	//数据支持的类型
	public static Object getRealVal(Class<?> clazz, String fromValue) {
		if (fromValue == null || "null".equals(fromValue)) {
			return null;
		} else if (clazz.equals(String.class)) {
			return fromValue;
		} else if (clazz.equals(int.class) || clazz.equals(Integer.class)) {
			return Integer.valueOf(fromValue);
		} else if (clazz.equals(long.class) || clazz.equals(Long.class)) {
			return Long.valueOf(fromValue);
		} else if (clazz.equals(float.class) || clazz.equals(Float.class)) {
			return Float.valueOf(fromValue);
		} else if (clazz.equals(double.class) || clazz.equals(Double.class)) {
			return Double.valueOf(fromValue);
		} else if (clazz.equals(boolean.class) || clazz.equals(Boolean.class)) {
			return Boolean.valueOf(fromValue);
		}
		return fromValue;
	}

	public final static String toString(Object obj) {
		if (obj == null) {
			return null;
		}
		return JSONUtil.toJson(obj);
	}

	/**
	 * 获取对象属性值
	 * @param obj
	 * @param col
	 * @return
	 */
	public final static Object getPropertie(Object obj, String col) {
		try {
			Field[] fs = ReflectUtil.getFields(obj.getClass(), true);
			for (Field f : fs) {
				f.setAccessible(true);
				if (Modifier.isPrivate(f.getModifiers()) && !Modifier.isStatic(f.getModifiers())) {
					if (f.getName().equals(col)) {
						return f.get(obj);
					}
				}
			}
		} catch (Exception e) {
			throw new MiniGodException(e);
		}
		return null;
	}

	/**
	 * 判断是否为空
	 * @param t
	 * @return
	 */
	public static <T> boolean isNull(T t) {
		if (t == null) {
			return false;
		} else {
			return true;
		}
	}
}
