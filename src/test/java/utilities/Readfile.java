package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Readfile {
// Read the property file
	/**
	 * Read properties from a file located at the specified link.
	 * @param Link The relative path of the properties file.
	 * @return A Properties object containing the properties read from the file.
	 * @throws IOException If an I/O error occurs while reading the file.
	 */
	public Properties ReadFile(String Link) throws IOException {
	    // Create a new Properties object to store the properties read from the file
		Properties p = new Properties ();
	    // Create a FileReader to read the properties file
		FileReader fr = new FileReader(System.getProperty("user.dir")+Link);
	    // Load the properties from  file to the Properties object
		p.load(fr);
		return p;
	}

}
