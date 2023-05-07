package testNgPractice;

import java.util.Arrays;
import java.util.Iterator;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import mavenPac.DeleteTest;

public class Pr {
	/*
	 * //p[contains(text(),'ADULTS (12y +)')]/parent::div/ul/li[(contains(@data-cy,'adults-4'))]
	 * 
	 * //p[text()='Armed Forces ']/parent::li/following-sibling::li/p[contains(text(),'Student ')]
	 */
		//	(//tbody)[46]/tr/td[3]/a[not(contains(text(),'Organization Name'))]

		//	/div[not(@type='class' and @value='s-suggestion-container')]

		//	ChromeDriver driver=new ChromeDriver();
		//	
		//	driver.get("https://www.makemytrip.com/");
		//	
		//	driver.findElement(By.xpath("//ul[@class='makeFlex font12']/*[not(contains(@class,'menu_Activities'))]"));
		
/*		int num=1237567;

		String str = Integer.toString(num);

		int mid = str.length()/2;
		System.out.println(str.charAt(mid));	
		
		throw new SkipException("Exception Message");
		
	static int q;
	int a;
	static{
		Pr pa=new Pr();
	}
	 public static void main(String[] args) { 
		 System.out.println(q);
		 Pr p=new Pr();
		 
		
		 System.out.println(this.a);	 
	} 
	 public void demo(){
		 Pr pq=new Pr();
		 
		System.out.println(this.a);
	}
	*/

	{
		System.out.println("form non");
	}
	static {
		System.out.println("form static");//first static-block get executed before non static block
	}
	
public static void main(String[] args){
/*	try{
	System.out.println("hi sunny");
	
	}catch (Exception e) {
		e= new ClassCastException();
	}
	int a=10;
	int b=0;
	try {
		int ans=a/b;
	}finally {
		System.out.println("finally");
	}
*/
	Pr p=new Pr();
	
}
}
































