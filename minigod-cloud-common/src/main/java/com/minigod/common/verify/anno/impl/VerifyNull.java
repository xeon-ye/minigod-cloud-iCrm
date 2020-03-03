package com.minigod.common.verify.anno.impl;

import com.minigod.common.ResponseResult;
import com.minigod.common.verify.anno.NotNull;
import com.minigod.common.verify.inter.AnnotationVerifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.minigod.common.verify.inter.impl.VerifyResultImpl;

public class VerifyNull implements AnnotationVerifier<NotNull> {
	private static final Logger logger = LoggerFactory.getLogger(VerifyNull.class);

	public ResponseResult doVerify(Object param, String paramName, NotNull anno) {
		if (param == null || "".equals(param)) {
			logger.warn(String.format("[%s]%s.", paramName, anno.message()));
			return new VerifyResultImpl(false, anno.code(), String.format("[%s]%s.", paramName, anno.message()));
		}
		return VerifyResultImpl.DEFAULT_SUCCESS;
	}
}