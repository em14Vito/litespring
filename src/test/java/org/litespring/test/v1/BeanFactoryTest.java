package org.litespring.test.v1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.litespring.beans.BeanDefinition;
import org.litespring.beans.factory.BeanCreationException;
import org.litespring.beans.factory.BeanDefinitionStoreException;
import org.litespring.beans.factory.BeanFactory;
import org.litespring.beans.factory.support.DefaultBeanFactory;
import org.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import org.litespring.core.io.ClassPathResource;
import org.litespring.service.v1.PetStoreService;

import static org.junit.Assert.*;

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
	DefaultBeanFactory factory = null;
	XmlBeanDefinitionReader reader = null;

	@Before
	public void setUp() {
		factory = new DefaultBeanFactory();
		reader = new XmlBeanDefinitionReader(factory);

	}

	@Test
	public void testGetBean() {

		reader.loadBeanDefinitions(new ClassPathResource("petstore-v1.xml"));

		BeanDefinition bd = factory.getBeanDefinition("petStore");

		assertTrue(bd.isSingleton());

		assertFalse(bd.isPrototype());

		assertEquals(BeanDefinition.SCOPE_DEFAULT, bd.getScope());

		assertEquals("org.litespring.service.v1.PointcutTest", bd.getBeanClassName());

		PetStoreService petStore = (PetStoreService) factory.getBean("petStore");

		assertNotNull(petStore);

		PetStoreService petStore1 = (PetStoreService) factory.getBean("petStore");

		assertTrue(petStore.equals(petStore1));
	}

	@Test
	public void testInvalidBean() {

		Object result = null;
		reader.loadBeanDefinitions(new ClassPathResource("petstore-v1.xml"));
		try {
			result = factory.getBean("invalidBean");
		} catch (BeanCreationException e) {
			return;
		}
		Assert.assertNull(result);
	}

	@Test
	public void testInvalidXML() {

		try {
			reader.loadBeanDefinitions(new ClassPathResource("xxxx.xml"));
		} catch (BeanDefinitionStoreException e) {
			return;
		}
		Assert.fail("expect BeanDefinitionStoreException ");
	}

}