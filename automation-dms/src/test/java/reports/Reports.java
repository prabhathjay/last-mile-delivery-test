package reports;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {
	
	public static void main(String[] args) {
		ExtentSparkReporter spark = new ExtentSparkReporter("spark.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(spark);
	}
	

}
