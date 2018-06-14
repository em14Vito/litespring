package org.litespring.bean.factory.support;

import org.litespring.beans.BeanDefinition;

/**
 * [Class description.  The first sentence should be a meaningful summary of the class since it
 * will be displayed as the class summary on the Javadoc package page.]
 * <p>
 * [Other notes, including guaranteed invariants, usage instructions and/or examples, reminders
 * about desired improvements, etc.]
 *
 * @author Denny
 * @version 1.0.0 14/06/2018 12:51 AM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 **/

public class GenericBeanDefinition implements BeanDefinition {

	private String id;
	private String beanClassName;

	public GenericBeanDefinition(String id, String beanClassName) {
		this.id = id;
		this.beanClassName = beanClassName;
	}

	public String getBeanClassName() {
		return this.beanClassName;
	}
}
