package testNG_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertion {
	@Test
	public void login() {
		System.out.println("launch browser");
		System.out.println("enter url");
		String actualTitle="get Title";
		String expectedTitle="get Ttle";
		Assert.assertEquals(actualTitle, expectedTitle);

		SoftAssert asse=new SoftAssert();
		asse.assertEquals(false,true);

		System.out.println("login page mbd");
		System.out.println("enter un");
		System.out.println("enter pwd");
		System.out.println("click on login btn");
		System.out.println("home page mbd");
		//		String actualTitle="get Title";
		//		String expectedTitle="get Ttle";
		//		
		//		asse.assertAll();
		//		Assert.assertEquals(actualTitle, expectedTitle);

	}

}
