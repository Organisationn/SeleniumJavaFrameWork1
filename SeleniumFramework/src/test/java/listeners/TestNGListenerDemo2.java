package listeners;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/*i)If you want the listeners to be used by all methods then declare it at class level 
 * ii)if you have more than one class where you have defined the listeners then mention all using comma separated value
 *  inside @Listeners annotation*/

//@Listeners(listeners.TestNGListeners.class)
public class TestNGListenerDemo2 {

	@Test
	public void test4() {
		System.out.println("I am inside test4");
	}

	@Test
	public void test5() {
		System.out.println("I am inside test5");
	}

	@Test
	public void test6() {
		System.out.println("I am inside test6");
		throw new SkipException("This test is skipped");
	}

}
