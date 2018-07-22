package org.litespring.beans.factory.annotation;

import java.util.List;

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


public class InjectionMetadata {

	private final Class<?> targetClass;
	private List<InjectionElement> injectionElements;

	public InjectionMetadata(Class<?> targetClass, List<InjectionElement> injectionElements) {
		this.targetClass = targetClass;
		this.injectionElements = injectionElements;
	}

	public List<InjectionElement> getInjectionElements() {
		return injectionElements;
	}

	public void inject(Object target) {
		if (injectionElements == null || injectionElements.isEmpty()) {
			return;
		}
		for (InjectionElement ele : injectionElements) {

			ele.inject(target);
		}
	}
}