package org.litespring.core.io;

import org.litespring.util.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * [Class description. The first sentence should be a meaningful summary of the class since it will
 * be displayed as the class summary on the Javadoc package page.]
 *
 * <p>[Other notes, including guaranteed invariants, usage instructions and/or examples, reminders
 * about desired improvements, etc.]
 *
 * @author Denny
 * @version 1.0.0 19/06/2018 11:13 PM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 */
public class ClassPathResource implements Resource {

  private String path;
  private ClassLoader classLoader;

  public ClassPathResource(String path) {
    this(path, (ClassLoader) null);
  }

  public ClassPathResource(String path, ClassLoader classLoader) {
    this.path = path;
    this.classLoader = (classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader());
  }

  public InputStream getInputStream() throws IOException {
    InputStream is = this.classLoader.getResourceAsStream(this.path);

    if (is == null) {
      throw new FileNotFoundException(path + " cannot be opened");
    }
    return is;
  }

  public String getDescription() {
    return this.path;
  }
}
