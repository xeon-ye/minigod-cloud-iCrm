package com.minigod.common.config;

import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @Title: OrderedProperties.java
 * @Description: 有序的读取配置文件
 * @Copyright:  2016 minigod
 * @Company: minigod
 *
 * @author
 * @date 2015-3-20 下午12:41:33
 * @version v1.0
 */

public class OrderSafeProperties extends Properties {
	private static final long serialVersionUID = -4627607243846121965L;
	private final LinkedHashSet<Object> keys = new LinkedHashSet<Object>();

	public Enumeration<Object> keys() {
		return Collections.<Object> enumeration(keys);
	}

	public Set<Object> keySet() {
		return keys;
	}

	public Object put(Object key, Object value) {
		keys.add(key);
		return super.put(key, value);
	}

	public Object remove(Object o) {
		keys.remove(o);
		return super.remove(o);
	}

	public void clear() {
		keys.clear();
		super.clear();
	}

	public void putAll(Map<? extends Object, ? extends Object> map) {
		keys.addAll(map.keySet());
		super.putAll(map);
	}

	public Set<Map.Entry<Object, Object>> entrySet() {
		Set<Map.Entry<Object, Object>> entrySet = new LinkedHashSet<Map.Entry<Object, Object>>(keys.size());
		for (Object key : keys) {
			entrySet.add(new Entry(key, get(key)));
		}
		return entrySet;
	}

	static class Entry implements Map.Entry<Object, Object> {
		private final Object key;
		private final Object value;

		private Entry(Object key, Object value) {
			this.key = key;
			this.value = value;
		}

		public Object getKey() {
			return key;
		}

		public Object getValue() {
			return value;
		}

		public Object setValue(Object o) {
			throw new IllegalStateException("not implemented.");
		}
	}
}
