package com.minigod.common.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

public class ReflectUtil {

	// 缓存反射,以最大限度降低调用开销
	private static final Map<String, Field[]> fieldMap = new ConcurrentHashMap<String, Field[]>();

	public static final <T> Field[] getFields(Class<T> entityClass, boolean isSuperclass) {
		String key = entityClass.getName() + isSuperclass;
		Field[] fs = fieldMap.get(key);
		if (fs == null) {
			fs = getClassFields(entityClass, isSuperclass);
			// 缓存反射方法getDeclaredFields的调用结果
			fieldMap.put(key, fs);
		}
		return fs;
	}

	/**
	 * 获取给定对象的所有属性,包括2层父类属性,子类属性覆盖父类属性
	 * @param value
	 * @return
	 */
	private static final Field[] getClassFields(Class<?> entityClass, boolean isSuperclass) {
		Map<String, Field> map = new ConcurrentHashMap<String, Field>();
		Field[] fs = entityClass.getDeclaredFields();
		for (Field p : fs) {
			if (Modifier.isFinal(p.getModifiers()) || Modifier.isStatic(p.getModifiers())) {
				continue;
			}
			map.put(p.getName(), p);
		}
		if (isSuperclass) {
			// 如果是继承关系的话,把父类的属性也加进来,目前只支持2层父类
			Class<?> pClass = entityClass.getSuperclass();
			if (pClass != null && pClass != Object.class) {
				Field[] pfs = pClass.getDeclaredFields();
				for (Field p : pfs) {
					if (Modifier.isFinal(p.getModifiers()) || Modifier.isStatic(p.getModifiers())) {
						continue;
					}
					//抛弃父类的属性值
					String keyName = p.getName();
					if (map.get(keyName) == null) {
						map.put(p.getName(), p);
					}
				}
				pClass = pClass.getSuperclass();
				if (pClass != null && pClass != Object.class) {
					pfs = pClass.getDeclaredFields();
					for (Field p : pfs) {
						if (Modifier.isFinal(p.getModifiers()) || Modifier.isStatic(p.getModifiers())) {
							continue;
						}
						//抛弃父类的属性值
						String keyName = p.getName();
						if (map.get(keyName) == null) {
							map.put(p.getName(), p);
						}
					}
				}
			}
		}
		return map.values().toArray(new Field[map.size()]);
	}

	public static final Map<String, Field> getFieldMap(Class<?> entityClass) {
		Field[] fs = getFields(entityClass, true);
		Map<String, Field> map = new HashMap<String, Field>();
		for (Field f : fs) {
			map.put(f.getName(), f);
		}
		return map;
	}

	private Class<? extends Object> cls;

	/**
	 * 传过来的对象
	 */
	private Object obj;

	/**
	 * 存放get方法
	 */
	private Hashtable<String, Method> getMethods = null;

	/**
	 * 存放set方法
	 */
	private Hashtable<String, Method> setMethods = null;

	/**
	 * 定义构造方法 -- 一般来说是个pojo
	 * @param o 目标对象
	 */
	public ReflectUtil(Object o) {
		obj = o;
		initMethods();
	}

	/**
	 * @desc 初始化
	 */
	public void initMethods() {
		getMethods = new Hashtable<String, Method>();
		setMethods = new Hashtable<String, Method>();
		cls = obj.getClass();
		Method[] methods = cls.getMethods();
		// 定义正则表达式,从方法中过滤出getter / setter 函数.
		String gs = "get(\\w+)";
		Pattern getM = Pattern.compile(gs);
		String ss = "set(\\w+)";
		Pattern setM = Pattern.compile(ss);
		// 把方法中的"set" 或者 "get" 去掉
		String rapl = "$1";
		String param;
		for (int i = 0; i < methods.length; ++i) {
			Method m = methods[i];
			String methodName = m.getName();
			if (Pattern.matches(gs, methodName)) {
				param = getM.matcher(methodName).replaceAll(rapl).toLowerCase();
				getMethods.put(param, m);
			} else if (Pattern.matches(ss, methodName)) {
				param = setM.matcher(methodName).replaceAll(rapl).toLowerCase();
				setMethods.put(param, m);
			}
		}
	}

	/**
	 * @desc 调用set方法
	 */
	public boolean setMethodValue(String property, Object object) {
		Method m = setMethods.get(property.toLowerCase());
		if (m != null) {
			try {
				// 调用目标类的setter函数
				m.invoke(obj, object);
				return true;
			} catch (Exception ex) {
				System.out.println("invoke getter on " + property + " handler: " + ex.toString());
				return false;
			}
		}
		return false;
	}

	/**
	 *调用get方法
	 */
	public Object getMethodValue(String property) {
		Object value = null;
		Method m = getMethods.get(property.toLowerCase());
		if (m != null) {
			try {
				/**
				 * 调用obj类的setter函数
				 */
				value = m.invoke(obj, new Object[] {});

			} catch (Exception ex) {
				System.out.println("invoke getter on " + property + " handler: " + ex.toString());
			}
		}
		return value;
	}
}
