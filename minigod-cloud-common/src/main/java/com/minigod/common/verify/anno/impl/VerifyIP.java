package com.minigod.common.verify.anno.impl;

import com.minigod.common.ResponseResult;
import com.minigod.common.verify.anno.IP;
import com.minigod.common.verify.inter.AnnotationVerifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.minigod.common.verify.exception.UnKnownVerifyException;
import com.minigod.common.verify.inter.impl.VerifyResultImpl;
import com.minigod.common.verify.utils.VerifyUtil;

public class VerifyIP implements AnnotationVerifier<IP> {
	private static final Logger logger = LoggerFactory.getLogger(VerifyIP.class);

	public ResponseResult doVerify(Object paramValue, String paramName, IP anno) throws UnKnownVerifyException {
		try {
			String ip = (String) paramValue;
			if (VerifyUtil.isNull(ip)) {
				return VerifyResultImpl.DEFAULT_SUCCESS;
			}
			if (!VerifyUtil.isIP(ip)) {
				logger.debug(String.format("[%s]%s.", paramName, anno.message()));
				return new VerifyResultImpl(false, anno.code(), anno.message());
			}
			return VerifyResultImpl.DEFAULT_SUCCESS;
		} catch (Exception e) {
			logger.error("未知的VerifyIP异常.", e);
			throw new UnKnownVerifyException("未知的VerifyIP异常.");
		}
	}
}