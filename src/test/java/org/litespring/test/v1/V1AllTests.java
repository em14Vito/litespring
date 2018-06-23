package org.litespring.test.v1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * [Class description.  The first sentence should be a meaningful summary of the class since it
 * will be displayed as the class summary on the Javadoc package page.]
 * <p>
 * [Other notes, including guaranteed invariants, usage instructions and/or examples, reminders
 * about desired improvements, etc.]
 *
 * @author Denny
 * @version 1.0.0 19/06/2018 11:06 PM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 **/


@RunWith(Suite.class)
@Suite.SuiteClasses({
		ApplicationContextTest.class,
		BeanFactoryTest.class ,
		ResourceTest.class})
public class V1AllTests {

}
