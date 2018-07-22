package org.litespring.beans;

/**
 *
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
