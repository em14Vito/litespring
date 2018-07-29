package org.litespring.aop;

import java.lang.reflect.Method;

/**
 * <p>
 *
 * </p>
 *
 * @author Denny
 * @version 1.0.0 04/08/2018 11:23 PM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 **/

public interface MethodMatcher {

	boolean matches(Method method/*, Class<?> targetClass*/);
}

