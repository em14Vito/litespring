package org.litespring.core.io;

import org.litespring.util.Assert;

import java.io.File;
import java.io.FileInputStream;
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
 * @version 1.0.0 19/06/2018 11:16 PM
 * @see [String]
 * @see {URL}
 * @see [Class name#method name]
 */
public class FileSystemResource implements Resource {

	private final String path;
	private final File file;

	public FileSystemResource(File file) {
		this.path = file.getPath();
		this.file = file;
	}

	public FileSystemResource(String path) {
		Assert.notNull(path, "Path must not be null");
		this.file = new File(path);
		this.path = path;
	}

	public InputStream getInputStream() throws IOException {
		return new FileInputStream(this.file);
	}

	public String getDescription() {
		return "file [" + this.file.getAbsolutePath() + "]";
	}
}
