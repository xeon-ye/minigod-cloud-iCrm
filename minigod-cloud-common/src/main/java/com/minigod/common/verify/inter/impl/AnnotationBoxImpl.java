package com.minigod.common.verify.inter.impl;

import java.lang.annotation.Annotation;

import com.minigod.common.verify.inter.AnnotationBox;
import com.minigod.common.verify.inter.AnnotationVerifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AnnotationBoxImpl implements AnnotationBox {
	
	private static Logger logger = LoggerFactory.getLogger(AnnotationBoxImpl.class);

	@SuppressWarnings("rawtypes")
	public void addNewAnno(Class<? extends Annotation> annoclazz, Class<? extends AnnotationVerifier> annoVerifyClazz) {
		try {
			verifyMap.put(annoclazz, annoVerifyClazz.newInstance());
		} catch (Exception e) {
			logger.error("AnnotationBoxImpl handler.", e);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public AnnotationVerifier getAnno(Class<? extends Annotation> annoclazz) {
		return verifyMap.get(annoclazz);
	}
}