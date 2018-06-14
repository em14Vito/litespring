package org.litespring.bean.factory;

import org.litespring.beans.BeanDefinition;

/**
 * Cathay-ins.com.cn Inc.
 * Copyright (c) 2014-2018 All Rights Reserved.
 * <p>
 * [Class description.  The first sentence should be a meaningful summary of the class since it
 * will be displayed as the class summary on the Javadoc package page.]
 * <p>
 * [Other notes, including guaranteed invariants, usage instructions and/or examples, reminders
 * about desired improvements, etc.]
 *
 * @author Denny
 * @version 1.0.0 14/06/2018 12:21 AM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 **/

public interface BeanFactory {

	BeanDefinition getBeanDefinition(String beanId);

	Object getBean(String petStore);
}
