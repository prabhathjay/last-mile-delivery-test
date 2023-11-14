package defaults;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.ReadProperties;

public class LoginApplication {
	static ReadProperties config = new ReadProperties("config");
	static HashMap<String, String> props = config.getPropertyAsHashMap();
	
	//need to declare username and password properties in config.properties file
	static String username = props.get("username");
	static String password = props.get("password");
	
	@BeforeTest
	public static void main(String[] args) {
		testLogin();
	}
	
	@Test
	public static void testLogin() {
		BrowserTest.navigateDomain();
		BrowserTest.driver.findElement(By.name("login")).sendKeys(username);
		BrowserTest.driver.findElement(By.name("password")).sendKeys(password);
		BrowserTest.driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}
	
	@AfterTest
	public void tearDown() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		BrowserTest.driver.close(); 
		BrowserTest.driver.quit(); 
	}

}
