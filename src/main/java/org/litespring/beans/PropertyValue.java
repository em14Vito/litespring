package org.litespring.beans;

/**
 * Property 值对象，目前用于 构造函数注入
 *
 * @author Denny
 * @version 1.0.0 30/06/2018 11:38 AM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 */
public class PropertyValue {
	private final String name;

	private final Object value;

	private boolean converted = false;

	private Object convertedValue;

	public PropertyValue(String name, Object value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return this.name;
	}

	public Object getValue() {
		return this.value;
	}

	public synchronized boolean isConverted() {
		return this.converted;
	}

	public synchronized void setConvertedValue(Object value) {
		this.converted = true;
		this.convertedValue = value;
	}

	public synchronized Object getConvertedValue() {
		return this.convertedValue;
	}
}
