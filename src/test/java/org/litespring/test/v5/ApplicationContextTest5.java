package org.litespring.test.v5;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.litespring.context.ApplicationContext;
import org.litespring.context.support.ClassPathXmlApplicationContext;
import org.litespring.util.MessageTracker;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author Denny
 * @version 1.0.0 29/07/2018 9:47 PM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 **/
public class ApplicationContextTest5 {

	@Before
	public void setUp(){
		MessageTracker.clearMsgs();
	}
	@Test
	public void testPlaceOrder() {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("petstore-v5.xml");
		PointcutTest petStore = (PointcutTest)ctx.getBean("petStore");

		Assert.assertNotNull(petStore.getAccountDao());
		Assert.assertNotNull(petStore.getItemDao());

		petStore.placeOrder();

		List<String> msgs = MessageTracker.getMsgs();

		Assert.assertEquals(3, msgs.size());
		Assert.assertEquals("start tx", msgs.get(0));
		Assert.assertEquals("place order", msgs.get(1));
		Assert.assertEquals("commit tx", msgs.get(2));

	}


}
