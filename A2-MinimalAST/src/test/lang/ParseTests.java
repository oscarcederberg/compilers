package lang;

import java.io.File;

import org.junit.Test;

public class ParseTests {
	/** Directory where the test input files are stored. */
	private static final File TEST_DIRECTORY = new File("testfiles/parser");

	//Test 1
	@Test public void test1() {
		Util.testValidSyntax(TEST_DIRECTORY, "step1.in");
	}

	//Test 2
	@Test public void test2() {
		Util.testValidSyntax(TEST_DIRECTORY, "step2.in");
	}

	//Test 3
	@Test public void test3_mult() {
		Util.testValidSyntax(TEST_DIRECTORY, "step3/mult.in");
	}
	@Test public void test3_plus() {
		Util.testValidSyntax(TEST_DIRECTORY, "step3/plus.in");
	}
	@Test public void test3_complex() {
		Util.testValidSyntax(TEST_DIRECTORY, "step3/complex.in");
	}
	@Test public void test3_mod() {
		Util.testValidSyntax(TEST_DIRECTORY, "step3/mod.in");
	}
	@Test public void test3_boolean_ops() {
		Util.testValidSyntax(TEST_DIRECTORY, "step3/boolean_ops.in");
	}
	@Test public void test3_minus() {
		Util.testValidSyntax(TEST_DIRECTORY, "step3/minus.in");
	}
	@Test public void test3_div() {
		Util.testValidSyntax(TEST_DIRECTORY, "step3/div.in");
	}


	@Test public void test4_sample1() {
		Util.testValidSyntax(TEST_DIRECTORY, "step4_sample1.in");
	}
	@Test public void test4_sample2() {
		Util.testValidSyntax(TEST_DIRECTORY, "step4_sample2.in");
	}
	@Test public void test4_sample3() {
		Util.testValidSyntax(TEST_DIRECTORY, "step4_sample3.in");
	}
	
	@Test public void test4_ifelse() {
		Util.testValidSyntax(TEST_DIRECTORY, "step4_ifelse.in");
	}
	@Test public void test4_params() {
		Util.testValidSyntax(TEST_DIRECTORY, "step4_params.in");
	}
	@Test public void test4_return() {
		Util.testValidSyntax(TEST_DIRECTORY, "step4_return.in");
	}
	@Test public void test4_while() {
		Util.testValidSyntax(TEST_DIRECTORY, "step4_while.in");
	}
	@Test public void test4_call() {
		Util.testValidSyntax(TEST_DIRECTORY, "step4_call.in");
	}
	@Test public void test4_function_use() {
		Util.testValidSyntax(TEST_DIRECTORY, "step4_function_use.in");
	}
	@Test public void test4_iddeclassign() {
		Util.testValidSyntax(TEST_DIRECTORY, "step4_iddeclassign.in");
	}
	@Test public void test0_empty() {
		Util.testValidSyntax(TEST_DIRECTORY, "step0_empty.in");
	}

	/*
	@Test public void test4_xx() {
		Util.testValidSyntax(TEST_DIRECTORY, "step4_xx.in");
	}
	*/
}
