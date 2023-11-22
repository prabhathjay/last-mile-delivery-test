package reports;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import defaults.LoginApplication;

public class Reports {
	
	public static void main(String[] args) {
		ExtentSparkReporter spark = new ExtentSparkReporter("spark.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(spark);
		ExtentTest lmdTest1 = extent.createTest("LMD_Test1");
		
		LoginApplication.testLogin();
		lmdTest1.log(Status.PASS, "Test Passed!");
		extent.flush();
	}
	

}
