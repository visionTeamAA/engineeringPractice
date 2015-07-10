package vn.axon.vision.test.helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
	private static Configuration config;
	
	private Properties properties;
	
	private Configuration() {
		ClassLoader classLoader = this.getClass().getClassLoader();
		String configPath = classLoader.getResource("resources/config.properties").getFile();
		
		properties = new Properties();
		try {
			properties.load(new FileInputStream(configPath));
		} catch (FileNotFoundException ev) {
			ev.printStackTrace();
		} catch (IOException ev) {
			ev.printStackTrace();
		}
	}
	
	public static Configuration getInstance() {
		if (config == null) {
			config = new Configuration();
		}
		return config;
	}
	
	public String get(String propName) {
		return properties.getProperty(propName);
	}
}
