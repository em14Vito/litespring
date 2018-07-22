package org.litespring.test.v2;

/**
 * [Class description.  The first sentence should be a meaningful summary of the class since it
 * will be displayed as the class summary on the Javadoc package page.]
 * <p>
 * [Other notes, including guaranteed invariants, usage instructions and/or examples, reminders
 * about desired improvements, etc.]
 *
 * @author Denny
 * @version 1.0.0 01/07/2018 9:25 PM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 **/

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ApplicationContextTestV2.class, BeanDefinitionTestV2.class, BeanDefinitionValueResolverTest.class,
		CustomBooleanEditorTest.class, CustomNumberEditorTest.class, TypeConverterTest.class})
public class V2AllTests {

}

