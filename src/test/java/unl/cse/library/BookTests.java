package unl.cse.library;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.Test;

/**
 * This is a suite of tests for the {@link #Book} class.
 * The compiler errors should be addressed once you've completed the lab.  
 * 
 */
public class BookTests {

	/**
	 * Tests that {@link #Book} class has the appropriate constructor and getters.
	 */
	@Test
	public void bookFixedTest01() {
		Book b = new Book("Three Body Problem", null, "978-7-5366-9293-0", "2008-01-01");
		Assertions.assertEquals("Three Body Problem", b.getTitle());
		Assertions.assertEquals("978-7-5366-9293-0", b.getISBN());
	}

	/**
	 * Tests that {{@link #Book} class has a <code>getAge()</code> method and that
	 * it computes the age of a book correctly.
	 */
	@Test
	public void bookFixedTest02() {
		LocalDate d = LocalDate.parse("2008-01-01");
		int years = Period.between(d, LocalDate.now()).getYears();
		Book b = new Book("Foo", null, "Bar", "2008-01-01");
		Assertions.assertEquals(years, b.getAge());
	}

}
