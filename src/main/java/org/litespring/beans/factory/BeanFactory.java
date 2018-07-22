package org.litespring.beans.factory;

/**
 * Bean 工厂, 供user 调用;
 *
 * @author Denny
 * @version 1.0.0 14/06/2018 12:21 AM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 */
public interface BeanFactory {

	Object getBean(String petStore);
}
