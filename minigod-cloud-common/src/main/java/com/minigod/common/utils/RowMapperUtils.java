package com.minigod.common.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RowMapperUtils {
	//缓存反射，以最大限度降低调用开销
	static final Map<Class<?>, Map<String, String>> mysqlFieldMap = new ConcurrentHashMap<Class<?>, Map<String, String>>();
	private static final Map<Class<?>, TypeEnum> TYPE_MAP = new ConcurrentHashMap<Class<?>, TypeEnum>();

	enum TypeEnum {
		Integer, Long, Float, Double, Boolean, String, Date, Object
	}

	static void init() {
		TYPE_MAP.put(Integer.class, TypeEnum.Integer);
		TYPE_MAP.put(Long.class, TypeEnum.Long);
		TYPE_MAP.put(Float.class, TypeEnum.Float);
		TYPE_MAP.put(Double.class, TypeEnum.Double);
		TYPE_MAP.put(Boolean.class, TypeEnum.Boolean);
		TYPE_MAP.put(String.class, TypeEnum.String);
		TYPE_MAP.put(Date.class, TypeEnum.Date);
		TYPE_MAP.put(Object.class, TypeEnum.Object);
	}

	static {
		init();
	}

	public static final <T> T map2Entity(Map<String, Object> map, Class<T> entityClass) {
		T t = null;
		try {
			Field[] fs = ReflectUtil.getFields(entityClass, true);
			t = entityClass.newInstance();

			//缓存javaType<-->mysqlType名称对应,如:userName<-->user_name
			if (mysqlFieldMap.get(entityClass) == null) {
				Map<String, String> fm = new HashMap<String, String>();
				for (Field f : fs) {
					String name = getMysqlStandField(f.getName());
					fm.put(f.getName(), name);
				}
				mysqlFieldMap.put(entityClass, fm);
			}

			for (Field f : fs) {
				f.setAccessible(true);
				String fieldName = f.getName();
				String key = mysqlFieldMap.get(entityClass).get(fieldName);
				if (key == null) {
					continue;
				}
				Object value = map.get(key);
				if (value == null) {
					value = map.get(fieldName);
				}
				f.set(t, getRealValue(f, value));
			}
		} catch (Exception e) {
			throw new RuntimeException("map2Entity", e);
		}
		return t;
	}

	private static final Object getRealValue(Field field, Object value) {
		if (value instanceof String) {
			return getValueByClass(field.getType(), value.toString());
		}
		if (value instanceof Number) {
			return getValueByClass(field.getType(), (Number) value);
		}
		if (value instanceof Date) {
			return (Date) value;
		}
		if (value instanceof Boolean) {
			return (Boolean) value;
		}
		return null;
	}

	private static final Object getValueByClass(Class<?> clazz, String value) {
		TypeEnum type = TYPE_MAP.get(clazz);
		switch (type) {
		case Integer:
			return Integer.parseInt(value);
		case Long:
			return Long.parseLong(value);
		case Float:
			return Float.parseFloat(value);
		case Double:
			return Double.parseDouble(value);
		case Boolean:
			return Boolean.parseBoolean(value);
		case String:
			return value;
		case Object:
			return value;
		default:
			break;
		}
		return null;
	}

	private static final Object getValueByClass(Class<?> clazz, Number value) {
		TypeEnum type = TYPE_MAP.get(clazz);
		switch (type) {
		case Integer:
			return value.intValue();
		case Long:
			return value.longValue();
		case Float:
			return value.floatValue();
		case Double:
			return value.doubleValue();
		case Boolean:
			return value.intValue() == 1;
		case String:
			return value.toString();
		case Object:
			return value;
		default:
			break;
		}
		return null;
	}

	public static final <T> List<T> map2List(List<Map<String, Object>> list, Class<T> entityClass) {
		List<T> nList = new ArrayList<T>();
		for (Map<String, Object> map : list) {
			nList.add(map2Entity(map, entityClass));
		}
		return nList;
	}

	/**
	 * 是否大写的英文字母
	 * @param value
	 * @return
	 */
	private static final boolean isUpperEnglishChar(char value) {
		return (value >= 'A' && value <= 'Z');
	}

	/**
	 * 是否是数字
	 * @param value
	 * @return
	 */
	private static final boolean isNumberChar(char value) {
		return (value >= '0' && value <= '9');
	}

	private static final String getMysqlStandField(String javaField) {
		char[] chars = javaField.toCharArray();
		int count = 0;
		//判断整个java属性是否都是大写
		int isUpperCase = 0;
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			//如果是数字
			if (isNumberChar(c)) {
				isUpperCase += 1;
			}
			//如果大写字母
			if (isUpperEnglishChar(c)) {
				isUpperCase += 1;
				count += 2;
			} else {
				count++;
			}
		}

		//如果全部是大写或者数字则返回和数据库一样的属性名称
		if (javaField.replace("_", "").length() == isUpperCase) {
			return javaField;
		}

		char[] dest = new char[count];
		int index = 0;
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			if (c >= 'A' && c <= 'Z') {
				count += 2;
				dest[index++] = '_';
				dest[index++] = (char) (c + 32);
			} else {
				dest[index++] = c;
			}
		}
		return new String(dest);
	}

	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", 32);
		map.put("name", "q32rfsd");
		Foo foo = map2Entity(map, Foo.class);
		foo = map2Entity(map, Foo.class);
		foo = map2Entity(map, Foo.class);
		foo = map2Entity(map, Foo.class);
		System.err.println(foo);
	}

	static class Foo {
		private Integer id;
		private String name;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String toString() {
			return "Foo [id=" + id + ", name=" + name + "]";
		}
	}
}
