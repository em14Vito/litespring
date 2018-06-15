package org.litespring.bean.factory.support;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.litespring.bean.factory.BeanCreateException;
import org.litespring.bean.factory.BeanDefinitionStoreException;
import org.litespring.bean.factory.BeanFactory;
import org.litespring.beans.BeanDefinition;
import org.litespring.util.ClassUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * [Class description. The first sentence should be a meaningful summary of the class since it will
 * be displayed as the class summary on the Javadoc package page.]
 *
 * <p>[Other notes, including guaranteed invariants, usage instructions and/or examples, reminders
 * about desired improvements, etc.]
 *
 * @author Denny
 * @version 1.0.0 14/06/2018 12:22 AM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 */
public class DefaultBeanFactory implements BeanFactory {
  public static final String ID_ATTRIBUTE = "id";

  public static final String CLASS_ATTRIBUTE = "class";

  private final Map<String, BeanDefinition> beanDefinitonMap =
      new ConcurrentHashMap<String, BeanDefinition>();

  public DefaultBeanFactory(String configFile) {
    loadBeanDefinition(configFile);
  }

  private void loadBeanDefinition(String configFile) {
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
        this.beanDefinitonMap.put(id, bd);
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

  @Override
  public BeanDefinition getBeanDefinition(String beanId) {
    return beanDefinitonMap.get(beanId);
  }

  @Override
  public Object getBean(String beanId) {
    BeanDefinition bd = this.getBeanDefinition(beanId);
    if (bd == null) {
      throw new BeanCreateException("Bean Definition does not exist");
    }

    ClassLoader cl = ClassUtils.getDefaultClassLoader();
    String beanClassName = bd.getBeanClassName();
    try{
    	Class<?> clz = cl.loadClass(beanClassName);
		return clz.newInstance();
    } catch (Exception e) {
		throw new BeanCreateException("create bean for " + beanClassName + " fail", e);
    }
  }
}
