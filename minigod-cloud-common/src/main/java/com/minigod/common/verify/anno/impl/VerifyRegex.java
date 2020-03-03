package com.minigod.common.verify.anno.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.minigod.common.ResponseResult;
import com.minigod.common.verify.inter.AnnotationVerifier;
import com.minigod.common.verify.anno.Regex;
import com.minigod.common.verify.exception.UnKnownVerifyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.minigod.common.verify.inter.impl.VerifyResultImpl;
import com.minigod.common.verify.utils.VerifyUtil;

/**
 * @Title: VerifyRegex.java
 * @Description: 
 * @Copyright:  2016 minigod
 * @Company: minigod
 *
 * @author
 * @date 2015-7-31 下午3:21:48
 * @version v1.0
 */

public class VerifyRegex implements AnnotationVerifier<Regex> {
	private static final Logger logger = LoggerFactory.getLogger(VerifyRegex.class);

	public ResponseResult doVerify(Object param, String paramName, Regex anno) throws UnKnownVerifyException {
		try {
			String _param = (String) param;
			if (VerifyUtil.isNull(_param)) {
				return VerifyResultImpl.DEFAULT_SUCCESS;
			}

			String regex = anno.regex();
			if (VerifyUtil.isNull(regex)) {
				logger.warn(String.format("[%s]正则表达式不能为空.", paramName));
				return new VerifyResultImpl(false, anno.code(), String.format("[%s]正则表达式不能为空.", paramName));
			}

			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(_param);
			if (!matcher.matches()) {
				logger.warn(String.format("[%s]%s.", paramName, anno.message()));
				return new VerifyResultImpl(false, anno.code(), String.format("[%s]%s.", paramName, anno.message()));
			}

			return VerifyResultImpl.DEFAULT_SUCCESS;
		} catch (Exception e) {
			logger.error("VerifyRegex参数检查异常.", e);
			throw new UnKnownVerifyException("未知的VerifyNumber异常.");
		}
	}
}
