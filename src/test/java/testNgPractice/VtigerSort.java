package testNgPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bouncycastle.util.Strings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class VtigerSort {

	@Test
	public void vtigerSort() {
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		
		driver.findElement(By.name("user_password")).sendKeys("admin");
		
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//td[2]//a[text()='Organizations']")).click();
		
		List<WebElement> tabledata = driver.findElements(By.xpath("(//tbody)[46]/tr/td[3]/a[not(contains(text(),'Organization Name'))]"));
		
		int count=0;
		
		for (WebElement webElement : tabledata) {
			String srr = webElement.getText().toString();
			char[] arr = srr.toCharArray();
			Arrays.sort(arr);
			
		//	System.out.println(srr);
			System.out.println(arr);
			count++;
		}
		System.out.println(count);
		
	}
//	(//tbody)[46]/tr/td[3]/a[not(contains(text(),'Organization Name'))]..xpath without header name
}
