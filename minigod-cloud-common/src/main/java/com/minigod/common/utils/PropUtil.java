package com.minigod.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.minigod.common.config.OrderSafeProperties;

/**
 * 属性文件加载类
 */
public class PropUtil {

	private static Map<String, OrderSafeProperties> propMap = new ConcurrentHashMap<String, OrderSafeProperties>();

	/**
	 * 加载属性文件
	 * @param propFile 属性文件路径（相对classes根目录）
	 * @return
	 */
	public static final OrderSafeProperties loadProperty(String propFile) {
		InputStream input = null;
		try {
			input = Thread.currentThread().getContextClassLoader().getResourceAsStream(propFile);
			OrderSafeProperties prop = new OrderSafeProperties();
			prop.load(input);
			return prop;
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (input != null) {
					input.close();
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	/**
	 * 根据文件名，返回属性配置对象
	 * @param propFile 属性文件路径（相对classes根目录）
	 * @return
	 */
	public static final OrderSafeProperties getProperties(String propFile) {
		OrderSafeProperties prop = propMap.get(propFile);
		if (prop == null) {
			prop = loadProperty(propFile);
			propMap.put(propFile, prop);
		}
		return prop;
	}

	/**
	 * @param propFile 属性文件路径（相对classes根目录）
	 * @param key	属性KEY
	 * @param reloadFile 是否重新读取文件（<b>reloadFile=false</b>时，会利用缓存，只加载一次配置文件,<b>reloadFile=true</b>时，每次都重新打开配置文件）
	 * @return
	 */
	public static final String getProp(String propFile, String key, boolean... reloadFile) {
		OrderSafeProperties prop = null;
		if (reloadFile.length > 0 && reloadFile[0]) {
			prop = loadProperty(propFile);
			return prop.getProperty(key);
		}
		prop = propMap.get(propFile);
		if (prop == null) {
			prop = loadProperty(propFile);
			propMap.put(propFile, prop);
		}
		return prop.getProperty(key);
	}
}
