package practice;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonPriceCompare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Redmi 10 Power (Power Black, 8GB RAM, 128GB Storage)",Keys.ENTER);
		
		driver.findElement(By.xpath("//span[text()='Redmi 10 Power (Power Black, 8GB RAM, 128GB Storage)']")).click();
		
		Set<String> ids = driver.getWindowHandles();
		System.out.println(ids);
		
		
	//	driver.switchTo().window(null)
	}

}
