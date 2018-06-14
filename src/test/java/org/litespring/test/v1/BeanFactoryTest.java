package org.litespring.test.v1;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Assert.*;
import org.litespring.bean.factory.BeanFactory;
import org.litespring.bean.factory.support.DefaultBeanFactory;
import org.litespring.beans.BeanDefinition;
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
		BeanFactory factory = new DefaultBeanFactory("petstore-v1.xml");
		BeanDefinition bd = factory.getBeanDefinition("petStore");

		Assert.assertEquals("org.litespring.service.v1.PetStoreService",bd.getBeanClassName());

		PetStoreService petStore = (PetStoreService)factory.getBean("petStore");
		Assert.assertNotNull(petStore);
	}
}
