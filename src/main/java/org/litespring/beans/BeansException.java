package org.litespring.beans;

/**
 * [Class description. The first sentence should be a meaningful summary of the class since it will
 * be displayed as the class summary on the Javadoc package page.]
 *
 * <p>[Other notes, including guaranteed invariants, usage instructions and/or examples, reminders
 * about desired improvements, etc.]
 *
 * @author Denny
 * @version 1.0.0 15/06/2018 12:40 AM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 */
public class BeansException extends RuntimeException {
  public BeansException(String msg) {
    super(msg);
  }

  public BeansException(String message, Throwable cause) {
    super(message, cause);
  }
}
