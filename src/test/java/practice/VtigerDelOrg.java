package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class VtigerDelOrg {

	@Test
	public void DelOrg() throws Exception {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("http://localhost:8888/");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		
		driver.findElement(By.name("user_password")).sendKeys("admin");
		
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//td[2]//a[text()='Organizations']")).click();
		
		driver.findElement(By.name("search_text")).sendKeys("Hyundai950");
		
		Select sl=new Select(driver.findElement(By.id("bas_searchfield")));
		
		sl.selectByVisibleText("Organization Name");
		
		driver.findElement(By.name("submit")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.name("selected_id")).click();
		
		driver.findElement(By.xpath("(//input[@value='Delete'])[2]")).click();
		
	}

}
