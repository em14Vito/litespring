package org.litespring.stereotype;

import java.lang.annotation.*;

/**
 * <p>
 *
 * </p>
 *
 * @author Denny
 * @version 1.0.0 16/07/2018 9:07 PM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Component {

	/**
	 * The value may indicate a suggestion for a logical component name,
	 * to be turned into a Spring bean in case of an autodetected component.
	 * @return the suggested component name, if any
	 */
	String value() default "";

}