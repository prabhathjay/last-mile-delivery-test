package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;


//import defaults.BrowserTest;
//import defaults.LoginApplication;

public class ReadProperties {
	static Properties prop = null;
	static String projectPath = System.getProperty("user.dir");
	static String propertyName = null;
	
	//This is constructor to pass properties file name during object creation
	@SuppressWarnings("static-access")
	public ReadProperties(String propertyName) {
		this.propertyName = propertyName;
	}

	//This is method to load property file
	public static void loadProperty() {
		prop = new Properties();
		try {
			InputStream input = new FileInputStream("C:/Users/Dell/eclipse-workspace/automation-dms/src/test/java/Config/"+propertyName+".properties");
			try {
				prop.load(input);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			//commenting out individual property mapping
			
//			String username = prop.getProperty("username");
//			String password = prop.getProperty("password");
//			String browser = prop.getProperty("browser");
//			String loginUrl = prop.getProperty("loginUrl");
//			BrowserTest.browserName = browser;
//			BrowserTest.loginUrl = loginUrl;
//			LoginApplication.username = username;
//			LoginApplication.password = password;
			
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}
	
	//public method created to access outside class. This method load property file and store data in HashMap
	public HashMap<String, String> getPropertyAsHashMap() {
		loadProperty();
		HashMap<String, String> map = new HashMap<String, String>();
		
		for(Entry<Object, Object> entry : prop.entrySet()) {
			map.put((String) entry.getKey(), (String) entry.getValue());
		}
		return map;
	}
	
	
}
