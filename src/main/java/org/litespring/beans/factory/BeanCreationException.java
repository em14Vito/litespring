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
public class BeanCreationException extends BeansException {
	private String beanName;

	public BeanCreationException(String msg) {
		super(msg);
	}

	public BeanCreationException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public BeanCreationException(String beanName, String msg) {
		super("Error creating bean with name '" + beanName + "': " + msg);
		this.beanName = beanName;
	}

	public BeanCreationException(String beanName, String msg, Throwable cause) {
		this(beanName, msg);
		initCause(cause);
	}

	public String getBeanName() {
		return this.beanName;
	}
}
