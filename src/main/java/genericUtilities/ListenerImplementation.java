package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.SkipException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener {

	ExtentReports reports;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		test=reports.createTest(result.getMethod().getMethodName()+" got started:-");
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName()+" got passed");
	}
	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getMethod().getMethodName()+" got failed");
		test.log(Status.FAIL, result.getThrowable());
		String path=null;
		try {
			path = BaseClass.takeScreenShots(result.getMethod().getMethodName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(path);
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		//to skip the test cases	

		/**throw new SkipException("got skipped");**/ //in script we have to do it	
	}
	@Override
	public void onStart(ITestContext context) {

		ExtentSparkReporter reporter=new 
				ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/SDET10.html");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setDocumentTitle("vtiger");

		reports=new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("platform", "Windows10");
		reports.setSystemInfo("brower", "chrome");
		reports.setSystemInfo("ReporteName","Ratan");	
	}
	@Override
	public void onFinish(ITestContext context) {
		reports.flush();
	}
}
