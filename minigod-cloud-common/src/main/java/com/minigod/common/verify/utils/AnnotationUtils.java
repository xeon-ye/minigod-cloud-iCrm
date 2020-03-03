package com.minigod.common.verify.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

public class AnnotationUtils {

	public static Map<String, Object> getAnnotationAttributes(Annotation annotation) {
		return getAnnotationAttributes(annotation, false, false);
	}

	public static Map<String, Object> getAnnotationAttributes(Annotation annotation, boolean classValuesAsString) {
		return getAnnotationAttributes(annotation, classValuesAsString, false);
	}

	public static LinkedHashMap<String, Object> getAnnotationAttributes(Annotation annotation, boolean classValuesAsString, boolean nestedAnnotationsAsMap) {
		LinkedHashMap<String, Object> attrs = new LinkedHashMap<String, Object>();
		Method[] methods = annotation.annotationType().getDeclaredMethods();
		for (Method method : methods) {
			if (method.getParameterTypes().length == 0 && method.getReturnType() != void.class) {
				try {
					Object value = method.invoke(annotation);
					attrs.put(method.getName(), adaptValue(value, classValuesAsString, nestedAnnotationsAsMap));
				} catch (Exception ex) {
					throw new IllegalStateException("Could not obtain annotation attribute values", ex);
				}
			}
		}
		return attrs;
	}

	@SuppressWarnings("unchecked")
	static Object adaptValue(Object value, boolean classValuesAsString, boolean nestedAnnotationsAsMap) {
		if (classValuesAsString) {
			if (value instanceof Class) {
				value = ((Class<?>) value).getName();
			} else if (value instanceof Class[]) {
				Class<?>[] clazzArray = (Class[]) value;
				String[] newValue = new String[clazzArray.length];
				for (int i = 0; i < clazzArray.length; i++) {
					newValue[i] = clazzArray[i].getName();
				}
				value = newValue;
			}
		}
		if (nestedAnnotationsAsMap && value instanceof Annotation) {
			return getAnnotationAttributes((Annotation) value, classValuesAsString, true);
		} else if (nestedAnnotationsAsMap && value instanceof Annotation[]) {
			Annotation[] realAnnotations = (Annotation[]) value;
			LinkedHashMap<String, Object>[] mappedAnnotations = new LinkedHashMap[realAnnotations.length];
			for (int i = 0; i < realAnnotations.length; i++) {
				mappedAnnotations[i] = getAnnotationAttributes(realAnnotations[i], classValuesAsString, true);
			}
			return mappedAnnotations;
		} else {
			return value;
		}
	}
}
