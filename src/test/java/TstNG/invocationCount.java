package TstNG;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class invocationCount {
	public class PracticeTestNG_Methods {
		@Test(enabled = true)
		public void buySimcard() {
			System.out.println("sim card purchased");
			
		}
		@Test(invocationCount = 1)
		public void customerSupport() {
			System.out.println("Customer Supported");
		}


		@Test
		public void activateSimcard() {
			System.out.println(" Be Activated sim card ");
			throw new SkipException("skipp");
		}



	}

}
