package testNgPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import dataProvider.SpijejetDp1;

public class Spicejet1 extends SpijejetDp1{

	@Test(dataProvider = "dpSpicejet",dataProviderClass = SpijejetDp1.class)
	public void bookFlight(String[] location) throws Exception {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.spicejet.com/");
		
		driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep'])[1]")).click();
		driver.findElement(By.xpath("(//input[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu'])[1]")).sendKeys(location[0]);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep'])[2]")).click();
		driver.findElement(By.xpath("(//input[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu'])[2]")).clear();
		driver.findElement(By.xpath("(//input[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu'])[2]")).sendKeys(location[1]);
	}

}
