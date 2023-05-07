package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

	WebDriver driver;
	static WebDriver sdriver;
	
	@BeforeSuite
	public void launch() {
		
		driver=new ChromeDriver();
		sdriver=driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		
	}	
	@AfterSuite
	public void close() {
	//	driver.close();
	}
	public static String takeScreenShots(String methodname) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)sdriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"./screenShots/vtigerhome.png";
		File dest=new File(path);
		FileUtils.copyFile(src, dest);
		
		return path;
		//return dest.getAbsolutePath();
		
	}	
}
