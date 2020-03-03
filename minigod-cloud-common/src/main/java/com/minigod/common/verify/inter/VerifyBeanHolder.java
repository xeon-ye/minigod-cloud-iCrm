package com.minigod.common.verify.inter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Map;

import com.minigod.common.ResponseResult;
import com.minigod.common.utils.ReflectUtil;
import com.minigod.common.verify.utils.AnnotationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.minigod.common.verify.inter.impl.AnnotationBoxImpl;
import com.minigod.common.verify.inter.impl.VerifyResultImpl;

public class VerifyBeanHolder {
	private static Logger logger = LoggerFactory.getLogger(VerifyBeanHolder.class);
	private AnnotationBox annotationBox = new AnnotationBoxImpl();
	private static VerifyBeanHolder beanChecker = new VerifyBeanHolder();

	public ResponseResult doVerify(Object bean) {
		Field[] fields = ReflectUtil.getFields(bean.getClass(), false);
		for (Field f : fields) {
			f.setAccessible(true);
			try {
				Annotation[] annos = f.getDeclaredAnnotations();
				if (annos != null && annos.length > 0) {
					ResponseResult result = doVerify(f.get(bean), f.getName(), f.getDeclaredAnnotations());
					if (!result.isSuccess()) {
						return result;
					}
				}
			} catch (Exception e) {
				logger.error("VerifyBeanHolder handler.", e);
				return VerifyResultImpl.DEFAULT_FAILED;
			}
		}
		return VerifyResultImpl.DEFAULT_SUCCESS;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private ResponseResult doVerify(Object param, String paramName, Annotation[] annotations) {
		for (Annotation annotation : annotations) {

			System.err.println(param + "---" + paramName);

			Map<String, Object> map = AnnotationUtils.getAnnotationAttributes(annotation);
			AnnotationVerifier validator = annotationBox.getAnno(annotation.getClass());

			try {
				if (validator == null) {
					Object obj = map.get("clazz");
					if (obj == null) {
						continue;
					}

					Class<?> o = (Class<?>) obj;
					validator = (AnnotationVerifier<?>) o.newInstance();
					annotationBox.addNewAnno(annotation.getClass(), validator.getClass());
				}

				ResponseResult result = validator.doVerify(param, paramName, annotation);
				if (!result.isSuccess()) {
					return result;
				}
			} catch (Exception e) {
				logger.error("VerifyBeanHolder handler.", e);
				return VerifyResultImpl.DEFAULT_FAILED;
			}
		}
		return VerifyResultImpl.DEFAULT_SUCCESS;
	}

	public static ResponseResult doCheck(Object bean) {
		return beanChecker.doVerify(bean);
	}
}
