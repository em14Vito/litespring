package org.litespring.beans.factory.annotation;

import org.litespring.beans.BeanDefinition;
import org.litespring.core.type.AnnotationMetadata;

/**
 * <p>
 *
 * </p>
 *
 * @author Denny
 * @version 1.0.0 18/07/2018 11:39 PM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 **/

public interface AnnotatedBeanDefinition extends BeanDefinition {
	AnnotationMetadata getMetadata();
}

