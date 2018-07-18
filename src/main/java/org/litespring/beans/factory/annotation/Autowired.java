package org.litespring.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * <p>
 *
 * </p>
 *
 * @author Denny
 * @version 1.0.0 16/07/2018 9:16 PM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 **/
@Target({ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Autowired {

	/**
	 * Declares whether the annotated dependency is required.
	 * <p>Defaults to {@code true}.
	 */
	boolean required() default true;

}

