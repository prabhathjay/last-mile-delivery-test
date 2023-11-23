package utils;

import java.util.HashMap;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import config.ReadProperties;
import defaults.BrowserTest;

public class ReadExcelData {
	static ReadProperties config = new ReadProperties("config2");
	static HashMap<String, String> props = config.getPropertyAsHashMap();
	static String username = props.get("username");
	static String password = props.get("password");
	static String returnRequests = props.get("returnRequests");
	String afhi = "/excel-files/old-rtn-requests.xlsx";
	
	@Test(dataProvider = "testdata")
	public static void test1(String tr) {
		BrowserTest.navigateDomain();
		BrowserTest.driver.findElement(By.name("login")).sendKeys(username);
		BrowserTest.driver.findElement(By.name("password")).sendKeys(password);
		BrowserTest.driver.findElement(By.xpath("//button[@type='submit']")).click();
		try {
			Thread.sleep(2000);
			BrowserTest.driver.get(returnRequests);
			BrowserTest.driver.findElement(By.xpath("//div[@id='pending_datatable_filter']/label/input")).sendKeys(tr);
			Thread.sleep(2000);

			BrowserTest.driver.findElement(By.xpath("//button[contains(.,'Review')]")).click();
			Thread.sleep(1000);
			BrowserTest.driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[3]/form[1]/div[1]/div[1]/div[3]/button[3]")).click();
			Thread.sleep(1000);
			
			//To handle alert message
			Alert confirmAlert = BrowserTest.driver.switchTo().alert();
			confirmAlert.dismiss();
			BrowserTest.driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[3]/form[1]/div[1]/div[1]/div[3]/button[1]")).click();
			Thread.sleep(1000);
			BrowserTest.driver.close();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
	@DataProvider(name="testdata")
	public static Object[][] getData() {
		String excelPath = "/excel-files/old-rtn-requests.xlsx";
		Object data[][] = testData(excelPath);
		return data;
	}
	
	public static Object[][] testData(String excelPath) {
		ExcelUtils excel = new ExcelUtils(excelPath);
		int rowCount = excel.getRowCount();
		
		Object data[][] = new Object[rowCount-1][1];
		
		for(int i=1; i<rowCount;i++) {
			String cellData = excel.getCellData(i, 0);
			data[i-1][0] =cellData;
//			System.out.println(cellData);
		}
		return data;
	}

}
