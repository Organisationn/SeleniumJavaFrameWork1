package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import test.TestNGDemo;

public class PropertiesFile {
	static Properties confProps = new Properties();
	static String projectPath = System.getProperty("user.dir");

	public static void main(String[] args) throws FileNotFoundException {
		getProperties();
		setProperties();
		getProperties();
	}

	public static void getProperties() {

		try {
			InputStream input = new FileInputStream(projectPath + "/src/test/java/config/config.properties");
			confProps.load(input);
			String browser = confProps.getProperty("browser");
			System.out.println(browser);
			TestNGDemo.browserName = browser;

		} catch (Exception exp) {
			System.out.println("Inside catch block");
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
	}

	public static void setProperties() {
		try {
			OutputStream output = new FileOutputStream(projectPath + "/src/test/java/config/config.properties");
//			confProps.setProperty("browser", "chrome");
			confProps.setProperty("result", "pass");
			confProps.store(output, null);
		} catch (Exception exp) {
			System.out.println("Inside catch block");
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
	}
}
