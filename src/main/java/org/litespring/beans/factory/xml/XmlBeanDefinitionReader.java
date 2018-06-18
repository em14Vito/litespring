package org.litespring.beans.factory.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.litespring.bean.BeanDefinition;
import org.litespring.beans.factory.BeanDefinitionStoreException;
import org.litespring.beans.factory.support.BeanDefinitionRegistry;
import org.litespring.beans.factory.support.GenericBeanDefinition;
import org.litespring.util.ClassUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

/**
 *
 * @author Denny
 * @version 1.0.0 18/06/2018 11:51 PM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 **/

public class XmlBeanDefinitionReader {
	public static final String ID_ATTRIBUTE = "id";

	public static final String CLASS_ATTRIBUTE = "class";

	BeanDefinitionRegistry registry;

	public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
		this.registry = registry;
	}
	public void loadBeanDefinition(String configFile){
		InputStream iStream = null;
		try {
			ClassLoader loader = ClassUtils.getDefaultClassLoader();
			iStream = loader.getResourceAsStream(configFile);
			SAXReader reader = new SAXReader();
			Document doc = reader.read(iStream);

			Element root = doc.getRootElement();
			Iterator<Element> iter = root.elementIterator();
			while (iter.hasNext()) {
				Element ele = iter.next();
				String id = ele.attributeValue(ID_ATTRIBUTE);
				String beanName = ele.attributeValue(CLASS_ATTRIBUTE);
				BeanDefinition bd = new GenericBeanDefinition(id, beanName);
				this.registry.registerBeanDefinition(id, bd);
			}
		} catch (DocumentException e) {
			throw new BeanDefinitionStoreException("IOException parsing XML document");
		} finally {
			if (iStream != null) {
				try {
					iStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
