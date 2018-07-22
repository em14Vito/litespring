package org.litespring.beans.factory.config;

import org.litespring.beans.BeansException;

/**
 * <p>
 *
 * </p>
 *
 * @author Denny
 * @version 1.0.0 22/07/2018 7:10 PM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 **/

public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {

	Object beforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;

	boolean afterInstantiation(Object bean, String beanName) throws BeansException;

	void postProcessPropertyValues(Object bean, String beanName)
			throws BeansException;

}

