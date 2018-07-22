package org.litespring.test.v3;

import org.junit.Assert;
import org.junit.Test;
import org.litespring.context.ApplicationContext;
import org.litespring.context.support.ClassPathXmlApplicationContext;
import org.litespring.dao.v3.AccountDao;
import org.litespring.dao.v3.ItemDao;
import org.litespring.service.v3.PetStoreService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * <p>
 *
 * </p>
 *
 * @author Denny
 * @version 1.0.0 07/07/2018 3:36 PM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 **/

public class ApplicationContextTestV3 {

	@Test
	public void testGetBeanProperty() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("petstore-v3.xml");
		PetStoreService petStore = (PetStoreService) ctx.getBean("petStore");

		Assert.assertNotNull(petStore.getAccountDao());
		Assert.assertNotNull(petStore.getItemDao());
		Assert.assertEquals(1, petStore.getVersion());

	}

}
