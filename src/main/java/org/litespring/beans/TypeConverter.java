package org.litespring.beans;


import org.litespring.TypeMismatchException;

/**
 * 类型转换接口： 目前用于 构造器注入对象时 转换
 *
 * @author Denny
 * @version 1.0.0 01/07/2018 5:10 PM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 **/
public interface TypeConverter {


	<T> T convertIfNecessary(Object value, Class<T> requiredType) throws TypeMismatchException;


}
