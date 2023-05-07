package genericUtilities;

import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation_1 implements ITestListener {

	ExtentReports reports;
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		test=reports.createTest(result.getMethod().getMethodName()+" test started");
		
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName()+" test success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getMethod().getMethodName()+" test failed");
		test.log(Status.FAIL, result.getThrowable());
		
		String path=null;
		
		try {
			path=BaseClass.takeScreenShots(result.getMethod().getMethodName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(path);
	}

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter reporter=new 
		ExtentSparkReporter(System.getProperty("user.dir")+"./Reports/r1_new.html");
	reporter.config().setTheme(Theme.DARK);
	reporter.config().setDocumentTitle("Ratan_reports");
	
	reports=new ExtentReports();
	
	reports.attachReporter(reporter);
	
	reports.setSystemInfo("platform", "windows 10");
	reports.setSystemInfo("reporter", "ratanKumar");
	reports.setSystemInfo("browser", "chrome");
	}

	@Override
	public void onFinish(ITestContext context) {
		reports.flush();
	}	
}
