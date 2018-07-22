package org.litespring.beans.factory.support;

/**
 * [Class description. The first sentence should be a meaningful summary of the class since it will
 * be displayed as the class summary on the Javadoc package page.]
 *
 * <p>[Other notes, including guaranteed invariants, usage instructions and/or examples, reminders
 * about desired improvements, etc.]
 *
 * @author Denny
 * @version 1.0.0 23/06/2018 11:49 PM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 */

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.litespring.beans.factory.config.SingletonBeanRegistry;
import org.litespring.util.Assert;

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

	private final Map<String, Object> singletonObjects = new ConcurrentHashMap<String, Object>(64);

	public void registerSingleton(String beanName, Object singletonObject) {

		Assert.notNull(beanName, "'beanName' must not be null");

		Object oldObject = this.singletonObjects.get(beanName);
		if (oldObject != null) {
			throw new IllegalStateException(
					"Could not register object ["
							+ singletonObject
							+ "] under bean name '"
							+ beanName
							+ "': there is already object ["
							+ oldObject
							+ "] bound");
		}
		this.singletonObjects.put(beanName, singletonObject);
	}

	public Object getSingleton(String beanName) {

		return this.singletonObjects.get(beanName);
	}
}
