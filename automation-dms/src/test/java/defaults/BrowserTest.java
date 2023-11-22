package defaults;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import config.ReadProperties;

public class BrowserTest {
	public static WebDriver driver = null;
	static String browserName = null;
	static String trackingHistory = null;

	public static void main(String[] args) {
		navigateDomain();
	}

	public static void navigateDomain() {
		ReadProperties rp = new ReadProperties("config2");
		HashMap<String, String> hs = rp.getPropertyAsHashMap();
		browserName = hs.get("browser");
		trackingHistory = hs.get("trackingHistory");

		if(browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			driver = new  ChromeDriver(options);
		}else
			if(browserName.equalsIgnoreCase("firefox")){
				driver = new FirefoxDriver();
			}else
				if(browserName.equalsIgnoreCase("ie")) {
					driver = new InternetExplorerDriver();
				}

		driver.get(trackingHistory);
//		System.out.println("Navigated to DMS login page..");
//		--------------------------------------------------
//		try {
//			Thread.sleep(2000);
//			System.out.println("Waiting for 2sec before browser exit..");
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//			e.getMessage();
//			e.getCause();
//		}

//		driver.close();
//		System.out.println("Test completed!");
	}


}
