package com.sunline.modules.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @author PENGFENG
 * @decription ORC识别工具类
 * @date 2017-07-24
 * 
 * @version
 *
 */
public class OCRUtils {
	private static final Logger logger = LoggerFactory.getLogger(OCRUtils.class);

	public static Map<String,Object> ocr(String filePath) {
		Map<String,Object> map = Maps.newHashMap();
		try {
//			String serverUrl = Global.getConfig("ocr.url");
			String serverUrl = "http://10.1.2.53:9008/platform_api/ocr_card";
			URL url = new URL(filePath);
			//String host = url.getHost();
			String path = url.getPath();
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("path" , path);
			Map<String,Object> paramsMap = Maps.newHashMap();
			paramsMap.put("params" , jsonObject);
			String result = HttpClientUtils.postJson(serverUrl, JSONObject.toJSONString(paramsMap));
			String code = JSONObject.parseObject(result).get("code").toString();
			if (code.equals("5000")) {
				String resultInfo = JSONObject.parseObject(result).get("result").toString();
				JSONObject obj = JSONObject.parseObject(resultInfo);
				result = obj.getString("result");
				obj = JSONObject.parseObject(result).getJSONObject("info");
				String name = obj.getString("name");
				String address = obj.getString("address");
				String number = obj.getString("number");
				String sex = obj.getString("sex");
				String year = obj.getString("year");
				String month = obj.getString("month");
				String day = obj.getString("day");

				map.put("name" , name);
				map.put("address" , address);
				map.put("number" , number);
				map.put("sex" , sex);
				map.put("year" , year);
				map.put("month" , month);
				map.put("day" , day);
			}else {
				return null;
			}
		}catch (Exception e) {
			logger.error("ocr 识别异常" , e);
		}
		return map;
	}

	public static void main(String[] args) throws Exception {
		String url  = "http://10.1.2.53:8000/platform/2017/07/28/1577d92c11da40c4ac9fa3c8f0636fb9__960x1280.jpg";
		URL u = new URL(url);
		System.out.println(u.getHost());
		System.out.println(u.getPath());

		ocr(url);
	}
}
