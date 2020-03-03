package com.minigod.common.verify.anno.impl;

import com.minigod.common.ResponseResult;
import com.minigod.common.verify.anno.Email;
import com.minigod.common.verify.inter.AnnotationVerifier;
import com.minigod.common.verify.inter.impl.VerifyResultImpl;
import com.minigod.common.verify.utils.VerifyUtil;
import com.minigod.common.verify.exception.UnKnownVerifyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VerifyEmail implements AnnotationVerifier<Email> {
	private static final Logger logger = LoggerFactory.getLogger(VerifyEmail.class);

	public ResponseResult doVerify(Object paramValue, String paramName, Email anno) throws UnKnownVerifyException {
		try {
			String email = (String) paramValue;
			if (VerifyUtil.isNull(email)) {
				return VerifyResultImpl.DEFAULT_SUCCESS;
			}
			if (!VerifyUtil.isEmail(email)) {
				logger.warn(String.format("[%s]%s", paramName, anno.message()));
				return new VerifyResultImpl(false, anno.code(), String.format("[%s]%s", paramName, anno.message()));
			}
			return VerifyResultImpl.DEFAULT_SUCCESS;
		} catch (Exception e) {
			logger.error("VerifyEmail异常.", e);
			throw new UnKnownVerifyException("未知的VerifyEmail异常.");
		}
	}
}