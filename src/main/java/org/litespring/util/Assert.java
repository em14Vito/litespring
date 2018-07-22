package org.litespring.util;

/**
 * <p>
 *     非空Assert 判断
 * </p>
 *
 * @author Denny
 * @version 1.0.0 01/07/2018 9:12 PM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 **/


public abstract class Assert {
	public static void notNull(Object object, String message) {
		if (object == null) {
			throw new IllegalArgumentException(message);
		}
	}
}
