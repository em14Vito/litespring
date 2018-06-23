package org.litespring.test.v1;

import org.junit.Assert;
import org.junit.Test;
import org.litespring.context.ApplicationContext;
import org.litespring.context.support.ClassPathXmlApplicationContext;
import org.litespring.context.support.FileSystemXmlApplicationContext;
import org.litespring.service.v1.PetStoreService;

import java.io.File;

/**
 * [Class description.  The first sentence should be a meaningful summary of the class since it
 * will be displayed as the class summary on the Javadoc package page.]
 * <p>
 * [Other notes, including guaranteed invariants, usage instructions and/or examples, reminders
 * about desired improvements, etc.]
 *
 * @author Denny
 * @version 1.0.0 19/06/2018 10:51 PM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 **/

public class ApplicationContextTest {

	@Test
	public void testGetBean(){
		ApplicationContext context = new ClassPathXmlApplicationContext("petstore-v1.xml");
		PetStoreService petStoreService = (PetStoreService) context.getBean("petStore");
        Assert.assertNotNull(petStoreService);
	}

	@Test
	public void testGetBeanFromFileSystemContext(){
		//注意啊，这里仍然是hardcode了一个本地路径，这是不好的实践!! 如何处理，留作作业
		ApplicationContext ctx = new FileSystemXmlApplicationContext("src"+File.separator+"test"+File.separator+
				"resources"+File.separator+"petstore-v1.xml");
		PetStoreService petStore = (PetStoreService)ctx.getBean("petStore");
		Assert.assertNotNull(petStore);

	}
}
