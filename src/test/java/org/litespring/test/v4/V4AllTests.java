package org.litespring.test.v4;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.litespring.test.v3.ApplicationContextTestV3;
import org.litespring.test.v3.BeanDefinitionTestV3;
import org.litespring.test.v3.ConstructorResolverTest;

/**
 * <p>
 *
 * </p>
 *
 * @author Denny
 * @version 1.0.0 19/07/2018 12:09 AM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 **/

@RunWith(Suite.class)
@Suite.SuiteClasses({ApplicationContextTest4.class, ClassPathBeanDefinitionScannerTest.class, ClassReaderTest.class,
		MetadataReaderTest.class, PackageResourceLoaderTest.class, XmlBeanDefinitionReaderTest.class,
		DependencyDescriptorTest.class, InjectionMetadataTest.class, AutowiredAnnotationProcessorTest.class})
public class V4AllTests {
}
