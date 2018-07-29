package org.litespring.aop;

/**
 * <p>
 *
 * </p>
 *
 * @author Denny
 * @version 1.0.0 04/08/2018 11:24 PM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 **/

public interface Pointcut {
	MethodMatcher getMethodMatcher();
	String getExpression();
}
