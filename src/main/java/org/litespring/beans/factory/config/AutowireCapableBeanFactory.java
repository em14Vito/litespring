package org.litespring.beans.factory.config;

import org.litespring.beans.factory.BeanFactory;

/**
 * <p>
 *
 * </p>
 *
 * @author Denny
 * @version 1.0.0 22/07/2018 4:29 PM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 **/

public interface AutowireCapableBeanFactory extends BeanFactory {
	public Object resolveDependency(DependencyDescriptor descriptor);
}
