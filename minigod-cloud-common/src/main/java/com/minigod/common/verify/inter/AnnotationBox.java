package com.minigod.common.verify.inter;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

public interface AnnotationBox {

	@SuppressWarnings("rawtypes")
	public static Map<Class<? extends Annotation>, AnnotationVerifier> verifyMap = new HashMap<Class<? extends Annotation>, AnnotationVerifier>();

	@SuppressWarnings("rawtypes")
	void addNewAnno(Class<? extends Annotation> clazz, Class<? extends AnnotationVerifier> verifyClazz);

	AnnotationVerifier<?> getAnno(Class<? extends Annotation> clazz);
}
