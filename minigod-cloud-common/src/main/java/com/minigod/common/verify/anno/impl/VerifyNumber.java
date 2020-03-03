package com.minigod.common.verify.anno.impl;

import com.minigod.common.ResponseResult;
import com.minigod.common.verify.anno.Number;
import com.minigod.common.verify.inter.AnnotationVerifier;
import com.minigod.common.verify.inter.impl.VerifyResultImpl;
import com.minigod.common.verify.utils.VerifyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.minigod.common.verify.exception.UnKnownVerifyException;

public class VerifyNumber implements AnnotationVerifier<Number> {
	private static final Logger logger = LoggerFactory.getLogger(VerifyNumber.class);

	public ResponseResult doVerify(Object param, String paramName, Number anno) throws UnKnownVerifyException {
		try {
			String num = String.valueOf(param);
			if (VerifyUtil.isNull(num)) {
				return VerifyResultImpl.DEFAULT_SUCCESS;
			}
			if (!VerifyUtil.isNumber(num)) {
				logger.warn(String.format("[%s]非数字.", paramName));
				return new VerifyResultImpl(false, anno.code(), String.format("[%s]非数字.", paramName));
			}

			Long _num = Long.valueOf(num);
			if (_num > anno.maxValue()) {
				logger.warn(String.format("[%s]不能超过最大值%s.", paramName, anno.maxValue()));
				return new VerifyResultImpl(false, anno.code(), String.format("[%s]不能超过最大值%s.", paramName, anno.maxValue()));
			}

			if (_num < anno.minValue()) {
				logger.warn(String.format("[%s]不能小于最小值%s.", paramName, anno.minValue()));
				return new VerifyResultImpl(false, anno.code(), String.format("[%s]不能小于最小值%s.", paramName, anno.minValue()));
			}

			return VerifyResultImpl.DEFAULT_SUCCESS;
		} catch (Exception e) {
			logger.error("VerifyNumber参数检查异常.", e);
			throw new UnKnownVerifyException("未知的VerifyNumber异常.");
		}
	}
}
