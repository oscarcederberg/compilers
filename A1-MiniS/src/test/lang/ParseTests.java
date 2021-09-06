package lang;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import static org.junit.Assert.fail;

public class ParseTests {
	/** Directory where the test input files are stored. */
	private static final File TEST_DIRECTORY = new File("testfiles");

	@Test public void testAll() {
		Util.testValidSyntax(TEST_DIRECTORY, "all.in");
	}
	@Test public void testShortest() {
		Util.testValidSyntax(TEST_DIRECTORY, "shortest.in");
	}
	@Test public void scannerError() {
		Util.testSyntaxError(TEST_DIRECTORY, "scanningerror.in");
	}
	@Test public void parserError() {
		Util.testSyntaxError(TEST_DIRECTORY, "parsingerror.in");
	}

	@Test public void testFun() {
		Util.testSyntaxError(TEST_DIRECTORY, "testfun.in");
	}
}
