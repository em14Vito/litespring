package org.litespring.beans.factory.support;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.litespring.beans.BeanDefinition;
import org.litespring.beans.PropertyValue;
import org.litespring.beans.SimpleTypeConverter;
import org.litespring.beans.factory.BeanCreationException;
import org.litespring.beans.factory.BeanFactory;
import org.litespring.beans.factory.NoSuchBeanDefinitionException;
import org.litespring.beans.factory.config.BeanPostProcessor;
import org.litespring.beans.factory.config.ConfigurableBeanFactory;
import org.litespring.beans.factory.config.DependencyDescriptor;
import org.litespring.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.litespring.util.ClassUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;
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
		implements ConfigurableBeanFactory, BeanDefinitionRegistry {

	private List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();

	private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>(64);
	private ClassLoader beanClassLoader;

	public DefaultBeanFactory() {

	}

	public void addBeanPostProcessor(BeanPostProcessor postProcessor) {
		this.beanPostProcessors.add(postProcessor);
	}

	public List<BeanPostProcessor> getBeanPostProcessors() {
		return this.beanPostProcessors;
	}

	public void registerBeanDefinition(String beanID, BeanDefinition bd) {
		this.beanDefinitionMap.put(beanID, bd);
	}

	public BeanDefinition getBeanDefinition(String beanID) {

		return this.beanDefinitionMap.get(beanID);
	}

	public Object getBean(String beanID) {
		BeanDefinition bd = this.getBeanDefinition(beanID);
		if (bd == null) {
			return null;
		}

		if (bd.isSingleton()) {
			Object bean = this.getSingleton(beanID);
			if (bean == null) {
				bean = createBean(bd);
				this.registerSingleton(beanID, bean);
			}
			return bean;
		}
		return createBean(bd);
	}

	private Object createBean(BeanDefinition bd) {
		//创建实例
		Object bean = instantiateBean(bd);
		//设置属性
		populateBean(bd, bean);

		return bean;

	}

	private Object instantiateBean(BeanDefinition bd) {
		if (bd.hasConstructorArgumentValues()) {
			ConstructorResolver resolver = new ConstructorResolver(this);
			return resolver.autowireConstructor(bd);
		} else {
			ClassLoader cl = this.getBeanClassLoader();
			String beanClassName = bd.getBeanClassName();
			try {
				Class<?> clz = cl.loadClass(beanClassName);
				return clz.newInstance();
			} catch (Exception e) {
				throw new BeanCreationException("create bean for " + beanClassName + " failed", e);
			}
		}
	}

	protected void populateBean(BeanDefinition bd, Object bean) {

		for (BeanPostProcessor processor : this.getBeanPostProcessors()) {
			if (processor instanceof InstantiationAwareBeanPostProcessor) {
				((InstantiationAwareBeanPostProcessor) processor).postProcessPropertyValues(bean, bd.getID());
			}
		}

		List<PropertyValue> pvs = bd.getPropertyValues();

		if (pvs == null || pvs.isEmpty()) {
			return;
		}

		BeanDefinitionValueResolver valueResolver = new BeanDefinitionValueResolver(this);
		SimpleTypeConverter converter = new SimpleTypeConverter();
		try {
			for (PropertyValue pv : pvs) {
				String propertyName = pv.getName();
				Object originalValue = pv.getValue();
				Object resolvedValue = valueResolver.resolveValueIfNecessary(originalValue);

				BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
				PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
				for (PropertyDescriptor pd : pds) {
					if (pd.getName().equals(propertyName)) {
						Object convertedValue = converter.convertIfNecessary(resolvedValue, pd.getPropertyType());
						pd.getWriteMethod().invoke(bean, convertedValue);
						break;
					}
				}


			}
		} catch (Exception ex) {
			throw new BeanCreationException("Failed to obtain BeanInfo for class [" + bd.getBeanClassName() + "]", ex);
		}
	}

	public void setBeanClassLoader(ClassLoader beanClassLoader) {
		this.beanClassLoader = beanClassLoader;
	}

	public ClassLoader getBeanClassLoader() {
		return (this.beanClassLoader != null ? this.beanClassLoader : ClassUtils.getDefaultClassLoader());
	}

	public Object resolveDependency(DependencyDescriptor descriptor) {

		Class<?> typeToMatch = descriptor.getDependencyType();
		for (BeanDefinition bd : this.beanDefinitionMap.values()) {
			//确保BeanDefinition 有Class对象
			resolveBeanClass(bd);
			Class<?> beanClass = bd.getBeanClass();
			if (typeToMatch.isAssignableFrom(beanClass)) {
				return this.getBean(bd.getID());
			}
		}
		return null;
	}

	public void resolveBeanClass(BeanDefinition bd) {
		if (bd.hasBeanClass()) {
			return;
		} else {
			try {
				bd.resolveBeanClass(this.getBeanClassLoader());
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("can't load class:" + bd.getBeanClassName());
			}
		}
	}
	public Class<?> getType(String name) throws NoSuchBeanDefinitionException {
		BeanDefinition bd = this.getBeanDefinition(name);
		if(bd == null){
			throw new NoSuchBeanDefinitionException(name);
		}
		resolveBeanClass(bd);
		return bd.getBeanClass();
	}
}

