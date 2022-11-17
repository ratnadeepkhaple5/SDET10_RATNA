package practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonPriceCompare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.amazon.in/");
		
		String parentId = driver.getWindowHandle();
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Redmi 10 Power (Power Black, 8GB RAM, 128GB Storage)",Keys.ENTER);
		driver.findElement(By.xpath("//span[text()='Redmi 10 Power (Power Black, 8GB RAM, 128GB Storage)']")).click();
		
		String price = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[5]")).getText();
		
		System.out.println("AMAZON price: "+price);
		
	}

}
