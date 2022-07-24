package testNG_Group_exe;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
public class Annotation_1 extends Annotation {
	@Test(groups = {"smoke","regression"})
	public void test1() {
		System.out.println("testcase1 passed");
	}
	@Test(groups = "regression")
	public void test2() {
		System.out.println("testcase2 passed");
	}
}
