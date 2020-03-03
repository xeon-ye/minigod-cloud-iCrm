package com.minigod.common.verify.inter;

import java.lang.annotation.Annotation;

import com.minigod.common.ResponseResult;
import com.minigod.common.verify.exception.UnKnownVerifyException;

public interface AnnotationVerifier<Anno extends Annotation> {

	ResponseResult doVerify(Object paramValue, String paramName, Anno annotation) throws UnKnownVerifyException;
}