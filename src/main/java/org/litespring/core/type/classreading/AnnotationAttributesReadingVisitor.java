package org.litespring.core.type.classreading;

import org.litespring.core.annotation.AnnotationAttributes;
import org.litespring.core.type.AnnotationMetadata;
import org.springframework.asm.AnnotationVisitor;
import org.springframework.asm.SpringAsmInfo;

import java.util.Map;

/**
 * <p>
 * 注释属性读取器：
 * 通过 继承 ASM Hooks, 获得指定注解下=》 属性对应的 key-value (String - AnnotationAttributes)
 * </p>
 *
 * @author Denny
 * @version 1.0.0 18/07/2018 8:57 AM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 **/


final class AnnotationAttributesReadingVisitor extends AnnotationVisitor {

	private final String annotationType;

	private final Map<String, AnnotationAttributes> attributesMap;

	AnnotationAttributes attributes = new AnnotationAttributes();


	public AnnotationAttributesReadingVisitor(
			String annotationType, Map<String, AnnotationAttributes> attributesMap) {
		super(SpringAsmInfo.ASM_VERSION);

		this.annotationType = annotationType;
		this.attributesMap = attributesMap;

	}

	@Override
	public final void visitEnd() {
		this.attributesMap.put(this.annotationType, this.attributes);
	}

	@Override
	public void visit(String attributeName, Object attributeValue) {
		this.attributes.put(attributeName, attributeValue);
	}


}

