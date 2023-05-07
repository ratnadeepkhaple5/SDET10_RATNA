package extendReportsPractice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;

@Listeners(genericUtilities.ListenerImplementation_1.class)
public class ER_driver extends BaseClass{

	@Test
	public void create() {
		System.out.println("task created");
		Assert.assertEquals(true, true);
	}
	@Test
	public void modify() {
		System.out.println("task modified");
		Assert.assertEquals(true, true);
	}
	@Test
	public void remove() {
		System.out.println("task removed");
		Assert.assertEquals(true, true);
	}
}
