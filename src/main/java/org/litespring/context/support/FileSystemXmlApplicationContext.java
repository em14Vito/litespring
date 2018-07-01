package org.litespring.context.support;

import org.litespring.beans.factory.support.DefaultBeanFactory;
import org.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import org.litespring.context.ApplicationContext;
import org.litespring.core.io.ClassPathResource;
import org.litespring.core.io.FileSystemResource;
import org.litespring.core.io.Resource;

/**
 * [Class description. The first sentence should be a meaningful summary of the class since it will
 * be displayed as the class summary on the Javadoc package page.]
 *
 * <p>[Other notes, including guaranteed invariants, usage instructions and/or examples, reminders
 * about desired improvements, etc.]
 *
 * @author Denny
 * @version 1.0.0 21/06/2018 12:00 AM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 */
public class FileSystemXmlApplicationContext extends AbstractApplicationContext {

  public FileSystemXmlApplicationContext(String configFile) {
    super(configFile);
  }

  @Override
  protected Resource getResourceByPath(String path) {

    return new FileSystemResource(path);
  }
}
