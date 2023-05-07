package practice;

import java.awt.Window;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmaFlkPriceCompare {

	public static void main(String[] args) {
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		
		driver.get("https://www.amazon.in/");
		//String parentId = driver.getWindowHandle();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Redmi 10 Power (Power Black, 8GB RAM, 128GB Storage)",Keys.ENTER);
		driver.findElement(By.xpath("//span[text()='Redmi 10 Power (Power Black, 8GB RAM, 128GB Storage)']")).click();
		String amzPrice = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[5]")).getText();
		
//		System.out.println("AMAZON price: "+amzPrice);
//		
//	 	Set<String> allids = driver.getWindowHandles();
//		allids.remove(parentId);
//
//		for (String string : allids) {
//			driver.switchTo().window(string);
//		//	driver.close();
//		}
//	 	Thread.sleep(4000);
//			JavascriptExecutor jse=(JavascriptExecutor) driver;
//			jse.executeScript("window.scrollBy(0,100)");
//			Thread.sleep(2000);
//	try {	
//		driver.findElement(By.id("add-to-cart-button")).click();
//		driver.findElement(By.xpath("//span[@id='submit.add-to-cart']")).click();	
//		Thread.sleep(5000);
//		String amzPrice = driver.findElement(By.id("attach-accessory-cart-subtotal")).getText();
//
//		System.out.println("AMAZON price: "+amzPrice);
//		//String amzprice="14,990";
//		int Amzactprice =AmzParsingPrice (amzPrice);
//		//System.out.println(Amzactprice);
//	}catch (StringIndexOutOfBoundsException e) {
//		e.printStackTrace();
//	}	
//	 
		 
		//String amzprice="14,990";
		int Amzactprice =AmzParsingPrice (amzPrice);
		
	//	int Amzactprice=16999;
		System.out.println("AMAZON price: "+Amzactprice);
		
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		driver.get("https://www.flipkart.com/");	
		driver.findElement(By.xpath("//*[@class='_2KpZ6l _2doB4z']")).click();
		String parentwindowId = driver.getWindowHandle();
		driver.findElement(By.name("q")).sendKeys("Redmi 10 Power (Power Black, 8GB RAM, 128GB Storage",Keys.ENTER);
		driver.findElement(By.xpath("//*[text()='REDMI 10 Power (Power Black, 128 GB)']")).click();
		Set<String> ids = driver.getWindowHandles();
		ids.remove(parentwindowId);
		for (String string : ids) {
			driver.switchTo().window(string);
		//	driver.close();
		}
		String flipPrice = driver.findElement(By.xpath("//div[@class='_30jeq3 _16Jk6d']")).getText();
		//String flipPrice="₹13,990";
		
	//	System.out.println("flipkart Price: "+flipPrice);
		
		int flipactprice = flipparsingPrice(flipPrice);
	
	//	int flipactprice=13980;
		System.out.println("flipkart Price: "+flipactprice);
		
		if (Amzactprice>flipactprice) {
			System.out.println("lowest price on flipkart: "+flipactprice);
		} else if(flipactprice>Amzactprice) {
			System.out.println("lowest price on amazon: "+Amzactprice);
		}else if(flipactprice==Amzactprice) {
			System.out.println("prices are equal");
		}else {
			System.out.println("dyanmic price changes..can't compared");
		}
	}	
	
	public static int flipparsingPrice(String flipPrice) {
		
		String fp1 = flipPrice.substring(1, 3);
		String fp2= flipPrice.substring(4, 7);
		//System.out.println(fp1+fp2);
		
		 int flipPriceInt = Integer.parseInt((fp1+fp2));
		// System.out.println(flipPriceInt);
		 
		 return flipPriceInt;
	
	}
	public static int AmzParsingPrice(String amzprice) {
		
		String p1=amzprice.substring(0, 2);
		String p2=amzprice.substring(3, 6);
		//System.out.println(p1+p2);
		
		int actprice=Integer.parseInt((p1+p2));
	//	System.out.println(actprice);
		
		return actprice;
	}
}	
