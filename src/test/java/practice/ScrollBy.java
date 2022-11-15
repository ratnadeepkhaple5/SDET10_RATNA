package practice;

import java.net.SocketException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollBy {

	public static void main(String[] args) throws SocketException,Exception {
		// TODO Auto-generated method stub
		
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

			driver.get("https://www.naukri.com/");

			JavascriptExecutor jse=(JavascriptExecutor) driver;

			jse.executeScript("window.scrollBy(0,1000)");
			Thread.sleep(5000);

			driver.close();

		
		
	}

}
