package org.litespring.context.annotation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.litespring.beans.BeanDefinition;
import org.litespring.beans.factory.BeanDefinitionStoreException;
import org.litespring.beans.factory.support.BeanDefinitionRegistry;
import org.litespring.beans.factory.support.BeanNameGenerator;
import org.litespring.core.io.Resource;
import org.litespring.core.io.support.PackageResourceLoader;
import org.litespring.core.type.classreading.MetadataReader;
import org.litespring.core.type.classreading.SimpleMetadataReader;
import org.litespring.stereotype.Component;
import org.litespring.util.StringUtils;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * <p>
 *   扫描BasePackage 并转成BeanDefinition;
 * </p>
 *
 * @author Denny
 * @version 1.0.0 18/07/2018 11:45 PM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 **/
public class ClassPathBeanDefinitionScanner {


	private final BeanDefinitionRegistry registry;

	private PackageResourceLoader resourceLoader = new PackageResourceLoader();

	protected final Log logger = LogFactory.getLog(getClass());

	private BeanNameGenerator beanNameGenerator = new AnnotationBeanNameGenerator();

	public ClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry) {
		this.registry = registry;
	}

	public Set<BeanDefinition> doScan(String packagesToScan) {

		String[] basePackages = StringUtils.tokenizeToStringArray(packagesToScan, ",");

		Set<BeanDefinition> beanDefinitions = new LinkedHashSet<BeanDefinition>();
		for (String basePackage : basePackages) {
			Set<BeanDefinition> candidates = findCandidateComponents(basePackage);
			for (BeanDefinition candidate : candidates) {
				beanDefinitions.add(candidate);
				registry.registerBeanDefinition(candidate.getID(), candidate);

			}
		}
		return beanDefinitions;
	}

	/**
	 * 1. 递归查询basePackage下所有的文件, 转成Resource[]
	 * 2. 利用ASM扫描所有Resource的class,查找是否有属于Component注解;
	 * 3. 将Component 注解的Class 转成 ScannedGenericBeanDefinition(继承BeanDefinition)
	 *
	 * @param basePackage  package(以逗号分隔)
	 * @return
	 */
	public Set<BeanDefinition> findCandidateComponents(String basePackage) {
		Set<BeanDefinition> candidates = new LinkedHashSet<BeanDefinition>();
		try {

			Resource[] resources = this.resourceLoader.getResources(basePackage);

			for (Resource resource : resources) {
				try {

					MetadataReader metadataReader = new SimpleMetadataReader(resource);

					if (metadataReader.getAnnotationMetadata().hasAnnotation(Component.class.getName())) {
						ScannedGenericBeanDefinition sbd = new ScannedGenericBeanDefinition(metadataReader.getAnnotationMetadata());
						String beanName = this.beanNameGenerator.generateBeanName(sbd, this.registry);
						sbd.setId(beanName);
						candidates.add(sbd);
					}
				} catch (Throwable ex) {
					throw new BeanDefinitionStoreException(
							"Failed to read candidate component class: " + resource, ex);
				}

			}
		} catch (IOException ex) {
			throw new BeanDefinitionStoreException("I/O failure during classpath scanning", ex);
		}
		return candidates;
	}

}