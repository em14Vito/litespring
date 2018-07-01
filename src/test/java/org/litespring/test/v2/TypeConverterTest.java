package org.litespring.test.v2;

import org.junit.Assert;
import org.junit.Test;
import org.litespring.TypeMismatchException;
import org.litespring.beans.SimpleTypeConverter;
import org.litespring.beans.TypeConverter;

import static junit.framework.TestCase.fail;

/**
 * [Class description.  The first sentence should be a meaningful summary of the class since it
 * will be displayed as the class summary on the Javadoc package page.]
 * <p>
 * [Other notes, including guaranteed invariants, usage instructions and/or examples, reminders
 * about desired improvements, etc.]
 *
 * @author Denny
 * @version 1.0.0 01/07/2018 9:03 PM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 **/

public class TypeConverterTest {

	@Test
	public void testConvertStringToInt() {
		TypeConverter converter = new SimpleTypeConverter();
		Integer i = converter.convertIfNecessary("3", Integer.class);
		Assert.assertEquals(3,i.intValue());

		try{
			converter.convertIfNecessary("3.1", Integer.class);
		}catch(TypeMismatchException e){
			return;
		}
		fail();
	}
	@Test
	public void testConvertStringToBoolean(){
		TypeConverter converter = new SimpleTypeConverter();
		Boolean b = converter.convertIfNecessary("true", Boolean.class);
		Assert.assertEquals(true,b.booleanValue());

		try{
			converter.convertIfNecessary("xxxyyyzzz", Boolean.class);
		}catch(TypeMismatchException e){
			return;
		}
		fail();
	}

}
