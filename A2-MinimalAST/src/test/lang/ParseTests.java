package lang;

import java.io.File;

import org.junit.Test;

public class ParseTests {
	/** Directory where the test input files are stored. */
	private static final File TEST_DIRECTORY = new File("testfiles/parser");

	@Test public void test1() {
		Util.testValidSyntax(TEST_DIRECTORY, "step1.in");
	}
	@Test public void test2() {
		Util.testValidSyntax(TEST_DIRECTORY, "step2.in");
	}
}
