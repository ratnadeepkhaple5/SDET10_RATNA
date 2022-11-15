package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = null;
		driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.flipkart.com/");

		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		
		driver.findElement(By.xpath("//a[.='Cart']")).click();
		
		String text = driver.findElement(By.xpath("//div[.='Missing Cart items?']")).getText();
		
		if (driver.getPageSource().contains(text)) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
		
	}

}
