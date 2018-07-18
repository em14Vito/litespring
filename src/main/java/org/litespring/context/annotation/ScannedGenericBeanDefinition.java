package org.litespring.context.annotation;

import org.litespring.beans.factory.annotation.AnnotatedBeanDefinition;
import org.litespring.beans.factory.support.GenericBeanDefinition;
import org.litespring.core.type.AnnotationMetadata;

/**
 * <p>
 *
 * </p>
 *
 * @author Denny
 * @version 1.0.0 18/07/2018 11:38 PM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 **/


public class ScannedGenericBeanDefinition extends GenericBeanDefinition implements AnnotatedBeanDefinition {

	private final AnnotationMetadata metadata;


	public ScannedGenericBeanDefinition(AnnotationMetadata metadata) {
		super();

		this.metadata = metadata;

		setBeanClassName(this.metadata.getClassName());
	}


	public final AnnotationMetadata getMetadata() {
		return this.metadata;
	}

}
