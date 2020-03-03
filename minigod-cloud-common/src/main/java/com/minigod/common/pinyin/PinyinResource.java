package com.minigod.common.pinyin;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

/**
 * 资源文件加载类
 */

public class PinyinResource {

	private static Properties getResource(String resourceName) {
		InputStream is = PinyinResource.class.getResourceAsStream(resourceName);
		Properties props = new Properties();
		try {
			props.load(is);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return props;
	}

	protected static Properties getPinyinTable() {
		String resourceName = "/data/pinyin.db";
		return getResource(resourceName);
	}

	protected static Properties getMutilPintinTable() {
		String resourceName = "/data/mutil_pinyin.db";
		for (Map.Entry<Object, Object> en : getResource(resourceName).entrySet()) {
			String key = (String) en.getKey();
			String val = (String) en.getValue();
			System.err.println(key + "===" + val);
		}

		return getResource(resourceName);
	}

	protected static Properties getChineseTable() {
		String resourceName = "/data/chinese.db";
		return getResource(resourceName);
	}
}
