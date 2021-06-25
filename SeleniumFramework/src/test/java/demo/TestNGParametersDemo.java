package demo;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParametersDemo {
	/*
	 * i)Parameters used to pass values to arguments which helps in data driven
	 * testing. ii)Single parameter can be resides within (). However, for more than
	 * one parameter use {}.exp: ({"name1","name2"})
	 */
	@Parameters({ "MyName", "MyName1" })
	@Test
	public void test(String name1, String name2) {
		System.out.println("name is: " + name1);
		System.out.println("name is: " + name2);
	}

}
