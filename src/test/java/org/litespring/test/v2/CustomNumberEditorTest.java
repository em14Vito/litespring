package org.litespring.test.v2;

import org.junit.Assert;
import org.junit.Test;
import org.litespring.beans.propertyeditors.CustomNumberEditor;

/**
 * [Class description.  The first sentence should be a meaningful summary of the class since it
 * will be displayed as the class summary on the Javadoc package page.]
 * <p>
 * [Other notes, including guaranteed invariants, usage instructions and/or examples, reminders
 * about desired improvements, etc.]
 *
 * @author Denny
 * @version 1.0.0 01/07/2018 5:14 PM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 **/

public class CustomNumberEditorTest {

	@Test
	public void testConvertString() {
		CustomNumberEditor editor = new CustomNumberEditor(Integer.class, true);

		editor.setAsText("3");
		Object value = editor.getValue();
		Assert.assertTrue(value instanceof Integer);
		Assert.assertEquals(3, ((Integer) editor.getValue()).intValue());


		editor.setAsText("");
		Assert.assertTrue(editor.getValue() == null);


		try {
			editor.setAsText("3.1");

		} catch (IllegalArgumentException e) {
			return;
		}
		Assert.fail();

	}
}
