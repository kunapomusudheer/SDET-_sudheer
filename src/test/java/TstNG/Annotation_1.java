package TstNG;

import org.testng.annotations.Test;

public class Annotation_1 extends Annotation {
	@Test
	public void test1() {
		System.out.println("testcase1 passed");
	}
	@Test
	public void test2() {
		System.out.println("testcase2 passed");
	}
}
