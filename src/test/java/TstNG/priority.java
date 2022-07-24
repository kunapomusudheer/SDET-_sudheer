package TstNG;

import org.testng.annotations.Test;

public class priority {
	public class PracticeTestNG_Methods {
		@Test(priority = 1)
		public void buySimcard() {
			System.out.println("sim card purchased");
			//Assert.assertFalse(true);

		}
		@Test(priority = 3)
		public void customerSupport() {
			System.out.println("Customer Supported");
		}


		@Test(priority = 2)
		public void activateSimcard() {
			System.out.println(" Be Activated sim card ");
		}



	}

}
