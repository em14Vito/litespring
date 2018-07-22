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
public interface BeanPostProcessor {

	Object beforeInitialization(Object bean, String beanName) throws BeansException;


	Object afterInitialization(Object bean, String beanName) throws BeansException;

}
