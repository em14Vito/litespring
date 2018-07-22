package org.litespring.beans.factory.config;

/**
 * [Class description. The first sentence should be a meaningful summary of the class since it will
 * be displayed as the class summary on the Javadoc package page.]
 *
 * <p>[Other notes, including guaranteed invariants, usage instructions and/or examples, reminders
 * about desired improvements, etc.]
 *
 * @author Denny
 * @version 1.0.0 30/06/2018 5:15 PM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 */
public class TypedStringValue {
	private String value;

	public TypedStringValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
