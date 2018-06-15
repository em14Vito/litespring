package org.litespring.bean.factory;

import org.litespring.beans.BeansException;

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

public class BeanCreateException extends BeansException {


	private String beanName;
	public BeanCreateException(String msg) {
		super(msg);
	}

	public BeanCreateException(String message, Throwable cause) {
		super(message, cause);
	}

	public BeanCreateException( String beanName,String message) {
		super("Error creating bean with name " + beanName + ": " + message);
		this.beanName = beanName;
	}


	public String getBeanName() {
		return beanName;
	}
}
