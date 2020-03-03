package com.minigod.common.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.minigod.common.exception.MiniGodException;

public class EntityUtils {

	private static boolean isEmpty(Collection<?> collection) {
		return (collection == null || collection.isEmpty());
	}

	public static List<Object> getOneFieldValues(Collection<?> entitys, String fieldName) {
		List<Object> values = new ArrayList<Object>();
		try {
			if (!isEmpty(entitys)) {
				for (Object object : entitys) {
					Class<?> c = object.getClass();
					Field field = c.getDeclaredField(fieldName);
					field.setAccessible(true);
					values.add(field.get(object));
				}
			}
		} catch (Exception e) {
			try {
				for (Object object : entitys) {
					Class<?> c = object.getClass().getSuperclass();
					Field field = c.getDeclaredField(fieldName);
					field.setAccessible(true);
					values.add(field.get(object));
				}
			} catch (Exception e2) {
				throw new MiniGodException("getOneFieldValues.", e2);
			}
		}
		return values;
	}

	@SuppressWarnings("unchecked")
	public static <T> List<T> getOneFieldValues(Collection<?> entitys, String fieldName, Class<T> clazz) {
		List<T> values = new ArrayList<T>();
		try {
			if (!isEmpty(entitys)) {
				for (Object object : entitys) {
					Class<?> c = object.getClass();
					Field field = c.getDeclaredField(fieldName);
					field.setAccessible(true);
					values.add((T) field.get(object));
				}
			}
		} catch (Exception e) {
			try {
				for (Object object : entitys) {
					Class<?> c = object.getClass().getSuperclass();
					Field field = c.getDeclaredField(fieldName);
					field.setAccessible(true);
					values.add((T) field.get(object));
				}
			} catch (Exception e2) {
				throw new MiniGodException("getOneFieldValues.", e2);
			}
		}
		return values;
	}

	public static <T> Map<Object, T> getField2EntityMap(List<T> entitys, String fieldName) {
		Map<Object, T> map = new HashMap<Object, T>();
		try {
			if (!isEmpty(entitys)) {
				for (T object : entitys) {
					Class<?> c = object.getClass();
					Field field = c.getDeclaredField(fieldName);
					field.setAccessible(true);
					map.put(field.get(object), object);
				}
			}
		} catch (Exception e) {
			try {
				for (T object : entitys) {
					Class<?> c = object.getClass().getSuperclass();
					Field field = c.getDeclaredField(fieldName);
					field.setAccessible(true);
					map.put(field.get(object), object);
				}
			} catch (Exception e2) {
				throw new MiniGodException("getOneFieldValues.", e2);
			}
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public static <T, T2> Map<T2, T> getField2EntityMap(List<T> entitys, String fieldName, Class<T2> clazz) {
		Map<T2, T> map = new HashMap<T2, T>();
		try {
			if (!isEmpty(entitys)) {
				for (T object : entitys) {
					Class<?> c = object.getClass();
					Field field = c.getDeclaredField(fieldName);
					field.setAccessible(true);
					map.put((T2) field.get(object), object);
				}
			}
		} catch (Exception e) {
			try {
				for (T object : entitys) {
					Class<?> c = object.getClass().getSuperclass();
					Field field = c.getDeclaredField(fieldName);
					field.setAccessible(true);
					map.put((T2) field.get(object), object);
				}
			} catch (Exception e2) {
				throw new MiniGodException("getOneFieldValues.", e2);
			}
		}
		return map;
	}

	public static Map<String, String> entity2Map(Object obj) {
		Map<String, String> map = new HashMap<String, String>();
		// 获取f对象对应类中的所有属性域  
		Field[] fields = ReflectUtil.getFields(obj.getClass(), true);
		for (Field field : fields) {
			String varName = field.getName();
			try {
				// 获取原来的访问控制权限  
				boolean accessFlag = field.isAccessible();
				// 修改访问控制权限  
				field.setAccessible(true);
				// 获取在对象f中属性fields[i]对应的对象中的变量  
				Object o = field.get(obj);
				if (o != null) {
					map.put(varName, o.toString());
				}
				// 恢复访问控制权限  
				field.setAccessible(accessFlag);
			} catch (Exception e) {
				throw new MiniGodException("entity2Map.", e);
			}
		}
		return map;
	}
}
