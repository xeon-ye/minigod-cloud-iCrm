package com.minigod.common.verify.anno.impl;

import com.minigod.common.ResponseResult;
import com.minigod.common.verify.anno.Date;
import com.minigod.common.verify.inter.AnnotationVerifier;
import com.minigod.common.verify.inter.impl.VerifyResultImpl;
import com.minigod.common.verify.utils.VerifyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.minigod.common.verify.exception.UnKnownVerifyException;

public class VerifyDate implements AnnotationVerifier<Date> {
	private static final Logger logger = LoggerFactory.getLogger(VerifyDate.class);

	public ResponseResult doVerify(Object paramValue, String paramName, Date anno) throws UnKnownVerifyException {
		try {
			String date = (String) paramValue;
			if (VerifyUtil.isNull(date)) {
				return VerifyResultImpl.DEFAULT_SUCCESS;
			}
			java.util.Date d = VerifyUtil.fromatDate(date, anno.format());
			if (d == null) {
				logger.warn(String.format("[%s]%s.", paramName, anno.message()));
				return new VerifyResultImpl(false, anno.code(), String.format("[%s]%s.", paramName, anno.message()));
			}
			return VerifyResultImpl.DEFAULT_SUCCESS;
		} catch (Exception e) {
			logger.error("未知的VerifyDate异常.", e);
			throw new UnKnownVerifyException("未知的VerifyDate异常.");
		}
	}
}