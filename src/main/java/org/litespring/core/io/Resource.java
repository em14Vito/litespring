package org.litespring.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * [Class description. The first sentence should be a meaningful summary of the class since it will
 * be displayed as the class summary on the Javadoc package page.]
 *
 * <p>[Other notes, including guaranteed invariants, usage instructions and/or examples, reminders
 * about desired improvements, etc.]
 *
 * @author Denny
 * @version 1.0.0 19/06/2018 11:11 PM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 */
public interface Resource {

	public InputStream getInputStream() throws IOException;

	public String getDescription();
}
