package com.minigod.security.utils;

import com.minigod.common.exception.MiniGodException;
import com.minigod.common.utils.IdentitiesUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 用户系统公共 工具类
 */

public class UserUtil {
	// 日志对象
	private static final Logger logger = LoggerFactory.getLogger(UserUtil.class);

	//获取随机的Session+自增长ID,在分布式环境下也不会重复
	public static String getUUIDCode(Integer pkId) {
		return IdentitiesUtil.getUUID() + pkId;
	}

	//获取UserSession中缓存的key
	public static Integer getSessionId(String sessionCode) throws Exception {
		if (StringUtils.isNotEmpty(sessionCode) && sessionCode.length() > 32) {
			String sessionId = sessionCode.substring(32, sessionCode.length());
			return Integer.valueOf(sessionId);
		}
		return null;
	}
	
	//强制退出描述信息
	public static String getExitMsg(Date date, String deviceModel, String msg){
		if(StringUtils.isBlank(deviceModel)){
			deviceModel="其他";
		}
		return "您的帐号于"+new SimpleDateFormat("HH:mm").format(date)+"在"+deviceModel+msg;
	}

	public static byte[] getImageFromURL(String urlPath) {
		return getImageFromURL(urlPath, null, 0);
	}

	public static byte[] getImageFromURL(String urlPath, String host, int port) {
		byte[] data = null;
		InputStream is = null;
		HttpURLConnection conn = null;
		Integer length = 0;
		try {
			URL url = new URL(urlPath);
			if (host != null && port > 0) {
				Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(host, port));
				conn = (HttpURLConnection) url.openConnection(proxy);
			} else {
				conn = (HttpURLConnection) url.openConnection();
			}

			conn.setDoInput(true);
			conn.setRequestMethod("GET");
			conn.setConnectTimeout(60000);
			length = conn.getContentLength();
			is = conn.getInputStream();
			if (conn.getResponseCode() == 200) {
				data = readInputStream(is);
			} else {
				data = null;
			}
			conn.disconnect();
		} catch (Exception e) {
			throw new MiniGodException(e);
		} finally {
			Integer dataLength = data.length;
			if (length > 0 && !dataLength.equals(length)) {
				throw new MiniGodException("图片下载不完整." + urlPath);
			}
			if (is != null) {
				try {
					is.close();
				} catch (Exception e) {
					throw new MiniGodException(e);
				}
			}
		}
		return data;
	}

	public static byte[] readInputStream(InputStream is) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int length = -1;
		byte[] data = null;
		try {
			while ((length = is.read(buffer)) != -1) {
				baos.write(buffer, 0, length);
			}
			baos.flush();
			data = baos.toByteArray();
		} catch (Exception e) {
			throw new MiniGodException(e);
		} finally {
			try {
				if (is != null) {
					is.close();
				}
				if (baos != null) {
					baos.close();
				}
			} catch (Exception e) {
				throw new MiniGodException(e);
			}
		}
		return data;
	}
	
	/**
	 * 返回n位数字验证码
	 * 
	 * @return n位数字验证码
	 */
	public static String generateCaptcha(int iDigit) {
		if (iDigit <= 0) {
			return null;
		}
		String chars = "0123456789";
		char[] rands = new char[iDigit];
		for (int i = 0; i <= (iDigit - 1); i++) {
			int rand = (int) (Math.random() * 10);
			rands[i] = chars.charAt(rand);
		}
		return String.valueOf(rands);
	}

}
