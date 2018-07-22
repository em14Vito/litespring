package org.litespring.beans.factory.annotation;

import org.litespring.beans.factory.config.AutowireCapableBeanFactory;

import java.lang.reflect.Member;

/**
 * <p>
 *
 * </p>
 *
 * @author Denny
 * @version 1.0.0 22/07/2018 6:42 PM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 **/

public abstract class InjectionElement {
	protected Member member;
	protected AutowireCapableBeanFactory factory;

	InjectionElement(Member member, AutowireCapableBeanFactory factory) {
		this.member = member;
		this.factory = factory;
	}

	public abstract void inject(Object target);
}
