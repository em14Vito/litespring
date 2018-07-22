package org.litespring.beans;

import java.util.List;

/**
 * [Class description. The first sentence should be a meaningful summary of the class since it will
 * be displayed as the class summary on the Javadoc package page.]
 *
 * <p>[Other notes, including guaranteed invariants, usage instructions and/or examples, reminders
 * about desired improvements, etc.]
 *
 * @author Denny
 * @version 1.0.0 14/06/2018 12:23 AM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 */
public interface BeanDefinition {
	public static final String SCOPE_SINGLETON = "singleton";
	public static final String SCOPE_PROTOTYPE = "prototype";
	public static final String SCOPE_DEFAULT = "";

	public boolean isSingleton();

	public boolean isPrototype();

	String getScope();

	void setScope(String scope);

	public String getBeanClassName();

	List<PropertyValue> getPropertyValues();

	ConstructorArgument getConstructorArgument();

	public String getID();

	public boolean hasConstructorArgumentValues();

	public Class<?> resolveBeanClass(ClassLoader classLoader) throws ClassNotFoundException;

	public Class<?> getBeanClass() throws IllegalStateException;

	public boolean hasBeanClass();

}
