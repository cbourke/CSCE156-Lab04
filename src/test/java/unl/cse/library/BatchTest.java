package unl.cse.library;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

/**
 * This is a batch test file used by grading  
 * scripts to generate a full roster grade report.
 * 
 * @author cbourke
 *
 */
public class BatchTest {

	public static void main(String[] args) {

		int labPoints = 20;
		JUnitCore jUnitCore = new JUnitCore();
		Result r = jUnitCore.run(AuthorTests.class, BookTests.class);

		// prints total number of points, number of pass/fail 
		// and total tests in csv format
		System.out.printf("%d,%d,%d,%d", 
				r.getFailureCount() == 0 ? labPoints : 0,
				r.getRunCount() - r.getFailureCount(), 
				r.getFailureCount(), 
				r.getRunCount());
	}

}
