package lang;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import lang.ast.*;

/**
 * This is a parameterized test: one test case is generated for each input
 * file found in TEST_DIRECTORY. Input files should have the ".in" extension.
 */
@RunWith(Parameterized.class)
public class TestCallGraph {
	/** Directory where the test input files are stored. */
	private static final File TEST_DIRECTORY = new File("testfiles/callgraph");

	private final String filename;
	public TestCallGraph(String testFile) {
		filename = testFile;
	}

	@Test public void runTest() throws Exception {
		Program program = (Program) Util.parse(new File(TEST_DIRECTORY, filename));
		StringBuilder sb = new StringBuilder();
        
		FunctionDecl main = null;
		for(FunctionDecl func : program.getFunctionDecls()) {
			if(func.getIdDecl().getID().equals("main")){
				main = func;
			}
		}
		
		for (FunctionDecl f : main.reachable()) {
			sb.append(f.getIdDecl().getID()).append("\n");
		}

		String actual = sb.toString();
		Util.compareOutput(actual,
				new File(TEST_DIRECTORY, Util.changeExtension(filename, ".out")),
				new File(TEST_DIRECTORY, Util.changeExtension(filename, ".expected")));
	}

	@Parameters(name = "{0}")
	public static Iterable<Object[]> getTests() {
		return Util.getTestParameters(TEST_DIRECTORY, ".in");
	}
}
