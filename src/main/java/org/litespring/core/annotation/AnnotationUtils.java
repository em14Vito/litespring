package org.litespring.core.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

/**
 * <p>
 *
 * </p>
 *
 * @author Denny
 * @version 1.0.0 22/07/2018 7:03 PM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 **/
public abstract class AnnotationUtils {

	public static <T extends Annotation> T getAnnotation(AnnotatedElement ae, Class<T> annotationType) {
		T ann = ae.getAnnotation(annotationType);
		if (ann == null) {
			for (Annotation metaAnn : ae.getAnnotations()) {
				ann = metaAnn.annotationType().getAnnotation(annotationType);
				if (ann != null) {
					break;
				}
			}
		}
		return ann;
	}


}
