package org.litespring.beans.factory;

import org.litespring.beans.BeansException;

/**
 *
 * @author Denny
 * @version 1.0.0 15/06/2018 8:37 AM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 */
public class BeanDefinitionStoreException extends BeansException {

	private String beanName;

	public BeanDefinitionStoreException(String msg) {
		super(msg);
	}

	public BeanDefinitionStoreException(String message, Throwable cause) {
		super(message, cause);
	}

	public BeanDefinitionStoreException(String beanName, String message) {
		super("Error creating bean with name " + beanName + ": " + message);
		this.beanName = beanName;
	}

	public String getBeanName() {
		return beanName;
	}
}
