package org.litespring.context.annotation;

import org.litespring.beans.BeanDefinition;
import org.litespring.beans.factory.annotation.AnnotatedBeanDefinition;
import org.litespring.beans.factory.support.BeanDefinitionRegistry;
import org.litespring.beans.factory.support.BeanNameGenerator;
import org.litespring.core.annotation.AnnotationAttributes;
import org.litespring.core.type.AnnotationMetadata;
import org.litespring.util.ClassUtils;
import org.litespring.util.StringUtils;

import java.beans.Introspector;
import java.util.Set;

/**
 * <p>
 *     为Bean 生成Name:
 *     如果注解内未提供，则根据Class Nama 按照一定规则给与生成
 *
 * </p>
 *
 * @author Denny
 * @version 1.0.0 18/07/2018 11:45 PM
 *
 * @see java.beans.Introspector#decapitalize(String) {Bean Name生成规则}
 **/

public class AnnotationBeanNameGenerator implements BeanNameGenerator {


	public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
		if (definition instanceof AnnotatedBeanDefinition) {
			String beanName = determineBeanNameFromAnnotation((AnnotatedBeanDefinition) definition);
			if (StringUtils.hasText(beanName)) {
				// Explicit bean name found.
				return beanName;
			}
		}
		//未指定BeanName,自动生成BeanName
		return buildDefaultBeanName(definition, registry);
	}

	/**
	 * Derive a bean name from one of the annotations on the class.
	 *
	 * 查找对应的注解的Name( Field = value)
	 *
	 * @param annotatedDef the annotation-aware bean definition
	 * @return the bean name, or {@code null} if none is found
	 */
	protected String determineBeanNameFromAnnotation(AnnotatedBeanDefinition annotatedDef) {
		AnnotationMetadata amd = annotatedDef.getMetadata();
		//
		Set<String> types = amd.getAnnotationTypes();
		String beanName = null;
		//FIXME 感觉这段写的不太好; 没有遍历所有的属性;有种写死的感觉：
		for (String type : types) {
			AnnotationAttributes attributes = amd.getAnnotationAttributes(type);
			if (attributes.get("value") != null) {
				Object value = attributes.get("value");
				if (value instanceof String) {
					String strVal = (String) value;
					if (StringUtils.hasLength(strVal)) {
						beanName = strVal;
					}
				}
			}
		}
		return beanName;
	}


	/**
	 * Derive a default bean name from the given bean definition.
	 * <p>The default implementation delegates to {@link #buildDefaultBeanName(BeanDefinition)}.
	 *
	 * @param definition the bean definition to build a bean name for
	 * @param registry   the registry that the given bean definition is being registered with
	 * @return the default bean name (never {@code null})
	 */
	protected String buildDefaultBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
		return buildDefaultBeanName(definition);
	}

	/**
	 * Derive a default bean name from the given bean definition.
	 * <p>The default implementation simply builds a decapitalized version
	 * of the short class name:
	 *
	 * e.g.
	 * 1: "mypackage.MyJdbcDao" -> "myJdbcDao".
	 * 2:"URL" -> "URL"
	 * 3:"Fool" -> "fool"
	 *
	 * <p>Note that inner classes will thus have names of the form
	 * "outerClassName.InnerClassName", which because of the period in the
	 * name may be an issue if you are autowiring by name.
	 *
	 * @param definition the bean definition to build a bean name for
	 * @return the default bean name (never {@code null})
	 */
	protected String buildDefaultBeanName(BeanDefinition definition) {
		String shortClassName = ClassUtils.getShortName(definition.getBeanClassName());
		return Introspector.decapitalize(shortClassName);
	}

}
