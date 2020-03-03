package com.minigod.common.verify.anno.impl;

import com.minigod.common.ResponseResult;
import com.minigod.common.verify.inter.AnnotationVerifier;
import com.minigod.common.verify.utils.VerifyUtil;
import com.minigod.common.verify.anno.Mob;
import com.minigod.common.verify.exception.UnKnownVerifyException;
import com.minigod.common.verify.inter.impl.VerifyResultImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VerifyMob implements AnnotationVerifier<Mob> {
	private static final Logger logger = LoggerFactory.getLogger(VerifyMob.class);

	public ResponseResult doVerify(Object paramValue, String paramName, Mob anno) throws UnKnownVerifyException {
		try {
			String mob = (String) paramValue;
			if (VerifyUtil.isNull(mob)) {
				return VerifyResultImpl.DEFAULT_SUCCESS;
			}
			if (!VerifyUtil.isMobNO(mob)) {
				logger.warn(String.format("[%s]%s", paramName, anno.message()));
				return new VerifyResultImpl(false, anno.code(), String.format("[%s]%s", paramName, anno.message()));
			}
			return VerifyResultImpl.DEFAULT_SUCCESS;
		}catch (Exception e) {
			logger.error("未知的VerifyMob异常.", e);
			throw new UnKnownVerifyException("未知的VerifyMob异常.");
		}
	}
}