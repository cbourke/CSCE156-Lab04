package unl.cse.library;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.Test;

/**
 * This is a suite of tests for the {@link #Author} class.
 * The compiler errors should be addressed once you've completed the lab.  
 * 
 */
public class AuthorTests {

	/**
	 * Tests that {{@link #Author} class has the appropriate constructor and
	 * getters.
	 */
	@Test
	public void authorFixedTest01() {
		Author a = new Author("Liu", "Cixin");
		Assertions.assertEquals("Liu", a.getFirstName());
		Assertions.assertEquals("Cixin", a.getLastName());
	}

}
