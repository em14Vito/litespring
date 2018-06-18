package org.litespring.beans.factory;

import org.litespring.bean.BeansException;

/**
 * [Class description.  The first sentence should be a meaningful summary of the class since it
 * will be displayed as the class summary on the Javadoc package page.]
 * <p>
 * [Other notes, including guaranteed invariants, usage instructions and/or examples, reminders
 * about desired improvements, etc.]
 *
 * @author Denny
 * @version 1.0.0 15/06/2018 8:37 AM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 **/

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
