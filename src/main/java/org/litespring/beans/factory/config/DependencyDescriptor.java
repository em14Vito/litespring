package org.litespring.beans.factory.config;

import org.litespring.util.Assert;

import java.lang.reflect.Field;

/**
 * <p>
 *
 * </p>
 *
 * @author Denny
 * @version 1.0.0 22/07/2018 4:27 PM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 **/

public class DependencyDescriptor {
	private Field field;
	private boolean required;

	public DependencyDescriptor(Field field, boolean required) {
		Assert.notNull(field, "Field must not be null");
		this.field = field;
		this.required = required;

	}

	public Class<?> getDependencyType() {
		if (this.field != null) {
			return field.getType();
		}
		throw new RuntimeException("only support field dependency");
	}

	public boolean isRequired() {
		return this.required;
	}
}

