package org.litespring.beans.factory.support;

import org.litespring.beans.BeanDefinition;

/**
 * [Class description. The first sentence should be a meaningful summary of the class since it will
 * be displayed as the class summary on the Javadoc package page.]
 *
 * <p>[Other notes, including guaranteed invariants, usage instructions and/or examples, reminders
 * about desired improvements, etc.]
 *
 * @author Denny
 * @version 1.0.0 14/06/2018 12:51 AM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 */
import org.litespring.beans.BeanDefinition;
import org.litespring.beans.PropertyValue;

import java.util.ArrayList;
import java.util.List;

public class GenericBeanDefinition implements BeanDefinition {
  private String id;
  private String beanClassName;
  private boolean singleton = true;
  private boolean prototype = false;
  private String scope = SCOPE_DEFAULT;
  List<PropertyValue> propertyValues = new ArrayList<PropertyValue>();

  public GenericBeanDefinition(String id, String beanClassName) {

    this.id = id;
    this.beanClassName = beanClassName;
  }

  public String getBeanClassName() {

    return this.beanClassName;
  }

  public List<PropertyValue> getPropertyValues() {
    return this.propertyValues;
  }

  public boolean isSingleton() {
    return this.singleton;
  }

  public boolean isPrototype() {
    return this.prototype;
  }

  public String getScope() {
    return this.scope;
  }

  public void setScope(String scope) {
    this.scope = scope;
    this.singleton = SCOPE_SINGLETON.equals(scope) || SCOPE_DEFAULT.equals(scope);
    this.prototype = SCOPE_PROTOTYPE.equals(scope);
  }
}
