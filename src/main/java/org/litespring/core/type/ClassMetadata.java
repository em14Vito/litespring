package org.litespring.core.type;

/**
 * <p>
 *  Class 的 元数据 接口：
 * </p>
 *
 * @author Denny
 * @version 1.0.0 18/07/2018 11:25 PM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 **/

public interface ClassMetadata {

	/**
	 * Return the name of the underlying class.
	 */
	String getClassName();

	/**
	 * Return whether the underlying class represents an interface.
	 */
	boolean isInterface();

	/**
	 * Return whether the underlying class is marked as abstract.
	 */
	boolean isAbstract();


	/**
	 * Return whether the underlying class is marked as 'final'.
	 */
	boolean isFinal();


	/**
	 * Return whether the underlying class has a super class.
	 */
	boolean hasSuperClass();

	/**
	 * Return the name of the super class of the underlying class,
	 * or {@code null} if there is no super class defined.
	 */
	String getSuperClassName();

	/**
	 * Return the names of all interfaces that the underlying class
	 * implements, or an empty array if there are none.
	 */
	String[] getInterfaceNames();


}