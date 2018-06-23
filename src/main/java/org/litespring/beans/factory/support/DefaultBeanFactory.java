package org.litespring.beans.factory.support;

import org.litespring.beans.BeanDefinition;
import org.litespring.beans.factory.BeanCreationException;
import org.litespring.beans.factory.BeanFactory;
import org.litespring.beans.factory.config.ConfigurableBeanFactory;
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

public class DefaultBeanFactory extends DefaultSingletonBeanRegistry
		implements ConfigurableBeanFactory,BeanDefinitionRegistry{



	private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>(64);
	private ClassLoader beanClassLoader;

	public DefaultBeanFactory() {

	}

	@Override
	public void registerBeanDefinition(String beanID, BeanDefinition bd){
		this.beanDefinitionMap.put(beanID, bd);
	}
	@Override
	public BeanDefinition getBeanDefinition(String beanID) {

		return this.beanDefinitionMap.get(beanID);
	}

	@Override
	public Object getBean(String beanID) {
		BeanDefinition bd = this.getBeanDefinition(beanID);
		if(bd == null){
//			return null;
			throw new BeanCreationException("Don't exist bean name");
		}

		if(bd.isSingleton()){
			Object bean = this.getSingleton(beanID);
			if(bean == null){
				bean = createBean(bd);
				this.registerSingleton(beanID, bean);
			}
			return bean;
		}
		return createBean(bd);
	}
	private Object createBean(BeanDefinition bd) {
		ClassLoader cl = this.getBeanClassLoader();
		String beanClassName = bd.getBeanClassName();
		try {
			Class<?> clz = cl.loadClass(beanClassName);
			return clz.newInstance();
		} catch (Exception e) {
			throw new BeanCreationException("create bean for "+ beanClassName +" failed",e);
		}
	}
	@Override
	public void setBeanClassLoader(ClassLoader beanClassLoader) {
		this.beanClassLoader = beanClassLoader;
	}

	@Override
	public ClassLoader getBeanClassLoader() {
		return (this.beanClassLoader != null ? this.beanClassLoader : ClassUtils.getDefaultClassLoader());
	}
}
