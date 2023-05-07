package extendReportsPractice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
@Listeners(genericUtilities.ListenerImplementation.class)
public class ExReport1 extends BaseClass {

	@Test
	public void createReport() {
		
	System.out.println("reports created only");
	Assert.assertEquals(true, true);
	}
	@Test
	public void createReportWithEmail() {
		
	System.out.println("reports created & email sent");
	Assert.assertEquals(false, true);
	}
	@Test
	public void createdReportSentToGitHub() {
		
	System.out.println("reports created & sent to gitHub");
	Assert.assertEquals(true, true);
	}
}
