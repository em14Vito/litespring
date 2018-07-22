package org.litespring;

import org.litespring.beans.BeansException;

/**
 * [Class description.  The first sentence should be a meaningful summary of the class since it
 * will be displayed as the class summary on the Javadoc package page.]
 * <p>
 * [Other notes, including guaranteed invariants, usage instructions and/or examples, reminders
 * about desired improvements, etc.]
 *
 * @author Denny
 * @version 1.0.0 01/07/2018 9:12 PM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 **/


public class TypeMismatchException extends BeansException {
	private transient Object value;

	private Class<?> requiredType;

	public TypeMismatchException(Object value, Class<?> requiredType) {
		super("Failed to convert value :" + value + "to type " + requiredType);
		this.value = value;
		this.requiredType = requiredType;
	}

	public Object getValue() {
		return value;
	}

	public Class<?> getRequiredType() {
		return requiredType;
	}


}
