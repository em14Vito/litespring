package org.litespring.test.v4;

import org.junit.Assert;
import org.junit.Test;
import org.litespring.core.io.Resource;
import org.litespring.core.io.support.PackageResourceLoader;

import java.io.IOException;

/**
 * <p>
 *
 * </p>
 *
 * @author Denny
 * @version 1.0.0 16/07/2018 8:58 PM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 **/

public class PackageResourceLoaderTest {

	@Test
	public void testGetResources() throws IOException {
		PackageResourceLoader loader = new PackageResourceLoader();
		Resource[] resources = loader.getResources("org.litespring.dao.v4");
		Assert.assertEquals(2, resources.length);

	}

}
