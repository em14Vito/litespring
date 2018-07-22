package org.litespring.context.support;

import org.litespring.beans.factory.annotation.AutowiredAnnotationProcessor;
import org.litespring.beans.factory.config.ConfigurableBeanFactory;
import org.litespring.beans.factory.support.DefaultBeanFactory;
import org.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import org.litespring.context.ApplicationContext;
import org.litespring.core.io.Resource;
import org.litespring.util.ClassUtils;

/**
 * [Class description. The first sentence should be a meaningful summary of the class since it will
 * be displayed as the class summary on the Javadoc package page.]
 *
 * <p>[Other notes, including guaranteed invariants, usage instructions and/or examples, reminders
 * about desired improvements, etc.]
 *
 * @author Denny
 * @version 1.0.0 21/06/2018 12:20 AM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 */
public abstract class AbstractApplicationContext implements ApplicationContext {

	private DefaultBeanFactory factory = null;
	private ClassLoader beanClassLoader;

	public AbstractApplicationContext(String configFile) {
		factory = new DefaultBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		Resource resource = this.getResourceByPath(configFile);
		reader.loadBeanDefinitions(resource);
		factory.setBeanClassLoader(this.getBeanClassLoader());
		registerBeanPostProcessors(factory);
	}

	public Object getBean(String beanID) {

		return factory.getBean(beanID);
	}

	protected abstract Resource getResourceByPath(String path);

	public void setBeanClassLoader(ClassLoader beanClassLoader) {
		this.beanClassLoader = beanClassLoader;
	}

	public ClassLoader getBeanClassLoader() {
		return (this.beanClassLoader != null ? this.beanClassLoader : ClassUtils.getDefaultClassLoader());
	}

	protected void registerBeanPostProcessors(ConfigurableBeanFactory beanFactory) {

		AutowiredAnnotationProcessor postProcessor = new AutowiredAnnotationProcessor();
		postProcessor.setBeanFactory(beanFactory);
		beanFactory.addBeanPostProcessor(postProcessor);

	}

}
