package testNgPractice;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip2 {
	
	@Test(dataProvider = "data")
	public void myTrip(String[] city) throws Exception {
		
Date date=new Date();
		
		String dstr = date.toString();
		//	System.out.println(dstr);
		// Mon Nov 14 09:40:58 IST 2022
		//	0   1   2    3      4    5

		// Mon Jan 02 2023
			
			String[] str = dstr.split(" ");
			String day = str[0];
			String mon = str[1];
			String dat = str[2];
			String year = str[5];
			
			String travelDate = day+" "+mon+" "+dat+" "+year;
			System.out.println(travelDate);
				
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
		//	driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
		driver.get("https://www.makemytrip.com/");
	//from	
		driver.findElement(By.xpath("(//input[@type='text'])[1]")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(city[0]);
		driver.findElement(By.xpath("//p[text()='"+city[0]+", India']")).click();
		
		Thread.sleep(2000);
	//to	
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(city[1]);
		driver.findElement(By.xpath("//p[text()='"+city[1]+", India']")).click();
		Thread.sleep(2000);
	//date
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[.='DEPARTURE']")).click();
	//	driver.findElement(By.xpath("//*[@aria-label='"+travelDate+"']")).click();
		
		
		for(;;) {
			try {
			driver.findElement(By.xpath("//div[@aria-label='Thu Mar 02 2023']")).click();
			break;
			} catch (Exception e) {
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();	
			}
		}
	}

	@DataProvider
	public String[][] data() {
		
		String[][] data=new String[][] {
			{"Mumbai","Hyderabad"}
		};
		return data;
	}
}
