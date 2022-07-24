package TstNG;

import org.testng.annotations.Test;

public class PracticeTestNG_Methods {
	@Test()
	public void buySimcard() {
		System.out.println("sim card purchased");
		//Assert.assertFalse(true);

	}
	@Test(enabled = true)
	public void customerSupport() {
		System.out.println("Customer Supported");
	}


	@Test
	public void activateSimcard() {
		System.out.println(" Be Activated sim card ");
	}



}
