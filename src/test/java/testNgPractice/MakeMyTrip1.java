package testNgPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip1 {

	@Test(dataProvider = "cityData")
	public void bookFlightMakeMyTrip(String[] city) throws Exception 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
	//	driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.makemytrip.com/");
		
		Thread.sleep(1000);
		
		Actions ac=new Actions(driver);
		ac.moveByOffset(10, 10).click().perform();
		
	//	driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@id='fromCity']")).sendKeys(city[0]);
		driver.findElement(By.xpath("//p[text()='"+city[0]+", India']")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@id='toCity']")).sendKeys(city[1]);
		driver.findElement(By.xpath("//p[text()='"+city[1]+", India']")).click();
		
		driver.findElement(By.xpath("//*[.='DEPARTURE']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@aria-label='"+city[2]+"']")).click();
	}
	
	@DataProvider
	public String[][] cityData(){
		
		String[][] data=new String[][] {
			{"Mumbai","Chennai","Thu Dec 08 2022"}
		};
		return data;
	}
	
	
}
