package org.litespring.beans.factory.config;

/**
 * [Class description. The first sentence should be a meaningful summary of the class since it will
 * be displayed as the class summary on the Javadoc package page.]
 *
 * <p>[Other notes, including guaranteed invariants, usage instructions and/or examples, reminders
 * about desired improvements, etc.]
 *
 * @author Denny
 * @version 1.0.0 21/06/2018 12:28 AM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 */
import org.litespring.beans.factory.BeanFactory;

public interface ConfigurableBeanFactory extends BeanFactory {
  void setBeanClassLoader(ClassLoader beanClassLoader);

  ClassLoader getBeanClassLoader();
}
