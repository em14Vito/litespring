package org.litespring.beans.factory.support;

import org.litespring.beans.factory.BeanCreateException;
import org.litespring.beans.factory.BeanFactory;
import org.litespring.bean.BeanDefinition;
import org.litespring.util.ClassUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * [Class description. The first sentence should be a meaningful summary of the class since it will
 * be displayed as the class summary on the Javadoc package page.]
 *
 * <p>[Other notes, including guaranteed invariants, usage instructions and/or examples, reminders
 * about desired improvements, etc.]
 *
 * @author Denny
 * @version 1.0.0 14/06/2018 12:22 AM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 */
public class DefaultBeanFactory implements BeanFactory, BeanDefinitionRegistry {

  private final Map<String, BeanDefinition> beanDefinitionMap =
      new ConcurrentHashMap<String, BeanDefinition>();

  public DefaultBeanFactory() {}

  @Override
  public BeanDefinition getBeanDefinition(String beanId) {
    return beanDefinitionMap.get(beanId);
  }

  @Override
  public void registerBeanDefinition(String beanID, BeanDefinition bd) {
    this.beanDefinitionMap.put(beanID, bd);
  }

  @Override
  public Object getBean(String beanId) {
    BeanDefinition bd = this.getBeanDefinition(beanId);
    if (bd == null) {
      throw new BeanCreateException("Bean Definition does not exist");
    }

    ClassLoader cl = ClassUtils.getDefaultClassLoader();
    String beanClassName = bd.getBeanClassName();
    try {
      Class<?> clz = cl.loadClass(beanClassName);
      return clz.newInstance();
    } catch (Exception e) {
      throw new BeanCreateException("create bean for " + beanClassName + " fail", e);
    }
  }
}
