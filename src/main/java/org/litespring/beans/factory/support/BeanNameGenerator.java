package org.litespring.beans.factory.support;

import org.litespring.beans.BeanDefinition;

/**
 * <p>
 *
 * </p>
 *
 * @author Denny
 * @version 1.0.0 18/07/2018 11:46 PM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 **/

public interface BeanNameGenerator {

	/**
	 * Generate a bean name for the given bean definition.
	 *
	 * @param definition the bean definition to generate a name for
	 * @param registry   the bean definition registry that the given definition
	 *                   is supposed to be registered with
	 * @return the generated bean name
	 */
	String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry);

}
