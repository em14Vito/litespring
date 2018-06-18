package org.litespring.test.v1;

import org.junit.Assert;
import org.junit.Test;
import org.litespring.beans.factory.BeanCreateException;
import org.litespring.beans.factory.BeanDefinitionStoreException;
import org.litespring.beans.factory.BeanFactory;
import org.litespring.beans.factory.support.DefaultBeanFactory;
import org.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import org.litespring.bean.BeanDefinition;
import org.litespring.service.v1.PetStoreService;

/**
 * <p>
 * [Class description.  The first sentence should be a meaningful summary of the class since it
 * will be displayed as the class summary on the Javadoc package page.]
 * <p>
 * [Other notes, including guaranteed invariants, usage instructions and/or examples, reminders
 * about desired improvements, etc.]
 *
 * @author Denny
 * @version 1.0.0 13/06/2018 12:15 AM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 **/

public class BeanFactoryTest {

	@Test
	public void testGetBean(){
		DefaultBeanFactory factory = new DefaultBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinition("petstore-v1.xml");

		BeanDefinition bd = factory.getBeanDefinition("petStore");

		Assert.assertEquals("org.litespring.service.v1.PetStoreService",bd.getBeanClassName());

		PetStoreService petStore = (PetStoreService)factory.getBean("petStore");
		Assert.assertNotNull(petStore);
	}

	@Test
	public void testInvalidBean(){
		DefaultBeanFactory factory = new DefaultBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinition("petstore-v1.xml");

		try{
			factory.getBean( "invalid");
		} catch ( BeanCreateException e) {
			return;
		}
 		Assert.fail("expect BeanCreationException ");
	}

	@Test
	public void testInvalidXML(){
		try{
			DefaultBeanFactory factory = new DefaultBeanFactory();
			XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
			reader.loadBeanDefinition("invalid-v1.xml");

		} catch ( BeanDefinitionStoreException e) {
			return;
		}
		Assert.fail("expect BeanDefinitionStoreException ");
	}

}
