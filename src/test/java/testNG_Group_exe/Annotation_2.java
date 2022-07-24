package testNG_Group_exe;

import org.testng.annotations.Test;

public class Annotation_2 extends Annotation {
	@Test(groups = "smoke")
	public void test3() {
		System.out.println("testcase3 passed");
	}
	@Test(groups = "regression")
	public void test4() {
		System.out.println("testcase4 passed");
	}
}
