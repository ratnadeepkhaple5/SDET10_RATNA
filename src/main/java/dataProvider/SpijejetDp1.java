package dataProvider;

import org.testng.annotations.DataProvider;

public class SpijejetDp1 {

	@DataProvider(name = "dpSpicejet")
	public String[][] dpSpicejet() {
		String[][] data=new String[][] {
			{"BOM","HYD"}
		} ;
		return data;
	}
}
