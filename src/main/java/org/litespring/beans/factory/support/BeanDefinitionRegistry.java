package org.litespring.beans.factory.support;

import org.litespring.bean.BeanDefinition;

/**
 *
 * @author Denny
 * @version 1.0.0 18/06/2018 11:59 PM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 **/

public interface  BeanDefinitionRegistry {
	BeanDefinition getBeanDefinition(String beanId);

	void registerBeanDefinition(String id, BeanDefinition bd);
}
