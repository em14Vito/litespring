package org.litespring.core.type;

import org.litespring.core.annotation.AnnotationAttributes;

import java.util.Set;

/**
 * <p>
 *
 * </p>
 *
 * @author Denny
 * @version 1.0.0 18/07/2018 11:24 PM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 **/
public interface AnnotationMetadata extends ClassMetadata{

	Set<String> getAnnotationTypes();


	boolean hasAnnotation(String annotationType);

	public AnnotationAttributes getAnnotationAttributes(String annotationType);
}
